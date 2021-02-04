package com.jdbc.model;

public class Page {
	private int pageNow = 1;// 当前页数
	private int pageOffset = 0;//  开始位置，从0开始
	private int pageSize = 10; // 每页显示记录的条数
	public int total;// 总记录条数
	private int pageCount;// 总页数

	public int getPageOffset() {
		return (getPageNow() - 1) * getPageSize();
	}


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageCount() {
		int pages = getTotal() / getPageSize();
		pages = getTotal() % getPageSize() == 0 ? pages : pages + 1;
		pageCount= pages;
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
}
