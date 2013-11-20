package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseActiveconfigInternal;



public class ActiveconfigInternal extends BaseActiveconfigInternal {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ActiveconfigInternal () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ActiveconfigInternal (java.lang.Integer config) {
		super(config);
	}

	/**
	 * Constructor for required fields
	 */
	public ActiveconfigInternal (
		java.lang.Integer config,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ConfigInternal configInternal) {

		super (
			config,
			configInternal);
	}

/*[CONSTRUCTOR MARKER END]*/


}