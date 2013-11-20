package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseUserInternal;



public class UserInternal extends BaseUserInternal implements IUser {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UserInternal () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UserInternal (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public UserInternal (
		java.lang.Integer id,
		java.lang.String lastname) {

		super (
			id,
			lastname);
	}

/*[CONSTRUCTOR MARKER END]*/


}