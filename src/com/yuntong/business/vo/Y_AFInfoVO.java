package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 *	运时运费信息
 */
public class Y_AFInfoVO {
private int	afrerghtID;//信息编号
private int	afrerghtBegin;//起始地区编号
private String afBeginName;//其实地区名称
private String afrerghtEndName;//目的地区名称
private int	afrerghtEnd;//目的地地区编号
private int	afrerghtTime;//地区间平均运送时间(小时)
private float	afrerghtHeft;//按重量计算的运费标准(吨)
private float	afrerghtBulk;//按方量计算的运费标准（立方米）
public String getAfBeginName() {
	return afBeginName;
}
public void setAfBeginName(String afBeginName) {
	this.afBeginName = afBeginName;
}
public int getAfrerghtBegin() {
	return afrerghtBegin;
}
public void setAfrerghtBegin(int afrerghtBegin) {
	this.afrerghtBegin = afrerghtBegin;
}
public float getAfrerghtBulk() {
	return afrerghtBulk;
}
public void setAfrerghtBulk(float afrerghtBulk) {
	this.afrerghtBulk = afrerghtBulk;
}
public int getAfrerghtEnd() {
	return afrerghtEnd;
}
public void setAfrerghtEnd(int afrerghtEnd) {
	this.afrerghtEnd = afrerghtEnd;
}
public String getAfrerghtEndName() {
	return afrerghtEndName;
}
public void setAfrerghtEndName(String afrerghtEndName) {
	this.afrerghtEndName = afrerghtEndName;
}
public float getAfrerghtHeft() {
	return afrerghtHeft;
}
public void setAfrerghtHeft(float afrerghtHeft) {
	this.afrerghtHeft = afrerghtHeft;
}
public int getAfrerghtID() {
	return afrerghtID;
}
public void setAfrerghtID(int afrerghtID) {
	this.afrerghtID = afrerghtID;
}
public int getAfrerghtTime() {
	return afrerghtTime;
}
public void setAfrerghtTime(int frerghtTime) {
	afrerghtTime = frerghtTime;
}

}
