package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the invoice_customer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="invoice_customer"
 */

public abstract class BaseInvoiceCustomer  implements Serializable {

	public static String REF = "InvoiceCustomer";
	public static String PROP_CUSTOMER = "Customer";
	public static String PROP_INVOICEADDRESS = "Invoiceaddress";
	public static String PROP_TAXAMOUNT = "Taxamount";
	public static String PROP_PAYMENTINFORMATION = "Paymentinformation";
	public static String PROP_PRICETOTAL_NET = "PricetotalNet";
	public static String PROP_TOTALLINEITEMS = "Totallineitems";
	public static String PROP_INVOICEDATE = "Invoicedate";
	public static String PROP_PRICETOTAL_GROSS = "PricetotalGross";
	public static String PROP_TAXTOTAL = "Taxtotal";
	public static String PROP_REMARK = "Remark";
	public static String PROP_INVOICEID = "Invoiceid";
	public static String PROP_CURRENCY = "Currency";
	public static String PROP_PAYMENTTYPE = "Paymenttype";


	// constructors
	public BaseInvoiceCustomer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInvoiceCustomer (java.lang.String invoiceid) {
		this.setInvoiceid(invoiceid);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseInvoiceCustomer (
		java.lang.String invoiceid,
		java.util.Date invoicedate) {

		this.setInvoiceid(invoiceid);
		this.setInvoicedate(invoicedate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String invoiceid;

	// fields
	private java.util.Date invoicedate;
	private java.lang.String remark;
	private java.math.BigDecimal pricetotalNet;
	private java.math.BigDecimal pricetotalGross;
	private java.math.BigDecimal taxtotal;
	private java.math.BigDecimal taxamount;
	private java.lang.Integer totallineitems;
	private java.lang.String paymenttype;
	private java.lang.String paymentinformation;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Currency currency;
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer;
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Address invoiceaddress;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="invoiceid"
     */
	public java.lang.String getInvoiceid () {
		return invoiceid;
	}

	/**
	 * Set the unique identifier of this class
	 * @param invoiceid the new ID
	 */
	public void setInvoiceid (java.lang.String invoiceid) {
		this.invoiceid = invoiceid;
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



	/**
	 * Return the value associated with the column: currency
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Currency getCurrency () {
		return currency;
	}

	/**
	 * Set the value related to the column: currency
	 * @param currency the currency value
	 */
	public void setCurrency (de.htwg_konstanz.ebus.framework.wholesaler.vo.Currency currency) {
		this.currency = currency;
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
	 * Return the value associated with the column: invoiceaddress
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Address getInvoiceaddress () {
		return invoiceaddress;
	}

	/**
	 * Set the value related to the column: invoiceaddress
	 * @param invoiceaddress the invoiceaddress value
	 */
	public void setInvoiceaddress (de.htwg_konstanz.ebus.framework.wholesaler.vo.Address invoiceaddress) {
		this.invoiceaddress = invoiceaddress;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceCustomer)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceCustomer invoiceCustomer = (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceCustomer) obj;
			if (null == this.getInvoiceid() || null == invoiceCustomer.getInvoiceid()) return false;
			else return (this.getInvoiceid().equals(invoiceCustomer.getInvoiceid()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getInvoiceid()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getInvoiceid().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}