package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the multimediadocument_product table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="multimediadocument_product"
 */

public abstract class BaseMultimediadocumentProduct  implements Serializable {

	public static String REF = "MultimediadocumentProduct";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ISURI = "Isuri";
	public static String PROP_PRODUCT = "Product";
	public static String PROP_ID = "Id";
	public static String PROP_PURPOSE = "Purpose";
	public static String PROP_MIMETYPE = "Mimetype";
	public static String PROP_REMARK = "Remark";
	public static String PROP_URL_OR_RELATIVEFILEPATH = "UrlOrRelativefilepath";


	// constructors
	public BaseMultimediadocumentProduct () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMultimediadocumentProduct (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMultimediadocumentProduct (
		java.lang.Integer id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product,
		java.lang.String mimetype,
		java.lang.String urlOrRelativefilepath,
		java.lang.String purpose) {

		this.setId(id);
		this.setProduct(product);
		this.setMimetype(mimetype);
		this.setUrlOrRelativefilepath(urlOrRelativefilepath);
		this.setPurpose(purpose);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String mimetype;
	private java.lang.String urlOrRelativefilepath;
	private java.lang.Integer isuri;
	private java.lang.String purpose;
	private java.lang.String description;
	private java.lang.String remark;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: mimetype
	 */
	public java.lang.String getMimetype () {
		return mimetype;
	}

	/**
	 * Set the value related to the column: mimetype
	 * @param mimetype the mimetype value
	 */
	public void setMimetype (java.lang.String mimetype) {
		this.mimetype = mimetype;
	}



	/**
	 * Return the value associated with the column: url_or_relativefilepath
	 */
	public java.lang.String getUrlOrRelativefilepath () {
		return urlOrRelativefilepath;
	}

	/**
	 * Set the value related to the column: url_or_relativefilepath
	 * @param urlOrRelativefilepath the url_or_relativefilepath value
	 */
	public void setUrlOrRelativefilepath (java.lang.String urlOrRelativefilepath) {
		this.urlOrRelativefilepath = urlOrRelativefilepath;
	}



	/**
	 * Return the value associated with the column: isuri
	 */
	public java.lang.Integer getIsuri () {
		return isuri;
	}

	/**
	 * Set the value related to the column: isuri
	 * @param isuri the isuri value
	 */
	public void setIsuri (java.lang.Integer isuri) {
		this.isuri = isuri;
	}



	/**
	 * Return the value associated with the column: purpose
	 */
	public java.lang.String getPurpose () {
		return purpose;
	}

	/**
	 * Set the value related to the column: purpose
	 * @param purpose the purpose value
	 */
	public void setPurpose (java.lang.String purpose) {
		this.purpose = purpose;
	}



	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: product
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Product getProduct () {
		return product;
	}

	/**
	 * Set the value related to the column: product
	 * @param product the product value
	 */
	public void setProduct (de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product) {
		this.product = product;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.MultimediadocumentProduct)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.MultimediadocumentProduct multimediadocumentProduct = (de.htwg_konstanz.ebus.framework.wholesaler.vo.MultimediadocumentProduct) obj;
			if (null == this.getId() || null == multimediadocumentProduct.getId()) return false;
			else return (this.getId().equals(multimediadocumentProduct.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}