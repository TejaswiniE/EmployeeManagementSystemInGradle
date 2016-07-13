package com.ems.test;
//import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.ems.app.EmployeeManagementSystemController;

public class EmployeeManagementSystemTestListAll {
	private static EmployeeManagementSystemController testerListAll=new EmployeeManagementSystemController();
	@Before
	public void setUP()
	{
		EmployeeManagementSystemController.reset();
	}
	@Test
	public void TestListAllBeforeHavingNoElements() {
		boolean thrown = false;
		try {
			testerListAll.listAll();
		}catch (IndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	@Test
	public void TestListAllAbletoListElements() {
		boolean thrown = false;
		try {
			testerListAll.add("Teju", 20000, "Chennai", 24);
			testerListAll.add("Tej", 35000, "Hyd", 25);
			testerListAll.listAll();
		} catch (Exception e) {
			System.out.println(e);
			thrown = true;
		}

		assertFalse(thrown);//Exception not thrown
	}
	
	@Test
	public void TestListAllAfterDeleteAllElements() {
		boolean thrown = false;
		try {
			testerListAll.add("Teju", 20000, "Chennai", 24);
			testerListAll.add("Tej", 35000, "Hyd", 25);
			testerListAll.delete(1);
			testerListAll.delete(2);
			testerListAll.listAll();
		} catch (NullPointerException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
}
