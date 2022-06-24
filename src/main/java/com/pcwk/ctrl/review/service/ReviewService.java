package com.pcwk.ctrl.review.service;

import java.sql.SQLException;

import com.pcwk.ctrl.cmn.DTO;

public interface ReviewService {
	
	/**
	 * 리뷰 저장
	 * @param dto
	 * @return
	 * @throws SQLException
	 */
	public int doReviewInsert(DTO dto) throws SQLException;
}
