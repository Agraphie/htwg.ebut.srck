package de.htwg_konstanz.ebus.wholesaler.main;

import java.io.File;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSalesPrice;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.PriceBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;

public class Exporter {
	
	private static final String ATTRIBUTE_PRICE_TYPE = "price_type";
	
	private Document doc;
	private Transformer bumblebee;
	private Collection<BOProduct> products;
	private ServletContext context;
	
	public Exporter(String shortDescription, ServletContext context){
		init(shortDescription, context);
	}
	

	private void init(String shortDescription, ServletContext context) {
		this.context = context;

		if(stringNotNull(shortDescription)){
			products = ProductBOA.getInstance().findByShortdescription(shortDescription);
		}else{
			products = ProductBOA.getInstance().findAll();
		}
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();
			
	        TransformerFactory autobots = TransformerFactory.newInstance();
	        bumblebee = autobots.newTransformer();
	        //PrettyPrintXML
	        bumblebee.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        bumblebee.setOutputProperty(OutputKeys.INDENT, "yes");
	        	
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerConfigurationException tce) {
			// TODO Auto-generated catch block
			tce.printStackTrace();
		}
		
	}

	public File buildXMLFile() {
		Element root = createRootElement();
		Element header = createHeader();
		Element tNewCatalog = createTNewCatalog();
		
		doc.appendChild(root);
		root.appendChild(header);
		root.appendChild(tNewCatalog);

		//TODO: Check for valid XMLFile -> necessary?
		File repository = (File) context.getAttribute("javax.servlet.context.tempdir");
		File file = new File(repository.getAbsolutePath() + "\\generatedXML.xml");
		StreamResult streamResult = new StreamResult(file);

		try {
			//FIXME: koennte racecondition verursachen. entweder methode satic + synchronized machen oder file anders oder wo anders speichern
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
		//FIXME Bin mir nicht sicher ob man die Attribute braucht
		root.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
		root.setAttribute("xsi:noNamespaceSchemaLocation", "bmecat_new_catalog_1_2_simple_V0.96.xsd");
		return root;
	}

	private Element createTNewCatalog() {
		Element tNewCatalog = doc.createElement("T_NEW_CATALOG");
		for(BOProduct product : products){
			Element article = doc.createElement(Constants.ARTICLE);
			
			//scaffold of article(first level)
			// 	-ARTICLE
			//	--SUPPLIER_AID
			//	--ARTICLE_DETAILS
			//	--ARTICLE_ORDER_DETAILS
			//	--ARTICLE_PRICE_DETAILS
			//	--(ARTICLE_REFERENCE)
			
			// 1. Set Element <SUPPLIER_AID>
			if(stringNotNull(product.getOrderNumberCustomer())){
				Element supplierAid = doc.createElement(Constants.ARTICLE_SUPPLIER_AID);
				supplierAid.setTextContent(product.getOrderNumberCustomer());
				article.appendChild(supplierAid);
			}
			
			// 2. Set Element <ARTICLE_DETAILS>
			if(createArticleDetails(product) != null){
				Element articleDetails = createArticleDetails(product);
				article.appendChild(articleDetails);
			}
			
			
			// 3. Set Element <ARTICLE_ORDER_DETAILS>
			//set always static values to Element <ARTICLE_ORDER_DETAILS>
			Element articleOrderDetails = createArticleOrderDetails();
			article.appendChild(articleOrderDetails);


			// 4. Set Element <ARTICLE_PRICE_DETAILS>
			if(createArticlePriceDetails(product) != null){
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
		if(stringNotNull(product.getLongDescription()) || stringNotNull(product.getShortDescription())){
			//FIXME ean nicht immer vorhanden? was hier speichern? ist mind eine nummer pflicht hier?
			//Element ean = doc.createElement(Constants.ARTICLE_ARTICLE_DETAILS_EAN);
			articleDetails = doc.createElement(Constants.ARTICLE_ARTICLE_DETAILS);
			
			if(stringNotNull(product.getShortDescription())){
				Element descriptionShort = doc.createElement(Constants.ARTICLE_ARTICLE_DETAILS_DESCRIPTION_SHORT);
				descriptionShort.setTextContent(product.getShortDescription());;
				articleDetails.appendChild(descriptionShort);
			}
			
			if(stringNotNull(product.getLongDescription())){
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
 		if(!salesPrices.isEmpty()){
			articlePriceDetails = doc.createElement(Constants.ARTICLE_ARTICLE_PRICE_DETAILS);
			//FIXME anstelle von mehrere preisinstanzen für genau den selben preis, mehrere TERRITORY
 			for(BOSalesPrice salesPrice :salesPrices){
				Element articlePrice = doc.createElement(Constants.ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE);
				Element priceAmount = doc.createElement(Constants.ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_PRICE_AMOUNT);
				Element priceCurrency = doc.createElement(Constants.ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_PRICE_CURRENCY);
				Element priceTax = doc.createElement(Constants.ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_TAX);
				Element priceTerritory = doc.createElement(Constants.ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_TERRITORY);
				
				articlePrice.appendChild(priceAmount);
				articlePrice.appendChild(priceCurrency);
				articlePrice.appendChild(priceTax);
				articlePrice.appendChild(priceTerritory);
				
				// FIXME Brutto oder Nettopreis ausgeben?
				priceAmount.setTextContent(salesPrice.getAmount().toString());
				priceCurrency.setTextContent(salesPrice.getCountry().getCurrency().getCode());
				priceTax.setTextContent(salesPrice.getTaxrate().toString());
				priceTerritory.setTextContent(salesPrice.getCountry().getIsocode());
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
		
		//supplierName.setTextContent(SupplierFinderUtil.supplierFinder(loginBean).getCompanyname());
		//FIXME wer ist supplier für alle produkte?!
		supplierName.setTextContent("DER Supplier");

		
		return header;
	}
	
}
