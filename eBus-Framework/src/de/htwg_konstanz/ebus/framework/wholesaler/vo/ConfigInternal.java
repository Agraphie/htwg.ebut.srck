package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseConfigInternal;



public class ConfigInternal extends BaseConfigInternal {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ConfigInternal () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ConfigInternal (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ConfigInternal (
		java.lang.Integer id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Address wholesaleraddress,
		java.lang.Integer marginOnSales,
		java.lang.Integer thresholdReorder,
		java.lang.Integer numberToReorder,
		java.lang.String multimediaDocroot) {

		super (
			id,
			wholesaleraddress,
			marginOnSales,
			thresholdReorder,
			numberToReorder,
			multimediaDocroot);
	}

/*[CONSTRUCTOR MARKER END]*/


}