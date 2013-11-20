package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseShipmentitemPurchase;



public class ShipmentitemPurchase extends BaseShipmentitemPurchase {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ShipmentitemPurchase () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ShipmentitemPurchase (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ShipmentitemPurchase (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK id,
		java.lang.String ordernumberSupplier,
		java.lang.Integer shipmentquantity,
		java.lang.String orderunit) {

		super (
			id,
			ordernumberSupplier,
			shipmentquantity,
			orderunit);
	}

/*[CONSTRUCTOR MARKER END]*/


}