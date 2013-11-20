package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseReferencetype;



public class Referencetype extends BaseReferencetype {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Referencetype () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Referencetype (java.lang.String code) {
		super(code);
	}

	/**
	 * Constructor for required fields
	 */
	public Referencetype (
		java.lang.String code,
		java.lang.String description) {

		super (
			code,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}