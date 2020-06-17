package com.accolite.aumanagement.unittests.logs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.accolite.aumanagement.controller.LogController;
import com.accolite.aumanagement.service.LogServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LogControllerTest {
	
	
	LogController controller;
	
	@Mock
	LogServiceImpl logService;
	
	@Before
	public void setUp() {
	
		controller = new LogController(logService);
		
	}
	
	@Test
	public void test1CreateLogNewFile() {
		controller.generateNewFile();
		assertTrue(controller.isFlag());
	}
	
	@Test
	public void test2SaveLogFile() {
		Mockito.when(logService.addLogFile()).thenReturn(true);
		controller.saveLogFile();
		assertTrue(controller.isFlag());
	}
	
	@Test
	public void test3GetLogDetails() {
		
		String str = "This is a blob file";
		Blob blob;
		try {
			blob = new SerialBlob(str.getBytes());
			Mockito.when(logService.getLog(java.sql.Date.valueOf("2020-06-12"))).thenReturn(blob);
			assertEquals(controller.getLogDetails("2020-06-12").getBody().length,str.getBytes().length);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

}
