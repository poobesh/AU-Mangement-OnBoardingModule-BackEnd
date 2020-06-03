package com.accolite.aumanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.AuManagementApplication;
import com.accolite.aumanagement.exception.CustomException;
import com.accolite.aumanagement.model.Demand;
import com.accolite.aumanagement.model.Employee;
import com.accolite.aumanagement.service.DemandServiceImpl;
import com.accolite.aumanagement.service.EmployeeServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl service ;
	
	@Autowired
	DemandServiceImpl dService;
	
	final Logger logger = LoggerFactory.getLogger(AuManagementApplication.class);
	
	

	public EmployeeController() {
		super();
	}
	public EmployeeController(EmployeeServiceImpl employeeService) {
		this.service = employeeService;
	}
	public EmployeeController(DemandServiceImpl service) {
		this.dService = service;
	}


	@RequestMapping(method=RequestMethod.GET,value="/employees", produces="application/json")
	public List<Employee> getEmployees(){
		List<Employee> employees;
		
		try {
			logger.info("Request to display employees is received ");
			employees= service.getRequest();							// get request 
			logger.info("Request to display employees is processed successfully");
		}
		catch(Exception e) {
			logger.error("Request to display employees has been failed ");
			throw new CustomException("Can't find any employees : ");
		}
		return employees;
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/employees/{id}", produces="application/json")
	public Employee getEmployee(@PathVariable String id){
		
		Employee employee  ;
		try {
			logger.info("Request to display Employee with id "+id+" has been received ");
			employee = service.getRequestWithId(Integer.valueOf(id));									// Get Request by Id 
			logger.info("Request to display Employee with id "+id+" has been succesfully processed ");
		}
		catch (Exception e)
		{
			logger.error("Request to display Employee with id "+id+" has been failed ");
			throw new CustomException("Employee of  id = : "+id+ " is not present " );
		}
		return employee;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/employees", consumes="application/json")
	public String postEmployee(@RequestBody Employee t){
		 //System.out.println(t.toString());
		 try {
			 logger.info("Request to add Employee with id "+t.getId()+" has been received ");
			 service.postRequest(t);														// Post Request with Employee Details
			 logger.info("Request to add Employee with id "+t.getId()+" has been succesfully completed ");
			 return "Successfully Posted"+t.getId();
		 }
		 catch(Exception e)
		 {
			 logger.error("Request to add Employee with id "+t.getId()+" has been failed ");
			 throw e;
		 }
		 
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/employees/{id}", consumes="application/json")
	public String putEmployee(@PathVariable String id ,@RequestBody Employee t){
		System.out.println(t.toString());
		try {
			logger.info("Request to update Employee with id "+t.getId()+" has been received ");
			service.putRequest(Integer.valueOf(id),t);														// Put Request with id ,Employee Details
			logger.info("Request to update Employee with id "+t.getId()+" has been processed succesfully ");
			return "Succesfully Updated"+id;
		}
		catch(Exception e)
		 {
			logger.error("Request to display Employee with id "+id+" has been failed ");
			 throw e;
		 }
		 
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/employees/{id}")
	public String deleteEmployee(@PathVariable String id){
		 try{
			 logger.info("Request to delete Employee with id "+id+" has been received ");
			 service.deleteRequest(Integer.valueOf(id));													// Delete Request with id
			 logger.info("Request to delete Employee with id "+id+" has been completed successfully ");
			 return "Successfully Deleted id = "+id;
		 }
		 catch(Exception e)
		 {
			 logger.error("Request to delete Employee with id "+id+" has been failed ");
			 throw e;
		 }
	}
	
	// Request Mappings for Demands :
	@RequestMapping(method=RequestMethod.GET,value="/demands" )
	public List<Demand> getDemands(){
		List<Demand> employees;
		
		try {
			logger.info("Request to get Demands is received ");
			employees= dService.getDemands();							// get request 
			logger.info("Request to get Demands is processed successfully");
		}
		catch(Exception e) {
			logger.error("Request to get Demands has been failed ");
			throw new CustomException("Can't find any demands now : ");
		}
		return employees;
	}

}
