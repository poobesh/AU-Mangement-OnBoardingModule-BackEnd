package com.accolite.aumanagement.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrendRowMapper implements RowMapper<Trends>{

	@Override
	public Trends mapRow(ResultSet rs, int rowNo) throws SQLException {
		Trends trend = new Trends();
		try {
			trend.setCompany_name(rs.getString("company_name"));
			trend.setRequired_employee_count(rs.getInt("count"));
			trend.setYear(rs.getInt("year"));
			return trend;
		} catch (SQLException e) {
			return trend;
		}
	}

}
