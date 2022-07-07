package com.pcwk.ctrl.pay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ctrl.cmn.CartVO;
import com.pcwk.ctrl.cmn.DetailVO;
import com.pcwk.ctrl.cmn.OrderVO;
import com.pcwk.ctrl.pay.service.PayService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller
@RequestMapping("pay")
public class PayController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	PayService payService;
	
	@RequestMapping(value = "/cartSelect.do", method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String cartSelect(CartVO inVO, Model model) throws SQLException{
		String jsonString = "";
		LOG.debug("=================================");
		LOG.debug("cartSelect()");
		LOG.debug("=================================");
		
		List<CartVO> list = payService.cartSelect(inVO);
		Gson gson = new Gson();
		jsonString = gson.toJson(list);
		
		LOG.debug("====================");
		LOG.debug("=jsonString=" + jsonString);
		LOG.debug("====================");
		
		model.addAttribute("list:"+list);
		
		return jsonString;
		
	}
	
	@RequestMapping(value = "/getoNum.do", method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public OrderVO getoNum(OrderVO inVO) throws SQLException{
		OrderVO vo = payService.getoNum(inVO);
		
		return vo;
	}
	
	
	
	@RequestMapping(value = "/payOrderInsert.do", method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int payOrderInsert(OrderVO inVO) throws SQLException{
		
		LOG.debug("=================================");
		LOG.debug("payOrderInsert()");
		LOG.debug("inVO"+inVO);
		LOG.debug("=================================");
		
		int flag = payService.payOrderInsert(inVO);
		
		return flag;
		
	}
	
	@RequestMapping(value = "/payDetailInsert.do", method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int payDetailInsert(DetailVO inVO) throws SQLException{
		
		LOG.debug("=================================");
		LOG.debug("payDetailInsert()");
		LOG.debug("inVO"+inVO);
		LOG.debug("=================================");
		
		int flag = payService.payDetailInsert(inVO);
		
		return flag;
		
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
	public String payBefore(HttpServletRequest req, Model model) {
		LOG.debug("====================");
		LOG.debug("=before()=");
		LOG.debug("====================");
		
		String pNum = req.getParameter("pNum");
		String product_name = req.getParameter("product_name");
		String product_price = req.getParameter("product_price");
		String buy_number = req.getParameter("buy_number");
		String totalNum = req.getParameter("totalNum");
		
		model.addAttribute("pNum",pNum);
		model.addAttribute("product_name",product_name);
		model.addAttribute("product_price",product_price);
		model.addAttribute("buy_number",buy_number);
		model.addAttribute("totalNum",totalNum);
		
		return "pay/pay_before";
		//http://localhost:8081/ctrl/ctrl/before.do
	}
	
}

