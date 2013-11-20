package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseOrderitemCustomer;



public class OrderitemCustomer extends BaseOrderitemCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OrderitemCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OrderitemCustomer (de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemCustomerPK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public OrderitemCustomer (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemCustomerPK id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderCustomer orderref,
		java.lang.Integer itemnumber,
		java.lang.String ordernumberCustomer,
		java.lang.Integer orderamount,
		java.lang.String orderunit,
		boolean rejected) {

		super (
			id,
			orderref,
			itemnumber,
			ordernumberCustomer,
			orderamount,
			orderunit,
			rejected);
	}

/*[CONSTRUCTOR MARKER END]*/


}