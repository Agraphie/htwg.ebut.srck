package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseUserCustomer;



public class UserCustomer extends BaseUserCustomer implements IUser {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UserCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UserCustomer (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public UserCustomer (
		java.lang.Integer id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer,
		java.lang.String lastname) {

		super (
			id,
			customer,
			lastname);
	}

/*[CONSTRUCTOR MARKER END]*/


}