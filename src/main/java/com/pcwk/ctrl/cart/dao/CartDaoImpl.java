package com.pcwk.ctrl.cart.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.ProductVO;

@Repository("cartDao")
public class CartDaoImpl implements CartDao {

	final Logger LOG = LogManager.getLogger(this.getClass());

	//mybatis namespace
	final String NAMESPACE = "com.pcwk.ctrl.cart";
	
	//mybatis db연결객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
		public List<ProductVO> doCartSelect(ProductVO inVO) {
			List<ProductVO> outVO = null;
		
		String statement = NAMESPACE+".doCartSelect";
		
		LOG.debug("=============================");
		LOG.debug("statement :" + statement);
		LOG.debug("=============================");
		
		outVO = this.sqlSessionTemplate.selectList(statement, inVO);
		
		LOG.debug("=============================");
		LOG.debug("outVO="+outVO.toString());
		LOG.debug("=============================");
		
		return outVO;
	}


}