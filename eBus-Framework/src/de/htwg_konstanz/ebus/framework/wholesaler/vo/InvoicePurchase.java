package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseInvoicePurchase;



public class InvoicePurchase extends BaseInvoicePurchase {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public InvoicePurchase () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public InvoicePurchase (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public InvoicePurchase (
		java.lang.String id,
		java.util.Date invoicedate) {

		super (
			id,
			invoicedate);
	}

/*[CONSTRUCTOR MARKER END]*/


}