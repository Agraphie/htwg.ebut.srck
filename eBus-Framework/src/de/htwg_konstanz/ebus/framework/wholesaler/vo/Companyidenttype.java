package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseCompanyidenttype;



public class Companyidenttype extends BaseCompanyidenttype {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Companyidenttype () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Companyidenttype (java.lang.String companyidenttype) {
		super(companyidenttype);
	}

	/**
	 * Constructor for required fields
	 */
	public Companyidenttype (
		java.lang.String companyidenttype,
		java.lang.String description) {

		super (
			companyidenttype,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}