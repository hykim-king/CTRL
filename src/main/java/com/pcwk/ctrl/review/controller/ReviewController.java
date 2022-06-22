package com.pcwk.ctrl.review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ctrl.review.domain.ReviewVO;
import com.pcwk.ctrl.review.service.ReviewService;

@Controller
@RequestMapping("review")
public class ReviewController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ReviewService reviewService;
	
	public ReviewController() {}
	
	
	@RequestMapping(value = "/reviewPopup.do", method = RequestMethod.GET
			, produces = "application/json;charset=UTF-8")
	public String reviewPopup() {
		LOG.debug("=================================");
		LOG.debug("reviewPopup()");
		LOG.debug("=================================");
		
		return "review/review_write_popup";
	}
	
	@RequestMapping(value = "/reviewInsert.do", method = RequestMethod.GET
			, produces = "application/json;charset=UTF-8")
	public void reviewInsert(HttpServletRequest req, HttpServletResponse res, ReviewVO inVO) throws SQLException, IOException {
		LOG.debug("=================================");
		LOG.debug("reviewInsert()");
		LOG.debug("=================================");
		
		inVO.setdNum(req.getParameter("d_num"));
		inVO.setoNum(Long.parseLong(req.getParameter("o_num")));
		inVO.setoName(req.getParameter("o_name"));
		inVO.setrContent(req.getParameter("contents"));
		
		int flag = reviewService.doReviewInsert(inVO);
		
        res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
 		if(1 == flag) {
			out.println("<script>alert('상품 리뷰가 등록되었습니다.'); opener.location.href='/ctrl/detail/detail.do'; window.close();</script>");			
		}else {
			out.println("<script>alert('다시 시도해주세요');</script>");			
		}
	}

}
