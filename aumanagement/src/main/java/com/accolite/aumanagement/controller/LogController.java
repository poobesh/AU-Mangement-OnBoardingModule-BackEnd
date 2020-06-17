package com.accolite.aumanagement.controller;


import java.sql.Blob;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accolite.aumanagement.AuManagementApplication;
import com.accolite.aumanagement.exception.CustomException;
import com.accolite.aumanagement.service.LogServiceImpl;

@CrossOrigin(origins = "*")
@Controller
public class LogController {
	
	final Logger logger = LoggerFactory.getLogger(AuManagementApplication.class);
	
	@Autowired
	LogServiceImpl logService;
	
	// For testing 
	boolean flag=false;
	
	public LogController() {
		super();
	}

	public LogController(LogServiceImpl service) {
		this.logService = service;
	}

	@Scheduled(cron="0 5 0 * * ?")
	public void generateNewFile() {
		logger.info("New File Created "+ new Date());
		//For Testing
		flag = true;
	}
	
	@Scheduled(cron="0 0 1 * * ?")
	public void saveLogFile() {
		logger.info("Back up started @Time "+ new Date());
		flag = logService.addLogFile();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/logs/{date}", produces="application/json" )
	public ResponseEntity<byte[]> getLogDetails(@PathVariable String date) {
		
		
		try {
			logger.info("Request to get log for date "+date+"is received ");
			
			Blob file = logService.getLog(java.sql.Date.valueOf(date));							// get request 
			byte[] bArray = StreamUtils.copyToByteArray(file.getBinaryStream());
			logger.info("Request to get log for date "+date+" is processed successfully");
			return ResponseEntity.ok(bArray);
		}
		catch(Exception e) {
			logger.error("\"Request to get log for date "+date+"is failed ");
			throw new CustomException("Can't get log for the given date : ");
		}
	}

	public boolean isFlag() {
		return flag;
	}
	
	

}
