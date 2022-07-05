package com.pcwk.ctrl.productSearch.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.SearchVO;

@Repository("ProductSearchDao")
public class ProductSearchDaoImpl implements ProductSearchDao {

	final Logger LOG = LogManager.getLogger(this.getClass());
	
	//mybatis namespace
	final String NAVESPACE ="com.pcwk.ctrl.productSearch";
	
	//mybatis db연결객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<ProductVO> doRetrieve(DTO dto) throws SQLException {
		List<ProductVO> list =new ArrayList<ProductVO>();
        String statement = NAVESPACE+".doRetrieve";
        SearchVO   inVO = (SearchVO) dto;
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("statement:" + statement);
		LOG.debug("==============================");        
		
		list = sqlSessionTemplate.selectList(statement, inVO);
        
		for(ProductVO vo :list) {
			LOG.debug(vo);
		}
		
		return list;	
		
	}

}
