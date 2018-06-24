package com.leon.framework.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leon.framework.dao.IBaseDao;
import com.leon.framework.enums.ErrorCode;
import com.leon.framework.exception.EggException;
import com.leon.framework.util.QueryResult;

@Repository
public abstract class BaseDao<T> implements IBaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;

	protected Class<T> clazz;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDao() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) type.getActualTypeArguments()[0];
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public String save(T entity) {
		String id = (String) getSession().save(entity);
		return id;
	}

	@Override
	public void delete(String id) {
		Object object = (Object) getSession().get(clazz, id);
		getSession().delete(object);
	}
	@Override
	public void merge(T entity) {
		getSession().merge(entity);
	}
	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public int update(String hql, Object... field) {
		System.out.println(hql);
		for (Object obj : field) {
			System.out.println(obj);
		}
		Query query = getSession().createQuery(hql);
		if (field.length != 0) {
			for (int i = 0; i < field.length; i++) {
				query.setParameter(i, field[i]);
			}
		}
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(String id) {
		return (T) getSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getSession().createQuery("from " + clazz.getSimpleName()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByIds(String[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		}
		return getSession().createQuery("FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)")
		        .setParameterList("ids", ids).list();
	}

	@Override
	public int getTotalCount() {
		int totalCount = ((Long) getSession().createQuery("select count(*) from " + clazz.getSimpleName()).list()
		        .get(0)).intValue();
		return totalCount;
	}

	public int countByHQL(String countHQL, Map<String, Object> parameterMap) {
		try {
			Query query = getSession().createQuery(countHQL);
			this.setParameters(query, parameterMap);
			return Integer.parseInt(query.list().get(0).toString());
		} catch (HibernateException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 根据JPQL语句分页查询，返回页对象
	 * 
	 * @param hql
	 *            查询语句
	 * @param countHQL
	 *            记录总数查询语句
	 * @param parameterMap
	 *            参数集合
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            每页记录数
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public QueryResult<T> findByJPQLWithPage(String hql, String countHQL, Map<String, Object> parameterMap,
	        int pageNo, int pageSize) {
		if (StringUtils.isBlank(hql)) {
			throw new EggException(ErrorCode.DATA_QUERY_ERROR, "查询语句不能为空");
		}
		try {
			long count = this.countByHQL(countHQL, parameterMap);

			if (count == 0) {
				return new QueryResult<T>(new ArrayList(), count, pageNo, pageSize);
			}

			if (pageNo < 1) {
				pageNo = 1;
			}
			if (pageSize < 1) {
				pageSize = 10;
			}
			Query query = getSession().createQuery(hql);
			this.setParameters(query, parameterMap);
			// 设置查询结果的结束记录数
			int maxResults = pageSize;
			query.setMaxResults(maxResults);
			// 设置查询结果的开始记录数（从0开始计数）
			int firstResult = (pageNo - 1) * pageSize;
			query.setFirstResult(firstResult);
			return new QueryResult<T>(query.list(), count, pageNo, pageSize);
		} catch (HibernateException ex) {
			throw new EggException(ErrorCode.DATA_QUERY_ERROR, ex);
		}
	}

	/**
	 * 内部方法，设置参数
	 * 
	 * @param query
	 * @param parameterMap
	 */
	private void setParameters(Query query, Map<String, Object> parameterMap) {
		if (parameterMap != null) {
			for (String parameterName : parameterMap.keySet()) {
				Object parameterValue = parameterMap.get(parameterName);
				query.setParameter(parameterName, parameterValue);
			}
		}
	}
}