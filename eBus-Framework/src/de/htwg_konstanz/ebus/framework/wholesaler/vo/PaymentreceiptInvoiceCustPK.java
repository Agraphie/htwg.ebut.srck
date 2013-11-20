package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BasePaymentreceiptInvoiceCustPK;

public class PaymentreceiptInvoiceCustPK extends BasePaymentreceiptInvoiceCustPK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PaymentreceiptInvoiceCustPK () {}
	
	public PaymentreceiptInvoiceCustPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptCustomer paymentreceiptCustomer,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemCustomer invoiceitemCustomer,
		java.lang.Integer partialpaymentnumber) {

		super (
			paymentreceiptCustomer,
			invoiceitemCustomer,
			partialpaymentnumber);
	}
/*[CONSTRUCTOR MARKER END]*/


}