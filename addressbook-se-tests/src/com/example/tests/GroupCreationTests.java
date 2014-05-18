package com.example.tests;

import org.testng.annotations.Test;

@Test(priority=1)
public class GroupCreationTests extends TestBase {

  @Test(priority=1)
  public void testNonEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    Data_group group = new Data_group();
    group.group_name = "group name 1";
    group.group_header = "header 1";
    group.group_footer = "footer 1";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }

  @Test(priority=2)
  public void testArbitrarySymbolsGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    Data_group group = new Data_group();
    group.group_name = "@#$^SFG$+-.-1e";
    group.group_header = "-23h";
    group.group_footer = "^$%we#er_=`~";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }
    
  @Test(priority=3)
  public void testEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    fillGroupForm(new Data_group("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
  }
}
