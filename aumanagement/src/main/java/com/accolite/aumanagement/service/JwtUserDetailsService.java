package com.accolite.aumanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.accolite.aumanagement.dao.JwtDao;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Autowired
	JwtDao jwtDao;
	
	
	
	public JwtUserDetailsService() {
		super();
	}

	public JwtUserDetailsService(JwtDao jwtDao) {
		super();
		this.jwtDao = jwtDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<String> list = jwtDao.getAuthorizedUsers();
		if (list.contains(username)) {
			return new User(username, "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
}

