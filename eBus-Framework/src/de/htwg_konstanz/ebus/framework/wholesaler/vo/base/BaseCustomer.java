package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customer"
 */

public abstract class BaseCustomer  implements Serializable {

	public static String REF = "Customer";
	public static String PROP_WS_INVOICE_ENDPOINT = "wsInvoiceEndpoint";
	public static String PROP_WS_PASSWORD = "wsPassword";
	public static String PROP_WS_DELIVERY_ENDPOINT = "wsDeliveryEndpoint";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_LASTNAME = "Lastname";
	public static String PROP_FIRSTNAME = "Firstname";
	public static String PROP_REMARK = "Remark";
	public static String PROP_WS_USER_NAME = "wsUserName";
	public static String PROP_CUSTOMERID = "customerid";
	public static String PROP_COMPANYNAME = "Companyname";


	// constructors
	public BaseCustomer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomer (java.lang.String customerid) {
		this.setCustomerid(customerid);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCustomer (
		java.lang.String customerid,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Address address,
		java.lang.String companyname,
		java.lang.String firstname,
		java.lang.String lastname,
		java.lang.String wsUserName,
		java.lang.String wsPassword,
		java.lang.String wsDeliveryEndpoint,
		java.lang.String wsInvoiceEndpoint) {

		this.setCustomerid(customerid);
		this.setAddress(address);
		this.setCompanyname(companyname);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setWsUserName(wsUserName);
		this.setWsPassword(wsPassword);
		this.setWsDeliveryEndpoint(wsDeliveryEndpoint);
		this.setWsInvoiceEndpoint(wsInvoiceEndpoint);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String customerid;

	// fields
	private java.lang.String companyname;
	private java.lang.String firstname;
	private java.lang.String lastname;
	private java.lang.String remark;
	private java.lang.String wsUserName;
	private java.lang.String wsPassword;
	private java.lang.String wsDeliveryEndpoint;
	private java.lang.String wsInvoiceEndpoint;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Address address;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="customerid"
     */
	public java.lang.String getCustomerid () {
		return customerid;
	}

	/**
	 * Set the unique identifier of this class
	 * @param customerid the new ID
	 */
	public void setCustomerid (java.lang.String customerid) {
		this.customerid = customerid;
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
	 * Return the value associated with the column: ws_delivery_endpoint
	 */
	public java.lang.String getWsDeliveryEndpoint () {
		return wsDeliveryEndpoint;
	}

	/**
	 * Set the value related to the column: ws_delivery_endpoint
	 * @param wsDeliveryEndpoint the ws_delivery_endpoint value
	 */
	public void setWsDeliveryEndpoint (java.lang.String wsDeliveryEndpoint) {
		this.wsDeliveryEndpoint = wsDeliveryEndpoint;
	}



	/**
	 * Return the value associated with the column: ws_invoice_endpoint
	 */
	public java.lang.String getWsInvoiceEndpoint () {
		return wsInvoiceEndpoint;
	}

	/**
	 * Set the value related to the column: ws_invoice_endpoint
	 * @param wsInvoiceEndpoint the ws_invoice_endpoint value
	 */
	public void setWsInvoiceEndpoint (java.lang.String wsInvoiceEndpoint) {
		this.wsInvoiceEndpoint = wsInvoiceEndpoint;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer) obj;
			if (null == this.getCustomerid() || null == customer.getCustomerid()) return false;
			else return (this.getCustomerid().equals(customer.getCustomerid()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCustomerid()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCustomerid().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}