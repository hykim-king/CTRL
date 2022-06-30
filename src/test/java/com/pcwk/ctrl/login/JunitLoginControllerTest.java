package com.pcwk.ctrl.login;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.MessageVO;
import com.pcwk.ctrl.member.dao.MemberDao;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) //JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		
}) //applicationContext.xml loading
public class JunitLoginControllerTest {

	final Logger LOG = LogManager.getLogger(this.getClass());
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	//브라우저 대역(Mock)
	MockMvc mockMvc;
	
	@Autowired
	MemberDao dao;
	MemberVO member01;
	MemberVO member02;
	MemberVO member03;
	
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("=================");
		LOG.debug("=0.setUp()=");
		LOG.debug("=================");

		member01 = new MemberVO("11111", "테스트", "test@naver.com", "010-1234-5678", "서울특별시 마포구", "2");
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		LOG.debug("webApplicationContext : "+ webApplicationContext);
		LOG.debug("mockMvc : "+ mockMvc);
	  
		assertNotNull(webApplicationContext);
		assertNotNull(mockMvc);
		
	}

	@Test
//	@Ignore
	public void doMemberInsert() throws Exception{
		//호출url, param, 호출방식(get/post)
		  //GET방식으로 : http://localhost:8081/ehr/login/doMemberInsert.do?mNum=
		  MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/login/doMemberInsert.do")
				  .param("mNum",member01.getmNum())		  
				  .param("mName",member01.getmName())		  
				  .param("mEmail",member01.getmEmail())		  
				  .param("mTel",member01.getmTel())		  
				  .param("mAddr",member01.getmAddr())		  
				  .param("mGrade",member01.getmGrade())		  
				  ;
		  //대역 객체 통해 호출
		  ResultActions resultActions = mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
		  String result = resultActions.andDo(print()).andReturn().getResponse().getContentAsString();
		  
		  LOG.debug("====================");
		  LOG.debug("result : "+ result);
		  LOG.debug("====================");	
		  
		  //jsonString to VO
		  Gson gson = new Gson();
		  MessageVO messageVO = gson.fromJson(result, MessageVO.class);
		  LOG.debug("====================");
		  LOG.debug("messageVO : "+ messageVO);
		  LOG.debug("====================");	
	}


}
