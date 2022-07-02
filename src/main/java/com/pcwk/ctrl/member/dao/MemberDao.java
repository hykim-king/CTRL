package com.pcwk.ctrl.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.MemberVO;

public interface MemberDao {

	/**
	 * 회원 등록
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	List<MemberVO> doMemberInsert(MemberVO inVO) throws SQLException;

	/**
	 * 회원 단건 조회
	 * @param inVO
	 * @return MemberVO
	 * @throws SQLException
	 */
	MemberVO doSelectOne(MemberVO inVO) throws SQLException;
	
	
	List<MemberVO> getAll(MemberVO inVO) throws SQLException;

	//test
//	List<MemberVO> memberCheck(MemberVO inVO) throws SQLException;

	/**
	 * member 중복 check(DB와 비교)
	 * @param inVO
	 * @return 1(mNum존재)/0(없음)
	 * @throws SQLException
	 */
	int memberCheck(MemberVO inVO) throws SQLException;
	
	
	
}
