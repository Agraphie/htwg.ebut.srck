package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseOrderPurchase;



public class OrderPurchase extends BaseOrderPurchase {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OrderPurchase () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OrderPurchase (java.lang.String orderid) {
		super(orderid);
	}

	/**
	 * Constructor for required fields
	 */
	public OrderPurchase (
		java.lang.String orderid,
		java.util.Date orderdate,
		java.lang.Integer totallineitems,
		boolean rejected) {

		super (
			orderid,
			orderdate,
			totallineitems,
			rejected);
	}

/*[CONSTRUCTOR MARKER END]*/


}