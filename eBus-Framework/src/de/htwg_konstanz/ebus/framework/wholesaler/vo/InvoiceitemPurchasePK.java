package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseInvoiceitemPurchasePK;

public class InvoiceitemPurchasePK extends BaseInvoiceitemPurchasePK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public InvoiceitemPurchasePK () {}
	
	public InvoiceitemPurchasePK (
		java.lang.Integer itemnumber,
		java.lang.String invoice) {

		super (
			itemnumber,
			invoice);
	}
/*[CONSTRUCTOR MARKER END]*/


}