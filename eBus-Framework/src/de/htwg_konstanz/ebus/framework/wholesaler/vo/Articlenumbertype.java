package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseArticlenumbertype;



public class Articlenumbertype extends BaseArticlenumbertype {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Articlenumbertype () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Articlenumbertype (java.lang.String articlenumbertype) {
		super(articlenumbertype);
	}

	/**
	 * Constructor for required fields
	 */
	public Articlenumbertype (
		java.lang.String articlenumbertype,
		java.lang.String description) {

		super (
			articlenumbertype,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}