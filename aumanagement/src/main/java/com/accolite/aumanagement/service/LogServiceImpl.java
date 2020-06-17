package com.accolite.aumanagement.service;

import java.sql.Blob;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.aumanagement.dao.LogDaoImpl;

@Service
public class LogServiceImpl implements LogService{

	@Autowired
	LogDaoImpl logDao;
	
	
	public LogServiceImpl() {
		super();
	}

	public LogServiceImpl(LogDaoImpl dao) {
		this.logDao = dao;
	}

	@Override
	public boolean addLogFile() {
		return logDao.addLogFile();
	}

	@Override
	public Blob getLog(Date date) {
		
		return logDao.getLog(date);
	}

}
