/* TestBOProductCRUD.java
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

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCountry;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSalesPrice;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.PriceBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.SupplierBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.util.Constants;

public class TestBOProductCRUD
{
	public static final String TEST_PRODUCT_ORDER_NUMBER_SUPPLIER = "TestOrdernumberSupplier";
	public static final String TEST_PRODUCT_ORDER_NUMBER_CUSTOMER = "TestOrdernumberCustomer";
	public static final String TEST_PRODUCT_SHORT_DESCR = "TestProductShortDescription";
	public static final String TEST_UPDATED_PRODUCT_SHORT_DESCR = "TestUpdatedProductShortDescription";
	public static final String TEST_SUPPLIER_ID = "10";
	public static final BigDecimal TEST_PRODUCT_SALES_PRICE_AMOUNT = new BigDecimal("18.70");
	public static final BigDecimal TEST_PRODUCT_SALES_PRICE_TAXRATE = new BigDecimal("0.16");
	public static final String TEST_PRODUCT_SALES_PRICE_TYPE = "test_price_type";

	private static Integer materialnumber = null;
	
	
	@Test public void testCreate()
	{
		// load a existing supplier
		BOSupplier supplier = SupplierBOA.getInstance().findSupplierById(TEST_SUPPLIER_ID);
		assertNotNull(supplier);

		// create and save the product
		BOProduct product = new BOProduct();
		product.setShortDescription(TEST_PRODUCT_SHORT_DESCR);
		product.setOrderNumberSupplier(TEST_PRODUCT_ORDER_NUMBER_SUPPLIER);
		product.setOrderNumberCustomer(TEST_PRODUCT_ORDER_NUMBER_CUSTOMER);
		product.setInventoryAmount(777);
		product.setSupplier(supplier);
		ProductBOA.getInstance().saveOrUpdate(product);
		
		_BaseBOA.getInstance().commit();

		// important! store the materialnumber for further use
		materialnumber = product.getMaterialNumber();

		// create a salesprice -> for further use in the read method		
		// load the country
		BOCountry country = CountryBOA.getInstance().findCountry(Constants.DEFAULT_COUNTRY_ISO_CODE);
		assertNotNull(country);
		
		// create a sales price
		BOSalesPrice salesPrice = new BOSalesPrice(TEST_PRODUCT_SALES_PRICE_AMOUNT, 
																 TEST_PRODUCT_SALES_PRICE_TAXRATE, 
																 TEST_PRODUCT_SALES_PRICE_TYPE);
		salesPrice.setProduct(product);
		salesPrice.setCountry(country);
		salesPrice.setLowerboundScaledprice(Constants.DEFAULT_LOWERBOUND_SCALED_PRICE);
		PriceBOA.getInstance().saveOrUpdateSalesPrice(salesPrice);

		_BaseBOA.getInstance().commit();
	
		supplier = null;
		product = null;
		country = null;
		salesPrice = null;
	}

	@Test public void testRead()
	{
		// load the created product
		BOProduct product = ProductBOA.getInstance().findByMaterialNumber(materialnumber);
		assertNotNull(product);

		// compare product values
		assertEquals(product.getShortDescription(), TEST_PRODUCT_SHORT_DESCR);
		assertEquals(product.getOrderNumberSupplier(), TEST_PRODUCT_ORDER_NUMBER_SUPPLIER);
		assertEquals(product.getOrderNumberCustomer(), TEST_PRODUCT_ORDER_NUMBER_CUSTOMER);

		// load the supplier
		BOSupplier supplier = product.getSupplier();
		assertNotNull(supplier);
		
		// compare supplier values
		assertEquals(supplier.getSupplierNumber(), TEST_SUPPLIER_ID);
		
		BOSalesPrice salesPrice = product.getDefaultSalesPrice();
		assertNotNull(salesPrice);
		
		assertEquals(TEST_PRODUCT_SALES_PRICE_AMOUNT, salesPrice.getAmount());
	
		product = null;
		supplier = null;
		salesPrice = null;
	}
	
	@Test public void testUpdate()
	{
		// load the created product
		BOProduct product = ProductBOA.getInstance().findByMaterialNumber(materialnumber);
		assertNotNull(product);
		
		// set a different shortdescription
		product.setShortDescription(TEST_UPDATED_PRODUCT_SHORT_DESCR);
		ProductBOA.getInstance().saveOrUpdate(product);
		
      _BaseBOA.getInstance().commit();

      // load the updated product
		BOProduct updatedProduct = ProductBOA.getInstance().findByMaterialNumber(materialnumber);
		assertNotNull(updatedProduct);
		
		// compare the values to the static texts
		assertEquals(product.getShortDescription(), TEST_UPDATED_PRODUCT_SHORT_DESCR);
	
		product = null;
		updatedProduct = null;
	}
	
	@Test public void testDelete()
	{
		// load the product
		BOProduct product = ProductBOA.getInstance().findByMaterialNumber(materialnumber);
		assertNotNull(product);

		// delete the sales price first
		BOSalesPrice salesPrice = product.getDefaultSalesPrice();
		assertNotNull(salesPrice);
		PriceBOA.getInstance().deleteSalesPrice(salesPrice);
		
		// delete the product
		ProductBOA.getInstance().delete(product);
		
      _BaseBOA.getInstance().commit();
		
		// load it again to ensure deleting was successful
		BOProduct deletedProduct = ProductBOA.getInstance().findByMaterialNumber(materialnumber);
		assertNull(deletedProduct);
		
		product = null;
		salesPrice = null;
		deletedProduct = null;
	}

	@Test public void testRollback()
   {
      // load a existing supplier
      BOSupplier supplier = SupplierBOA.getInstance().findSupplierById(TEST_SUPPLIER_ID);
      assertNotNull(supplier);

      // create and save the product
      BOProduct product = new BOProduct();
      product.setShortDescription(TEST_PRODUCT_SHORT_DESCR);
      product.setOrderNumberSupplier(TEST_PRODUCT_ORDER_NUMBER_SUPPLIER);
      product.setOrderNumberCustomer(TEST_PRODUCT_ORDER_NUMBER_CUSTOMER);
      product.setSupplier(supplier);
      ProductBOA.getInstance().saveOrUpdate(product);

      // rollback current transaction
      _BaseBOA.getInstance().rollback();
      
      // load it again to ensure rollback was successful
      BOProduct deletedProduct = ProductBOA.getInstance().findByMaterialNumber(materialnumber);
      assertNull(deletedProduct);         
      
      supplier = null;
      product = null;
      deletedProduct = null;
   }
   
   @After public void tearDown()
   {
      System.gc();
   }
}
