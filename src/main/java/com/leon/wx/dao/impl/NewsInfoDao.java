package com.leon.wx.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.leon.framework.dao.impl.BaseDao;
import com.leon.framework.util.QueryResult;
import com.leon.wx.bo.NewsInfo;
import com.leon.wx.condition.BaseCondition;
import com.leon.wx.dao.INewsInfoDao;

@Repository
public class NewsInfoDao extends BaseDao<NewsInfo> implements INewsInfoDao {

	@Override
	public QueryResult<NewsInfo> findWithPage(BaseCondition condition) {
		StringBuffer hql = new StringBuffer("from NewsInfo t where 1=1 ");
		// 添加条件
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		if (condition.getStartTime() != null) {
			hql.append("and t.startTime >= :startTime ");
			parameterMap.put("startTime", condition.getStartTime());
		}
		if (condition.getEndTime() != null) {
			hql.append("and t.endTime <= :endTime ");
			parameterMap.put("endTime", condition.getEndTime());
		}
		if (StringUtils.isNoneBlank(condition.getTitle())) {
			hql.append("and t.title like :title ");
			parameterMap.put("title", "%" + condition.getTitle() + "%");
		}

		String countHQL = "select count(*) " + hql;
		hql.append("order by t.create_time desc, t.startTime asc ");

		return this.findByJPQLWithPage(hql.toString(), countHQL, parameterMap, condition.getPageNo(),
		        condition.getPageSize());
	}

}
