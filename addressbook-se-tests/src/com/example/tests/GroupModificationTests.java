package com.example.tests;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test (dataProvider = "randomValidGroupGenerator")
	public void testGroupModificationPositive(DataGroup group) {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();

	    // save old state
	    List<DataGroup> oldList = app.getGroupHelper().getGroups();

	    // generate random index of selected element
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);

	    // perform test actions
		app.getGroupHelper().initGroupModification(index);
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
	    app.getGroupHelper().returnToGroupsPage();

	    // save new state
	    List<DataGroup> newList = app.getGroupHelper().getGroups();

	    // compare states
	    oldList.remove(index); 
	    oldList.add(group);
	    Collections.sort(oldList);
	    Assert.assertEquals(newList, oldList);    	    
	}	

}
