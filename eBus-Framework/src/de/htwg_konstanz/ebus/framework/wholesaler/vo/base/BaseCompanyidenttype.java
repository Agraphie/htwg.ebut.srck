package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the companyidenttype table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="companyidenttype"
 */

public abstract class BaseCompanyidenttype  implements Serializable {

	public static String REF = "Companyidenttype";
	public static String PROP_COMPANYIDENTTYPE = "companyidenttype";
	public static String PROP_DESCRIPTION = "Description";


	// constructors
	public BaseCompanyidenttype () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCompanyidenttype (java.lang.String companyidenttype) {
		this.setCompanyidenttype(companyidenttype);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCompanyidenttype (
		java.lang.String companyidenttype,
		java.lang.String description) {

		this.setCompanyidenttype(companyidenttype);
		this.setDescription(description);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String companyidenttype;

	// fields
	private java.lang.String description;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="companyidenttype"
     */
	public java.lang.String getCompanyidenttype () {
		return companyidenttype;
	}

	/**
	 * Set the unique identifier of this class
	 * @param companyidenttype the new ID
	 */
	public void setCompanyidenttype (java.lang.String companyidenttype) {
		this.companyidenttype = companyidenttype;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Companyidenttype)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Companyidenttype companyidenttype = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Companyidenttype) obj;
			if (null == this.getCompanyidenttype() || null == companyidenttype.getCompanyidenttype()) return false;
			else return (this.getCompanyidenttype().equals(companyidenttype.getCompanyidenttype()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCompanyidenttype()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCompanyidenttype().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}