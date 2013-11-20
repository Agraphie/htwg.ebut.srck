/* TestShipment.java
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

import java.util.Iterator;
import java.util.List;

import org.junit.After;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.Customer;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentCustomer;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomer;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.ShipmentitemCustomerPK;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.ShipmentCustomerVOA;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.ShipmentitemCustomerVOA;

public class TestShipment
{
	public void testShipmentCustomerLoad()
	{
		ShipmentCustomer shipmentCustomer = ShipmentCustomerVOA.getInstance().load("1");
		Customer customer = shipmentCustomer.getCustomer();
		System.out.println("Shipment->ID: " + shipmentCustomer.getShipmentid());
		System.out.println("Shipment->Customer->Name: " + customer.getFirstname() + " "	
											 			+ customer.getLastname());
		System.out.println("Shipment->Customer->Remark: " + shipmentCustomer.getRemark());
	}

	@SuppressWarnings("unchecked")
   public void testShipmentCustomerFindAll()
	{
		List shipmentCustomers = ShipmentCustomerVOA.getInstance().findAll();

		for (Iterator iter = shipmentCustomers.iterator(); iter.hasNext();)
		{
			ShipmentCustomer shipmentCustomer = (ShipmentCustomer) iter.next();
			System.out.println("Shipment->ID: " + shipmentCustomer.getShipmentid());
			Customer customer = shipmentCustomer.getCustomer();
			System.out.println("Shipment->Customer->Name: " + customer.getFirstname() + " "	
												 			+ customer.getLastname());
			System.out.println("Shipment->Customer->Remark: " + shipmentCustomer.getRemark());
		}
	}
	
	public void testShipmentItemCustomer()
	{
		ShipmentCustomer shipmentCustomer = ShipmentCustomerVOA.getInstance().load("1");

		ShipmentitemCustomerPK pk = new ShipmentitemCustomerPK(shipmentCustomer, new Integer(1));
		ShipmentitemCustomer shipmentItemCustomer = ShipmentitemCustomerVOA.getInstance().load(pk);
		System.out.println("ShipmentItemCustomer->ProductDescription: " + shipmentItemCustomer.getProductdescription());
		System.out.println("ShipmentItemCustomer->Deliveryaddress: "	+ shipmentItemCustomer.getDeliveryaddress().getStreet() + " "
																		+ shipmentItemCustomer.getDeliveryaddress().getZipcode() + " "
																		+ shipmentItemCustomer.getDeliveryaddress().getCity() + " "
																		+ shipmentItemCustomer.getDeliveryaddress().getCountry().getName());
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
