package com.example.tests;

import org.testng.annotations.Test;

@Test(priority=1)
public class Test01_GroupCreationTests extends TestBase {

  @Test(priority=1)
  public void testNonEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    Data_Group group = new Data_Group();
    group.name = "group name 1";
    group.header = "header 1";
    group.footer = "footer 1";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }

  @Test(priority=2)
  public void testArbitrarySymbolsGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    Data_Group group = new Data_Group();
    group.name = "@#$^SFG$+-.-1e";
    group.header = "-23h";
    group.footer = "^$%we#er_=`~";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }
    
  @Test(priority=3)
  public void testEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    fillGroupForm(new Data_Group("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
  }
}
