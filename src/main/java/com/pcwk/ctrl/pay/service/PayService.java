package com.pcwk.ctrl.pay.service;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ctrl.cmn.CartVO;
import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.DetailVO;
import com.pcwk.ctrl.cmn.OrderVO;

public interface PayService {
	
	
	/**
	 * 장바구니 삭제
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	public int cartDelete(CartVO inVO) throws SQLException;
	
	/**
	 * 장바구니 조회
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	public List<CartVO> cartSelect(CartVO cart) throws SQLException;
	
	public OrderVO getoNum(OrderVO inVO) throws SQLException;
	
	/**
	 * 결제 완료 시 추가
	 * @param inVO
	 * @return int
	 * @throws SQLException
	 */
	public int payOrderInsert(OrderVO inVO) throws SQLException;
	
	/**
	 * 결제 완료 시 추가
	 * @param inVO
	 * @return int
	 * @throws SQLException
	 */
	public int payDetailInsert(DetailVO inVO) throws SQLException;
	
}
