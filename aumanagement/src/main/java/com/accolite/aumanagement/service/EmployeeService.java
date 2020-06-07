package com.accolite.aumanagement.service;

import java.util.List;
import com.accolite.aumanagement.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getRequest() ;

	public List<Integer> getRequestForIds() ;
	
	public Employee getRequestWithId(int id) ;

	public boolean postRequest(Employee t) ;

	public boolean putRequest(int id, Employee t) ;

	public boolean deleteRequest(int id) ;
   
	

}
