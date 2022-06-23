package com.pcwk.ctrl.review.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ctrl.cmn.MessageVO;
import com.pcwk.ctrl.cmn.ReviewVO;
import com.pcwk.ctrl.review.service.ReviewService;

@Controller
@RequestMapping("review")
public class ReviewController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ReviewService reviewService;
	
	public ReviewController() {}
	
	
	@RequestMapping(value = "/reviewPopup.do", method = RequestMethod.GET
			, produces = "application/text;charset=UTF-8")
	public String reviewPopup() {
		LOG.debug("=================================");
		LOG.debug("reviewPopup()");
		LOG.debug("=================================");
		
		return "review/review_write_popup";
	}
	
	@RequestMapping(value = "/doReviewInsert.do", method = RequestMethod.GET
			, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doReviewInsert(ReviewVO inVO) throws SQLException {
		String jsonString = "";
		LOG.debug("=================================");
		LOG.debug("inVO : " + inVO);
		LOG.debug("=================================");
		
		String resultMessage = "";
		int flag = reviewService.doReviewInsert(inVO);
		
        if(1 == flag) {
        	resultMessage = "리뷰가 등록되었습니다!";
        }else {
        	resultMessage = "다시 시도해주세요.^^";
        }
	      
		MessageVO message = new MessageVO(String.valueOf(flag), resultMessage);
		jsonString = new Gson().toJson(message);
		LOG.debug("=================================");
		LOG.debug("jsonString : " + jsonString);
		LOG.debug("=================================");
		return jsonString;

	}
}
