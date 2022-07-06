package com.pcwk.ctrl.productSearch.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.SearchVO;
import com.pcwk.ctrl.cmn.StringUtil;
import com.pcwk.ctrl.productSearch.Service.ProductSearchService;

@Controller("productSearchController")
@RequestMapping("productSearch")
public class ProductSearchController {

	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	ProductSearchService productSearchService;

	public ProductSearchController() {
	}

	@RequestMapping(value = "/doRetrieve.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRetrieve(SearchVO inVO) throws SQLException {

		String jsonString = "";

		LOG.debug("=================================");
		LOG.debug("doRetrieve()");
		LOG.debug("=inVO=" + inVO);
		LOG.debug("=================================");

		// 페이지 사이즈n
		if (0 == inVO.getPageSize()) {
			inVO.setPageSize(10);
		}

		// 페이지 번호
		if (0 == inVO.getPageNum()) {
			inVO.setPageNum(1);
		}

		// 검색어
		if (null == inVO.getSearchWord()) {
			inVO.setSearchWord(StringUtil.nvl(inVO.getSearchWord(), ""));
		}

		LOG.debug("==============================");
		LOG.debug("=inVO=" + inVO);
		LOG.debug("==============================");

		
		Gson gson = new Gson();List<ProductVO> list = productSearchService.doRetrieve(inVO);

		jsonString = gson.toJson(list);

		LOG.debug("==============================");
		LOG.debug("=jsonString=" + jsonString);
		LOG.debug("==============================");

		return jsonString;

	}
	
	
	@RequestMapping(value="/View.do",method=RequestMethod.GET)
	public String productSearchView(Model model, SearchVO inVO, HttpServletRequest req) throws SQLException {
		LOG.debug("========================");
		LOG.debug("=productSearchView()=");
		LOG.debug("========================");		
		
		//페이지사이즈
		if(0==inVO.getPageSize()) {
			inVO.setPageSize(10);
		}
		
		//페이지 번호
		if(0==inVO.getPageNum()) {
			inVO.setPageNum(1);
		}
		
		//검색구분
		if(null == inVO.getSearchDiv()) {
			inVO.setSearchDiv(StringUtil.nvl(inVO.getSearchDiv(), ""));
		}
		
		//검색어
		if(null == inVO.getSearchWord()) {
			inVO.setSearchWord(StringUtil.nvl(inVO.getSearchWord(),""));
		}
		
		
		String searchWord = req.getParameter("searchWord");
		String pageSize = req.getParameter("pageSize");
		
		LOG.debug("==============================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=searchWord="+searchWord);
		LOG.debug("=pageSize="+pageSize);
		LOG.debug("==============================");		
		
		
		List<ProductVO> list = productSearchService.doRetrieve(inVO);
		
		int totalCnt = 0;//총글수
		double pageTotal = 0;//총페이지(총글수/pageSize ?+1:총글수/pageSize;)
		
		if(null !=list && list.size()>0) {
			
			pageTotal = Math.ceil(totalCnt/(inVO.getPageSize()*1.0));
			LOG.debug("==============================");
			LOG.debug("="+(totalCnt/(inVO.getPageSize()*1.0)));//1.5
			LOG.debug("="+Math.ceil(totalCnt/(inVO.getPageSize()*1.0)));//2.0
			LOG.debug("=pageTotal="+pageTotal);
			LOG.debug("==============================");				
		}
		
		
		//model.addAttribute("totalCnt", totalCnt);
		//model.addAttribute("pageTotal", pageTotal);
		model.addAttribute("list", list);
		model.addAttribute("vo", inVO);
		
		return "productSearch/productSearch";
		
	}
	

}
