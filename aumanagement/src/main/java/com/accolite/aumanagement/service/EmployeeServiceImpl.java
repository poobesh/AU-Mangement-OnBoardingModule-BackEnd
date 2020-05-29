package com.accolite.aumanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.aumanagement.dao.EmployeeDaoImpl;
import com.accolite.aumanagement.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDaoImpl employeeDao ;
	
	@Override
	public List<Employee> getRequest() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee getRequest(int id) {
		
		 return employeeDao.findEmployeeById(id);
	}

	@Override
	public void postRequest(Employee t) {
		employeeDao.addEmployee(t);
		
	}

	@Override
	public void putRequest(String id, Employee t) {
		employeeDao.updateEmployee(Integer.valueOf(id) , t);
		
	}

	@Override
	public void deleteRequest(String id) {
		employeeDao.deleteEmployee(Integer.valueOf(id));
		
	}

	

	

}
