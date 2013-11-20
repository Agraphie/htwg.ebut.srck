/* TestBOCurrencyCRUD.java
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

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCurrency;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CurrencyBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;

public class TestBOCurrencyCRUD
{
	public static final String TEST_CURRENCY_CODE = "TCC";
	public static final String TEST_CURRENCY_DESCR = "TestCurrencyDescription";
	public static final String TEST_CURRENCY_UPDATED_DESCR = "TestCurrencyDescription";
	
	
	@Test public void testCreate()
	{
		// create the currency
		BOCurrency currency = new BOCurrency();
		currency.setCode(TEST_CURRENCY_CODE);
		currency.setDescription(TEST_CURRENCY_DESCR);
		CurrencyBOA.getInstance().saveOrUpdate(currency);
		
      _BaseBOA.getInstance().commit();
      
      currency = null;
	}

	@Test public void testRead()
	{
		// load the currency
		BOCurrency currency = CurrencyBOA.getInstance().findCurrency(TEST_CURRENCY_CODE);
		assertNotNull(currency);

		// compare country values
		assertEquals(currency.getCode(), TEST_CURRENCY_CODE);
		assertEquals(currency.getDescription(), TEST_CURRENCY_DESCR);

      currency = null;
	}
	
	@Test public void testUpdate()
	{		
		// load the currency
		BOCurrency currency = CurrencyBOA.getInstance().findCurrency(TEST_CURRENCY_CODE);
		assertNotNull(currency);
		
		// change the currency description 
		currency.setDescription(TEST_CURRENCY_UPDATED_DESCR);
		CurrencyBOA.getInstance().saveOrUpdate(currency);
		
      _BaseBOA.getInstance().commit();

      // load the updated country
		BOCurrency updatedCurrency = CurrencyBOA.getInstance().findCurrency(TEST_CURRENCY_CODE);
		assertNotNull(updatedCurrency);
		
		// compare the values to the static texts
		assertEquals(updatedCurrency.getDescription(), TEST_CURRENCY_UPDATED_DESCR);

      currency = null;
      updatedCurrency = null;
	}
	
	@Test public void testDelete()
	{
		// load the currency
		BOCurrency currency = CurrencyBOA.getInstance().findCurrency(TEST_CURRENCY_CODE);
		assertNotNull(currency);

		// delete the currency
		CurrencyBOA.getInstance().delete(currency);
		
      _BaseBOA.getInstance().commit();
		
		// load it again to ensure deleting was successful
		BOCurrency deletedCurrency = CurrencyBOA.getInstance().findCurrency(TEST_CURRENCY_CODE);
		assertNull(deletedCurrency);		

      currency = null;
      deletedCurrency = null;
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
