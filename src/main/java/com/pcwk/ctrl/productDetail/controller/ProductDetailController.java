package com.pcwk.ctrl.productDetail.controller;

import java.io.IOException;
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
import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.ReviewRdVO;
import com.pcwk.ctrl.cmn.SearchVO;
import com.pcwk.ctrl.cmn.StringUtil;
import com.pcwk.ctrl.productDetail.service.ProductDetailService;
import com.pcwk.ctrl.review.service.ReviewService;

@Controller("productDetailController")
@RequestMapping("productDetail")
public class ProductDetailController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ProductDetailService detailService;
	
	@Autowired
	ReviewService reviewService;
	
	public ProductDetailController() {}

	@RequestMapping(value = "/doReviewsRetrieve.do", method = RequestMethod.GET
			, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doReviewsRetrieve(SearchVO sInVO, HttpServletRequest req) throws SQLException {
		
		String jsonString = ""; // 리뷰, 관리자 댓글 테이블 조회

		LOG.debug("=================================");
		LOG.debug("doReviewsRetrieve()");
		LOG.debug("=sInVO=" + sInVO);
		LOG.debug("=================================");
		
       //페이지 사이즈
       if(0 == sInVO.getPageSize()) {
    	   sInVO.setPageSize(10);
       }
      
       //페이지 번호
       if(0 == sInVO.getPageNum()) {
    	   sInVO.setPageNum(1);
       }
       
       //검색어
       if(null == sInVO.getSearchWord()) {
    	   sInVO.setSearchWord(StringUtil.nvl(sInVO.getSearchWord(), ""));
       }
       
       	Map<String, Object> mapParam = new HashMap<String, Object>(); // doReviewsRetrieve param
       	mapParam.put("pageSize", sInVO.getPageSize()); 
       	mapParam.put("pageNum", sInVO.getPageNum()); 
       	mapParam.put("pNum", sInVO.getSearchWord());
       	
       	HttpSession session = req.getSession();
       	Object member = session.getAttribute("member");
       	MemberVO memberVO = (MemberVO)member;
       	
        if(session.getAttribute("member") != null){
        	LOG.debug("***mNum: "+memberVO.getmNum());
        	mapParam.put("mNum", memberVO.getmNum());  // value : session.getAttribute("")
        }else {
            System.out.println("session:null");
             
         }
		List<ReviewRdVO> list = reviewService.doReviewsRetrieve(mapParam);
		for(ReviewRdVO vo :list) {
			LOG.debug("vo : " + vo);
		}
		
	    Gson gson = new Gson();
	      
	    jsonString = gson.toJson(list);
		
	    LOG.debug("=================================");
	    LOG.debug("=jsonString= "+ jsonString);
	    LOG.debug("=================================");
	    
	    return jsonString;
		
	}
	
	@RequestMapping(value = "/doSelect.do", method = RequestMethod.GET
			, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doProductDetailSelect(ProductVO inVO) throws IOException, SQLException {
		String jsonString = "";
		LOG.debug("=================================");
		LOG.debug("productDetail()");
		LOG.debug("=================================");
		
		ProductVO outVO = detailService.doProductDetailSelect(inVO);
	    LOG.debug("outVO : " + outVO);	
		
		jsonString = new Gson().toJson(outVO);
		LOG.debug("=================================");
		LOG.debug("jsonString : " + jsonString);
		LOG.debug("=================================");

		return jsonString;
	}
	
	@RequestMapping(value="/view.do", method = RequestMethod.GET)
	public String productDetailView(ProductVO pInVO, SearchVO sInVO, Model model, HttpServletRequest req) throws SQLException {
		
		LOG.debug("==================");
	    LOG.debug("=productDetailView()=");
	    LOG.debug("=pInVO=" + pInVO);
	    LOG.debug("=sInVO=" + sInVO);
	    LOG.debug("==================");
        
       	Map<String, Object> mapParam = new HashMap<String, Object>(); // doReviewsRetrieve param
       	mapParam.put("pageSize", sInVO.getPageSize()); 
       	mapParam.put("pageNum", sInVO.getPageNum()); 
       	mapParam.put("pNum", pInVO.getpNum());
       	
       	HttpSession session = req.getSession();
       	Object member = session.getAttribute("member");
       	MemberVO memberVO = (MemberVO)member;
       	
        if(session.getAttribute("member") != null){
        	LOG.debug("***mNum: "+memberVO.getmNum());
        	mapParam.put("mNum", memberVO.getmNum());  // value : session.getAttribute("")
        }else {
            System.out.println("session:null");
             
         }
       	
        List<ReviewRdVO> list = reviewService.doReviewsRetrieve(mapParam);
        
		LOG.debug("==================");
	    LOG.debug("=list=" + list);
	    LOG.debug("==================");
        
        int totalCnt = 0;//총글수
        double pageTotal = 0;//총 페이지
        
        if(null != list && list.size() > 0) {
        	totalCnt = reviewService.getCountAll(pInVO); // 총글수
        	
        	pageTotal = Math.ceil(totalCnt/(sInVO.getPageSize() * 1.0));
            LOG.debug("==============================");
            LOG.debug(": "+ (totalCnt/(sInVO.getPageSize() * 1.0))); //1.2
            LOG.debug(": "+ Math.ceil(totalCnt/(sInVO.getPageSize() * 1.0))); //2.0
            LOG.debug("pageTotal : "+pageTotal); 
            LOG.debug("==============================");   
        }
        
	    model.addAttribute("productInfo", pInVO);
	    model.addAttribute("totalCnt", totalCnt);
	    model.addAttribute("pageTotal", pageTotal);
	    
		return "productDetail/productDetail";
	}
	
}
