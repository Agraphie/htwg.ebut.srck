package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the inventory table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="inventory"
 */

public abstract class BaseInventory  implements Serializable {

	public static String REF = "Inventory";
	public static String PROP_PRODUCT = "Product";
	public static String PROP_RELATIVEPATH_DIGITALPRODUCT = "RelativepathDigitalproduct";
	public static String PROP_NUMBER_TO_REORDER = "NumberToReorder";
	public static String PROP_INVENTORY = "Inventory";
	public static String PROP_NONPHYSICALDELIVERY = "Nonphysicaldelivery";
	public static String PROP_THRESHOLD_REORDER = "ThresholdReorder";


	// constructors
	public BaseInventory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInventory (java.lang.Integer product) {
		this.setProduct(product);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer product;

	// fields
	private java.lang.Integer inventory;
	private java.lang.Integer thresholdReorder;
	private java.lang.Integer numberToReorder;
	private java.lang.Integer nonphysicaldelivery;
	private java.lang.String relativepathDigitalproduct;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="product"
     */
	public java.lang.Integer getProduct () {
		return product;
	}

	/**
	 * Set the unique identifier of this class
	 * @param product the new ID
	 */
	public void setProduct (java.lang.Integer product) {
		this.product = product;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: inventory
	 */
	public java.lang.Integer getInventory () {
		return inventory;
	}

	/**
	 * Set the value related to the column: inventory
	 * @param inventory the inventory value
	 */
	public void setInventory (java.lang.Integer inventory) {
		this.inventory = inventory;
	}



	/**
	 * Return the value associated with the column: threshold_reorder
	 */
	public java.lang.Integer getThresholdReorder () {
		return thresholdReorder;
	}

	/**
	 * Set the value related to the column: threshold_reorder
	 * @param thresholdReorder the threshold_reorder value
	 */
	public void setThresholdReorder (java.lang.Integer thresholdReorder) {
		this.thresholdReorder = thresholdReorder;
	}



	/**
	 * Return the value associated with the column: number_to_reorder
	 */
	public java.lang.Integer getNumberToReorder () {
		return numberToReorder;
	}

	/**
	 * Set the value related to the column: number_to_reorder
	 * @param numberToReorder the number_to_reorder value
	 */
	public void setNumberToReorder (java.lang.Integer numberToReorder) {
		this.numberToReorder = numberToReorder;
	}



	/**
	 * Return the value associated with the column: nonphysicaldelivery
	 */
	public java.lang.Integer getNonphysicaldelivery () {
		return nonphysicaldelivery;
	}

	/**
	 * Set the value related to the column: nonphysicaldelivery
	 * @param nonphysicaldelivery the nonphysicaldelivery value
	 */
	public void setNonphysicaldelivery (java.lang.Integer nonphysicaldelivery) {
		this.nonphysicaldelivery = nonphysicaldelivery;
	}



	/**
	 * Return the value associated with the column: relativepath_digitalproduct
	 */
	public java.lang.String getRelativepathDigitalproduct () {
		return relativepathDigitalproduct;
	}

	/**
	 * Set the value related to the column: relativepath_digitalproduct
	 * @param relativepathDigitalproduct the relativepath_digitalproduct value
	 */
	public void setRelativepathDigitalproduct (java.lang.String relativepathDigitalproduct) {
		this.relativepathDigitalproduct = relativepathDigitalproduct;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Inventory)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Inventory inventory = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Inventory) obj;
			if (null == this.getProduct() || null == inventory.getProduct()) return false;
			else return (this.getProduct().equals(inventory.getProduct()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getProduct()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getProduct().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}