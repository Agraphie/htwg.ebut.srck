package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


public abstract class BaseFulfillmentinfoitemPurchasePK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.Integer itemnumber;
	private java.lang.String fulfillmentinfo;


	public BaseFulfillmentinfoitemPurchasePK () {}
	
	public BaseFulfillmentinfoitemPurchasePK (
		java.lang.Integer itemnumber,
		java.lang.String fulfillmentinfo) {

		this.setItemnumber(itemnumber);
		this.setFulfillmentinfo(fulfillmentinfo);
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
	 * Return the value associated with the column: fulfillmentinfo
	 */
	public java.lang.String getFulfillmentinfo () {
		return fulfillmentinfo;
	}

	/**
	 * Set the value related to the column: fulfillmentinfo
	 * @param fulfillmentinfo the fulfillmentinfo value
	 */
	public void setFulfillmentinfo (java.lang.String fulfillmentinfo) {
		this.fulfillmentinfo = fulfillmentinfo;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoitemPurchasePK)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoitemPurchasePK mObj = (de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentinfoitemPurchasePK) obj;
			if (null != this.getItemnumber() && null != mObj.getItemnumber()) {
				if (!this.getItemnumber().equals(mObj.getItemnumber())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getFulfillmentinfo() && null != mObj.getFulfillmentinfo()) {
				if (!this.getFulfillmentinfo().equals(mObj.getFulfillmentinfo())) {
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
			if (null != this.getItemnumber()) {
				sb.append(this.getItemnumber().hashCode());
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


}