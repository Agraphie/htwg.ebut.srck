package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


public abstract class BaseCustomeridentifcationPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer;
	private java.lang.String companyidenttype;


	public BaseCustomeridentifcationPK () {}
	
	public BaseCustomeridentifcationPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer,
		java.lang.String companyidenttype) {

		this.setCustomer(customer);
		this.setCompanyidenttype(companyidenttype);
	}


	/**
	 * Return the value associated with the column: customer
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer getCustomer () {
		return customer;
	}

	/**
	 * Set the value related to the column: customer
	 * @param customer the customer value
	 */
	public void setCustomer (de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer) {
		this.customer = customer;
	}



	/**
	 * Return the value associated with the column: companyidenttype
	 */
	public java.lang.String getCompanyidenttype () {
		return companyidenttype;
	}

	/**
	 * Set the value related to the column: companyidenttype
	 * @param companyidenttype the companyidenttype value
	 */
	public void setCompanyidenttype (java.lang.String companyidenttype) {
		this.companyidenttype = companyidenttype;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK mObj = (de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK) obj;
			if (null != this.getCustomer() && null != mObj.getCustomer()) {
				if (!this.getCustomer().equals(mObj.getCustomer())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getCompanyidenttype() && null != mObj.getCompanyidenttype()) {
				if (!this.getCompanyidenttype().equals(mObj.getCompanyidenttype())) {
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
			if (null != this.getCustomer()) {
				sb.append(this.getCustomer().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getCompanyidenttype()) {
				sb.append(this.getCompanyidenttype().hashCode());
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