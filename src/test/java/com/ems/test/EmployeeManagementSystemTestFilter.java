package com.ems.test;
//import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.ems.app.EmployeeManagementSystemController;

public class EmployeeManagementSystemTestFilter {
	private static EmployeeManagementSystemController testerFilter=new EmployeeManagementSystemController();
	@Before
	public void setUP()
	{
		EmployeeManagementSystemController.reset();
	}
	@Test
	public void testFilterBeforeHavingNoElements() {
		boolean thrown = false;
		try {
			testerFilter.filter("name:=Teju&age:=25");
		}catch (IndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	@Test
	public void testFilterAbletoListElements() {
		boolean thrown = false;
		try {
			testerFilter.add("Teju", 20000, "Chennai", 25);
			testerFilter.add("Tej", 35000, "Hyd", 25);
			testerFilter.filter("name:=Teju&age:=25");
		} catch (Exception e) {
			thrown = true;
		}

		assertFalse(thrown);//Exception not thrown
	}
	@Test
	public void testFilterIllegalFormat() {
		boolean thrown = false;
		try {
			testerFilter.add("Teju", 20000, "Chennai", 25);
			testerFilter.add("Tej", 35000, "Hyd", 25);
			testerFilter.filter("name:Teju&age25");
		} catch (ArrayIndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);//Exception not thrown
	}
	
	@Test
	public void testFilterIllegalFormat1() {
		boolean thrown = false;
		try {
			testerFilter.add("Teju", 20000, "Chennai", 25);
			testerFilter.add("Tej", 35000, "Hyd", 25);
			testerFilter.filter("name:=Teju&age:=er");
		} catch (IllegalArgumentException e) {
			thrown = true;
		}

		assertTrue(thrown);//Exception not thrown
	}
	@Test
	public void testFilterIllegalFormat2() {
		boolean thrown = false;
		try {
			testerFilter.add("Teju", 20000, "Chennai", 25);
			testerFilter.add("Tej", 35000, "Hyd", 25);
			testerFilter.filter(" ");
		} catch (ArrayIndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);//Exception not thrown
	}
	@Test
	public void testFilterAfterDeleteAllElements() {
		boolean thrown = false;
		try {
			testerFilter.add("Teju", 20000, "Chennai", 24);
			testerFilter.add("Tej", 35000, "Hyd", 25);
			testerFilter.delete(1);
			testerFilter.delete(2);
			testerFilter.filter("name:=Teju&age:=25");
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
}
