package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the articlenumber table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="articlenumber"
 */

public abstract class BaseArticlenumber  implements Serializable {

	public static String REF = "Articlenumber";
	public static String PROP_ID = "Id";
	public static String PROP_ANUMBER = "Anumber";


	// constructors
	public BaseArticlenumber () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseArticlenumber (de.htwg_konstanz.ebus.framework.wholesaler.vo.ArticlenumberPK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseArticlenumber (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ArticlenumberPK id,
		java.lang.String anumber) {

		this.setId(id);
		this.setAnumber(anumber);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.ArticlenumberPK id;

	// fields
	private java.lang.String anumber;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ArticlenumberPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (de.htwg_konstanz.ebus.framework.wholesaler.vo.ArticlenumberPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: anumber
	 */
	public java.lang.String getAnumber () {
		return anumber;
	}

	/**
	 * Set the value related to the column: anumber
	 * @param anumber the anumber value
	 */
	public void setAnumber (java.lang.String anumber) {
		this.anumber = anumber;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Articlenumber)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Articlenumber articlenumber = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Articlenumber) obj;
			if (null == this.getId() || null == articlenumber.getId()) return false;
			else return (this.getId().equals(articlenumber.getId()));
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