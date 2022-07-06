package com.pcwk.ctrl.review.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.OrderVO;
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.RdVO;
import com.pcwk.ctrl.cmn.ReviewRdVO;
import com.pcwk.ctrl.cmn.ReviewVO;
import com.pcwk.ctrl.review.dao.ReviewDao;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	private ReviewDao reviewDao;

	@Override
	public int doReviewInsert(DTO dto) throws SQLException {
		return reviewDao.doReviewInsert(dto);
	}

	@Override
	public List<ReviewRdVO> doReviewsRetrieve(Map<String, Object> inVO) throws SQLException {
		return reviewDao.doReviewsRetrieve(inVO);
	}

	@Override
	public int getRdCount(RdVO inVO) throws SQLException {
		return reviewDao.getRdCount(inVO);
	}

	@Override
	public int getCount(ReviewVO inVO) throws SQLException {
		return reviewDao.getCount(inVO);
	}

	@Override
	public RdVO doRdSelectOne(RdVO inVO) throws SQLException {
		return reviewDao.doRdSelectOne(inVO);
	}

	@Override
	public ReviewVO doSelectOne(ReviewVO inVO) throws SQLException {
		return reviewDao.doSelectOne(inVO);
	}

	@Override
	public int getCountAll(ProductVO inVO) throws SQLException {
		return reviewDao.getCountAll(inVO);
	}

	@Override
	public int doRdInsert(MemberVO mInVO, RdVO rInVO) throws SQLException {
		// 1. 회원테이블 조회(관리자인지 여부)
		// 2. 관리자라면 관리자 댓글 입력
		LOG.debug("===================");
		LOG.debug("=mInVO="+mInVO);
		LOG.debug("=rInVO="+rInVO);
		LOG.debug("===================");
		
		// 1.
		MemberVO outVO = reviewDao.doMemberSelect(mInVO);
		LOG.debug("outVO.getmGrade() : " + outVO.getmGrade());
		int rdFlag = 0;
		
		// 2.
		if( outVO.getmGrade().equals("1") ) { // 관리자 1, 회원 2

			rdFlag = reviewDao.doRdInsert(rInVO); 
		}
		LOG.debug("===================");
		LOG.debug("=rdFlag="+rdFlag);
		LOG.debug("===================");
		return rdFlag;
	}

	@Override
	public MemberVO doMemberSelect(MemberVO inVO) throws SQLException {
		return reviewDao.doMemberSelect(inVO);
	}

	@Override
	public int reviewUpdate(ReviewVO inVO) throws SQLException {
		return reviewDao.reviewUpdate(inVO);
	}

	@Override
	public int rdUpdate(MemberVO mInVO, RdVO rdInVO) throws SQLException {
		// 1. 회원테이블 조회(관리자인지 여부)
		// 2. 관리자라면 관리자 댓글 수정
		
		// 1.
		MemberVO outVO = reviewDao.doMemberSelect(mInVO);
		LOG.debug("outVO.getmGrade() : " + outVO.getmGrade());
		int rdFlag = 0;
		
		// 2.
		if( outVO.getmGrade().equals("1") ) { // 관리자 1, 회원 2

			rdFlag = reviewDao.rdUpdate(rdInVO); 
		}
		LOG.debug("===================");
		LOG.debug("=rdFlag="+rdFlag);
		LOG.debug("===================");
		
		return rdFlag;
	}

	@Override
	public int rdDelete(MemberVO mInVO, RdVO rdInVO) throws SQLException {
		// 1. 회원테이블 조회(관리자인지 여부)
		// 2. 관리자라면 관리자 댓글 삭제
		
		// 1.
		MemberVO outVO = reviewDao.doMemberSelect(mInVO);
		LOG.debug("outVO.getmGrade() : " + outVO.getmGrade());
		int rdFlag = 0;
		
		// 2.
		if( outVO.getmGrade().equals("1") ) { // 관리자 1, 회원 2

			rdFlag = reviewDao.rdDelete(rdInVO); 
		}
		LOG.debug("===================");
		LOG.debug("=rdFlag="+rdFlag);
		LOG.debug("===================");
		
		return rdFlag;
	}

	@Override
	public int reviewDelete(ReviewVO rInVO, RdVO rdInVO) throws SQLException {
		// 1. review의 rnum이  rd테이블에 있는지 확인
		// 2. 있으면  review의 rnum을 가진 rd 행을 삭제
		// 3. review 삭제
		int flag = 0;
		
		rdInVO.setrNum(rInVO.getrNum());
		
		// 1. 
		int count = reviewDao.getRdCount(rdInVO);
	
		// 3.
		if(1 == count) { // rd 테이블에 값이 있다면
			int rdFlag = reviewDao.rdDelete(rdInVO); // rd 행 삭제
			
			if(1 == rdFlag) { // rd 행 삭제 성공하면
				flag = reviewDao.reviewDelete(rInVO);			
			} 
		}else { // rd 테이블에 값이 없다면
			flag = reviewDao.reviewDelete(rInVO);
		} 
		
		return flag;
	}

	
}
