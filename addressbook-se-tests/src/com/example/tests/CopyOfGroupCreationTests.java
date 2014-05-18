package com.example.tests;

import org.testng.annotations.Test;

@Test(priority=2)
public class CopyOfGroupCreationTests extends TestBase {

  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    Data_group group = new Data_group();
    group.group_name = "group name 2";
    group.group_header = "header 2";
    group.group_footer = "footer 2";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    fillGroupForm(new Data_group("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
  }

  
}
