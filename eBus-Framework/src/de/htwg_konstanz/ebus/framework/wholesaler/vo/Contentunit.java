package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseContentunit;



public class Contentunit extends BaseContentunit {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Contentunit () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Contentunit (java.lang.String code) {
		super(code);
	}

	/**
	 * Constructor for required fields
	 */
	public Contentunit (
		java.lang.String code,
		java.lang.String description) {

		super (
			code,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}