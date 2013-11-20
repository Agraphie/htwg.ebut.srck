/* TestBOPurchasePriceCRUD.java
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
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOPurchasePrice;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.PriceBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.util.Constants;

public class TestBOPurchasePriceCRUD
{
	public static final Integer TEST_PRODUCT_MATERIAL_NUMBER = new Integer(1);
	public static final BigDecimal TEST_PRODUCT_PURCHASE_PRICE_AMOUNT = new BigDecimal("18.70");
	public static final BigDecimal TEST_UPDATED_PRODUCT_PURCHASE_PRICE_AMOUNT = new BigDecimal("33.00");
   public static final BigDecimal TEST_PRODUCT_PURCHASE_PRICE_TAXRATE = new BigDecimal("16.00");
	public static final String TEST_PRODUCT_PURCHASE_PRICE_TYPE = "test_price_type";
	
	
	@Test public void testCreate()
	{
		// load the product
		BOProduct product = ProductBOA.getInstance().findByMaterialNumber(TEST_PRODUCT_MATERIAL_NUMBER);
		assertNotNull(product);

		// load the country
		BOCountry country = CountryBOA.getInstance().findCountry(Constants.DEFAULT_COUNTRY_ISO_CODE);
		assertNotNull(country);
		
		// create a purchase price
		BOPurchasePrice purchasePrice = new BOPurchasePrice(TEST_PRODUCT_PURCHASE_PRICE_AMOUNT, 
																 TEST_PRODUCT_PURCHASE_PRICE_TAXRATE, 
																 TEST_PRODUCT_PURCHASE_PRICE_TYPE);
		purchasePrice.setProduct(product);
		purchasePrice.setCountry(country);
		purchasePrice.setLowerboundScaledprice(Constants.DEFAULT_LOWERBOUND_SCALED_PRICE);
		PriceBOA.getInstance().saveOrUpdatePurchasePrice(purchasePrice);

      _BaseBOA.getInstance().commit();

      product = null;
      country = null;
      purchasePrice = null;
	}

	@Test public void testRead()
	{
		// load the product
		BOProduct product = ProductBOA.getInstance().findByMaterialNumber(TEST_PRODUCT_MATERIAL_NUMBER);
		assertNotNull(product);

		// load the country
		BOCountry country = CountryBOA.getInstance().findCountry(Constants.DEFAULT_COUNTRY_ISO_CODE);
		assertNotNull(country);

		BOPurchasePrice purchasePrice = PriceBOA.getInstance().findPurchasePrice(product, country, Constants.DEFAULT_LOWERBOUND_SCALED_PRICE);
		assertNotNull(purchasePrice);
		
		// compare price values
		assertEquals(purchasePrice.getAmount(), TEST_PRODUCT_PURCHASE_PRICE_AMOUNT);
		assertEquals(purchasePrice.getTaxrate(), TEST_PRODUCT_PURCHASE_PRICE_TAXRATE);
		assertEquals(purchasePrice.getPricetype(), TEST_PRODUCT_PURCHASE_PRICE_TYPE);
		
		product = null;
		country = null;
		purchasePrice = null;
	}
	
	@Test public void testUpdate()
	{
		// load the product
		BOProduct product = ProductBOA.getInstance().findByMaterialNumber(TEST_PRODUCT_MATERIAL_NUMBER);
		assertNotNull(product);

		// load the country
		BOCountry country = CountryBOA.getInstance().findCountry(Constants.DEFAULT_COUNTRY_ISO_CODE);
		assertNotNull(country);

		BOPurchasePrice purchasePrice = PriceBOA.getInstance().findPurchasePrice(product, country, Constants.DEFAULT_LOWERBOUND_SCALED_PRICE);
		assertNotNull(purchasePrice);

		// change the amount 
		purchasePrice.setAmount(TEST_UPDATED_PRODUCT_PURCHASE_PRICE_AMOUNT);
		PriceBOA.getInstance().saveOrUpdatePurchasePrice(purchasePrice);
		
      _BaseBOA.getInstance().commit();

      // load the updated purchase price
		BOPurchasePrice updatedPurchasePrice = PriceBOA.getInstance().findPurchasePrice(product, country, Constants.DEFAULT_LOWERBOUND_SCALED_PRICE);
		assertNotNull(updatedPurchasePrice);
		
		// compare the values to the static texts
		assertEquals(updatedPurchasePrice.getAmount(), TEST_UPDATED_PRODUCT_PURCHASE_PRICE_AMOUNT);
	
		product = null;
		country = null;
		purchasePrice = null;
		updatedPurchasePrice = null;
	}
	
	@Test public void testDelete()
	{
		// load the product
		BOProduct product = ProductBOA.getInstance().findByMaterialNumber(TEST_PRODUCT_MATERIAL_NUMBER);
		assertNotNull(product);

		// load the country
		BOCountry country = CountryBOA.getInstance().findCountry(Constants.DEFAULT_COUNTRY_ISO_CODE);
		assertNotNull(country);

		BOPurchasePrice purchasePrice = PriceBOA.getInstance().findPurchasePrice(product, country, Constants.DEFAULT_LOWERBOUND_SCALED_PRICE);
		assertNotNull(purchasePrice);

		// delete the purchase price
		PriceBOA.getInstance().deletePurchasePrice(purchasePrice);
		
      _BaseBOA.getInstance().commit();

		// load it again to ensure deleting was successful
		BOPurchasePrice deletedPurchasePrice = PriceBOA.getInstance().findPurchasePrice(product, country, Constants.DEFAULT_LOWERBOUND_SCALED_PRICE);
		assertNull(deletedPurchasePrice);		
	
		product = null;
		country = null;
		purchasePrice = null;
		deletedPurchasePrice = null;
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
