package com.ems.model;

public class Employee {

	private String name;
    private int id;
    private double salary;
    private int age;
    private String location;

	/**
	 * Get the Name of employee
	 * @param No parameters
	 * @return Return the name of the employee
	 */
	public String getName() {
		return name;
	}
	/**
	 * Set the name of employee
	 * @param name : Name of employee in string format
	 *  @return nothing
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the Id of employee
	 * @param No parameters
	 * @return Return the employee id in integer format
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Set the Id of employee
	 * @param id : Id of employee in integer format
	 *  @return nothing
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Get the salary of given employee
	 * @param No parameters
	 * @return salary :Salary of given employee in double format
	 */
	public double getSalary() {
		return salary;
	}
	
	/**
	 * Set the salary of given employee
	 * @param salary : Salary of employee in double format
	 *  @return nothing
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	/**
	 * Get the age of given employee
	 * @param No parameters
	 * @return age : Age of employee in integer format  
	 */
	public int getAge() {
		return age;
		
	}
	/**
	 * Set the age of given employee.
	 * It cannot be negative and more than 100
	 * @param age : Age of employee only accept positive integers not more than 100
	 *  @return nothing
	 */
	public void setAge(int age) {
		this.age = age;
		
	}
	/**
	 * Get the location of given employee
	 * @param No parameters
	 * @return location :Location of employee in string format
	 */
	public String getLocation() {
		return location;
	}
	/**
	 *Set location of the employee in string format
	 * @param location : Location of employee in string format
	 * @return nothing
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Print the given employee details
	 * @param No parameters
	 * @return Nothing
	 */
	public void printEmployeeDetails()
	{
		System.out.println(this.getId()+" "+this.getName()+" "+this.getLocation()+" "+this.getSalary()+" "+this.getAge());
	}
}
