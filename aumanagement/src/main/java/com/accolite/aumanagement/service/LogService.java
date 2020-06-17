package com.accolite.aumanagement.service;

import java.sql.Blob;
import java.sql.Date;

public interface LogService {
	
	public boolean addLogFile();
	
	 public Blob getLog(Date date);

}
