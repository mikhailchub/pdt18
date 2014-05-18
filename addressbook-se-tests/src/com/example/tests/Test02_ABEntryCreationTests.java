package com.example.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import static org.testng.AssertJUnit.assertEquals;

@Test(priority=2)
public class Test02_ABEntryCreationTests extends TestBase {
    private static Integer n;
	
  @Test(priority=1)
  public void testNonEmptyABEntryCreation() throws Exception {
    openMainPage();
    returnToAddressBook();
    n = driver.findElements(By.xpath("//td/input")).size();
    initABEntryCreation();
    // Define test data
	    Data_AddressBook ab = new Data_AddressBook();
	    ab.fname = "fname";
	    ab.lname = "lname";
	    ab.addr1 = "address 1";
	    ab.phone_home = "01";
	    ab.phone_mob = "02";
	    ab.phone_work = "03";
	    ab.email = "abc@xyz.com";
	    ab.email2 = "qwe@rty";
	    ab.bday = "1";
	    ab.bmonth = "February";
	    ab.byear = "1999";
	    ab.addr2 = "address 2";
	    ab.phone2 = "+1234567890";
    fillABEntry(ab);
    submitABEntryCreation();
    returnToAddressBook();
    assertEquals(n+1, driver.findElements(By.xpath("//td/input")).size());    
  }

  @Test(priority=2)
  public void testEmptyABEntryCreation() throws Exception {
    openMainPage();
    returnToAddressBook();
    n = driver.findElements(By.xpath("//td/input")).size();
    initABEntryCreation();
    // Define test data
	    Data_AddressBook ab = new Data_AddressBook();
	    ab.fname = "";
	    ab.lname = "";
	    ab.addr1 = "";
	    ab.phone_home = "";
	    ab.phone_mob = "";
	    ab.phone_work = "";
	    ab.email = "";
	    ab.email2 = "";
	    ab.bday = "";
	    ab.bmonth = "";
	    ab.byear = "";
	    ab.addr2 = "";
	    ab.phone2 = "";
    fillABEntry(ab);
    submitABEntryCreation();
    returnToAddressBook();
    assertEquals(n+1, driver.findElements(By.xpath("//td/input")).size());    
  }

  @Test(priority=3)
  public void testArbitrarySymbolsABEntryCreation() throws Exception {
    openMainPage();
    returnToAddressBook();
    n = driver.findElements(By.xpath("//td/input")).size();
    initABEntryCreation();
    // Define test data
	    Data_AddressBook ab = new Data_AddressBook();
	    ab.fname = "@#$@%$#FGH0-==/.";
	    ab.lname = "+-345#$%(@*`'@#$";
	    ab.addr1 = "";
	    ab.phone_home = "";
	    ab.phone_mob = "";
	    ab.phone_work = "";
	    ab.email = "";
	    ab.email2 = "";
	    ab.bday = "";
	    ab.bmonth = "";
	    ab.byear = "";
	    ab.addr2 = "";
	    ab.phone2 = "";
    fillABEntry(ab);
    submitABEntryCreation();
    returnToAddressBook();
    assertEquals(n+1, driver.findElements(By.xpath("//td/input")).size());    
  }
  
}
