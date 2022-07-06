package com.pcwk.ctrl.memberInfo.dao;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ctrl.cmn.MemberVO;

public interface MemberInfoDao {

	/**
	 * 목록 조회
	 * @param dto
	 * @return List<MemberVO>
	 * @throws SQLException
	 */
	public List<MemberVO> memberList(MemberVO inVO);
}
