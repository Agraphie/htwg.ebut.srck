package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BasePaymentreceiptCustomer;



public class PaymentreceiptCustomer extends BasePaymentreceiptCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PaymentreceiptCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PaymentreceiptCustomer (java.lang.String paymentreceiptnumber) {
		super(paymentreceiptnumber);
	}

	/**
	 * Constructor for required fields
	 */
	public PaymentreceiptCustomer (
		java.lang.String paymentreceiptnumber,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Currency currency,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer,
		java.util.Date paymentreceiptdate) {

		super (
			paymentreceiptnumber,
			currency,
			customer,
			paymentreceiptdate);
	}

/*[CONSTRUCTOR MARKER END]*/


}