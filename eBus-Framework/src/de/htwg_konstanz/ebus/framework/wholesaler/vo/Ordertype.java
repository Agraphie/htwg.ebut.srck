package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseOrdertype;



public class Ordertype extends BaseOrdertype {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Ordertype () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Ordertype (java.lang.String code) {
		super(code);
	}

	/**
	 * Constructor for required fields
	 */
	public Ordertype (
		java.lang.String code,
		java.lang.String description) {

		super (
			code,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}