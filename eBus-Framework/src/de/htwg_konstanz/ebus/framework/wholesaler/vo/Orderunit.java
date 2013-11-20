package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseOrderunit;



public class Orderunit extends BaseOrderunit {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Orderunit () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Orderunit (java.lang.String code) {
		super(code);
	}

	/**
	 * Constructor for required fields
	 */
	public Orderunit (
		java.lang.String code,
		java.lang.String description) {

		super (
			code,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}