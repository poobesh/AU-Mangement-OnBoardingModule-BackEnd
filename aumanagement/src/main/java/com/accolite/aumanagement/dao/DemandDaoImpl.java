package com.accolite.aumanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.exception.CustomException;
import com.accolite.aumanagement.model.Demand;
import com.accolite.aumanagement.model.DemandRowMapper;

@Repository
public class DemandDaoImpl implements DemandDao {
	
	@Autowired
	JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Demand> getDemands() {
		String query = "SELECT * from demand";
		RowMapper<Demand> rowMapper = new DemandRowMapper();
		List<Demand> list;
		
		list = template.query(query, rowMapper);
		
		if(list.isEmpty())
		{
			throw new CustomException("No Demands are available ");
		}
		else
		return list;
		
	}
	

}
