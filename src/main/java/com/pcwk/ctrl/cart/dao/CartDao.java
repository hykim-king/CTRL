package com.pcwk.ctrl.cart.dao;


import java.util.List;

import com.pcwk.ctrl.cmn.ProductVO;

public interface CartDao {
	
	List<ProductVO> doCartSelect(ProductVO inVO);
	
}