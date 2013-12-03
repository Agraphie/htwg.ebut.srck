package de.htwg_konstanz.ebus.wholesaler.main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;
import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;

public class ProductFinderUtil {

	/**
	 *  find all available products for current Supplier
	 * @param loginBean
	 * @return productListTemp 
	 */
	public static List<BOProduct> findProductsForSupplier(LoginBean loginBean) {
		
		// Use temp list to save all the products which belong to the logged in supplier
		List<BOProduct> productList = ProductBOA.getInstance().findAll();

		List<BOProduct> productListTemp = new LinkedList<BOProduct>();
		Iterator<BOProduct> iterator = productList.iterator();
		BOProduct productTemp;
		BOSupplier endsupplier = SupplierFinderUtil.supplierFinder(loginBean);
		while (iterator.hasNext()) {
			productTemp = iterator.next();
			if (productTemp.getSupplier().getSupplierNumber() == endsupplier.getSupplierNumber()) {
				productListTemp.add(productTemp);
			}
		}
		return productListTemp;
	}

	
}
