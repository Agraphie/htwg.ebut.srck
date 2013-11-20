package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the shipmentitem_customer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="shipmentitem_customer"
 */

public abstract class BaseShipmentitemCustomer  implements Serializable {

	public static String REF = "ShipmentitemCustomer";
	public static String PROP_NO_CU_PER_OU = "NoCuPerOu";
	public static String PROP_CONTENTUNIT = "Contentunit";
	public static String PROP_SHIPMENTQUANTITY = "Shipmentquantity";
	public static String PROP_INTERNATIONALRESTRICTIONS = "Internationalrestrictions";
	public static String PROP_ORDERNUMBER_CUSTOMER = "OrdernumberCustomer";
	public static String PROP_PRODUCTDESCRIPTION = "Productdescription";
	public static String PROP_DELIVERYADDRESS = "Deliveryaddress";
	public static String PROP_PARTIALSHIPMENT = "Partialshipment";
	public static String PROP_TRANSPORT = "Transport";
	public static String PROP_SPECIALTREATMENT = "Specialtreatment";
	public static String PROP_ORDERUNIT = "Orderunit";
	public static String PROP_ID = "Id";
	public static String PROP_REMARK = "Remark";


	// constructors
	public BaseShipmentitemCustomer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShipmentitemCustomer (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomerPK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseShipmentitemCustomer (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomerPK id,
		java.lang.String ordernumberCustomer,
		java.lang.Integer shipmentquantity,
		java.lang.String orderunit) {

		this.setId(id);
		this.setOrdernumberCustomer(ordernumberCustomer);
		this.setShipmentquantity(shipmentquantity);
		this.setOrderunit(orderunit);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomerPK id;

	// fields
	private java.lang.String ordernumberCustomer;
	private java.lang.String productdescription;
	private java.lang.Integer shipmentquantity;
	private java.lang.String orderunit;
	private java.lang.String contentunit;
	private java.lang.Integer noCuPerOu;
	private java.lang.Integer partialshipment;
	private java.lang.String transport;
	private java.lang.String specialtreatment;
	private java.lang.String internationalrestrictions;
	private java.lang.String remark;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Address deliveryaddress;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomerPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomerPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: ordernumber_customer
	 */
	public java.lang.String getOrdernumberCustomer () {
		return ordernumberCustomer;
	}

	/**
	 * Set the value related to the column: ordernumber_customer
	 * @param ordernumberCustomer the ordernumber_customer value
	 */
	public void setOrdernumberCustomer (java.lang.String ordernumberCustomer) {
		this.ordernumberCustomer = ordernumberCustomer;
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
	 * Return the value associated with the column: shipmentquantity
	 */
	public java.lang.Integer getShipmentquantity () {
		return shipmentquantity;
	}

	/**
	 * Set the value related to the column: shipmentquantity
	 * @param shipmentquantity the shipmentquantity value
	 */
	public void setShipmentquantity (java.lang.Integer shipmentquantity) {
		this.shipmentquantity = shipmentquantity;
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
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomer)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomer shipmentitemCustomer = (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomer) obj;
			if (null == this.getId() || null == shipmentitemCustomer.getId()) return false;
			else return (this.getId().equals(shipmentitemCustomer.getId()));
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