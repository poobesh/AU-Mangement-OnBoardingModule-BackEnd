package com.accolite.aumanagement.unittests.logs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.accolite.aumanagement.dao.LogDaoImpl;
import com.accolite.aumanagement.service.LogServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LogServiceTest {
	
	LogServiceImpl service;
	
	@Mock
	LogDaoImpl dao;
	
	@Before
	public void setUp() {
		service = new LogServiceImpl(dao);
	}
	
	@Test
	public void test1AddLogFile() {
		Mockito.when(dao.addLogFile()).thenReturn(true);
		assertTrue(service.addLogFile());
	}
	
	@Test
	public void test2GetLogFile() throws SerialException, SQLException {
		
		String str = "This is Blob";
		Blob blob = new SerialBlob(str.getBytes());
		Mockito.when(dao.getLog(java.sql.Date.valueOf("2020-06-12"))).thenReturn(blob);
		// service return blob
		assertEquals(service.getLog(java.sql.Date.valueOf("2020-06-12")).length(),blob.length());
	}

}
