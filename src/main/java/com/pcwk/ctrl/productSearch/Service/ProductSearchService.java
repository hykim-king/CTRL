package com.pcwk.ctrl.productSearch.Service;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.ProductVO;

public interface ProductSearchService {
	/**
	 * 목록조회 
	 * @param dto
	 * @return List<ProductVO>
	 * @throws SQLException
	 */
	List<ProductVO> doRetrieve(DTO dto) throws SQLException;
	
}
