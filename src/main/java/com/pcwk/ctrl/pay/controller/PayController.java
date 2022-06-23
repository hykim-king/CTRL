package com.pcwk.ctrl.pay.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("ctrl")
public class PayController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@RequestMapping(value = "/after.do", method = RequestMethod.GET)
	public String after() {
		LOG.debug("====================");
		LOG.debug("=after()=");
		LOG.debug("====================");
		
		return "pay/after";
		//http://localhost:8081/ctrl/ctrl/after.do
	}
	
	@RequestMapping(value = "/before.do", method = RequestMethod.GET)
	public String before() {
		LOG.debug("====================");
		LOG.debug("=before()=");
		LOG.debug("====================");
		
		return "pay/before";
		//http://localhost:8081/ctrl/ctrl/before.do
	}
	
}