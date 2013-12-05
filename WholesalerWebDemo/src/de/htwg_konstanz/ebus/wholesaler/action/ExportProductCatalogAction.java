package de.htwg_konstanz.ebus.wholesaler.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.htwg_konstanz.ebus.framework.wholesaler.api.security.Security;
import de.htwg_konstanz.ebus.wholesaler.demo.IAction;
import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;
import de.htwg_konstanz.ebus.wholesaler.main.Exporter;

public class ExportProductCatalogAction implements IAction{

	private static final String PARAM_LOGIN_BEAN = "loginBean";
	private static final String PARAM_PRODUCT_FILE = "productFile";

	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ArrayList<String> errorList) {
			// get the login bean from the session
			LoginBean loginBean = (LoginBean) request.getSession(true).getAttribute(PARAM_LOGIN_BEAN);

			// ensure that the user is logged in
			if (loginBean != null && loginBean.isLoggedIn()) {
				// ensure that the user is allowed to execute this action (authorization) at this time the authorization is not fully implemented.
				// -> use the "Security.RESOURCE_ALL" constant which includes all resources.
				if (Security.getInstance().isUserAllowed(loginBean.getUser(),Security.RESOURCE_ALL, Security.ACTION_READ)) {
					
//					Boolean flag = (Boolean) request.getAttribute("flag");
//					if(flag == Boolean.TRUE){
						Exporter exporter = new Exporter("Bleistift HB", request.getSession().getServletContext());
						
						File file = exporter.buildXMLFile();
						// now set the file to the session
						request.getSession(true).setAttribute(PARAM_PRODUCT_FILE,file);	
//					}
					String filePath = file.getAbsolutePath();
					int length   = 0;
			        ServletOutputStream outStream;
					try {
						outStream = response.getOutputStream();
						ServletContext context = request.getSession().getServletContext();
				        String mimetype = context.getMimeType(filePath);
				       
				        // sets response content type
				        if (mimetype == null) {
				            mimetype = "application/octet-stream";
				        }
				        response.setContentType(mimetype);
				        response.setContentLength((int)file.length());
				        String fileName = (new File(filePath)).getName();
				       
				        // sets HTTP header
				        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
				       
				        byte[] byteBuffer = new byte[4096];
				        DataInputStream in = new DataInputStream(new FileInputStream(file));
				       
				        // reads the file's bytes and writes them to the response stream
				        while ((in != null) && ((length = in.read(byteBuffer)) != -1))
				        {
				            outStream.write(byteBuffer,0,length);
				        }
				       
				        in.close();
				        //response is already sent, therefor can't redirect anymore!
						outStream.close();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        
					
					return "export.jsp";
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
		return actionName.equalsIgnoreCase(Constants.ACTION_EXPORT_CUSTOMER_PRODUCTS);
	}

}
