package com.pcwk.ctrl.faq.controller;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("faqController")
@RequestMapping("faq")
public class FaqController {
	
	final Logger LOG=LogManager.getLogger(getClass());
	
	public FaqController() {}
	
	@RequestMapping(value = "/faq.do",method = RequestMethod.GET)
	public String faqPageGET() throws SQLException {
		LOG.debug("========================");
		LOG.debug("=faqPageGET()=");
		LOG.debug("========================");
		
		///WEB-INF/views/+ boot/boot_list+ .jsp
		///WEB-INF/views/boot/boot_list.jsp
		return "faq/faq";
	}

}