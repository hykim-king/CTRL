package com.pcwk.ctrl.naver.service;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.naver.Item;

public interface NaverProfileService {

	/**
	 * 네이버 프로필정보 조회 
	 * @param accessToken
	 * @return
	 * @throws SQLException
	 */
	MemberVO doMemberInsert(String accessToken) throws SQLException, NullPointerException;
	
	
	/**
	 * member 중복 check(DB와 비교)
	 * @param inVO
	 * @return 1(mNum존재)/0(없음)
	 * @throws SQLException
	 */
	public int memberCheck(MemberVO inVO) throws SQLException;

}

