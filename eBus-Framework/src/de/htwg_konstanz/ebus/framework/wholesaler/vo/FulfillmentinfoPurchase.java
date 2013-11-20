package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseFulfillmentinfoPurchase;



public class FulfillmentinfoPurchase extends BaseFulfillmentinfoPurchase {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FulfillmentinfoPurchase () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FulfillmentinfoPurchase (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FulfillmentinfoPurchase (
		java.lang.String id,
		java.util.Date fulfillmentinfodate,
		java.lang.String orderref) {

		super (
			id,
			fulfillmentinfodate,
			orderref);
	}

/*[CONSTRUCTOR MARKER END]*/


}