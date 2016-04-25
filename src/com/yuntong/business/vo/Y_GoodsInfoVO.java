package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 *	货物信息封装
 */
public class Y_GoodsInfoVO {
	private int goodsID;						//货物编号(主)
	private String goodsName;					//货物名称
	private int goodsPaymentModeid;				//货款计算方式(重量或方量)编号
	private String goodsPaymentModeName;		//货款计算方式(重量或方量)名字
	private int buyStyleID;						//付费方式编号
	private String buyStyleName;				//付费方式名称
	private float goodsHeft;					//货物重量(吨)
	private float goodsBulk;					//货物方量(立方米)
	private long goodsNumber;					//货物件数
	private String goodsNumberUnit;				//件数单位
	private float goodsValue;					//货物价值
	private float goodsFreight;					//运费		
	private float goodsInsuranceValue;			//货物保价
	private String goodsRemarkInfo;				//备注信息
	public float getGoodsBulk() {
		return goodsBulk;
	}
	public void setGoodsBulk(float goodsBulk) {
		this.goodsBulk = goodsBulk;
	}
	public float getGoodsFreight() {
		return goodsFreight;
	}
	public void setGoodsFreight(float goodsFreight) {
		this.goodsFreight = goodsFreight;
	}
	public float getGoodsHeft() {
		return goodsHeft;
	}
	public void setGoodsHeft(float goodsHeft) {
		this.goodsHeft = goodsHeft;
	}
	public int getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(int goodsID) {
		this.goodsID = goodsID;
	}
	public float getGoodsInsuranceValue() {
		return goodsInsuranceValue;
	}
	public void setGoodsInsuranceValue(float goodsInsuranceValue) {
		this.goodsInsuranceValue = goodsInsuranceValue;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public long getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(long goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public String getGoodsNumberUnit() {
		return goodsNumberUnit;
	}
	public void setGoodsNumberUnit(String goodsNumberUnit) {
		this.goodsNumberUnit = goodsNumberUnit;
	}
	public int getGoodsPaymentModeid() {
		return goodsPaymentModeid;
	}
	public void setGoodsPaymentModeid(int goodsPaymentModeid) {
		this.goodsPaymentModeid = goodsPaymentModeid;
	}
	public String getGoodsPaymentModeName() {
		return goodsPaymentModeName;
	}
	public void setGoodsPaymentModeName(String goodsPaymentModeName) {
		this.goodsPaymentModeName = goodsPaymentModeName;
	}
	public String getGoodsRemarkInfo() {
		return goodsRemarkInfo;
	}
	public void setGoodsRemarkInfo(String goodsRemarkInfo) {
		this.goodsRemarkInfo = goodsRemarkInfo;
	}
	public float getGoodsValue() {
		return goodsValue;
	}
	public void setGoodsValue(float goodsValue) {
		this.goodsValue = goodsValue;
	}
	public int getBuyStyleID() {
		return buyStyleID;
	}
	public void setBuyStyleID(int buyStyleID) {
		this.buyStyleID = buyStyleID;
	}
	public String getBuyStyleName() {
		return buyStyleName;
	}
	public void setBuyStyleName(String buyStyleName) {
		this.buyStyleName = buyStyleName;
	}
}
