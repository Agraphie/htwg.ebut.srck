package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the invoice_shipment_purchase table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="invoice_shipment_purchase"
 */

public abstract class BaseInvoiceShipmentPurchase  implements Serializable {

	public static String REF = "InvoiceShipmentPurchase";


	// constructors
	public BaseInvoiceShipmentPurchase () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInvoiceShipmentPurchase (
		java.lang.String shipment,
		java.lang.String invoice) {

		this.setShipment(shipment);
		this.setInvoice(invoice);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key

	private java.lang.String shipment;

	private java.lang.String invoice;



	/**
     * @hibernate.property
     *  column=shipment
	 * not-null=true
	 */
	public java.lang.String getShipment () {
		return this.shipment;
	}

	/**
	 * Set the value related to the column: shipment
	 * @param shipment the shipment value
	 */
	public void setShipment (java.lang.String shipment) {
		this.shipment = shipment;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
     * @hibernate.property
     *  column=invoice
	 * not-null=true
	 */
	public java.lang.String getInvoice () {
		return this.invoice;
	}

	/**
	 * Set the value related to the column: invoice
	 * @param invoice the invoice value
	 */
	public void setInvoice (java.lang.String invoice) {
		this.invoice = invoice;
		this.hashCode = Integer.MIN_VALUE;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentPurchase)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentPurchase invoiceShipmentPurchase = (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentPurchase) obj;
			if (null != this.getShipment() && null != invoiceShipmentPurchase.getShipment()) {
				if (!this.getShipment().equals(invoiceShipmentPurchase.getShipment())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getInvoice() && null != invoiceShipmentPurchase.getInvoice()) {
				if (!this.getInvoice().equals(invoiceShipmentPurchase.getInvoice())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getShipment()) {
				sb.append(this.getShipment().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getInvoice()) {
				sb.append(this.getInvoice().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}