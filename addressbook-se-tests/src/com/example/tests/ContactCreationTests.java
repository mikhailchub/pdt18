package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ContactCreationTests extends TestBase {
	
  @Test (dataProviderClass = TestDataProvider.class, dataProvider = "randomValidContactGenerator")
  public void testContactCreationPositive(DataContact contact) {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().returnToAddressBook();
    
    // save old state
    List<DataContact> oldList = app.getContactHelper().getContacts();

    // perform test actions    
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContact(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToAddressBook();
    
    // save new state
    List<DataContact> newList = app.getContactHelper().getContacts();

    // compare states
    oldList.add(contact);
    Collections.sort(oldList);
    Assert.assertEquals(newList, oldList);    	    	    
  }
  
}
