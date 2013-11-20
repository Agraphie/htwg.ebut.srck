package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fulfillmentinfo_purchase table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fulfillmentinfo_purchase"
 */

public abstract class BaseFulfillmentinfoPurchase  implements Serializable {

	public static String REF = "FulfillmentinfoPurchase";
	public static String PROP_INVOICEADDRESS = "Invoiceaddress";
	public static String PROP_ORDERREF = "Orderref";
	public static String PROP_TAXAMOUNT = "Taxamount";
	public static String PROP_FULFILLMENTINFOID_SUPPLIER = "FulfillmentinfoidSupplier";
	public static String PROP_INTERNATIONALRESTRICTIONS = "Internationalrestrictions";
	public static String PROP_PRICETOTAL_NET = "PricetotalNet";
	public static String PROP_TOTALLINEITEMS = "Totallineitems";
	public static String PROP_PRICETOTAL_GROSS = "PricetotalGross";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_DELIVERYADDRESS = "Deliveryaddress";
	public static String PROP_PARTIALSHIPMENT = "Partialshipment";
	public static String PROP_TAXTOTAL = "Taxtotal";
	public static String PROP_ORDERDATE = "Orderdate";
	public static String PROP_TRANSPORT = "Transport";
	public static String PROP_SPECIALTREATMENT = "Specialtreatment";
	public static String PROP_ID = "Id";
	public static String PROP_FULFILLMENTINFODATE = "Fulfillmentinfodate";
	public static String PROP_ORDERID_SUPPLIER = "OrderidSupplier";
	public static String PROP_REMARK = "Remark";
	public static String PROP_CURRENCY = "Currency";
	public static String PROP_ORDERTYPE = "Ordertype";


	// constructors
	public BaseFulfillmentinfoPurchase () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFulfillmentinfoPurchase (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFulfillmentinfoPurchase (
		java.lang.String id,
		java.util.Date fulfillmentinfodate,
		java.lang.String orderref) {

		this.setId(id);
		this.setFulfillmentinfodate(fulfillmentinfodate);
		this.setOrderref(orderref);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.util.Date fulfillmentinfodate;
	private java.lang.String supplier;
	private java.lang.String fulfillmentinfoidSupplier;
	private java.lang.String orderref;
	private java.util.Date orderdate;
	private java.lang.String ordertype;
	private java.lang.String orderidSupplier;
	private java.lang.String invoiceaddress;
	private java.lang.String deliveryaddress;
	private java.lang.String currency;
	private java.lang.String remark;
	private java.lang.Integer partialshipment;
	private java.lang.String transport;
	private java.lang.String specialtreatment;
	private java.lang.String internationalrestrictions;
	private java.math.BigDecimal pricetotalNet;
	private java.math.BigDecimal pricetotalGross;
	private java.math.BigDecimal taxtotal;
	private java.math.BigDecimal taxamount;
	private java.lang.Integer totallineitems;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.Assigned"
     *  column="fulfillmentinfoid"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: fulfillmentinfodate
	 */
	public java.util.Date getFulfillmentinfodate () {
		return fulfillmentinfodate;
	}

	/**
	 * Set the value related to the column: fulfillmentinfodate
	 * @param fulfillmentinfodate the fulfillmentinfodate value
	 */
	public void setFulfillmentinfodate (java.util.Date fulfillmentinfodate) {
		this.fulfillmentinfodate = fulfillmentinfodate;
	}



	/**
	 * Return the value associated with the column: supplier
	 */
	public java.lang.String getSupplier () {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier
	 * @param supplier the supplier value
	 */
	public void setSupplier (java.lang.String supplier) {
		this.supplier = supplier;
	}



	/**
	 * Return the value associated with the column: fulfillmentinfoid_supplier
	 */
	public java.lang.String getFulfillmentinfoidSupplier () {
		return fulfillmentinfoidSupplier;
	}

	/**
	 * Set the value related to the column: fulfillmentinfoid_supplier
	 * @param fulfillmentinfoidSupplier the fulfillmentinfoid_supplier value
	 */
	public void setFulfillmentinfoidSupplier (java.lang.String fulfillmentinfoidSupplier) {
		this.fulfillmentinfoidSupplier = fulfillmentinfoidSupplier;
	}



	/**
	 * Return the value associated with the column: orderref
	 */
	public java.lang.String getOrderref () {
		return orderref;
	}

	/**
	 * Set the value related to the column: orderref
	 * @param orderref the orderref value
	 */
	public void setOrderref (java.lang.String orderref) {
		this.orderref = orderref;
	}



	/**
	 * Return the value associated with the column: orderdate
	 */
	public java.util.Date getOrderdate () {
		return orderdate;
	}

	/**
	 * Set the value related to the column: orderdate
	 * @param orderdate the orderdate value
	 */
	public void setOrderdate (java.util.Date orderdate) {
		this.orderdate = orderdate;
	}



	/**
	 * Return the value associated with the column: ordertype
	 */
	public java.lang.String getOrdertype () {
		return ordertype;
	}

	/**
	 * Set the value related to the column: ordertype
	 * @param ordertype the ordertype value
	 */
	public void setOrdertype (java.lang.String ordertype) {
		this.ordertype = ordertype;
	}



	/**
	 * Return the value associated with the column: orderid_supplier
	 */
	public java.lang.String getOrderidSupplier () {
		return orderidSupplier;
	}

	/**
	 * Set the value related to the column: orderid_supplier
	 * @param orderidSupplier the orderid_supplier value
	 */
	public void setOrderidSupplier (java.lang.String orderidSupplier) {
		this.orderidSupplier = orderidSupplier;
	}



	/**
	 * Return the value associated with the column: invoiceaddress
	 */
	public java.lang.String getInvoiceaddress () {
		return invoiceaddress;
	}

	/**
	 * Set the value related to the column: invoiceaddress
	 * @param invoiceaddress the invoiceaddress value
	 */
	public void setInvoiceaddress (java.lang.String invoiceaddress) {
		this.invoiceaddress = invoiceaddress;
	}



	/**
	 * Return the value associated with the column: deliveryaddress
	 */
	public java.lang.String getDeliveryaddress () {
		return deliveryaddress;
	}

	/**
	 * Set the value related to the column: deliveryaddress
	 * @param deliveryaddress the deliveryaddress value
	 */
	public void setDeliveryaddress (java.lang.String deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}



	/**
	 * Return the value associated with the column: currency
	 */
	public java.lang.String getCurrency () {
		return currency;
	}

	/**
	 * Set the value related to the column: currency
	 * @param currency the currency value
	 */
	public void setCurrency (java.lang.String currency) {
		this.currency = currency;
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
	 * Return the value associated with the column: pricetotal_net
	 */
	public java.math.BigDecimal getPricetotalNet () {
		return pricetotalNet;
	}

	/**
	 * Set the value related to the column: pricetotal_net
	 * @param pricetotalNet the pricetotal_net value
	 */
	public void setPricetotalNet (java.math.BigDecimal pricetotalNet) {
		this.pricetotalNet = pricetotalNet;
	}



	/**
	 * Return the value associated with the column: pricetotal_gross
	 */
	public java.math.BigDecimal getPricetotalGross () {
		return pricetotalGross;
	}

	/**
	 * Set the value related to the column: pricetotal_gross
	 * @param pricetotalGross the pricetotal_gross value
	 */
	public void setPricetotalGross (java.math.BigDecimal pricetotalGross) {
		this.pricetotalGross = pricetotalGross;
	}



	/**
	 * Return the value associated with the column: taxtotal
	 */
	public java.math.BigDecimal getTaxtotal () {
		return taxtotal;
	}

	/**
	 * Set the value related to the column: taxtotal
	 * @param taxtotal the taxtotal value
	 */
	public void setTaxtotal (java.math.BigDecimal taxtotal) {
		this.taxtotal = taxtotal;
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
	 * Return the value associated with the column: totallineitems
	 */
	public java.lang.Integer getTotallineitems () {
		return totallineitems;
	}

	/**
	 * Set the value related to the column: totallineitems
	 * @param totallineitems the totallineitems value
	 */
	public void setTotallineitems (java.lang.Integer totallineitems) {
		this.totallineitems = totallineitems;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoPurchase)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoPurchase fulfillmentinfoPurchase = (de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoPurchase) obj;
			if (null == this.getId() || null == fulfillmentinfoPurchase.getId()) return false;
			else return (this.getId().equals(fulfillmentinfoPurchase.getId()));
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