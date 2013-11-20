package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the order_customer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="order_customer"
 */

public abstract class BaseOrderCustomer  implements Serializable {

	public static String REF = "OrderCustomer";
	public static String PROP_INVOICEADDRESS = "Invoiceaddress";
	public static String PROP_CUSTOMER = "Customer";
	public static String PROP_XML_FILE_RESPONSE = "xmlFileResponse";
	public static String PROP_TAXAMOUNT = "Taxamount";
	public static String PROP_INTERNATIONALRESTRICTIONS = "Internationalrestrictions";
	public static String PROP_PRICETOTAL_NET = "PricetotalNet";
	public static String PROP_REJECTED = "rejected";
	public static String PROP_TOTALLINEITEMS = "Totallineitems";
	public static String PROP_XML_FILE_REQUEST = "xmlFileRequest";
	public static String PROP_PRICETOTAL_GROSS = "PricetotalGross";
	public static String PROP_DELIVERYADDRESS = "Deliveryaddress";
	public static String PROP_PARTIALSHIPMENT = "Partialshipment";
	public static String PROP_ORDERDATE = "Orderdate";
	public static String PROP_TAXTOTAL = "Taxtotal";
	public static String PROP_ORDERID_CUSTOMER = "OrderidCustomer";
	public static String PROP_TRANSPORT = "Transport";
	public static String PROP_SPECIALTREATMENT = "Specialtreatment";
	public static String PROP_SPLITTED = "splitted";
	public static String PROP_ORDERID = "Orderid";
	public static String PROP_REMARK = "Remark";
	public static String PROP_CURRENCY = "Currency";
	public static String PROP_ORDERTYPE = "Ordertype";


	// constructors
	public BaseOrderCustomer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrderCustomer (java.lang.String orderid) {
		this.setOrderid(orderid);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseOrderCustomer (
		java.lang.String orderid,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Currency currency,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Address invoiceaddress,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Address deliveryaddress,
		java.util.Date orderdate,
		java.lang.Integer totallineitems,
		boolean rejected,
		boolean splitted) {

		this.setOrderid(orderid);
		this.setCustomer(customer);
		this.setCurrency(currency);
		this.setInvoiceaddress(invoiceaddress);
		this.setDeliveryaddress(deliveryaddress);
		this.setOrderdate(orderdate);
		this.setTotallineitems(totallineitems);
		this.setRejected(rejected);
		this.setSplitted(splitted);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String orderid;

	// fields
	private java.util.Date orderdate;
	private java.lang.String ordertype;
	private java.lang.String orderidCustomer;
	private java.lang.String remark;
	private java.lang.Integer partialshipment;
	private java.lang.String transport;
	private java.lang.String specialtreatment;
	private java.lang.String internationalrestrictions;
	private java.math.BigDecimal pricetotalNet;
	private java.math.BigDecimal pricetotalGross;
	private java.math.BigDecimal taxtotal;
	private java.math.BigDecimal taxamount;
	private java.lang.Integer totallineitems;
	private byte[] xmlFileRequest;
	private byte[] xmlFileResponse;
	private boolean rejected;
	private boolean splitted;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer customer;
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Currency currency;
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Address invoiceaddress;
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.Address deliveryaddress;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="orderid"
     */
	public java.lang.String getOrderid () {
		return orderid;
	}

	/**
	 * Set the unique identifier of this class
	 * @param orderid the new ID
	 */
	public void setOrderid (java.lang.String orderid) {
		this.orderid = orderid;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: orderdate
	 */
	public java.util.Date getOrderdate () {
		return orderdate;
	}

	/**
	 * Set the value related to the column: orderdate
	 * @param orderdate the orderdate value
	 */
	public void setOrderdate (java.util.Date orderdate) {
		this.orderdate = orderdate;
	}



	/**
	 * Return the value associated with the column: ordertype
	 */
	public java.lang.String getOrdertype () {
		return ordertype;
	}

	/**
	 * Set the value related to the column: ordertype
	 * @param ordertype the ordertype value
	 */
	public void setOrdertype (java.lang.String ordertype) {
		this.ordertype = ordertype;
	}



	/**
	 * Return the value associated with the column: orderid_customer
	 */
	public java.lang.String getOrderidCustomer () {
		return orderidCustomer;
	}

	/**
	 * Set the value related to the column: orderid_customer
	 * @param orderidCustomer the orderid_customer value
	 */
	public void setOrderidCustomer (java.lang.String orderidCustomer) {
		this.orderidCustomer = orderidCustomer;
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
	 * Return the value associated with the column: partialshipment
	 */
	public java.lang.Integer getPartialshipment () {
		return partialshipment;
	}

	/**
	 * Set the value related to the column: partialshipment
	 * @param partialshipment the partialshipment value
	 */
	public void setPartialshipment (java.lang.Integer partialshipment) {
		this.partialshipment = partialshipment;
	}



	/**
	 * Return the value associated with the column: transport
	 */
	public java.lang.String getTransport () {
		return transport;
	}

	/**
	 * Set the value related to the column: transport
	 * @param transport the transport value
	 */
	public void setTransport (java.lang.String transport) {
		this.transport = transport;
	}



	/**
	 * Return the value associated with the column: specialtreatment
	 */
	public java.lang.String getSpecialtreatment () {
		return specialtreatment;
	}

	/**
	 * Set the value related to the column: specialtreatment
	 * @param specialtreatment the specialtreatment value
	 */
	public void setSpecialtreatment (java.lang.String specialtreatment) {
		this.specialtreatment = specialtreatment;
	}



	/**
	 * Return the value associated with the column: internationalrestrictions
	 */
	public java.lang.String getInternationalrestrictions () {
		return internationalrestrictions;
	}

	/**
	 * Set the value related to the column: internationalrestrictions
	 * @param internationalrestrictions the internationalrestrictions value
	 */
	public void setInternationalrestrictions (java.lang.String internationalrestrictions) {
		this.internationalrestrictions = internationalrestrictions;
	}



	/**
	 * Return the value associated with the column: pricetotal_net
	 */
	public java.math.BigDecimal getPricetotalNet () {
		return pricetotalNet;
	}

	/**
	 * Set the value related to the column: pricetotal_net
	 * @param pricetotalNet the pricetotal_net value
	 */
	public void setPricetotalNet (java.math.BigDecimal pricetotalNet) {
		this.pricetotalNet = pricetotalNet;
	}



	/**
	 * Return the value associated with the column: pricetotal_gross
	 */
	public java.math.BigDecimal getPricetotalGross () {
		return pricetotalGross;
	}

	/**
	 * Set the value related to the column: pricetotal_gross
	 * @param pricetotalGross the pricetotal_gross value
	 */
	public void setPricetotalGross (java.math.BigDecimal pricetotalGross) {
		this.pricetotalGross = pricetotalGross;
	}



	/**
	 * Return the value associated with the column: taxtotal
	 */
	public java.math.BigDecimal getTaxtotal () {
		return taxtotal;
	}

	/**
	 * Set the value related to the column: taxtotal
	 * @param taxtotal the taxtotal value
	 */
	public void setTaxtotal (java.math.BigDecimal taxtotal) {
		this.taxtotal = taxtotal;
	}



	/**
	 * Return the value associated with the column: taxamount
	 */
	public java.math.BigDecimal getTaxamount () {
		return taxamount;
	}

	/**
	 * Set the value related to the column: taxamount
	 * @param taxamount the taxamount value
	 */
	public void setTaxamount (java.math.BigDecimal taxamount) {
		this.taxamount = taxamount;
	}



	/**
	 * Return the value associated with the column: totallineitems
	 */
	public java.lang.Integer getTotallineitems () {
		return totallineitems;
	}

	/**
	 * Set the value related to the column: totallineitems
	 * @param totallineitems the totallineitems value
	 */
	public void setTotallineitems (java.lang.Integer totallineitems) {
		this.totallineitems = totallineitems;
	}



	/**
	 * Return the value associated with the column: xml_file_request
	 */
	public byte[] getXmlFileRequest () {
		return xmlFileRequest;
	}

	/**
	 * Set the value related to the column: xml_file_request
	 * @param xmlFileRequest the xml_file_request value
	 */
	public void setXmlFileRequest (byte[] xmlFileRequest) {
		this.xmlFileRequest = xmlFileRequest;
	}



	/**
	 * Return the value associated with the column: xml_file_response
	 */
	public byte[] getXmlFileResponse () {
		return xmlFileResponse;
	}

	/**
	 * Set the value related to the column: xml_file_response
	 * @param xmlFileResponse the xml_file_response value
	 */
	public void setXmlFileResponse (byte[] xmlFileResponse) {
		this.xmlFileResponse = xmlFileResponse;
	}



	/**
	 * Return the value associated with the column: is_rejected
	 */
	public boolean isRejected () {
		return rejected;
	}

	/**
	 * Set the value related to the column: is_rejected
	 * @param rejected the is_rejected value
	 */
	public void setRejected (boolean rejected) {
		this.rejected = rejected;
	}



	/**
	 * Return the value associated with the column: is_splitted
	 */
	public boolean isSplitted () {
		return splitted;
	}

	/**
	 * Set the value related to the column: is_splitted
	 * @param splitted the is_splitted value
	 */
	public void setSplitted (boolean splitted) {
		this.splitted = splitted;
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



	/**
	 * Return the value associated with the column: currency
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Currency getCurrency () {
		return currency;
	}

	/**
	 * Set the value related to the column: currency
	 * @param currency the currency value
	 */
	public void setCurrency (de.htwg_konstanz.ebus.framework.wholesaler.vo.Currency currency) {
		this.currency = currency;
	}



	/**
	 * Return the value associated with the column: invoiceaddress
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Address getInvoiceaddress () {
		return invoiceaddress;
	}

	/**
	 * Set the value related to the column: invoiceaddress
	 * @param invoiceaddress the invoiceaddress value
	 */
	public void setInvoiceaddress (de.htwg_konstanz.ebus.framework.wholesaler.vo.Address invoiceaddress) {
		this.invoiceaddress = invoiceaddress;
	}



	/**
	 * Return the value associated with the column: deliveryaddress
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Address getDeliveryaddress () {
		return deliveryaddress;
	}

	/**
	 * Set the value related to the column: deliveryaddress
	 * @param deliveryaddress the deliveryaddress value
	 */
	public void setDeliveryaddress (de.htwg_konstanz.ebus.framework.wholesaler.vo.Address deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderCustomer)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderCustomer orderCustomer = (de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderCustomer) obj;
			if (null == this.getOrderid() || null == orderCustomer.getOrderid()) return false;
			else return (this.getOrderid().equals(orderCustomer.getOrderid()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getOrderid()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getOrderid().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}