package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the supplieridentification table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="supplieridentification"
 */

public abstract class BaseSupplieridentification  implements Serializable {

	public static String REF = "Supplieridentification";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_ID = "Id";


	// constructors
	public BaseSupplieridentification () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSupplieridentification (de.htwg_konstanz.ebus.framework.wholesaler.vo.SupplieridentificationPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.SupplieridentificationPK id;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier supplier;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.SupplieridentificationPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (de.htwg_konstanz.ebus.framework.wholesaler.vo.SupplieridentificationPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: supplier
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier getSupplier () {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier
	 * @param supplier the supplier value
	 */
	public void setSupplier (de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier supplier) {
		this.supplier = supplier;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplieridentification)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplieridentification supplieridentification = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplieridentification) obj;
			if (null == this.getId() || null == supplieridentification.getId()) return false;
			else return (this.getId().equals(supplieridentification.getId()));
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