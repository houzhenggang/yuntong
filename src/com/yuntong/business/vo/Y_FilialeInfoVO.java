package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 *	�ֹ�˾��Ϣ��״
 */
public class Y_FilialeInfoVO {
private int	filialeID;        					//�ֹ�˾���
private int	filialeAreaID;					//�������
private String	filialeName;					//��˾��
private String	filialeLinkman;					//��ϵ��
private String	filialePhone;	           		//��ϵ�绰
private String  filialeAddress;     			//��ϸ��ַ
private String	filialeEmail;		   			//��������		
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
