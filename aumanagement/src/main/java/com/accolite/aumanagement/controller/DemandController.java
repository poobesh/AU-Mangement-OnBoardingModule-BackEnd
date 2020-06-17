package com.accolite.aumanagement.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.AuManagementApplication;
import com.accolite.aumanagement.exception.CustomException;
import com.accolite.aumanagement.model.Demand;
import com.accolite.aumanagement.model.Trends;
import com.accolite.aumanagement.service.DemandServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class DemandController {
	
	@Autowired
	DemandServiceImpl dService;  // For Trends and Demand Related Functions
	
	final Logger logger = LoggerFactory.getLogger(AuManagementApplication.class);
	
	
	
	public DemandController() {
		super();
	}

	public DemandController(DemandServiceImpl dService) {
		super();
		this.dService = dService;
	}

	// Request Mappings for Demands :
	@RequestMapping(method=RequestMethod.GET,value="/demands" )
	public List<Demand> getDemands() {
		
		List<Demand> demand;
		
		try {
			logger.info("Request to get Demands is received ");
			demand= dService.getDemands();							// get request 
			logger.info("Request to get Demands is processed successfully");
		}
		catch(Exception e) {
			logger.error("Request to get Demands has been failed ");
			throw new CustomException("Can't find any demands now : ");
		}
		return demand;
	}
	
	//Trends Mappings
	@RequestMapping(method=RequestMethod.GET,value="/trends/{name}" )
	public List<Trends> getTrends(@PathVariable String name) {
		
		List<Trends> trends;
		
		try {
			logger.info("Request to get Trends for company "+name+" is received ");
			trends= dService.getTrends(name);							// get request 
			logger.info("Request to get Trends company "+name+" is processed successfully");
		}
		catch(Exception e) {
			logger.error("Request to get Trends for company "+name+" has been failed ");
			throw new CustomException("Can't find any trends now : ");
		}
		return trends;
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/trends" )
	public List<String> getTrends() {
		
		List<String> names;
		
		try {
			logger.info("Request to get Company Names is received ");
			names= dService.getCompanyNames()
						   .stream()
						   .map(p -> new String(p.getCompany_name()))
						   .collect(Collectors.toList());							// get request 
			logger.info("Request to get Company names is processed successfully");
		}
		catch(Exception e) {
			logger.error("Request to get Company names has been failed ");
			throw new CustomException("Can't find any demands or company names now : ");
		}
		return names;
	}

}
