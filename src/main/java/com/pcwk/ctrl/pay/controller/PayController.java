package com.pcwk.ctrl.pay.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ctrl.cmn.DetailVO;
import com.pcwk.ctrl.cmn.OrderVO;
import com.pcwk.ctrl.order.service.OrderService;
import com.pcwk.ctrl.pay.service.PayService;

@Controller
@RequestMapping("pay")
public class PayController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	PayService payService;
	
	public PayController() {}
	
	@RequestMapping(value = "/payOrderInsert.do", method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String payOrderInsert(OrderVO inVO) throws SQLException{
		
		LOG.debug("=================================");
		LOG.debug("payOrderInsert()");
		LOG.debug("inVO"+inVO);
		LOG.debug("=================================");
		
		int outVO = payService.payOrderInsert(inVO);
		Gson gson = new Gson();
		String jsonString = gson.toJson(outVO);
		
		return jsonString;
		
	}
	
	@RequestMapping(value = "/payDetailInsert.do", method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public String payDetailInsert(DetailVO inVO) throws SQLException{
		
		LOG.debug("=================================");
		LOG.debug("payDetailInsert()");
		LOG.debug("inVO"+inVO);
		LOG.debug("=================================");
		
		int outVO = payService.payDetailInsert(inVO);
		Gson gson = new Gson();
		String jsonString = gson.toJson(outVO);
		
		return jsonString;
		
	}
	
	@RequestMapping(value = "/payAfter.do", method = RequestMethod.GET)
	public String payAfter() {
		LOG.debug("====================");
		LOG.debug("=after()=");
		LOG.debug("====================");
		
		return "pay/pay_after";
		//http://localhost:8081/ctrl/ctrl/after.do
	}
	
	@RequestMapping(value = "/payBefore.do", method = RequestMethod.GET)
	public String payBefore() {
		LOG.debug("====================");
		LOG.debug("=before()=");
		LOG.debug("====================");
		
		return "pay/pay_before";
		//http://localhost:8081/ctrl/ctrl/before.do
	}
	
}

