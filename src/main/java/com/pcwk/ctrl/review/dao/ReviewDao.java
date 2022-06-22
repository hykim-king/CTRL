package com.pcwk.ctrl.review.dao;

import java.sql.SQLException;

import com.pcwk.ctrl.cmn.DTO;

public interface ReviewDao {
	
	/**
	 * 리뷰 저장
	 * @param dto
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doReviewInsert(DTO dto) throws SQLException;
}