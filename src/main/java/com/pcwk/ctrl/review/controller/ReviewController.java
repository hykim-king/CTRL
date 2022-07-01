
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.MessageVO;
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.RdVO;
import com.pcwk.ctrl.cmn.ReviewVO;
import com.pcwk.ctrl.productDetail.service.ProductDetailService;
import com.pcwk.ctrl.review.service.ReviewService;

@Controller("reviewController")
@RequestMapping("review")
public class ReviewController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ProductDetailService productDetailService;
	
	public ReviewController() {}
	
	@RequestMapping(value = "/rdPopup.do", method = RequestMethod.GET, produces = "application/text;charset=UTF-8")
	public String rdPopup(MemberVO memberVO, RdVO rdVO, HttpServletResponse response, Model model) throws SQLException, IOException {
		
		String jsonString = "";
		
		LOG.debug("=================================");
		LOG.debug("rdPopup()");
		LOG.debug("=================================");
		
		int flag = reviewService.doSelectGrade(memberVO);
		
		// VIEW 전송
		// response encoding
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(1 == flag) { // memberVO가 관리자이면
		    out.println("<script>window.open('${CP}/review/reviewPopup.do?oNum='+oNum+'&dNum='+dNum+'&oName='+oName"
		    		+ "+'&pNum='+pNum,'리뷰작성', 'width=800, height=700, left=100, top=100');</script>");			
		} else { // memberVO가 관리자가 아니면
			out.println("<script>alert('접근할 수 없습니다.'); </script>");			
		}
		return jsonString;
	}
	
	@RequestMapping(value = "/reviewPopup.do", method = RequestMethod.GET, produces = "application/text;charset=UTF-8")
	public String reviewPopup(HttpServletRequest req, Model model) {
		LOG.debug("=================================");
		LOG.debug("reviewPopup()");
		LOG.debug("=================================");

		String dNum = req.getParameter("dNum");
		String oNum = req.getParameter("oNum");
		String oName = req.getParameter("oName");
		String pNum = req.getParameter("pNum");

		model.addAttribute("dNum", dNum);
		model.addAttribute("oNum", oNum);
		model.addAttribute("oName", oName);
		model.addAttribute("pNum", pNum);
		
		return "review/review_write_popup";
	}

	@RequestMapping(value = "/doReviewInsert.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doReviewInsert(ProductVO selectParam, ReviewVO inVO) throws SQLException {
		ProductVO pVo = null; // return 값

		LOG.debug("=================================");
		LOG.debug("inVO : " + inVO);
		LOG.debug("selectParam : " + selectParam);
		LOG.debug("=================================");

		int flag = reviewService.doReviewInsert(inVO);

		if (1 == flag) {
			pVo = productDetailService.doProductDetailSelect(selectParam);
		}

		String jsonString = new Gson().toJson(pVo);
		LOG.debug("================================="); 
		LOG.debug("jsonString : " + jsonString); 
		LOG.debug("=================================");
		 
		return jsonString;

	}
}
