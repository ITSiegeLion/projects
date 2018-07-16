package com.ssm.store.entity;

import java.util.List;

/**
 * 分页属性类
 * @author liusf
 *
 */
public class PageBean {
	private int currPage;	//当前页
	private int allPage;	//总页数
	private int showRow;	//每页显示记录数
	private int allRow;		//总记录数
	
	private List showResult;	//当前页要显示的记录

	public PageBean() {
	}
	
	public PageBean(int currPage, int allPage, int showRow, int allRow, List showResult) {
		super();
		this.currPage = currPage;
		this.allPage = allPage;
		this.showRow = showRow;
		this.allRow = allRow;
		this.showResult = showResult;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public int getShowRow() {
		return showRow;
	}

	public void setShowRow(int showRow) {
		this.showRow = showRow;
	}

	public int getAllRow() {
		return allRow;
	}
	
	//根据总记录数计算总页数
	public void setAllRow(int allRow) {
		if(this.allRow%this.showRow==0) {
			this.allPage = this.allRow/this.showRow;
		}else {
			this.allPage = this.allRow/this.showRow+1;
		}
		this.allRow = allRow;
	}

	public List getShowResult() {
		return showResult;
	}

	public void setShowResult(List showResult) {
		this.showResult = showResult;
	}
	
	
	
}
