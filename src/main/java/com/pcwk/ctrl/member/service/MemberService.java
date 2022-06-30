package com.pcwk.ctrl.member.service;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.MessageVO;

public interface MemberService {

	/**
	 * 회원 등록
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	 List<MemberVO> doMemberInsert(MemberVO inVO) throws SQLException;
	
	/**
	 * 회원 여부 확인
	 * @param inVO
	 * @return MessageVO
	 * @throws SQLException
	 */
	public MessageVO memberCheck(MemberVO inVO) throws SQLException;
	
	
	/**
	 * 회원 단건 조회
	 * @param inVO
	 * @return MemberVO
	 * @throws SQLException
	 */
	public MemberVO doSelectOne(MemberVO inVO) throws SQLException;
	
	

	
}
