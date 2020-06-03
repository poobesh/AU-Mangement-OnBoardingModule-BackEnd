package com.accolite.aumanagement.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class DemandRowMapper implements RowMapper<Demand> {

	@Override
	public Demand mapRow(ResultSet rs, int rowNo)  {
		Demand demand = new Demand();
		try {
			demand.setDemand_id(rs.getInt("demand_id"));
			demand.setSkill(rs.getString("skillset"));
			return demand;
		} catch (SQLException e) {
			return null;
		}
	}

}
