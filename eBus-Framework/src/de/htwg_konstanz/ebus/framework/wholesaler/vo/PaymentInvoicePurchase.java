package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BasePaymentInvoicePurchase;



public class PaymentInvoicePurchase extends BasePaymentInvoicePurchase {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PaymentInvoicePurchase () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PaymentInvoicePurchase (
		java.lang.Integer partialpaymentnumber,
		java.lang.String payment,
		java.lang.String invoice,
		java.lang.Integer invoiceitem) {

		super (
			partialpaymentnumber,
			payment,
			invoice,
			invoiceitem);
	}

/*[CONSTRUCTOR MARKER END]*/


}