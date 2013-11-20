package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the payment_invoice_purchase table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="payment_invoice_purchase"
 */

public abstract class BasePaymentInvoicePurchase  implements Serializable {

	public static String REF = "PaymentInvoicePurchase";


	// constructors
	public BasePaymentInvoicePurchase () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePaymentInvoicePurchase (
		java.lang.Integer partialpaymentnumber,
		java.lang.String payment,
		java.lang.String invoice,
		java.lang.Integer invoiceitem) {

		this.setPartialpaymentnumber(partialpaymentnumber);
		this.setPayment(payment);
		this.setInvoice(invoice);
		this.setInvoiceitem(invoiceitem);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key

	private java.lang.Integer partialpaymentnumber;

	private java.lang.String payment;

	private java.lang.String invoice;

	private java.lang.Integer invoiceitem;



	/**
     * @hibernate.property
     *  column=partialpaymentnumber
	 * not-null=true
	 */
	public java.lang.Integer getPartialpaymentnumber () {
		return this.partialpaymentnumber;
	}

	/**
	 * Set the value related to the column: partialpaymentnumber
	 * @param partialpaymentnumber the partialpaymentnumber value
	 */
	public void setPartialpaymentnumber (java.lang.Integer partialpaymentnumber) {
		this.partialpaymentnumber = partialpaymentnumber;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
     * @hibernate.property
     *  column=payment
	 * not-null=true
	 */
	public java.lang.String getPayment () {
		return this.payment;
	}

	/**
	 * Set the value related to the column: payment
	 * @param payment the payment value
	 */
	public void setPayment (java.lang.String payment) {
		this.payment = payment;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
     * @hibernate.property
     *  column=invoice
	 * not-null=true
	 */
	public java.lang.String getInvoice () {
		return this.invoice;
	}

	/**
	 * Set the value related to the column: invoice
	 * @param invoice the invoice value
	 */
	public void setInvoice (java.lang.String invoice) {
		this.invoice = invoice;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
     * @hibernate.property
     *  column=invoiceitem
	 * not-null=true
	 */
	public java.lang.Integer getInvoiceitem () {
		return this.invoiceitem;
	}

	/**
	 * Set the value related to the column: invoiceitem
	 * @param invoiceitem the invoiceitem value
	 */
	public void setInvoiceitem (java.lang.Integer invoiceitem) {
		this.invoiceitem = invoiceitem;
		this.hashCode = Integer.MIN_VALUE;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentInvoicePurchase)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentInvoicePurchase paymentInvoicePurchase = (de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentInvoicePurchase) obj;
			if (null != this.getPartialpaymentnumber() && null != paymentInvoicePurchase.getPartialpaymentnumber()) {
				if (!this.getPartialpaymentnumber().equals(paymentInvoicePurchase.getPartialpaymentnumber())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getPayment() && null != paymentInvoicePurchase.getPayment()) {
				if (!this.getPayment().equals(paymentInvoicePurchase.getPayment())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getInvoice() && null != paymentInvoicePurchase.getInvoice()) {
				if (!this.getInvoice().equals(paymentInvoicePurchase.getInvoice())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getInvoiceitem() && null != paymentInvoicePurchase.getInvoiceitem()) {
				if (!this.getInvoiceitem().equals(paymentInvoicePurchase.getInvoiceitem())) {
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
			if (null != this.getPartialpaymentnumber()) {
				sb.append(this.getPartialpaymentnumber().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getPayment()) {
				sb.append(this.getPayment().hashCode());
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
			if (null != this.getInvoiceitem()) {
				sb.append(this.getInvoiceitem().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}