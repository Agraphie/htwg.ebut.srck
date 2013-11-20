package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseShipmentitemCustomer;



public class ShipmentitemCustomer extends BaseShipmentitemCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ShipmentitemCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ShipmentitemCustomer (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomerPK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ShipmentitemCustomer (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomerPK id,
		java.lang.String ordernumberCustomer,
		java.lang.Integer shipmentquantity,
		java.lang.String orderunit) {

		super (
			id,
			ordernumberCustomer,
			shipmentquantity,
			orderunit);
	}

/*[CONSTRUCTOR MARKER END]*/


}