package com.accolite.aumanagement.unittests.jwt;

import static org.junit.Assert.assertTrue;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.accolite.aumanagement.dao.JwtDao;

@RunWith(MockitoJUnitRunner.class)
public class JwtDaoTest {
	
	
	JwtDao dao;
	
	@Before
	public void setUp() {
		DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:jdbc/schema.sql")
				.build();
		
		dao = new JwtDao(new JdbcTemplate(dataSource));
		dao.getTemplate().execute("INSERT INTO authorized_users VALUES('test@123.com')");
	}
	
	@Test
	public void getAuthorizedUsers() {
		
		assertTrue(dao.getAuthorizedUsers().size()==1);
	}

}
