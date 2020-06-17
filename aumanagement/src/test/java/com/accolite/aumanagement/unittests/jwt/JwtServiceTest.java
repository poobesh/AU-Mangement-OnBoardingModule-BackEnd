package com.accolite.aumanagement.unittests.jwt;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.User;

import com.accolite.aumanagement.dao.JwtDao;
import com.accolite.aumanagement.service.JwtUserDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class JwtServiceTest {
	
	@Mock
	JwtDao dao;
	
	JwtUserDetailsService service;
	
	List<String> list;
	
	@Before
	public void setUp() {
		service = new JwtUserDetailsService(dao);
		list = new ArrayList<String>();
		list.add("test@123.com");
	}
	
	@Test
	public void test1LoadUserByName() {
		Mockito.when(dao.getAuthorizedUsers()).thenReturn(list);
		assertTrue(
				service.loadUserByUsername("test@123.com")
				.equals(new User("test@123.com"
						, "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6"
						, new ArrayList<>()))
				);
	}

}
