package com.accolite.aumanagement.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNo)  {
		Employee employee = new Employee();
		try {
			employee.setId(rs.getInt("id"));
		
			employee.setFirst_name(rs.getString("first_name"));
			employee.setLast_name(rs.getString("last_name"));
			employee.setEmail(rs.getString("email"));
			employee.setDob(rs.getDate("dob"));
			employee.setBlood_type(rs.getString("blood_type"));
			employee.setGender(rs.getString("gender"));
			employee.setDate_of_joining(rs.getDate("date_of_joining"));
			employee.setPermanent_address(rs.getString("permanent_address"));
			employee.setP_pincode(rs.getInt("permanent_pincode"));
			employee.setPan_number(rs.getString("pan_number"));
			employee.setVersion(rs.getInt("version"));
			employee.setSkill_id(rs.getInt("skill_id"));
			employee.setExperience(rs.getInt("experience"));
			employee.setPhone_number(rs.getLong("phone_number"));
			employee.setCurrent_address(rs.getString("current_address"));
			employee.setC_pincode(rs.getInt("current_pincode"));
			employee.setBGC(rs.getBoolean("BGC"));
			employee.setDesignation(rs.getString("designation"));
			employee.setBank_ac_no(rs.getLong("bank_ac_no"));
			employee.setDemand_id(rs.getString("demand_id"));
			
			return employee;
		} catch (SQLException e) {
			return null;
		}
	}

}
