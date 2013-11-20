package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseCustomer;



public class Customer extends BaseCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Customer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Customer (java.lang.String customerid) {
		super(customerid);
	}

	/**
	 * Constructor for required fields
	 */
	public Customer (
		java.lang.String customerid,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Address address,
		java.lang.String companyname,
		java.lang.String firstname,
		java.lang.String lastname,
		java.lang.String wsUserName,
		java.lang.String wsPassword,
		java.lang.String wsDeliveryEndpoint,
		java.lang.String wsInvoiceEndpoint) {

		super (
			customerid,
			address,
			companyname,
			firstname,
			lastname,
			wsUserName,
			wsPassword,
			wsDeliveryEndpoint,
			wsInvoiceEndpoint);
	}

/*[CONSTRUCTOR MARKER END]*/


}