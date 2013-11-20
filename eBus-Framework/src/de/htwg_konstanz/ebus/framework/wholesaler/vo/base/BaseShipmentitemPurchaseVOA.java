package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.iface.ShipmentitemPurchaseVOA;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseShipmentitemPurchaseVOA extends de.htwg_konstanz.ebus.framework.wholesaler.vo.voa._RootVOA {




	// query name references


	public static ShipmentitemPurchaseVOA instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static ShipmentitemPurchaseVOA getInstance () {
		if (null == instance) instance = new de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.ShipmentitemPurchaseVOA();
		return instance;
	}

	public Class getReferenceClass () {
		return de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase cast (Object object) {
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase) object;
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase get(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK key)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase) get(getReferenceClass(), key);
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase get(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK key, Session s)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase) get(getReferenceClass(), key, s);
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase load(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK key)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase) load(getReferenceClass(), key);
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase load(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK key, Session s)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase) load(getReferenceClass(), key, s);
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase loadInitialize(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK key, Session s) 
	{ 
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param shipmentitemPurchase a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK save(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase shipmentitemPurchase)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK) super.save(shipmentitemPurchase);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param shipmentitemPurchase a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK save(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase shipmentitemPurchase, Session s)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK) save((Object) shipmentitemPurchase, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param shipmentitemPurchase a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase shipmentitemPurchase)
	{
		saveOrUpdate((Object) shipmentitemPurchase);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param shipmentitemPurchase a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase shipmentitemPurchase, Session s)
	{
		saveOrUpdate((Object) shipmentitemPurchase, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param shipmentitemPurchase a transient instance containing updated state
	 */
	public void update(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase shipmentitemPurchase) 
	{
		update((Object) shipmentitemPurchase);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param shipmentitemPurchase a transient instance containing updated state
	 * @param the Session
	 */
	public void update(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase shipmentitemPurchase, Session s)
	{
		update((Object) shipmentitemPurchase, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK id)
	{
		delete((Object) load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param id the instance ID to be removed
	 * @param s the Session
	 */
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchasePK id, Session s)
	{
		delete((Object) load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param shipmentitemPurchase the instance to be removed
	 */
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase shipmentitemPurchase)
	{
		delete((Object) shipmentitemPurchase);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param shipmentitemPurchase the instance to be removed
	 * @param s the Session
	 */
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase shipmentitemPurchase, Session s)
	{
		delete((Object) shipmentitemPurchase, s);
	}
	
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemPurchase shipmentitemPurchase, Session s)
	{
		refresh((Object) shipmentitemPurchase, s);
	}
	
	


}