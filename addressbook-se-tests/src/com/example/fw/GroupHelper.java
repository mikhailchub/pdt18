package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.DataGroup;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initGroupCreation() {
	    click(By.name("new"));
	}

	public void fillGroupForm(DataGroup group) {
	    fillTxtField(By.name("group_name"), group.name);
	    fillTxtField(By.name("group_header"), group.header);
	    fillTxtField(By.name("group_footer"), group.footer);
	}

	public void submitGroupCreation() {
	    click(By.name("submit"));
	}

	public void returnToGroupsPage() {
	    click(By.linkText("group page"));
	}

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}

	public void submitGroupModification() {
	    click(By.name("update"));
	}

	public int getGroupsNumber() {
		return getItemsNumber(By.xpath("//input[@name='selected[]']"));
	}

	public List<DataGroup> getGroups() {
		List<DataGroup> groups = new ArrayList<DataGroup>();
		List<WebElement> checkboxes = getItems(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			DataGroup group = new DataGroup();
			String title = checkbox.getAttribute("title");
			group.name = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(group);
		}
		return groups;
	}

}
