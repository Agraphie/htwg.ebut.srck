package de.htwg_konstanz.ebus.wholesaler.action;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.htwg_konstanz.ebus.framework.wholesaler.api.security.Security;
import de.htwg_konstanz.ebus.wholesaler.demo.IAction;
import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;
import de.htwg_konstanz.ebus.wholesaler.main.Exporter;

/**
 * Action to handle the export of items.
 * @author Simon and Clemens
 *
 */
public class ExportProductCatalogAction implements IAction {

	private static final String PARAM_LOGIN_BEAN = "loginBean";

	/**
	 * Method to instantiate the export of items. Is called by the controllservlet class.
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

					//searchcriteria
					String filter = (String) request.getParameter("filter");
					String format = (String) request.getParameter("exportFormat");
					boolean isFormatBMEcat = format.equals("formatBMEcat") ? true : false;
					File file = null;
					Exporter exporter = null;

					//Search by Shortdesciption
					if (!filter.equals("") && filter != null && !filter.equals(" ")) {
						exporter = new Exporter(filter, request.getSession().getServletContext(), isFormatBMEcat);
						System.out.println("gefiltert");
					} else {
						exporter = new Exporter(null, request.getSession().getServletContext(), isFormatBMEcat);
					}

					//ExportFormat
					if (isFormatBMEcat) {
						file = exporter.getBMEcat();
					} else {
						file = exporter.getXHTML();
					}

					// now set the file to the session
					request.getSession(true).setAttribute("file", file);

					return "export.jsp";
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
		return actionName.equalsIgnoreCase(Constants.ACTION_EXPORT_CUSTOMER_PRODUCTS);
	}

}
