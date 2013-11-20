package de.htwg_konstanz.ebus.framework.wholesaler.vo.voa;

import org.hibernate.Session;

import org.hibernate.Criteria;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.base.BaseRequestforquotationCustomerVOA;


public class RequestforquotationCustomerVOA extends BaseRequestforquotationCustomerVOA implements de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.iface.RequestforquotationCustomerVOA {




	public Criteria findFiltered(String propName, Object filter)
	{
		return findFiltered(propName, filter, getDefaultOrder());
	}
	
	public Criteria findFilteredLike(String propName, Object filter)
	{
		return findFilteredLike(propName, filter, getDefaultOrder());
	}
	
}