package com.pcwk.ctrl.order.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.KakaoMVO;

public interface OrderService {
	

	public List<Map<String, DTO>> doRetrieve(KakaoMVO kakaoMVO) throws SQLException;
}
