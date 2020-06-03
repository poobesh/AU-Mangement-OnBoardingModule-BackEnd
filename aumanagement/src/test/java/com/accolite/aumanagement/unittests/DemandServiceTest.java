package com.accolite.aumanagement.unittests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import com.accolite.aumanagement.dao.DemandDaoImpl;
import com.accolite.aumanagement.model.Demand;
import com.accolite.aumanagement.service.DemandServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class DemandServiceTest {
	
	@Mock
	DemandDaoImpl demandDao;
	
	@Rule public MockitoRule rule = MockitoJUnit.rule();

	DemandServiceImpl demandService = null;
	
	List<Demand> list;
	
	
	
	@Before
	public void setUp() {
		demandService = new DemandServiceImpl(demandDao);
		list = Arrays.asList(new Demand(1,"Java"));
	}
	
	
	
	@Test
	public void getListOfDemands() {
		when(demandDao.getDemands()).thenReturn(list);
		assertEquals(list,demandService.getDemands());
		
	}

}
