package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


public abstract class BaseOrderitemCustomerPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderCustomer orderref;
	private java.lang.Integer itemnumber;


	public BaseOrderitemCustomerPK () {}
	
	public BaseOrderitemCustomerPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderCustomer orderref,
		java.lang.Integer itemnumber) {

		this.setOrderref(orderref);
		this.setItemnumber(itemnumber);
	}


	/**
	 * Return the value associated with the column: orderref
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderCustomer getOrderref () {
		return orderref;
	}

	/**
	 * Set the value related to the column: orderref
	 * @param orderref the orderref value
	 */
	public void setOrderref (de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderCustomer orderref) {
		this.orderref = orderref;
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
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemCustomerPK)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemCustomerPK mObj = (de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderitemCustomerPK) obj;
			if (null != this.getOrderref() && null != mObj.getOrderref()) {
				if (!this.getOrderref().equals(mObj.getOrderref())) {
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
			if (null != this.getOrderref()) {
				sb.append(this.getOrderref().hashCode());
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