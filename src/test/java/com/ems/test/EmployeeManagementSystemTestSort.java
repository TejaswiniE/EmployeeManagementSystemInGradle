package com.ems.test;
//import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.ems.app.EmployeeManagementSystemController;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	
public class EmployeeManagementSystemTestSort {
	private static EmployeeManagementSystemController testerSort=new EmployeeManagementSystemController();
	@Before
	public void setUP()
	{
		EmployeeManagementSystemController.reset();
	}
	@Test
	public void TestSortByAgeListEmpty() {
		EmployeeManagementSystemController.reset();
		boolean thrown = false;
		try {
			testerSort.sortByAge();
		}catch (IndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	@Test
	public void TestSortByNameListEmpty() {
		boolean thrown = false;
		try {
			testerSort.sortByName();
		}catch (IndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	@Test
	public void TestSortByLocationListEmpty() {
		boolean thrown = false;
		try {
			testerSort.sortByLocation();
		}catch (IndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	@Test
	public void TestSortByAge() {
		boolean thrown = false;
		try {
			testerSort.add("Teju", 20000, "Chennai", 24);
			testerSort.add("Tej", 35000, "Hyd", 25);
			testerSort.sortByAge();
		} catch (Exception e) {
			thrown = true;
		}

		assertFalse(thrown);//Exception not thrown
	}
	@Test
	public void TestSortByName() {
		boolean thrown = false;
		try {
			testerSort.add("Bhanu", 20000, "Chennai", 24);
			testerSort.add("Teju", 35000, "Hyd", 25);
			testerSort.sortByName();
		} catch (Exception e) {
			System.out.println(e);
			thrown = true;
		}

		assertFalse(thrown);//Exception not thrown
	}
	@Test
	public void TestSortByLocation() {
		boolean thrown = false;
		try {
			testerSort.add("Teju", 20000, "Chennai", 24);
			testerSort.add("Chandu", 35000, "Banglore", 25);
			testerSort.sortByLocation();
		} catch (Exception e) {
			System.out.println(e);
			thrown = true;
		}

		assertFalse(thrown);//Exception not thrown
	}
	@Test
	public void TestSortByAgeDeletedElements() {
		boolean thrown = false;
		try {
			testerSort.add("Teju", 20000, "Chennai", 24);
			testerSort.add("Tej", 35000, "Hyd", 25);
			testerSort.delete(1);
			testerSort.delete(2);
			testerSort.sortByAge();
		}catch (IndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	@Test
	public void TestSortByNameDeletedElements() {
		boolean thrown = false;
		try {
			testerSort.add("Bhanu", 20000, "Chennai", 24);
			testerSort.add("Teju", 35000, "Hyd", 25);
			testerSort.delete(1);
			testerSort.delete(2);
			testerSort.sortByName();
		}catch (IndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	@Test
	public void TestSortByLocationDeletedElements() {
		boolean thrown = false;
		try {
			testerSort.add("Teju", 20000, "Chennai", 24);
			testerSort.add("Chandu", 35000, "Banglore", 25);
			testerSort.delete(1);
			testerSort.delete(2);
			testerSort.sortByLocation();
		}catch (IndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	
}
