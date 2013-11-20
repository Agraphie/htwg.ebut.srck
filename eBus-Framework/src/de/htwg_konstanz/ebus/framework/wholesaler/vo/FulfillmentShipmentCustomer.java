package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseFulfillmentShipmentCustomer;



public class FulfillmentShipmentCustomer extends BaseFulfillmentShipmentCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FulfillmentShipmentCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FulfillmentShipmentCustomer (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer shipment,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoCustomer fulfillmentinfo) {

		super (
			shipment,
			fulfillmentinfo);
	}

/*[CONSTRUCTOR MARKER END]*/


}