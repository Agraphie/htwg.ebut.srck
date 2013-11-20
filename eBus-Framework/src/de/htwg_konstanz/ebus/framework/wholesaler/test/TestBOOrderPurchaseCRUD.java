/* TestBOOrderPurchaseCRUD.java
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
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOOrderItemPurchase;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOOrderPurchase;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.AddressBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.OrderBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.OrderItemBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.SupplierBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;

public class TestBOOrderPurchaseCRUD
{
	public static final String TEST_ORDER_PURCHASE_ORDER_NUMBER = "999";
	public static final String TEST_ORDER_PURCHASE_ORDER_NUMBER_SUPPLIER = "SUPP001";
	public static final String TEST_ORDER_PURCHASE_COMPANY_NAME = "Supplier GmbH 1";
	public static final int TEST_ORDER_PURCHASE_TOTAL_LINE_ITEMS = 1;
	public static final BigDecimal TEST_ORDER_PURCHASE_ITEM_NET_PRICE = new BigDecimal(100.00);
	public static final BigDecimal TEST_ORDER_PURCHASE_ITEM_GROSS_PRICE = new BigDecimal(116.00);
	public static final BigDecimal TEST_ORDER_PURCHASE_ITEM_TAX_AMOUNT = new BigDecimal(16.00);
	public static final BigDecimal TEST_ORDER_PURCHASE_ITEM_TAX_RATE = new BigDecimal(16.00);
	public static final String TEST_ORDER_PURCHASE_ITEM_UNIT = "C62";
	public static final String TEST_ORDER_PURCHASE_ITEM_DESCR = "TestUserPurchaseLineItem1";
	public static final int TEST_ORDER_PURCHASE_ITEM_AMOUNT = 1;
	public static final String TEST_ORDER_PURCHASE_ITEM_ORDER_NUMBER = "ABC999";
	public static final String TEST_ORDER_PURCHASE_UPDATED_ITEM_ORDER_NUMBER = "ABC999U";
	public static final Date TEST_ORDER_PURCHASE_ORDER_DATE = new Date();

	public static final String TEST_USER_PURCHASE_STREET = "TestUserPurchaseStreet";
	public static final String TEST_USER_PURCHASE_ZIPCODE = "123456";
	public static final String TEST_USER_PURCHASE_CITY = "TestUserPurchaseStreetCity";
	public static final String TEST_USER_PURCHASE_COUNTRY_ISOCODE = "DE";
	public static final String TEST_SUPPLIER_ID = "1";
	
	
	@Test public void testCreate()
	{
		// load a existing country to build the delivery address
		BOCountry country = CountryBOA.getInstance().findCountry(TEST_USER_PURCHASE_COUNTRY_ISOCODE);
		assertNotNull(country);
		
		// create a delivery address which must be unique for each user (addresses could not be shared)
		BOAddress delivAddress = new BOAddress();
		delivAddress.setStreet(TEST_USER_PURCHASE_STREET);
		delivAddress.setZipcode(TEST_USER_PURCHASE_ZIPCODE);
		delivAddress.setCity(TEST_USER_PURCHASE_CITY);
		delivAddress.setCountry(country);
		AddressBOA.getInstance().saveOrUpdate(delivAddress);

		// load a existing supplier
		BOSupplier supplier = SupplierBOA.getInstance().findSupplierById(TEST_SUPPLIER_ID);
		assertNotNull(supplier);

		BOOrderPurchase orderPurchase = new BOOrderPurchase();
		orderPurchase.setDeliveryAddress(delivAddress);
		orderPurchase.setSupplier(supplier);
		orderPurchase.setOrderNumberSupplier(TEST_ORDER_PURCHASE_ORDER_NUMBER_SUPPLIER);
		orderPurchase.setOrderDate(TEST_ORDER_PURCHASE_ORDER_DATE);
		orderPurchase.setOrderNumber(TEST_ORDER_PURCHASE_ORDER_NUMBER);
		orderPurchase.setPriceTotalNet(TEST_ORDER_PURCHASE_ITEM_NET_PRICE);
		orderPurchase.setPriceTotalGross(TEST_ORDER_PURCHASE_ITEM_GROSS_PRICE);
		orderPurchase.setTaxAmount(TEST_ORDER_PURCHASE_ITEM_TAX_AMOUNT);
		orderPurchase.setTotalLineItems(new Integer(0));
		OrderBOA.getInstance().saveOrUpdate(orderPurchase);
		
		BOOrderItemPurchase orderItem = new BOOrderItemPurchase();
		orderItem.setOrderNumberSupplier(TEST_ORDER_PURCHASE_ITEM_ORDER_NUMBER);
		orderItem.setItemNetPrice(TEST_ORDER_PURCHASE_ITEM_NET_PRICE);
		orderItem.setOrderAmount(TEST_ORDER_PURCHASE_ITEM_AMOUNT);
		orderItem.setOrderUnit(TEST_ORDER_PURCHASE_ITEM_UNIT);
		orderItem.setTaxRate(TEST_ORDER_PURCHASE_ITEM_TAX_RATE);
		orderItem.setProductDescription(TEST_ORDER_PURCHASE_ITEM_DESCR);	
		orderItem.setOrderItemNumber(TEST_ORDER_PURCHASE_ITEM_AMOUNT);
		orderItem.setOrderPurchase(orderPurchase);
		OrderItemBOA.getInstance().saveOrUpdateOrderItemPurchase(orderItem);
	
		// the line item count has changed -> update the order purchase
		orderPurchase.setTotalLineItems(new Integer(1));
		OrderBOA.getInstance().saveOrUpdate(orderPurchase);

      _BaseBOA.getInstance().commit();
      
      country = null;
      delivAddress = null;
      orderPurchase = null;
      orderItem = null;
	}

	@Test public void testRead()
	{
		BOOrderPurchase orderPurchase = OrderBOA.getInstance().findOrderPurchase(TEST_ORDER_PURCHASE_ORDER_NUMBER);		
		assertNotNull(orderPurchase);

		BOSupplier supplier = orderPurchase.getSupplier();
		assertNotNull(supplier);
		assertEquals(supplier.getCompanyname(), TEST_ORDER_PURCHASE_COMPANY_NAME);

		assertEquals(OrderItemBOA.getInstance().findAllOrderItemPurchase(orderPurchase).size(), TEST_ORDER_PURCHASE_TOTAL_LINE_ITEMS);
		assertEquals(OrderItemBOA.getInstance().findAllOrderItemPurchase(orderPurchase).get(0).getOrderNumberSupplier(), TEST_ORDER_PURCHASE_ITEM_ORDER_NUMBER);
	
		orderPurchase = null;
		supplier = null;
	}
	
	@Test public void testUpdate()
	{
		// load the order purchase
		BOOrderPurchase orderPurchase = OrderBOA.getInstance().findOrderPurchase(TEST_ORDER_PURCHASE_ORDER_NUMBER);		
		assertNotNull(orderPurchase);

		// load the first line item
		assertEquals(OrderItemBOA.getInstance().findAllOrderItemPurchase(orderPurchase).size(), TEST_ORDER_PURCHASE_TOTAL_LINE_ITEMS);
		BOOrderItemPurchase orderItem = OrderItemBOA.getInstance().findAllOrderItemPurchase(orderPurchase).get(0);
		assertNotNull(orderItem);
		
		// update the first line item
		orderItem.setOrderNumberSupplier(TEST_ORDER_PURCHASE_UPDATED_ITEM_ORDER_NUMBER);
		OrderItemBOA.getInstance().saveOrUpdateOrderItemPurchase(orderItem);
		
      _BaseBOA.getInstance().commit();
		
		// reload the first line item to ensure that the changes were successful
		BOOrderItemPurchase updatedOrderItem = OrderItemBOA.getInstance().findAllOrderItemPurchase(orderPurchase).get(0);
		assertNotNull(updatedOrderItem);
		assertEquals(updatedOrderItem.getOrderNumberSupplier(), TEST_ORDER_PURCHASE_UPDATED_ITEM_ORDER_NUMBER);
	
		orderPurchase = null;
		orderItem = null;
		updatedOrderItem = null;
	}
	
	@Test public void testDelete()
	{
		// load the order purchase and delete it
		BOOrderPurchase orderPurchase = OrderBOA.getInstance().findOrderPurchase(TEST_ORDER_PURCHASE_ORDER_NUMBER);		
		assertNotNull(orderPurchase);		
		OrderBOA.getInstance().delete(orderPurchase);

      _BaseBOA.getInstance().commit();
		
		// ensure that the order purchase was deleted successfully 
		BOOrderPurchase deletedOrderPurchase = OrderBOA.getInstance().findOrderPurchase(TEST_ORDER_PURCHASE_ORDER_NUMBER);		
		assertNull(deletedOrderPurchase);
		
		// ensure that the line items have been deleted automatically (by the on delete cascade clause)
		// --> todo: implement this
	
		orderPurchase = null;
		deletedOrderPurchase = null;
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
