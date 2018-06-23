package com.leon.framework.util;

public class Page {
	private static int maxResult = 2147483647;
	private static int NUM_PER_PAGE_DEFAULT = 10;

	private int numPerPage = NUM_PER_PAGE_DEFAULT;
	private int curPage = 0;
	private int totalNum = 0;

	public static Page getMaxPage() {
		return new Page(getMaxResult());
	}

	public static int getMaxResult() {
		return maxResult;
	}

	public static Page getInstance(int numPerPage) {
		return new Page(numPerPage);
	}

	public Page() {
	}

	public Page(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public Page(int numPerPage, int curPage, int totalNum) {
		this.numPerPage = numPerPage;
		this.curPage = curPage;
		this.totalNum = totalNum;
	}

	public String toString() {
		return String.format("%s  %s/%s  %s", new Object[] { Integer.valueOf(getTotalNum()),
		        Integer.valueOf(getCurPage()), Integer.valueOf(getTotalPage()), Integer.valueOf(getNumPerPage()) });
	}

	public int getNumPerPage() {
		return this.numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getCurPage() {
		if (this.curPage < 1)
			this.curPage = 1;
		if (this.curPage > getTotalPage())
			this.curPage = getTotalPage();
		return this.curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotalNum() {
		return Math.min(this.totalNum, getMaxResult());
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getTrueTotalNum() {
		return this.totalNum;
	}

	public int getResultStart() {
		if (this.curPage <= 0) {
			return 0;
		}
		if (this.curPage > getTotalPage()) {
			this.curPage = getTotalPage();
		}
		if (this.curPage == 0) {
			this.curPage = 1;
		}
		return (this.numPerPage * (this.curPage - 1));
	}

	public int getTotalPage() {
		if (this.totalNum % this.numPerPage == 0) {
			return (this.totalNum / this.numPerPage);
		}
		return (this.totalNum / this.numPerPage + 1);
	}
}