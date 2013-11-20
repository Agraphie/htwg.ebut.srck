/* TestBOUserSupplierCRUD.java
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

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOAddress;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCountry;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOUserSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.AddressBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.SupplierBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.UserBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;

public class TestBOUserSupplierCRUD
{
	public static final String TEST_USER_SUPPLIER_LOGIN = "TUserSupp";
	public static final String TEST_USER_SUPPLIER_FIRSTNAME = "TestUserSupplierFirstName";
	public static final String TEST_USER_SUPPLIER_LASTNAME = "TestUserSupplierLastName";
	public static final String TEST_USER_SUPPLIER_UPDATED_FIRSTNAME = "TestUserSupplierFirstNameUpdated";
	public static final String TEST_USER_SUPPLIER_UPDATE_LASTNAME = "TestUserSupplierLastNameUpdated";
	public static final String TEST_USER_SUPPLIER_STREET = "TestUserSupplierStreet";
	public static final String TEST_USER_SUPPLIER_ZIPCODE = "123456";
	public static final String TEST_USER_SUPPLIER_CITY = "TestUserSupplierStreetCity";
	public static final String TEST_USER_SUPPLIER_COUNTRY_ISOCODE = "DE";
	public static final String TEST_SUPPLIER_ID = "1";

	private static Integer userId = null;
	
	
	@Test public void testCreate()
	{
		// first of all load a existing country to build the address
		BOCountry country = CountryBOA.getInstance().findCountry(TEST_USER_SUPPLIER_COUNTRY_ISOCODE);
		assertNotNull(country);
		
		// second, create a address which must be unique for each user (addresses could not be shared)
		BOAddress address = new BOAddress();
		address.setStreet(TEST_USER_SUPPLIER_STREET);
		address.setZipcode(TEST_USER_SUPPLIER_ZIPCODE);
		address.setCity(TEST_USER_SUPPLIER_CITY);
		address.setCountry(country);
		AddressBOA.getInstance().saveOrUpdate(address);
		
		// third, load a existing supplier
		BOSupplier supplier = SupplierBOA.getInstance().findSupplierById(TEST_SUPPLIER_ID);
		assertNotNull(supplier);
		
		// fourth, create and save the test customer
		BOUserSupplier userSupplier = new BOUserSupplier();
		userSupplier.setLogin(TEST_USER_SUPPLIER_LOGIN);
		userSupplier.setFirstname(TEST_USER_SUPPLIER_FIRSTNAME);
		userSupplier.setLastname(TEST_USER_SUPPLIER_LASTNAME);
		userSupplier.setAddress(address);
		userSupplier.setOrganization(supplier);
		UserBOA.getInstance().saveOrUpdate(userSupplier);
		
		// important! store the userid for further use
		userId = userSupplier.getId();
		
      _BaseBOA.getInstance().commit();
	}

	@Test public void testRead()
	{
		// load the created user
		BOUserSupplier userSupplier = UserBOA.getInstance().findUserSupplierById(userId);
		assertNotNull(userSupplier);

		// compare user values
		assertEquals(userSupplier.getLogin(), TEST_USER_SUPPLIER_LOGIN);
		assertEquals(userSupplier.getFirstname(), TEST_USER_SUPPLIER_FIRSTNAME);
		assertEquals(userSupplier.getLastname(), TEST_USER_SUPPLIER_LASTNAME);

		// load the created address
		BOAddress address = userSupplier.getAddress();
		assertNotNull(address);
		
		// compare address values
		assertEquals(address.getStreet(), TEST_USER_SUPPLIER_STREET);
		assertEquals(address.getZipcode(), TEST_USER_SUPPLIER_ZIPCODE);
		assertEquals(address.getCity(), TEST_USER_SUPPLIER_CITY);
		
		assertEquals(address.getCountry().getIsocode(), TEST_USER_SUPPLIER_COUNTRY_ISOCODE);
	}
	
	@Test public void testUpdate()
	{
		// load the user
		BOUserSupplier userSupplier = UserBOA.getInstance().findUserSupplierById(userId);
		assertNotNull(userSupplier);
		
		// set different name values and update
		userSupplier.setFirstname(TEST_USER_SUPPLIER_UPDATED_FIRSTNAME);
		userSupplier.setLastname(TEST_USER_SUPPLIER_UPDATE_LASTNAME);
		UserBOA.getInstance().saveOrUpdateUserSupplier(userSupplier);
		
      _BaseBOA.getInstance().commit();

      // load the updated user
		BOUserSupplier updatedUserSupplier = UserBOA.getInstance().findUserSupplierById(userId);
		assertNotNull(updatedUserSupplier);
		
		// compare the name values to the static texts
		assertEquals(updatedUserSupplier.getFirstname(), TEST_USER_SUPPLIER_UPDATED_FIRSTNAME);
		assertEquals(updatedUserSupplier.getLastname(), TEST_USER_SUPPLIER_UPDATE_LASTNAME);
	}
	
	@Test public void testDelete()
	{
		// load the user
		BOUserSupplier userSupplier = UserBOA.getInstance().findUserSupplierById(userId);
		assertNotNull(userSupplier);

		// delete the user
		UserBOA.getInstance().delete(userSupplier);
		
      _BaseBOA.getInstance().commit();

		// load it again to ensure deleting was successful
		BOUserSupplier deletedUserSupplier = UserBOA.getInstance().findUserSupplierById(userId);
		assertNull(deletedUserSupplier);		
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
