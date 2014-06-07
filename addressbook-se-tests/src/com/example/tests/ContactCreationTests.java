package com.example.tests;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;


public class ContactCreationTests extends TestBase {
    private static Integer n;
	
  @Test(priority=1)
  public void testContactCreationPositiveNonEmpty() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().returnToAddressBook();
    n = app.getContactHelper().getContactsNumber(); // get items number before adding contact
    app.getContactHelper().initContactCreation();
    // Define test data
	    Data_Contact contact = new Data_Contact();
	    contact.fname = "fname";
	    contact.lname = "lname";
	    contact.addr1 = "address 1";
	    contact.phoneHome = "01";
	    contact.phoneMob = "02";
	    contact.phoneWork = "03";
	    contact.email = "abc@xyz.com";
	    contact.email2 = "qwe@rty";
	    contact.bday = "1";
	    contact.bmonth = "February";
	    contact.byear = "1999";
	    contact.addr2 = "address 2";
	    contact.phone2 = "+1234567890";
    app.getContactHelper().fillContact(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToAddressBook();
    assertEquals(n+1, app.getContactHelper().getContactsNumber()); // verify items number increased on 1
  }

  @Test(priority=2)
  public void testContactCreationNegativeEmpty() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().returnToAddressBook();
    n = app.getContactHelper().getContactsNumber(); // get items number before adding contact
    app.getContactHelper().initContactCreation();
    // Define test data
	    Data_Contact contact = new Data_Contact();
	    contact.fname = "";
	    contact.lname = "";
	    contact.addr1 = "";
	    contact.phoneHome = "";
	    contact.phoneMob = "";
	    contact.phoneWork = "";
	    contact.email = "";
	    contact.email2 = "";
	    contact.bday = "";
	    contact.bmonth = "";
	    contact.byear = "";
	    contact.addr2 = "";
	    contact.phone2 = "";
    app.getContactHelper().fillContact(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToAddressBook();
    assertEquals(n+1, app.getContactHelper().getContactsNumber()); // verify items number increased on 1
  }

  @Test(priority=3)
  public void testContactCreationNegativeArbitrarySymbols() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().returnToAddressBook();
    n = app.getContactHelper().getContactsNumber(); // get items number before adding contact
    app.getContactHelper().initContactCreation();
    // Define test data
	    Data_Contact contact = new Data_Contact();
	    contact.fname = "@#$@%$#FGH0-==/.";
	    contact.lname = "+-345#$%(@*`'@#$";
	    contact.addr1 = "";
	    contact.phoneHome = "";
	    contact.phoneMob = "";
	    contact.phoneWork = "";
	    contact.email = "";
	    contact.email2 = "";
	    contact.bday = "";
	    contact.bmonth = "";
	    contact.byear = "";
	    contact.addr2 = "";
	    contact.phone2 = "";
    app.getContactHelper().fillContact(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToAddressBook();
    assertEquals(n+1, app.getContactHelper().getContactsNumber()); // verify items number increased on 1
  }
  
}
