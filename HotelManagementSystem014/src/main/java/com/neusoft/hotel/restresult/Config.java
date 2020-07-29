package com.neusoft.hotel.restresult;

public class Config {
	// 总数
	private int count=0;
	
	// 页的总数
	private int pageCount=0;
	
	// 一页的行数
	private int rows=0;
	
	// 当前页
	private int page=0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
