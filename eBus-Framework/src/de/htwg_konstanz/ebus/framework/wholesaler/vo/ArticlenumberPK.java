package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseArticlenumberPK;

public class ArticlenumberPK extends BaseArticlenumberPK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ArticlenumberPK () {}
	
	public ArticlenumberPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Articlenumbertype articlenumbertype) {

		super (
			product,
			articlenumbertype);
	}
/*[CONSTRUCTOR MARKER END]*/


}