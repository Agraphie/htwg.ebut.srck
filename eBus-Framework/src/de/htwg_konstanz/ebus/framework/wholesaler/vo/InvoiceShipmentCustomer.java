package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseInvoiceShipmentCustomer;



public class InvoiceShipmentCustomer extends BaseInvoiceShipmentCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public InvoiceShipmentCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public InvoiceShipmentCustomer (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer shipment,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceCustomer invoice) {

		super (
			shipment,
			invoice);
	}

/*[CONSTRUCTOR MARKER END]*/


}