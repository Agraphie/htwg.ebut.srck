package de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.iface;

import java.io.Serializable;

import org.hibernate.Criteria;

public interface OrderinfoSupplierVOA {
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderinfoSupplier get(java.lang.Integer key);

	public de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderinfoSupplier load(java.lang.Integer key);

	public java.util.List<de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderinfoSupplier> findAll ();


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param orderinfoSupplier a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderinfoSupplier orderinfoSupplier);

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param orderinfoSupplier a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderinfoSupplier orderinfoSupplier);

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param orderinfoSupplier a transient instance containing updated state
	 */
	public void update(de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderinfoSupplier orderinfoSupplier);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.Integer id);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param orderinfoSupplier the instance to be removed
	 */
	public void delete(de.htwg_konstanz.ebus.framework.wholesaler.vo.OrderinfoSupplier orderinfoSupplier);

 	/**
	 * Perform a filtered search.
	 */
	public Criteria findFiltered(String propName, Object filter);

 	/**
	 * Perform a filtered (with joker signs) search.
	 */
	public Criteria findFilteredLike(String propName, Object filter);

}