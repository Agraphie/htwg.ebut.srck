/* TestAuthenticateUser.java
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

import org.junit.Test;

import de.htwg_konstanz.ebus.framework.wholesaler.api.security.Security;

public class TestAuthenticateUser
{
	public static String TEST_USER_INTERNAL_LOGIN = "internal1";
	public static String TEST_USER_INTERNAL_PASSWD = "internal1";

	public static String TEST_USER_CUSTOMER_LOGIN = "customer1";
	public static String TEST_USER_CUSTOMER_PASSWD = "customer1";

	public static String TEST_USER_SUPPLIER_LOGIN = "supplier1";
	public static String TEST_USER_SUPPLIER_PASSWD = "supplier1";


	@Test public void testAuthenticateUserInternal()
	{
		assertTrue(Security.getInstance().authenticateUserInternal(TEST_USER_INTERNAL_LOGIN, TEST_USER_INTERNAL_PASSWD));
		assertFalse(Security.getInstance().authenticateUserInternal(TEST_USER_INTERNAL_LOGIN, ""));
		assertFalse(Security.getInstance().authenticateUserInternal("", TEST_USER_INTERNAL_PASSWD));
	}	

	@Test public void testAuthenticateUserCustomer()
	{
		assertTrue(Security.getInstance().authenticateUserCustomer(TEST_USER_CUSTOMER_LOGIN, TEST_USER_CUSTOMER_PASSWD));
		assertFalse(Security.getInstance().authenticateUserCustomer(TEST_USER_CUSTOMER_LOGIN, ""));
		assertFalse(Security.getInstance().authenticateUserCustomer("", TEST_USER_CUSTOMER_PASSWD));
	}	
	
	@Test public void testAuthenticateUserSupplier()
	{
		assertTrue(Security.getInstance().authenticateUserSupplier(TEST_USER_SUPPLIER_LOGIN, TEST_USER_SUPPLIER_PASSWD));
		assertFalse(Security.getInstance().authenticateUserSupplier(TEST_USER_SUPPLIER_LOGIN, ""));
		assertFalse(Security.getInstance().authenticateUserSupplier("", TEST_USER_SUPPLIER_PASSWD));
	}	
}
