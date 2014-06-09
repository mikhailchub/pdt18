package com.example.fw;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class HelperBase {
	
	protected ApplicationManager manager;
	protected WebDriver driver;
	public boolean acceptNextAlert = true;

	public HelperBase(ApplicationManager manager) {
		this.manager = manager;
		this.driver = manager.driver;
	}
	
	protected void fillTxtField(By locator, String text) {
		if (text != null) {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
		}
	}

	protected void fillDropdownField(By locator, String text) {
		// !text.isEmpty check is added because DropDown field can not be filled with ""
		// so it's skipped when value == ""
		if (text != null && !text.isEmpty()) {	
			new Select(driver.findElement(locator)).selectByVisibleText(text);		
		}
	}

	protected void click(By locator) {
		driver.findElement(locator).click();
	}

	protected WebElement getWebElementWhenClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
		return driver.findElement(locator);
	}

	public int getItemsNumber(By locator) {
		int n;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS); // avoid too long test execution if list is empty
		n = driver.findElements(locator).size();
		driver.manage().timeouts().implicitlyWait(manager.TIMEOUT, TimeUnit.SECONDS); // set wait settings back
		return n;
	}

	public List<WebElement> getItems(By locator) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS); // avoid too long test execution if list is empty
		List<WebElement> items = driver.findElements(locator);
		driver.manage().timeouts().implicitlyWait(manager.TIMEOUT, TimeUnit.SECONDS); // set wait settings back
		return items;
	}
	
	private String getItemText(By locator) {
		String str = driver.findElement(locator).getText();
//		if (str.isEmpty()) {return null;}  // needed for comparison in tests assertions and makes sense if dataProvider initializes data object with null values
		if (str.isEmpty()) {return "";}  //  when all fields of data object, used in our test, are initialized with some value != null
		else {return str;}		
	}

	public String getTableCellValue(String tableXPathLocator, int rowIndex, int colIndex) {
		return getItemText(By.xpath(tableXPathLocator + "//tr[" + rowIndex + "]" + "//td[" + colIndex + "]"));
	}	

	
	public String getTableCellValue(String tableXPathLocator, int rowIndex, String columnXPathLocator) {
		return getItemText(By.xpath(tableXPathLocator + "//tr[" + rowIndex + "]" + columnXPathLocator));
	}	
	
	public boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	
}
