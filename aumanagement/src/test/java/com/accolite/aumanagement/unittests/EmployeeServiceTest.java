package com.accolite.aumanagement.unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import com.accolite.aumanagement.dao.EmployeeDaoImpl;
import com.accolite.aumanagement.exception.CustomException;
import com.accolite.aumanagement.service.EmployeeServiceImpl;
import com.accolite.aumanagement.model.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@Mock
	EmployeeDaoImpl employeeDao;
	
	@Rule public MockitoRule rule = MockitoJUnit.rule();

	EmployeeServiceImpl employeeService = null;
	
	
	// new Employee 
	Employee employee;
	List<Employee> list;
	
	
	
	@Before
	public void setUp() {
		employeeService = new EmployeeServiceImpl(employeeDao);
		employee = new Employee(1,"Ram","ram@123.com","DHJPP$786A");
		Employee[] a = new Employee[] {employee};
		list = Arrays.asList(a);
	}
	
	
	
	@Test
	public void getListOfEmployees() {
		when(employeeDao.getAllEmployees()).thenReturn(list);
		assertEquals(list,employeeService.getRequest());
		verify(employeeDao).getAllEmployees();
	}
	@Test
	public void getListOfEmployeesIds() {
		when(employeeDao.getAllEmployeesIds()).thenReturn(Arrays.asList(1,2));
		assertEquals(Arrays.asList(1,2),employeeService.getRequestForIds());
		
	}
	@Test
	public void getEmployeeForGivenId() {
		Mockito.when(employeeDao.findEmployeeById(Mockito.anyInt())).thenReturn(employee);
		assertEquals(employee,employeeService.getRequestWithId(1));
	}
	
	@Test
	public void postEmployee() {
		//assertThrows();
		Mockito.when(employeeDao.addEmployee(new Employee(1,"Raman"))).thenReturn(true);
		assertTrue(employeeService.postRequest(new Employee(1,"Raman")));
		
	}
	@Test(expected = CustomException.class)
	public void postEmployeeError() {
		Mockito.when(employeeDao.addEmployee(new Employee())).thenThrow(new CustomException("Cant Add the given employee "));
		employeeService.postRequest(new Employee());
		
	}
	
	//new CustomException("Can't update the employee")
	//
	
	@Test
	public void updateEmployee() {
		
		Mockito.when(employeeDao.updateEmployee(1, new Employee(1,"Ram"))).thenReturn(true);
		assertTrue(employeeService.putRequest(1,new Employee(1,"Ram")));
	}
	
	@Test(expected = CustomException.class)
	public void updateEmployeeError() {
		
		Mockito.when(employeeDao.updateEmployee(1, new Employee(1,"Ram"))).thenThrow(new CustomException("Can't update the employee"));
		employeeService.putRequest(1,new Employee(1,"Ram"));
	}
	
	@Test
	public void deleteEmployee() {
		Mockito.when(employeeDao.deleteEmployee(Mockito.anyInt())).thenReturn(true);
		assertTrue(employeeService.deleteRequest(1));
	}
	@Test(expected = CustomException.class)
	public void deleteEmployeeError() {
		Mockito.when(employeeDao.deleteEmployee(Mockito.anyInt())).thenThrow(new CustomException("Can't Delete Employee "));
		assertTrue(employeeService.deleteRequest(1));
	}
}
