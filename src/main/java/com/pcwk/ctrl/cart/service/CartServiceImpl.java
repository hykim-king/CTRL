package com.pcwk.ctrl.cart.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cart.dao.CartDao;
import com.pcwk.ctrl.cmn.CartVO;

@Service("cartService")
public class CartServiceImpl implements CartService {

	public CartServiceImpl() {
	}
	
	@Autowired
	CartDao cartDao;
	
	@Override
	public int doInsert(CartVO inVO) throws SQLException {
		return cartDao.doInsert(inVO);
	}

	@Override
	public List<CartVO> doSelectList(CartVO inVO) throws SQLException {
		return cartDao.doSelectList(inVO);
	}

}