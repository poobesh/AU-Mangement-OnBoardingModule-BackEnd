package com.accolite.aumanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.aumanagement.dao.DemandDao;
import com.accolite.aumanagement.dao.DemandDaoImpl;
import com.accolite.aumanagement.model.Demand;
import com.accolite.aumanagement.model.Trends;

@Service
public class DemandServiceImpl implements DemandService{
	
	@Autowired
	DemandDao demandDao;
	
	public DemandServiceImpl(DemandDaoImpl dao) {
		this.demandDao = dao;
	}
	@Override
	public List<Demand> getDemands() {
		return demandDao.getDemands();
	}
	@Override
	public List<Trends> getTrends(String name) {
		return demandDao.getTrends(name);
	}
	@Override
	public List<Trends> getCompanyNames() {
		return demandDao.getCompanyNames();
	}

}
