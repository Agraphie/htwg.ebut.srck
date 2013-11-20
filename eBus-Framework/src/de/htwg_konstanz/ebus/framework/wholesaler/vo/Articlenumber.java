package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseArticlenumber;



public class Articlenumber extends BaseArticlenumber {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Articlenumber () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Articlenumber (de.htwg_konstanz.ebus.framework.wholesaler.vo.ArticlenumberPK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Articlenumber (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ArticlenumberPK id,
		java.lang.String anumber) {

		super (
			id,
			anumber);
	}

/*[CONSTRUCTOR MARKER END]*/


}