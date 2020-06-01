package com.accolite.aumanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuManagementApplication {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(AuManagementApplication.class);
				
		logger.info("AU Management application has started "+" -- User Directory -- "+System.getProperty("user.dir"));
		SpringApplication.run(AuManagementApplication.class, args);
	}

}
