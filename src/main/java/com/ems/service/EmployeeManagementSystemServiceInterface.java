package com.ems.service;

import com.ems.model.Employee;

import java.util.ArrayList;

/**
 * ServiceInterface : Interface to all services in Employee Management System
 * 
 */
public interface EmployeeManagementSystemServiceInterface {
	/**
	 * show : Show the details of given employee based on id
	 * 
	 * @param id
	 *            Id of employee in
	 * @return Employee object
	 * @throws Exception 
	 */
	public boolean show(int id);

	/**
	 * Add : Add the new employee
	 * 
	 * @param employee details
	 *      
	 * @return id :boolean if able to show returns true otherwise false
	 */
	public int add(String name, double salary, String location, int age);

	/**
	 * Delete : Remove the employee from the employee list
	 * 
	 * @param id
	 *            : Id of the employee
	 * @return Boolean value true if able to delete otherwise false
	 */
	public boolean delete(int id);

	/**
	 * Update : Update the employee details
	 * 
	 * @param employee
	 *            : Employee object
	 * @return Boolean value true if able to update otherwise false
	 */
	public boolean update(int id, String name, double salary, String location,
			int age);

	/**
	 * ListAll : Listall employee details
	 * 
	 * @param No
	 *            parameters
	 * @return employeelist : List of all employees in arraylist
	 */
	public ArrayList<Employee> listAll();

	/**
	 * SortByAge : Sort all elements in based on age
	 * 
	 * @param No
	 *            parameters
	 * @return SortedEmployeeList : Sorted list of all employees in arraylist
	 *         format based on age
	 */
	public ArrayList<Employee> sortByAge();

	/**
	 * SortByLocation : Sort all elements in based on location
	 * 
	 * @param No
	 *            parameters
	 * @return SortedEmployeeList : Sorted list of all employees in arraylist
	 *         format based on location
	 */
	public ArrayList<Employee> sortByLocation();

	/**
	 * SortByName : Sort all elements in based on name
	 * 
	 * @param No
	 *            parameters
	 * @return SortedEmployeeList : Sorted list of all employees in arraylist
	 *         format based on name
	 */
	public ArrayList<Employee> sortByName();

	/**
	 * @param searchString
	 *            : Serach query in string format
	 * @return filteredList :List of all filtered based on
	 */
	public ArrayList<Employee> filter(String searchString);

}
