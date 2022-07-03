package com.pcwk.ctrl.memberInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.memberInfo.dao.MemberInfoDaoImpl;

@Service
public class MemberInfoServiceImpl implements MemberInfoService {

	@Autowired
	MemberInfoDaoImpl my_pageDao;
	
	@Override
	public List<MemberVO> memberList(){
		return my_pageDao.memberList();
	}
	
}
