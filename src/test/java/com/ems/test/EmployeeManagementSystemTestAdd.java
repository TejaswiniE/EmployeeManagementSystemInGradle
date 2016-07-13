package com.ems.test;

import org.junit.Before;
import org.junit.Test;
import com.ems.app.EmployeeManagementSystemController;

import static org.junit.Assert.*;
public class EmployeeManagementSystemTestAdd {

	private static EmployeeManagementSystemController testerAdd = new EmployeeManagementSystemController();
	@Before
	public void setUP()
	{
		EmployeeManagementSystemController.reset();
	}
	@Test
	public void testAddElements() {
		
		assertEquals(1, testerAdd.add("tej", 25000, "lochjh", 25));
		assertEquals(2, testerAdd.add("tej", 25000, "location", 25));
		assertEquals(3, testerAdd.add("chandu", 30000, "Hyd", 23));
	}

	@Test
	public void testAddElementWithIllegalAgeArgument() {
		boolean thrown = false;

		try {
			testerAdd.add("chandu", 30000, "Hyd", -23);
		} catch (IllegalArgumentException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}

	@Test
	public void testAddElementWithIllegalNameArgument() {
		boolean thrown = false;

		try {
			testerAdd.add("", 30000, "Hyd", 23);
		} catch (IllegalArgumentException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}

	@Test
	public void testAddElementWithIllegalLocationArgument() {
		boolean thrown = false;

		try {
			testerAdd.add("chandu", 30000, "", 23);
		} catch (IllegalArgumentException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}

	@Test
	public void testAddElementWithIllegalArguments() {
		boolean thrown = false;

		try {
			testerAdd.add("", -1, "", 0);
		} catch (IllegalArgumentException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}

}