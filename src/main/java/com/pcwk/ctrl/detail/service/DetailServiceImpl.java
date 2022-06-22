package com.pcwk.ctrl.detail.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.detail.dao.DetailDao;
import com.pcwk.ctrl.review.dao.ReviewDao;

@Service("detailService")
public class DetailServiceImpl implements DetailService {

	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	private DetailDao detailDao;

	
}
