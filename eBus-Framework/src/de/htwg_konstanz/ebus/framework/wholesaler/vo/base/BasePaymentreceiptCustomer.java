package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the paymentreceipt_customer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="paymentreceipt_customer"
 */

public abstract class BasePaymentreceiptCustomer  implements Serializable {

	public static String REF = "PaymentreceiptCustomer";
	public static String PROP_CUSTOMER = "Customer";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_PAYMENTRECEIPTDATE = "Paymentreceiptdate";
	public static String PROP_PAYMENTINFOTEXT = "Paymentinfotext";
	public static String PROP_PAYMENTINFORMATION = "Paymentinformation";
	public static String PROP_PAYMENTRECEIPTNUMBER = "Paymentreceiptnumber";
	public static String PROP_CURRENCY = "Currency";
	public static String PROP_PAYMENTTYPE = "Paymenttype";


	// constructors
	public BasePaymentreceiptCustomer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePaymentreceiptCustomer (java.lang.String paymentreceiptnumber) {
		this.setPaymentreceiptnumber(paymentreceiptnumber);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePaymentreceiptCustomer (
		java.lang.String paymentreceiptnumber,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Currency currency,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer,
		java.util.Date paymentreceiptdate) {

		this.setPaymentreceiptnumber(paymentreceiptnumber);
		this.setCurrency(currency);
		this.setCustomer(customer);
		this.setPaymentreceiptdate(paymentreceiptdate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String paymentreceiptnumber;

	// fields
	private java.util.Date paymentreceiptdate;
	private java.lang.String paymenttype;
	private java.lang.String paymentinformation;
	private java.lang.String paymentinfotext;
	private java.math.BigDecimal amount;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Currency currency;
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="paymentreceiptnumber"
     */
	public java.lang.String getPaymentreceiptnumber () {
		return paymentreceiptnumber;
	}

	/**
	 * Set the unique identifier of this class
	 * @param paymentreceiptnumber the new ID
	 */
	public void setPaymentreceiptnumber (java.lang.String paymentreceiptnumber) {
		this.paymentreceiptnumber = paymentreceiptnumber;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: paymentreceiptdate
	 */
	public java.util.Date getPaymentreceiptdate () {
		return paymentreceiptdate;
	}

	/**
	 * Set the value related to the column: paymentreceiptdate
	 * @param paymentreceiptdate the paymentreceiptdate value
	 */
	public void setPaymentreceiptdate (java.util.Date paymentreceiptdate) {
		this.paymentreceiptdate = paymentreceiptdate;
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
	 * Return the value associated with the column: paymentinfotext
	 */
	public java.lang.String getPaymentinfotext () {
		return paymentinfotext;
	}

	/**
	 * Set the value related to the column: paymentinfotext
	 * @param paymentinfotext the paymentinfotext value
	 */
	public void setPaymentinfotext (java.lang.String paymentinfotext) {
		this.paymentinfotext = paymentinfotext;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptCustomer)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptCustomer paymentreceiptCustomer = (de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentreceiptCustomer) obj;
			if (null == this.getPaymentreceiptnumber() || null == paymentreceiptCustomer.getPaymentreceiptnumber()) return false;
			else return (this.getPaymentreceiptnumber().equals(paymentreceiptCustomer.getPaymentreceiptnumber()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getPaymentreceiptnumber()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getPaymentreceiptnumber().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}