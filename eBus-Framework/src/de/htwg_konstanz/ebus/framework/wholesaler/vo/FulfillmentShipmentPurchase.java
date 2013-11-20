package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseFulfillmentShipmentPurchase;



public class FulfillmentShipmentPurchase extends BaseFulfillmentShipmentPurchase {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FulfillmentShipmentPurchase () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FulfillmentShipmentPurchase (
		java.lang.String shipment,
		java.lang.String fulfillmentinfo) {

		super (
			shipment,
			fulfillmentinfo);
	}

/*[CONSTRUCTOR MARKER END]*/


}