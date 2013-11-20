package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseFulfillmentinfoitemCustomer;



public class FulfillmentinfoitemCustomer extends BaseFulfillmentinfoitemCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FulfillmentinfoitemCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FulfillmentinfoitemCustomer (de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoitemCustomerPK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FulfillmentinfoitemCustomer (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoitemCustomerPK id,
		java.lang.String ordernumberCustomer,
		java.lang.Integer orderamount,
		java.lang.String orderunit) {

		super (
			id,
			ordernumberCustomer,
			orderamount,
			orderunit);
	}

/*[CONSTRUCTOR MARKER END]*/


}