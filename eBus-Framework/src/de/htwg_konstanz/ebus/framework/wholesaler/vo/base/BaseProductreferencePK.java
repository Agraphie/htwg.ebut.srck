package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


public abstract class BaseProductreferencePK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product;
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Product referencedproduct;


	public BaseProductreferencePK () {}
	
	public BaseProductreferencePK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Product referencedproduct) {

		this.setProduct(product);
		this.setReferencedproduct(referencedproduct);
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
	 * Return the value associated with the column: referencedproduct
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Product getReferencedproduct () {
		return referencedproduct;
	}

	/**
	 * Set the value related to the column: referencedproduct
	 * @param referencedproduct the referencedproduct value
	 */
	public void setReferencedproduct (de.htwg_konstanz.ebus.framework.wholesaler.vo.Product referencedproduct) {
		this.referencedproduct = referencedproduct;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.ProductreferencePK)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.ProductreferencePK mObj = (de.htwg_konstanz.ebus.framework.wholesaler.vo.ProductreferencePK) obj;
			if (null != this.getProduct() && null != mObj.getProduct()) {
				if (!this.getProduct().equals(mObj.getProduct())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getReferencedproduct() && null != mObj.getReferencedproduct()) {
				if (!this.getReferencedproduct().equals(mObj.getReferencedproduct())) {
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
			if (null != this.getReferencedproduct()) {
				sb.append(this.getReferencedproduct().hashCode());
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