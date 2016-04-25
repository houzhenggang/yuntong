package com.yuntong.business.vo;

import java.util.Date;

/***
 * 
 * @author yqy
 *	通告
 */
public class AfficheInfoVO {
private int	afficheID;				//编号
private int	afficheUserID;			//发布人编号
private String afficheUserName;		//发布人姓名
private String	afficheTitle;		//标题
private String 	afficheInfo;		//内容
private Date	afficheDateTime;	//发布时间
private String arricheFormatDate;	//格式化发布时间
public Date getAfficheDateTime() {
	return afficheDateTime;
}
public void setAfficheDateTime(Date afficheDateTime) {
	this.afficheDateTime = afficheDateTime;
}
public int getAfficheID() {
	return afficheID;
}
public void setAfficheID(int afficheID) {
	this.afficheID = afficheID;
}
public String getAfficheInfo() {
	return afficheInfo;
}
public void setAfficheInfo(String afficheInfo) {
	this.afficheInfo = afficheInfo;
}
public String getAfficheTitle() {
	return afficheTitle;
}
public void setAfficheTitle(String afficheTitle) {
	this.afficheTitle = afficheTitle;
}
public int getAfficheUserID() {
	return afficheUserID;
}
public void setAfficheUserID(int afficheUserID) {
	this.afficheUserID = afficheUserID;
}
public String getAfficheUserName() {
	return afficheUserName;
}
public void setAfficheUserName(String afficheUserName) {
	this.afficheUserName = afficheUserName;
}
public String getArricheFormatDate() {
	return arricheFormatDate;
}
public void setArricheFormatDate(String arricheFormatDate) {
	this.arricheFormatDate = arricheFormatDate;
}
}
