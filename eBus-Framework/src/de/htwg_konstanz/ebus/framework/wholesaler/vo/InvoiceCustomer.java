package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseInvoiceCustomer;



public class InvoiceCustomer extends BaseInvoiceCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public InvoiceCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public InvoiceCustomer (java.lang.String invoiceid) {
		super(invoiceid);
	}

	/**
	 * Constructor for required fields
	 */
	public InvoiceCustomer (
		java.lang.String invoiceid,
		java.util.Date invoicedate) {

		super (
			invoiceid,
			invoicedate);
	}

/*[CONSTRUCTOR MARKER END]*/


}