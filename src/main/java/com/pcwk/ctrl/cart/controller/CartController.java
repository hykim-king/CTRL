package com.pcwk.ctrl.cart.controller;

import java.io.IOException;
import java.util.List;

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
	
	public CartController() {}

	@RequestMapping(value = "/cart.do", method = RequestMethod.GET
			, produces = "application/json;charset=UTF-8")
	public String  doCartSelect(Model model, ProductVO inVO) throws IOException {
		
		
		List<ProductVO> outVO = cartService.doCartSelect(inVO);
		
		LOG.debug("=================================");
		LOG.debug("outVO : " + outVO);	
		LOG.debug("=================================");
		
		model.addAttribute("ProductVO", outVO);

		return "cart/cart";
	}
}