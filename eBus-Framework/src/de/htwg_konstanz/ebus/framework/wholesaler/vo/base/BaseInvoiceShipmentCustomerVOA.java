package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.iface.InvoiceShipmentCustomerVOA;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseInvoiceShipmentCustomerVOA extends de.htwg_konstanz.ebus.framework.wholesaler.vo.voa._RootVOA {




	// query name references


	public static InvoiceShipmentCustomerVOA instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static InvoiceShipmentCustomerVOA getInstance () {
		if (null == instance) instance = new de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.InvoiceShipmentCustomerVOA();
		return instance;
	}

	public Class getReferenceClass () {
		return de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer cast (Object object) {
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer) object;
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer get(de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer key)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer) get(getReferenceClass(), key);
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer get(de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer key, Session s)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer) get(getReferenceClass(), key, s);
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer load(de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer key)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer) load(getReferenceClass(), key);
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer load(de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer key, Session s)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer) load(getReferenceClass(), key, s);
	}

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer loadInitialize(de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer key, Session s) 
	{ 
		de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param invoiceShipmentCustomer a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer save(de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer invoiceShipmentCustomer)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer) super.save(invoiceShipmentCustomer);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param invoiceShipmentCustomer a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer save(de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer invoiceShipmentCustomer, Session s)
	{
		return (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer) save((Object) invoiceShipmentCustomer, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param invoiceShipmentCustomer a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer invoiceShipmentCustomer)
	{
		saveOrUpdate((Object) invoiceShipmentCustomer);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param invoiceShipmentCustomer a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer invoiceShipmentCustomer, Session s)
	{
		saveOrUpdate((Object) invoiceShipmentCustomer, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param invoiceShipmentCustomer a transient instance containing updated state
	 */
	public void update(de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer invoiceShipmentCustomer) 
	{
		update((Object) invoiceShipmentCustomer);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param invoiceShipmentCustomer a transient instance containing updated state
	 * @param the Session
	 */
	public void update(de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer invoiceShipmentCustomer, Session s)
	{
		update((Object) invoiceShipmentCustomer, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param invoiceShipmentCustomer the instance to be removed
	 */
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer invoiceShipmentCustomer)
	{
		delete((Object) invoiceShipmentCustomer);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param invoiceShipmentCustomer the instance to be removed
	 * @param s the Session
	 */
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer invoiceShipmentCustomer, Session s)
	{
		delete((Object) invoiceShipmentCustomer, s);
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
	public void refresh (de.htwg_konstanz.ebus.framework.wholesaler.vo.InvoiceShipmentCustomer invoiceShipmentCustomer, Session s)
	{
		refresh((Object) invoiceShipmentCustomer, s);
	}
	
	


}