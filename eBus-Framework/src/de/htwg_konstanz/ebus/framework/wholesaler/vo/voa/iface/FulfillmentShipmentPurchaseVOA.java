package de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.iface;

import java.io.Serializable;

import org.hibernate.Criteria;

public interface FulfillmentShipmentPurchaseVOA {
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentPurchase get(de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentPurchase key);

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentPurchase load(de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentPurchase key);

	public java.util.List<de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentPurchase> findAll ();


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param fulfillmentShipmentPurchase a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentPurchase save(de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentPurchase fulfillmentShipmentPurchase);

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param fulfillmentShipmentPurchase a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentPurchase fulfillmentShipmentPurchase);

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param fulfillmentShipmentPurchase a transient instance containing updated state
	 */
	public void update(de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentPurchase fulfillmentShipmentPurchase);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param fulfillmentShipmentPurchase the instance to be removed
	 */
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentPurchase fulfillmentShipmentPurchase);

 	/**
	 * Perform a filtered search.
	 */
	public Criteria findFiltered(String propName, Object filter);

 	/**
	 * Perform a filtered (with joker signs) search.
	 */
	public Criteria findFilteredLike(String propName, Object filter);

}