package com.pcwk.ctrl.cart.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ctrl.cart.service.CartService;
import com.pcwk.ctrl.cmn.ProductVO;

@Controller("cartController")
@RequestMapping("cart")
public class CartController {

	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	CartService cartService;

	public CartController() {
	}
	@RequestMapping(value = "/addcart.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String addCart(Model model)throws IOException {
		
		LOG.debug("=============================");
		LOG.debug("=======addcart============");
		LOG.debug("=======addcart================");
		LOG.debug("=============================");
		
		return "cart/addcart";
	}

	@RequestMapping(value = "/cart.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String doCartSelect(Model model, ProductVO inVO, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 회원번호
//		String pNum =c;
		/*
		 * // 회원번호를 쿠키에 지정한다 Cookie c = new Cookie("pNum", pNum);
		 * 
		 * // 쿠키에 설명을 추가한다 c.setComment("상품번호");
		 * 
		 * // 쿠키 유효기간을 설정한다. 초단위 : 60*60*24= 1일 c.setMaxAge(60 * 5);
		 * 
		 * // 응답헤더에 쿠키를 추가한다. response.addCookie(c);
		 */

		LOG.debug("=============================");

		Cookie[] cookies = request.getCookies();
		
		
		// List<String> list.cookies
	
		String pNum = cookies[0].getValue();

		for (Cookie cookie : cookies) {
			LOG.debug("=============================");
			LOG.debug("=====" + cookie.getName() + "===");
			LOG.debug("=============================");
			LOG.debug("=====" + cookie.getValue() + "=======");
			LOG.debug("=============================");
		}

		LOG.debug("==" + request.getCookies());
		LOG.debug("=============================");

		inVO.setpNum(pNum);

		List<ProductVO> outVO = cartService.doCartSelect(inVO);

		LOG.debug("=================================");
		LOG.debug("outVO : " + outVO);
		LOG.debug("=================================");

		model.addAttribute("inquiry", outVO);

		return "cart/cart";
	}

}