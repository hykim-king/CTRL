package com.pcwk.ctrl.order.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.OrderListVO;
import com.pcwk.ctrl.cmn.OrderVO;
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.ReviewRdVO;
import com.pcwk.ctrl.cmn.SearchVO;
import com.pcwk.ctrl.cmn.StringUtil;
import com.pcwk.ctrl.order.service.OrderService;

@Controller
@RequestMapping("order")
public class OrderController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	OrderService orderService;
	
	public OrderController() {}
	
	// null
	@RequestMapping(value = "/orderList.do", method = RequestMethod.GET
			, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRetrieve(SearchVO inVO, HttpServletRequest req) throws SQLException {
		
		String jsonString ="";
		
		LOG.debug("=================================");
		LOG.debug("doRetrieve");
		LOG.debug("=inVO=" + inVO);
		LOG.debug("=================================");
		
		   //페이지 사이즈
	       if(0 == inVO.getPageSize()) {
	    	   inVO.setPageSize(5);
	       }
	      
	       //페이지 번호
	       if(0 == inVO.getPageNum()) {
	    	   inVO.setPageNum(1);
	       }
	      
	       //검색구분
	       if(null == inVO.getSearchDiv()) {
	          inVO.setSearchDiv(StringUtil.nvl(inVO.getSearchDiv(), ""));
	       }
	       
	       //검색어
	       if(null == inVO.getSearchWord()) {
	    	   inVO.setSearchWord(StringUtil.nvl(inVO.getSearchWord(), ""));
	       }
	       
	       	
	       
			List<OrderListVO> list = orderService.doRetrieve(inVO);
			Gson gson = new Gson();
		      
		    jsonString = gson.toJson(list);
			
		    LOG.debug("=================================");
		    LOG.debug("=jsonString= "+ jsonString);
		    LOG.debug("=================================");
		    
		    return jsonString;
		
	}
	
	@RequestMapping(value="/orderView.do", method = RequestMethod.GET)
	public String orderView(Model model, SearchVO inVO, HttpServletRequest req) throws SQLException {
		
		
		LOG.debug("==================");
	    LOG.debug("=orderView=");
	    LOG.debug("==================");
		
	     //페이지 사이즈
	      if(0 == inVO.getPageSize()) {
	         inVO.setPageSize(5);
	      }
	      
	      //페이지 번호
	      if(0 == inVO.getPageNum()) {
	         inVO.setPageNum(1);
	      }
	      
	      //검색구분
	      if(null == inVO.getSearchDiv()) {
	         inVO.setSearchDiv(StringUtil.nvl(inVO.getSearchDiv(), ""));
	      }
	      
	        // 세션 받아오기
	   		HttpSession session = req.getSession();
	   	    Object member = session.getAttribute("member");
	   		MemberVO memberVO = (MemberVO)member;
	   		
	   		if(session.getAttribute("member") != null) {
	   			LOG.debug("***mNum"+memberVO.getmNum());
		    	   inVO.setSearchWord(memberVO.getmNum()); // memberVO의 mNum을 SearchWord로 보내기

	   		}else {
	   			System.out.println("session:null");
	   		}
	   		// 세션 받아오기 끝
	      
	      LOG.debug("==============================");
	      LOG.debug("***inVO "+ inVO);
	      LOG.debug("==============================");     
	      
	      List<OrderListVO> list = orderService.doRetrieve(inVO);
        
        int totalCnt = 0;//총글수
        double pageTotal = 0;//총 페이지(총글수/pageSize ? +1: 총글수/pageSize;)
        
        if(null != list && list.size() > 0) {
        	totalCnt = orderService.getCount(list.get(0));//총글수
        	
        	pageTotal = Math.ceil(totalCnt/(inVO.getPageSize() * 1.0));
            LOG.debug("==============================");
            LOG.debug("=list.get(0)="+list.get(0));
            LOG.debug("=totalCnt="+totalCnt);
            LOG.debug(": "+ (totalCnt/(inVO.getPageSize() * 1.0))); 
            LOG.debug(": "+ Math.ceil(totalCnt/(inVO.getPageSize() * 1.0))); 
            LOG.debug("pageTotal : "+pageTotal); 
            LOG.debug("==============================");   
        }
        
        model.addAttribute("totalCnt", totalCnt);
        model.addAttribute("pageTotal", pageTotal);
        model.addAttribute("list", list);
        model.addAttribute("vo", inVO);
		
		
	    
	    return "order/order_list";
	}
	
}
