package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


public abstract class BaseSupplieridentificationPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier supplier;
	private java.lang.String identification;


	public BaseSupplieridentificationPK () {}
	
	public BaseSupplieridentificationPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier supplier,
		java.lang.String identification) {

		this.setSupplier(supplier);
		this.setIdentification(identification);
	}


	/**
	 * Return the value associated with the column: supplier
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier getSupplier () {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier
	 * @param supplier the supplier value
	 */
	public void setSupplier (de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier supplier) {
		this.supplier = supplier;
	}



	/**
	 * Return the value associated with the column: identification
	 */
	public java.lang.String getIdentification () {
		return identification;
	}

	/**
	 * Set the value related to the column: identification
	 * @param identification the identification value
	 */
	public void setIdentification (java.lang.String identification) {
		this.identification = identification;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.SupplieridentificationPK)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.SupplieridentificationPK mObj = (de.htwg_konstanz.ebus.framework.wholesaler.vo.SupplieridentificationPK) obj;
			if (null != this.getSupplier() && null != mObj.getSupplier()) {
				if (!this.getSupplier().equals(mObj.getSupplier())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getIdentification() && null != mObj.getIdentification()) {
				if (!this.getIdentification().equals(mObj.getIdentification())) {
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
			if (null != this.getSupplier()) {
				sb.append(this.getSupplier().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getIdentification()) {
				sb.append(this.getIdentification().hashCode());
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