package com.accolite.aumanagement.unittests;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.accolite.aumanagement.dao.DemandDaoImpl;
import com.accolite.aumanagement.model.Demand;

@RunWith(MockitoJUnitRunner.class)
public class DemandDaoTest {
	
	Demand demand;
	DemandDaoImpl demandDao;
	@Before
	public void setUp() {
		DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:jdbc/schema.sql")
				.build();
		demandDao = new DemandDaoImpl();
		demandDao.setTemplate(new JdbcTemplate(dataSource));
		demand = new Demand(1,"Angular");
	}
	
	@Test
	public void getDemands() {
		demandDao.getTemplate().execute(
				"INSERT INTO demand (demand_id, hiring_manager_id, company_name, location, skillset,"
				+ " joining_date, status, posted_date) VALUES(0, 10, 'XYZ Services', 'Mumbai', 'Java',"
				+ " '2019-11-15', 'open', '2019-10-14')"
				);
		assertEquals(demandDao.getDemands().size(),1);
	}

}
