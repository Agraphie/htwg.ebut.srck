package de.htwg_konstanz.ebus.framework.wholesaler.vo;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseMultimediadocumentProduct;



public class MultimediadocumentProduct extends BaseMultimediadocumentProduct {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MultimediadocumentProduct () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MultimediadocumentProduct (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MultimediadocumentProduct (
		java.lang.Integer id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product,
		java.lang.String mimetype,
		java.lang.String urlOrRelativefilepath,
		java.lang.String purpose) {

		super (
			id,
			product,
			mimetype,
			urlOrRelativefilepath,
			purpose);
	}

/*[CONSTRUCTOR MARKER END]*/


}