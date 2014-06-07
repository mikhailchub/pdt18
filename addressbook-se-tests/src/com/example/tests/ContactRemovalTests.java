package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	private static int n;
	
	@Test
	public void testContactRemovalPositive() {
	    app.getNavigationHelper().openMainPage();
	    app.getContactHelper().returnToAddressBook();
	    n = app.getContactHelper().getContactsNumber(); // get items number before deleting contact
	    app.getContactHelper().deleteContact(1);
	    app.getContactHelper().returnToAddressBook();
	    Assert.assertTrue(n-1 == app.getContactHelper().getContactsNumber(), "Contacts number is not decreased after deletion!");
	}

}
