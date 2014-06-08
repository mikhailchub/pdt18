package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.DataContact;


public class ContactHelper extends HelperBase  {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContact(DataContact contact) {
		fillTxtField(By.name("firstname"), contact.fname);
		fillTxtField(By.name("lastname"), contact.lname);
		fillTxtField(By.name("address"), contact.addr1);
		fillTxtField(By.name("home"), contact.phoneHome);
		fillTxtField(By.name("mobile"), contact.phoneMob);
		fillTxtField(By.name("work"), contact.phoneWork);
		fillTxtField(By.name("email"), contact.email);
		fillTxtField(By.name("email2"), contact.email2);
		fillDropdownField(By.name("bday"), contact.bday);
		fillDropdownField(By.name("bmonth"), contact.bmonth);
		fillTxtField(By.name("byear"), contact.byear);
		fillTxtField(By.name("address2"), contact.addr2);
		fillTxtField(By.name("phone2"), contact.phone2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToAddressBook() {
		click(By.linkText("home"));
	}
	
	public int getContactsNumber() {
		return getItemsNumber(By.xpath("//td/input[@name='selected[]']"));
	}
	
//	private void selectContactByIndex(int index) {
//		click(By.xpath("//table[@id='maintable']//tr[" + (index + 1) + "]//td[1]//input"));
//	}

	public void initContactModification(int index) {
//		selectContactByIndex(index); // this step is unnecessary
//		click(By.xpath("//table[@id='maintable']//tr[" + (index + 1) + "]//td[7]//a"));
	    getWebElementWhenClickable(By.xpath("//table[@id='maintable']//tr[" + (index + 1) + "]//td[7]//a")).click(); // same as click but waits until clickable
	}

	public void submitContactModification() {
//	    click(By.xpath("//input[@name='update'][@value='Update']"));
	    getWebElementWhenClickable(By.xpath("//input[@name='update'][@value='Update']")).click(); // same as click but waits until clickable
	}
	
	public void deleteContact(int index) {
		initContactModification(index); // open "Update" form first to access "Delete" button
		getWebElementWhenClickable(By.xpath("//input[@name='update'][@value='Delete']")).click(); // wait for "Delete" button to appear, and then click on it
	}
	
}
