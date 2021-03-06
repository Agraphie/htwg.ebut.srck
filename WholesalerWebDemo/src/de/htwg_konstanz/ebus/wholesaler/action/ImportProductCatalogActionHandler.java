package de.htwg_konstanz.ebus.wholesaler.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
import de.htwg_konstanz.ebus.framework.wholesaler.api.security.Security;
import de.htwg_konstanz.ebus.wholesaler.demo.IAction;
import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;
import de.htwg_konstanz.ebus.wholesaler.main.ProductFinderUtil;
/**
 * Class to handle the import of catalogs.
 * @author Simon and Clemens
 *
 */
public class ImportProductCatalogActionHandler implements IAction {

	public static final String PARAM_LOGIN_BEAN = "loginBean";
	private static final String PARAM_PRODUCT_LIST = "productList";


	/**
	 * Method to handle the import site.
	 * @param request The despatched request.
	 * @param response The despatched response.
	 * @param errorList The despatched errorlist.
	 * @return The string of the action to redirect to.
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response, ArrayList<String> errorList) {
		// get the login bean from the session
		LoginBean loginBean = (LoginBean) request.getSession(true).getAttribute(PARAM_LOGIN_BEAN);

		// ensure that the user is logged in
		if (loginBean != null && loginBean.isLoggedIn()) {
			// ensure that the user is allowed to execute this action (authorization)
			// at this time the authorization is not fully implemented.
			// -> use the "Security.RESOURCE_ALL" constant which includes all resources.
			if (Security.getInstance().isUserAllowed(loginBean.getUser(), Security.RESOURCE_ALL, Security.ACTION_READ))
			{

				List<BOProduct> productList = ProductFinderUtil.findProductsForSupplier(loginBean);
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
		return actionName.equalsIgnoreCase(Constants.ACTION_HANDLER_IMPORT_SUPPLIER_PRODUCTS);
	}

}
