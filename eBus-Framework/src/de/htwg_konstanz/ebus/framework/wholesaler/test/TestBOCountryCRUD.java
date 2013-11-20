/* TestBOCountryCRUD.java
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

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCountry;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCurrency;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CurrencyBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;

public class TestBOCountryCRUD
{
	public static final String TEST_COUNTRY_NAME = "TestCountryName";
	public static final String TEST_COUNTRY_UPDATED_NAME = "TestCountryUpdatedName";
	public static final String TEST_COUNTRY_ISOCODE = "XYZ";
	public static final String TEST_COUNTRY_CURRENCY_CODE = "EUR";
	
	
	@Test public void testCreate()
	{
		// load a existing currency
		BOCurrency currency = CurrencyBOA.getInstance().findCurrency(TEST_COUNTRY_CURRENCY_CODE);
		assertNotNull(currency);
		
		// create the country
		BOCountry country = new BOCountry();
		country.setIsocode(TEST_COUNTRY_ISOCODE);
		country.setName(TEST_COUNTRY_NAME);
		country.setCurrency(currency);
		CountryBOA.getInstance().saveOrUpdate(country);

		_BaseBOA.getInstance().commit();
		
		currency = null;
		country = null;
	}

	@Test public void testRead()
	{
		// load the country
		BOCountry country = CountryBOA.getInstance().findCountry(TEST_COUNTRY_ISOCODE);
		assertNotNull(country);

		// compare country values
		assertEquals(country.getName(), TEST_COUNTRY_NAME);
		assertEquals(country.getCurrency().getCode(), TEST_COUNTRY_CURRENCY_CODE);
		
		country = null;
	}
	
	@Test public void testUpdate()
	{		
		// load the country
		BOCountry country = CountryBOA.getInstance().findCountry(TEST_COUNTRY_ISOCODE);
		assertNotNull(country);
		
		// change the country name 
		country.setName(TEST_COUNTRY_UPDATED_NAME);
		CountryBOA.getInstance().saveOrUpdate(country);
		
      _BaseBOA.getInstance().commit();
		
		// load the updated country
		BOCountry updatedCountry = CountryBOA.getInstance().findCountry(TEST_COUNTRY_ISOCODE);
		assertNotNull(updatedCountry);
		
		// compare the values to the static texts
		assertEquals(updatedCountry.getName(), TEST_COUNTRY_UPDATED_NAME);
		
		country = null;
		updatedCountry = null;
	}
	
	@Test public void testDelete()
	{
		// load the country
		BOCountry country = CountryBOA.getInstance().findCountry(TEST_COUNTRY_ISOCODE);
		assertNotNull(country);

		// delete the country
		CountryBOA.getInstance().delete(country);

      _BaseBOA.getInstance().commit();
		
		// load it again to ensure deleting was successful
		BOCountry deletedCountry = CountryBOA.getInstance().findCountry(TEST_COUNTRY_ISOCODE);
		assertNull(deletedCountry);		
		
		country = null;
		deletedCountry = null;
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
