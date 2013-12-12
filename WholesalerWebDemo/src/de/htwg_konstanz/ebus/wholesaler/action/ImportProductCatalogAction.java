package de.htwg_konstanz.ebus.wholesaler.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
import de.htwg_konstanz.ebus.framework.wholesaler.api.security.Security;
import de.htwg_konstanz.ebus.wholesaler.demo.IAction;
import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;
import de.htwg_konstanz.ebus.wholesaler.main.Importer;
import de.htwg_konstanz.ebus.wholesaler.main.ProductFinderUtil;
import de.htwg_konstanz.ebus.wholesaler.main.TooManyPricesForOneCountryException;

/**
 * 
 * @author Simon, Clemens
 *
 */
public class ImportProductCatalogAction implements IAction {

	private static final String PARAM_LOGIN_BEAN = "loginBean";
	private static final String PARAM_PRODUCT_LIST = "productList";


	/**
	 * Servlet to handle the imports of catalogs. Is called by the controllservlet class.
	 * @param request The despatched request.
	 * @param response The despatched response.
	 * @param errorList The despatched errorlist.
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response, ArrayList<String> errorList) {
		// get the login bean from the session
		LoginBean loginBean = (LoginBean) request.getSession(true).getAttribute(PARAM_LOGIN_BEAN);

		// ensure that the user is logged in
		if (loginBean != null && loginBean.isLoggedIn()) {
			// ensure that the user is allowed to execute this action (authorization) at this time the authorization is not fully implemented.
			// -> use the "Security.RESOURCE_ALL" constant which includes all resources.
			if (Security.getInstance().isUserAllowed(loginBean.getUser(), Security.RESOURCE_ALL, Security.ACTION_READ)) {

				try {
					new Importer().startImport(request, loginBean);
				} catch (SAXParseException e) {
					errorList.add("XML file is not well-formed!");
					e.printStackTrace();
					return "import.jsp";
				} catch (SAXException e) {
					errorList.add("XML file is not valid!");
					e.printStackTrace();
					return "import.jsp";
				} catch (TooManyPricesForOneCountryException e) {
					errorList.add("Only one price per country per article is allowed!");
					System.out.println("Too many price attributes.");
					e.printStackTrace();
				} catch (IOException e) {
					errorList.add("Could not parse to w3c document!");
					System.out.println("Could not parse to w3c document.");
					e.printStackTrace();
				} catch (XPathExpressionException e) {
					e.printStackTrace();
				}

				List<BOProduct> productList = ProductFinderUtil.findProductsForSupplier(loginBean);
				// now set the right list to the session
				request.getSession(true).setAttribute(PARAM_PRODUCT_LIST, productList);

				return "import.jsp";
			} else {
				// authorization failed -> show error message
				errorList.add("You are not allowed to perform this action!");

				// redirect to the welcome page
				return "welcome.jsp";
			}
		} else {
			// redirect to the login page
			return "login.jsp";
		}
	}

	/**
	 * @param actionName The constant this class accepts.
	 */
	public boolean accepts(String actionName) {
		return actionName.equalsIgnoreCase(Constants.ACTION_IMPORT_SUPPLIER_PRODUCTS);
	}

}
