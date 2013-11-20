package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


public abstract class BasePurchasepricePK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product;
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Country country;
	private java.lang.Integer lowerboundScaledprice;


	public BasePurchasepricePK () {}
	
	public BasePurchasepricePK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Country country,
		java.lang.Integer lowerboundScaledprice) {

		this.setProduct(product);
		this.setCountry(country);
		this.setLowerboundScaledprice(lowerboundScaledprice);
	}


	/**
	 * Return the value associated with the column: product
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Product getProduct () {
		return product;
	}

	/**
	 * Set the value related to the column: product
	 * @param product the product value
	 */
	public void setProduct (de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product) {
		this.product = product;
	}



	/**
	 * Return the value associated with the column: country
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Country getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: country
	 * @param country the country value
	 */
	public void setCountry (de.htwg_konstanz.ebus.framework.wholesaler.vo.Country country) {
		this.country = country;
	}



	/**
	 * Return the value associated with the column: lowerbound_scaledprice
	 */
	public java.lang.Integer getLowerboundScaledprice () {
		return lowerboundScaledprice;
	}

	/**
	 * Set the value related to the column: lowerbound_scaledprice
	 * @param lowerboundScaledprice the lowerbound_scaledprice value
	 */
	public void setLowerboundScaledprice (java.lang.Integer lowerboundScaledprice) {
		this.lowerboundScaledprice = lowerboundScaledprice;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.PurchasepricePK)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.PurchasepricePK mObj = (de.htwg_konstanz.ebus.framework.wholesaler.vo.PurchasepricePK) obj;
			if (null != this.getProduct() && null != mObj.getProduct()) {
				if (!this.getProduct().equals(mObj.getProduct())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getCountry() && null != mObj.getCountry()) {
				if (!this.getCountry().equals(mObj.getCountry())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getLowerboundScaledprice() && null != mObj.getLowerboundScaledprice()) {
				if (!this.getLowerboundScaledprice().equals(mObj.getLowerboundScaledprice())) {
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
			if (null != this.getProduct()) {
				sb.append(this.getProduct().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getCountry()) {
				sb.append(this.getCountry().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getLowerboundScaledprice()) {
				sb.append(this.getLowerboundScaledprice().hashCode());
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