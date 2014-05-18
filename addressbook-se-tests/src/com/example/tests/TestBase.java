package com.example.tests;

import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase {

	public static WebDriver driver;
	private static String baseUrl;
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8080/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	@AfterTest
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	
// ---- Shared methods ----

	protected void openMainPage() {
	    driver.get(baseUrl + "/addressbookv4.1.4/group.php");
	}
	
// ---- "Groups" methods ----

	protected void gotoGroupsPage() {
	    driver.findElement(By.linkText("groups")).click();
	}

	protected void initGroupCreation() {
	    driver.findElement(By.name("new")).click();
	}

	protected void fillGroupForm(Data_Group group) {
	    driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.name);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	protected void submitGroupCreation() {
	    driver.findElement(By.name("submit")).click();
	}

	protected void returnToGroupsPage() {
	    driver.findElement(By.linkText("group page")).click();
	}

// ---- "AB Entries" methods ----

	protected void initABEntryCreation() {
		driver.findElement(By.linkText("add new")).click();
	}

/*	
	protected void fillABEntry(Data_AddressBook ab) {
		driver.findElement(By.name("firstname")).clear();
	    driver.findElement(By.name("firstname")).sendKeys(ab.fname);
	    driver.findElement(By.name("lastname")).clear();
	    driver.findElement(By.name("lastname")).sendKeys(ab.lname);
	    driver.findElement(By.name("address")).clear();
	    driver.findElement(By.name("address")).sendKeys(ab.addr1);
	    driver.findElement(By.name("home")).clear();
	    driver.findElement(By.name("home")).sendKeys(ab.phone_home);
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys(ab.phone_mob);
	    driver.findElement(By.name("work")).clear();
	    driver.findElement(By.name("work")).sendKeys(ab.phone_work);
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys(ab.email);
	    driver.findElement(By.name("email2")).clear();
	    driver.findElement(By.name("email2")).sendKeys(ab.email2);
	    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(ab.bday);
	    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(ab.bmonth);
	    driver.findElement(By.name("byear")).clear();
	    driver.findElement(By.name("byear")).sendKeys(ab.byear);
	    driver.findElement(By.name("address2")).clear();
	    driver.findElement(By.name("address2")).sendKeys(ab.addr2);
	    driver.findElement(By.name("phone2")).clear();
	    driver.findElement(By.name("phone2")).sendKeys(ab.phone2);
	}
*/
	protected void fillABEntry(Data_AddressBook ab) {
		fillTextField("firstname", ab.fname);
		fillTextField("lastname", ab.lname);
		fillTextField("address", ab.addr1);
		fillTextField("home", ab.phone_home);
		fillTextField("mobile", ab.phone_mob);
		fillTextField("work", ab.phone_work);
		fillTextField("email", ab.email);
		fillTextField("email2", ab.email2);
		fillDropdownField("bday", ab.bday);
		fillDropdownField("bmonth", ab.bmonth);
		fillTextField("byear", ab.byear);
		fillTextField("address2", ab.addr2);
		fillTextField("phone2", ab.phone2);
	}
	
	
	protected void returnToAddressBook() {
		driver.findElement(By.linkText("home")).click();
	}

	protected void submitABEntryCreation() {
		driver.findElement(By.name("submit")).click();
	}

// ---- Auxiliary methods ----	
	
	// Auxiliary method to fill text fields with values. 
	// If value is empty string - no actions performed under field.
	private void fillTextField(String fieldName, String fieldValue) {
		if (fieldValue != "") {
			driver.findElement(By.name(fieldName)).clear();
			driver.findElement(By.name(fieldName)).sendKeys(fieldValue);
		}
	}
	// Auxiliary method to fill dropdown fields with values. 
	// If value is empty string - no actions performed under field.
	private void fillDropdownField(String fieldName, String fieldValue) {
		if (fieldValue != "") {
			new Select(driver.findElement(By.name(fieldName))).selectByVisibleText(fieldValue);		
		}
	}
	
}
