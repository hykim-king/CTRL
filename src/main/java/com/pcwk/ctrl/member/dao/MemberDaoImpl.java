package com.pcwk.ctrl.member.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.SearchVO;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

	final Logger LOG = LogManager.getLogger(this.getClass());
	
	//mybatis namespace
	final String NAMESPACE = "com.pcwk.ctrl.member";
	
	//mybatis db연결객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
			
	public MemberDaoImpl() {}
	
	@Override
	public List<MemberVO> doMemberInsert(MemberVO inVO) throws SQLException {
		List<MemberVO> list = null;
		
		String statement = NAMESPACE+".doMemberInsert";
		
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("statement:" + statement);
		LOG.debug("==============================");
		
		list = this.sqlSessionTemplate.selectList(statement, inVO);
		
		for(MemberVO vo  :list) {
			LOG.debug("vo:"+vo.toString());
		}
		
		return list;
	}


	@Override
	@SuppressWarnings("deprecation")
	public MemberVO doSelectOne(MemberVO inVO) throws SQLException {
		MemberVO outVO = null;
		
		String statement = this.NAMESPACE +".doSelectOne";
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("statement:" + statement);
		LOG.debug("==============================");
		
		outVO = this.sqlSessionTemplate.selectOne(statement, inVO);		
		LOG.debug("==============================");
		LOG.debug("**outVO=" + outVO.toString());
		LOG.debug("==============================");

		return outVO;
	}


	@Override
	public List<MemberVO> getAll(MemberVO inVO) {
		List<MemberVO> list= null;
	    String statement = NAMESPACE+".getAll";
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("statement:" + statement);
		LOG.debug("==============================");	
		
		list = sqlSessionTemplate.selectList(statement, inVO);
		
		for(MemberVO vo  :list) {
			LOG.debug("vo:"+vo.toString());
		}
		
		return list;
	}


}
