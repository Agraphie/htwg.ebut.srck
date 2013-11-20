package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseFulfillmentinfoitemPurchase;



public class FulfillmentinfoitemPurchase extends BaseFulfillmentinfoitemPurchase {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FulfillmentinfoitemPurchase () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FulfillmentinfoitemPurchase (de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoitemPurchasePK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FulfillmentinfoitemPurchase (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoitemPurchasePK id,
		java.lang.String ordernumberSupplier,
		java.lang.Integer orderamount,
		java.lang.String orderunit) {

		super (
			id,
			ordernumberSupplier,
			orderamount,
			orderunit);
	}

/*[CONSTRUCTOR MARKER END]*/


}