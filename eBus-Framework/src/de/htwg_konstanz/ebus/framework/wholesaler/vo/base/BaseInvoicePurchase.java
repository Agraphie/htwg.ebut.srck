package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the invoice_purchase table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="invoice_purchase"
 */

public abstract class BaseInvoicePurchase  implements Serializable {

	public static String REF = "InvoicePurchase";
	public static String PROP_INVOICEADDRESS = "Invoiceaddress";
	public static String PROP_TAXAMOUNT = "Taxamount";
	public static String PROP_PAYMENTINFORMATION = "Paymentinformation";
	public static String PROP_PRICETOTAL_NET = "PricetotalNet";
	public static String PROP_INVOICEID_SUPPLIER = "InvoiceidSupplier";
	public static String PROP_TOTALLINEITEMS = "Totallineitems";
	public static String PROP_INVOICEDATE = "Invoicedate";
	public static String PROP_PRICETOTAL_GROSS = "PricetotalGross";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_TAXTOTAL = "Taxtotal";
	public static String PROP_ID = "Id";
	public static String PROP_REMARK = "Remark";
	public static String PROP_CURRENCY = "Currency";
	public static String PROP_PAYMENTTYPE = "Paymenttype";


	// constructors
	public BaseInvoicePurchase () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInvoicePurchase (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseInvoicePurchase (
		java.lang.String id,
		java.util.Date invoicedate) {

		this.setId(id);
		this.setInvoicedate(invoicedate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.util.Date invoicedate;
	private java.lang.String invoiceidSupplier;
	private java.lang.String supplier;
	private java.lang.String invoiceaddress;
	private java.lang.String currency;
	private java.lang.String remark;
	private java.math.BigDecimal pricetotalNet;
	private java.math.BigDecimal pricetotalGross;
	private java.math.BigDecimal taxtotal;
	private java.math.BigDecimal taxamount;
	private java.lang.Integer totallineitems;
	private java.lang.String paymenttype;
	private java.lang.String paymentinformation;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.Assigned"
     *  column="invoiceid"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: invoicedate
	 */
	public java.util.Date getInvoicedate () {
		return invoicedate;
	}

	/**
	 * Set the value related to the column: invoicedate
	 * @param invoicedate the invoicedate value
	 */
	public void setInvoicedate (java.util.Date invoicedate) {
		this.invoicedate = invoicedate;
	}



	/**
	 * Return the value associated with the column: invoiceid_supplier
	 */
	public java.lang.String getInvoiceidSupplier () {
		return invoiceidSupplier;
	}

	/**
	 * Set the value related to the column: invoiceid_supplier
	 * @param invoiceidSupplier the invoiceid_supplier value
	 */
	public void setInvoiceidSupplier (java.lang.String invoiceidSupplier) {
		this.invoiceidSupplier = invoiceidSupplier;
	}



	/**
	 * Return the value associated with the column: supplier
	 */
	public java.lang.String getSupplier () {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier
	 * @param supplier the supplier value
	 */
	public void setSupplier (java.lang.String supplier) {
		this.supplier = supplier;
	}



	/**
	 * Return the value associated with the column: invoiceaddress
	 */
	public java.lang.String getInvoiceaddress () {
		return invoiceaddress;
	}

	/**
	 * Set the value related to the column: invoiceaddress
	 * @param invoiceaddress the invoiceaddress value
	 */
	public void setInvoiceaddress (java.lang.String invoiceaddress) {
		this.invoiceaddress = invoiceaddress;
	}



	/**
	 * Return the value associated with the column: currency
	 */
	public java.lang.String getCurrency () {
		return currency;
	}

	/**
	 * Set the value related to the column: currency
	 * @param currency the currency value
	 */
	public void setCurrency (java.lang.String currency) {
		this.currency = currency;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: pricetotal_net
	 */
	public java.math.BigDecimal getPricetotalNet () {
		return pricetotalNet;
	}

	/**
	 * Set the value related to the column: pricetotal_net
	 * @param pricetotalNet the pricetotal_net value
	 */
	public void setPricetotalNet (java.math.BigDecimal pricetotalNet) {
		this.pricetotalNet = pricetotalNet;
	}



	/**
	 * Return the value associated with the column: pricetotal_gross
	 */
	public java.math.BigDecimal getPricetotalGross () {
		return pricetotalGross;
	}

	/**
	 * Set the value related to the column: pricetotal_gross
	 * @param pricetotalGross the pricetotal_gross value
	 */
	public void setPricetotalGross (java.math.BigDecimal pricetotalGross) {
		this.pricetotalGross = pricetotalGross;
	}



	/**
	 * Return the value associated with the column: taxtotal
	 */
	public java.math.BigDecimal getTaxtotal () {
		return taxtotal;
	}

	/**
	 * Set the value related to the column: taxtotal
	 * @param taxtotal the taxtotal value
	 */
	public void setTaxtotal (java.math.BigDecimal taxtotal) {
		this.taxtotal = taxtotal;
	}



	/**
	 * Return the value associated with the column: taxamount
	 */
	public java.math.BigDecimal getTaxamount () {
		return taxamount;
	}

	/**
	 * Set the value related to the column: taxamount
	 * @param taxamount the taxamount value
	 */
	public void setTaxamount (java.math.BigDecimal taxamount) {
		this.taxamount = taxamount;
	}



	/**
	 * Return the value associated with the column: totallineitems
	 */
	public java.lang.Integer getTotallineitems () {
		return totallineitems;
	}

	/**
	 * Set the value related to the column: totallineitems
	 * @param totallineitems the totallineitems value
	 */
	public void setTotallineitems (java.lang.Integer totallineitems) {
		this.totallineitems = totallineitems;
	}



	/**
	 * Return the value associated with the column: paymenttype
	 */
	public java.lang.String getPaymenttype () {
		return paymenttype;
	}

	/**
	 * Set the value related to the column: paymenttype
	 * @param paymenttype the paymenttype value
	 */
	public void setPaymenttype (java.lang.String paymenttype) {
		this.paymenttype = paymenttype;
	}



	/**
	 * Return the value associated with the column: paymentinformation
	 */
	public java.lang.String getPaymentinformation () {
		return paymentinformation;
	}

	/**
	 * Set the value related to the column: paymentinformation
	 * @param paymentinformation the paymentinformation value
	 */
	public void setPaymentinformation (java.lang.String paymentinformation) {
		this.paymentinformation = paymentinformation;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoicePurchase)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoicePurchase invoicePurchase = (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoicePurchase) obj;
			if (null == this.getId() || null == invoicePurchase.getId()) return false;
			else return (this.getId().equals(invoicePurchase.getId()));
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