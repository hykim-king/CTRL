package com.pcwk.ctrl.productDetail.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ctrl.productDetail.service.ProductDetailService;

@Controller
@RequestMapping("productDetail")
public class ProductDetailController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ProductDetailService detailService;
	
	public ProductDetailController() {}

	@RequestMapping(value = "/productDetail.do", method = RequestMethod.GET
			, produces = "application/json;charset=UTF-8")
	public String productDetail() {
		LOG.debug("=================================");
		LOG.debug("productDetail()");
		LOG.debug("=================================");
		
		return "productDetail/productDetail";
	}
}
