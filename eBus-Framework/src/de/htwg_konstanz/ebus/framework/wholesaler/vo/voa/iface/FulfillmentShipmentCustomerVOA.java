package de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.iface;

import java.io.Serializable;

import org.hibernate.Criteria;

public interface FulfillmentShipmentCustomerVOA {
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentCustomer get(de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentCustomer key);

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentCustomer load(de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentCustomer key);

	public java.util.List<de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentCustomer> findAll ();


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param fulfillmentShipmentCustomer a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentCustomer save(de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentCustomer fulfillmentShipmentCustomer);

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param fulfillmentShipmentCustomer a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentCustomer fulfillmentShipmentCustomer);

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param fulfillmentShipmentCustomer a transient instance containing updated state
	 */
	public void update(de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentCustomer fulfillmentShipmentCustomer);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param fulfillmentShipmentCustomer the instance to be removed
	 */
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.FulfillmentShipmentCustomer fulfillmentShipmentCustomer);

 	/**
	 * Perform a filtered search.
	 */
	public Criteria findFiltered(String propName, Object filter);

 	/**
	 * Perform a filtered (with joker signs) search.
	 */
	public Criteria findFilteredLike(String propName, Object filter);

}