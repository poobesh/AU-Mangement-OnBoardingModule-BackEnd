package com.accolite.aumanagement.dao;

import java.util.List;

import com.accolite.aumanagement.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployees();
	 
	 public Employee findEmployeeById(int id);
	 
	 public void addEmployee(Employee employee);
	 
	 public void updateEmployee(int id ,Employee employee);
	 
	 public void deleteEmployee(int id);

}
