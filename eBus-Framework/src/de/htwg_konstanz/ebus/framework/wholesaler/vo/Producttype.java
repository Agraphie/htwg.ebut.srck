package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseProducttype;



public class Producttype extends BaseProducttype {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Producttype () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Producttype (java.lang.String code) {
		super(code);
	}

	/**
	 * Constructor for required fields
	 */
	public Producttype (
		java.lang.String code,
		java.lang.String description) {

		super (
			code,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}