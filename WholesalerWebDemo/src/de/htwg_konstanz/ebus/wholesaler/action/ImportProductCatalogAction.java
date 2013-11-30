package de.htwg_konstanz.ebus.wholesaler.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSalesPrice;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.PriceBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOUserSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.SupplierBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.UserBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.security.Security;
import de.htwg_konstanz.ebus.wholesaler.demo.IAction;
import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;

public class ImportProductCatalogAction implements IAction {

	private static final String PARAM_LOGIN_BEAN = "loginBean";
	private static final String PARAM_PRODUCT_LIST = "productList";
	private static final String ATTRIBUTE_PRICE_TYPE = "price_type";
	
	

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ArrayList<String> errorList) {
		// get the login bean from the session
		LoginBean loginBean = (LoginBean) request.getSession(true).getAttribute(PARAM_LOGIN_BEAN);

		// ensure that the user is logged in
		if (loginBean != null && loginBean.isLoggedIn()) {
			// ensure that the user is allowed to execute this action
			// (authorization)
			// at this time the authorization is not fully implemented.

			// -> use the "Security.RESOURCE_ALL" constant which includes all resources.

			if (Security.getInstance().isUserAllowed(loginBean.getUser(), Security.RESOURCE_ALL, Security.ACTION_READ))
			{
				//get the supplier id and supplier
				int supplierID = loginBean.getUser().getId();	
				BOUserSupplier sup = UserBOA.getInstance().findUserSupplierById(supplierID);
				BOSupplier endSupplier = null;
				List<BOSupplier> sersup = SupplierBOA.getInstance().findAll();
				Iterator<BOSupplier> it = sersup.listIterator();
				while(it.hasNext()){
					endSupplier = it.next();
					if(endSupplier.getAddress().getId() == sup.getOrganization().getAddress().getId()){
						break;
					}
				}
				
				//get context from session, need to think about that
				ServletContext context = request.getSession().getServletContext();
				
				//get FileCleaningTracker, tracking files saved to a temp dir
				FileCleaningTracker fileCleaningTracker = FileCleanerCleanup.getFileCleaningTracker(context);
				//beyond this value (in bytes) all files will be written to a temp dir

				int yourMaxMemorySize = 1000;
				// Create a factory for disk-based file items
				DiskFileItemFactory factory = new DiskFileItemFactory();

				// Set factory constraints
				factory.setSizeThreshold(yourMaxMemorySize);

				// set FileCleaningtracker
				factory.setFileCleaningTracker(fileCleaningTracker);
				// Configure a repository (to ensure a secure temp location is
				// used)
				File repository = (File) context.getAttribute("javax.servlet.context.tempdir");
				System.out.println(repository.getAbsolutePath());
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

				if (items != null) {
					Iterator<FileItem> iter = items.iterator();

					// get and set schema
					SchemaFactory sFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
					Schema bmeCatSchema = null;
					try {
						bmeCatSchema = sFactory.newSchema(new File("C:\\Users\\Simon\\eclipse_workspaces\\workspace_WS13\\htwg.ebut.srck\\WholesalerWebDemo\\files\\bmecat_new_catalog_1_2_simple_V0.96.xsd"));

					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						System.out.println("could not create schema.");
						e1.printStackTrace();
					}
					DocumentBuilder xmlBuilder = null;
					DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();

					// set properties
					dbfactory.setValidating(true);
					dbfactory.setExpandEntityReferences(true);
					dbfactory.setIgnoringElementContentWhitespace(true);

					// this will allow namespaces to be specified in the xml
					// documents
					dbfactory.setNamespaceAware(true);

					dbfactory.setSchema(bmeCatSchema);
					dbfactory.setIgnoringComments(true);
					dbfactory.setXIncludeAware(false);

					try {
						xmlBuilder = dbfactory.newDocumentBuilder();
					} catch (ParserConfigurationException e) {
						System.out.println("Could not get xmlBuilder.");
						e.printStackTrace();
					}

					// set ErrorHandler
					xmlBuilder.setErrorHandler(new org.xml.sax.helpers.DefaultHandler());
					xmlBuilder.setEntityResolver(null);

					// koennte null sein
					Document parsedUploadedItem = null;

					// iterate over uploaded files
					while (iter.hasNext()) {
						FileItem item = iter.next();
						try {
							System.out.println("Datei befindet sich im RAM: " + item.isInMemory());
							// get input stream of the current item
							InputStream uploadedItemIS = item.getInputStream();

							// parse the input stream and output a w3c document
							parsedUploadedItem = xmlBuilder.parse(uploadedItemIS);
							// close input stream
							uploadedItemIS.close();
							
							
							if (parsedUploadedItem.getFirstChild().getNodeName() == "BMECAT") {
								// validate parsed file, will throw exception if
								// not
								// valid
								bmeCatSchema.newValidator().validate(new DOMSource(parsedUploadedItem));
							} else {
								errorList.add("File is not a BMECat format!");
								return "import.jsp";
							}

						} catch (SAXParseException e) {
							errorList.add("XML file is not well-formed!");
							e.printStackTrace();
							return "import.jsp";
						}
						catch (SAXException e) {
							errorList.add("XML file is not valid!");
							e.printStackTrace();
							return "import.jsp";
						} catch (IOException e) {
							System.out.println("Could not parse to w3c document.");
							e.printStackTrace();
						} finally {
							// for deletion of create item in temp folder,
							// otherwise gc will delete it some day

							// item.delete();
						}
					}

					try {
						
						//return type is nodeSet with all Articles. Cool right? XPath value could be everything
						// get XPath factory
						XPathFactory xpFactory = XPathFactory.newInstance();
						NodeList articles = (NodeList) xpFactory.newXPath().evaluate("/BMECAT/T_NEW_CATALOG/ARTICLE", parsedUploadedItem, XPathConstants.NODESET);
						createAndPersistArticles(articles, endSupplier);

						// find all available products for current Supplier and put it to the session 
						//now with our new products so a realoading of the site won't be necessary!
						//Use temp list to save all the products which belong to the logged in supplier
						List<BOProduct> productList = ProductBOA.getInstance().findAll();

						List<BOProduct> productListTemp = new LinkedList<BOProduct>();
						Iterator<BOProduct> iterator = productList.iterator();
						BOProduct productTemp;
						while(iterator.hasNext()){
							productTemp = iterator.next();
							if(productTemp.getSupplier().getSupplierNumber() == endSupplier.getSupplierNumber()){
								productListTemp.add(productTemp);
							}
						}
						//now set the right list to the temp list
						productList = productListTemp;
						request.getSession(true).setAttribute(PARAM_PRODUCT_LIST, productList);	
						
					} catch (XPathExpressionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// // parameter not set or product not found
					// errorList.add("Die angegebene Materialnummer ist fehlerhaft!");
					// errorList.add(PARAM_NAME_MATERIAL_NUMBER + ": " +
					// request.getParameter(PARAM_NAME_MATERIAL_NUMBER));

					// find the product by the given materialNumber and put it
					// to the session

					// redirect to the import page
					return "import.jsp";
				} else {
					return "import.jsp";
				}
			} else {
				// authorization failed -> show error message
				errorList.add("You are not allowed to perform this action!");

				// redirect to the welcome page
				return "welcome.jsp";
			}
		} else
			// redirect to the login page
			return "login.jsp";
	}

	private void createAndPersistArticles(NodeList articles, BOSupplier supplier) {
		//iterate over the nodeset and get _all_ the contens!
		for (int i = 0; i < articles.getLength(); i++) {
			Element currentArticle = (Element) articles.item(i);
			NodeList currentArticleChilds = currentArticle.getChildNodes();
			
		    BOProduct product = new BOProduct();

			for(int j = 0; j < currentArticleChilds.getLength(); j++){
				
				String currentNodeName = currentArticleChilds.item(j).getNodeName();
				Element currentNode = (Element) currentArticleChilds.item(j);
				if(Constants.ARTICLE_CHILD_SUPPLIER_AID.equals(currentNodeName)){
					product = setSupplierAID(currentNode, product);
				}else if (Constants.ARTICLE_CHILD_ARTICLE_DETAILS.equals(currentNodeName)){
					product = setArticleDetails(currentNode, product);
				}else if (Constants.ARTICLE_CHILD_ARTICLE_ORDER_DETAILS.equals(currentNodeName)){
					product = setArticleOrderDetails(currentNode, product);
				}else if (Constants.ARTICLE_CHILD_ARTICLE_REFERENCE.equals(currentNodeName)){
					//TODO: referencen auf andere produkte
				}else if (Constants.ARTICLE_CHILD_ARTICLE_PRICE_DETAILS.equals(currentNodeName)){
					//the salesprice needs a product-intance, therefore persist the current product!
					product.setSupplier(supplier);
					ProductBOA.getInstance().saveOrUpdate(product);
					setArticlePriceDetails(currentNode, product);
				}
			}

		}
	}

	private void setArticlePriceDetails(Element currentNode, BOProduct product) {
		NodeList articlePrices = fetchArticlePrices(currentNode);

		for(int i = 0 ; i < articlePrices.getLength() ; i++){
			 //create a sales price
		    BOSalesPrice salesPrice = new BOSalesPrice();
		    Element priceElement = (Element) articlePrices.item(i);
		    salesPrice.setPricetype(priceElement.getAttribute(ATTRIBUTE_PRICE_TYPE));
			NodeList priceElementChilds = priceElement.getChildNodes();
			for(int j = 0 ; j < priceElementChilds.getLength() ; j++){
				Node node = priceElementChilds.item(j);
				String nodeName = node.getNodeName();
				if(textContentNotNull(node)){
					String textContent = node.getTextContent();
					if(Constants.ARTICLE_CHILD_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_PRICE_AMOUNT.equals(nodeName)){
						salesPrice.setAmount(new BigDecimal(textContent));
					}else if(Constants.ARTICLE_CHILD_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_PRICE_CURRENCY.equals(nodeName)){
						//FIXME: not necessary - load default currency of territory?!
					}else if(Constants.ARTICLE_CHILD_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_TAX.equals(nodeName)){
						salesPrice.setTaxrate(new BigDecimal(textContent));
					}else if(Constants.ARTICLE_CHILD_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_TERRITORY.equals(nodeName)){
						 //load corresponding country
						//FIXME: Es ist möglich dass der bmecat mehrere <TERRITORY> elemente enthalten kann. es müssten dann also mehrere preisobjekte erstellt werden?!
						BOCountry country = CountryBOA.getInstance().findCountry(textContent);
						salesPrice.setCountry(country);
					}
				}
			}
			//FIXME: information fehlt uns im bmecat?
			salesPrice.setLowerboundScaledprice(new Integer(1));
			salesPrice.setProduct(product);
			// save the new sales price associated to the new product
			PriceBOA.getInstance().saveOrUpdateSalesPrice(salesPrice);
		}
	    
	}
	
	/*
	 * Das Element <ARTICLE_PRICE_DETAILS> hat kinder und kindeskinder. um noch eine doppelte for-schleife zu vermeiden mittels xpFactory geholt! y0?
	 */
	private NodeList fetchArticlePrices(Element currentNode) {
		try {
			XPathFactory xpFactory = XPathFactory.newInstance();
			NodeList articlePrices = (NodeList) xpFactory.newXPath().evaluate("ARTICLE_PRICE", currentNode, XPathConstants.NODESET);
			return articlePrices;
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* Set ArticleOrderDetails on product?!
	 * @param currentNode in that case <ARTICLE_ORDER_DETAILS>
	 * @param currentProduct instance
	 * 
	 */
	private BOProduct setArticleOrderDetails(Node currentNode, BOProduct product) {
		NodeList childNodes = getChildNodes(currentNode);
		for(int i = 0 ; i < childNodes.getLength() ; i++){
			Node childNode = childNodes.item(i);
			String nodeName = childNode.getNodeName();
			if(textContentNotNull(childNode)){
				String textContent = childNode.getTextContent();
				if (Constants.ARTICLE_CHILD_ARTICLE_ORDER_DETAILS_NO_CU_PER_OUT.equals(nodeName)) {
					//TODO: WORAUF setzen?
				} else if (Constants.ARTICLE_CHILD_ARTICLE_ORDER_DETAILS_ORDER_UNIT.equals(nodeName)) {
					//TODO: WORAUF setzen?
				}
			}
		}
		return product;
	}

	/*
	 *  Set ArticleDetails on product
	 *  E.g. long and shortdescription(supplier+costumer) and additional articlenumbers ...
	 *  @param currentNode in that case <ARTICLE_DETAILS>
	 *  @param product currentProduct instance
	 */
	private BOProduct setArticleDetails(Node currentNode, BOProduct product) {
		NodeList childNodes = getChildNodes(currentNode);
		for(int i = 0; i < childNodes.getLength(); i++){
			Node childNode = childNodes.item(i);
			String nodeName = childNode.getNodeName();
			if(textContentNotNull(childNode)){
				String textContent = childNode.getTextContent();
				if(Constants.ARTICLE_CHILD_ARTICLE_DETAILS_DESCRIPTION_LONG.equals(nodeName)){
						product.setLongDescription(textContent);
						product.setLongDescriptionCustomer(textContent);
				}else if(Constants.ARTICLE_CHILD_ARTICLE_DETAILS_DESCRIPTION_SHORT.equals(nodeName)){
						product.setShortDescription(textContent);
						product.setShortDescriptionCustomer(textContent);
				}else if(Constants.ARTICLE_CHILD_ARTICLE_DETAILS_EAN.equals(nodeName)){
						product.setOrderNumberCustomer(textContent);
						product.setOrderNumberSupplier(textContent);
				}
				//TODO: wohin mit zusätzlichen Artikelnummern?
			}
		}
		return product;
	}


	/*
	 * @param currentNode in that case <SUPPLIER_AID>
	 * @param product currentProduct instance
	 *  
	 * Set SupplierArticleNumber on product
	 */
	private BOProduct setSupplierAID(Node currentNode, BOProduct product) {
		if (textContentNotNull(currentNode)){
			product.setOrderNumberSupplier(currentNode.getTextContent());
		}
		return product;
	}
	
	
	/*
	 * Get childnodes ...
	 */
	private NodeList getChildNodes(Node currentNode) {
		return currentNode.getChildNodes();
	}
	
	/*
	 * Check for null value
	 */
	private boolean textContentNotNull(Node node) {
		return node.getTextContent() != null;
	}

	
	@Override
	public boolean accepts(String actionName) {
		return actionName.equalsIgnoreCase(Constants.ACTION_IMPORT_SUPPLIER_PRODUCTS);
	}

}
