package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the productcategory table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="productcategory"
 */

public abstract class BaseProductcategory  implements Serializable {

	public static String REF = "Productcategory";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_PARENTCATEGORY = "Parentcategory";
	public static String PROP_SHORTDESCRIPTION = "Shortdescription";


	// constructors
	public BaseProductcategory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProductcategory (java.lang.String shortdescription) {
		this.setShortdescription(shortdescription);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String shortdescription;

	// fields
	private java.lang.String description;
	private java.lang.String parentcategory;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="shortdescription"
     */
	public java.lang.String getShortdescription () {
		return shortdescription;
	}

	/**
	 * Set the unique identifier of this class
	 * @param shortdescription the new ID
	 */
	public void setShortdescription (java.lang.String shortdescription) {
		this.shortdescription = shortdescription;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: parentcategory
	 */
	public java.lang.String getParentcategory () {
		return parentcategory;
	}

	/**
	 * Set the value related to the column: parentcategory
	 * @param parentcategory the parentcategory value
	 */
	public void setParentcategory (java.lang.String parentcategory) {
		this.parentcategory = parentcategory;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Productcategory)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Productcategory productcategory = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Productcategory) obj;
			if (null == this.getShortdescription() || null == productcategory.getShortdescription()) return false;
			else return (this.getShortdescription().equals(productcategory.getShortdescription()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getShortdescription()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getShortdescription().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}