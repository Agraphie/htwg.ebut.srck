/* TestConfigInternal.java
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

import org.junit.After;
import org.junit.Test;

import de.htwg_konstanz.ebus.framework.wholesaler.vo.ActiveconfigInternal;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.ConfigInternal;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.ActiveconfigInternalVOA;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.voa.ConfigInternalVOA;

public class TestConfigInternal
{
	@Test public void testConfigInternalLoad()
	{
		ConfigInternal configInternal = ConfigInternalVOA.getInstance().load(new Integer("1"));
		
		System.out.println("ConfigInternal->MultimediaDocroot: " + configInternal.getMultimediaDocroot());
		System.out.println("ConfigInternal->Wholesaleraddress: " + configInternal.getWholesaleraddress().getStreet() + " "
				+ configInternal.getWholesaleraddress().getZipcode() + " "
				+ configInternal.getWholesaleraddress().getCity() + " "
				+ configInternal.getWholesaleraddress().getCountry().getName());
	}

	@Test public void testActiveConfigInternalLoad()
	{
		ActiveconfigInternal activeconfigInternal = ActiveconfigInternalVOA.getInstance().load(new Integer("1"));
		
		ConfigInternal configInternal = activeconfigInternal.getConfigInternal();	
		System.out.println("ActiveconfigInternal->ConfigInternal->MultimediaDocroot: " +  configInternal.getMultimediaDocroot());
		System.out.println("ActiveconfigInternal->ConfigInternal->Wholesaleraddress: " + configInternal.getWholesaleraddress().getStreet() + " "
				+ configInternal.getWholesaleraddress().getZipcode() + " "
				+ configInternal.getWholesaleraddress().getCity() + " "
				+ configInternal.getWholesaleraddress().getCountry().getName());
	}
   
   @After public void tearDown()
   {
      System.gc();
   }
}
