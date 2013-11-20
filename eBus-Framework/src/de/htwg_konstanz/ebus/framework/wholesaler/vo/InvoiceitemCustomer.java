package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseInvoiceitemCustomer;



public class InvoiceitemCustomer extends BaseInvoiceitemCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public InvoiceitemCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public InvoiceitemCustomer (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemCustomerPK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public InvoiceitemCustomer (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemCustomerPK id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceCustomer invoice,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderCustomer orderref,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoCustomer fulfillmentref,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer shipmentref,
		java.lang.Integer itemnumber,
		java.lang.String ordernumberCustomer,
		java.lang.Integer orderamount,
		java.lang.String orderunit) {

		super (
			id,
			invoice,
			orderref,
			fulfillmentref,
			shipmentref,
			itemnumber,
			ordernumberCustomer,
			orderamount,
			orderunit);
	}

/*[CONSTRUCTOR MARKER END]*/


}