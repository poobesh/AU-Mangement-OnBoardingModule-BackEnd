package com.accolite.aumanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.exception.CustomException;

@Repository
public class JwtDao {
	
	@Autowired
	JdbcTemplate template;
		
	public JwtDao() {
		super();
	}
	public JwtDao(JdbcTemplate template) {
		super();
		this.template = template;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<String> getAuthorizedUsers() {
			
			
			List<String> list;
			
			String query = "SELECT email FROM authorized_users ";
			
			list = template.queryForList(query, null,String.class);
			
			if(list.isEmpty())
			{
				throw new CustomException("No employees are present ");
			}
			else 
			{
				return list;
			}
		
	}

}