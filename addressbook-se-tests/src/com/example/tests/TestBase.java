package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected static ApplicationManager app;

	@BeforeSuite
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}

	@AfterSuite
	public void tearDown() throws Exception {
		app.stop();
	}

	@DataProvider	//for Groups
	  public Iterator<Object[]> randomValidGroupGenerator() {
		  List<Object[]> list = new ArrayList<Object[]>();
		  for (int i = 0; i < 5; i++) {
			  DataGroup group = new DataGroup();
			  group.name = generateRandomString("name ");
			  group.header = generateRandomString("header ");
			  group.footer = generateRandomString("footer ");
			  list.add(new Object[]{group});
		  }
		  return list.iterator();
	  }

	  @DataProvider	//for Contacts
	  public Iterator<Object[]> randomValidContactGenerator() {
		  List<Object[]> list = new ArrayList<Object[]>();
		  for (int i = 0; i < 5; i++) {
			  DataContact contact = new DataContact();
			  contact.fname = generateRandomString("FirstName_");
			  contact.lname = generateRandomString("LastName_");
			  contact.email = generateRandomString("email@");
			  contact.addr1 = generateRandomString("");
			  contact.phoneHome = generateRandomString("");
			  contact.phoneMob = generateRandomString("");
			  contact.phoneWork = generateRandomString("");
			  contact.email2 = generateRandomString("");
			  contact.addr2 = generateRandomString("");
			  contact.phone2 = generateRandomString("");
			  list.add(new Object[]{contact});
		  }
		  return list.iterator();
	  }
	  
	  public String generateRandomString(String str) {
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			  return "";
		  }
		  else {
			  return str + rnd.nextInt(); 
		  }
	  }
	  	
}
