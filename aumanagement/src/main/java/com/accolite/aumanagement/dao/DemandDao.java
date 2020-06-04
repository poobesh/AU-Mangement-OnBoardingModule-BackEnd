package com.accolite.aumanagement.dao;

import java.util.List;

import com.accolite.aumanagement.model.Demand;
import com.accolite.aumanagement.model.Trends;

public interface DemandDao {
	
	public List<Demand> getDemands();
	
	public List<Trends> getTrends(String name);
	
	public List<Trends> getCompanyNames();

}
