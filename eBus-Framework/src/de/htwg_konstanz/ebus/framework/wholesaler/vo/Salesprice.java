package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseSalesprice;



public class Salesprice extends BaseSalesprice {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Salesprice () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Salesprice (de.htwg_konstanz.ebus.framework.wholesaler.vo.SalespricePK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Salesprice (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.SalespricePK id,
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