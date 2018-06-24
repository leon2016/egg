package com.leon.wx.dao;

import com.leon.framework.dao.IBaseDao;
import com.leon.framework.util.QueryResult;
import com.leon.wx.bo.NewsInfo;
import com.leon.wx.condition.BaseCondition;

public interface INewsInfoDao extends IBaseDao<NewsInfo> {
	QueryResult<NewsInfo> findWithPage(BaseCondition condition);
}
