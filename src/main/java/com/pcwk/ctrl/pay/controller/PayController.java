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
import com.pcwk.ctrl.cart.service.CartService;
import com.pcwk.ctrl.cmn.CartVO;
import com.pcwk.ctrl.cmn.DetailVO;
import com.pcwk.ctrl.cmn.MessageVO;
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
	
	@Autowired
	CartService cartService; 
	
	public PayController() {}
	
	@RequestMapping(value = "/cartDelete.do", method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int cartDelete(CartVO inVO) throws SQLException{
		
		LOG.debug("=================================");
		LOG.debug("cartDelete()");
		LOG.debug("inVO"+inVO);
		LOG.debug("=================================");
		
		int flag = payService.cartDelete(inVO);
		
		return flag;
		
	}
	
	@RequestMapping(value = "/cartSelect.do", method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public String cartSelect(Model model) {
		LOG.debug("=================================");
		LOG.debug("cartSelect()");
		LOG.debug("=================================");
		
		List<CartVO> list = payService.cartSelect();
		
		
		model.addAttribute("list",list);
		
		return "pay/pay_before_cart";
		
		
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
	public String payOrderInsert(OrderVO inVO) throws SQLException{
		String jsonString = "";
		
		LOG.debug("=================================");
		LOG.debug("payOrderInsert()");
		LOG.debug("inVO"+inVO);
		LOG.debug("=================================");
		
		int flag = payService.payOrderInsert(inVO);
		LOG.debug("flag"+flag);
		String resultMsg = "";
		
		if(1 == flag) {
			resultMsg = "등록좀되라";
		}else {
			resultMsg = "등록안됨";
		}

		MessageVO message = new MessageVO(String.valueOf(flag), resultMsg);
		
		jsonString = new Gson().toJson(message);
		
		LOG.debug("=================================");
		LOG.debug("=jsonString="+jsonString);
		LOG.debug("=================================");
		
		return jsonString;
		
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

