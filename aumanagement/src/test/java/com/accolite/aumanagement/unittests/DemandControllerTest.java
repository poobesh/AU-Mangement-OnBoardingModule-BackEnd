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
import com.accolite.aumanagement.model.Trends;
import com.accolite.aumanagement.service.DemandServiceImpl;

@RunWith(MockitoJUnitRunner.class)

public class DemandControllerTest {
	
	// common controller for both demand and employees
	EmployeeController employeeController = null ;
	
	@Mock
	DemandServiceImpl service ;
	
	List<Demand> list ;
	List<Trends> trends;
	
	
	@Before
	public void setUp() {
		employeeController = new EmployeeController(service);
		Demand[] d = new Demand[] {new Demand(1,"Angular"),new Demand(2,"Java")};
		list = Arrays.asList(d);
		trends = Arrays.asList(new Trends());
		trends.get(0).setCompany_name("XYZ");
		
	}
	
	@Test
	public void getAllDemands() {
		Mockito.when(service.getDemands()).thenReturn(list);
		assertEquals(employeeController.getDemands().size(),2);
	}
	@Test
	public void getAllTrends() {
		Mockito.when(service.getTrends("XYZ")).thenReturn(trends);
		assertEquals(employeeController.getTrends("XYZ").size(),1);
	}
	@Test
	public void getAllCompaniesNames() {
		Mockito.when(service.getCompanyNames()).thenReturn(trends);
		assertEquals(employeeController.getTrends().get(0),"XYZ");
	}

}
