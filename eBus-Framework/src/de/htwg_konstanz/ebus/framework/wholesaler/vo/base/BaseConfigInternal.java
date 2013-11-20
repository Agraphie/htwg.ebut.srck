package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the config_internal table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="config_internal"
 */

public abstract class BaseConfigInternal  implements Serializable {

	public static String REF = "ConfigInternal";
	public static String PROP_MULTIMEDIA_DOCROOT = "MultimediaDocroot";
	public static String PROP_WHOLESALERADDRESS = "Wholesaleraddress";
	public static String PROP_MARGIN_ON_SALES = "MarginOnSales";
	public static String PROP_NUMBER_TO_REORDER = "NumberToReorder";
	public static String PROP_ID = "Id";
	public static String PROP_THRESHOLD_REORDER = "ThresholdReorder";


	// constructors
	public BaseConfigInternal () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseConfigInternal (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseConfigInternal (
		java.lang.Integer id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Address wholesaleraddress,
		java.lang.Integer marginOnSales,
		java.lang.Integer thresholdReorder,
		java.lang.Integer numberToReorder,
		java.lang.String multimediaDocroot) {

		this.setId(id);
		this.setWholesaleraddress(wholesaleraddress);
		this.setMarginOnSales(marginOnSales);
		this.setThresholdReorder(thresholdReorder);
		this.setNumberToReorder(numberToReorder);
		this.setMultimediaDocroot(multimediaDocroot);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer marginOnSales;
	private java.lang.Integer thresholdReorder;
	private java.lang.Integer numberToReorder;
	private java.lang.String multimediaDocroot;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Address wholesaleraddress;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: margin_on_sales
	 */
	public java.lang.Integer getMarginOnSales () {
		return marginOnSales;
	}

	/**
	 * Set the value related to the column: margin_on_sales
	 * @param marginOnSales the margin_on_sales value
	 */
	public void setMarginOnSales (java.lang.Integer marginOnSales) {
		this.marginOnSales = marginOnSales;
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
	 * Return the value associated with the column: multimedia_docroot
	 */
	public java.lang.String getMultimediaDocroot () {
		return multimediaDocroot;
	}

	/**
	 * Set the value related to the column: multimedia_docroot
	 * @param multimediaDocroot the multimedia_docroot value
	 */
	public void setMultimediaDocroot (java.lang.String multimediaDocroot) {
		this.multimediaDocroot = multimediaDocroot;
	}



	/**
	 * Return the value associated with the column: wholesaleraddress
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Address getWholesaleraddress () {
		return wholesaleraddress;
	}

	/**
	 * Set the value related to the column: wholesaleraddress
	 * @param wholesaleraddress the wholesaleraddress value
	 */
	public void setWholesaleraddress (de.htwg_konstanz.ebus.framework.wholesaler.vo.Address wholesaleraddress) {
		this.wholesaleraddress = wholesaleraddress;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.ConfigInternal)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.ConfigInternal configInternal = (de.htwg_konstanz.ebus.framework.wholesaler.vo.ConfigInternal) obj;
			if (null == this.getId() || null == configInternal.getId()) return false;
			else return (this.getId().equals(configInternal.getId()));
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