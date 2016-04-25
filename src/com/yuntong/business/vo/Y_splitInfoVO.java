package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 *	封装分页信息
 */
public class Y_splitInfoVO {
	private int curPage;  //当前页
	private int pageNum;  //总页数
	private int pageSize; //每页大小
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
