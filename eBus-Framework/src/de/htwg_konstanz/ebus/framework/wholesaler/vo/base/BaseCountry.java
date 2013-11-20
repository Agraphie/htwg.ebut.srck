package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the country table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="country"
 */

public abstract class BaseCountry  implements Serializable {

	public static String REF = "Country";
	public static String PROP_NAME = "Name";
	public static String PROP_ISOCODE = "isocode";
	public static String PROP_CURRENCY = "Currency";


	// constructors
	public BaseCountry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCountry (java.lang.String isocode) {
		this.setIsocode(isocode);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCountry (
		java.lang.String isocode,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Currency currency,
		java.lang.String name) {

		this.setIsocode(isocode);
		this.setCurrency(currency);
		this.setName(name);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String isocode;

	// fields
	private java.lang.String name;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Currency currency;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="isocode"
     */
	public java.lang.String getIsocode () {
		return isocode;
	}

	/**
	 * Set the unique identifier of this class
	 * @param isocode the new ID
	 */
	public void setIsocode (java.lang.String isocode) {
		this.isocode = isocode;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Country)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Country country = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Country) obj;
			if (null == this.getIsocode() || null == country.getIsocode()) return false;
			else return (this.getIsocode().equals(country.getIsocode()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getIsocode()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getIsocode().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}