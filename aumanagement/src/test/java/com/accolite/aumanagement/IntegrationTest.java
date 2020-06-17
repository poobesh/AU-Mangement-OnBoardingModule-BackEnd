package com.accolite.aumanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.junit4.SpringRunner;

import com.accolite.aumanagement.controller.LogController;
import com.accolite.aumanagement.exception.CustomException;
import com.accolite.aumanagement.model.Demand;
import com.accolite.aumanagement.model.Employee;
import com.accolite.aumanagement.model.Trends;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
	
	@LocalServerPort
	private int port;
	
	Employee employee;	
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers;
	
	@Before
	public void setUp() {
		headers = new HttpHeaders();
		//JwtRequest request = new JwtRequest();
		//request.setUsername("poobesh1999@gmail.com");
		//HttpEntity<JwtRequest> entity = new HttpEntity<JwtRequest>(request, headers);
		    	
		//ResponseEntity<JwtResponse> response = restTemplate.exchange(createURLWithPort("/authenticate"),HttpMethod.GET, entity, JwtResponse.class);
		
		headers.add("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwb29iZXNoMTk5OUBnbWFpbC5jb20iLCJleHAiOjE1OTIzNDQ1OTAsImlhdCI6MTU5MjMyNjU5MH0.NeAvE-_OBMxlCuh9K2NcSzzbyeexxnO6Ddvc6Uh-JPvAxradCFv95By7_tATh1IIJmnSWj1gTwHkDEYiKp71DQ");
		headers.add("Content-Type","application/json");
		
		employee = new Employee();
		employee.setId(100);
		employee.setEmail("test@test.com");
		employee.setVersion(0);
		employee.setFirst_name("Ram Test");
		employee.setLast_name("Raj Test");
		employee.setBGC(true);
		employee.setBlood_type("O");
		employee.setC_pincode(123);
		employee.setCurrent_address("Test address");
		employee.setDate_of_joining(new Date(12-05-2020));
		employee.setDemand_id(5);
		employee.setDesignation("SDE");
		employee.setDob(new Date(12-03-1999));
		employee.setExperience(3);
		employee.setGender("Male");
		employee.setP_pincode(456);
		employee.setPan_number("TEST+TEST.");
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
		
	}

    @Test
    public void test1AllEmployees() 
    {
    	HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<Employee[]> response = restTemplate.exchange(
				createURLWithPort("/employees"),
				HttpMethod.GET, entity, Employee[].class);
 
		assertEquals( response.getStatusCodeValue(),200); 	
    }
    
    @Test
    public void test2AllEmployeesIds() 
    {
    	HttpEntity<String> entity = new HttpEntity<String>(null, headers);
    	
		ResponseEntity<Integer[]> response = restTemplate.exchange(
				createURLWithPort("/employees/ids"),
				HttpMethod.GET, entity, Integer[].class);
 
		assertEquals(response.getStatusCodeValue(), 200);
    }
    
    @Test
    public void test3PostEmployeeById() {
      	
    	HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

		ResponseEntity<Employee> response = restTemplate.exchange(
				createURLWithPort("/employees"),
				HttpMethod.POST, entity, Employee.class);
		
		response = restTemplate.exchange(
				createURLWithPort("/employees/100"),
				HttpMethod.GET, new HttpEntity<String>(null,headers), Employee.class);

		assertEquals( response.getBody().getId(),100);
    	
    }
    @Test
    public void test4PutEmployeeById() {
      	
    	employee.setC_pincode(600025);
    	HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

		ResponseEntity<Employee> response = restTemplate.exchange(
				createURLWithPort("/employees/100"),
				HttpMethod.PUT, entity, Employee.class);
		response = restTemplate.exchange(
				createURLWithPort("/employees/100"),
				HttpMethod.GET, new HttpEntity<String>(null,headers), Employee.class);
		
// on Update version changes to 1 
		assertEquals( response.getBody().getVersion(),1);
    	
    }
    
    @Test
    public void test5GetEmployeeById() {
    	
    	HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<Employee> response = restTemplate.exchange(
				createURLWithPort("/employees/100"),
				HttpMethod.GET, entity, Employee.class);

		assertEquals( response.getBody().getId(),100);
    	
    }
    
    @Test
	public void getAllEmployeeByIdError() {
    
    	HttpEntity<String> entity = new HttpEntity<String>(null, headers);
    	
    	try {
			ResponseEntity<Employee> response = restTemplate.exchange(
					createURLWithPort("/employees/101"),
					HttpMethod.GET, entity, Employee.class);
			response.getBody();
    	}
    	catch(CustomException e)
    	{
    		assertTrue(true);
    	}
		
	}
    
   
    @Test
    public void test6DeleteEmployeeById() {
      	
    	HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

		ResponseEntity<Employee> response = restTemplate.exchange(
				createURLWithPort("/employees/100"),
				HttpMethod.DELETE, entity, Employee.class);
		
	 	
		response = restTemplate.exchange(
				createURLWithPort("/employees/100"),
				HttpMethod.GET, new HttpEntity<String>(null,headers), Employee.class);
		
		// On Delete Employee Status is set as False ...
		assertEquals( response.getBody().isStatus(),false);
    }
    
    @Test
    public void test7AllDemands() 
    {
    	HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<Demand[]> response = restTemplate.exchange(
				createURLWithPort("/demands"),
				HttpMethod.GET, entity, Demand[].class);
		
// 8 demands 3 active 
		assertEquals( response.getBody().length,3); 	
    }
    
    @Test
    public void test8Trends() 
    {
    	HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String[]> response = restTemplate.exchange(
				createURLWithPort("/trends"),
				HttpMethod.GET, entity, String[].class);
		
// total available companies 2 (ABC , XYZ)
		assertEquals( response.getBody().length,2); 	
    }
    
    @Test
    public void test9TrendsByName() 
    {
    	HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<Trends[]> response = restTemplate.exchange(
				createURLWithPort("/trends/XYZ"),
				HttpMethod.GET, entity, Trends[].class);
		
 // totally 3 trends are available for XYZ company
		assertEquals( response.getBody().length,3); 	
    }
    
	// For Log Files 
    @Test
    public void test10SaveandRetrieveLogFile() {
    	LogController controller = new LogController();
    	controller.generateNewFile();
    	//controller.saveLogFile();
    	
    	HttpEntity<String> entity = new HttpEntity<String>(null,headers);
    	ResponseEntity<byte[]> response = restTemplate.exchange(
    			createURLWithPort("/logs/2020-06-12"),
    			HttpMethod.GET,entity,byte[].class
    			);
    	assertEquals(response.getStatusCodeValue(),200);
		
    }
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
