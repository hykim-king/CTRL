package com.pcwk.ctrl.pay.service;

import java.sql.SQLException;

import com.pcwk.ctrl.cmn.DetailVO;
import com.pcwk.ctrl.cmn.OrderVO;

public interface PayService {
	
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
