package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseProductstatus;



public class Productstatus extends BaseProductstatus {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Productstatus () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Productstatus (java.lang.String code) {
		super(code);
	}

	/**
	 * Constructor for required fields
	 */
	public Productstatus (
		java.lang.String code,
		java.lang.String description) {

		super (
			code,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}