package com.pcwk.ctrl.memberInfo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.MemberVO;

@Repository
public class MemberInfoDaoImpl implements MemberInfoDao {
	
	// mybatis db 연결객체
		@Autowired
		SqlSessionTemplate sqlSessionTemplate;
		
		@Override
		public List<MemberVO> memberList(MemberVO inVO){     // 호출매퍼.호출ID
			return sqlSessionTemplate.selectList("com.pcwk.ctrl.memberInfo.memberList",inVO);
		}
}
