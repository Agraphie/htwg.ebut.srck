package de.htwg_konstanz.ebus.wholesaler.main;

import java.io.File;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSalesPrice;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.PriceBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;

/**
 * @author Simon and Clemens.
 *
 */
public class Exporter {


	private static final String ATTRIBUTE_PRICE_TYPE = "price_type";
	private static final String FILETYPE_XML = ".xml";
	private static final String FILETYPE_XHTML = ".xhtml";
	
	
	private Document doc;
	private Transformer bumblebee;
	private Collection<BOProduct> products;
	private File repository;

	/**
	 * @param shortDescription The shortDescription to look for.
	 * @param context The servlet context.
	 * @param isFormatBMEcat Output format BMECat (XML) or XHTML.
	 */
	public Exporter(String shortDescription, ServletContext context, boolean isFormatBMEcat) {
		init(shortDescription, context, isFormatBMEcat);
	}

	/**
	 * @param shortDescription The shortDescription to look for.
	 * @param context The servlet context.
	 * @param isFormatBMEcat Output format BMECat (XML) or XHTML.
	 */
	private void init(String shortDescription, ServletContext context, boolean isFormatBMEcat) {

		if (stringNotNull(shortDescription)) {
			products = ProductBOA.getInstance().findByCriteriaLike("Shortdescription", "%"+shortDescription+"%");
		} else {
			products = ProductBOA.getInstance().findAll();
		}

		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();

	        TransformerFactory autobots = TransformerFactory.newInstance();
	        if (isFormatBMEcat) {
		        bumblebee = autobots.newTransformer();
		        //TODO: PrettyPrintXML
		        bumblebee.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		        bumblebee.setOutputProperty(OutputKeys.INDENT, "yes");
	        } else {
	        	File stylesheet = new File("C:\\temp\\tranformationBMEcatToXHTML.xsl");
	    		StreamSource xslt = new StreamSource(stylesheet);
	        	bumblebee = autobots.newTransformer(xslt);
	        }

			repository = (File) context.getAttribute("javax.servlet.context.tempdir");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerConfigurationException tce) {
			tce.printStackTrace();
		}

	}

	private void createDocument() {
		Element root = createRootElement();
		Element header = createHeader();
		Element tNewCatalog = createTNewCatalog();

		root.appendChild(header);
		root.appendChild(tNewCatalog);
		doc.appendChild(root);
	}


	public File getBMEcat() {
		createDocument();
		//generate TS for unique filenames
		long ts = new GregorianCalendar().getTimeInMillis();
		String filename = "\\generatedBMEcat_ts="+ts;
		
		String fullyQualifiedPathName = repository.getAbsolutePath() + filename + FILETYPE_XML;
		File file = new File(fullyQualifiedPathName);
		StreamResult streamResult = new StreamResult(file);
		try {
			System.out.println(doc.getLocalName());
			bumblebee.transform(new DOMSource(doc), streamResult);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return file;
	}


	public File getXHTML() {
		createDocument();

		long ts = new GregorianCalendar().getTimeInMillis();
		String filename = "\\generatedXHTML_ts="+ts;
		String fullyQualifiedPathName = repository.getAbsolutePath() + filename + FILETYPE_XHTML;
		
		File file = new File(fullyQualifiedPathName);
		StreamResult streamResult = new StreamResult(file);
		try {
			//bumblebee.transform(new DOMSource(doc), streamResult);
			//new StreamSource(new File("C:\\temp\\articles_bmecat_new_catalog_1_2_simple_V0.96.xml")
			bumblebee.transform(new DOMSource(doc), streamResult);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}



	private Element createRootElement() {
		Element root = doc.createElement("BMECAT");
		root.setAttribute("version", "1.2");
		root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		root.setAttribute("xsi:noNamespaceSchemaLocation", "bmecat_new_catalog_1_2_simple_V0.96.xsd");
		return root;
	}

	private Element createTNewCatalog() {
		Element tNewCatalog = doc.createElement("T_NEW_CATALOG");
		for (BOProduct product : products) {
			Element article = doc.createElement(Constants.ARTICLE);

			//scaffold of article(first level)
			// 	-ARTICLE
			//	--SUPPLIER_AID
			//	--ARTICLE_DETAILS
			//	--ARTICLE_ORDER_DETAILS
			//	--ARTICLE_PRICE_DETAILS
			//	--(ARTICLE_REFERENCE)

			// 1. Set Element <SUPPLIER_AID>
			if (stringNotNull(product.getOrderNumberCustomer())) {
				Element supplierAid = doc.createElement(Constants.ARTICLE_SUPPLIER_AID);
				supplierAid.setTextContent(product.getOrderNumberCustomer());
				article.appendChild(supplierAid);
			}

			// 2. Set Element <ARTICLE_DETAILS>
			if (createArticleDetails(product) != null) {
				Element articleDetails = createArticleDetails(product);
				article.appendChild(articleDetails);
			}


			// 3. Set Element <ARTICLE_ORDER_DETAILS>
			//set always static values to Element <ARTICLE_ORDER_DETAILS>
			Element articleOrderDetails = createArticleOrderDetails();
			article.appendChild(articleOrderDetails);


			// 4. Set Element <ARTICLE_PRICE_DETAILS>
			if (createArticlePriceDetails(product) != null) {
				Element articlePriceDetails = createArticlePriceDetails(product);
				article.appendChild(articlePriceDetails);
			}

			//5. Set Element (ARTICLE_REFERENCE)
			//not necessary?!
			tNewCatalog.appendChild(article);
		}
		return tNewCatalog;
	}

	private Element createArticleDetails(BOProduct product) {
		Element articleDetails = null;
		if (stringNotNull(product.getLongDescription()) || stringNotNull(product.getShortDescription())) {
			articleDetails = doc.createElement(Constants.ARTICLE_ARTICLE_DETAILS);

			if (stringNotNull(product.getShortDescription())) {
				Element descriptionShort = doc.createElement(Constants.ARTICLE_ARTICLE_DETAILS_DESCRIPTION_SHORT);
				descriptionShort.setTextContent(product.getShortDescription());
				articleDetails.appendChild(descriptionShort);
			}

			if (stringNotNull(product.getLongDescription())) {
				Element descriptionLong = doc.createElement(Constants.ARTICLE_ARTICLE_DETAILS_DESCRIPTION_LONG);
				descriptionLong.setTextContent(product.getLongDescription());
				articleDetails.appendChild(descriptionLong);
			}

		}
		return articleDetails;
	}

	private Element createArticleOrderDetails() {
		Element articleOrderDetails = doc.createElement(Constants.ARTICLE_ARTICLE_ORDER_DETAILS);
		Element orderUnit = doc.createElement(Constants.ARTICLE_ARTICLE_ORDER_DETAILS_ORDER_UNIT);
		Element noCuPerOu = doc.createElement(Constants.ARTICLE_ARTICLE_ORDER_DETAILS_NO_CU_PER_OUT);
		orderUnit.setTextContent("C62");
		noCuPerOu.setTextContent("1");
		articleOrderDetails.appendChild(orderUnit);
		articleOrderDetails.appendChild(noCuPerOu);
		return articleOrderDetails;
	}

	private Element createArticlePriceDetails(BOProduct product) {
		List <BOSalesPrice> salesPrices = PriceBOA.getInstance().findSalesPrices(product);
		Element articlePriceDetails = null;
 		if (!salesPrices.isEmpty()) {
			articlePriceDetails = doc.createElement(Constants.ARTICLE_ARTICLE_PRICE_DETAILS);
 			for (BOSalesPrice salesPrice :salesPrices) {
				Element articlePrice = doc.createElement(Constants.ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE);
				Element priceAmount = doc.createElement(Constants.ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_PRICE_AMOUNT);
				Element priceCurrency = doc.createElement(Constants.ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_PRICE_CURRENCY);
				Element priceTax = doc.createElement(Constants.ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_TAX);
				Element priceTerritory = doc.createElement(Constants.ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_TERRITORY);

				articlePrice.appendChild(priceAmount);
				articlePrice.appendChild(priceCurrency);
				articlePrice.appendChild(priceTax);
				articlePrice.appendChild(priceTerritory);

				priceAmount.setTextContent(salesPrice.getAmount().toString());
				priceCurrency.setTextContent(salesPrice.getCountry().getCurrency().getCode());
				priceTax.setTextContent(salesPrice.getTaxrate().toString());
				priceTerritory.setTextContent(salesPrice.getCountry().getIsocode());
				//FIXME: Was passiert wenn ein kein PReistype gibt?
				articlePrice.setAttribute(ATTRIBUTE_PRICE_TYPE, salesPrice.getPricetype());

				articlePriceDetails.appendChild(articlePrice);
 			}
 		}
		return articlePriceDetails;

	}

	private boolean stringNotNull(String string) {
		return string != null && !string.isEmpty() && !string.equals(" ");
	}

	private Element createHeader() {
		Element header = doc.createElement("HEADER");
		Element catalog = doc.createElement("CATALOG");
		Element supplier = doc.createElement("SUPPLIER");
		Element language = doc.createElement("LANGUAGE");
		Element catalogId = doc.createElement("CATALOG_ID");
		Element catalogVersion = doc.createElement("CATALOG_VERSION");
		Element catalogName = doc.createElement("CATALOG_NAME");
		Element supplierName = doc.createElement("SUPPLIER_NAME");

		header.appendChild(catalog);
		header.appendChild(supplier);

		catalog.appendChild(language);
		catalog.appendChild(catalogId);
		catalog.appendChild(catalogVersion);
		catalog.appendChild(catalogName);

		supplier.appendChild(supplierName);

		language.setTextContent("deu");
		catalogId.setTextContent("#cksr-coop");
		catalogVersion.setTextContent("1.0");
		catalogName.setTextContent("Aktuelle Produkte der CKSR Cooperation");

		supplierName.setTextContent("CKSR Coop.");


		return header;
	}
	
		

}
