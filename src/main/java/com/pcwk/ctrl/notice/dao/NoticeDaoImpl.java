package com.pcwk.ctrl.notice.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.NoticeVO;

@Repository("noticeDao")
public class NoticeDaoImpl implements NoticeDao {
	
	final Logger LOG = LogManager.getLogger(this.getClass());
	
	//mybatis namespace
		final String NAMESPACE = "com.pcwk.ctrl.notice";
		
		//mybatis db연결객체
		@Autowired
		SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<NoticeVO> doNoticeSelect() {
		List<NoticeVO> outVO = null;
		
		String statement = NAMESPACE + ".doNoticeSelect";
		
		LOG.debug("=============================");
		LOG.debug("statement :" + statement);
		LOG.debug("=============================");
		
		outVO = this.sqlSessionTemplate.selectList(statement);
		
		LOG.debug("=============================");
		LOG.debug("outVO="+outVO.toString());
		LOG.debug("=============================");
		
		return outVO;
	}

}