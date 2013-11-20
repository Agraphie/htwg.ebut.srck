package de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.iface;

import java.io.Serializable;

import org.hibernate.Criteria;

public interface ShipmentitemPurchaseVOA {
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase get(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK key);

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase load(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK key);

	public java.util.List<de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase> findAll ();


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param shipmentitemPurchase a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK save(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase shipmentitemPurchase);

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param shipmentitemPurchase a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase shipmentitemPurchase);

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param shipmentitemPurchase a transient instance containing updated state
	 */
	public void update(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase shipmentitemPurchase);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK id);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param shipmentitemPurchase the instance to be removed
	 */
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase shipmentitemPurchase);

 	/**
	 * Perform a filtered search.
	 */
	public Criteria findFiltered(String propName, Object filter);

 	/**
	 * Perform a filtered (with joker signs) search.
	 */
	public Criteria findFilteredLike(String propName, Object filter);

}