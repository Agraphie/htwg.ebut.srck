package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseFulfillmentinfoitemCustomerPK;

public class FulfillmentinfoitemCustomerPK extends BaseFulfillmentinfoitemCustomerPK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FulfillmentinfoitemCustomerPK () {}
	
	public FulfillmentinfoitemCustomerPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoCustomer fulfillmentinfo,
		java.lang.Integer itemnumber) {

		super (
			fulfillmentinfo,
			itemnumber);
	}
/*[CONSTRUCTOR MARKER END]*/


}