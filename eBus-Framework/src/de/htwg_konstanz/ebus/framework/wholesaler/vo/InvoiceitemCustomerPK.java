package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseInvoiceitemCustomerPK;

public class InvoiceitemCustomerPK extends BaseInvoiceitemCustomerPK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public InvoiceitemCustomerPK () {}
	
	public InvoiceitemCustomerPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceCustomer invoice,
		java.lang.Integer itemnumber) {

		super (
			invoice,
			itemnumber);
	}
/*[CONSTRUCTOR MARKER END]*/


}