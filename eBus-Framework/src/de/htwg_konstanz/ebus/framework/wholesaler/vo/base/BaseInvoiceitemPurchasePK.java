package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


public abstract class BaseInvoiceitemPurchasePK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.Integer itemnumber;
	private java.lang.String invoice;


	public BaseInvoiceitemPurchasePK () {}
	
	public BaseInvoiceitemPurchasePK (
		java.lang.Integer itemnumber,
		java.lang.String invoice) {

		this.setItemnumber(itemnumber);
		this.setInvoice(invoice);
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
	 * Return the value associated with the column: invoice
	 */
	public java.lang.String getInvoice () {
		return invoice;
	}

	/**
	 * Set the value related to the column: invoice
	 * @param invoice the invoice value
	 */
	public void setInvoice (java.lang.String invoice) {
		this.invoice = invoice;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemPurchasePK)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemPurchasePK mObj = (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemPurchasePK) obj;
			if (null != this.getItemnumber() && null != mObj.getItemnumber()) {
				if (!this.getItemnumber().equals(mObj.getItemnumber())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getInvoice() && null != mObj.getInvoice()) {
				if (!this.getInvoice().equals(mObj.getInvoice())) {
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
			if (null != this.getInvoice()) {
				sb.append(this.getInvoice().hashCode());
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