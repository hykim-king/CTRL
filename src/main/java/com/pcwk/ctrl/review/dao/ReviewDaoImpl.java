package com.pcwk.ctrl.review.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.OrderVO;
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.RdVO;
import com.pcwk.ctrl.cmn.ReviewRdVO;
import com.pcwk.ctrl.cmn.ReviewVO;
import com.pcwk.ctrl.cmn.SearchVO;

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
		
		flag = sqlSessionTemplate.insert(statement,dto);
		LOG.debug("flag : " + flag);
		
		return flag;
	}
	
	@Override
	public int getRdCount(RdVO inVO) throws SQLException {
		int count = 0;
		
		String statement = this.NAMESPACE+".getRdCount";
		
		LOG.debug("=============================");
		LOG.debug("param : "+inVO.toString());
		LOG.debug("statement : "+statement);
		LOG.debug("=============================");
		
		count = sqlSessionTemplate.selectOne(statement, inVO);
		
		LOG.debug("====================");
		LOG.debug("=count="+count);
		LOG.debug("====================");
		
		return count;
	}
	
	@Override
	public int getCount(ReviewVO inVO) throws SQLException {
		int count = 0;
		
		String statement = this.NAMESPACE+".getCount";
		
		LOG.debug("=============================");
		LOG.debug("param : "+inVO.toString());
		LOG.debug("statement : "+statement);
		LOG.debug("=============================");
		
		count = sqlSessionTemplate.selectOne(statement, inVO);
		
		LOG.debug("====================");
		LOG.debug("=count="+count);
		LOG.debug("====================");
		
		return count;
	}
	
	@Override
	public RdVO doRdSelectOne(RdVO inVO) throws SQLException {
		RdVO outVO = null;
		
		String statement = this.NAMESPACE+".doRdSelectOne";
		LOG.debug("=============================");
		LOG.debug("param : "+inVO.toString());
		LOG.debug("statement : "+statement);
		LOG.debug("=============================");

		outVO = sqlSessionTemplate.selectOne(statement, inVO);
		
		LOG.debug("=============================");
		LOG.debug("outVO="+outVO.toString());
		LOG.debug("=============================");
		
		return outVO;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public ReviewVO doSelectOne(ReviewVO inVO) throws SQLException{
		ReviewVO outVO = null;
		
		String statement = this.NAMESPACE+".doSelectOne";
		LOG.debug("=============================");
		LOG.debug("param : "+inVO.toString());
		LOG.debug("statement : "+statement);
		LOG.debug("=============================");

		outVO = sqlSessionTemplate.selectOne(statement, inVO);
		
		LOG.debug("=============================");
		LOG.debug("outVO="+outVO.toString());
		LOG.debug("=============================");
		
		return outVO;
	}

	@Override
	public List<ReviewRdVO> doReviewsRetrieve(Map<String, Object> inVO) throws SQLException {
		List<ReviewRdVO> outVO = null;
		
		String statement = this.NAMESPACE+".doReviewsRetrieve";
		
		LOG.debug("=============================");
		LOG.debug("param : "+inVO.toString());
		LOG.debug("statement : "+statement);
		LOG.debug("=============================");
		
		outVO = sqlSessionTemplate.selectList(statement, inVO);
		
		LOG.debug("=============================");
		LOG.debug("outVO="+outVO.toString());
		LOG.debug("=============================");
		
		return outVO;
	}

	@Override
	public int getCountAll(ProductVO inVO) throws SQLException {
		int count = 0;
		
		String statement = this.NAMESPACE+".getCountAll";
		LOG.debug("=============================");
		LOG.debug("statement : "+statement);
		LOG.debug("=============================");
		
		count = sqlSessionTemplate.selectOne(statement,inVO);
		
		LOG.debug("=============================");
		LOG.debug("count="+count);
		LOG.debug("=============================");
		
		return count;
	}

	@Override
	public int doRdInsert(RdVO inVO) throws SQLException {
		int flag = 0;
		
		String statement = NAMESPACE+".doRdInsert";
		
		LOG.debug("=============================");
		LOG.debug("param :" + inVO.toString());
		LOG.debug("statement :" + statement);
		LOG.debug("=============================");
		
		flag = sqlSessionTemplate.insert(statement,inVO);
		LOG.debug("flag : " + flag);
		
		return flag;
	}

	@Override
	public MemberVO doMemberSelect(MemberVO inVO) throws SQLException {
		MemberVO outVO = null;
		
		String statement = NAMESPACE+".doMemberSelect";
		
		LOG.debug("=============================");
		LOG.debug("param :" + inVO.toString());
		LOG.debug("statement :" + statement);
		LOG.debug("=============================");
		
		outVO = sqlSessionTemplate.selectOne(statement, inVO);
		
		LOG.debug("=============================");
		LOG.debug("outVO="+outVO.toString());
		LOG.debug("=============================");
		
		return outVO;
	}

	@Override
	public int reviewUpdate(ReviewVO inVO) throws SQLException {
		int flag = 0;
		
		String statement = NAMESPACE+".reviewUpdate";
		
		LOG.debug("=============================");
		LOG.debug("param : "+inVO.toString());
		LOG.debug("statement :" + statement);
		LOG.debug("=============================");
		
		flag = sqlSessionTemplate.update(statement, inVO);
		LOG.debug("flag: "+flag);
		
		return flag;
	}

	@Override
	public int rdUpdate(RdVO inVO) throws SQLException {
		int flag = 0;
		
		String statement = NAMESPACE+".rdUpdate";
		
		LOG.debug("=============================");
		LOG.debug("param : "+inVO.toString());
		LOG.debug("statement :" + statement);
		LOG.debug("=============================");
		
		flag = sqlSessionTemplate.update(statement, inVO);
		LOG.debug("flag: "+flag);
		
		return flag;
	}

	@Override
	public int rdDelete(RdVO inVO) throws SQLException {
		int flag = 0;
		
		String statement = NAMESPACE+".rdDelete";
		
		LOG.debug("=============================");
		LOG.debug("param : "+inVO.toString());
		LOG.debug("statement :" + statement);
		LOG.debug("=============================");
		
		flag = sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("flag: "+flag);
		
		return flag;
	}

	@Override
	public int reviewDelete(ReviewVO inVO) throws SQLException {
		int flag = 0;
		
		String statement = NAMESPACE+".reviewDelete";
		
		LOG.debug("=============================");
		LOG.debug("param : "+inVO.toString());
		LOG.debug("statement :" + statement);
		LOG.debug("=============================");
		
		flag = sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("flag: "+flag);
		
		return flag;
	}

}
