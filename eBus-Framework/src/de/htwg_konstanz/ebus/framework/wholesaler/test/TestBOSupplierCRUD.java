/* TestBOSupplierCRUD.java
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

import java.util.List;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOAddress;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCountry;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.AddressBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.SupplierBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;

public class TestBOSupplierCRUD
{
	public static final String TEST_SUPPLIER_FIRST_NAME = "TestSupplierFirstName";
	public static final String TEST_SUPPLIER_LAST_NAME = "TestSupplierLastName";
	public static final String TEST_SUPPLIER_COMPANY_NAME = "TestSupplierCompanyName";
	public static final String TEST_SUPPLIER_UPDATED_COMPANY_NAME = "TestSupplierUdatedCompanyName";
	public static final String TEST_SUPPLIER_STREET = "TestSupplierStreet";
	public static final String TEST_SUPPLIER_ZIPCODE = "123456";
	public static final String TEST_SUPPLIER_CITY = "TestSupplierCity";
	public static final String TEST_SUPPLIER_COUNTRY_ISOCODE = "DE";
	
	private static String supplierNumber = "";
	
	@Test public void testCreate()
	{
		// load a existing country to build the supplier address
		BOCountry country = CountryBOA.getInstance().findCountry(TEST_SUPPLIER_COUNTRY_ISOCODE);
		assertNotNull(country);
		
		// create a address which must be unique for each supplier (addresses could not be shared)
		BOAddress address = new BOAddress();
		address.setStreet(TEST_SUPPLIER_STREET);
		address.setZipcode(TEST_SUPPLIER_ZIPCODE);
		address.setCity(TEST_SUPPLIER_CITY);
		address.setCountry(country);
		AddressBOA.getInstance().saveOrUpdate(address);

		// create the supplier
		BOSupplier supplier = new BOSupplier();
		supplier.setAddress(address);
		supplier.setFirstname(TEST_SUPPLIER_FIRST_NAME);
		supplier.setLastname(TEST_SUPPLIER_LAST_NAME);
		supplier.setCompanyname(TEST_SUPPLIER_COMPANY_NAME);
		SupplierBOA.getInstance().saveOrUpdate(supplier);
			
		// important! store the supplier number for further use
		supplierNumber = supplier.getSupplierNumber();
		
      _BaseBOA.getInstance().commit();	
      
      country = null;
      address = null;
      supplier = null;
	}

	@Test public void testRead()
	{
		// load the supplier
		BOSupplier supplier = SupplierBOA.getInstance().findSupplierById(supplierNumber);
		assertNotNull(supplier);

		// compare supplier values
		assertEquals(supplier.getFirstname(), TEST_SUPPLIER_FIRST_NAME);
		assertEquals(supplier.getLastname(), TEST_SUPPLIER_LAST_NAME);
		assertEquals(supplier.getCompanyname(), TEST_SUPPLIER_COMPANY_NAME);
	
		supplier = null;
	}
	
	@Test public void testUpdate()
	{
		// load the supplier
		BOSupplier supplier = SupplierBOA.getInstance().findSupplierById(supplierNumber);
		assertNotNull(supplier);
		
		// change the company name 
		supplier.setCompanyname(TEST_SUPPLIER_UPDATED_COMPANY_NAME);
		SupplierBOA.getInstance().saveOrUpdate(supplier);
		
      _BaseBOA.getInstance().commit();

      // load the updated supplier
		BOSupplier updatedSupplier = SupplierBOA.getInstance().findSupplierById(supplierNumber);
		assertNotNull(updatedSupplier);
		
		// compare the values to the static texts
		assertEquals(updatedSupplier.getCompanyname(), TEST_SUPPLIER_UPDATED_COMPANY_NAME);
	
		supplier = null;
		updatedSupplier = null;
	}
	
	@Test public void testDelete()
	{
		// load the supplier
		BOSupplier supplier = SupplierBOA.getInstance().findSupplierById(supplierNumber);
		assertNotNull(supplier);

		// delete the supplier
		SupplierBOA.getInstance().delete(supplier);
		
      _BaseBOA.getInstance().commit();

		// load it again to ensure deleting was successful
		BOSupplier deletedSupplier = SupplierBOA.getInstance().findSupplierById(supplierNumber);
		assertNull(deletedSupplier);		
	
		supplier = null;
		deletedSupplier = null;
	}
	
	@Test public void testFindByCompanyName()
	{
	   // find the suppliers by name with joker signs
	   List<BOSupplier> suppliers = SupplierBOA.getInstance().findByCompanyName("Supp%");
      assertNotNull(suppliers);
	   
      for (BOSupplier boSupplier : suppliers)
      {
         System.out.println(boSupplier.getCompanyname());
         
         boSupplier = null;
      }
      
      suppliers = null;
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
