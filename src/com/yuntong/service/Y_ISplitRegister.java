package com.yuntong.service;

import java.util.Date;
import java.util.List;

/***
 * 
 * @author yqy
 *	货票分页
 */
public interface Y_ISplitRegister {
	//总页数
	public int getPageNum(int pageSize);
	//当前页信息
	public List findSplitRegisterInfo(int pageSize,int curPage);
	//未估货票精确查询
	public List findRegisterByIDAndRunID(long inputID,int inputType);
	//得到所有厂商信息
	public List findAllClientInfo();
	//得到所有客户信息
	public List findAllFactoryInfo();
	//范围查询总页数
	public int getPageNum(int pageSize,int clientID,int factroyID,int freightID,Date insertDate);
	//范围查询当前页信息
	public List findSplitRegisterInfo(int pageSize,int curPage,int clientID,int factroyID,int freightID,Date insertDate);
	//根据编号删除货票
	public void deleteRegisterByID(int rid);
}
