/* TestBOCategoryCRUD.java
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

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCategory;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CategoryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;

public class TestBOCategoryCRUD
{
	public static final String TEST_CAT_SHORT_DESCR = "this is a category short description";
	public static final String TEST_CAT_LONG_DESCR = "this is a category long description";
	public static final String TEST_CAT_UPDATED_LONG_DESCR = "this is a updated category long description";

	@Test public void testCreate()
	{
		BOCategory category = new BOCategory();
		category.setShortDescription(TEST_CAT_SHORT_DESCR);
		category.setLongDescription(TEST_CAT_LONG_DESCR);
		
		CategoryBOA.getInstance().saveOrUpdate(category);
		_BaseBOA.getInstance().commit();
	}
	
	@Test public void testRead()
	{
		BOCategory category = CategoryBOA.getInstance().getCategoryById(TEST_CAT_SHORT_DESCR);	
		assertNotNull(category);
		
		category = null;
	}

	@Test public void testUpdate()
	{
		// load the category	
		BOCategory category = CategoryBOA.getInstance().getCategoryById(TEST_CAT_SHORT_DESCR);	
		assertNotNull(category);
		
		// set different long description and update
		category.setLongDescription(TEST_CAT_UPDATED_LONG_DESCR);
		CategoryBOA.getInstance().saveOrUpdate(category);

		_BaseBOA.getInstance().commit();

		// load the updated category	
		BOCategory updatedCategory = CategoryBOA.getInstance().getCategoryById(TEST_CAT_SHORT_DESCR);	
		assertNotNull(updatedCategory);
		
		// compare the long description to the static text 
		assertEquals(updatedCategory.getLongDescription(), TEST_CAT_UPDATED_LONG_DESCR);
		
		category = null;
		updatedCategory = null;
	}
	
	@Test public void testDelete()
	{
		// load the category	
		BOCategory category = CategoryBOA.getInstance().getCategoryById(TEST_CAT_SHORT_DESCR);	
		assertNotNull(category);
		
		// delete the category
		CategoryBOA.getInstance().delete(category);

		_BaseBOA.getInstance().commit();

		// load it again to ensure deleting was successful
		BOCategory deletedCategory = CategoryBOA.getInstance().getCategoryById(TEST_CAT_SHORT_DESCR);
		assertNull(deletedCategory);

		category = null;
		deletedCategory = null;
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
