package com.pcwk.ctrl.productDetail.service;

import com.pcwk.ctrl.productDetail.domain.ProductVO;

public interface ProductDetailService {
	
	/**
	 * 상품 상세 페이지에 필요한 정보 셀렉
	 * @param vo
	 * @return
	 */
	public ProductVO doProductDetailSelect(ProductVO vo);
}
