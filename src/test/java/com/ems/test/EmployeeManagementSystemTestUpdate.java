package com.ems.test;
//import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.ems.app.EmployeeManagementSystemController;
public class EmployeeManagementSystemTestUpdate {
	private static EmployeeManagementSystemController testerUpdate=new EmployeeManagementSystemController();
	@Before
	public void setUP()
	{
		EmployeeManagementSystemController.reset();
	}
	@Test
	public void TestUpdateAlreadyInttheListe() {
		EmployeeManagementSystemController.reset();
		testerUpdate.add("Teju", 20000, "Chennai", 24);
		testerUpdate.add("Tej", 35000, "Hyd", 25);
		assertTrue(testerUpdate.update(2, "chandu", 30000, "Hyd", 23));
		assertTrue(testerUpdate.update(1, "chandu", 2000, "delhi", 24));
	}
	@Test
	public void TestUpdateWithWrongAge() {
		boolean thrown = false;
		testerUpdate.add("Teju", 20000, "Chennai", 24);
		testerUpdate.add("Tej", 35000, "Hyd", 25);
		try {
			testerUpdate.update(2, "chandu", 2000, "delhi", -24);
		} catch (IllegalArgumentException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	
	@Test
	public void TestUpdateWithWrongSalary() {
		boolean thrown = false;
		testerUpdate.add("Teju", 20000, "Chennai", 24);
		testerUpdate.add("Tej", 35000, "Hyd", 25);
		try {
			testerUpdate.update(2, "chandu",-0, "delhi", 24);
		} catch (IllegalArgumentException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	@Test
	public void TestUpdatewithEmpty() {
		boolean thrown = false;
		testerUpdate.add("Teju", 20000, "Chennai", 24);
		testerUpdate.add("Tej", 35000, "Hyd", 25);
		try {
			testerUpdate.update(2,"", 0, "", -24);
		} catch (IllegalArgumentException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	@Test
	public void TestUpdateElementNotInList() {
		boolean thrown = false;
		testerUpdate.add("Teju", 20000, "Chennai", 24);
		testerUpdate.add("Tej", 35000, "Hyd", 25);
		try {
			testerUpdate.update(3,"", 0, "", -24);
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	

}
