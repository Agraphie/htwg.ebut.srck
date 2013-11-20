package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseUserSupplier;



public class UserSupplier extends BaseUserSupplier implements IUser {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UserSupplier () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UserSupplier (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public UserSupplier (
		java.lang.Integer id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier supplier,
		java.lang.String lastname) {

		super (
			id,
			supplier,
			lastname);
	}

/*[CONSTRUCTOR MARKER END]*/


}