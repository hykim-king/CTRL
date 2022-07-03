package com.pcwk.ctrl.order.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.OrderListVO;
import com.pcwk.ctrl.cmn.OrderVO;
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.SearchVO;

public interface OrderService {
	
	/**
	 * 주문조회
	 * @return List<MemberVO>
	 * @throws SQLException
	 */
	public List<OrderListVO> doRetrieve(DTO dto) throws SQLException;
	
	public int getCount(OrderListVO oVO) throws SQLException;
}
