package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the salesprice table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="salesprice"
 */

public abstract class BaseSalesprice  implements Serializable {

	public static String REF = "Salesprice";
	public static String PROP_PRICEUNIT = "Priceunit";
	public static String PROP_TAXRATE = "Taxrate";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_PRODUCT = "Product";
	public static String PROP_ID = "Id";
	public static String PROP_LOWERBOUND_SCALEDPRICE = "LowerboundScaledprice";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_REMARK = "Remark";
	public static String PROP_PRICETYPE = "Pricetype";


	// constructors
	public BaseSalesprice () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSalesprice (de.htwg_konstanz.ebus.framework.wholesaler.vo.SalespricePK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseSalesprice (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.SalespricePK id,
		java.lang.String pricetype,
		java.math.BigDecimal taxrate,
		java.math.BigDecimal amount) {

		this.setId(id);
		this.setPricetype(pricetype);
		this.setTaxrate(taxrate);
		this.setAmount(amount);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.SalespricePK id;

	// fields
	private java.lang.Integer lowerboundScaledprice;
	private java.lang.Integer priceunit;
	private java.lang.String pricetype;
	private java.math.BigDecimal taxrate;
	private java.math.BigDecimal amount;
	private java.lang.String remark;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product;
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Country country;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.SalespricePK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (de.htwg_konstanz.ebus.framework.wholesaler.vo.SalespricePK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: lowerbound_scaledprice
	 */
	public java.lang.Integer getLowerboundScaledprice () {
		return lowerboundScaledprice;
	}

	/**
	 * Set the value related to the column: lowerbound_scaledprice
	 * @param lowerboundScaledprice the lowerbound_scaledprice value
	 */
	public void setLowerboundScaledprice (java.lang.Integer lowerboundScaledprice) {
		this.lowerboundScaledprice = lowerboundScaledprice;
	}



	/**
	 * Return the value associated with the column: priceunit
	 */
	public java.lang.Integer getPriceunit () {
		return priceunit;
	}

	/**
	 * Set the value related to the column: priceunit
	 * @param priceunit the priceunit value
	 */
	public void setPriceunit (java.lang.Integer priceunit) {
		this.priceunit = priceunit;
	}



	/**
	 * Return the value associated with the column: pricetype
	 */
	public java.lang.String getPricetype () {
		return pricetype;
	}

	/**
	 * Set the value related to the column: pricetype
	 * @param pricetype the pricetype value
	 */
	public void setPricetype (java.lang.String pricetype) {
		this.pricetype = pricetype;
	}



	/**
	 * Return the value associated with the column: taxrate
	 */
	public java.math.BigDecimal getTaxrate () {
		return taxrate;
	}

	/**
	 * Set the value related to the column: taxrate
	 * @param taxrate the taxrate value
	 */
	public void setTaxrate (java.math.BigDecimal taxrate) {
		this.taxrate = taxrate;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
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
	 * Return the value associated with the column: product
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Product getProduct () {
		return product;
	}

	/**
	 * Set the value related to the column: product
	 * @param product the product value
	 */
	public void setProduct (de.htwg_konstanz.ebus.framework.wholesaler.vo.Product product) {
		this.product = product;
	}



	/**
	 * Return the value associated with the column: country
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Country getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: country
	 * @param country the country value
	 */
	public void setCountry (de.htwg_konstanz.ebus.framework.wholesaler.vo.Country country) {
		this.country = country;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.Salesprice)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.Salesprice salesprice = (de.htwg_konstanz.ebus.framework.wholesaler.vo.Salesprice) obj;
			if (null == this.getId() || null == salesprice.getId()) return false;
			else return (this.getId().equals(salesprice.getId()));
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