package com.pcwk.ctrl.cart.dao;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ctrl.cmn.CartVO;

public interface CartDao {
	
	int doDelete(CartVO inVO) throws SQLException;
	
	int doInsert(CartVO inVO) throws SQLException;
	
	List<CartVO> doSelectList(CartVO inVO) throws SQLException;
	
}