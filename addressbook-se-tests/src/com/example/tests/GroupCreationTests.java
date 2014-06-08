package com.example.tests;

import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test (dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationPositiveNonEmpty(DataGroup group) {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();

    // save old state
    List<DataGroup> oldList = app.getGroupHelper().getGroups();

    // perform test actions
    app.getGroupHelper().initGroupCreation();
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    
    // save new state
    List<DataGroup> newList = app.getGroupHelper().getGroups();
    
    // compare states
    oldList.add(group);
    Collections.sort(oldList);
    Assert.assertEquals(newList, oldList);
  }

}
