package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
	@Test
	public void testContactModificationPositive() {
	    app.getNavigationHelper().openMainPage();
	    app.getContactHelper().returnToAddressBook();
	    app.getContactHelper().initContactModification(1);
	    // Define test data
	    DataContact contact = new DataContact();
	    contact.fname = "modified First Name";
	    contact.lname = "modified Last Name";
	    app.getContactHelper().fillContact(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnToAddressBook();
	}

}
