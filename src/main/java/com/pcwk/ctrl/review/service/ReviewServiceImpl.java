package com.pcwk.ctrl.review.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cmn.DTO;
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
	
}
