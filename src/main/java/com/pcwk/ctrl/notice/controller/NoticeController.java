package com.pcwk.ctrl.notice.controller;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ctrl.cmn.NoticeVO;
import com.pcwk.ctrl.notice.service.NoticeService;

@Controller("noticeController")
@RequestMapping("notice")
public class NoticeController {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	NoticeService noticeService;
	
	public NoticeController() {}
	
	@RequestMapping(value = "/notice.do", method = RequestMethod.GET
			, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String  doNoticeSelect() throws IOException {
		String jsonString = "";
		LOG.debug("=================================");
		LOG.debug("productDetail()");
		LOG.debug("=================================");
		
		List<NoticeVO> outVO = noticeService.doNoticeSelect();
	    LOG.debug("outVO : " + outVO);	
		
		jsonString = new Gson().toJson(outVO);
		LOG.debug("=================================");
		LOG.debug("jsonString : " + jsonString);
		LOG.debug("=================================");

		return jsonString;
		
	}
	
}