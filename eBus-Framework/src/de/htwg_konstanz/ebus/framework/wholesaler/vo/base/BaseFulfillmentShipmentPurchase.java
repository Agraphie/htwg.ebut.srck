package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fulfillment_shipment_purchase table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fulfillment_shipment_purchase"
 */

public abstract class BaseFulfillmentShipmentPurchase  implements Serializable {

	public static String REF = "FulfillmentShipmentPurchase";


	// constructors
	public BaseFulfillmentShipmentPurchase () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFulfillmentShipmentPurchase (
		java.lang.String shipment,
		java.lang.String fulfillmentinfo) {

		this.setShipment(shipment);
		this.setFulfillmentinfo(fulfillmentinfo);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key

	private java.lang.String shipment;

	private java.lang.String fulfillmentinfo;



	/**
     * @hibernate.property
     *  column=shipment
	 * not-null=true
	 */
	public java.lang.String getShipment () {
		return this.shipment;
	}

	/**
	 * Set the value related to the column: shipment
	 * @param shipment the shipment value
	 */
	public void setShipment (java.lang.String shipment) {
		this.shipment = shipment;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
     * @hibernate.property
     *  column=fulfillmentinfo
	 * not-null=true
	 */
	public java.lang.String getFulfillmentinfo () {
		return this.fulfillmentinfo;
	}

	/**
	 * Set the value related to the column: fulfillmentinfo
	 * @param fulfillmentinfo the fulfillmentinfo value
	 */
	public void setFulfillmentinfo (java.lang.String fulfillmentinfo) {
		this.fulfillmentinfo = fulfillmentinfo;
		this.hashCode = Integer.MIN_VALUE;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentPurchase)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentPurchase fulfillmentShipmentPurchase = (de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentPurchase) obj;
			if (null != this.getShipment() && null != fulfillmentShipmentPurchase.getShipment()) {
				if (!this.getShipment().equals(fulfillmentShipmentPurchase.getShipment())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getFulfillmentinfo() && null != fulfillmentShipmentPurchase.getFulfillmentinfo()) {
				if (!this.getFulfillmentinfo().equals(fulfillmentShipmentPurchase.getFulfillmentinfo())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getShipment()) {
				sb.append(this.getShipment().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getFulfillmentinfo()) {
				sb.append(this.getFulfillmentinfo().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}