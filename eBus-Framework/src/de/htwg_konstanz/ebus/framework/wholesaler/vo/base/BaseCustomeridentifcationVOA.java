package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.iface.CustomeridentifcationVOA;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseCustomeridentifcationVOA extends de.htwg_konstanz.ebus.framework.wholesaler.vo.voa._RootVOA {




	// query name references


	public static CustomeridentifcationVOA instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static CustomeridentifcationVOA getInstance () {
		if (null == instance) instance = new de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.CustomeridentifcationVOA();
		return instance;
	}

	public Class getReferenceClass () {
		return de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation cast (Object object) {
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation) object;
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation get(de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK key)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation) get(getReferenceClass(), key);
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation get(de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK key, Session s)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation) get(getReferenceClass(), key, s);
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation load(de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK key)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation) load(getReferenceClass(), key);
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation load(de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK key, Session s)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation) load(getReferenceClass(), key, s);
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation loadInitialize(de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK key, Session s) 
	{ 
		de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param customeridentifcation a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK save(de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation customeridentifcation)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK) super.save(customeridentifcation);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param customeridentifcation a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK save(de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation customeridentifcation, Session s)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK) save((Object) customeridentifcation, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param customeridentifcation a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation customeridentifcation)
	{
		saveOrUpdate((Object) customeridentifcation);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param customeridentifcation a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation customeridentifcation, Session s)
	{
		saveOrUpdate((Object) customeridentifcation, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param customeridentifcation a transient instance containing updated state
	 */
	public void update(de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation customeridentifcation) 
	{
		update((Object) customeridentifcation);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param customeridentifcation a transient instance containing updated state
	 * @param the Session
	 */
	public void update(de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation customeridentifcation, Session s)
	{
		update((Object) customeridentifcation, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK id)
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
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.CustomeridentifcationPK id, Session s)
	{
		delete((Object) load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param customeridentifcation the instance to be removed
	 */
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation customeridentifcation)
	{
		delete((Object) customeridentifcation);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param customeridentifcation the instance to be removed
	 * @param s the Session
	 */
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation customeridentifcation, Session s)
	{
		delete((Object) customeridentifcation, s);
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
	public void refresh (de.htwg_konstanz.ebus.framework.wholesaler.vo.Customeridentifcation customeridentifcation, Session s)
	{
		refresh((Object) customeridentifcation, s);
	}
	
	


}