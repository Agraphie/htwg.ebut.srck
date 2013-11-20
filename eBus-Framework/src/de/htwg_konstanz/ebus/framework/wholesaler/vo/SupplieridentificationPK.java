package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseSupplieridentificationPK;

public class SupplieridentificationPK extends BaseSupplieridentificationPK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public SupplieridentificationPK () {}
	
	public SupplieridentificationPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier supplier,
		java.lang.String identification) {

		super (
			supplier,
			identification);
	}
/*[CONSTRUCTOR MARKER END]*/


}