package com.ems.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.ems.model.Employee;

public class EmployeeManagementSystemServiceImplementation implements
		EmployeeManagementSystemServiceInterface {
	/**
	 * employee list : Array list of all employees
	 */
	private ArrayList<Employee> employeelist=new ArrayList<Employee>();;
	private int count = 1;

	public ArrayList<Employee> nullCheck(ArrayList<Employee> employeeList) {
		ArrayList<Employee> employeeListWithoutNull = new ArrayList<Employee>();
		for (Employee emp : employeeList) {
			if (emp != null) {
				employeeListWithoutNull.add(emp);
			}
		}

		return employeeListWithoutNull;

	}

	public boolean show(int id) {
		try {
			if (employeelist.get(id - 1) != null) {
				Employee employee = employeelist.get(id - 1);
				employee.printEmployeeDetails();
				return true;
			} else {
				throw new IndexOutOfBoundsException();
			}
		} catch (IndexOutOfBoundsException ex) {
			throw ex;
		}

	}

	public boolean delete(int id) {
		try {
			if (employeelist.get(id - 1) != null) {
				employeelist.set(id - 1, null);

				return true;
			} else {
				throw new IndexOutOfBoundsException();
			}
		} catch (IndexOutOfBoundsException ex) {
			throw ex;
		}

	}

	public int add(String name, double salary, String location, int age) {
		Employee employee = new Employee();
		try {
			if (age <= 0 || age >= 150 || name == "" || location == ""
					|| salary <= 0 || name.trim().length() <= 0
					|| location.trim().length() <= 0) {
				throw new IllegalArgumentException();
			}
			employee.setId(count);
			employee.setName(name);
			employee.setSalary(salary);
			employee.setLocation(location);
			employee.setAge(age);
			count++;
			employeelist.add(employee);
			return employee.getId();
		} catch (IllegalArgumentException ex) {
			throw ex;
		}
	}

	public ArrayList<Employee> listAll() {
		try {
			if (!employeelist.isEmpty()) {

				ArrayList<Employee> employeeListWithoutNull = nullCheck(employeelist);
				if (employeeListWithoutNull.isEmpty()) {
					throw new NullPointerException();
				} else {
					return employeelist;
				}
			} else {
				throw new IndexOutOfBoundsException();
			}
		} catch (IndexOutOfBoundsException ex) {
			throw ex;
		} catch (NullPointerException ex) {
			throw ex;
		}

	}

	public boolean update(int id, String name, double salary, String location,
			int age) {
		try {
			if (employeelist.get(id - 1) != null) {
				if (age <= 0 || age >= 150 || name == "" || location == ""
						|| salary <= 0 || name.trim().length() <= 0
						|| location.trim().length() <= 0) {
					throw new IllegalArgumentException();
				}
				Employee employee = new Employee();
				employee.setId(id);
				employee.setName(name);
				employee.setSalary(salary);
				employee.setLocation(location);
				employee.setAge(age);
				employeelist.set(id - 1, employee);
				return true;
			} else {
				return false;
			}
		} catch (IllegalArgumentException ex) {
			throw ex;
		} catch (IndexOutOfBoundsException ex) {
			throw ex;
		}
	}

	public ArrayList<Employee> sortByAge() {
		try {
			if (!employeelist.isEmpty()) {
				ArrayList<Employee> employeeListToSort = nullCheck(employeelist);
				if (!employeeListToSort.isEmpty()) {
					Collections.sort(employeeListToSort,
							new Comparator<Employee>() {
								public int compare(Employee employee1,
										Employee employee2) {
									int compare = (employee1.getAge() > employee2
											.getAge()) ? 1 : 0;
									if (compare == 0)
										compare = (employee1.getAge() > employee2
												.getAge()) ? 0 : -1;
									return compare;
								}
							});
					return employeeListToSort;
				} else {
					throw new IndexOutOfBoundsException();
				}
			} else {
				throw new IndexOutOfBoundsException();
			}
		} catch (IndexOutOfBoundsException ex) {
			throw ex;
		}

	}

	public ArrayList<Employee> sortByLocation() {
		try {
			if (!employeelist.isEmpty()) {
				ArrayList<Employee> employeeListToSort = nullCheck(employeelist);
				if (!employeeListToSort.isEmpty()) {
					Collections.sort(employeeListToSort,
							new Comparator<Employee>() {
								public int compare(Employee employee1,
										Employee employee2) {
									return employee1.getLocation()
											.compareToIgnoreCase(
													employee2.getLocation());
								}
							});
					return employeeListToSort;
				} else {
					throw new IndexOutOfBoundsException();
				}
			} else {
				throw new IndexOutOfBoundsException();
			}
		} catch (IndexOutOfBoundsException ex) {
			throw ex;
		}
	}

	public ArrayList<Employee> sortByName() {
		try {
			if (!employeelist.isEmpty()) {
				ArrayList<Employee> employeeListToSort = nullCheck(employeelist);
				if (!employeeListToSort.isEmpty()) {
					Collections.sort(employeeListToSort,
							new Comparator<Employee>() {
								public int compare(Employee employee1,
										Employee employee2) {
									return employee1.getName()
											.compareToIgnoreCase(
													employee2.getName());
								}
							});
					return employeeListToSort;
				} else {
					throw new IndexOutOfBoundsException();
				}
			} else {
				throw new IndexOutOfBoundsException();
			}
		} catch (IndexOutOfBoundsException ex) {
			throw ex;
		}
	}

	public ArrayList<Employee> filter(String searchString) {
		ArrayList<Employee> filteredList = new ArrayList<Employee>();
		String[][] keyValuePairs = new String[2][2];
		try {
			ArrayList<Employee> employeeListToFilter = nullCheck(employeelist);
			if(!employeeListToFilter.isEmpty()){
			String[] splitConditions = searchString.split("&");
			int iterator = 0;
			for (String element : splitConditions) {
				keyValuePairs[iterator] = element.split(":");
				iterator++;
			}
			String firstDomain = (keyValuePairs[0][0]);
			String firstDomainValue = (keyValuePairs[0][1].substring(1));
			String secondDomain = (keyValuePairs[1][0]);
			String secondDomainValue = (keyValuePairs[1][1].substring(1));
			if (firstDomain.equals("name") && secondDomain.equals("age")) {
				int parsedsecondDomainValue = Integer
						.parseInt(secondDomainValue);
				for (Employee employee : employeelist) {
					if (employee.getName().equals(firstDomainValue)
							&& employee.getAge() == parsedsecondDomainValue) {
						filteredList.add(employee);
					}
				}
			}
			return filteredList;
			}
			else
			{
				throw new IndexOutOfBoundsException();
			}
		} catch (IllegalArgumentException iae) {
			System.err.println(iae
					+ "Please enter arguments correctly in search string");
			throw iae;
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			System.err.println(aiobe
					+ "Please enter Searchstring acc to format");
			throw aiobe;
		}
		catch (IndexOutOfBoundsException ibe) {
			throw ibe;
		}
	}

}
