package com.accolite.aumanagement.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.accolite.aumanagement.AuManagementApplication;
import com.accolite.aumanagement.exception.CustomException;

@Repository
public class LogDaoImpl implements LogDao{

	final Logger logger = LoggerFactory.getLogger(AuManagementApplication.class);
	
	@Autowired
	JdbcTemplate template;
	
	
	
	public LogDaoImpl() {
		super();
	}

	public LogDaoImpl(JdbcTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public boolean addLogFile() {
		
		String date = getYesterdayDate();
		
		String query = "INSERT INTO log_files(date,file) VALUES (?,?) ";
		
		File file;
		
			
		try {
			//File Name : mylog.log.2020.06.12.0.gz
			
			file = new ClassPathResource("logs/mylog.log."+date+".0.gz").getFile();
			FileInputStream input = new FileInputStream(file);
		    

			// Prepared Statement to Store Blob Data
			template.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(query.toString(),Statement.RETURN_GENERATED_KEYS);
					ps.setDate(1, Date.valueOf(date));
					ps.setBlob(2, input);
					
					return ps;
				}
			});
			
			
			logger.info("Log File with name "+ file.getName() +"is updated in the database");
			return true;
			
		} catch (FileNotFoundException e) {
			
			logger.error("Log File Not Found For Back UP FNF");
			return false;
		}catch (IOException e) {
			logger.error("Log File Not Found For Back UP I/o Exception");
			return false;
		}catch (Exception e) {
			logger.error("SQL Exception Error occured");
			return false;
		}
			
	}

	private String getYesterdayDate() {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(cal.getTime());
		
	}

	@Override
	public Blob getLog(Date date) {
		try {
			
			String query = "SELECT file FROM log_files WHERE date = ?";
			Blob file = template.queryForObject(query, new Object[] {date}, Blob.class);
			System.out.println(" LOG FILE : "+ file.length());
			return file;
		}
		catch(Exception e) {
			throw new CustomException("No Log's are present "+e.getMessage());
		}
	}


}
