package com.accolite.aumanagement.service;

import java.util.List;

import com.accolite.aumanagement.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getRequest() ;

	public Employee getRequest(int id) ;

	public void postRequest(Employee t) ;

	public void putRequest(String id, Employee t) ;

	public void deleteRequest(String id) ;

}
