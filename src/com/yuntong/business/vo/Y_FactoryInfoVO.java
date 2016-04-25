package com.yuntong.business.vo;

import java.util.Date;

/***
 * 
 * @author yqy
 *	厂商信息
 */
public class Y_FactoryInfoVO {
private int factoryID;						//厂家编号
private String factoryName;					//公司名
private String factoryLinkMan;				//联系人
private int factoryAreaID;					//地区编号
private String factoryAreaName;				//地区名称
private String factoryAddress;				//详细地址
private String factoryPhone;				//电话
private String factoryFax;					//传真
private String factoryPostID;				//邮政编码
private String factoryEmail;				//Email
private String factoryRemark;				//备注
private float factoryConsumption;			//累计消费金额
private String factoryDate;					//注册时间
private int factoryGradeID;					//等级编号
private String factoryGradeName;			//等级名称
private float factoryGradeRote;				//优惠比率

public float getFactoryConsumption() {
	return factoryConsumption;
}
public void setFactoryConsumption(float factoryConsumption) {
	this.factoryConsumption = factoryConsumption;
}
public String getFactoryDate() {
	return factoryDate;
}
public void setFactoryDate(String factoryDate) {
	this.factoryDate = factoryDate;
}
public int getFactoryGradeID() {
	return factoryGradeID;
}
public void setFactoryGradeID(int factoryGradeID) {
	this.factoryGradeID = factoryGradeID;
}
public String getFactoryGradeName() {
	return factoryGradeName;
}
public void setFactoryGradeName(String factoryGradeName) {
	this.factoryGradeName = factoryGradeName;
}
public float getFactoryGradeRote() {
	return factoryGradeRote;
}
public void setFactoryGradeRote(float factoryGradeRote) {
	this.factoryGradeRote = factoryGradeRote;
}
public String getFactoryAddress() {
	return factoryAddress;
}
public void setFactoryAddress(String factoryAddress) {
	this.factoryAddress = factoryAddress;
}
public int getFactoryAreaID() {
	return factoryAreaID;
}
public void setFactoryAreaID(int factoryAreaID) {
	this.factoryAreaID = factoryAreaID;
}
public String getFactoryAreaName() {
	return factoryAreaName;
}
public void setFactoryAreaName(String factoryAreaName) {
	this.factoryAreaName = factoryAreaName;
}
public String getFactoryEmail() {
	return factoryEmail;
}
public void setFactoryEmail(String factoryEmail) {
	this.factoryEmail = factoryEmail;
}
public String getFactoryFax() {
	return factoryFax;
}
public void setFactoryFax(String factoryFax) {
	this.factoryFax = factoryFax;
}
public int getFactoryID() {
	return factoryID;
}
public void setFactoryID(int factoryID) {
	this.factoryID = factoryID;
}
public String getFactoryLinkMan() {
	return factoryLinkMan;
}
public void setFactoryLinkMan(String factoryLinkMan) {
	this.factoryLinkMan = factoryLinkMan;
}
public String getFactoryName() {
	return factoryName;
}
public void setFactoryName(String factoryName) {
	this.factoryName = factoryName;
}
public String getFactoryPhone() {
	return factoryPhone;
}
public void setFactoryPhone(String factoryPhone) {
	this.factoryPhone = factoryPhone;
}
public String getFactoryPostID() {
	return factoryPostID;
}
public void setFactoryPostID(String factoryPostID) {
	this.factoryPostID = factoryPostID;
}
public String getFactoryRemark() {
	return factoryRemark;
}
public void setFactoryRemark(String factoryRemark) {
	this.factoryRemark = factoryRemark;
}
}
