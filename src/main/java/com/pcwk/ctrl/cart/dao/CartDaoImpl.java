package com.pcwk.ctrl.cart.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.CartVO;

@Repository("cartDao")
public class CartDaoImpl implements CartDao {

	final Logger LOG = LogManager.getLogger(this.getClass());
	
	final String NAMESPACE = "com.pcwk.ctrl.cart";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public CartDaoImpl() {
		
	}
	
	@Override
	public int doInsert(CartVO inVO) throws SQLException {
		int flag = 0;
		String statement = this.NAMESPACE + ".doInsert";
		flag = sqlSessionTemplate.insert(statement, inVO);
		
		return flag;
	}

	@Override
	public List<CartVO> doSelectList(CartVO inVO) throws SQLException {
		List<CartVO> list = null;
		String statement = this.NAMESPACE + ".doSelectList";
		list = sqlSessionTemplate.selectList(statement, inVO);
		for(CartVO vo : list) {
			LOG.debug("vo : " + vo);
		}
		return list;
	}

}