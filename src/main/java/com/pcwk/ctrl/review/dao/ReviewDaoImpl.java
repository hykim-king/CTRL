package com.pcwk.ctrl.review.dao;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.DTO;

@Repository("reviewDao")
public class ReviewDaoImpl implements ReviewDao {
	
	final Logger LOG = LogManager.getLogger(this.getClass());

	//mybatis namespace
	final String NAMESPACE = "com.pcwk.ctrl.review";
	
	//mybatis db연결객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int doReviewInsert(DTO dto) throws SQLException {
		int flag = 0;
		
		String statement = NAMESPACE+".doReviewInsert";
		
		LOG.debug("=============================");
		LOG.debug("param :" + dto.toString());
		LOG.debug("statement :" + statement);
		LOG.debug("=============================");
		
		flag = this.sqlSessionTemplate.insert(statement,dto);
		LOG.debug("flag : " + flag);
		
		return flag;
	}


}
