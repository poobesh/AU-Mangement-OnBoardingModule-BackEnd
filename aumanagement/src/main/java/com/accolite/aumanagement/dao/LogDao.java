package com.accolite.aumanagement.dao;

import java.sql.Blob;
import java.sql.Date;

public interface LogDao {
	
	public boolean addLogFile();

	public Blob getLog(Date date); 

}
