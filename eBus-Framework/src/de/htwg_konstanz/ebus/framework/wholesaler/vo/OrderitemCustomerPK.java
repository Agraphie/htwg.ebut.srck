package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseOrderitemCustomerPK;

public class OrderitemCustomerPK extends BaseOrderitemCustomerPK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OrderitemCustomerPK () {}
	
	public OrderitemCustomerPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderCustomer orderref,
		java.lang.Integer itemnumber) {

		super (
			orderref,
			itemnumber);
	}
/*[CONSTRUCTOR MARKER END]*/


}