package com.pcwk.ctrl.order.dao;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.OrderListVO;
import com.pcwk.ctrl.cmn.OrderVO;

public interface OrderDao {
	/**
	 * 주문조회
	 * @return List<MemberVO>
	 * @throws SQLException
	 */
	List<OrderListVO> doRetrieve(DTO dto) throws SQLException;
	
	int getCount (OrderListVO oVO) throws SQLException;
}