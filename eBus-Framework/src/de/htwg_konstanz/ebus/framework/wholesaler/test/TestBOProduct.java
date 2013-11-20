/* TestBOProduct.java
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

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCategory;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CategoryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;

public class TestBOProduct
{

   @Test public void testFindByCategory()
	{
		BOCategory boCategory = CategoryBOA.getInstance().getCategoryById("Alle");
		if (boCategory != null)
		{
			List<BOProduct> boProductList = ProductBOA.getInstance().findByCategory(boCategory);
	      System.out.println("\ntestFindByCategory: \"Alle\"");
			if (boProductList != null)
			{
				for (BOProduct boProduct : boProductList)
				{
					System.out.println(boProduct.getShortDescription());
				}
			}

			boCategory = null;
			boProductList = null;
		}
	}

   @Test public void testFindByCriteria()
	{
		findByCriteria("Shortdescription", "%pen");
		findByCriteria("Shortdescription", "%00%");
		findByCriteria("Shortdescription", "s%");		
		findByCriteria("Longdescription", "%notebook%");		
	}

	@Test public void findByCriteria(String attributeName, String searchString)
	{
		System.out.println("\ntestFindByCriteria: " + "\"" + attributeName + "\" " + "\"" + searchString +  "\"");
		List<BOProduct> boProductList = ProductBOA.getInstance().findByCriteria(attributeName, searchString);
		if (boProductList != null)
		{
			for (BOProduct boProduct : boProductList)
			{
				System.out.println(boProduct.getShortDescription());
			}
		}
		
		boProductList = null;
	}
	
	@Test public void testFindByOrderNumberSupplier()
	{
	   BOProduct boProduct = ProductBOA.getInstance().findByOrderNumberSupplier("20");
	   assertNotNull(boProduct);
	   
      System.out.println("\ntestFindByOrderNumberSupplier: \"20\"");
	   System.out.println(boProduct.getShortDescription());
	   
	   boProduct = null;
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
