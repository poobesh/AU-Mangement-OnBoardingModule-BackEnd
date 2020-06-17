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
	public Employee getRequestWithId(int id) {
		
		 return employeeDao.findEmployeeById(id);
	}

	@Override
	public boolean postRequest(Employee t) {
		return employeeDao.addEmployee(t);
		
	}
	
	@Override
	public boolean putRequest(int id, Employee t) {
		return employeeDao.updateEmployee(id , t);
		
	}

	@Override
	public boolean deleteRequest(int id) {
		return employeeDao.deleteEmployee(id);
		
	}

	@Autowired
	public EmployeeServiceImpl(EmployeeDaoImpl employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Integer> getRequestForIds() {
		return employeeDao.getAllEmployeesIds();
	}

}
