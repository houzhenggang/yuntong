package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 *	�г���Ϣ��װ
 */
public class Y_MarketInfoVO {
private int marketID;								//�г����
private int marketAreaID;							//�����������
private String marketName;							//�г�����
private String marketAddress;						//�г���ַ
private String markeyPostID;						//�ʱ� 	
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
