package com.accolite.aumanagement.unittests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.accolite.aumanagement.controller.EmployeeController;
import com.accolite.aumanagement.model.Demand;
import com.accolite.aumanagement.service.DemandServiceImpl;

@RunWith(MockitoJUnitRunner.class)

public class DemandControllerTest {
	
	// common controller for both demand and employees
	EmployeeController employeeController = null ;
	
	@Mock
	DemandServiceImpl service ;
	
	List<Demand> list ;
	
	@Before
	public void setUp() {
		employeeController = new EmployeeController(service);
		Demand[] d = new Demand[] {new Demand(1,"Angular"),new Demand(2,"Java")};
		list = Arrays.asList(d);
	}
	
	@Test
	public void getAllDemands() {
		Mockito.when(service.getDemands()).thenReturn(list);
		assertEquals(employeeController.getDemands().size(),2);
	}

}
