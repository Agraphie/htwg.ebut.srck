package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BasePurchaseprice;



public class Purchaseprice extends BasePurchaseprice {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Purchaseprice () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Purchaseprice (de.htwg_konstanz.ebus.framework.wholesaler.vo.PurchasepricePK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Purchaseprice (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.PurchasepricePK id,
		java.lang.String pricetype,
		java.math.BigDecimal taxrate,
		java.math.BigDecimal amount) {

		super (
			id,
			pricetype,
			taxrate,
			amount);
	}

/*[CONSTRUCTOR MARKER END]*/


}