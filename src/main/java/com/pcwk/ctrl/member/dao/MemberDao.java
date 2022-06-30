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
	
	
	/**
	 * 목록조회 
	 * @param dto
	 * @return List<MemberVO>
	 * @throws SQLException
	 */
	List<MemberVO> doRetrieve(DTO dto) throws SQLException;
	
	List<MemberVO> getAll(MemberVO inVO);
	
	
}
