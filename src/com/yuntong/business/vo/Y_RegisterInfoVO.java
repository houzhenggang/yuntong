package com.yuntong.business.vo;

import java.util.Date;

/***
 * 
 * @author yqy
 *	��Ʊ��Ϣ��װ
 */
public class Y_RegisterInfoVO {

private int	registerID;						//��Ʊ���
private long	registerGlideID;				//����ˮ��
private int	registerFactoryID;				//���ұ��
private long registerClientID;				//�ͻ����
private String	registerConveyanceID;		//(�Զ�����)������(�ͻ����+��ˮ��+����)
private String	registerLine;				//������·�����ݿͻ����ǰ��λ�Զ����ɣ�
private int	RegisterFreightID;				//�˷ѽ��㷽ʽ���
private String	RegisterPayerName;			//���������� 
private int	registerUserID;					//����Ա���
private Date	registerDate;				//�Ƶ�ʱ��
private String strDate ;                    //��ʽ��ʱ��
private int	registerState;					//״̬���
private String	RegisterRemark;				//��ע

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
