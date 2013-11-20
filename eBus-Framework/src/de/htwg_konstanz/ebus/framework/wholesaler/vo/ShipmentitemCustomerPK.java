package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseShipmentitemCustomerPK;

public class ShipmentitemCustomerPK extends BaseShipmentitemCustomerPK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ShipmentitemCustomerPK () {}
	
	public ShipmentitemCustomerPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer shipment,
		java.lang.Integer itemnumber) {

		super (
			shipment,
			itemnumber);
	}
/*[CONSTRUCTOR MARKER END]*/


}