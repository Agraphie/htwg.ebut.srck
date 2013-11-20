package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customeridentifcation table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customeridentifcation"
 */

public abstract class BaseCustomeridentifcation  implements Serializable {

	public static String REF = "Customeridentifcation";
	public static String PROP_CUSTOMER = "Customer";
	public static String PROP_ID = "Id";


	// constructors
	public BaseCustomeridentifcation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomeridentifcation (de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK id;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: customer
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer getCustomer () {
		return customer;
	}

	/**
	 * Set the value related to the column: customer
	 * @param customer the customer value
	 */
	public void setCustomer (de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer) {
		this.customer = customer;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation customeridentifcation = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation) obj;
			if (null == this.getId() || null == customeridentifcation.getId()) return false;
			else return (this.getId().equals(customeridentifcation.getId()));
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