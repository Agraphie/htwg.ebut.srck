package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseOrderitemPurchasePK;

public class OrderitemPurchasePK extends BaseOrderitemPurchasePK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OrderitemPurchasePK () {}
	
	public OrderitemPurchasePK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderPurchase orderref,
		java.lang.Integer itemnumber) {

		super (
			orderref,
			itemnumber);
	}
/*[CONSTRUCTOR MARKER END]*/


}