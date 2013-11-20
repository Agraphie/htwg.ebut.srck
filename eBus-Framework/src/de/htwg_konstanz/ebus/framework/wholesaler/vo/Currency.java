package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseCurrency;



public class Currency extends BaseCurrency {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Currency () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Currency (java.lang.String code) {
		super(code);
	}

	/**
	 * Constructor for required fields
	 */
	public Currency (
		java.lang.String code,
		java.lang.String description) {

		super (
			code,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}