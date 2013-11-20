package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the productreference table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="productreference"
 */

public abstract class BaseProductreference  implements Serializable {

	public static String REF = "Productreference";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_ID = "Id";
	public static String PROP_REFERENCETYPE = "Referencetype";
	public static String PROP_REMARK = "Remark";


	// constructors
	public BaseProductreference () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProductreference (de.htwg_konstanz.ebus.framework.wholesaler.vo.ProductreferencePK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.ProductreferencePK id;

	// fields
	private java.lang.String referencetype;
	private java.lang.Integer quantity;
	private java.lang.String remark;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ProductreferencePK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (de.htwg_konstanz.ebus.framework.wholesaler.vo.ProductreferencePK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: referencetype
	 */
	public java.lang.String getReferencetype () {
		return referencetype;
	}

	/**
	 * Set the value related to the column: referencetype
	 * @param referencetype the referencetype value
	 */
	public void setReferencetype (java.lang.String referencetype) {
		this.referencetype = referencetype;
	}



	/**
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.Integer quantity) {
		this.quantity = quantity;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Productreference)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Productreference productreference = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Productreference) obj;
			if (null == this.getId() || null == productreference.getId()) return false;
			else return (this.getId().equals(productreference.getId()));
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