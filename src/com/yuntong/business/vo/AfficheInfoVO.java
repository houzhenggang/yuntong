package com.yuntong.business.vo;

import java.util.Date;

/***
 * 
 * @author yqy
 *	ͨ��
 */
public class AfficheInfoVO {
private int	afficheID;				//���
private int	afficheUserID;			//�����˱��
private String afficheUserName;		//����������
private String	afficheTitle;		//����
private String 	afficheInfo;		//����
private Date	afficheDateTime;	//����ʱ��
private String arricheFormatDate;	//��ʽ������ʱ��
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
