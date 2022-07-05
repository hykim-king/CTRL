package com.pcwk.ctrl.productSearch.Service;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.productSearch.dao.ProductSearchDao;

@Service("productSearchService")
public class ProductSearchServiceImpl implements ProductSearchService {
	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	private ProductSearchDao productSearchDao;
	
	public ProductSearchServiceImpl() {}



	@Override
	public List<ProductVO> doRetrieve(DTO dto) throws SQLException {
		return productSearchDao.doRetrieve(dto);
	}
	

		
		
		
}
