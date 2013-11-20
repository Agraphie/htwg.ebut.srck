package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseInvoiceitemPurchase;



public class InvoiceitemPurchase extends BaseInvoiceitemPurchase {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public InvoiceitemPurchase () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public InvoiceitemPurchase (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemPurchasePK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public InvoiceitemPurchase (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemPurchasePK id,
		java.lang.String orderref,
		java.lang.String fulfillmentref,
		java.lang.String shipmentref,
		java.lang.String ordernumberSupplier,
		java.lang.Integer orderamount,
		java.lang.String orderunit) {

		super (
			id,
			orderref,
			fulfillmentref,
			shipmentref,
			ordernumberSupplier,
			orderamount,
			orderunit);
	}

/*[CONSTRUCTOR MARKER END]*/


}