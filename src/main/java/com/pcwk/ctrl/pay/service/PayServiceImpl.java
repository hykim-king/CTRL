package com.pcwk.ctrl.pay.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cmn.CartVO;
import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.DetailVO;
import com.pcwk.ctrl.cmn.OrderVO;
import com.pcwk.ctrl.pay.dao.PayDao;

@Service("payService")
public class PayServiceImpl implements PayService {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	private PayDao payDao;
	
	//기본 생성자
	public PayServiceImpl() {}
	
	@Override
	public int payOrderInsert(OrderVO inVO) throws SQLException {
		return payDao.payOrderInsert(inVO);
	}

	@Override
	public int payDetailInsert(DetailVO inVO) throws SQLException {
		return payDao.payDetailInsert(inVO);
	}

	@Override
	public OrderVO getoNum(OrderVO inVO) throws SQLException {
		return payDao.getoNum(inVO);
	}

	@Override
	public int cartDelete(CartVO inVO) throws SQLException {
		return payDao.cartDelete(inVO);
	}

	@Override
	public List<CartVO> cartSelect(CartVO cart) throws SQLException{
		return payDao.cartSelect(cart);
	}

}
