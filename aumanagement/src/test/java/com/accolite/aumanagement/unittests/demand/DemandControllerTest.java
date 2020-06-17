package com.accolite.aumanagement.unittests.demand;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.accolite.aumanagement.controller.DemandController;
import com.accolite.aumanagement.exception.CustomException;
import com.accolite.aumanagement.model.Demand;
import com.accolite.aumanagement.model.Trends;
import com.accolite.aumanagement.service.DemandServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DemandControllerTest {
	
	DemandController demandController = null ;
	
	@Mock
	DemandServiceImpl service ;
	
	List<Demand> list ;
	List<Trends> trends;
		
	@Before
	public void setUp() {
	
		demandController = new DemandController(service);
		Demand[] d = new Demand[] {new Demand(1,"Angular"),new Demand(2,"Java")};
		list = Arrays.asList(d);
		trends = Arrays.asList(new Trends());
		trends.get(0).setCompany_name("XYZ");
		
	}
	
	@Test
	public void getAllDemands() {
		
		Mockito.when(service.getDemands()).thenReturn(list);
		assertEquals(demandController.getDemands().size(),2);
	}
	
	@Test(expected = CustomException.class)
	public void getAllDemandsError() {
		Mockito.when(service.getDemands()).thenThrow(new CustomException("Can't find any demands now : "));
		demandController.getDemands();
	}
	
	@Test
	public void getAllTrends() {
		Mockito.when(service.getTrends("XYZ")).thenReturn(trends);
		assertEquals(demandController.getTrends("XYZ").size(),1);
	}
	
	@Test(expected = CustomException.class)
	public void getAllTrendsError() {
		Mockito.when(service.getTrends("XYZABC")).thenThrow(new CustomException("Can't find any trends now : "));
		demandController.getTrends("XYZABC");
	}
	
	@Test
	public void getAllCompaniesNames() {
		Mockito.when(service.getCompanyNames()).thenReturn(trends);
		assertEquals(demandController.getTrends().get(0),"XYZ");
	}
	
	@Test(expected = CustomException.class)
	public void getAllCompaniesNamesError() {
		Mockito.when(service.getCompanyNames()).thenThrow(new CustomException("Can't find any demands or company names now : "));
		demandController.getTrends();
	}

}
