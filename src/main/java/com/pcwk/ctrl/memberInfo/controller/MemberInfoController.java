package com.pcwk.ctrl.memberInfo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.memberInfo.service.MemberInfoService;


@Controller("memberInfoController")
@RequestMapping("memberInfo")
public class MemberInfoController {
	
	final Logger LOG = LogManager.getLogger(getClass());
	   
	   @Autowired
	   MemberInfoService memberService;
	   
	   public MemberInfoController() {}
	   
	   // 회원목록
	   @RequestMapping(value="/memberInfo.do", method=RequestMethod.GET)
		public String memberList(Model model) {
			LOG.debug("==========================");
			LOG.debug("memberList()");
			LOG.debug("==========================");
			
			List<MemberVO> list = memberService.memberList();
			model.addAttribute("list", list);
			return "memberInfo/memberInfo";
			
		}
}
