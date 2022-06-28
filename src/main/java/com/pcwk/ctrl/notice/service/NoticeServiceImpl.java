package com.pcwk.ctrl.notice.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cmn.NoticeVO;
import com.pcwk.ctrl.notice.dao.NoticeDao;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	private NoticeDao noticedDao;

	@Override
	public List<NoticeVO> doNoticeSelect() {
		
		return noticedDao.doNoticeSelect();
	}

}