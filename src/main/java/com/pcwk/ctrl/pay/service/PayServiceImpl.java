package com.pcwk.ctrl.pay.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cmn.DetailVO;
import com.pcwk.ctrl.cmn.OrderVO;
import com.pcwk.ctrl.pay.dao.PayDao;

@Service("payService")
public class PayServiceImpl implements PayService {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	private PayDao payDao;
	
	@Override
	public int payOrderInsert(OrderVO inVO) throws SQLException {
		// TODO Auto-generated method stub
		return payDao.payOrderInsert(inVO);
	}

	@Override
	public int payDetailInsert(DetailVO inVO) throws SQLException {
		// TODO Auto-generated method stub
		return payDao.payDetailInsert(inVO);
	}

}
