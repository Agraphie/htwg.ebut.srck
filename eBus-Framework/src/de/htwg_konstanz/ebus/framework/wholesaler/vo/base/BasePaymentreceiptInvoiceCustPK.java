package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


public abstract class BasePaymentreceiptInvoiceCustPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptCustomer paymentreceiptCustomer;
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemCustomer invoiceitemCustomer;
	private java.lang.Integer partialpaymentnumber;


	public BasePaymentreceiptInvoiceCustPK () {}
	
	public BasePaymentreceiptInvoiceCustPK (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptCustomer paymentreceiptCustomer,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemCustomer invoiceitemCustomer,
		java.lang.Integer partialpaymentnumber) {

		this.setPaymentreceiptCustomer(paymentreceiptCustomer);
		this.setInvoiceitemCustomer(invoiceitemCustomer);
		this.setPartialpaymentnumber(partialpaymentnumber);
	}


	/**
	 * Return the value associated with the column: paymentreceipt
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptCustomer getPaymentreceiptCustomer () {
		return paymentreceiptCustomer;
	}

	/**
	 * Set the value related to the column: paymentreceipt
	 * @param paymentreceiptCustomer the paymentreceipt value
	 */
	public void setPaymentreceiptCustomer (de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptCustomer paymentreceiptCustomer) {
		this.paymentreceiptCustomer = paymentreceiptCustomer;
	}



	/**
	 * Return the value associated with the column: invoiceitem
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemCustomer getInvoiceitemCustomer () {
		return invoiceitemCustomer;
	}

	/**
	 * Set the value related to the column: invoiceitem
	 * @param invoiceitemCustomer the invoiceitem value
	 */
	public void setInvoiceitemCustomer (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceitemCustomer invoiceitemCustomer) {
		this.invoiceitemCustomer = invoiceitemCustomer;
	}



	/**
	 * Return the value associated with the column: partialpaymentnumber
	 */
	public java.lang.Integer getPartialpaymentnumber () {
		return partialpaymentnumber;
	}

	/**
	 * Set the value related to the column: partialpaymentnumber
	 * @param partialpaymentnumber the partialpaymentnumber value
	 */
	public void setPartialpaymentnumber (java.lang.Integer partialpaymentnumber) {
		this.partialpaymentnumber = partialpaymentnumber;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptInvoiceCustPK)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptInvoiceCustPK mObj = (de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptInvoiceCustPK) obj;
			if (null != this.getPaymentreceiptCustomer() && null != mObj.getPaymentreceiptCustomer()) {
				if (!this.getPaymentreceiptCustomer().equals(mObj.getPaymentreceiptCustomer())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getInvoiceitemCustomer() && null != mObj.getInvoiceitemCustomer()) {
				if (!this.getInvoiceitemCustomer().equals(mObj.getInvoiceitemCustomer())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getPartialpaymentnumber() && null != mObj.getPartialpaymentnumber()) {
				if (!this.getPartialpaymentnumber().equals(mObj.getPartialpaymentnumber())) {
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
			if (null != this.getPaymentreceiptCustomer()) {
				sb.append(this.getPaymentreceiptCustomer().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getInvoiceitemCustomer()) {
				sb.append(this.getInvoiceitemCustomer().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getPartialpaymentnumber()) {
				sb.append(this.getPartialpaymentnumber().hashCode());
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