package com.accolite.aumanagement.unittests;



import static org.junit.Assert.assertEquals;

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

import com.accolite.aumanagement.controller.EmployeeController;
import com.accolite.aumanagement.exception.CustomException;
import com.accolite.aumanagement.model.Employee;
import com.accolite.aumanagement.service.EmployeeServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
	
	
	EmployeeController employeeController = null ;
	
	@Mock
	EmployeeServiceImpl employeeService;
	
	@Rule public MockitoRule rule = MockitoJUnit.rule();
	
	 
	List<Employee> list ;
	
	@Before
	public void setUp() {
		employeeController = new EmployeeController(employeeService);
		Employee[] e = new Employee[] {new Employee(1,"Ram"),new Employee(2,"Ragu")};
		list = Arrays.asList(e);
	}
	
	@Test
	public void getAllEmployees() {
		Mockito.when(employeeService.getRequest()).thenReturn(list);
		assertEquals(employeeController.getEmployees().size(),2);
	}
	
	@Test
	public void getEmployeeById() {
		Mockito.when(employeeService.getRequestWithId(Mockito.anyInt())).thenReturn(new Employee());
		assertEquals(employeeController.getEmployee("1"),new Employee());
	}
	
	@Test
	public void postEmployee() {
		Employee temp = new Employee(1,"Ram");
		Mockito.when(employeeService.postRequest(temp)).thenReturn(true);
		assertEquals(employeeController.postEmployee(temp),"Successfully Posted"+temp.getId());
	}
	@Test(expected = CustomException.class)
	public void postEmployeeError() {
		Mockito.when(employeeService.postRequest(new Employee())).thenThrow(new CustomException("Cant Add the given employee "));
		employeeController.postEmployee(new Employee());
	}
	
	@Test
	public void updateEmployee() {
		Employee temp = new Employee(1,"Raman");
		Mockito.when(employeeService.putRequest(temp.getId(), temp)).thenReturn(true);
		assertEquals(employeeController.putEmployee("1",temp),"Succesfully Updated"+temp.getId());
	}
	@Test(expected = CustomException.class)
	public void updateEmployeeError() {
		Mockito.when(employeeService.putRequest(1, new Employee(1,"Ram"))).thenThrow(new CustomException("Can't update the employee"));
		employeeController.putEmployee("1", new Employee(1,"Ram"));
	}
	
	@Test
	public void deleteEmployee() {
		Mockito.when(employeeService.deleteRequest(Mockito.anyInt())).thenReturn(true);
		assertEquals(employeeController.deleteEmployee("1"),"Successfully Deleted id = 1");
	}

}