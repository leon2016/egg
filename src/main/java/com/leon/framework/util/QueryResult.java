package com.leon.framework.util;

import java.util.ArrayList;
import java.util.List;

public class QueryResult<T> {
	private List<T> resultList;
	private Long totalRecord;
	private Integer pageSize;
	private Integer currPageNo;
	private Long pageCount;

	public List<T> getResultList() {
		return this.resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public Long getTotalRecord() {
		return this.totalRecord;
	}

	public void setTotalRecord(Long totalRecord) {
		this.totalRecord = totalRecord;
		calculatePageCount();
	}

	public static Integer calculateFirstResult(Integer pageSize, Integer currpageNo) {
		if ((pageSize != null) && (currpageNo != null)) {
			Integer pageNo = Integer.valueOf(currpageNo.intValue() - 1);
			return Integer.valueOf(pageSize.intValue() * pageNo.intValue());
		}
		return null;
	}

	public void calculateCurrPageNo(Integer firstResultNo) {
		if (this.currPageNo != null)
			return;
		this.currPageNo = Integer.valueOf(firstResultNo.intValue() / this.pageSize.intValue());
		if (firstResultNo.intValue() % this.pageSize.intValue() > 0) {
			QueryResult tmp43_42 = this;
			tmp43_42.currPageNo = Integer.valueOf(tmp43_42.currPageNo.intValue() + 1);
		}
	}

	private void calculatePageCount() {
		this.pageCount = Long.valueOf(this.totalRecord.longValue() / this.pageSize.intValue());
		if (this.totalRecord.longValue() % this.pageSize.intValue() != 0L) {
			QueryResult tmp45_44 = this;
			tmp45_44.pageCount = Long.valueOf(tmp45_44.pageCount.longValue() + 1L);
		}
	}

	public Integer getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPageCount() {
		return this.pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getCurrPageNo() {
		return this.currPageNo;
	}

	public void setCurrPageNo(Integer currPageNo) {
		this.currPageNo = currPageNo;
	}

	public QueryResult() {
	}

	public QueryResult(List<T> resultList, long totalRecord, int currPageNo, int pageSize) {
		this.resultList = ((resultList == null) ? new ArrayList() : resultList);
		this.totalRecord = Long.valueOf(totalRecord);
		this.currPageNo = Integer.valueOf(currPageNo);
		this.pageSize = Integer.valueOf(pageSize);
		this.pageCount = Long.valueOf((totalRecord + pageSize - 1L) / pageSize);
	}

	public String toString() {
		return String.format("QueryResult [resultList=%s, totalRecord=%s, pageSize=%s, currPageNo=%s, pageCount=%s]",
		        new Object[] { this.resultList, this.totalRecord, this.pageSize, this.currPageNo, this.pageCount });
	}
}
