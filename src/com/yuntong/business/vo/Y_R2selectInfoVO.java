package com.yuntong.business.vo;

import java.util.Date;

/**
 * 
 * @author yqy
 *	��װδ����Ʊ�߼���ѯ����
 */
public class Y_R2selectInfoVO {
private int clientID;			//�ͻ����
private int factroyID;			//���̱��
private int freightID;			//���㷽ʽ���
private Date insertDate;		//ʱ��
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
