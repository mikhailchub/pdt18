package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

	private static int n;
	
	@Test
	public void testGroupRemovalPositive() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    n = app.getGroupHelper().getGroupsNumber(); // get items number before deleting group
		app.getGroupHelper().deleteGroup(1);
	    app.getGroupHelper().returnToGroupsPage();
	    Assert.assertTrue(n-1 == app.getGroupHelper().getGroupsNumber()); // verify that number of groups decreased
	}
	
}
