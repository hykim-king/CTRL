package com.pcwk.ctrl.cart;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ctrl.cart.dao.CartDao;
import com.pcwk.ctrl.cmn.CartVO;

@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
		
}) // applicationContext.xml loading
public class JUnitCartTest {

	final Logger LOG = LogManager.getLogger(this.getClass());
	
	
	@Autowired // 컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입
	ApplicationContext context;
	
	@Autowired
	CartDao cartDao;
	CartVO cart01;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("=======================");
		LOG.debug("=0. setUp()=");
		LOG.debug("=======================");
		
		cart01 = new CartVO("abc", 1, "d", "e", 3, 1000, 2000);
		
		LOG.debug("context:"+context);
		LOG.debug("cart01:"+cart01);
		
		assertNotNull(context);
		assertNotNull(cart01);
	}

	@Test
	public void doSelectList() throws SQLException {
		List<CartVO> list = cartDao.doSelectList(cart01);
		assertEquals(1, list.size());
	}
	
	@Test
	@Ignore
	public void doInsertTest() throws SQLException {
		int flag = cartDao.doInsert(cart01);
		LOG.debug("=====================");
		LOG.debug("=flag=");
		LOG.debug("=====================");
		assertEquals(1, flag);
	}
}