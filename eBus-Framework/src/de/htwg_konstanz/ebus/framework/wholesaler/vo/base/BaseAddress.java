package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the address table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="address"
 */

public abstract class BaseAddress  implements Serializable {

	public static String REF = "Address";
	public static String PROP_STREET = "Street";
	public static String PROP_ID = "Id";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_ZIPCODE = "Zipcode";
	public static String PROP_CITY = "City";


	// constructors
	public BaseAddress () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAddress (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAddress (
		java.lang.String id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Country country,
		java.lang.String street,
		java.lang.String zipcode,
		java.lang.String city) {

		this.setId(id);
		this.setCountry(country);
		this.setStreet(street);
		this.setZipcode(zipcode);
		this.setCity(city);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String street;
	private java.lang.String zipcode;
	private java.lang.String city;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Country country;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="id"
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
	 * Return the value associated with the column: street
	 */
	public java.lang.String getStreet () {
		return street;
	}

	/**
	 * Set the value related to the column: street
	 * @param street the street value
	 */
	public void setStreet (java.lang.String street) {
		this.street = street;
	}



	/**
	 * Return the value associated with the column: zipcode
	 */
	public java.lang.String getZipcode () {
		return zipcode;
	}

	/**
	 * Set the value related to the column: zipcode
	 * @param zipcode the zipcode value
	 */
	public void setZipcode (java.lang.String zipcode) {
		this.zipcode = zipcode;
	}



	/**
	 * Return the value associated with the column: city
	 */
	public java.lang.String getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city
	 * @param city the city value
	 */
	public void setCity (java.lang.String city) {
		this.city = city;
	}



	/**
	 * Return the value associated with the column: country
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Country getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: country
	 * @param country the country value
	 */
	public void setCountry (de.htwg_konstanz.ebus.framework.wholesaler.vo.Country country) {
		this.country = country;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Address)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Address address = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Address) obj;
			if (null == this.getId() || null == address.getId()) return false;
			else return (this.getId().equals(address.getId()));
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