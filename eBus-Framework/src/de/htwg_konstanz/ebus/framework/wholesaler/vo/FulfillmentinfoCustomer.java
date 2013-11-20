package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseFulfillmentinfoCustomer;



public class FulfillmentinfoCustomer extends BaseFulfillmentinfoCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FulfillmentinfoCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FulfillmentinfoCustomer (java.lang.String fulfillmentinfoid) {
		super(fulfillmentinfoid);
	}

	/**
	 * Constructor for required fields
	 */
	public FulfillmentinfoCustomer (
		java.lang.String fulfillmentinfoid,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderCustomer orderref,
		java.util.Date fulfillmentinfodate) {

		super (
			fulfillmentinfoid,
			orderref,
			fulfillmentinfodate);
	}

/*[CONSTRUCTOR MARKER END]*/


}