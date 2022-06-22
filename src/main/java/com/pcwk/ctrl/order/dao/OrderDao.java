package com.pcwk.ctrl.order.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.KakaoMVO;

public interface OrderDao {
	/**
	 * 주문조회
	 * @param 
	 * @return
	 * @throws SQLException
	 */
	List<Map<String, DTO>> doRetrieve(KakaoMVO kakaoMVO) throws SQLException;

}