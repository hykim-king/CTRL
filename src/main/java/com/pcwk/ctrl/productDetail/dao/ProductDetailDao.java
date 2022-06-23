package com.pcwk.ctrl.productDetail.dao;

import com.pcwk.ctrl.cmn.ProductVO;

public interface ProductDetailDao {
	
	/**
	 * 상품 상세 페이지에 필요한 정보 셀렉
	 * @param vo
	 * @return
	 */
	ProductVO doProductDetailSelect(ProductVO vo);
}