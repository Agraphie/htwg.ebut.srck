/* TestBOCustomerCRUD.java
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
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCustomer;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.AddressBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CustomerBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;

public class TestBOCustomerCRUD
{
	public static final String TEST_CUST_ID = "TestCustId";
	public static final String TEST_CUST_FIRSTNAME = "TestCustFirstName";
	public static final String TEST_CUST_LASTNAME = "TestCustLastName";
	public static final String TEST_CUST_UPDATED_FIRSTNAME = "TestCustUpdatedFirstName";
	public static final String TEST_CUST_UPDATED_LASTNAME = "TestCustUpdatedLastName";
	public static final String TEST_CUST_COMPANYNAME = "TestCustCompanyName";
	public static final String TEST_CUST_STREET = "TestCustStreet";
	public static final String TEST_CUST_ZIPCODE = "123456";
	public static final String TEST_CUST_CITY = "TestCustCity";
	public static final String TEST_CUST_COUNTRY_ISOCODE = "DE";

	@Test public void testCreate()
	{
		// first of all load a existing country to build the address
		BOCountry country = CountryBOA.getInstance().findCountry(TEST_CUST_COUNTRY_ISOCODE);
		assertNotNull(country);

		// second, create a address which must be unique for each customer (addresses could not be shared)
		BOAddress address = new BOAddress();
		address.setStreet(TEST_CUST_STREET);
		address.setZipcode(TEST_CUST_ZIPCODE);
		address.setCity(TEST_CUST_CITY);
		address.setCountry(country);
		AddressBOA.getInstance().saveOrUpdate(address);

      _BaseBOA.getInstance().commit();

      BOCustomer customer = new BOCustomer();
		customer.setCustomerId(TEST_CUST_ID);
		customer.setFirstname(TEST_CUST_FIRSTNAME);
		customer.setLastname(TEST_CUST_LASTNAME);
		customer.setCompanyname(TEST_CUST_COMPANYNAME);
		customer.setAddress(address);
		CustomerBOA.getInstance().saveOrUpdate(customer);	

		_BaseBOA.getInstance().commit();
		
		country = null;
		address = null;
		customer = null;
	}

   @Test public void testRead()
	{
		// load the created customer
		BOCustomer customer = CustomerBOA.getInstance().findCustomerById(TEST_CUST_ID);
		assertNotNull(customer);

		// compare customer values
		assertEquals(customer.getFirstname(), TEST_CUST_FIRSTNAME);
		assertEquals(customer.getLastname(), TEST_CUST_LASTNAME);

		// load the created address
		BOAddress address = customer.getAddress();
		assertNotNull(address);
		
		// compare address values
		assertEquals(address.getStreet(), TEST_CUST_STREET);
		assertEquals(address.getZipcode(), TEST_CUST_ZIPCODE);
		assertEquals(address.getCity(), TEST_CUST_CITY);
		
		assertEquals(address.getCountry().getIsocode(), TEST_CUST_COUNTRY_ISOCODE);
		
		address = null;
	   customer = null;
	}
	
   @Test public void testUpdate()
	{
		// load the created customer
		BOCustomer customer = CustomerBOA.getInstance().findCustomerById(TEST_CUST_ID);
		assertNotNull(customer);
		
		// set different name values and update
		customer.setFirstname(TEST_CUST_UPDATED_FIRSTNAME);
		customer.setLastname(TEST_CUST_UPDATED_LASTNAME);
		CustomerBOA.getInstance().saveOrUpdate(customer);	

      _BaseBOA.getInstance().commit();
		
		// load the updated customer
		BOCustomer updatedCustomer = CustomerBOA.getInstance().findCustomerById(TEST_CUST_ID);
		assertNotNull(updatedCustomer);
		
		// compare the name values to the static texts
		assertEquals(updatedCustomer.getFirstname(), TEST_CUST_UPDATED_FIRSTNAME);
		assertEquals(updatedCustomer.getLastname(), TEST_CUST_UPDATED_LASTNAME);
		
      customer = null;
      updatedCustomer = null;
	}
	
   @Test public void testDelete()
	{
		// load the created customer
		BOCustomer customer = CustomerBOA.getInstance().findCustomerById(TEST_CUST_ID);
		assertNotNull(customer);

		// delete the customer
		CustomerBOA.getInstance().delete(customer);
		
      _BaseBOA.getInstance().commit();
		
		// load it again to ensure deleting was successful
		BOCustomer deletedCustomer = CustomerBOA.getInstance().findCustomerById(TEST_CUST_ID);
		assertNull(deletedCustomer);		
      
      customer = null;
      deletedCustomer = null;
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
