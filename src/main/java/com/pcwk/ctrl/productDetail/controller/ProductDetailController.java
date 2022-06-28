package com.pcwk.ctrl.productDetail.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
	public String doReviewsRetrieve(SearchVO inVO) throws SQLException {
		
		String jsonString = "";
		
		LOG.debug("=================================");
		LOG.debug("doReviewsRetrieve()");
		LOG.debug("=inVO=" + inVO);
		LOG.debug("=================================");
		
       //페이지 사이즈
       if(0 == inVO.getPageSize()) {
          inVO.setPageSize(10);
       }
      
       //페이지 번호
       if(0 == inVO.getPageNum()) {
          inVO.setPageNum(1);
       }
       
       //검색어
       if(null == inVO.getSearchWord()) {
          inVO.setSearchWord(StringUtil.nvl(inVO.getSearchWord(), ""));
       }
		
		List<ReviewRdVO> list = reviewService.doReviewsRetrieve(inVO);
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
	public String productDetailView(Model model, ProductVO pInVO, SearchVO sInVO) throws SQLException {
		
		LOG.debug("==================");
	    LOG.debug("=productDetailView()=");
	    LOG.debug("=pInVO=" + pInVO);
	    LOG.debug("=sInVO=" + sInVO);
	    LOG.debug("==================");
		
	    
        sInVO.setSearchWord(pInVO.getpNum());
        List<ReviewRdVO> list = reviewService.doReviewsRetrieve(sInVO);
        
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
