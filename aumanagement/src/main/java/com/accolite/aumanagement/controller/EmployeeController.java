package com.accolite.aumanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.model.Employee;
import com.accolite.aumanagement.service.EmployeeServiceImpl;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl service ;
	
	@RequestMapping(method=RequestMethod.GET,value="/employees", produces="application/json")
	public List<Employee> getEmployees(){
		return service.getRequest();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/employees/{id}", produces="application/json")
	public Employee getEmployee(@PathVariable String id){
		return service.getRequest(Integer.valueOf(id));
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/employees", consumes="application/json")
	public void postEmployee(@RequestBody Employee t){
		 System.out.println(t.toString());
		 service.postRequest(t);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/employees/{id}", consumes="application/json")
	public void putEmployee(@PathVariable String id ,@RequestBody Employee t){
		System.out.println(t.toString());
		 service.putRequest(id,t);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/employees/{id}")
	public void deleteEmployee(@PathVariable String id){
		 service.deleteRequest(id);
	}

}
