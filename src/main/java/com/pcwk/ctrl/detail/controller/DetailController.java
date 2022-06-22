package com.pcwk.ctrl.detail.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ctrl.detail.service.DetailService;

@Controller
@RequestMapping("detail")
public class DetailController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	DetailService detailService;
	
	public DetailController() {}

	@RequestMapping(value = "/detail.do", method = RequestMethod.GET
			, produces = "application/json;charset=UTF-8")
	public String detail() {
		LOG.debug("=================================");
		LOG.debug("detail()");
		LOG.debug("=================================");
		
		return "detail/detail";
	}
}
