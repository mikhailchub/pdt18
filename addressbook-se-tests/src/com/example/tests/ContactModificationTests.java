package com.example.tests;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
	@Test (dataProviderClass = TestDataProvider.class, dataProvider = "randomValidContactGenerator")
	public void testContactModificationPositive(DataContact contact) {
	    app.getNavigationHelper().openMainPage();
	    app.getContactHelper().returnToAddressBook();
	    
	    // save old state
	    List<DataContact> oldList = app.getContactHelper().getContacts();
	    
	    // generate random index of selected element
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);

	    // perform test actions
	    app.getContactHelper().initContactModification(index);
	    app.getContactHelper().fillContact(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnToAddressBook();
	    
	    // save new state
	    List<DataContact> newList = app.getContactHelper().getContacts();

	    // compare states
	    oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Assert.assertEquals(newList, oldList);    	    	    
	}

}
