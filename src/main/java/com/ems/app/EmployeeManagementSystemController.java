package com.ems.app;
import com.ems.service.*;

import java.util.ArrayList;

import com.ems.model.Employee;

public class EmployeeManagementSystemController {
	private static volatile EmployeeManagementSystemServiceImplementation emsServiceImpl = new EmployeeManagementSystemServiceImplementation();
	public static void reset() {
		emsServiceImpl = new EmployeeManagementSystemServiceImplementation();
	}
	/**
	 * Request to service to add employee
	 * @param name : Name of the employee
	 * @param salary :Salary of the employee
	 * @param location :Location of the employee
	 * @param age :Age of the Employee
	 * @return Id allocated to given EMployee
	 */
	public int add(String name, double salary, String location, int age) {

		int allocatedId = emsServiceImpl.add(name, salary, location, age);
		return allocatedId;
	}

	/**
	 * Request to service to update employee details
	 * @param id :Id of the employee
	 * @param name : Name of the employee
	 * @param salary :Salary of the employee
	 * @param location :Location of the employee
	 * @param age :Age of the Employee
	 * @return boolean : If sucessfully updated returns true else false
	 */
	public boolean update(int id, String name, double salary, String location,
			int age) {
		boolean status = emsServiceImpl.update(id, name, salary, location, age);
		return status;

	}
	

	/**
	 * Request to service to show employee details
	 * @param id :Id of the employee
	 * @return boolean :If able to reply returns true else false
	 */
	public boolean show(int id) {
		boolean status = emsServiceImpl.show(id);
		return status;
	}
	/**
	 * Request to service to delete employee details
	 * @param id :Id of the employee
	 * @return If sucessfully deteled returns true else false
	 */

	public boolean delete(int id) {
		boolean status = emsServiceImpl.delete(id);
		return status;
	}
	
	/**
	 * Request service to show employee list by age
	 */
	public void sortByAge() {
		ArrayList<Employee> employeeSortedList = emsServiceImpl.sortByAge();
		displayList(employeeSortedList);
	}
	/**
	 * Request service to show employee list by name
	 */
	public void sortByName() {
		ArrayList<Employee> employeeSortedList = emsServiceImpl.sortByName();
		displayList(employeeSortedList);
	}
	/**
	 * Request service to show employee list by location
	 */
	public void sortByLocation() {
		ArrayList<Employee> employeeSortedList = emsServiceImpl.sortByLocation();
		displayList(employeeSortedList);
	}
	/**
	 * Request service to show employee list
	 */
	public void listAll() {
		ArrayList<Employee> employeelist = emsServiceImpl.listAll();
		if (employeelist.isEmpty())
			throw new IndexOutOfBoundsException("Index: 0, Size: 0");
		else
			displayList(employeelist);
	}
	
	/**
	 * Filter the list based on search query
	 * @param searchString : Querystring
	 * @return Nothing
	 */
	public void filter(String searchString) {
		ArrayList<Employee> filterdlist = emsServiceImpl.filter(searchString);
		if (filterdlist != null)
			displayList(filterdlist);
	}

	/**
	 * Display the list of employees
	 * @param employeelist :Array list of employee objects
	 * 
	 */
	public void displayList(ArrayList<Employee> employeelist) {
		if (!employeelist.isEmpty()) {
			for (Employee employee : employeelist) {
				if (employee != null)
					employee.printEmployeeDetails();
			}
		}
		else
		{
			System.out.println("List is Empty");
		}
	}
}
