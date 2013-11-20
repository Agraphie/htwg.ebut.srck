package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseSupplier;



public class Supplier extends BaseSupplier {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Supplier () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Supplier (java.lang.String suppliernumber) {
		super(suppliernumber);
	}

	/**
	 * Constructor for required fields
	 */
	public Supplier (
		java.lang.String suppliernumber,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Address address,
		java.lang.String companyname) {

		super (
			suppliernumber,
			address,
			companyname);
	}

/*[CONSTRUCTOR MARKER END]*/


}