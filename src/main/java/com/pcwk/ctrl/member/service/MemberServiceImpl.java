package com.pcwk.ctrl.member.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.MessageVO;
import com.pcwk.ctrl.member.dao.MemberDao;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	private MemberDao memberDao;
	
	
	@Override
	public List<MemberVO> doMemberInsert(MemberVO inVO) throws SQLException {
		return memberDao.doMemberInsert(inVO);
	}


	@Override
	public MessageVO memberCheck(MemberVO inVO) throws SQLException {
		//msgId: 메시지ID(회원 여부 확인)
		//10: 회원
		//20: 비회원
		MessageVO message = new MessageVO();
		if("10" == message.getMsgId()) {
			message.setMsgContents(inVO.getmName()+"님은 회원입니다.");
		}else {
			message.setMsgContents("회원 전용 서비스입니다. 로그인 후 이용하세요.");
		}
		
		return message;
	}


	@Override
	public MemberVO doSelectOne(MemberVO inVO) throws SQLException {
		return memberDao.doSelectOne(inVO);
	}


	//test
//	@Override
//	public List<MemberVO> memberCheck(MemberVO inVO) throws SQLException {
//		return memberDao.memberCheck(inVO);
//	}


}
