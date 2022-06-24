package com.pcwk.ctrl.review;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ctrl.cmn.ReviewVO;
import com.pcwk.ctrl.review.dao.ReviewDao;

@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
		
}) // applicationContext.xml loading
public class JunitReviewDaoTest {
	final Logger LOG = LogManager.getLogger(this.getClass());
	
	@Autowired // 컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입
	ApplicationContext context;
	
	@Autowired
	ReviewDao reviewDao;
	ReviewVO review01;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("=======================");
		LOG.debug("=0. setUp()=");
		LOG.debug("=======================");
		
		review01 = new ReviewVO(201, "1", 1, "안녕하세요, junitReviewrDaoTest입니다.", "kjh", "날짜_사용안함");
		
		LOG.debug("context:"+context);
		LOG.debug("reviewDao:"+reviewDao);
		
		assertNotNull(context);
	}
	
	@Test
	public void doReviewInsert() throws SQLException {
		// 1건 추가
		reviewDao.doReviewInsert(review01);
		assertEquals(1, reviewDao.getCount(review01));
		
		reviewDao.doSelectOne(review01);
	}

	
	@After
	public void tearDown() throws Exception {
		LOG.debug("=======================");
		LOG.debug("=9. tearDown()=");
		LOG.debug("=======================");
		
	}
	
}
