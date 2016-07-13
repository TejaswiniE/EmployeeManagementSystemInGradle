package com.ems.test;
//import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.ems.app.EmployeeManagementSystemController;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	
public class EmployeeManagementSystemTestDelete {
	private static EmployeeManagementSystemController testerDelete=new EmployeeManagementSystemController();
	@Before
	public void setUP()
	{
		EmployeeManagementSystemController.reset();
	}
	@Test
	public void TestDeleteedAlreadyExistedElement() {
		testerDelete.add("Teju", 20000, "Chennai", 24);
		testerDelete.add("Tej", 35000, "Hyd", 25);
		assertTrue(testerDelete.delete(1));
	}
	@Test
	public void TestDeleteAlereadyDeletedElement() {
		boolean thrown = false;
		try {
			System.out.println(testerDelete.delete(1));
			
		} catch (Exception e) {
			
			thrown = true;
		}

		assertTrue(thrown);
	}
	
	@Test
	public void TestDeleteNotThereInList() {
		boolean thrown = false;

		try {
			testerDelete.delete(3);
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	

}
