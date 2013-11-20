package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseOrderitemPurchase;



public class OrderitemPurchase extends BaseOrderitemPurchase {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OrderitemPurchase () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OrderitemPurchase (de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemPurchasePK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public OrderitemPurchase (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemPurchasePK id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderPurchase orderref,
		java.lang.Integer itemnumber,
		java.lang.String ordernumberSupplier,
		java.lang.Integer orderamount,
		java.lang.String orderunit,
		boolean rejected) {

		super (
			id,
			orderref,
			itemnumber,
			ordernumberSupplier,
			orderamount,
			orderunit,
			rejected);
	}

/*[CONSTRUCTOR MARKER END]*/


}