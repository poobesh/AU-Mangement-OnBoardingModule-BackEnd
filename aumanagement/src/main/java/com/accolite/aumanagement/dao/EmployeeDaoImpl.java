package com.accolite.aumanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.model.Employee;
import com.accolite.aumanagement.model.EmployeeRowMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	
	@Autowired
    JdbcTemplate template;

	@Override
	public List<Employee> getAllEmployees() {
		String query = "SELECT * from employee";
		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		List<Employee> list = template.query(query, rowMapper);
		return list;
	}

	@Override
	public Employee findEmployeeById(int id) {
		try {
			String query = "SELECT * FROM employee WHERE id = ?";
			RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
			Employee employee = template.queryForObject(query, rowMapper, id);
		
			return employee;
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public void addEmployee(Employee employee) {
		String query1 = "INSERT INTO `employee_constant`(`id`, `first_name`, `last_name`, `email`, `dob`, `blood_type`, `gender`, `date_of_joining`, `permanent_address`, `pincode`, `pan_number`, `version`) VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? )";
		template.update(query1, employee.getId(), employee.getFirst_name(), employee.getLast_name(), employee.getEmail(), employee.getDob(), employee.getBlood_type(), employee.getGender() ,employee.getDate_of_joining() , employee.getPermanent_address() , employee.getP_pincode() , employee.getPan_number(), 0 );
		String query2 = "INSERT INTO `employee_editable`(`emailversion`, `skill_id`, `experience`, `phone_number`, `current_address`, `pincode`, `BGC`, `designation`, `bank_ac_no`, `demand_id`) VALUES (? ,? , ? ,? ,? ,? ,? , ? ,? , ? )";
		template.update(query2, employee.getEmail().concat("0"), employee.getSkill_id(), employee.getExperience(), employee.getPhone_number(), employee.getCurrent_address() , employee.getC_pincode(), employee.getBGC(), employee.getDesignation(), employee.getBank_ac_no() , employee.getDemand_id());
		
		System.out.println(employee.toString());
	}

	@Override
	public void updateEmployee(int id , Employee employee) {
		try {
			String query = "SELECT version FROM employee WHERE id = ?";
			int version = template.queryForObject(query, new Object[] {id}, Integer.class);
			version++;
			String query1 = "SELECT email FROM employee WHERE id = ?";
			String email = template.queryForObject(query1, new Object[] {id}, String.class);
			String query2 = "UPDATE `employee_constant` SET `version`= ? WHERE `id` = ?" ;
			template.update(query2, version , id);
			
			String query3 = "INSERT INTO `employee_editable`(`emailversion`, `skill_id`, `experience`, `phone_number`, `current_address`, `pincode`, `BGC`, `designation`, `bank_ac_no`, `demand_id`) VALUES (? ,? ,? , ? ,? ,? ,? ,? , ? ,?  )";
			template.update(query3, email.concat(String.valueOf(version)) , employee.getSkill_id(), employee.getExperience(), employee.getPhone_number(), employee.getCurrent_address() , employee.getC_pincode(), employee.getBGC(), employee.getDesignation(), employee.getBank_ac_no() , employee.getDemand_id());
		}
		catch(Exception e)
		{
			System.out.println("\n Cant Update Value "+e);
		}
		
	}

	@Override
	public void deleteEmployee(int id) {
		try {
			String query = "UPDATE `employee_constant` SET `status`= ? WHERE `id` = ?" ;
			template.update(query, false , id);
		}
		catch(Exception e)
		{
			System.out.println("Cant Delete ");
		}
		
	}

}
