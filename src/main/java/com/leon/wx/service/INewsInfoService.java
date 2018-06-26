package com.leon.wx.service;

import com.leon.framework.util.QueryResult;
import com.leon.wx.bo.NewsInfo;
import com.leon.wx.condition.BaseCondition;

public interface INewsInfoService {
	void add(NewsInfo book);
	void update(NewsInfo book);
	QueryResult<NewsInfo> findWithPage(BaseCondition condition);
}
