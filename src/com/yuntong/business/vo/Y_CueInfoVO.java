package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 *	鼠标提示封装
 */
public class Y_CueInfoVO {
private int	cueID;//编号
private String 	cuePlace;//连接或按钮位置
private String 	CueName;//连接或按钮名称
private String	CueInfo;//提示信息内容
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
