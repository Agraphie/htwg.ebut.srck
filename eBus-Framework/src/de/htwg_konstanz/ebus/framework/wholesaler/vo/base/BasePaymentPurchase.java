package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the payment_purchase table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="payment_purchase"
 */

public abstract class BasePaymentPurchase  implements Serializable {

	public static String REF = "PaymentPurchase";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_PAYMENTINFOTEXT = "Paymentinfotext";
	public static String PROP_PAYMENTINFORMATION = "Paymentinformation";
	public static String PROP_ID = "Id";
	public static String PROP_PAYMENTDATE = "Paymentdate";
	public static String PROP_CURRENCY = "Currency";
	public static String PROP_PAYMENTTYPE = "Paymenttype";


	// constructors
	public BasePaymentPurchase () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePaymentPurchase (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePaymentPurchase (
		java.lang.String id,
		java.util.Date paymentdate,
		java.lang.String supplier,
		java.lang.String currency) {

		this.setId(id);
		this.setPaymentdate(paymentdate);
		this.setSupplier(supplier);
		this.setCurrency(currency);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.util.Date paymentdate;
	private java.lang.String paymenttype;
	private java.lang.String paymentinformation;
	private java.lang.String paymentinfotext;
	private java.lang.String supplier;
	private java.math.BigDecimal amount;
	private java.lang.String currency;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.Assigned"
     *  column="paymentnumber"
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
	 * Return the value associated with the column: paymentdate
	 */
	public java.util.Date getPaymentdate () {
		return paymentdate;
	}

	/**
	 * Set the value related to the column: paymentdate
	 * @param paymentdate the paymentdate value
	 */
	public void setPaymentdate (java.util.Date paymentdate) {
		this.paymentdate = paymentdate;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentPurchase)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentPurchase paymentPurchase = (de.htwg_konstanz.ebus.framework.wholesaler.vo.PaymentPurchase) obj;
			if (null == this.getId() || null == paymentPurchase.getId()) return false;
			else return (this.getId().equals(paymentPurchase.getId()));
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