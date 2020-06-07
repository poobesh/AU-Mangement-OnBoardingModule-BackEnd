package com.accolite.aumanagement.unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.accolite.aumanagement.dao.EmployeeDaoImpl;
import com.accolite.aumanagement.model.Employee;

public class EmployeeDaoTest {
	
	Employee employee;
	EmployeeDaoImpl employeeDao;
	@Before
	public void setUp() {
		DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:jdbc/schema.sql")
				.build();
		employeeDao = new EmployeeDaoImpl();
		employeeDao.setTemplate(new JdbcTemplate(dataSource));
		employee = new Employee();
		employee.setId(1);
		employee.setEmail("p@c.m");
		employee.setVersion(0);
		employee.setFirst_name("Ram");
		employee.setLast_name("Raj");
		employee.setBGC(true);
		employee.setBlood_type("O");
		employee.setC_pincode(123);
		employee.setCurrent_address("Current address");
		employee.setDate_of_joining(new Date(12-05-2020));
		employee.setDemand_id(5);
		employee.setDesignation("SDE");
		employee.setDob(new Date(12-03-1999));
		employee.setExperience(3);
		employee.setGender("Male");
		employee.setP_pincode(456);
		employee.setPan_number("DHJPP5673A");
		employee.setPermanent_address("Permanent Address");
		employee.setPhone_number(987654321);
		employee.setSkill_1("Angular");
		employee.setSkill_2("Pyhton");
		employee.setSkill_3("Java");
		employee.setStatus(true);
		employee.setName("Ram");
		employee.setBank_ac_no(15533456);
		employee.setIfsc_code("PNB123");
		employee.setBranch("DPI");
		
		employeeDao.getTemplate().execute(
				"Insert into employee (id ,email ,version ,first_name ,last_name ,dob ,blood_type ,gender ,date_of_joining ,permanent_address ,permanent_pincode ,"
				+ "pan_number ,skill_1 ,skill_2 ,skill_3 ,status ,experience ,phone_number ,current_address ,current_pincode ,BGC ,designation ,demand_id ,ac_no,"
				+ "ifsc_code,name,branch ) values (1,'p@c.m',0,'Ram','Ragu',"+ null +",'O','male',"+ null +",'permanent address',123,'100PP6748A',"
				+ "'Angular','python','C',true,0,98765489,'Current address',456,true,'SDE',3,123456,'PNB006','Ram','PNB') "

								);
		
	}
	
	@Test
	public void postEmployee() {
		assertTrue(employeeDao.addEmployee(employee));		
	}
	@Test
	public void updateEmployee() {
		assertTrue(employeeDao.updateEmployee(1, employee));
	}
	
	@Test
	public void GetEmployeeById() {
		assertEquals(employeeDao.findEmployeeById(1),employee);
	}
	
	@Test
	public void getEmployees() {
		assertEquals(employeeDao.getAllEmployees().size(),1);
	}
	
	@Test
	public void deleteEmployee() {
        assertTrue(employeeDao.deleteEmployee(1));
		
	}
	@Test
	public void getEmployeeIds() {
		employeeDao.getTemplate().execute("Insert into employee_constant (id , first_name , last_name , email ,dob , blood_type , gender , date_of_joining , permanent_address , pincode , pan_number , version ,status ) values (100,'Ram','Kumar','ram@123.com','1999-03-03','o','Male','2020-03-03','permanent',7890,'DHJIUYR',0,false)");
		assertEquals(employeeDao.getAllEmployeesIds().size(),1);
	
	}
	
	
}
