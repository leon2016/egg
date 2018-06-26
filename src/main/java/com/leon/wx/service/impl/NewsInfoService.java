package com.leon.wx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leon.framework.util.QueryResult;
import com.leon.wx.bo.NewsInfo;
import com.leon.wx.condition.BaseCondition;
import com.leon.wx.dao.INewsInfoDao;
import com.leon.wx.service.INewsInfoService;

@Service
public class NewsInfoService implements INewsInfoService {

	@Autowired
	private INewsInfoDao newsInfoDao;

	@Override
	public void add(NewsInfo book) {
		newsInfoDao.save(book);
	}

	@Override
	public void update(NewsInfo book) {
		newsInfoDao.update(book);
	}

	@Override
	public QueryResult<NewsInfo> findWithPage(BaseCondition condition) {
		return newsInfoDao.findWithPage(condition);
	}

}
