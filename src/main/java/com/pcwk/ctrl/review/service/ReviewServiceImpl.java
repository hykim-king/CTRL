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
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.RdVO;
import com.pcwk.ctrl.cmn.ReviewRdVO;
import com.pcwk.ctrl.cmn.ReviewVO;
import com.pcwk.ctrl.cmn.SearchVO;
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
	public List<ReviewRdVO> doReviewsRetrieve(SearchVO inVO) throws SQLException {
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
	public int doRdInsert(RdVO inVO) throws SQLException {
		return reviewDao.doRdInsert(inVO);
	}

	@Override
	public MemberVO doMemberSelect(MemberVO inVO) throws SQLException {
		return reviewDao.doMemberSelect(inVO);
	}

	@Override
	public int doReviewUpdate(ReviewVO inVO) throws SQLException {
		return reviewDao.doReviewUpdate(inVO);
	}

	@Override
	public int doRdUpdate(RdVO inVO) throws SQLException {
		return reviewDao.doRdUpdate(inVO);
	}


	
}
