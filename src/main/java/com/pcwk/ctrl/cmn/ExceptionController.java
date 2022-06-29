package com.pcwk.ctrl.cmn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("except")
public class ExceptionController {
	
	// http://localhost:8081/ehr/except/illegal.do?uId=
	@RequestMapping(value="/illegal.do")
	public String illegalArgumentException(MemberVO inVO) {
		if(null == inVO.getmEmail() || "".equals(inVO.getmEmail())) {
			throw new IllegalArgumentException("이메일 타입을 확인하세요.");
		}
		
		
		
		return "main/main";
	}
	
	// http://localhost:8081/ehr/except/nullPointer.do?uId=
	@RequestMapping(value="/nullPointer.do")
	public String nullPointerException(MemberVO inVO) {
		if(null == inVO.getmEmail() || "".equals(inVO.getmEmail())) {
			throw new NullPointerException("이메일을 입력하세요.");
		}
		return "main/main"; // 오류가 없으면 main.jsp로 넘김
	}
}
