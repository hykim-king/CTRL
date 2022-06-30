package com.pcwk.ctrl.login.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

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

import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.StringUtil;
import com.pcwk.ctrl.member.service.MemberService;
import com.pcwk.ctrl.naver.service.NaverProfileService;


@Controller("loginController")
@RequestMapping("login")
public class LoginController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	NaverProfileService naverProfileService;
	
	
	public LoginController () {}
	
	@RequestMapping(value = "/login.do",method = RequestMethod.GET)
	public String loginPageGET() {
		LOG.debug("=================================");
		LOG.debug("loginPageGET()");
		LOG.debug("=================================");
		
		return "login/naver_login";
	}
	
	@RequestMapping(value = "/callback.do")
	public String naverCallback(HttpSession session, HttpServletRequest req, Model model)throws IOException, ParseException {
		
	    //session.invalidate();
	    
		LOG.debug("=================================");
		LOG.debug("naverCallback()");
		LOG.debug("=================================");
		
		return "login/naver_callback";
	}
	
	//네이버 프로필 출력
//	@RequestMapping(value = "/doRetrieve.do", method=RequestMethod.GET
//			, produces="application/json;charset=UTF-8")
//	@ResponseBody
//	public MemberVO doRetrieve(MemberVO inVO, HttpServletRequest req, HttpSession session)throws Exception{
//		String accessToken = req.getParameter("access_token");
//		
//		inVO = naverProfileService.doRetrieve(accessToken);
//		
//		LOG.debug("=================================");
//		LOG.debug("doRetrieve");
//		LOG.debug("inVO: "+inVO);
//		LOG.debug("=================================");
//		
//		return inVO;
//	}
	
	@RequestMapping(value="/doMemberInsert.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody//스프링에서 비동기 처리를 하는 경우 HTTP 요청의 본문 body 부분이 그대로 전달된다
	public MemberVO doMemberInsert(MemberVO inVO, HttpServletRequest req, HttpSession session) throws Exception{
//		String jsonString = "";
		String accessToken = req.getParameter("access_token");
		
		inVO = naverProfileService.doMemberInsert(accessToken);
		
		if(null == inVO.getmAddr()) {
			inVO.setmAddr(StringUtil.nvl(inVO.getmAddr(), ""));
		}
		
		LOG.debug("==============================");
		LOG.debug("doMemberInsert");
		LOG.debug("inVO "+ inVO);
		LOG.debug("==============================");
		
		List<MemberVO> list = memberService.doMemberInsert(inVO);
		String resultMessaage = "";
		
		if(null == list) {
			resultMessaage = inVO.getmNum() + "가 등록되었습니다";
		}else {
			resultMessaage = inVO.getmNum() + "등록 실패";
		}
//		MessageVO message = new MessageVO(String.valueOf(list), resultMessaage);
//		Gson gson = new Gson();
//		
//		jsonString = gson.toJson(message);
//		LOG.debug("==============================");
//		LOG.debug("=jsonString="+ jsonString);
//		LOG.debug("==============================");	
//		
		return inVO;
	}
	
	
	
//	@RequestMapping(value = "/accessToken.do", method = RequestMethod.GET, 
//			produces = "application/json;charset=UTF-8")
//	@ResponseBody
//	public String accessToken(MemberVO inVO, HttpSession session) throws Exception{
//	String jsonString = "";
//	LOG.debug("=================================");
//	LOG.debug("accessToken()");
//	LOG.debug("inVO: "+inVO);
//	LOG.debug("=================================");	
//	
//	MessageVO message = memberService.memberCheck(inVO);
//	
//	if(null != message && "10".equals(message.getMsgId())) {
//	MemberVO loginMember = memberService.doSelectOne(inVO);
//	if(null != loginMember) {
//		session.setAttribute("member", loginMember);
//	
//	message.setMsgContents(loginMember.getmName()+"님 환영합니다!");
//	}
//	
//	}
//	
//	return jsonString;
//	
//	}
	
}
