package com.pcwk.ctrl.cart.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ctrl.cart.service.CartService;
import com.pcwk.ctrl.cmn.CartVO;
import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.MessageVO;

@Controller("cartController")
@RequestMapping("cart")
public class CartController {

	final Logger LOG = LogManager.getLogger(this.getClass());
	
	@Autowired
	CartService cartService;
	
	public CartController() {
		
	}
	
	@RequestMapping(value = "/doInsert.do", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doInsert(CartVO inVO) throws SQLException{
		String jsonString = "";
		int flag = cartService.doInsert(inVO);
		
		LOG.debug("===========================");
		LOG.debug("=inVO=" + inVO);
		LOG.debug("=flag=" + flag);
		LOG.debug("===========================");
		
		String resultMsg = "";
		
		if(flag == 1) {
			resultMsg += "장바구니에 담겼습니다!";
		}else {
			resultMsg += "장바구니 실패";
		}
		MessageVO message = new MessageVO(String.valueOf(flag), resultMsg);
		Gson gson = new Gson();
		jsonString = gson.toJson(message);
		LOG.debug("===========================");
		LOG.debug("=jsonString=" + jsonString);
		LOG.debug("===========================");
		
		return jsonString;
	}
	
	@RequestMapping(value = "/cart.do", method=RequestMethod.GET)
	public String cartView(HttpServletRequest request, Model model, HttpSession session) throws SQLException {
		CartVO inVO = new CartVO("", 0, "", "", 0, 0, 0);
		MemberVO memVO = (MemberVO)session.getAttribute("member");
//		inVO.setmNum(memVO.getmNum());
		LOG.debug("memVO = " +memVO);
//		List<CartVO> list = cartService.doSelectList(inVO);
//		for(CartVO vo : list) {
//			LOG.debug(" cartView vo = " + vo);
//		}
//		model.addAttribute("list", list);
		
		return "cart/cart";
	}
}