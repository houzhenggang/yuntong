package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 *	��װ�ͻ���Ϣ
 */
public class Y_ClientInfoVO {
private long	clientID;           		  //�ͻ����	
private int clientMarketID;  			  //�г����
private String clientMarketName;          //�г�����
private String clientCompany;    		  //��˾����
private String clientName;       		  //��ϵ������
private	String clientPhone;     		   //�ͻ��绰
private	String clientEmail;   				//�ͻ������ʼ�
private	String	clientPostID;          	   //��������
private	String clientAddress;     			//��ϵ��ַ
private	String clientDate;        			//��¼����ʱ��
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
