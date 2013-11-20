/* TestBOAddressCRUD.java
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Test;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOAddress;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCountry;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.AddressBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;

public class TestBOAddressCRUD
{
	public static final String TEST_ADDRESS_STREET = "TestAddressStreet";
	public static final String TEST_ADDRESS_ZIPCODE = "123456";
	public static final String TEST_ADDRESS_CITY = "TestAddressCity";
	public static final String TEST_ADDRESS_UPDATED_CITY = "TestAddressUpdatedCity";
	public static final String TEST_ADDRESS_COUNTRY_ISOCODE = "DE";
	
	private static String addressId = "";
	
	
	@Test public void testCreate()
	{
		// load a existing country to build the address
		BOCountry country = CountryBOA.getInstance().findCountry(TEST_ADDRESS_COUNTRY_ISOCODE);
		assertNotNull(country);
		
		// create the address which must be unique (addresses could not be shared)
		BOAddress address = new BOAddress();
		address.setStreet(TEST_ADDRESS_STREET);
		address.setZipcode(TEST_ADDRESS_ZIPCODE);
		address.setCity(TEST_ADDRESS_CITY);
		address.setCountry(country);
		AddressBOA.getInstance().saveOrUpdate(address);

		// important! store the address id for further use
		addressId = address.getId();
		
		_BaseBOA.getInstance().commit();
		
		country = null;
		address = null;
	}

	@Test public void testRead()
	{
		// load the address
		BOAddress address = AddressBOA.getInstance().findAddress(addressId);		
		assertNotNull(address);

		// compare values
		assertEquals(address.getStreet(), TEST_ADDRESS_STREET);
		assertEquals(address.getZipcode(), TEST_ADDRESS_ZIPCODE);
		assertEquals(address.getCity(), TEST_ADDRESS_CITY);
		assertEquals(address.getCountry().getIsocode(), TEST_ADDRESS_COUNTRY_ISOCODE);

		address = null;
	}
	
	@Test public void testUpdate()
	{
		// load the address
		BOAddress address = AddressBOA.getInstance().findAddress(addressId);		
		assertNotNull(address);
		
		// update the city
		address.setCity(TEST_ADDRESS_UPDATED_CITY);
		AddressBOA.getInstance().saveOrUpdate(address);

		// load the updated address
		BOAddress updatedAddress = AddressBOA.getInstance().findAddress(addressId);		
		assertNotNull(updatedAddress);
		assertEquals(updatedAddress.getCity(), TEST_ADDRESS_UPDATED_CITY);

      _BaseBOA.getInstance().commit();

      updatedAddress = null;
      address = null;
	}
	
	@Test public void testDelete()
	{
		// load the address
		BOAddress address = AddressBOA.getInstance().findAddress(addressId);		
		assertNotNull(address);

		// delete the address
		AddressBOA.getInstance().delete(address);
		
		// ensure that the address was deleted successfully 
		BOAddress deletedAddress = AddressBOA.getInstance().findAddress(addressId);		
		assertNull(deletedAddress);

      _BaseBOA.getInstance().commit();
      
      deletedAddress = null;
      address = null;
	}
	
   @After public void tearDown()
   {
      System.gc();
   }
}
