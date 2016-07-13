package com.ems.test;
//import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ems.app.EmployeeManagementSystemController;
public class EmployeeManagementSystemTestShow {
	private static EmployeeManagementSystemController testerShow=new EmployeeManagementSystemController();
	@Before
	public void setUP()
	{
		EmployeeManagementSystemController.reset();
	}
	@Test
	public void TestShowAbletoShowElementInList() {
		testerShow.add("Teju", 20000, "Chennai", 24);
		testerShow.add("Tej", 35000, "Hyd", 25);
		assertTrue(testerShow.show(1));
	}
	@Test
	public void TestShowAlreadyDeletedElement() {
		boolean thrown = false;
		try {
			testerShow.add("Teju", 20000, "Chennai", 24);
			testerShow.delete(1);
			testerShow.show(1);
		} catch (IndexOutOfBoundsException e) {
			
			thrown = true;
		}

		assertTrue(thrown);
	}
	
	@Test
	public void TestShowOutOfBoundElement() {
		boolean thrown = false;

		try {
			testerShow.show(3);
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	

}
