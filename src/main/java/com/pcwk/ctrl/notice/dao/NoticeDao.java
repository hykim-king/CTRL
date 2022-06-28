package com.pcwk.ctrl.notice.dao;

import java.util.List;

import com.pcwk.ctrl.cmn.NoticeVO;

public interface NoticeDao {

	List<NoticeVO> doNoticeSelect();
}