package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the articlenumbertype table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="articlenumbertype"
 */

public abstract class BaseArticlenumbertype  implements Serializable {

	public static String REF = "Articlenumbertype";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ARTICLENUMBERTYPE = "articlenumbertype";


	// constructors
	public BaseArticlenumbertype () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseArticlenumbertype (java.lang.String articlenumbertype) {
		this.setArticlenumbertype(articlenumbertype);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseArticlenumbertype (
		java.lang.String articlenumbertype,
		java.lang.String description) {

		this.setArticlenumbertype(articlenumbertype);
		this.setDescription(description);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String articlenumbertype;

	// fields
	private java.lang.String description;

	// collections
	private java.util.Set<de.htwg_konstanz.ebus.framework.wholesaler.vo.Product> products;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="articlenumbertype"
     */
	public java.lang.String getArticlenumbertype () {
		return articlenumbertype;
	}

	/**
	 * Set the unique identifier of this class
	 * @param articlenumbertype the new ID
	 */
	public void setArticlenumbertype (java.lang.String articlenumbertype) {
		this.articlenumbertype = articlenumbertype;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Articlenumbertype)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Articlenumbertype articlenumbertype = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Articlenumbertype) obj;
			if (null == this.getArticlenumbertype() || null == articlenumbertype.getArticlenumbertype()) return false;
			else return (this.getArticlenumbertype().equals(articlenumbertype.getArticlenumbertype()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getArticlenumbertype()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getArticlenumbertype().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}