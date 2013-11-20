package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the shipment_customer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="shipment_customer"
 */

public abstract class BaseShipmentCustomer  implements Serializable {

	public static String REF = "ShipmentCustomer";
	public static String PROP_CUSTOMER = "Customer";
	public static String PROP_SHIPMENTID = "Shipmentid";
	public static String PROP_SHIPMENTDATE = "Shipmentdate";
	public static String PROP_TRANSPORT = "Transport";
	public static String PROP_SPECIALTREATMENT = "Specialtreatment";
	public static String PROP_INTERNATIONALRESTRICTIONS = "Internationalrestrictions";
	public static String PROP_DISPATCHNOTIFICATIONDATE = "Dispatchnotificationdate";
	public static String PROP_REMARK = "Remark";
	public static String PROP_PACKAGEINFO = "Packageinfo";
	public static String PROP_DELIVERYNOTEDATE = "Deliverynotedate";


	// constructors
	public BaseShipmentCustomer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShipmentCustomer (java.lang.String shipmentid) {
		this.setShipmentid(shipmentid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String shipmentid;

	// fields
	private java.util.Date shipmentdate;
	private java.util.Date deliverynotedate;
	private java.util.Date dispatchnotificationdate;
	private java.lang.String transport;
	private java.lang.String packageinfo;
	private java.lang.String specialtreatment;
	private java.lang.String internationalrestrictions;
	private java.lang.String remark;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="shipmentid"
     */
	public java.lang.String getShipmentid () {
		return shipmentid;
	}

	/**
	 * Set the unique identifier of this class
	 * @param shipmentid the new ID
	 */
	public void setShipmentid (java.lang.String shipmentid) {
		this.shipmentid = shipmentid;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: shipmentdate
	 */
	public java.util.Date getShipmentdate () {
		return shipmentdate;
	}

	/**
	 * Set the value related to the column: shipmentdate
	 * @param shipmentdate the shipmentdate value
	 */
	public void setShipmentdate (java.util.Date shipmentdate) {
		this.shipmentdate = shipmentdate;
	}



	/**
	 * Return the value associated with the column: deliverynotedate
	 */
	public java.util.Date getDeliverynotedate () {
		return deliverynotedate;
	}

	/**
	 * Set the value related to the column: deliverynotedate
	 * @param deliverynotedate the deliverynotedate value
	 */
	public void setDeliverynotedate (java.util.Date deliverynotedate) {
		this.deliverynotedate = deliverynotedate;
	}



	/**
	 * Return the value associated with the column: dispatchnotificationdate
	 */
	public java.util.Date getDispatchnotificationdate () {
		return dispatchnotificationdate;
	}

	/**
	 * Set the value related to the column: dispatchnotificationdate
	 * @param dispatchnotificationdate the dispatchnotificationdate value
	 */
	public void setDispatchnotificationdate (java.util.Date dispatchnotificationdate) {
		this.dispatchnotificationdate = dispatchnotificationdate;
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
	 * Return the value associated with the column: packageinfo
	 */
	public java.lang.String getPackageinfo () {
		return packageinfo;
	}

	/**
	 * Set the value related to the column: packageinfo
	 * @param packageinfo the packageinfo value
	 */
	public void setPackageinfo (java.lang.String packageinfo) {
		this.packageinfo = packageinfo;
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
	 * Return the value associated with the column: customer
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer getCustomer () {
		return customer;
	}

	/**
	 * Set the value related to the column: customer
	 * @param customer the customer value
	 */
	public void setCustomer (de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer) {
		this.customer = customer;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer shipmentCustomer = (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer) obj;
			if (null == this.getShipmentid() || null == shipmentCustomer.getShipmentid()) return false;
			else return (this.getShipmentid().equals(shipmentCustomer.getShipmentid()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getShipmentid()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getShipmentid().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}