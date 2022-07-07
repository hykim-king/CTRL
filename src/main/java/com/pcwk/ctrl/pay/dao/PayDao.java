package com.pcwk.ctrl.pay.dao;

import java.sql.SQLException;

import com.pcwk.ctrl.cmn.DetailVO;
import com.pcwk.ctrl.cmn.OrderVO;

public interface PayDao {
	
	/**
	 * 장바구니 삭제
	 * @param inVO
	 * @return int
	 * @throws SQLException
	 */
	//int cartDelete(CartVO inVO) throws SQLException;
	
	/**
	 * 장바구니 조회
	 * @param inVO
	 * @return int
	 * @throws SQLException
	 */
	//int cartSelect(CartVO inVO) throws SQLException;
	
	OrderVO getoNum(OrderVO inVO) throws SQLException;
	
	/**
	 * 결제 완료 시 추가
	 * @param inVO
	 * @return int
	 * @throws SQLException
	 */
	int payOrderInsert(OrderVO inVO) throws SQLException;
	
	/**
	 * 결제 완료 시 추가
	 * @param inVO
	 * @return int
	 * @throws SQLException
	 */
	int payDetailInsert(DetailVO inVO) throws SQLException;
	
	
}
