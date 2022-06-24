package com.pcwk.ctrl.review.dao;

import java.sql.SQLException;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.ReviewVO;

public interface ReviewDao {
	
	/**
	 * 리뷰 저장
	 * @param dto
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doReviewInsert(DTO dto) throws SQLException;
	
	/**
	 * 리뷰 테이블 갯수 조회
	 * @param vo
	 * @return 갯수
	 * @throws SQLException
	 */
	int getCount(ReviewVO vo) throws SQLException;
	
	/**
	 * 리뷰 테이블 단건 
	 * 
	 * @param inVO
	 * @return UserVO
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	ReviewVO doSelectOne(ReviewVO inVO) throws SQLException;
}