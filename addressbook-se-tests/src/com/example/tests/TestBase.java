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

	  @DataProvider
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
