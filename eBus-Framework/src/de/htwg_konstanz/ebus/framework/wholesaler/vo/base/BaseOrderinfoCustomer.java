package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the orderinfo_customer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="orderinfo_customer"
 */

public abstract class BaseOrderinfoCustomer  implements Serializable {

	public static String REF = "OrderinfoCustomer";
	public static String PROP_DELIVERYDAYS = "Deliverydays";
	public static String PROP_MAXORDERQUANTITY = "Maxorderquantity";
	public static String PROP_NO_CU_PER_OU = "NoCuPerOu";
	public static String PROP_PRODUCT = "Product";
	public static String PROP_SPECIALTREATMENT = "Specialtreatment";
	public static String PROP_CONTENTUNIT = "Contentunit";
	public static String PROP_INTERNATIONALRESTRICTIONS = "Internationalrestrictions";
	public static String PROP_ORDERUNIT = "Orderunit";
	public static String PROP_ID = "Id";
	public static String PROP_ORDERQUANTITYINTERVAL = "Orderquantityinterval";
	public static String PROP_MINORDERQUANTITY = "Minorderquantity";


	// constructors
	public BaseOrderinfoCustomer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrderinfoCustomer (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseOrderinfoCustomer (
		java.lang.Integer id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product,
		java.lang.String orderunit,
		java.lang.String contentunit) {

		this.setId(id);
		this.setProduct(product);
		this.setOrderunit(orderunit);
		this.setContentunit(contentunit);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String orderunit;
	private java.lang.String contentunit;
	private java.lang.Integer noCuPerOu;
	private java.lang.Integer minorderquantity;
	private java.lang.Integer maxorderquantity;
	private java.lang.Integer orderquantityinterval;
	private java.lang.Integer deliverydays;
	private java.lang.String specialtreatment;
	private java.lang.String internationalrestrictions;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="product"
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
	 * Return the value associated with the column: orderunit
	 */
	public java.lang.String getOrderunit () {
		return orderunit;
	}

	/**
	 * Set the value related to the column: orderunit
	 * @param orderunit the orderunit value
	 */
	public void setOrderunit (java.lang.String orderunit) {
		this.orderunit = orderunit;
	}



	/**
	 * Return the value associated with the column: contentunit
	 */
	public java.lang.String getContentunit () {
		return contentunit;
	}

	/**
	 * Set the value related to the column: contentunit
	 * @param contentunit the contentunit value
	 */
	public void setContentunit (java.lang.String contentunit) {
		this.contentunit = contentunit;
	}



	/**
	 * Return the value associated with the column: no_cu_per_ou
	 */
	public java.lang.Integer getNoCuPerOu () {
		return noCuPerOu;
	}

	/**
	 * Set the value related to the column: no_cu_per_ou
	 * @param noCuPerOu the no_cu_per_ou value
	 */
	public void setNoCuPerOu (java.lang.Integer noCuPerOu) {
		this.noCuPerOu = noCuPerOu;
	}



	/**
	 * Return the value associated with the column: minorderquantity
	 */
	public java.lang.Integer getMinorderquantity () {
		return minorderquantity;
	}

	/**
	 * Set the value related to the column: minorderquantity
	 * @param minorderquantity the minorderquantity value
	 */
	public void setMinorderquantity (java.lang.Integer minorderquantity) {
		this.minorderquantity = minorderquantity;
	}



	/**
	 * Return the value associated with the column: maxorderquantity
	 */
	public java.lang.Integer getMaxorderquantity () {
		return maxorderquantity;
	}

	/**
	 * Set the value related to the column: maxorderquantity
	 * @param maxorderquantity the maxorderquantity value
	 */
	public void setMaxorderquantity (java.lang.Integer maxorderquantity) {
		this.maxorderquantity = maxorderquantity;
	}



	/**
	 * Return the value associated with the column: orderquantityinterval
	 */
	public java.lang.Integer getOrderquantityinterval () {
		return orderquantityinterval;
	}

	/**
	 * Set the value related to the column: orderquantityinterval
	 * @param orderquantityinterval the orderquantityinterval value
	 */
	public void setOrderquantityinterval (java.lang.Integer orderquantityinterval) {
		this.orderquantityinterval = orderquantityinterval;
	}



	/**
	 * Return the value associated with the column: deliverydays
	 */
	public java.lang.Integer getDeliverydays () {
		return deliverydays;
	}

	/**
	 * Set the value related to the column: deliverydays
	 * @param deliverydays the deliverydays value
	 */
	public void setDeliverydays (java.lang.Integer deliverydays) {
		this.deliverydays = deliverydays;
	}



	/**
	 * Return the value associated with the column: specialtreatment
	 */
	public java.lang.String getSpecialtreatment () {
		return specialtreatment;
	}

	/**
	 * Set the value related to the column: specialtreatment
	 * @param specialtreatment the specialtreatment value
	 */
	public void setSpecialtreatment (java.lang.String specialtreatment) {
		this.specialtreatment = specialtreatment;
	}



	/**
	 * Return the value associated with the column: internationalrestrictions
	 */
	public java.lang.String getInternationalrestrictions () {
		return internationalrestrictions;
	}

	/**
	 * Set the value related to the column: internationalrestrictions
	 * @param internationalrestrictions the internationalrestrictions value
	 */
	public void setInternationalrestrictions (java.lang.String internationalrestrictions) {
		this.internationalrestrictions = internationalrestrictions;
	}



	/**
	 * Return the value associated with the column: materialnumber
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Product getProduct () {
		return product;
	}

	/**
	 * Set the value related to the column: materialnumber
	 * @param product the materialnumber value
	 */
	public void setProduct (de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product) {
		this.product = product;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderinfoCustomer)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderinfoCustomer orderinfoCustomer = (de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderinfoCustomer) obj;
			if (null == this.getId() || null == orderinfoCustomer.getId()) return false;
			else return (this.getId().equals(orderinfoCustomer.getId()));
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