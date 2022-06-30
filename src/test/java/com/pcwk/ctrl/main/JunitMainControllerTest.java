package com.pcwk.ctrl.main;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) //JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		
}) //applicationContext.xml loading
public class JunitMainControllerTest {

	final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	WebApplicationContext webApplicationContext;
	
	//브라우저 대역(Mock)
	MockMvc mockMvc;
		
	
	
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("====================");
		LOG.debug("=0.setUp()=");
		LOG.debug("====================");
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//		LOG.debug("dao : "+ dao);
		LOG.debug("mockMvc : "+ mockMvc);
		LOG.debug("webApplicationContext : "+ webApplicationContext);
		
		assertNotNull(webApplicationContext);
		assertNotNull(mockMvc);
//		assertNotNull(dao);

	
	}

	@Test
	public void test() {

	}

}
