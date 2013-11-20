package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;


/**
 * This is an automatically generated DAO class which should not be edited.
 */
public class BaseVOA extends de.htwg_konstanz.ebus.framework.wholesaler.vo.voa._RootVOA {

	private BaseVOA (){}

	public static BaseVOA instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static BaseVOA getInstance () {
		if (null == instance) instance = new de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseVOA();
		return instance;
	}

	public Class getReferenceClass () {
      return de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseVOA.class;
   }
	
	/**
	 * Perform a commit on the current transaction.
	 */
	public void commit()
	{
	   commitTransaction();
	}
	
	/**
	 * Perform a rollback on the current transaction.
	 */
	public void rollback()
	{
      rollbackTransaction();
	}
}