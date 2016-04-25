package com.yuntong.business.vo;

import java.util.Date;

/***
 * 
 * @author yqy
 *	货票信息封装
 */
public class Y_RegisterInfoVO {

private int	registerID;						//货票编号
private long	registerGlideID;				//日流水号
private int	registerFactoryID;				//厂家编号
private long registerClientID;				//客户编号
private String	registerConveyanceID;		//(自动生成)运输编号(客户编号+流水号+件数)
private String	registerLine;				//运输线路（根据客户编号前四位自动生成）
private int	RegisterFreightID;				//运费结算方式编号
private String	RegisterPayerName;			//付款人姓名 
private int	registerUserID;					//操作员编号
private Date	registerDate;				//制单时间
private String strDate ;                    //格式化时间
private int	registerState;					//状态编号
private String	RegisterRemark;				//备注

public long getRegisterClientID() {
	return registerClientID;
}
public void setRegisterClientID(long registerClientID) {
	this.registerClientID = registerClientID;
}
public String getRegisterConveyanceID() {
	return registerConveyanceID;
}
public void setRegisterConveyanceID(String registerConveyanceID) {
	this.registerConveyanceID = registerConveyanceID;
}
public Date getRegisterDate() {
	return registerDate;
}
public void setRegisterDate(Date registerDate) {
	this.registerDate = registerDate;
}
public int getRegisterFactoryID() {
	return registerFactoryID;
}
public void setRegisterFactoryID(int registerFactoryID) {
	this.registerFactoryID = registerFactoryID;
}
public int getRegisterFreightID() {
	return RegisterFreightID;
}
public void setRegisterFreightID(int registerFreightID) {
	RegisterFreightID = registerFreightID;
}
public long getRegisterGlideID() {
	return registerGlideID;
}
public void setRegisterGlideID(long registerGlideID) {
	this.registerGlideID = registerGlideID;
}
public int getRegisterID() {
	return registerID;
}
public void setRegisterID(int registerID) {
	this.registerID = registerID;
}
public String getRegisterLine() {
	return registerLine;
}
public void setRegisterLine(String registerLine) {
	this.registerLine = registerLine;
}
public String getRegisterPayerName() {
	return RegisterPayerName;
}
public void setRegisterPayerName(String registerPayerName) {
	RegisterPayerName = registerPayerName;
}
public String getRegisterRemark() {
	return RegisterRemark;
}
public void setRegisterRemark(String registerRemark) {
	RegisterRemark = registerRemark;
}
public int getRegisterState() {
	return registerState;
}
public void setRegisterState(int registerState) {
	this.registerState = registerState;
}
public int getRegisterUserID() {
	return registerUserID;
}
public void setRegisterUserID(int registerUserID) {
	this.registerUserID = registerUserID;
}
public String getStrDate() {
	return strDate;
}
public void setStrDate(String strDate) {
	this.strDate = strDate;
}

}
