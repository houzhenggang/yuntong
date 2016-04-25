package com.yuntong.business.vo;

import java.util.Date;

/**
 * 
 * @author yqy
 *	封装未估货票高级查询条件
 */
public class Y_R2selectInfoVO {
private int clientID;			//客户编号
private int factroyID;			//厂商编号
private int freightID;			//结算方式编号
private Date insertDate;		//时间
public int getClientID() {
	return clientID;
}
public void setClientID(int clientID) {
	this.clientID = clientID;
}
public int getFactroyID() {
	return factroyID;
}
public void setFactroyID(int factroyID) {
	this.factroyID = factroyID;
}
public int getFreightID() {
	return freightID;
}
public void setFreightID(int freightID) {
	this.freightID = freightID;
}
public Date getInsertDate() {
	return insertDate;
}
public void setInsertDate(Date insertDate) {
	this.insertDate = insertDate;
}
}
