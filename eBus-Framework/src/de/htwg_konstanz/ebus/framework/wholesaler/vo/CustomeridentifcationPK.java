package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseCustomeridentifcationPK;

public class CustomeridentifcationPK extends BaseCustomeridentifcationPK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CustomeridentifcationPK () {}
	
	public CustomeridentifcationPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer,
		java.lang.String companyidenttype) {

		super (
			customer,
			companyidenttype);
	}
/*[CONSTRUCTOR MARKER END]*/


}