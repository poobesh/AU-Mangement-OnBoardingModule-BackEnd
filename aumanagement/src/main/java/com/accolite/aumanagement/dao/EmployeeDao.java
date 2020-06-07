package com.accolite.aumanagement.dao;

import java.util.List;

import com.accolite.aumanagement.model.Employee;

public interface EmployeeDao {
	
	 public List<Employee> getAllEmployees();
	 
	 public List<Integer> getAllEmployeesIds();
	 
	 public Employee findEmployeeById(int id);
	 
	 public boolean addEmployee(Employee employee);
	 
	 public boolean updateEmployee(int id ,Employee employee);
	 
	 public boolean deleteEmployee(int id);

}
