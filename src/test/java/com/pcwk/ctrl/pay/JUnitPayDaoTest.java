package com.pcwk.ctrl.pay;

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

import com.pcwk.ctrl.cmn.CartVO;
import com.pcwk.ctrl.cmn.DetailVO;
import com.pcwk.ctrl.cmn.OrderVO;
import com.pcwk.ctrl.pay.dao.PayDao;


@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
		
}) // applicationContext.xml loading
public class JUnitPayDaoTest {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired // 컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입
	ApplicationContext context;
	
	@Autowired
	PayDao payDao;
	
	OrderVO  orderVO;
	DetailVO detailVO;
	CartVO cartVO;

	@Before
	public void setUp() throws Exception {
		LOG.debug("========================");
		LOG.debug("=0.setUp()=");
		LOG.debug("========================");
		
		orderVO = new OrderVO(2222,"서울특별시 마포구 서강로 136 아이비타워 2,3층", 
				"김병완","010-1234-5678","10","날짜사용않함","4444");
		detailVO = new DetailVO(2222,"222","1","cup01");
		
		LOG.debug("context:"+context);
		LOG.debug("payDao:"+payDao);
	}
	
	@Test
	public void cartSelect() throws SQLException{
		LOG.debug("========================");
		LOG.debug("=1.cartSelect()=");
		LOG.debug("========================");
		
		CartVO cart = new CartVO("b0eS7C0xv40MLAhDU5uIEQ7WJAbQNOm3v-KEtXp7Tzs",15558,
				"cup01","cup02",1,1000,1000);
		
		
		List<CartVO> cart1 = payDao.cartSelect(cart);
		
		assertEquals(2, cart1.size());
		
	}
	
	@Test
	@Ignore
	public void getoNumTest() throws SQLException{
		OrderVO inVO = new OrderVO();
		inVO.setmNum("b0eS7C0xv40MLAhDU5uIEQ7WJAbQNOm3v-KEtXp7Tzs");
		inVO = payDao.getoNum(inVO);
		LOG.debug("========================");
		LOG.debug("=getoNumTest=");
		LOG.debug("========================");
		assertEquals(11, inVO.getoNum());
	}
	

	@Test
	@Ignore
	public void payOrderInsert() throws SQLException {
		LOG.debug("========================");
		LOG.debug("=1.payOrderInsert()=");
		LOG.debug("========================");
		
		int flag = payDao.payOrderInsert(orderVO);
		
		//1건 등록
		//payDao.payOrderInsert(orderVO);
		
		assertEquals(1, flag);
		
	}
	
	@Test
	@Ignore
	public void payDetailInsert() throws SQLException {
		LOG.debug("========================");
		LOG.debug("=2.payOrderInsert()=");
		LOG.debug("========================");
		
		int flag = payDao.payDetailInsert(detailVO);
		
		//1건 등록
		//payDao.payDetailInsert(detailVO);
		
		assertEquals(1, flag);
	}

}
