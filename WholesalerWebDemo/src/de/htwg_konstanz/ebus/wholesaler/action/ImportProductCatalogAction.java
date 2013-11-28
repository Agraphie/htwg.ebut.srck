package de.htwg_konstanz.ebus.wholesaler.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
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
import org.dom4j.XPath;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;

import de.htwg_konstanz.ebus.framework.wholesaler.api.security.Security;
import de.htwg_konstanz.ebus.wholesaler.demo.IAction;
import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;

public class ImportProductCatalogAction implements IAction {

	public static final String PARAM_LOGIN_BEAN = "loginBean";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, ArrayList<String> errorList) {
		// get the login bean from the session
		LoginBean loginBean = (LoginBean) request.getSession(true)
				.getAttribute(PARAM_LOGIN_BEAN);

		// ensure that the user is logged in
		if (loginBean != null && loginBean.isLoggedIn()) {
			// ensure that the user is allowed to execute this action
			// (authorization)
			// at this time the authorization is not fully implemented.
			// -> use the "Security.RESOURCE_ALL" constant which includes all
			// resources.
			if (Security.getInstance().isUserAllowed(loginBean.getUser(),
					Security.RESOURCE_ALL, Security.ACTION_READ)) {

				// get context from session, need to think about that
				ServletContext context = request.getSession()
						.getServletContext();

				// get FileCleaningTracker, tracking files saved to a temp dir
				FileCleaningTracker fileCleaningTracker = FileCleanerCleanup
						.getFileCleaningTracker(context);
				// beyond this value (in bytes) all files will be written to a
				// temp dir
				int yourMaxMemorySize = 1000;
				// Create a factory for disk-based file items
				DiskFileItemFactory factory = new DiskFileItemFactory();

				// Set factory constraints
				factory.setSizeThreshold(yourMaxMemorySize);

				// set FileCleaningtracker
				factory.setFileCleaningTracker(fileCleaningTracker);
				// Configure a repository (to ensure a secure temp location is
				// used)
				File repository = (File) context
						.getAttribute("javax.servlet.context.tempdir");
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
					SchemaFactory sFactory = SchemaFactory
							.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
					Schema bmeCatSchema = null;
					try {
						bmeCatSchema = sFactory
								.newSchema(new File(
										"C:\\temp\\bmecat_new_catalog_1_2_simple_V0.96.xsd"));
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						System.out.println("could not create schema.");
						e1.printStackTrace();
					}
					DocumentBuilder xmlBuilder = null;
					DocumentBuilderFactory dbfactory = DocumentBuilderFactory
							.newInstance();

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

					// get XPath factory
					XPathFactory xpFactory = XPathFactory.newInstance();

					try {
						xmlBuilder = dbfactory.newDocumentBuilder();
					} catch (ParserConfigurationException e) {
						System.out.println("Could not get xmlBuilder.");
						e.printStackTrace();
					}

					// set ErrorHandler
					xmlBuilder
							.setErrorHandler(new org.xml.sax.helpers.DefaultHandler());
					xmlBuilder.setEntityResolver(null);

					// koennte null sein
					Document parsedUploadedItem = null;

					// iterate over uploaded files
					while (iter.hasNext()) {
						FileItem item = iter.next();
						try {
							System.out.println("Datei befindet sich im RAM: "
									+ item.isInMemory());
							// get input stream of the current item
							InputStream uploadedItemIS = item.getInputStream();

							// parse the input stream and output a w3c document
							parsedUploadedItem = xmlBuilder
									.parse(uploadedItemIS);
							// close input stream
							uploadedItemIS.close();
							
							
							if (parsedUploadedItem.getFirstChild()
									.getNodeName() == "BMECAT") {
								// validate parsed file, will throw exception if
								// not
								// valid
								bmeCatSchema.newValidator().validate(
										new DOMSource(parsedUploadedItem));
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
							System.out
									.println("Could not parse to w3c document.");
							e.printStackTrace();
						} finally {
							// for deletion of create item in temp folder,
							// otherwise gc will delete it some day

							// item.delete();
						}
					}

					// parsedUploadedItem koennte null sein!!
					try {

						// return type is nodeSet with all Articles. Cool right?
						// XPath value could be everything
						NodeList values = (NodeList) xpFactory.newXPath()
								.evaluate("/BMECAT/T_NEW_CATALOG/ARTICLE",
										parsedUploadedItem,
										XPathConstants.NODESET);
						// iterate over the nodeset and get _all_ the contens!
						for (int i = 0; i < values.getLength(); i++) {
							Element el = (Element) values.item(i);

							// get the supplier id for the article
							System.out.println("Artikel: "
									+ el.getFirstChild().getTextContent());
							// get the Article_Details of the current article.
							// m'kay?
							NodeList values2 = (NodeList) xpFactory.newXPath()
									.evaluate("ARTICLE_DETAILS/*", el,
											XPathConstants.NODESET);
							for (int j = 0; j < values2.getLength(); j++) {

								// get the node name and it's value
								System.out.println(values2.item(j)
										.getNodeName()
										+ ": "
										+ values2.item(j).getTextContent());
							}
							System.out
									.println("----------------------------------------------");
							System.out.println("");

						}

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

	@Override
	public boolean accepts(String actionName) {
		return actionName
				.equalsIgnoreCase(Constants.ACTION_IMPORT_SUPPLIER_PRODUCTS);
	}

}
