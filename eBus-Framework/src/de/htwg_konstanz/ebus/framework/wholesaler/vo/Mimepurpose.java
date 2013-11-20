package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseMimepurpose;



public class Mimepurpose extends BaseMimepurpose {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Mimepurpose () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Mimepurpose (java.lang.String code) {
		super(code);
	}

	/**
	 * Constructor for required fields
	 */
	public Mimepurpose (
		java.lang.String code,
		java.lang.String description) {

		super (
			code,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}