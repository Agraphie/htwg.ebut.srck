package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the user_supplier table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="user_supplier"
 */

public abstract class BaseUserSupplier  implements Serializable {

	public static String REF = "UserSupplier";
	public static String PROP_LOGIN = "Login";
	public static String PROP_PASSWD = "Passwd";
	public static String PROP_TITLE = "Title";
	public static String PROP_PHONENUMBER = "Phonenumber";
	public static String PROP_FAXNUMBER = "Faxnumber";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_EMAIL = "Email";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_LASTNAME = "Lastname";
	public static String PROP_FIRSTNAME = "Firstname";
	public static String PROP_ID = "Id";
	public static String PROP_MOBILENUMBER = "Mobilenumber";
	public static String PROP_REMARK = "Remark";


	// constructors
	public BaseUserSupplier () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserSupplier (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUserSupplier (
		java.lang.Integer id,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier supplier,
		java.lang.String lastname) {

		this.setId(id);
		this.setSupplier(supplier);
		this.setLastname(lastname);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String lastname;
	private java.lang.String firstname;
	private java.lang.String title;
	private java.lang.String email;
	private java.lang.String phonenumber;
	private java.lang.String mobilenumber;
	private java.lang.String faxnumber;
	private java.lang.String login;
	private java.lang.String passwd;
	private java.lang.String remark;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier supplier;
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Address address;



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
	 * Return the value associated with the column: title
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: title
	 * @param title the title value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
	}



	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: phonenumber
	 */
	public java.lang.String getPhonenumber () {
		return phonenumber;
	}

	/**
	 * Set the value related to the column: phonenumber
	 * @param phonenumber the phonenumber value
	 */
	public void setPhonenumber (java.lang.String phonenumber) {
		this.phonenumber = phonenumber;
	}



	/**
	 * Return the value associated with the column: mobilenumber
	 */
	public java.lang.String getMobilenumber () {
		return mobilenumber;
	}

	/**
	 * Set the value related to the column: mobilenumber
	 * @param mobilenumber the mobilenumber value
	 */
	public void setMobilenumber (java.lang.String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}



	/**
	 * Return the value associated with the column: faxnumber
	 */
	public java.lang.String getFaxnumber () {
		return faxnumber;
	}

	/**
	 * Set the value related to the column: faxnumber
	 * @param faxnumber the faxnumber value
	 */
	public void setFaxnumber (java.lang.String faxnumber) {
		this.faxnumber = faxnumber;
	}



	/**
	 * Return the value associated with the column: login
	 */
	public java.lang.String getLogin () {
		return login;
	}

	/**
	 * Set the value related to the column: login
	 * @param login the login value
	 */
	public void setLogin (java.lang.String login) {
		this.login = login;
	}



	/**
	 * Return the value associated with the column: passwd
	 */
	public java.lang.String getPasswd () {
		return passwd;
	}

	/**
	 * Set the value related to the column: passwd
	 * @param passwd the passwd value
	 */
	public void setPasswd (java.lang.String passwd) {
		this.passwd = passwd;
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
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.UserSupplier)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.UserSupplier userSupplier = (de.htwg_konstanz.ebus.framework.wholesaler.vo.UserSupplier) obj;
			if (null == this.getId() || null == userSupplier.getId()) return false;
			else return (this.getId().equals(userSupplier.getId()));
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