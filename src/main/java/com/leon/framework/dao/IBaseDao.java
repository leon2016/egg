package com.leon.framework.dao;

import java.util.List;
import java.util.Map;

import com.leon.framework.util.QueryResult;

public abstract interface IBaseDao<T> {

	String save(T entity);

	void delete(String id);

	void update(T entity);

	int update(String hql, Object... field);

	T getById(String id);

	List<T> findAll();

	List<T> findByIds(String[] ids);

	int getTotalCount();

	QueryResult<Object> findByJPQLWithPage(String hql, String countHQL, Map<String, Object> parameterMap, int pageNo,
	        int pageSize);

}