package de.htwg_konstanz.ebus.wholesaler.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

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
		LoginBean loginBean = (LoginBean)request.getSession(true).getAttribute(PARAM_LOGIN_BEAN);

		// ensure that the user is logged in
		if (loginBean != null && loginBean.isLoggedIn())
		{
			// ensure that the user is allowed to execute this action (authorization)
			// at this time the authorization is not fully implemented.
			// -> use the "Security.RESOURCE_ALL" constant which includes all resources.
			if (Security.getInstance().isUserAllowed(loginBean.getUser(), Security.RESOURCE_ALL, Security.ACTION_READ))
			{
				
					int yourMaxMemorySize = 1000;
					// Create a factory for disk-based file items
					DiskFileItemFactory factory = new DiskFileItemFactory();
					
					// Set factory constraints
					factory.setSizeThreshold(yourMaxMemorySize);
					
					// Configure a repository (to ensure a secure temp location is used)
					ServletContext servletContext = request.getSession().getServletContext();
					File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
					factory.setRepository(repository);
					
					// Create a new file upload handler
					ServletFileUpload upload = new ServletFileUpload(factory);

					// Parse the request
					List<FileItem> items = null;
					try {
						 items = upload.parseRequest(request);
					} catch (FileUploadException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Iterator<FileItem> iter = items.iterator();
					
					SchemaFactory sFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
					Schema bmeCatSchema = null;
					try {
						bmeCatSchema = sFactory.newSchema(new File("C:\\Users\\Simon\\Google Drive\\Wirtschaftsinformatik\\6. Semester\\E-Business Technologien\\Übung\\Aufgabenteil2\\Abgabe\\Aufgabe 2\\bmecat_new_catalog_1_2_simple_V0.96.xsd"));
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					DocumentBuilder xmlBuilder = null;
					DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
					dbfactory.setValidating(true);
					dbfactory.setExpandEntityReferences(true);
					dbfactory.setIgnoringElementContentWhitespace(true);
					dbfactory.setNamespaceAware(false);
					dbfactory.setSchema(bmeCatSchema);
					dbfactory.setIgnoringComments(true);
					dbfactory.setXIncludeAware(false);
					
					
					try {
						xmlBuilder = dbfactory.newDocumentBuilder();
					} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					xmlBuilder.setErrorHandler(null);
					xmlBuilder.setEntityResolver(null);
					
					while (iter.hasNext()) {
					    FileItem item = iter.next();
					    	try {
					    		InputStream hurrdurr = item.getInputStream();
								Document doc = xmlBuilder.parse(hurrdurr);
								bmeCatSchema.newValidator().validate(new DOMSource(doc));
								hurrdurr.close();
							} catch (SAXException e) {
								System.out.println("is not valid");			
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
//            // parameter not set or product not found
//            errorList.add("Die angegebene Materialnummer ist fehlerhaft!");
//            errorList.add(PARAM_NAME_MATERIAL_NUMBER + ": " + request.getParameter(PARAM_NAME_MATERIAL_NUMBER));
		      
		      // find the product by the given materialNumber and put it to the session
			
				// redirect to the import page
				return "import.jsp";
			}
			else
			{
				// authorization failed -> show error message
				errorList.add("You are not allowed to perform this action!");
				
				// redirect to the welcome page
				return "welcome.jsp";
			}
		}
		else
			// redirect to the login page
			return "login.jsp";				
	}

	@Override
	public boolean accepts(String actionName) {
		return actionName.equalsIgnoreCase(Constants.ACTION_IMPORT_SUPPLIER_PRODUCTS);
	}

	
	
}
