package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 *	�����ʾ��װ
 */
public class Y_CueInfoVO {
private int	cueID;//���
private String 	cuePlace;//���ӻ�ťλ��
private String 	CueName;//���ӻ�ť����
private String	CueInfo;//��ʾ��Ϣ����
public int getCueID() {
	return cueID;
}
public void setCueID(int cueID) {
	this.cueID = cueID;
}
public String getCueInfo() {
	return CueInfo;
}
public void setCueInfo(String cueInfo) {
	CueInfo = cueInfo;
}
public String getCueName() {
	return CueName;
}
public void setCueName(String cueName) {
	CueName = cueName;
}
public String getCuePlace() {
	return cuePlace;
}
public void setCuePlace(String cuePlace) {
	this.cuePlace = cuePlace;
}
}
