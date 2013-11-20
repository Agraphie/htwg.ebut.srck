/* TestBOUserInternalCRUD.java
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
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOUserInternal;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.AddressBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.UserBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;

public class TestBOUserInternalCRUD
{
	public static final String TEST_USER_INTERNAL_LOGIN = "TUserInt";
	public static final String TEST_USER_INTERNAL_FIRSTNAME = "TestUserInternalFirstName";
	public static final String TEST_USER_INTERNAL_LASTNAME = "TestUserInternalLastName";
	public static final String TEST_USER_INTERNAL_UPDATED_FIRSTNAME = "TestUserInternalFirstNameUpdated";
	public static final String TEST_USER_INTERNAL_UPDATE_LASTNAME = "TestUserInternalLastNameUpdated";
	public static final String TEST_USER_INTERNAL_STREET = "TestUserInternalStreet";
	public static final String TEST_USER_INTERNAL_ZIPCODE = "123456";
	public static final String TEST_USER_INTERNAL_CITY = "TestUserInternalStreetCity";
	public static final String TEST_USER_INTERNAL_COUNTRY_ISOCODE = "DE";

	private static Integer userId = null;
	
	
	@Test public void testCreate()
	{
		// first of all load a existing country to build the address
		BOCountry country = CountryBOA.getInstance().findCountry(TEST_USER_INTERNAL_COUNTRY_ISOCODE);
		assertNotNull(country);
		
		// second, create a address which must be unique for each user (addresses could not be shared)
		BOAddress address = new BOAddress();
		address.setStreet(TEST_USER_INTERNAL_STREET);
		address.setZipcode(TEST_USER_INTERNAL_ZIPCODE);
		address.setCity(TEST_USER_INTERNAL_CITY);
		address.setCountry(country);
		AddressBOA.getInstance().saveOrUpdate(address);
		
		// third, create and save the test customer
		BOUserInternal userInternal = new BOUserInternal();
		userInternal.setLogin(TEST_USER_INTERNAL_LOGIN);
		userInternal.setFirstname(TEST_USER_INTERNAL_FIRSTNAME);
		userInternal.setLastname(TEST_USER_INTERNAL_LASTNAME);
		userInternal.setAddress(address);
		UserBOA.getInstance().saveOrUpdate(userInternal);
		
		// important! store the userid for further use
		userId = userInternal.getId();

      _BaseBOA.getInstance().commit();
	}

	@Test public void testRead()
	{
		// load the created user
		BOUserInternal userInternal = UserBOA.getInstance().findUserInternalById(userId);
		assertNotNull(userInternal);

		// compare user values
		assertEquals(userInternal.getLogin(), TEST_USER_INTERNAL_LOGIN);
		assertEquals(userInternal.getFirstname(), TEST_USER_INTERNAL_FIRSTNAME);
		assertEquals(userInternal.getLastname(), TEST_USER_INTERNAL_LASTNAME);

		// load the created address
		BOAddress address = userInternal.getAddress();
		assertNotNull(address);
		
		// compare address values
		assertEquals(address.getStreet(), TEST_USER_INTERNAL_STREET);
		assertEquals(address.getZipcode(), TEST_USER_INTERNAL_ZIPCODE);
		assertEquals(address.getCity(), TEST_USER_INTERNAL_CITY);
		
		assertEquals(address.getCountry().getIsocode(), TEST_USER_INTERNAL_COUNTRY_ISOCODE);
	}
	
	@Test public void testUpdate()
	{
		// load the user
		BOUserInternal userInternal = UserBOA.getInstance().findUserInternalById(userId);
		assertNotNull(userInternal);
		
		// set different name values and update
		userInternal.setFirstname(TEST_USER_INTERNAL_UPDATED_FIRSTNAME);
		userInternal.setLastname(TEST_USER_INTERNAL_UPDATE_LASTNAME);
		UserBOA.getInstance().saveOrUpdateUserInternal(userInternal);
		
      _BaseBOA.getInstance().commit();

      // load the updated user
		BOUserInternal updatedUserInternal = UserBOA.getInstance().findUserInternalById(userId);
		assertNotNull(updatedUserInternal);
		
		// compare the name values to the static texts
		assertEquals(updatedUserInternal.getFirstname(), TEST_USER_INTERNAL_UPDATED_FIRSTNAME);
		assertEquals(updatedUserInternal.getLastname(), TEST_USER_INTERNAL_UPDATE_LASTNAME);
	}
	
	@Test public void testDelete()
	{
		// load the user
		BOUserInternal userInternal = UserBOA.getInstance().findUserInternalById(userId);
		assertNotNull(userInternal);

		// delete the user
		UserBOA.getInstance().delete(userInternal);
		
      _BaseBOA.getInstance().commit();

		// load it again to ensure deleting was successful
		BOUserInternal deletedUserInternal = UserBOA.getInstance().findUserInternalById(userId);
		assertNull(deletedUserInternal);		
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
