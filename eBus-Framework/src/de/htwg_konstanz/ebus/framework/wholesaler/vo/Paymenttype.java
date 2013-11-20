package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BasePaymenttype;



public class Paymenttype extends BasePaymenttype {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Paymenttype () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Paymenttype (java.lang.String code) {
		super(code);
	}

	/**
	 * Constructor for required fields
	 */
	public Paymenttype (
		java.lang.String code,
		java.lang.String description) {

		super (
			code,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}