package com.pcwk.ctrl.order.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.OrderListVO;
import com.pcwk.ctrl.cmn.OrderVO;
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.SearchVO;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
	
	final Logger LOG = LogManager.getLogger(this.getClass());

	//mybatis namespace
	final String NAMESPACE = "com.pcwk.ctrl.order";
	
	//mybatis db연결객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<OrderListVO> doRetrieve(DTO dto) throws SQLException {
		List<OrderListVO> list = new ArrayList<OrderListVO>();
		
		String statement = this.NAMESPACE+".doRetrieve";
		SearchVO inVO = (SearchVO)dto;
		
		list = sqlSessionTemplate.selectList(statement, inVO);
		
		for(OrderListVO vo : list) {
			LOG.debug("vo : "+vo);
		}
		
		
		return list;
	}
	
	@Override
	public int getCount(OrderListVO oVO) throws SQLException {
		int count = 0;
		
		String statement = this.NAMESPACE+".getCount";
		LOG.debug("=============================");
		LOG.debug("param : "+oVO.toString());
		LOG.debug("statement : "+statement);
		LOG.debug("=============================");
		
		count = this.sqlSessionTemplate.selectOne(statement,oVO);
		
		LOG.debug("=============================");
		LOG.debug("count="+count);
		LOG.debug("=============================");
		
		return count;
	}
}
