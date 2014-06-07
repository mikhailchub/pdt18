package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test(priority=1)
  public void testGroupCreationPositiveNonEmpty() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().initGroupCreation();
    Data_Group group = new Data_Group();
    group.name = "group name 1";
    group.header = "header 1";
    group.footer = "footer 1";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
  }

  @Test(priority=2)
  public void testGroupCreationNegativeArbitrarySymbols() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().initGroupCreation();
    Data_Group group = new Data_Group();
    group.name = "@#$^SFG$+-.-1e";
    group.header = "-23h";
    group.footer = "^$%we#er_=`~";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
  }
    
  @Test(priority=3)
  public void testGroupCreationNegativeEmpty() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new Data_Group("", "", ""));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
  }
}
