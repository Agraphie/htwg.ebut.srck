package de.htwg_konstanz.ebus.wholesaler.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCountry;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOPurchasePrice;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSalesPrice;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOUserSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.PriceBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.SupplierBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.UserBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.Product;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.Productreference;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.ProductreferencePK;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.ProductVOA;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.ProductreferenceVOA;
import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;

public class Importer {
	private static XPathFactory xpFactory;
	private static final String ATTRIBUTE_PRICE_TYPE = "price_type";
	private static final String ATTRIBUTE_TYPE = "type";
	private static final BigDecimal INCREASE_IN_PRICE = new BigDecimal(2);

	public void startImport(HttpServletRequest request, LoginBean loginBean)throws SAXParseException, SAXException,  IOException, XPathExpressionException {
		// get the supplier id and supplier
		BOSupplier endSupplier = supplierFinder(loginBean);

		List<FileItem> items = fileUploadParser(request);

		if (items != null) {

			// koennte null sein
			Document parsedUploadedItem = null;

			Schema bmeCatSchema = getSchema();

			DocumentBuilder xmlBuilder = getXMLBuilder(bmeCatSchema);
			
			// iterate over uploaded files
			parsedUploadedItem = parseUploadItem(parsedUploadedItem, items,	xmlBuilder);

			try{
			bmeCatSchema.newValidator().validate(new DOMSource(parsedUploadedItem));
			} catch (SAXParseException e){
				throw new SAXException();
			}
			// return type is nodeSet with all Articles. Cool right? XPath value
			// could be everything
			// get XPath factory
			xpFactory = XPathFactory.newInstance();
			NodeList articles = (NodeList) xpFactory.newXPath().evaluate("/BMECAT/T_NEW_CATALOG/ARTICLE", parsedUploadedItem,XPathConstants.NODESET);

			createAndPersistArticles(articles, endSupplier);

		}
	}

	private Document parseUploadItem(Document parsedUploadedItem,List<FileItem> items, DocumentBuilder xmlBuilder)	throws IOException, SAXException {
		Iterator<FileItem> iter = items.iterator();

		while (iter.hasNext()) {
			FileItem item = iter.next();
			// get input stream of the current item
			InputStream uploadedItemIS = item.getInputStream();

			// parse the input stream and output a w3c document
			parsedUploadedItem = xmlBuilder.parse(uploadedItemIS);
			xmlBuilder.reset();
			// close input stream
			uploadedItemIS.close();
		}
		return parsedUploadedItem;
	}

	private DocumentBuilder getXMLBuilder(Schema bmeCatSchema) throws SAXParseException {
		DocumentBuilder xmlBuilder = null;
		DocumentBuilderFactory dbfactory = documentBuilderFactory(bmeCatSchema);

		try {
			xmlBuilder = dbfactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("Could not get xmlBuilder.");
			e.printStackTrace();
		}

		// set ErrorHandler
		xmlBuilder.setErrorHandler(new org.xml.sax.helpers.DefaultHandler());
		xmlBuilder.setEntityResolver(null);
		return xmlBuilder;
	}

	private Schema getSchema() throws SAXException {
		// get and set schema
		SchemaFactory sFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		Schema bmeCatSchema = sFactory.newSchema(new File("C:\\Users\\Simon\\eclipse_workspaces\\workspace_WS13\\htwg.ebut.srck\\WholesalerWebDemo\\files\\bmecat_new_catalog_1_2_simple_V0.96.xsd"));
		return bmeCatSchema;

	}

	public DocumentBuilderFactory documentBuilderFactory(Schema bmeCatSchema) {
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();

		// set properties
		dbfactory.setValidating(false);
		dbfactory.setExpandEntityReferences(true);
		dbfactory.setIgnoringElementContentWhitespace(true);

		// this will allow namespaces to be specified in the xml
		// documents
		dbfactory.setNamespaceAware(true);

		dbfactory.setSchema(bmeCatSchema);
		dbfactory.setIgnoringComments(true);
		dbfactory.setXIncludeAware(false);
		return dbfactory;
	}
	
	/**
	 * Create and persist articles
	 * 
	 * @param articles contains uploaded articles 
	 * @param supplier logged-in supplier
	 */

	public void createAndPersistArticles(NodeList articles, BOSupplier supplier) {
		// iterate over the nodeset and get _all_ the contens!
		for (int i = 0; i < articles.getLength(); i++) {
			Element currentArticle = (Element) articles.item(i);
			NodeList currentArticleChilds = currentArticle.getChildNodes();
			String supplierAID = "";
			try {
				// query the current article and get it's S_AID
				supplierAID = (String) xpFactory.newXPath().evaluate("SUPPLIER_AID", currentArticle,	XPathConstants.STRING);
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// declare a product
			BOProduct product;

			// if update product, search for which criteria? Materialnumber
			// is set by the database (or hibernate?)
			// product would be null if the EAN is not found.
			product = ProductBOA.getInstance().findByOrderNumberSupplier(supplierAID);

			if (product == null) {
				// initiate new product if no product was found above
				product = new BOProduct();
			}

			for (int j = 0; j < currentArticleChilds.getLength(); j++) {

				String currentNodeName = currentArticleChilds.item(j).getNodeName();
				Element currentNode = (Element) currentArticleChilds.item(j);
				if (Constants.ARTICLE_CHILD_SUPPLIER_AID.equals(currentNodeName)) {
					product = setSupplierAID(currentNode, product);
				} else if (Constants.ARTICLE_CHILD_ARTICLE_DETAILS.equals(currentNodeName)) {
					product = setArticleDetails(currentNode, product);
				} else if (Constants.ARTICLE_CHILD_ARTICLE_ORDER_DETAILS.equals(currentNodeName)) {
					product = setArticleOrderDetails(currentNode, product);
				} else if (Constants.ARTICLE_CHILD_ARTICLE_REFERENCE.equals(currentNodeName)) {
					createReferenceToOtherProducts(currentNode, product);
				} else if (Constants.ARTICLE_CHILD_ARTICLE_PRICE_DETAILS.equals(currentNodeName)) {
					// the salesprice needs a product-intance, therefore persist the the current product before then
					product.setSupplier(supplier);
					ProductBOA.getInstance().saveOrUpdate(product);
					setArticlePriceDetails(currentNode, product);
				}
			}

		}
	}
	
	/**
	 * Create references to other products
	 * 
	 * @param currentNode in that case <ARTICLE_REFERENCE>
	 * @param product
	 */

	private void createReferenceToOtherProducts(Element currentNode, BOProduct product){
		
		String referenceType = currentNode.getAttribute(ATTRIBUTE_TYPE);	
		NodeList referencen = getChildNodes(currentNode);


		ProductreferencePK referencePK = new ProductreferencePK();
		Productreference reference = new Productreference();
		Product pro = ProductVOA.getInstance().get(product.getMaterialNumber());
		
		for(int i = 0; i < referencen.getLength() ; i++){
			String nodeName = referencen.item(i).getNodeName();
			Element node = (Element) referencen.item(i);
			if (textContentNotNull(node) && Constants.ARTICLE_CHILD_ARTICLE_REFERENCE_ART_ID_TO.equals(nodeName)) {
				BOProduct tempProduct = ProductBOA.getInstance().findByOrderNumberSupplier(node.getTextContent());
				Product referencedProduct = ProductVOA.getInstance().get(tempProduct.getMaterialNumber());
				referencePK.setProduct(pro);
				referencePK.setReferencedproduct(referencedProduct);
				reference.setId(referencePK);
				reference.setQuantity(1);
				reference.setReferencetype(referenceType);
				//reference.setRemark(remark);
				
				ProductreferenceVOA.getInstance().saveOrUpdate(reference);
			}
		}	
	}
	
	/**
	 * Create/persist the sales- and purchaseprice. 
	 * 
	 * @param currentNode in that case <ARTICLE_PRICE_DETAILS>
	 * @param product every price needs a product!
	 */

	private void setArticlePriceDetails(Element currentNode, BOProduct product) {
		//List with all persisted prices for this article
		//in case an article has several equal prices
		HashSet<Object> persistedPrices = new HashSet<Object>();
		NodeList articlePrices = fetchArticlePrices(currentNode);
		for (int i = 0; i < articlePrices.getLength(); i++) {
			// create a sales/purchase price
			Element articlePriceNode = (Element) articlePrices.item(i);

			String priceType = articlePriceNode.getAttribute(ATTRIBUTE_PRICE_TYPE);	
			BigDecimal amount = null;
			BigDecimal taxrate = null;
			BOCountry country = null;
			
			NodeList priceElementChilds = articlePriceNode.getChildNodes();
			for (int j = 0; j < priceElementChilds.getLength(); j++) {
				Node node = priceElementChilds.item(j);
				String nodeName = node.getNodeName();
				if (textContentNotNull(node)) {
					String textContent = node.getTextContent();
					if (Constants.ARTICLE_CHILD_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_PRICE_AMOUNT.equals(nodeName)) {
						amount = new BigDecimal(textContent);
					} else if (Constants.ARTICLE_CHILD_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_PRICE_CURRENCY.equals(nodeName)) {
						// not necessary - load default currency of territory
					} else if (Constants.ARTICLE_CHILD_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_TAX.equals(nodeName)) {
						taxrate = new BigDecimal(textContent);
					} else if (Constants.ARTICLE_CHILD_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_TERRITORY.equals(nodeName)) {
						// load corresponding country
						country = CountryBOA.getInstance().findCountry(textContent);
					}	
					if(articlePriceDetailsNotNull(amount, taxrate, country)){
						BOSalesPrice salesPrice = new BOSalesPrice(increaseSalesPrice(amount), taxrate, priceType);
						salesPrice.setCountry(country);
						salesPrice.setProduct(product);
						salesPrice.setLowerboundScaledprice(new Integer(1));
						
						//TODO Bugfix
						if(!persistedPrices.contains(salesPrice)){
							PriceBOA.getInstance().saveOrUpdateSalesPrice(salesPrice);
							persistedPrices.add(salesPrice);
						}
						
						BOPurchasePrice purchasePrice = new BOPurchasePrice(amount, taxrate, priceType);
						purchasePrice.setCountry(country);
						purchasePrice.setProduct(product);						
						purchasePrice.setLowerboundScaledprice(new Integer(1));
						if(!persistedPrices.contains(purchasePrice)){
							PriceBOA.getInstance().saveOrUpdatePurchasePrice(purchasePrice);
							persistedPrices.add(purchasePrice);
						}
						
					}
				}
			}
		}

	}

	private boolean articlePriceDetailsNotNull(BigDecimal amount,BigDecimal taxrate, BOCountry country) {
		return amount != null && taxrate != null && country != null;
	}

	/**
	 * business as usual
	 * @param amount
	 * @return
	 */
	private BigDecimal increaseSalesPrice(BigDecimal amount) {
		return amount.multiply(INCREASE_IN_PRICE);
	}

	/**
	 * Das Element <ARTICLE_PRICE_DETAILS> hat kinder und kindeskinder. um noch
	 * eine doppelte for-schleife zu vermeiden mittels xpFactory geholt! y0?
	 * 
	 */
	private NodeList fetchArticlePrices(Element currentNode) {
		try {
			NodeList articlePrices = (NodeList) xpFactory.newXPath().evaluate("ARTICLE_PRICE", currentNode, XPathConstants.NODESET);
			return articlePrices;
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Set ArticleOrderDetails on product?!
	 * 
	 * @param currentNode in that case <ARTICLE_ORDER_DETAILS>
	 * @param currentProduct 
	 * 
	 */
	private BOProduct setArticleOrderDetails(Node currentNode, BOProduct product) {
		NodeList childNodes = getChildNodes(currentNode);
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node childNode = childNodes.item(i);
			String nodeName = childNode.getNodeName();
			if (textContentNotNull(childNode)) {
				String textContent = childNode.getTextContent();
				if (Constants.ARTICLE_CHILD_ARTICLE_ORDER_DETAILS_NO_CU_PER_OUT.equals(nodeName)) {
					// not necessary
				} else if (Constants.ARTICLE_CHILD_ARTICLE_ORDER_DETAILS_ORDER_UNIT.equals(nodeName)) {
					// not necessary
				}
			}
		}
		return product;
	}

	/**
	 * Set article details on product e.g. long and
	 * shortdescription(supplier+costumer) and additional articlenumbers ...
	 * 
	 * @param currentNode	in that case <ARTICLE_DETAILS>
	 * @param product		currentProduct instance
	 */
	private BOProduct setArticleDetails(Node currentNode, BOProduct product) {
		NodeList childNodes = getChildNodes(currentNode);
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node childNode = childNodes.item(i);
			String nodeName = childNode.getNodeName();
			if (textContentNotNull(childNode)) {
				String textContent = childNode.getTextContent();
				if (Constants.ARTICLE_CHILD_ARTICLE_DETAILS_DESCRIPTION_LONG.equals(nodeName)) {
					product.setLongDescription(textContent);
					product.setLongDescriptionCustomer(textContent);
				} else if (Constants.ARTICLE_CHILD_ARTICLE_DETAILS_DESCRIPTION_SHORT.equals(nodeName)) {
					product.setShortDescription(textContent);
					product.setShortDescriptionCustomer(textContent);
				} else if (Constants.ARTICLE_CHILD_ARTICLE_DETAILS_EAN.equals(nodeName)) {
					//zusätzlcihe artikelnummern werden nicht berücksichtigt
					//ean ist nicht immer vorhanden, nehme S_AID
					//product.setOrderNumberCustomer(textContent);
					//product.setOrderNumberSupplier(textContent);
				}
			}
		}
		return product;
	}

	/**
	 * Set SupplierArticleNumber on product
	 * 
	 * @param currentNode in that case <SUPPLIER_AID>
	 * @param product currentProduct instance
	 * 
	 */
	private BOProduct setSupplierAID(Node currentNode, BOProduct product) {
		if (textContentNotNull(currentNode)) {
			product.setOrderNumberSupplier(currentNode.getTextContent());
			product.setOrderNumberCustomer(currentNode.getTextContent());
		}
		return product;
	}

	/**
	 * Get childnodes of transfer parameter
	 */
	private NodeList getChildNodes(Node currentNode) {
		return currentNode.getChildNodes();
	}

	/**
	 * Check for null value
	 */
	private boolean textContentNotNull(Node node) {
		return node.getTextContent() != null;
	}
	
	
	/**
	 * Fileupload
	 * 
	 * @param request
	 * @return
	 */

	private List<FileItem> fileUploadParser(HttpServletRequest request) {
		// get context from session, need to think about that
		ServletContext context = request.getSession().getServletContext();

		// get FileCleaningTracker, tracking files saved to a temp dir
		FileCleaningTracker fileCleaningTracker = FileCleanerCleanup.getFileCleaningTracker(context);
		// beyond this value (in bytes) all files will be written to a temp dir

		int maxMemorySize = 1000;
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Set factory constraints
		factory.setSizeThreshold(maxMemorySize);

		// set FileCleaningtracker
		factory.setFileCleaningTracker(fileCleaningTracker);
		// Configure a repository (to ensure a secure temp location is
		// used)
		File repository = (File) context.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			System.out.println("Could not parse upload request.");
			e.printStackTrace();
		}
		return items;
	}
	
	/**
	 * Compare on basis of the address, so we find the logged-in supplier.
	 * Returns the logged-in supplier as {@link BOSupplier}. 
	 * 
	 * @param loginBean 
	 * @return endSupplier logged-in supplier
	 */

	public BOSupplier supplierFinder(LoginBean loginBean) {
		int supplierID = loginBean.getUser().getId();
		BOUserSupplier sup = UserBOA.getInstance().findUserSupplierById(supplierID);
		BOSupplier endSupplier = null;
		//not nice but rare
		List<BOSupplier> sersup = SupplierBOA.getInstance().findAll();
		Iterator<BOSupplier> it = sersup.listIterator();
		while (it.hasNext()) {
			endSupplier = it.next();
			if (endSupplier.getAddress().getId() == sup.getOrganization().getAddress().getId()) {
				break;
			}
		}
		return endSupplier;
	}
}
