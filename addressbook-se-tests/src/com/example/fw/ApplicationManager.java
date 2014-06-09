package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class ApplicationManager {

	public WebDriver driver;
	public String baseUrl;
	
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;	
	
	public final int TIMEOUT = 10;
	
	// Constructor
	public ApplicationManager() {
		driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8080/";
	    driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    
/* // Static initialisation of helpers	    
	    navigationHelper = new NavigationHelper(this);
	    groupHelper = new GroupHelper(this);
	    contactHelper = new ContactHelper(this);
*/
	}

	    public void stop() {
		driver.quit();
	}

// Lazy initialisation of helpers
	public NavigationHelper getNavigationHelper() {
		if (navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}
	public GroupHelper getGroupHelper() {
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}
	public ContactHelper getContactHelper() {
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}
}
