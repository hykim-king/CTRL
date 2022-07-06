package com.pcwk.ctrl.productSearch;


import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.SearchVO;
import com.pcwk.ctrl.productSearch.dao.ProductSearchDao;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
		
}) // applicationContext.xml loading
public class JunitProductSearchControllerTest {
	final Logger LOG = LogManager.getLogger(this.getClass());
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	// 브라우저 대역(Mock)
	MockMvc mockMvc;
	
	@Autowired
	ProductSearchDao dao;
	ProductVO product01;
	SearchVO search;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("=======================");
		LOG.debug("=0. setUp()=");
		LOG.debug("=======================");
		
		product01 = new ProductVO("glass07", "glass", "뉴웨이브 데일리 글라스", 2700, "270ml");
		search = new SearchVO(10, 1, "", "");
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		LOG.debug("mockMvc:" + mockMvc);
		LOG.debug("webApplicationContext:"+webApplicationContext);
		
		assertNotNull(webApplicationContext);
		assertNotNull(mockMvc);
		}
	
	@Test
	public void doRetrieve() throws Exception {
		
		// 호출url, param, 호출방식(get/post)		
		search.setSearchWord("gl");
				
		
		MockHttpServletRequestBuilder requestBuilder=
				MockMvcRequestBuilders.get("/productSearch/doRetrieve.do")	
				.param("pageSize"   ,String.valueOf(search.getPageSize()))
				.param("pageNum"    ,String.valueOf(search.getPageNum()))
				.param("searchWord" ,search.getSearchWord());
		
		
		ResultActions resultActions = mockMvc.perform(requestBuilder)
				.andExpect(status().is2xxSuccessful());
		
		String result = resultActions.andDo(print())
				            .andReturn().getResponse().getContentAsString();
		
		LOG.debug("====================");
		LOG.debug("=result=" + result);
		LOG.debug("====================");			
		
		Gson gson=new Gson();
		List<ProductVO>  list = gson.fromJson(result,new TypeToken<List<ProductVO>>() {}.getType());
		
		for(ProductVO vo :list) {
			LOG.debug("vo="+vo);
		}		
		
	}

	
}
