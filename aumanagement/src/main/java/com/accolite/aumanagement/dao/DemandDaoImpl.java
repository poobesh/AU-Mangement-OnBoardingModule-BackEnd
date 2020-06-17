package com.accolite.aumanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.exception.CustomException;
import com.accolite.aumanagement.model.Demand;

import com.accolite.aumanagement.model.Trends;
import com.accolite.aumanagement.rowmappers.DemandRowMapper;
import com.accolite.aumanagement.rowmappers.TrendRowMapper;


@Repository
public class DemandDaoImpl implements DemandDao {
	
	@Autowired
	JdbcTemplate template;

	// Getters and Setters
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Demand> getDemands() {
		
		String query = "SELECT * FROM demand WHERE status = 'active'";
		RowMapper<Demand> rowMapper = new DemandRowMapper();
		List<Demand> list;
		
		list = template.query(query, rowMapper);
		
		if(list.isEmpty())
		{
			throw new CustomException("No Demands are available ");
		}
		else {
			return list;
		}
		
	}
	
	@Override
	public List<Trends> getTrends(String name) {
		
		String query = "SELECT * FROM trends WHERE company_name = ?";
		RowMapper<Trends> rowMapper = new TrendRowMapper();
		List<Trends> list;
		
		list = template.query(query, rowMapper ,name );
		
		if(list.isEmpty())
		{
			throw new CustomException("No Trends are available ");
		}
		else {
			return list;
		}
		
	}
	@Override
	public List<Trends> getCompanyNames() {
		
		String query = "SELECT * FROM trends GROUP BY company_name";
		List<Trends> list;
		RowMapper<Trends> rowMapper = new TrendRowMapper();
		
		list = template.query(query, rowMapper);
		
		if(list.isEmpty())
		{
			throw new CustomException("No Trends are available ");
		}
		else {
			return list;
		}
	}
	

}
