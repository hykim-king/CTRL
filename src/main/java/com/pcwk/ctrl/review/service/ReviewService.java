package com.pcwk.ctrl.review.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.OrderVO;
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.RdVO;
import com.pcwk.ctrl.cmn.ReviewRdVO;
import com.pcwk.ctrl.cmn.ReviewVO;
import com.pcwk.ctrl.cmn.SearchVO;

public interface ReviewService {
	
	/**
	 * 관리자 댓글 삭제
	 * @param mInVO, rdInVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int rdDelete(MemberVO mInVO, RdVO rdInVO) throws SQLException;
	
	/**
	 * 회원 댓글+회원 댓글의 관리자 댓글 삭제
	 * @param rInVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int reviewDelete(ReviewVO rInVO, RdVO rdInVO) throws SQLException;
	
	/**
	 * 관리자 댓글 수정
	 * @param mInVO, rdInVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int rdUpdate(MemberVO mInVO, RdVO rdInVO) throws SQLException;
	
	/**
	 * 회원 댓글 수정
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int reviewUpdate(ReviewVO inVO) throws SQLException;
	
	/**
	 * 회원 테이블 조회(param 검사)
	 * @return MemberVO
	 * @throws SQLException
	 */
	public MemberVO doMemberSelect(MemberVO inVO) throws SQLException;
	
	/**
	 * 관리자가 맞는 지 확인 후 관리자 댓글 입력
	 * @param mInVO, rInVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doRdInsert(MemberVO mInVO, RdVO rInVO) throws SQLException;
	
	/**
	 * 리뷰 테이블 전체 개수 조회
	 * @param ProductVO
	 * @return int
	 * @throws SQLException
	 */
	public int getCountAll(ProductVO inVO) throws SQLException;
	
	/**
	 * 회원 댓글 및 관리자 댓글 조회(페이징)
	 * @return List<ReviewRdVO>
	 * @throws SQLException
	 */
	public List<ReviewRdVO> doReviewsRetrieve(Map<String, Object> inVO) throws SQLException;
	
	/**
	 * 리뷰 입력
	 * @param dto
	 * @return
	 * @throws SQLException
	 */
	public int doReviewInsert(DTO dto) throws SQLException;
	
	/**
	 * 관리자 댓글 테이블 갯수 조회
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	public int getRdCount(RdVO inVO) throws SQLException;
	
	/**
	 * 리뷰 테이블 갯수 조회
	 * @param vo
	 * @return 갯수
	 * @throws SQLException
	 */
	public int getCount(ReviewVO inVO) throws SQLException;
	
	/**
	 * 관리자 댓글 테이블 단건 조회
	 * @return RdVO
	 * @throws SQLException
	 */
	public RdVO doRdSelectOne(RdVO inVO) throws SQLException;
	
	/**
	 * 리뷰 테이블 단건  조회
	 * 
	 * @param inVO
	 * @return UserVO
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ReviewVO doSelectOne(ReviewVO inVO) throws SQLException;
}
