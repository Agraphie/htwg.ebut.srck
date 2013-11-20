package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


public abstract class BaseInvoiceitemCustomerPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceCustomer invoice;
	private java.lang.Integer itemnumber;


	public BaseInvoiceitemCustomerPK () {}
	
	public BaseInvoiceitemCustomerPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceCustomer invoice,
		java.lang.Integer itemnumber) {

		this.setInvoice(invoice);
		this.setItemnumber(itemnumber);
	}


	/**
	 * Return the value associated with the column: invoice
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceCustomer getInvoice () {
		return invoice;
	}

	/**
	 * Set the value related to the column: invoice
	 * @param invoice the invoice value
	 */
	public void setInvoice (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceCustomer invoice) {
		this.invoice = invoice;
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
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemCustomerPK)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemCustomerPK mObj = (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemCustomerPK) obj;
			if (null != this.getInvoice() && null != mObj.getInvoice()) {
				if (!this.getInvoice().equals(mObj.getInvoice())) {
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
			if (null != this.getInvoice()) {
				sb.append(this.getInvoice().hashCode());
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