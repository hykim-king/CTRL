package com.pcwk.ctrl.cart.service;

import java.util.List;

import com.pcwk.ctrl.cmn.ProductVO;

public interface CartService {
	
	public List<ProductVO> doCartSelect(ProductVO inVO);
	
}