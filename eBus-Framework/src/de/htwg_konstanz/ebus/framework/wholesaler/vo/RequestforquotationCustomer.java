package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseRequestforquotationCustomer;



public class RequestforquotationCustomer extends BaseRequestforquotationCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public RequestforquotationCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public RequestforquotationCustomer (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public RequestforquotationCustomer (
		java.lang.String id,
		java.lang.String customer,
		java.util.Date rfqdate) {

		super (
			id,
			customer,
			rfqdate);
	}

/*[CONSTRUCTOR MARKER END]*/


}