package com.pcwk.ctrl.pay.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.CartVO;
import com.pcwk.ctrl.cmn.DetailVO;
import com.pcwk.ctrl.cmn.OrderVO;

@Repository("payDao")
public class PayDaoImpl implements PayDao {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	// mybatis namespace
	final String NAMESPACE = "com.pcwk.ctrl.pay";
	
	// mybatis db연결객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public PayDaoImpl() {}
	
	@Override
	public int payOrderInsert(OrderVO inVO) throws SQLException {
		int flag = 0;
		
		String statement = NAMESPACE+".payOrderInsert";
		
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
		
		flag = sqlSessionTemplate.insert(statement,inVO);
		LOG.debug("=flag="+flag);
		
		return flag;
	}

	@Override
	public int payDetailInsert(DetailVO inVO) throws SQLException {
		int flag = 0;
		
		String statement = NAMESPACE+".payDetailInsert";
		
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
				
		flag = sqlSessionTemplate.insert(statement,inVO);
		LOG.debug("=flag="+flag);
		
		return flag;
	}

	@Override
	public OrderVO getoNum(OrderVO inVO) throws SQLException {
		OrderVO outvo = null;
		String statement = this.NAMESPACE + ".getoNum";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
		
		outvo = sqlSessionTemplate.selectOne(statement, inVO);
		
		return outvo;
	}

	@Override
	public int cartDelete(CartVO inVO) throws SQLException {
		int flag = 0;
		
		String statement = NAMESPACE+".cartDelete";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
		
		flag = sqlSessionTemplate.insert(statement,inVO);
		LOG.debug("=flag="+flag);
		
		return flag;
	}

	@Override
	public List<CartVO> cartSelect(CartVO inVO) throws SQLException {
		List<CartVO> list = null;
		String statement = NAMESPACE+".cartSelect";
		LOG.debug("==============================");
		LOG.debug("=param="+inVO.toString());
		LOG.debug("=statement="+statement);
		LOG.debug("==============================");
		
		list = this.sqlSessionTemplate.selectList(statement, inVO);
		
		for(CartVO vo :list) {
			LOG.debug("vo:" + vo.toString());
		}
		
		return list;
	}

}
