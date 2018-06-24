package com.leon.wx.service;

import com.leon.wx.bo.NewsInfo;
import com.leon.wx.condition.BaseCondition;

public interface INewsInfoService {
	void add(NewsInfo book);
	void update(NewsInfo book);
	void findWithPage(BaseCondition condition);
}
