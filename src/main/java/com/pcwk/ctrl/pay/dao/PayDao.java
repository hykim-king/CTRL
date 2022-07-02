package com.pcwk.ctrl.pay.dao;

import java.sql.SQLException;

import com.pcwk.ctrl.cmn.DetailVO;
import com.pcwk.ctrl.cmn.OrderVO;

public interface PayDao {
	
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