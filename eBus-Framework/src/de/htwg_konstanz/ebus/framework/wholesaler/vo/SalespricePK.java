package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseSalespricePK;

public class SalespricePK extends BaseSalespricePK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public SalespricePK () {}
	
	public SalespricePK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Country country,
		java.lang.Integer lowerboundScaledprice) {

		super (
			product,
			country,
			lowerboundScaledprice);
	}
/*[CONSTRUCTOR MARKER END]*/


}