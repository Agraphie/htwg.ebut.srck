package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BasePaymentreceiptInvoiceCust;



public class PaymentreceiptInvoiceCust extends BasePaymentreceiptInvoiceCust {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PaymentreceiptInvoiceCust () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PaymentreceiptInvoiceCust (de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptInvoiceCustPK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PaymentreceiptInvoiceCust (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptInvoiceCustPK id,
		java.lang.String paymentreceipt,
		java.lang.String invoice,
		java.lang.Integer invoiceitem) {

		super (
			id,
			paymentreceipt,
			invoice,
			invoiceitem);
	}

/*[CONSTRUCTOR MARKER END]*/


}