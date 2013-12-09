package de.htwg_konstanz.ebus.wholesaler.main;

import java.util.Iterator;
import java.util.List;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOUserSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.SupplierBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.UserBOA;
import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;

/**
 * Very important util which find suppliers.
 * @author srck
 *
 */
public final class SupplierFinderUtil {

	/**
	 * not called.
	 */
	private SupplierFinderUtil() { }

	/**TODO SYNCHRONIZED
	 * Compare on basis of the address, so we find the logged-in supplier.
	 * Returns the logged-in supplier as {@link BOSupplier}.
	 * @param loginBean LoginBean logged-in user
	 * @return endSupplier logged-in supplier
	 */
	public static BOSupplier supplierFinder(LoginBean loginBean) {
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
