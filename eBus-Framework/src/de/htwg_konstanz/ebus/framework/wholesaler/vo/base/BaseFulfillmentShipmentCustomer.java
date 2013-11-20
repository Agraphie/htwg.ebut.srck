package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fulfillment_shipment_customer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fulfillment_shipment_customer"
 */

public abstract class BaseFulfillmentShipmentCustomer  implements Serializable {

	public static String REF = "FulfillmentShipmentCustomer";


	// constructors
	public BaseFulfillmentShipmentCustomer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFulfillmentShipmentCustomer (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer shipment,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoCustomer fulfillmentinfo) {

		this.setShipment(shipment);
		this.setFulfillmentinfo(fulfillmentinfo);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key

	private de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer shipment;

	private de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoCustomer fulfillmentinfo;



	/**
     * @hibernate.property
     *  column=shipment
	 * not-null=true
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer getShipment () {
		return this.shipment;
	}

	/**
	 * Set the value related to the column: shipment
	 * @param shipment the shipment value
	 */
	public void setShipment (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer shipment) {
		this.shipment = shipment;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
     * @hibernate.property
     *  column=fulfillmentinfo
	 * not-null=true
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoCustomer getFulfillmentinfo () {
		return this.fulfillmentinfo;
	}

	/**
	 * Set the value related to the column: fulfillmentinfo
	 * @param fulfillmentinfo the fulfillmentinfo value
	 */
	public void setFulfillmentinfo (de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoCustomer fulfillmentinfo) {
		this.fulfillmentinfo = fulfillmentinfo;
		this.hashCode = Integer.MIN_VALUE;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentCustomer)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentCustomer fulfillmentShipmentCustomer = (de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentCustomer) obj;
			if (null != this.getShipment() && null != fulfillmentShipmentCustomer.getShipment()) {
				if (!this.getShipment().equals(fulfillmentShipmentCustomer.getShipment())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getFulfillmentinfo() && null != fulfillmentShipmentCustomer.getFulfillmentinfo()) {
				if (!this.getFulfillmentinfo().equals(fulfillmentShipmentCustomer.getFulfillmentinfo())) {
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