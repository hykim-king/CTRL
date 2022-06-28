package com.pcwk.ctrl.notice;

import static org.junit.Assert.*;

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

import com.pcwk.ctrl.cmn.NoticeVO;
import com.pcwk.ctrl.notice.dao.NoticeDao;

@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class NoticeTest {
	final Logger LOG = LogManager.getLogger(this.getClass());
	
	@Autowired // 컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입
	ApplicationContext context;
	
	@Autowired
	NoticeDao noticeDao;
	NoticeVO notice01;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("=======================");
		LOG.debug("=0. setUp()=");
		LOG.debug("=======================");
		
		notice01 = new NoticeVO(5, "2022년 설연휴 배송안내"
				, "- 택배 배송안내 -1월 26일 (수) 오후 3시 이전 주문 건 : 일반지역 설 연휴 전 발송1월 26일 (수) 오후 3시 ~ 2월 3일 (목) 오후 3시 주문 건 : 2월 3일 (목) 발송"
				,"관리자","22/01/21");
		
		
		LOG.debug("context:"+context);
		LOG.debug("noticeDao:"+noticeDao);
		
		assertNotNull(context);
		assertNotNull(noticeDao);
	}

	@Test
	public void test() {
		// 1. 1건 조회
//	NoticeVO outVO = noticeDao.doNoticeSelect(notice01);
		List<NoticeVO> list = noticeDao.doNoticeSelect();
		// 2. 비교
//		LOG.debug("================");
//		LOG.debug("================");
//		LOG.debug("================");
//		LOG.debug("=list=" + list);
		
		
		for(NoticeVO vo : list) {
			LOG.debug("===============");
			LOG.debug("===============");
			LOG.debug("===============");
			LOG.debug("=vo=" + vo);
			LOG.debug("===============");
			LOG.debug("===============");
			LOG.debug("===============");
		}
		
	}
	
	private void isSameData(NoticeVO voVO, NoticeVO orgVO) {
	      assertEquals(voVO.getnNum(), orgVO.getnNum());
	      assertEquals(voVO.getnTitle(), orgVO.getnTitle());
	      assertEquals(voVO.getnContent(), orgVO.getnContent());
	      assertEquals(voVO.getnName(), orgVO.getnName());
	      assertEquals(voVO.getnRegdt(), orgVO.getnRegdt());
 }


}