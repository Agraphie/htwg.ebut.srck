package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


public abstract class BaseArticlenumberPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product;
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Articlenumbertype articlenumbertype;


	public BaseArticlenumberPK () {}
	
	public BaseArticlenumberPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Articlenumbertype articlenumbertype) {

		this.setProduct(product);
		this.setArticlenumbertype(articlenumbertype);
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
	 * Return the value associated with the column: articlenumbertype
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Articlenumbertype getArticlenumbertype () {
		return articlenumbertype;
	}

	/**
	 * Set the value related to the column: articlenumbertype
	 * @param articlenumbertype the articlenumbertype value
	 */
	public void setArticlenumbertype (de.htwg_konstanz.ebus.framework.wholesaler.vo.Articlenumbertype articlenumbertype) {
		this.articlenumbertype = articlenumbertype;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.ArticlenumberPK)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.ArticlenumberPK mObj = (de.htwg_konstanz.ebus.framework.wholesaler.vo.ArticlenumberPK) obj;
			if (null != this.getProduct() && null != mObj.getProduct()) {
				if (!this.getProduct().equals(mObj.getProduct())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getArticlenumbertype() && null != mObj.getArticlenumbertype()) {
				if (!this.getArticlenumbertype().equals(mObj.getArticlenumbertype())) {
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
			if (null != this.getArticlenumbertype()) {
				sb.append(this.getArticlenumbertype().hashCode());
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