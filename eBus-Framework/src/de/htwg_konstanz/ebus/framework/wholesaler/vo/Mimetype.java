package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseMimetype;



public class Mimetype extends BaseMimetype {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Mimetype () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Mimetype (java.lang.String code) {
		super(code);
	}

	/**
	 * Constructor for required fields
	 */
	public Mimetype (
		java.lang.String code,
		java.lang.String description) {

		super (
			code,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}