package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BasePricetype;



public class Pricetype extends BasePricetype {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Pricetype () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Pricetype (java.lang.String code) {
		super(code);
	}

	/**
	 * Constructor for required fields
	 */
	public Pricetype (
		java.lang.String code,
		java.lang.String description) {

		super (
			code,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}