package com.accolite.aumanagement.unittests.jwt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;

import com.accolite.aumanagement.controller.JwtAuthenticationController;
import com.accolite.aumanagement.model.JwtRequest;
import com.accolite.aumanagement.service.JwtUserDetailsService;
import com.accolite.aumanagement.websecurity.JwtTokenUtil;

@RunWith(MockitoJUnitRunner.class)
public class JwtControllerTest {

	@Mock
	JwtUserDetailsService service;
	@Mock
	JwtTokenUtil jwtTokenUtil;
	@Mock
	AuthenticationManager authenticationManager;
	
	JwtRequest request;
	
	JwtAuthenticationController controller;
	
	@Before
	public void setUp() {
		controller = new JwtAuthenticationController(authenticationManager,jwtTokenUtil,service);
		request = new JwtRequest();
		request.setUsername("poobesh1999@gmail.com");
	}
	
	@Test
	public void test1CreateAuthenticationToken() throws Exception {
		
		Mockito.when(service.loadUserByUsername(Mockito.anyString()))
		 .thenReturn(new User(request.getUsername()
				 , "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
				new ArrayList<>()));
		
		Mockito.when(jwtTokenUtil.generateToken(new User(request.getUsername()
				, "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
				new ArrayList<>())))
		.thenReturn("this is my token");
		try {
			assertEquals(controller.createAuthenticationToken(request).getStatusCodeValue(),200);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
}
