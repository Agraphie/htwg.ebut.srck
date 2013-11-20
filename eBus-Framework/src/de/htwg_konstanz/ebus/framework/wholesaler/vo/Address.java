package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseAddress;



public class Address extends BaseAddress {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Address () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Address (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Address (
		java.lang.String id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Country country,
		java.lang.String street,
		java.lang.String zipcode,
		java.lang.String city) {

		super (
			id,
			country,
			street,
			zipcode,
			city);
	}

/*[CONSTRUCTOR MARKER END]*/


}