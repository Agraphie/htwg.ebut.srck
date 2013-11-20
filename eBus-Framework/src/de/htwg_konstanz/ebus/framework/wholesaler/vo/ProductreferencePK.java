package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseProductreferencePK;

public class ProductreferencePK extends BaseProductreferencePK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ProductreferencePK () {}
	
	public ProductreferencePK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Product referencedproduct) {

		super (
			product,
			referencedproduct);
	}
/*[CONSTRUCTOR MARKER END]*/


}