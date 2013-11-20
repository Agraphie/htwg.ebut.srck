package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseOrderinfoSupplier;



public class OrderinfoSupplier extends BaseOrderinfoSupplier {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OrderinfoSupplier () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OrderinfoSupplier (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public OrderinfoSupplier (
		java.lang.Integer id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product,
		java.lang.String orderunit,
		java.lang.String contentunit) {

		super (
			id,
			product,
			orderunit,
			contentunit);
	}

/*[CONSTRUCTOR MARKER END]*/


}