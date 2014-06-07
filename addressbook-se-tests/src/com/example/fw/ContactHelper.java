package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.Data_Contact;


public class ContactHelper extends HelperBase  {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContact(Data_Contact contact) {
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
		return driver.findElements(By.xpath("//td/input")).size();
	}
}
