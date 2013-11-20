package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the product table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="product"
 */

public abstract class BaseProduct  implements Serializable {

	public static String REF = "Product";
	public static String PROP_MANUFACTURERTYPEDESCRIPTION = "Manufacturertypedescription";
	public static String PROP_SHORTDESCRIPTION_CUSTOMER = "ShortdescriptionCustomer";
	public static String PROP_ORDERNUMBER_SUPPLIER = "OrdernumberSupplier";
	public static String PROP_LONGDESCRIPTION = "Longdescription";
	public static String PROP_PRODUCTSTATUS = "Productstatus";
	public static String PROP_PRODUCTTYPE = "Producttype";
	public static String PROP_PRODUCTCATEGORY = "Productcategory";
	public static String PROP_ORDERNUMBER_CUSTOMER = "OrdernumberCustomer";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_LONGDESCRIPTION_CUSTOMER = "LongdescriptionCustomer";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_REMARK = "Remark";
	public static String PROP_SHORTDESCRIPTION = "Shortdescription";
	public static String PROP_MATERIALNUMBER = "materialnumber";


	// constructors
	public BaseProduct () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProduct (java.lang.Integer materialnumber) {
		this.setMaterialnumber(materialnumber);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseProduct (
		java.lang.Integer materialnumber,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier supplier,
		java.lang.String ordernumberSupplier,
		java.lang.String shortdescription,
		java.lang.String ordernumberCustomer) {

		this.setMaterialnumber(materialnumber);
		this.setSupplier(supplier);
		this.setOrdernumberSupplier(ordernumberSupplier);
		this.setShortdescription(shortdescription);
		this.setOrdernumberCustomer(ordernumberCustomer);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer materialnumber;

	// fields
	private java.lang.String ordernumberSupplier;
	private java.lang.String shortdescription;
	private java.lang.String longdescription;
	private java.lang.String ordernumberCustomer;
	private java.lang.String shortdescriptionCustomer;
	private java.lang.String longdescriptionCustomer;
	private java.lang.String manufacturertypedescription;
	private java.lang.String manufacturer;
	private java.lang.String productstatus;
	private java.lang.String producttype;
	private java.lang.String remark;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Productcategory productcategory;
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier supplier;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="materialnumber"
     */
	public java.lang.Integer getMaterialnumber () {
		return materialnumber;
	}

	/**
	 * Set the unique identifier of this class
	 * @param materialnumber the new ID
	 */
	public void setMaterialnumber (java.lang.Integer materialnumber) {
		this.materialnumber = materialnumber;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: ordernumber_supplier
	 */
	public java.lang.String getOrdernumberSupplier () {
		return ordernumberSupplier;
	}

	/**
	 * Set the value related to the column: ordernumber_supplier
	 * @param ordernumberSupplier the ordernumber_supplier value
	 */
	public void setOrdernumberSupplier (java.lang.String ordernumberSupplier) {
		this.ordernumberSupplier = ordernumberSupplier;
	}



	/**
	 * Return the value associated with the column: shortdescription
	 */
	public java.lang.String getShortdescription () {
		return shortdescription;
	}

	/**
	 * Set the value related to the column: shortdescription
	 * @param shortdescription the shortdescription value
	 */
	public void setShortdescription (java.lang.String shortdescription) {
		this.shortdescription = shortdescription;
	}



	/**
	 * Return the value associated with the column: longdescription
	 */
	public java.lang.String getLongdescription () {
		return longdescription;
	}

	/**
	 * Set the value related to the column: longdescription
	 * @param longdescription the longdescription value
	 */
	public void setLongdescription (java.lang.String longdescription) {
		this.longdescription = longdescription;
	}



	/**
	 * Return the value associated with the column: ordernumber_customer
	 */
	public java.lang.String getOrdernumberCustomer () {
		return ordernumberCustomer;
	}

	/**
	 * Set the value related to the column: ordernumber_customer
	 * @param ordernumberCustomer the ordernumber_customer value
	 */
	public void setOrdernumberCustomer (java.lang.String ordernumberCustomer) {
		this.ordernumberCustomer = ordernumberCustomer;
	}



	/**
	 * Return the value associated with the column: shortdescription_customer
	 */
	public java.lang.String getShortdescriptionCustomer () {
		return shortdescriptionCustomer;
	}

	/**
	 * Set the value related to the column: shortdescription_customer
	 * @param shortdescriptionCustomer the shortdescription_customer value
	 */
	public void setShortdescriptionCustomer (java.lang.String shortdescriptionCustomer) {
		this.shortdescriptionCustomer = shortdescriptionCustomer;
	}



	/**
	 * Return the value associated with the column: longdescription_customer
	 */
	public java.lang.String getLongdescriptionCustomer () {
		return longdescriptionCustomer;
	}

	/**
	 * Set the value related to the column: longdescription_customer
	 * @param longdescriptionCustomer the longdescription_customer value
	 */
	public void setLongdescriptionCustomer (java.lang.String longdescriptionCustomer) {
		this.longdescriptionCustomer = longdescriptionCustomer;
	}



	/**
	 * Return the value associated with the column: manufacturertypedescription
	 */
	public java.lang.String getManufacturertypedescription () {
		return manufacturertypedescription;
	}

	/**
	 * Set the value related to the column: manufacturertypedescription
	 * @param manufacturertypedescription the manufacturertypedescription value
	 */
	public void setManufacturertypedescription (java.lang.String manufacturertypedescription) {
		this.manufacturertypedescription = manufacturertypedescription;
	}



	/**
	 * Return the value associated with the column: manufacturer
	 */
	public java.lang.String getManufacturer () {
		return manufacturer;
	}

	/**
	 * Set the value related to the column: manufacturer
	 * @param manufacturer the manufacturer value
	 */
	public void setManufacturer (java.lang.String manufacturer) {
		this.manufacturer = manufacturer;
	}



	/**
	 * Return the value associated with the column: productstatus
	 */
	public java.lang.String getProductstatus () {
		return productstatus;
	}

	/**
	 * Set the value related to the column: productstatus
	 * @param productstatus the productstatus value
	 */
	public void setProductstatus (java.lang.String productstatus) {
		this.productstatus = productstatus;
	}



	/**
	 * Return the value associated with the column: producttype
	 */
	public java.lang.String getProducttype () {
		return producttype;
	}

	/**
	 * Set the value related to the column: producttype
	 * @param producttype the producttype value
	 */
	public void setProducttype (java.lang.String producttype) {
		this.producttype = producttype;
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



	/**
	 * Return the value associated with the column: productcategory
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Productcategory getProductcategory () {
		return productcategory;
	}

	/**
	 * Set the value related to the column: productcategory
	 * @param productcategory the productcategory value
	 */
	public void setProductcategory (de.htwg_konstanz.ebus.framework.wholesaler.vo.Productcategory productcategory) {
		this.productcategory = productcategory;
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
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Product)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Product) obj;
			if (null == this.getMaterialnumber() || null == product.getMaterialnumber()) return false;
			else return (this.getMaterialnumber().equals(product.getMaterialnumber()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getMaterialnumber()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getMaterialnumber().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}