package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the invoice_shipment_customer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="invoice_shipment_customer"
 */

public abstract class BaseInvoiceShipmentCustomer  implements Serializable {

	public static String REF = "InvoiceShipmentCustomer";


	// constructors
	public BaseInvoiceShipmentCustomer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInvoiceShipmentCustomer (
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer shipment,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceCustomer invoice) {

		this.setShipment(shipment);
		this.setInvoice(invoice);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key

	private de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer shipment;

	private de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceCustomer invoice;



	/**
     * @hibernate.property
     *  column=shipment
	 * not-null=true
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer getShipment () {
		return this.shipment;
	}

	/**
	 * Set the value related to the column: shipment
	 * @param shipment the shipment value
	 */
	public void setShipment (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer shipment) {
		this.shipment = shipment;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
     * @hibernate.property
     *  column=invoice
	 * not-null=true
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceCustomer getInvoice () {
		return this.invoice;
	}

	/**
	 * Set the value related to the column: invoice
	 * @param invoice the invoice value
	 */
	public void setInvoice (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceCustomer invoice) {
		this.invoice = invoice;
		this.hashCode = Integer.MIN_VALUE;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer invoiceShipmentCustomer = (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer) obj;
			if (null != this.getShipment() && null != invoiceShipmentCustomer.getShipment()) {
				if (!this.getShipment().equals(invoiceShipmentCustomer.getShipment())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getInvoice() && null != invoiceShipmentCustomer.getInvoice()) {
				if (!this.getInvoice().equals(invoiceShipmentCustomer.getInvoice())) {
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