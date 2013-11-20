package de.htwg_konstanz.ebus.framework.wholesaler.vo.voa;

import org.hibernate.Session;

import org.hibernate.Criteria;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseShipmentitemCustomerVOA;


public class ShipmentitemCustomerVOA extends BaseShipmentitemCustomerVOA implements de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.iface.ShipmentitemCustomerVOA {




	public Criteria findFiltered(String propName, Object filter)
	{
		return findFiltered(propName, filter, getDefaultOrder());
	}
	
	public Criteria findFilteredLike(String propName, Object filter)
	{
		return findFilteredLike(propName, filter, getDefaultOrder());
	}
	
}