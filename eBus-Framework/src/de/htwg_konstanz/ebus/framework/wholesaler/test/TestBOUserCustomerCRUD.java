/* TestBOUserCustomerCRUD.java
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
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCustomer;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOUserCustomer;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.AddressBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CustomerBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.UserBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;

public class TestBOUserCustomerCRUD
{
	public static final String TEST_USER_CUSTOMER_LOGIN = "TUserCust";
	public static final String TEST_USER_CUSTOMER_FIRSTNAME = "TestUserCustomerFirstName";
	public static final String TEST_USER_CUSTOMER_LASTNAME = "TestUserCustomerLastName";
	public static final String TEST_USER_CUSTOMER_UPDATED_FIRSTNAME = "TestUserCustomerFirstNameUpdated";
	public static final String TEST_USER_CUSTOMER_UPDATE_LASTNAME = "TestUserCustomerLastNameUpdated";
	public static final String TEST_USER_CUSTOMER_STREET = "TestUserCustomerStreet";
	public static final String TEST_USER_CUSTOMER_ZIPCODE = "123456";
	public static final String TEST_USER_CUSTOMER_CITY = "TestUserCustomerStreetCity";
	public static final String TEST_USER_CUSTOMER_COUNTRY_ISOCODE = "DE";
	public static final String TEST_CUSTOMER_ID = "10";

	private static Integer userId = null;
	
	
	@Test public void testCreate()
	{
		// first of all load a existing country to build the address
		BOCountry country = CountryBOA.getInstance().findCountry(TEST_USER_CUSTOMER_COUNTRY_ISOCODE);
		assertNotNull(country);
		
		// second, create a address which must be unique for each user (addresses could not be shared)
		BOAddress address = new BOAddress();
		address.setStreet(TEST_USER_CUSTOMER_STREET);
		address.setZipcode(TEST_USER_CUSTOMER_ZIPCODE);
		address.setCity(TEST_USER_CUSTOMER_CITY);
		address.setCountry(country);
		AddressBOA.getInstance().saveOrUpdate(address);
		
		// third, load a existing customer
		BOCustomer customer = CustomerBOA.getInstance().findCustomerById(TEST_CUSTOMER_ID);
		assertNotNull(customer);
		
		// fourth, create and save the test customer
		BOUserCustomer userCustomer = new BOUserCustomer();
		userCustomer.setLogin(TEST_USER_CUSTOMER_LOGIN);
		userCustomer.setFirstname(TEST_USER_CUSTOMER_FIRSTNAME);
		userCustomer.setLastname(TEST_USER_CUSTOMER_LASTNAME);
		userCustomer.setAddress(address);
		userCustomer.setOrganization(customer);
		UserBOA.getInstance().saveOrUpdate(userCustomer);
		
		// important! store the userid for further use
		userId = userCustomer.getId();

		_BaseBOA.getInstance().commit();
	}

	@Test public void testRead()
	{
		// load the created user
		BOUserCustomer userCustomer = UserBOA.getInstance().findUserCustomerById(userId);
		assertNotNull(userCustomer);

		// test if organization exists
		assertNotNull(userCustomer.getOrganization());
		
		// compare user values
		assertEquals(userCustomer.getLogin(), TEST_USER_CUSTOMER_LOGIN);
		assertEquals(userCustomer.getFirstname(), TEST_USER_CUSTOMER_FIRSTNAME);
		assertEquals(userCustomer.getLastname(), TEST_USER_CUSTOMER_LASTNAME);

		// load the created address
		BOAddress address = userCustomer.getAddress();
		assertNotNull(address);
		
		// compare address values
		assertEquals(address.getStreet(), TEST_USER_CUSTOMER_STREET);
		assertEquals(address.getZipcode(), TEST_USER_CUSTOMER_ZIPCODE);
		assertEquals(address.getCity(), TEST_USER_CUSTOMER_CITY);
		
		assertEquals(address.getCountry().getIsocode(), TEST_USER_CUSTOMER_COUNTRY_ISOCODE);
	}
	
	@Test public void testUpdate()
	{
		// load the user
		BOUserCustomer userCustomer = UserBOA.getInstance().findUserCustomerById(userId);
		assertNotNull(userCustomer);
		
		// set different name values and update
		userCustomer.setFirstname(TEST_USER_CUSTOMER_UPDATED_FIRSTNAME);
		userCustomer.setLastname(TEST_USER_CUSTOMER_UPDATE_LASTNAME);
		UserBOA.getInstance().saveOrUpdateUserCustomer(userCustomer);
		
      _BaseBOA.getInstance().commit();

		// load the updated user
		BOUserCustomer updatedUserCustomer = UserBOA.getInstance().findUserCustomerById(userId);
		assertNotNull(updatedUserCustomer);
		
		// compare the name values to the static texts
		assertEquals(updatedUserCustomer.getFirstname(), TEST_USER_CUSTOMER_UPDATED_FIRSTNAME);
		assertEquals(updatedUserCustomer.getLastname(), TEST_USER_CUSTOMER_UPDATE_LASTNAME);
	}
	
	@Test public void testDelete()
	{
		// load the user
		BOUserCustomer userCustomer = UserBOA.getInstance().findUserCustomerById(userId);
		assertNotNull(userCustomer);

		// delete the user
		UserBOA.getInstance().delete(userCustomer);
		
      _BaseBOA.getInstance().commit();

      // load it again to ensure deleting was successful
		BOUserCustomer deletedUserCustomer = UserBOA.getInstance().findUserCustomerById(userId);
		assertNull(deletedUserCustomer);		
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
