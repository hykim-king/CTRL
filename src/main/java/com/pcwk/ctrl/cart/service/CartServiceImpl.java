package com.pcwk.ctrl.cart.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cart.dao.CartDao;
import com.pcwk.ctrl.cmn.ProductVO;


@Service("cartService")
public class CartServiceImpl implements CartService {

	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	private CartDao cartDao;

	@Override
	public List<ProductVO> doCartSelect(ProductVO inVO) {
		return cartDao.doCartSelect(inVO);
	}

	
}