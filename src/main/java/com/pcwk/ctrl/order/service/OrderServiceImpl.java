package com.pcwk.ctrl.order.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.KakaoMVO;
import com.pcwk.ctrl.order.dao.OrderDao;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<Map<String, DTO>> doRetrieve(KakaoMVO kakaoMVO) throws SQLException {
		return orderDao.doRetrieve(kakaoMVO);
	}
}
