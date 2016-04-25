package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 *	分公司信息封状
 */
public class Y_FilialeInfoVO {
private int	filialeID;        					//分公司编号
private int	filialeAreaID;					//地区编号
private String	filialeName;					//公司名
private String	filialeLinkman;					//联系人
private String	filialePhone;	           		//联系电话
private String  filialeAddress;     			//详细地址
private String	filialeEmail;		   			//电子邮箱		
public String getFilialeAddress() {
	return filialeAddress;
}
public void setFilialeAddress(String filialeAddress) {
	this.filialeAddress = filialeAddress;
}
public int getFilialeAreaID() {
	return filialeAreaID;
}
public void setFilialeAreaID(int filialeAreaID) {
	this.filialeAreaID = filialeAreaID;
}
public String getFilialeEmail() {
	return filialeEmail;
}
public void setFilialeEmail(String filialeEmail) {
	this.filialeEmail = filialeEmail;
}
public int getFilialeID() {
	return filialeID;
}
public void setFilialeID(int filialeID) {
	this.filialeID = filialeID;
}
public String getFilialeLinkman() {
	return filialeLinkman;
}
public void setFilialeLinkman(String filialeLinkman) {
	this.filialeLinkman = filialeLinkman;
}
public String getFilialeName() {
	return filialeName;
}
public void setFilialeName(String filialeName) {
	this.filialeName = filialeName;
}
public String getFilialePhone() {
	return filialePhone;
}
public void setFilialePhone(String filialePhone) {
	this.filialePhone = filialePhone;
}
}
