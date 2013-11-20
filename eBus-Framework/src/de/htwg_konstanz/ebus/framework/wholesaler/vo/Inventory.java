package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseInventory;



public class Inventory extends BaseInventory {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Inventory () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Inventory (java.lang.Integer product) {
		super(product);
	}

/*[CONSTRUCTOR MARKER END]*/


}