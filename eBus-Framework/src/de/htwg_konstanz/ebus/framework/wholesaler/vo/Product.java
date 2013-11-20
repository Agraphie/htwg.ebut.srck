package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseProduct;



public class Product extends BaseProduct {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Product () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Product (java.lang.Integer materialnumber) {
		super(materialnumber);
	}

	/**
	 * Constructor for required fields
	 */
	public Product (
		java.lang.Integer materialnumber,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier supplier,
		java.lang.String ordernumberSupplier,
		java.lang.String shortdescription,
		java.lang.String ordernumberCustomer) {

		super (
			materialnumber,
			supplier,
			ordernumberSupplier,
			shortdescription,
			ordernumberCustomer);
	}

/*[CONSTRUCTOR MARKER END]*/


}