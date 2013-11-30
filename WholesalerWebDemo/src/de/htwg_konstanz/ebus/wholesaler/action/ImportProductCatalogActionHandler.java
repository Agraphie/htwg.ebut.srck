package de.htwg_konstanz.ebus.wholesaler.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOUserSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.SupplierBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.UserBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.security.Security;
import de.htwg_konstanz.ebus.wholesaler.demo.IAction;
import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;

public class ImportProductCatalogActionHandler implements IAction {

	public static final String PARAM_LOGIN_BEAN = "loginBean";
	private static final String PARAM_PRODUCT_LIST = "productList";


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
				// redirect to the product page
				//TODO: FOR CURRENT SUPPLIER
				List<BOProduct> productList = ProductBOA.getInstance().findAll();
				//get the supplier id and supplier
				int supplierID = loginBean.getUser().getId();	
				BOUserSupplier sup = UserBOA.getInstance().findUserSupplierById(supplierID);
				BOSupplier endSupplier = null;
				List<BOSupplier> sersup = SupplierBOA.getInstance().findAll();
				Iterator<BOSupplier> it = sersup.listIterator();
				while(it.hasNext()){

					endSupplier = it.next();
					if(endSupplier.getAddress().getId() == sup.getOrganization().getAddress().getId())
					{
						break;
					}
				}
				// find all available products for current Suppllier and put it to the session
				//TODO: FOR CURRENT SUPPLIER
				//Use temp list to save all the products which belong to the logged in supplier
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
		return actionName.equalsIgnoreCase(Constants.ACTION_HANDLER_IMPORT_SUPPLIER_PRODUCTS);
	}

}
