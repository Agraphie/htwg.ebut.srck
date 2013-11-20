package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BasePaymentPurchase;



public class PaymentPurchase extends BasePaymentPurchase {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PaymentPurchase () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PaymentPurchase (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PaymentPurchase (
		java.lang.String id,
		java.util.Date paymentdate,
		java.lang.String supplier,
		java.lang.String currency) {

		super (
			id,
			paymentdate,
			supplier,
			currency);
	}

/*[CONSTRUCTOR MARKER END]*/


}