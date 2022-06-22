package com.pcwk.ctrl.review.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.KakaoMVO;

public interface ReviewService {
	
	/**
	 * 리뷰 저장
	 * @param dto
	 * @return
	 * @throws SQLException
	 */
	public int doReviewInsert(DTO dto) throws SQLException;
}
