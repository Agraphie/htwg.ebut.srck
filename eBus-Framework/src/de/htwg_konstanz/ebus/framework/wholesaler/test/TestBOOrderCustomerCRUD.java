/* TestBOOrderCustomerCRUD.java
***********************************************************************************
* 20.03.2007 ** tdi
* - created
*
***********************************************************************************
* Copyright 2007-2010 HTWG Konstanz
* 
* Prof. Dr.-Ing. Juergen Waesch
* Dipl. -Inf. (FH) Thomas Dietrich
* Fakultaet Informatik - Department of Computer Science
* E-Business Technologien 
* 
* Hochschule Konstanz Technik, Wirtschaft und Gestaltung
* University of Applied Sciences
* Brauneggerstrasse 55
* D-78462 Konstanz
* 
* E-Mail: juergen.waesch(at)htwg-konstanz.de
************************************************************************************/
package de.htwg_konstanz.ebus.framework.wholesaler.test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOAddress;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCountry;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCustomer;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOOrderCustomer;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOOrderItemCustomer;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.AddressBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CustomerBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.OrderBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.OrderItemBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;

public class TestBOOrderCustomerCRUD
{
	public static final String TEST_ORDER_CUSTOMER_ORDER_NUMBER = "999";
	public static final String TEST_ORDER_CUSTOMER_ORDER_NUMBER_CUSTOMER = "CUST999";
	public static final String TEST_ORDER_CUSTOMER_LAST_NAME = "Minic";
	public static final int TEST_ORDER_CUSTOMER_TOTAL_LINE_ITEMS = 1;
	public static final BigDecimal TEST_ORDER_CUSTOMER_ITEM_NET_PRICE = new BigDecimal(100.00);
	public static final BigDecimal TEST_ORDER_CUSTOMER_ITEM_GROSS_PRICE = new BigDecimal(116.00);
	public static final BigDecimal TEST_ORDER_CUSTOMER_ITEM_TAX_AMOUNT = new BigDecimal(16.00);
	public static final BigDecimal TEST_ORDER_CUSTOMER_ITEM_TAX_RATE = new BigDecimal(16.00);
	public static final String TEST_ORDER_CUSTOMER_ITEM_UNIT = "C62";
	public static final String TEST_ORDER_CUSTOMER_ITEM_DESCR = "TestUserCustomerLineItem1";
	public static final int TEST_ORDER_CUSTOMER_ITEM_AMOUNT = 1;
	public static final String TEST_ORDER_CUSTOMER_ITEM_ORDER_NUMBER = "ABC999";
	public static final String TEST_ORDER_CUSTOMER_UPDATED_ITEM_ORDER_NUMBER = "ABC999U";
	public static final Date TEST_ORDER_CUSTOMER_ORDER_DATE = new Date();

	public static final String TEST_USER_CUSTOMER_STREET = "TestUserCustomerStreet";
	public static final String TEST_USER_CUSTOMER_ZIPCODE = "123456";
	public static final String TEST_USER_CUSTOMER_CITY = "TestUserCustomerStreetCity";
	public static final String TEST_USER_CUSTOMER_COUNTRY_ISOCODE = "DE";
	public static final String TEST_CUSTOMER_ID = "1";
	
	
	@Test public void testCreate()
	{
		// load a existing country to build the delivery address
		BOCountry country = CountryBOA.getInstance().findCountry(TEST_USER_CUSTOMER_COUNTRY_ISOCODE);
		assertNotNull(country);
		
		// create a delivery address which must be unique for each user (addresses could not be shared)
		BOAddress delivAddress = new BOAddress();
		delivAddress.setStreet(TEST_USER_CUSTOMER_STREET);
		delivAddress.setZipcode(TEST_USER_CUSTOMER_ZIPCODE);
		delivAddress.setCity(TEST_USER_CUSTOMER_CITY);
		delivAddress.setCountry(country);
		AddressBOA.getInstance().saveOrUpdate(delivAddress);
		
		// load a existing customer
		BOCustomer customer = CustomerBOA.getInstance().findCustomerById(TEST_CUSTOMER_ID);
		assertNotNull(customer);

		BOOrderCustomer orderCustomer = new BOOrderCustomer();
		orderCustomer.setDeliveryAddress(delivAddress);
		orderCustomer.setCustomer(customer);
		orderCustomer.setOrderNumberCustomer(TEST_ORDER_CUSTOMER_ORDER_NUMBER_CUSTOMER);
		orderCustomer.setOrderDate(TEST_ORDER_CUSTOMER_ORDER_DATE);
		orderCustomer.setOrderNumber(TEST_ORDER_CUSTOMER_ORDER_NUMBER);
		orderCustomer.setPriceTotalNet(TEST_ORDER_CUSTOMER_ITEM_NET_PRICE);
		orderCustomer.setPriceTotalGross(TEST_ORDER_CUSTOMER_ITEM_GROSS_PRICE);
		orderCustomer.setTaxAmount(TEST_ORDER_CUSTOMER_ITEM_TAX_AMOUNT);
		orderCustomer.setTotalLineItems(new Integer(0));
		OrderBOA.getInstance().saveOrUpdate(orderCustomer);
		
		BOOrderItemCustomer orderItem = new BOOrderItemCustomer();
		orderItem.setOrderNumberCustomer(TEST_ORDER_CUSTOMER_ITEM_ORDER_NUMBER);
		orderItem.setItemNetPrice(TEST_ORDER_CUSTOMER_ITEM_NET_PRICE);
		orderItem.setOrderAmount(TEST_ORDER_CUSTOMER_ITEM_AMOUNT);
		orderItem.setOrderUnit(TEST_ORDER_CUSTOMER_ITEM_UNIT);
		orderItem.setTaxRate(TEST_ORDER_CUSTOMER_ITEM_TAX_RATE);
		orderItem.setProductDescription(TEST_ORDER_CUSTOMER_ITEM_DESCR);	
		orderItem.setOrderItemNumber(TEST_ORDER_CUSTOMER_ITEM_AMOUNT);
		orderItem.setOrderCustomer(orderCustomer);
		OrderItemBOA.getInstance().saveOrUpdateOrderItemCustomer(orderItem);
	
		// the line item count has changed -> update the order customer
		orderCustomer.setTotalLineItems(new Integer(1));
		OrderBOA.getInstance().saveOrUpdate(orderCustomer);

		_BaseBOA.getInstance().commit();
		
		country = null;
		delivAddress = null;
		customer = null;
		orderCustomer = null;
		orderItem = null;
	}

	@Test public void testRead()
	{
		BOOrderCustomer orderCustomer = OrderBOA.getInstance().findOrderCustomer(TEST_ORDER_CUSTOMER_ORDER_NUMBER);		
		assertNotNull(orderCustomer);

		BOCustomer customer = orderCustomer.getCustomer();
		assertNotNull(customer);
		assertEquals(customer.getLastname(), TEST_ORDER_CUSTOMER_LAST_NAME);

		assertEquals(OrderItemBOA.getInstance().findAllOrderItemCustomer(orderCustomer).size(), TEST_ORDER_CUSTOMER_TOTAL_LINE_ITEMS);
		assertEquals(OrderItemBOA.getInstance().findAllOrderItemCustomer(orderCustomer).get(0).getOrderNumberCustomer(), TEST_ORDER_CUSTOMER_ITEM_ORDER_NUMBER);
	
		orderCustomer = null;
		customer = null;
	}
	
	@Test public void testUpdate()
	{
		// load the order customer
		BOOrderCustomer orderCustomer = OrderBOA.getInstance().findOrderCustomer(TEST_ORDER_CUSTOMER_ORDER_NUMBER);		
		assertNotNull(orderCustomer);

		// load the first line item
		assertEquals(OrderItemBOA.getInstance().findAllOrderItemCustomer(orderCustomer).size(), TEST_ORDER_CUSTOMER_TOTAL_LINE_ITEMS);
		BOOrderItemCustomer orderItem = OrderItemBOA.getInstance().findAllOrderItemCustomer(orderCustomer).get(0);
		assertNotNull(orderItem);
		
		// update the first line item
		orderItem.setOrderNumberCustomer(TEST_ORDER_CUSTOMER_UPDATED_ITEM_ORDER_NUMBER);
		OrderItemBOA.getInstance().saveOrUpdateOrderItemCustomer(orderItem);

      _BaseBOA.getInstance().commit();
		
		// reload the first line item to ensure that the changes were successful
		BOOrderItemCustomer updatedOrderItem = OrderItemBOA.getInstance().findAllOrderItemCustomer(orderCustomer).get(0);
		assertNotNull(updatedOrderItem);
		assertEquals(updatedOrderItem.getOrderNumberCustomer(), TEST_ORDER_CUSTOMER_UPDATED_ITEM_ORDER_NUMBER);
	
		orderCustomer = null;
		orderItem = null;
		updatedOrderItem = null;
	}
	
	@Test public void testDelete()
	{		
		// load the order customer and delete it
		BOOrderCustomer orderCustomer = OrderBOA.getInstance().findOrderCustomer(TEST_ORDER_CUSTOMER_ORDER_NUMBER);		
		assertNotNull(orderCustomer);		
		
//		BOOrderItemCustomer orderItem = BOOrderItemDAO.getInstance().findAllOrderItemCustomer(orderCustomer).get(0);
//		BOOrderItemDAO.getInstance().deleteOrderItemCustomer(orderItem);		
//
//		BOOrderItemCustomer deletedOrderItem = BOOrderItemDAO.getInstance().findOrderItemCustomer(orderCustomer, 0);
//		assertNull(deletedOrderItem);
		
		// delete the order customer. 
		// the line items will be deleted automatically (by the on delete cascade clause)
		OrderBOA.getInstance().delete(orderCustomer);

      _BaseBOA.getInstance().commit();
		
		// ensure that the order customer was deleted successfully 
		BOOrderCustomer deletedOrderCustomer = OrderBOA.getInstance().findOrderCustomer(TEST_ORDER_CUSTOMER_ORDER_NUMBER);		
		assertNull(deletedOrderCustomer);
	
		orderCustomer = null;
		deletedOrderCustomer = null;
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
