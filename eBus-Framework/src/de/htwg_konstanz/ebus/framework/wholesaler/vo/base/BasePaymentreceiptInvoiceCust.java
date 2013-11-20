package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the paymentreceipt_invoice_cust table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="paymentreceipt_invoice_cust"
 */

public abstract class BasePaymentreceiptInvoiceCust  implements Serializable {

	public static String REF = "PaymentreceiptInvoiceCust";
	public static String PROP_INVOICEITEM = "Invoiceitem";
	public static String PROP_ID = "Id";
	public static String PROP_INVOICE = "Invoice";
	public static String PROP_PAYMENTRECEIPT = "Paymentreceipt";


	// constructors
	public BasePaymentreceiptInvoiceCust () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePaymentreceiptInvoiceCust (de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptInvoiceCustPK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePaymentreceiptInvoiceCust (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptInvoiceCustPK id,
		java.lang.String paymentreceipt,
		java.lang.String invoice,
		java.lang.Integer invoiceitem) {

		this.setId(id);
		this.setPaymentreceipt(paymentreceipt);
		this.setInvoice(invoice);
		this.setInvoiceitem(invoiceitem);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptInvoiceCustPK id;

	// fields
	private java.lang.String paymentreceipt;
	private java.lang.String invoice;
	private java.lang.Integer invoiceitem;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptInvoiceCustPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptInvoiceCustPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: paymentreceipt
	 */
	public java.lang.String getPaymentreceipt () {
		return paymentreceipt;
	}

	/**
	 * Set the value related to the column: paymentreceipt
	 * @param paymentreceipt the paymentreceipt value
	 */
	public void setPaymentreceipt (java.lang.String paymentreceipt) {
		this.paymentreceipt = paymentreceipt;
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



	/**
	 * Return the value associated with the column: invoiceitem
	 */
	public java.lang.Integer getInvoiceitem () {
		return invoiceitem;
	}

	/**
	 * Set the value related to the column: invoiceitem
	 * @param invoiceitem the invoiceitem value
	 */
	public void setInvoiceitem (java.lang.Integer invoiceitem) {
		this.invoiceitem = invoiceitem;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptInvoiceCust)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptInvoiceCust paymentreceiptInvoiceCust = (de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptInvoiceCust) obj;
			if (null == this.getId() || null == paymentreceiptInvoiceCust.getId()) return false;
			else return (this.getId().equals(paymentreceiptInvoiceCust.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}