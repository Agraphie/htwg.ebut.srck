package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseOrderCustomer;



public class OrderCustomer extends BaseOrderCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OrderCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OrderCustomer (java.lang.String orderid) {
		super(orderid);
	}

	/**
	 * Constructor for required fields
	 */
	public OrderCustomer (
		java.lang.String orderid,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Currency currency,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Address invoiceaddress,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Address deliveryaddress,
		java.util.Date orderdate,
		java.lang.Integer totallineitems,
		boolean rejected,
		boolean splitted) {

		super (
			orderid,
			customer,
			currency,
			invoiceaddress,
			deliveryaddress,
			orderdate,
			totallineitems,
			rejected,
			splitted);
	}

/*[CONSTRUCTOR MARKER END]*/


}