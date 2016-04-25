package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 *	封装客户信息
 */
public class Y_ClientInfoVO {
private long	clientID;           		  //客户编号	
private int clientMarketID;  			  //市场编号
private String clientMarketName;          //市场名称
private String clientCompany;    		  //公司名称
private String clientName;       		  //联系人姓名
private	String clientPhone;     		   //客户电话
private	String clientEmail;   				//客户电子邮件
private	String	clientPostID;          	   //邮政编码
private	String clientAddress;     			//联系地址
private	String clientDate;        			//记录插入时间
public String getClientAddress() {
	return clientAddress;
}
public void setClientAddress(String clientAddress) {
	this.clientAddress = clientAddress;
}
public String getClientCompany() {
	return clientCompany;
}
public void setClientCompany(String clientCompany) {
	this.clientCompany = clientCompany;
}
public String getClientDate() {
	return clientDate;
}
public void setClientDate(String clientDate) {
	this.clientDate = clientDate;
}
public String getClientEmail() {
	return clientEmail;
}
public void setClientEmail(String clientEmail) {
	this.clientEmail = clientEmail;
}
public long getClientID() {
	return clientID;
}
public void setClientID(long clientID) {
	this.clientID = clientID;
}
public int getClientMarketID() {
	return clientMarketID;
}
public void setClientMarketID(int clientMarketID) {
	this.clientMarketID = clientMarketID;
}
public String getClientMarketName() {
	return clientMarketName;
}
public void setClientMarketName(String clientMarketName) {
	this.clientMarketName = clientMarketName;
}
public String getClientName() {
	return clientName;
}
public void setClientName(String clientName) {
	this.clientName = clientName;
}
public String getClientPhone() {
	return clientPhone;
}
public void setClientPhone(String clientPhone) {
	this.clientPhone = clientPhone;
}
public String getClientPostID() {
	return clientPostID;
}
public void setClientPostID(String clientPostID) {
	this.clientPostID = clientPostID;
}

	
}
