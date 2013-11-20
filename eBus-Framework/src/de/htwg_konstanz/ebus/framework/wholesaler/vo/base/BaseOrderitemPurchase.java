package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the orderitem_purchase table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="orderitem_purchase"
 */

public abstract class BaseOrderitemPurchase  implements Serializable {

	public static String REF = "OrderitemPurchase";
	public static String PROP_NO_CU_PER_OU = "NoCuPerOu";
	public static String PROP_ORDERREF = "Orderref";
	public static String PROP_TAXAMOUNT = "Taxamount";
	public static String PROP_CONTENTUNIT = "Contentunit";
	public static String PROP_INTERNATIONALRESTRICTIONS = "Internationalrestrictions";
	public static String PROP_ORDERNUMBER_SUPPLIER = "OrdernumberSupplier";
	public static String PROP_PRICEQUANTITY = "Pricequantity";
	public static String PROP_REJECTED = "rejected";
	public static String PROP_PRICETYPE = "Pricetype";
	public static String PROP_PRODUCTDESCRIPTION = "Productdescription";
	public static String PROP_TAXRATE = "Taxrate";
	public static String PROP_DELIVERYADDRESS = "Deliveryaddress";
	public static String PROP_PARTIALSHIPMENT = "Partialshipment";
	public static String PROP_TRANSPORT = "Transport";
	public static String PROP_ORDERAMOUNT = "Orderamount";
	public static String PROP_SPECIALTREATMENT = "Specialtreatment";
	public static String PROP_ITEMNUMBER = "Itemnumber";
	public static String PROP_ORDERUNIT = "Orderunit";
	public static String PROP_ID = "Id";
	public static String PROP_REMARK = "Remark";
	public static String PROP_ITEMPRICE = "Itemprice";
	public static String PROP_UNITPRICE = "Unitprice";


	// constructors
	public BaseOrderitemPurchase () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrderitemPurchase (de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemPurchasePK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseOrderitemPurchase (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemPurchasePK id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderPurchase orderref,
		java.lang.Integer itemnumber,
		java.lang.String ordernumberSupplier,
		java.lang.Integer orderamount,
		java.lang.String orderunit,
		boolean rejected) {

		this.setId(id);
		this.setOrderref(orderref);
		this.setItemnumber(itemnumber);
		this.setOrdernumberSupplier(ordernumberSupplier);
		this.setOrderamount(orderamount);
		this.setOrderunit(orderunit);
		this.setRejected(rejected);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemPurchasePK id;

	// fields
	private java.lang.Integer itemnumber;
	private java.lang.String ordernumberSupplier;
	private java.lang.String productdescription;
	private java.lang.Integer orderamount;
	private java.lang.String orderunit;
	private java.lang.String contentunit;
	private java.lang.Integer noCuPerOu;
	private java.math.BigDecimal unitprice;
	private java.math.BigDecimal itemprice;
	private java.lang.String pricetype;
	private java.lang.Integer pricequantity;
	private java.math.BigDecimal taxrate;
	private java.math.BigDecimal taxamount;
	private java.lang.Integer partialshipment;
	private java.lang.String transport;
	private java.lang.String specialtreatment;
	private java.lang.String internationalrestrictions;
	private java.lang.String remark;
	private boolean rejected;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderPurchase orderref;
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Address deliveryaddress;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemPurchasePK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemPurchasePK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: itemnumber
	 */
	public java.lang.Integer getItemnumber () {
		return itemnumber;
	}

	/**
	 * Set the value related to the column: itemnumber
	 * @param itemnumber the itemnumber value
	 */
	public void setItemnumber (java.lang.Integer itemnumber) {
		this.itemnumber = itemnumber;
	}



	/**
	 * Return the value associated with the column: ordernumber_supplier
	 */
	public java.lang.String getOrdernumberSupplier () {
		return ordernumberSupplier;
	}

	/**
	 * Set the value related to the column: ordernumber_supplier
	 * @param ordernumberSupplier the ordernumber_supplier value
	 */
	public void setOrdernumberSupplier (java.lang.String ordernumberSupplier) {
		this.ordernumberSupplier = ordernumberSupplier;
	}



	/**
	 * Return the value associated with the column: productdescription
	 */
	public java.lang.String getProductdescription () {
		return productdescription;
	}

	/**
	 * Set the value related to the column: productdescription
	 * @param productdescription the productdescription value
	 */
	public void setProductdescription (java.lang.String productdescription) {
		this.productdescription = productdescription;
	}



	/**
	 * Return the value associated with the column: orderamount
	 */
	public java.lang.Integer getOrderamount () {
		return orderamount;
	}

	/**
	 * Set the value related to the column: orderamount
	 * @param orderamount the orderamount value
	 */
	public void setOrderamount (java.lang.Integer orderamount) {
		this.orderamount = orderamount;
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
	 * Return the value associated with the column: unitprice
	 */
	public java.math.BigDecimal getUnitprice () {
		return unitprice;
	}

	/**
	 * Set the value related to the column: unitprice
	 * @param unitprice the unitprice value
	 */
	public void setUnitprice (java.math.BigDecimal unitprice) {
		this.unitprice = unitprice;
	}



	/**
	 * Return the value associated with the column: itemprice
	 */
	public java.math.BigDecimal getItemprice () {
		return itemprice;
	}

	/**
	 * Set the value related to the column: itemprice
	 * @param itemprice the itemprice value
	 */
	public void setItemprice (java.math.BigDecimal itemprice) {
		this.itemprice = itemprice;
	}



	/**
	 * Return the value associated with the column: pricetype
	 */
	public java.lang.String getPricetype () {
		return pricetype;
	}

	/**
	 * Set the value related to the column: pricetype
	 * @param pricetype the pricetype value
	 */
	public void setPricetype (java.lang.String pricetype) {
		this.pricetype = pricetype;
	}



	/**
	 * Return the value associated with the column: pricequantity
	 */
	public java.lang.Integer getPricequantity () {
		return pricequantity;
	}

	/**
	 * Set the value related to the column: pricequantity
	 * @param pricequantity the pricequantity value
	 */
	public void setPricequantity (java.lang.Integer pricequantity) {
		this.pricequantity = pricequantity;
	}



	/**
	 * Return the value associated with the column: taxrate
	 */
	public java.math.BigDecimal getTaxrate () {
		return taxrate;
	}

	/**
	 * Set the value related to the column: taxrate
	 * @param taxrate the taxrate value
	 */
	public void setTaxrate (java.math.BigDecimal taxrate) {
		this.taxrate = taxrate;
	}



	/**
	 * Return the value associated with the column: taxamount
	 */
	public java.math.BigDecimal getTaxamount () {
		return taxamount;
	}

	/**
	 * Set the value related to the column: taxamount
	 * @param taxamount the taxamount value
	 */
	public void setTaxamount (java.math.BigDecimal taxamount) {
		this.taxamount = taxamount;
	}



	/**
	 * Return the value associated with the column: partialshipment
	 */
	public java.lang.Integer getPartialshipment () {
		return partialshipment;
	}

	/**
	 * Set the value related to the column: partialshipment
	 * @param partialshipment the partialshipment value
	 */
	public void setPartialshipment (java.lang.Integer partialshipment) {
		this.partialshipment = partialshipment;
	}



	/**
	 * Return the value associated with the column: transport
	 */
	public java.lang.String getTransport () {
		return transport;
	}

	/**
	 * Set the value related to the column: transport
	 * @param transport the transport value
	 */
	public void setTransport (java.lang.String transport) {
		this.transport = transport;
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
	 * Return the value associated with the column: is_rejected
	 */
	public boolean isRejected () {
		return rejected;
	}

	/**
	 * Set the value related to the column: is_rejected
	 * @param rejected the is_rejected value
	 */
	public void setRejected (boolean rejected) {
		this.rejected = rejected;
	}



	/**
	 * Return the value associated with the column: orderref
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderPurchase getOrderref () {
		return orderref;
	}

	/**
	 * Set the value related to the column: orderref
	 * @param orderref the orderref value
	 */
	public void setOrderref (de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderPurchase orderref) {
		this.orderref = orderref;
	}



	/**
	 * Return the value associated with the column: deliveryaddress
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Address getDeliveryaddress () {
		return deliveryaddress;
	}

	/**
	 * Set the value related to the column: deliveryaddress
	 * @param deliveryaddress the deliveryaddress value
	 */
	public void setDeliveryaddress (de.htwg_konstanz.ebus.framework.wholesaler.vo.Address deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemPurchase)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemPurchase orderitemPurchase = (de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemPurchase) obj;
			if (null == this.getId() || null == orderitemPurchase.getId()) return false;
			else return (this.getId().equals(orderitemPurchase.getId()));
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