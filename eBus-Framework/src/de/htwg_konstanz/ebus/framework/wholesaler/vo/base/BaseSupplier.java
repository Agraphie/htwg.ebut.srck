package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the supplier table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="supplier"
 */

public abstract class BaseSupplier  implements Serializable {

	public static String REF = "Supplier";
	public static String PROP_WS_CATALOG_ENDPOINT = "wsCatalogEndpoint";
	public static String PROP_WS_PASSWORD = "wsPassword";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_LASTNAME = "Lastname";
	public static String PROP_FIRSTNAME = "Firstname";
	public static String PROP_SUPPLIERNUMBER = "suppliernumber";
	public static String PROP_REMARK = "Remark";
	public static String PROP_WS_ORDER_ENDPOINT = "wsOrderEndpoint";
	public static String PROP_WS_USER_NAME = "wsUserName";
	public static String PROP_COMPANYNAME = "Companyname";


	// constructors
	public BaseSupplier () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSupplier (java.lang.String suppliernumber) {
		this.setSuppliernumber(suppliernumber);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseSupplier (
		java.lang.String suppliernumber,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Address address,
		java.lang.String companyname) {

		this.setSuppliernumber(suppliernumber);
		this.setAddress(address);
		this.setCompanyname(companyname);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String suppliernumber;

	// fields
	private java.lang.String companyname;
	private java.lang.String firstname;
	private java.lang.String lastname;
	private java.lang.String remark;
	private java.lang.String wsUserName;
	private java.lang.String wsPassword;
	private java.lang.String wsCatalogEndpoint;
	private java.lang.String wsOrderEndpoint;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Address address;

	// collections
	private java.util.Set<de.htwg_konstanz.ebus.framework.wholesaler.vo.Product> products;
	private java.util.Set<de.htwg_konstanz.ebus.framework.wholesaler.vo.UserSupplier> userSuppliers;
	private java.util.Set<de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplieridentification> supplieridentifications;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="suppliernumber"
     */
	public java.lang.String getSuppliernumber () {
		return suppliernumber;
	}

	/**
	 * Set the unique identifier of this class
	 * @param suppliernumber the new ID
	 */
	public void setSuppliernumber (java.lang.String suppliernumber) {
		this.suppliernumber = suppliernumber;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: companyname
	 */
	public java.lang.String getCompanyname () {
		return companyname;
	}

	/**
	 * Set the value related to the column: companyname
	 * @param companyname the companyname value
	 */
	public void setCompanyname (java.lang.String companyname) {
		this.companyname = companyname;
	}



	/**
	 * Return the value associated with the column: firstname
	 */
	public java.lang.String getFirstname () {
		return firstname;
	}

	/**
	 * Set the value related to the column: firstname
	 * @param firstname the firstname value
	 */
	public void setFirstname (java.lang.String firstname) {
		this.firstname = firstname;
	}



	/**
	 * Return the value associated with the column: lastname
	 */
	public java.lang.String getLastname () {
		return lastname;
	}

	/**
	 * Set the value related to the column: lastname
	 * @param lastname the lastname value
	 */
	public void setLastname (java.lang.String lastname) {
		this.lastname = lastname;
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
	 * Return the value associated with the column: ws_user_name
	 */
	public java.lang.String getWsUserName () {
		return wsUserName;
	}

	/**
	 * Set the value related to the column: ws_user_name
	 * @param wsUserName the ws_user_name value
	 */
	public void setWsUserName (java.lang.String wsUserName) {
		this.wsUserName = wsUserName;
	}



	/**
	 * Return the value associated with the column: ws_password
	 */
	public java.lang.String getWsPassword () {
		return wsPassword;
	}

	/**
	 * Set the value related to the column: ws_password
	 * @param wsPassword the ws_password value
	 */
	public void setWsPassword (java.lang.String wsPassword) {
		this.wsPassword = wsPassword;
	}



	/**
	 * Return the value associated with the column: ws_catalog_endpoint
	 */
	public java.lang.String getWsCatalogEndpoint () {
		return wsCatalogEndpoint;
	}

	/**
	 * Set the value related to the column: ws_catalog_endpoint
	 * @param wsCatalogEndpoint the ws_catalog_endpoint value
	 */
	public void setWsCatalogEndpoint (java.lang.String wsCatalogEndpoint) {
		this.wsCatalogEndpoint = wsCatalogEndpoint;
	}



	/**
	 * Return the value associated with the column: ws_order_endpoint
	 */
	public java.lang.String getWsOrderEndpoint () {
		return wsOrderEndpoint;
	}

	/**
	 * Set the value related to the column: ws_order_endpoint
	 * @param wsOrderEndpoint the ws_order_endpoint value
	 */
	public void setWsOrderEndpoint (java.lang.String wsOrderEndpoint) {
		this.wsOrderEndpoint = wsOrderEndpoint;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Address getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (de.htwg_konstanz.ebus.framework.wholesaler.vo.Address address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: Products
	 */
	public java.util.Set<de.htwg_konstanz.ebus.framework.wholesaler.vo.Product> getProducts () {
		return products;
	}

	/**
	 * Set the value related to the column: Products
	 * @param products the Products value
	 */
	public void setProducts (java.util.Set<de.htwg_konstanz.ebus.framework.wholesaler.vo.Product> products) {
		this.products = products;
	}

	public void addToProducts (de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product) {
		if (null == getProducts()) setProducts(new java.util.TreeSet<de.htwg_konstanz.ebus.framework.wholesaler.vo.Product>());
		getProducts().add(product);
	}



	/**
	 * Return the value associated with the column: UserSuppliers
	 */
	public java.util.Set<de.htwg_konstanz.ebus.framework.wholesaler.vo.UserSupplier> getUserSuppliers () {
		return userSuppliers;
	}

	/**
	 * Set the value related to the column: UserSuppliers
	 * @param userSuppliers the UserSuppliers value
	 */
	public void setUserSuppliers (java.util.Set<de.htwg_konstanz.ebus.framework.wholesaler.vo.UserSupplier> userSuppliers) {
		this.userSuppliers = userSuppliers;
	}

	public void addToUserSuppliers (de.htwg_konstanz.ebus.framework.wholesaler.vo.UserSupplier userSupplier) {
		if (null == getUserSuppliers()) setUserSuppliers(new java.util.TreeSet<de.htwg_konstanz.ebus.framework.wholesaler.vo.UserSupplier>());
		getUserSuppliers().add(userSupplier);
	}



	/**
	 * Return the value associated with the column: Supplieridentifications
	 */
	public java.util.Set<de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplieridentification> getSupplieridentifications () {
		return supplieridentifications;
	}

	/**
	 * Set the value related to the column: Supplieridentifications
	 * @param supplieridentifications the Supplieridentifications value
	 */
	public void setSupplieridentifications (java.util.Set<de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplieridentification> supplieridentifications) {
		this.supplieridentifications = supplieridentifications;
	}

	public void addToSupplieridentifications (de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplieridentification supplieridentification) {
		if (null == getSupplieridentifications()) setSupplieridentifications(new java.util.TreeSet<de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplieridentification>());
		getSupplieridentifications().add(supplieridentification);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier supplier = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier) obj;
			if (null == this.getSuppliernumber() || null == supplier.getSuppliernumber()) return false;
			else return (this.getSuppliernumber().equals(supplier.getSuppliernumber()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getSuppliernumber()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getSuppliernumber().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}