package com.pcwk.ctrl.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
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
	public String naverCallback()throws IOException, ParseException {
		
		LOG.debug("=================================");
		LOG.debug("naverCallback()");
		LOG.debug("=================================");
		
		return "login/naver_callback";
	}
	

	
	@RequestMapping(value="/memberCheck.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody//스프링에서 비동기 처리를 하는 경우 HTTP 요청의 본문 body 부분이 그대로 전달된다
	public MemberVO memberCheck(MemberVO inVO, HttpServletRequest req, HttpSession session, HttpServletResponse response) throws Exception{
		String accessToken = req.getParameter("access_token");
		String resultMessaage = "";
		
		inVO = naverProfileService.doMemberInsert(accessToken);
		
		if(null == inVO.getmAddr()) {
			inVO.setmAddr(StringUtil.nvl(inVO.getmAddr(), ""));
		}
		
		LOG.debug("memberCheck");
		LOG.debug("inVO: "+ inVO);
		
		MemberVO outVO = memberService.doSelectOne(inVO);
		if(null == outVO) {
			List<MemberVO> list = memberService.doMemberInsert(inVO);
			LOG.debug("==============================");
			LOG.debug("doMemberInsert");
			LOG.debug("inVO "+ inVO);
			LOG.debug("==============================");
			resultMessaage = inVO.getmNum() + " 가 등록되었습니다";
		}else {
			resultMessaage = outVO.getmNum() + "는 이미 등록된 회원번호입니다.";
		}
		
		LOG.debug("==============================");
		LOG.debug("resultMessaage: "+ resultMessaage);
		LOG.debug("==============================");
		
		   
		session = req.getSession();
//		PrintWriter pw = response.getWriter();
		if(null != session) {
			session.setAttribute("member", inVO);
			LOG.debug("session:"+session);
			response.sendRedirect("/ctrl/main/main.do");
//			pw.println("<script>alert('로그인');document.location.href='/ctrl/main/main.do';</script>");
		}else {
			LOG.debug("session is null");
//			pw.println("<script>alert('로그인 실패');document.location.href='/ctrl/main/main.do';</script>");
		}
		
//        response.sendRedirect("/ctrl/main/main.do");
		
//		PrintWriter pw = response.getWriter();
//		if(null != session) {
//			pw.println("<script>alert('로그인');document.location.href='/ctrl/main/main.do';</script>");
//		}else {
//			pw.println("<script>alert('로그인 실패');document.location.href='/ctrl/main/main.do';</script>");
//		}
		
		return outVO;
	}
	
	
	@RequestMapping(value = "doSelectOne.do",method = RequestMethod.GET
	         ,produces = "application/json;charset=UTF-8")
	@ResponseBody //스프링에서 비동기 처리를 하는 경우, Http 요청의 본문 body부분이 전달된다.
	public String doSelectOne(MemberVO inVO) throws SQLException {
		LOG.debug("==============================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("==============================");
		
		MemberVO outVO = memberService.doSelectOne(inVO);
		Gson gson = new Gson();
		String jsonString = gson.toJson(outVO);
		
		LOG.debug("==============================");
		LOG.debug("=jsonString="+jsonString);
		LOG.debug("==============================");      
		return jsonString;
	}

	
	
}
