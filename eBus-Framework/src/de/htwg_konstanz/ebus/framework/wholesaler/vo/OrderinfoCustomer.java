package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseOrderinfoCustomer;



public class OrderinfoCustomer extends BaseOrderinfoCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OrderinfoCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OrderinfoCustomer (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public OrderinfoCustomer (
		java.lang.Integer id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product,
		java.lang.String orderunit,
		java.lang.String contentunit) {

		super (
			id,
			product,
			orderunit,
			contentunit);
	}

/*[CONSTRUCTOR MARKER END]*/


}