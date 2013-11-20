package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseCountry;



public class Country extends BaseCountry {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Country () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Country (java.lang.String isocode) {
		super(isocode);
	}

	/**
	 * Constructor for required fields
	 */
	public Country (
		java.lang.String isocode,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Currency currency,
		java.lang.String name) {

		super (
			isocode,
			currency,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/


}