package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


public abstract class BaseShipmentitemCustomerPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer shipment;
	private java.lang.Integer itemnumber;


	public BaseShipmentitemCustomerPK () {}
	
	public BaseShipmentitemCustomerPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer shipment,
		java.lang.Integer itemnumber) {

		this.setShipment(shipment);
		this.setItemnumber(itemnumber);
	}


	/**
	 * Return the value associated with the column: shipment
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer getShipment () {
		return shipment;
	}

	/**
	 * Set the value related to the column: shipment
	 * @param shipment the shipment value
	 */
	public void setShipment (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer shipment) {
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
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomerPK)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomerPK mObj = (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomerPK) obj;
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