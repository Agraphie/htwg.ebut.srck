package de.htwg_konstanz.ebus.framework.wholesaler.vo.voa;

import org.hibernate.Session;

import org.hibernate.Criteria;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseFulfillmentShipmentCustomerVOA;


public class FulfillmentShipmentCustomerVOA extends BaseFulfillmentShipmentCustomerVOA implements de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.iface.FulfillmentShipmentCustomerVOA {




	public Criteria findFiltered(String propName, Object filter)
	{
		return findFiltered(propName, filter, getDefaultOrder());
	}
	
	public Criteria findFilteredLike(String propName, Object filter)
	{
		return findFilteredLike(propName, filter, getDefaultOrder());
	}
	
}