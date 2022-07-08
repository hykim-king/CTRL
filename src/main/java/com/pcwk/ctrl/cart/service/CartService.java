package com.pcwk.ctrl.cart.service;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ctrl.cmn.CartVO;

public interface CartService {

	public int doDelete(CartVO inVO) throws SQLException;
	
	public int doInsert(CartVO inVO) throws SQLException;
	
	List<CartVO> doSelectList(CartVO inVO) throws SQLException;
}