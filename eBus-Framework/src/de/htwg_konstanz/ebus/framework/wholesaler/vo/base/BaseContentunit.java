package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the contentunit table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="contentunit"
 */

public abstract class BaseContentunit  implements Serializable {

	public static String REF = "Contentunit";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_CODE = "code";


	// constructors
	public BaseContentunit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseContentunit (java.lang.String code) {
		this.setCode(code);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseContentunit (
		java.lang.String code,
		java.lang.String description) {

		this.setCode(code);
		this.setDescription(description);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String code;

	// fields
	private java.lang.String description;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="code"
     */
	public java.lang.String getCode () {
		return code;
	}

	/**
	 * Set the unique identifier of this class
	 * @param code the new ID
	 */
	public void setCode (java.lang.String code) {
		this.code = code;
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
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Contentunit)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Contentunit contentunit = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Contentunit) obj;
			if (null == this.getCode() || null == contentunit.getCode()) return false;
			else return (this.getCode().equals(contentunit.getCode()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCode()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCode().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}