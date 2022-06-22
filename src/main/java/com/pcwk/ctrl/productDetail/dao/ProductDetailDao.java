package com.pcwk.ctrl.productDetail.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.productDetail.domain.ProductVO;

public interface ProductDetailDao {
	
	/**
	 * 상품 상세 페이지에 필요한 정보 셀렉
	 * @param vo
	 * @return
	 */
	ProductVO doProductDetailSelect(ProductVO vo);
}