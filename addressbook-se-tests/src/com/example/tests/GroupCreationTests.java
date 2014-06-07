package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

	private static int n;

  @Test(priority=1)
  public void testGroupCreationPositiveNonEmpty() {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    n = app.getGroupHelper().getGroupsNumber();
    app.getGroupHelper().initGroupCreation();
    Data_Group group = new Data_Group();
    group.name = "group name 1";
    group.header = "header 1";
    group.footer = "footer 1";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    Assert.assertTrue(n+1 == app.getGroupHelper().getGroupsNumber()); // verify that number of groups increased
  }

  @Test(priority=2)
  public void testGroupCreationNegativeArbitrarySymbols() {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    n = app.getGroupHelper().getGroupsNumber();    
    app.getGroupHelper().initGroupCreation();
    Data_Group group = new Data_Group();
    group.name = "@#$^SFG$+-.-1e";
    group.header = "-23h";
    group.footer = "^$%we#er_=`~";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    Assert.assertTrue(n+1 == app.getGroupHelper().getGroupsNumber()); // verify that number of groups increased    
  }
    
  @Test(priority=3)
  public void testGroupCreationNegativeEmpty() {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    n = app.getGroupHelper().getGroupsNumber();    
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new Data_Group("", "", ""));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    Assert.assertTrue(n+1 == app.getGroupHelper().getGroupsNumber()); // verify that number of groups increased    
  }
}
