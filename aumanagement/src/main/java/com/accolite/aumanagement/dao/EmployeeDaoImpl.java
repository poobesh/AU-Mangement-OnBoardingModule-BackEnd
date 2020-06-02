package com.accolite.aumanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.model.Employee;
import com.accolite.aumanagement.model.EmployeeRowMapper;
import java.util.NoSuchElementException;
import com.accolite.aumanagement.exception.*;

/**
 * @author Sathish-PC
 *
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	
	@Autowired
    JdbcTemplate template;

	@Override
	public List<Employee> getAllEmployees() {
		String query = "SELECT * from employee";
		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		List<Employee> list;
		
		list = template.query(query, rowMapper);
		
		if(list.isEmpty())
		{
			throw new CustomException("No employees are present ");
		}
		else
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
		catch(NoSuchElementException e) {
			throw new CustomException("No Employee of given id is Present");
		}
	}

	@Override
	public void addEmployee(Employee employee) {
		
		try {
		String query1 = "INSERT INTO `employee_constant`(`id`, `first_name`, `last_name`, `email`, `dob`, `blood_type`, `gender`, `date_of_joining`, `permanent_address`, `pincode`, `pan_number`, `version`) VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? )";
		template.update(query1, employee.getId(), employee.getFirst_name(), employee.getLast_name(), employee.getEmail(), employee.getDob(), employee.getBlood_type(), employee.getGender() ,employee.getDate_of_joining() , employee.getPermanent_address() , employee.getP_pincode() , employee.getPan_number(), 0 );
		
		//update Employee Editable tables
		String query2 = "INSERT INTO `employee_editable`(`emailversion`, `experience`, `phone_number`, `current_address`, `pincode`, `BGC`, `designation`, `bank_ac_no`, `demand_id`) VALUES (? ,? , ? ,? ,? ,? ,? , ? ,? )";
		template.update(query2, employee.getEmail().concat("0"), employee.getExperience(), employee.getPhone_number(), employee.getCurrent_address() , employee.getC_pincode(), employee.getBGC(), employee.getDesignation(), employee.getBank_ac_no() , employee.getDemand_id());
													// Initially version is 0
		//update bank details
		String query3 = "INSERT INTO `bank_details`(`ac_no`, `ifsc_code`, `name`, `branch`) VALUES (? ,? ,? ,?)";
		template.update(query3, employee.getBank_ac_no(),employee.getIfsc_code(),employee.getName(),employee.getBranch());
		
		//update Skill Details
		String query4 = "INSERT INTO `skill`(`pan_number`, `skill_1`, `skill_2`, `skill_3`) VALUES (? , ? ,? , ? )";
		template.update(query4, employee.getPan_number(),employee.getSkill_1(),employee.getSkill_2(),employee.getSkill_3());
		
		
		}
		catch(Exception e)
		{
			throw new CustomException("Cant Add the given employee ");
		}
	}

	/* (non-Javadoc)
	 * @see com.accolite.aumanagement.dao.EmployeeDao#updateEmployee(int, com.accolite.aumanagement.model.Employee)
	 * 
	 * For update :
	 * 1) Get the current version of the employee
	 * 2) Increment the version + 1
	 * 3) Get Email Address of the employee
	 * 4) update version in employee_constant table
	 * 5) Insert new obtained data into the employee editable table with key as ( "Email + version ")
	 * 6) Update skills in skill table
	 * 7) 
	 * 
	 */
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
			
			String query3 = "INSERT INTO `employee_editable`(`emailversion`, `experience`, `phone_number`, `current_address`, `pincode`, `BGC`, `designation`, `bank_ac_no`, `demand_id`) VALUES (? ,? ,? , ? ,? ,? ,? ,? , ?  )";
			template.update(query3, email.concat(String.valueOf(version)), employee.getExperience(), employee.getPhone_number(), employee.getCurrent_address() , employee.getC_pincode(), employee.getBGC(), employee.getDesignation(), employee.getBank_ac_no() , employee.getDemand_id());
			
			String query4 = "UPDATE `skill` SET `skill_1`= ? , `skill_2`=? , `skill_3`=?  WHERE `pan_number` = ?";
			template.update(query4, employee.getSkill_1(), employee.getSkill_2(), employee.getSkill_3(),employee.getPan_number());
			
			
		}
		catch(Exception e)
		{
			throw new CustomException("Can't update the employee");
		}
		
	}

	
	/* (non-Javadoc)
	 * @see com.accolite.aumanagement.dao.EmployeeDao#deleteEmployee(int)
	 * 
	 * Deleting only the Employee Primary Details .
	 * Secondary Details are still available after deleting
	 */
	@Override
	public void deleteEmployee(int id) {
		try {
			String query = "DELETE FROM `employee_constant` WHERE id = ?" ;
			template.update(query, id);
		}
		catch(Exception e)
		{
			throw new CustomException("Can't Delete Employee ");
		}
		
	}

}
