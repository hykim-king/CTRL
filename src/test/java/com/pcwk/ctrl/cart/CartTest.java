package com.pcwk.ctrl.cart;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ctrl.cart.dao.CartDao;
import com.pcwk.ctrl.cmn.ProductVO;


@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class CartTest {
	final Logger LOG = LogManager.getLogger(this.getClass());
	
	@Autowired // 컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입
	ApplicationContext context;
	
	@Autowired
	CartDao cartDao;
	ProductVO cart01;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("=======================");
		LOG.debug("=0. setUp()=");
		LOG.debug("=======================");
		
		cart01 = new ProductVO("glass07", "glass", "뉴웨이브 데일리 글라스", 2700, "270ml");
		
		
		LOG.debug("context:"+context);
		LOG.debug("cartDao:"+cartDao);
		
		assertNotNull(context);
		assertNotNull(cartDao);
	}


	@Test
	public void doSelectone() throws SQLException {
		List<ProductVO> list = cartDao.doCartSelect(cart01);
		for(ProductVO vo : list) {
			LOG.debug("vo="+vo);
		}
	}

}