package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


public abstract class BaseShipmentitemPurchasePK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String shipment;
	private java.lang.Integer itemnumber;


	public BaseShipmentitemPurchasePK () {}
	
	public BaseShipmentitemPurchasePK (
		java.lang.String shipment,
		java.lang.Integer itemnumber) {

		this.setShipment(shipment);
		this.setItemnumber(itemnumber);
	}


	/**
	 * Return the value associated with the column: shipment
	 */
	public java.lang.String getShipment () {
		return shipment;
	}

	/**
	 * Set the value related to the column: shipment
	 * @param shipment the shipment value
	 */
	public void setShipment (java.lang.String shipment) {
		this.shipment = shipment;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK mObj = (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK) obj;
			if (null != this.getShipment() && null != mObj.getShipment()) {
				if (!this.getShipment().equals(mObj.getShipment())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getItemnumber() && null != mObj.getItemnumber()) {
				if (!this.getItemnumber().equals(mObj.getItemnumber())) {
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
			if (null != this.getItemnumber()) {
				sb.append(this.getItemnumber().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


}