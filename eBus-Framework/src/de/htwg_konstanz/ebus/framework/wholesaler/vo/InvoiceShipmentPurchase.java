package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseInvoiceShipmentPurchase;



public class InvoiceShipmentPurchase extends BaseInvoiceShipmentPurchase {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public InvoiceShipmentPurchase () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public InvoiceShipmentPurchase (
		java.lang.String shipment,
		java.lang.String invoice) {

		super (
			shipment,
			invoice);
	}

/*[CONSTRUCTOR MARKER END]*/


}