
package com.pcwk.ctrl.review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	
	@RequestMapping(value = "/reviewDelete.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String reviewDelete(ReviewVO rInVO, RdVO rdInVO) throws SQLException, IOException {
		String jsonString = "";
		
		LOG.debug("=================================");
		LOG.debug("=reviewDelete()=");
		LOG.debug("=rInVO=" + rInVO);
		LOG.debug("=================================");
		
		rdInVO.setrNum(rInVO.getrNum());
		
		int flag = reviewService.reviewDelete(rInVO, rdInVO);
		LOG.debug("=flag="+flag);
		String resultMsg = "";
		
		if (1 == flag) {
			resultMsg = "리뷰가 삭제되었습니다!";
		}else {
			resultMsg = "다시 시도해주세요";
		}
		MessageVO message = new MessageVO(String.valueOf(flag), resultMsg);
		
		jsonString = new Gson().toJson(message);
		
		LOG.debug("=================================");
		LOG.debug("=jsonString="+jsonString);
		LOG.debug("=================================");
		
		return jsonString;
		
	}
	
	@RequestMapping(value = "/rdDelete.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String rdDelete(MemberVO mInVO, RdVO rInVO, HttpServletRequest req) throws SQLException, IOException {
		String jsonString = "";
		
		LOG.debug("=================================");
		LOG.debug("=rdDelete()=");
		LOG.debug("=rInVO=" + rInVO);
		LOG.debug("=================================");
		
		// 세션으로 회원 번호 받기
       	HttpSession session = req.getSession();
       	Object member = session.getAttribute("member");
       	MemberVO memberVO = (MemberVO)member;
       	
        if(session.getAttribute("member") != null){
        	LOG.debug("***mNum: "+memberVO.getmNum());
        	mInVO.setmNum(memberVO.getmNum());  // value : session.getAttribute("")
        }
		
		int flag = reviewService.rdDelete(mInVO, rInVO);
		LOG.debug("=flag="+flag);
		String resultMsg = "";
		
		if (1 == flag) {
			resultMsg = "관리자 댓글이 삭제되었습니다!";
		}else {
			resultMsg = "다시 시도해주세요";
		}
		MessageVO message = new MessageVO(String.valueOf(flag), resultMsg);
		
		jsonString = new Gson().toJson(message);
		
		LOG.debug("=================================");
		LOG.debug("=jsonString="+jsonString);
		LOG.debug("=================================");
		
		return jsonString;
		
	}
	
	@RequestMapping(value = "/reviewUpdatePopup.do", method = RequestMethod.GET, produces = "application/text;charset=UTF-8")
	public String reviewUpdatePopup(HttpServletRequest req, MemberVO memberParam, Model model) throws SQLException, IOException {
		LOG.debug("=================================");
		LOG.debug("reviewUpdatePopup()");
		LOG.debug("=================================");
		
		// jsp에 보내기 위한 값 추출
		String rNum = req.getParameter("rNum"); // 댓글 번호
		String oName = req.getParameter("oName"); // 주문한 회원 이름
		
		model.addAttribute("rNum", rNum); // 댓글번호
		model.addAttribute("oName", oName); // 주문한 회원 이름
		
		return "review/review_update_popup";
		
	}
	
	@RequestMapping(value = "/doReviewUpdate.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doReviewUpdate(ReviewVO inVO) throws SQLException {
		LOG.debug("=================================");
		LOG.debug("inVO : " + inVO);
		LOG.debug("=================================");
		
		int flag = reviewService.reviewUpdate(inVO);
				
		String resultMsg = "";
		if (1 == flag) {
			resultMsg = "댓글이 수정되었습니다!";
		}else {
			resultMsg = "다시 시도해주세요";
		}
		MessageVO message = new MessageVO(String.valueOf(flag), resultMsg);
		
		String jsonString = new Gson().toJson(message);
		LOG.debug("================================="); 
		LOG.debug("jsonString : " + jsonString); 
		LOG.debug("=================================");
		
		return jsonString;
		
	}
	
	@RequestMapping(value = "/rdUpdatePopup.do", method = RequestMethod.GET, produces = "application/text;charset=UTF-8")
	public String rdUpdatePopup(HttpServletRequest req, MemberVO memberParam, Model model) throws SQLException, IOException {
		LOG.debug("=================================");
		LOG.debug("rdUpdatePopup()");
		LOG.debug("=================================");
		
		// jsp에 보내기 위한 값 추출
		String rNum = req.getParameter("rNum"); // 댓글 번호	
		
		model.addAttribute("rNum", rNum); // 댓글번호
		
		return "review/rd_update_popup";
		
	}
	
	@RequestMapping(value = "/doRdUpdate.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRdUpdate(MemberVO mInVO, RdVO rInVO) throws SQLException {
		LOG.debug("=================================");
		LOG.debug("rInVO : " + rInVO);
		LOG.debug("=================================");
		
		mInVO.setmNum(rInVO.getmNum());
		
		int flag = reviewService.rdUpdate(mInVO, rInVO);
				
		String resultMsg = "";
		if (1 == flag) {
			resultMsg = "댓글이 수정되었습니다!";
		}else {
			resultMsg = "다시 시도해주세요";
		}
		MessageVO message = new MessageVO(String.valueOf(flag), resultMsg);
		
		String jsonString = new Gson().toJson(message);
		LOG.debug("================================="); 
		LOG.debug("jsonString : " + jsonString); 
		LOG.debug("=================================");
		
		return jsonString;
		
	}
	
	@RequestMapping(value = "/rdPopup.do", method = RequestMethod.GET, produces = "application/text;charset=UTF-8")
	public String rdPopup(HttpServletRequest req, MemberVO memberParam, Model model) throws SQLException, IOException {
		LOG.debug("=================================");
		LOG.debug("rdPopup()");
		LOG.debug("=================================");
		
		// jsp에 보내기 위한 값 추출
		String rNum = req.getParameter("rNum"); // 댓글 번호
		
		model.addAttribute("rNum", rNum);
		
		return "review/rd_write_popup";
		
	}

	@RequestMapping(value = "/doRdInsert.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRdInsert(MemberVO mInVO, RdVO rInVO) throws SQLException {
		LOG.debug("=================================");
		LOG.debug("rInVO : " + rInVO);
		LOG.debug("=================================");

		mInVO.setmNum(rInVO.getmNum());
		
		int flag = reviewService.doRdInsert(mInVO, rInVO);
				
		String resultMsg = "";
		if (1 == flag) {
			resultMsg = "댓글이 등록되었습니다!";
		}else {
			resultMsg = "다시 시도해주세요";
		}
		MessageVO message = new MessageVO(String.valueOf(flag), resultMsg);
		
		String jsonString = new Gson().toJson(message);
		LOG.debug("================================="); 
		LOG.debug("jsonString : " + jsonString); 
		LOG.debug("=================================");
		
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
