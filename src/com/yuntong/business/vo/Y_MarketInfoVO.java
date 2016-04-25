package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 *	市场信息封装
 */
public class Y_MarketInfoVO {
private int marketID;								//市场编号
private int marketAreaID;							//所属地区编号
private String marketName;							//市场名称
private String marketAddress;						//市场地址
private String markeyPostID;						//邮编 	
public String getMarketAddress() {
	return marketAddress;
}
public void setMarketAddress(String marketAddress) {
	this.marketAddress = marketAddress;
}
public int getMarketAreaID() {
	return marketAreaID;
}
public void setMarketAreaID(int marketAreaID) {
	this.marketAreaID = marketAreaID;
}
public int getMarketID() {
	return marketID;
}
public void setMarketID(int marketID) {
	this.marketID = marketID;
}
public String getMarketName() {
	return marketName;
}
public void setMarketName(String marketName) {
	this.marketName = marketName;
}
public String getMarkeyPostID() {
	return markeyPostID;
}
public void setMarkeyPostID(String markeyPostID) {
	this.markeyPostID = markeyPostID;
}

}
