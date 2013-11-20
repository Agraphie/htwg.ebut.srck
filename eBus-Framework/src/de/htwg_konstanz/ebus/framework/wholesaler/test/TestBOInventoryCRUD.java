/* TestBOInventoryCRUD.java
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
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOInventory;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CategoryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.InventoryBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.SupplierBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa._BaseBOA;


public class TestBOInventoryCRUD
{
   public static final String TEST_PRODUCT_ORDER_NUMBER_SUPPLIER = "TestOrdernumberSupplier-Inventory";
   public static final String TEST_PRODUCT_ORDER_NUMBER_CUSTOMER = "TestOrdernumberCustomer-Inventory";
   public static final String TEST_PRODUCT_SHORT_DESCR = "TestProductShortDescription";
   public static final String TEST_SUPPLIER_ID = "1";
   public static final String TEST_CATEGORY_ID = "ALLE";
	public static final Integer TEST_WAREHOUSE_INVENTORY = new Integer(1000);
   public static final Integer TEST_UPDATED_WAREHOUSE_INVENTORY = new Integer(999);
   public static final Integer TEST_NON_PHYSICAL_DELIVERY = new Integer(1);
   public static final Integer TEST_NUMBER_TO_REORDER = new Integer(5);
   public static final Integer TEST_THRESHOLD_REORDER = new Integer(10);
   
   private static Integer materialnumber = null;
	
   
   @Test public void testCreate()
	{
	   // 1. create a new product
	   // 1.1 load a existing supplier
      BOSupplier supplier = SupplierBOA.getInstance().findSupplierById(TEST_SUPPLIER_ID);
      assertNotNull(supplier);

      // 1.2 load a existing category
      BOCategory category = CategoryBOA.getInstance().getCategoryById(TEST_CATEGORY_ID);
      assertNotNull(category);
      
      // 1.3 create and save the product
      BOProduct product = new BOProduct();
      product.setShortDescription(TEST_PRODUCT_SHORT_DESCR);
      product.setOrderNumberSupplier(TEST_PRODUCT_ORDER_NUMBER_SUPPLIER);
      product.setOrderNumberCustomer(TEST_PRODUCT_ORDER_NUMBER_CUSTOMER);
      product.setSupplier(supplier);
      product.setCategory(category);
      
      ProductBOA.getInstance().saveOrUpdate(product);

      // important! store the materialnumber for further use
      materialnumber = product.getMaterialNumber();

	   // 2. create a inventory for the product	   
      BOInventory inventory = new BOInventory();
	   inventory.setInventory(TEST_WAREHOUSE_INVENTORY);
	   inventory.setNonPhysicalDelivery(TEST_NON_PHYSICAL_DELIVERY);
	   inventory.setNumberToReorder(TEST_NUMBER_TO_REORDER);
	   inventory.setThresholdReorder(TEST_THRESHOLD_REORDER);
      inventory.setProduct(materialnumber);

      InventoryBOA.getInstance().saveOrUpdate(inventory);

      _BaseBOA.getInstance().commit();
      
      supplier = null;
      category = null;
      product = null;
      inventory = null;
	}
	
   @Test public void testRead()
	{
		// load an existing product
		BOProduct product = ProductBOA.getInstance().findByMaterialNumber(materialnumber);
		assertNotNull(product);

      BOInventory inventory =  InventoryBOA.getInstance().findByProduct(product);
      assertNotNull(inventory);
      
		// compare inventory value
		assertEquals(inventory.getInventoryNumber(), TEST_WAREHOUSE_INVENTORY);
		
		product = null;
		inventory = null;
	}
	
   @Test public void testUpdate()
	{
      // load an existing product
      BOProduct product = ProductBOA.getInstance().findByMaterialNumber(materialnumber);
      assertNotNull(product);

      BOInventory inventory =  InventoryBOA.getInstance().findByProduct(product);
      assertNotNull(inventory);
      
		// set a different inventory
      inventory.setInventory(TEST_UPDATED_WAREHOUSE_INVENTORY);
      InventoryBOA.getInstance().saveOrUpdate(inventory);
		_BaseBOA.getInstance().commit();
      
		// load the updated inventory
      BOInventory updatedInventory =  InventoryBOA.getInstance().findByProduct(product);
      assertNotNull(updatedInventory);
		
      // compare updated inventory value
      assertEquals(updatedInventory.getInventoryNumber(), TEST_UPDATED_WAREHOUSE_INVENTORY);    
      
      // reset the inventory to default value 
      updatedInventory.setInventory(TEST_WAREHOUSE_INVENTORY);
      InventoryBOA.getInstance().saveOrUpdate(updatedInventory);
      
      _BaseBOA.getInstance().commit();
      
      product = null;
      inventory = null;
      updatedInventory = null;
	}
	
   @Test public void testDelete()
	{
      // load the created product
      BOProduct product = ProductBOA.getInstance().findByMaterialNumber(materialnumber);
      assertNotNull(product);

      // load the created inventory
      BOInventory inventory =  InventoryBOA.getInstance().findByProduct(product);
      assertNotNull(inventory);

      // delete the inventory
      InventoryBOA.getInstance().delete(inventory);
      
      _BaseBOA.getInstance().commit();
      
      // ensure inventory deletion was successful
      inventory = InventoryBOA.getInstance().findByMaterialNumber(materialnumber);
      assertNull(inventory);
      
      // delete the product
      ProductBOA.getInstance().delete(product);
      
      _BaseBOA.getInstance().commit();

      // ensure product deletion was successful
      product = ProductBOA.getInstance().findByMaterialNumber(materialnumber);
      assertNull(product);

      product = null;
      inventory = null;
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
