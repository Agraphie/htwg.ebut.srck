/* TestBOSalesPriceCRUD.java
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
import java.util.List;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCountry;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSalesPrice;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.PriceBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.util.Constants;

public class TestBOSalesPriceCRUD
{
	public static final Integer TEST_PRODUCT_MATERIAL_NUMBER = new Integer(1);
	public static final BigDecimal TEST_PRODUCT_SALES_PRICE_AMOUNT = new BigDecimal("18.70");
	public static final BigDecimal TEST_UPDATED_PRODUCT_SALES_PRICE_AMOUNT = new BigDecimal("33.00");
   public static final BigDecimal TEST_PRODUCT_SALES_PRICE_TAXRATE = new BigDecimal("16.00");
	public static final String TEST_PRODUCT_SALES_PRICE_TYPE = "test_price_type";
	
	
	@Test public void testCreate()
	{
		// load the product
		BOProduct product = ProductBOA.getInstance().findByMaterialNumber(TEST_PRODUCT_MATERIAL_NUMBER);
		assertNotNull(product);

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
	
      product = null;
      country = null;
      salesPrice = null;
	}

	@Test public void testRead()
	{
		// load the product
		BOProduct product = ProductBOA.getInstance().findByMaterialNumber(TEST_PRODUCT_MATERIAL_NUMBER);
		assertNotNull(product);

		// load the country
		BOCountry country = CountryBOA.getInstance().findCountry(Constants.DEFAULT_COUNTRY_ISO_CODE);
		assertNotNull(country);

		BOSalesPrice salesPrice = PriceBOA.getInstance().findSalesPrice(product, country, Constants.DEFAULT_LOWERBOUND_SCALED_PRICE);
		assertNotNull(salesPrice);
		
		// compare price values
		assertEquals(salesPrice.getAmount(), TEST_PRODUCT_SALES_PRICE_AMOUNT);
		assertEquals(salesPrice.getTaxrate(), TEST_PRODUCT_SALES_PRICE_TAXRATE);
		assertEquals(salesPrice.getPricetype(), TEST_PRODUCT_SALES_PRICE_TYPE);
	
		product = null;
		country = null;
		salesPrice = null;
	}
	
	@Test public void testReadPriceList()
	{
	   // load the product
	   BOProduct product = ProductBOA.getInstance().findByMaterialNumber(TEST_PRODUCT_MATERIAL_NUMBER);
	   assertNotNull(product);

	   List<BOSalesPrice> salesPriceList = PriceBOA.getInstance().findSalesPrices(product);
	   assertNotNull(salesPriceList);
   
	   for(BOSalesPrice boSalesPrice : salesPriceList)
      {
	      System.out.println("Pricetype: " + boSalesPrice.getPricetype());
         System.out.println("Country: " + boSalesPrice.getCountry().getName());
         System.out.println("Amount: " + boSalesPrice.getAmount());
         
         boSalesPrice = null;
      }
	
	   product = null;
	   salesPriceList = null;
	}
	
	@Test public void testUpdate()
	{
		// load the product
		BOProduct product = ProductBOA.getInstance().findByMaterialNumber(TEST_PRODUCT_MATERIAL_NUMBER);
		assertNotNull(product);

		// load the country
		BOCountry country = CountryBOA.getInstance().findCountry(Constants.DEFAULT_COUNTRY_ISO_CODE);
		assertNotNull(country);

		BOSalesPrice salesPrice = PriceBOA.getInstance().findSalesPrice(product, country, Constants.DEFAULT_LOWERBOUND_SCALED_PRICE);
		assertNotNull(salesPrice);

		// change the amount 
		salesPrice.setAmount(TEST_UPDATED_PRODUCT_SALES_PRICE_AMOUNT);
		PriceBOA.getInstance().saveOrUpdateSalesPrice(salesPrice);
		
      _BaseBOA.getInstance().commit();
		
		// load the updated sales price
		BOSalesPrice updatedSalesPrice = PriceBOA.getInstance().findSalesPrice(product, country, Constants.DEFAULT_LOWERBOUND_SCALED_PRICE);
		assertNotNull(updatedSalesPrice);
		
		// compare the values to the static texts
		assertEquals(updatedSalesPrice.getAmount(), TEST_UPDATED_PRODUCT_SALES_PRICE_AMOUNT);
	
		product = null;
		country = null;
		salesPrice = null;
		updatedSalesPrice = null;
	}
	
	@Test public void testDelete()
	{
		// load the product
		BOProduct product = ProductBOA.getInstance().findByMaterialNumber(TEST_PRODUCT_MATERIAL_NUMBER);
		assertNotNull(product);

		// load the country
		BOCountry country = CountryBOA.getInstance().findCountry(Constants.DEFAULT_COUNTRY_ISO_CODE);
		assertNotNull(country);

		BOSalesPrice salesPrice = PriceBOA.getInstance().findSalesPrice(product, country, Constants.DEFAULT_LOWERBOUND_SCALED_PRICE);
		assertNotNull(salesPrice);

		// delete the sales price
		PriceBOA.getInstance().deleteSalesPrice(salesPrice);
		
      _BaseBOA.getInstance().commit();
		
		// load it again to ensure deleting was successful
		BOSalesPrice deletedSalesPrice = PriceBOA.getInstance().findSalesPrice(product, country, Constants.DEFAULT_LOWERBOUND_SCALED_PRICE);
		assertNull(deletedSalesPrice);		
	
		product = null;
		country = null;
		salesPrice = null;
		deletedSalesPrice = null;
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
