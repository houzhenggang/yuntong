package com.yuntong.business.vo;

public class G_RegisterAndGoodsInfoVO {
	private long  registerGlideID;				//日流水号
	private String goodsName;  //货物名称
	private String goodsNumberUnit; //数量单位
	private long goodsNumber;  //货物数量
	private float goodsHeft;//货物重量
	private float goodsBulk;//货物方量
	private int registerState;//货票状态(省际运输(1)或者时常配送(2))
	public float getGoodsBulk() {
		return goodsBulk;
	}
	public void setGoodsBulk(float goodsBulk) {
		this.goodsBulk = goodsBulk;
	}
	public float getGoodsHeft() {
		return goodsHeft;
	}
	public void setGoodsHeft(float goodsHeft) {
		this.goodsHeft = goodsHeft;
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
	public long getRegisterGlideID() {
		return registerGlideID;
	}
	public void setRegisterGlideID(long registerGlideID) {
		this.registerGlideID = registerGlideID;
	}
	public int getRegisterState() {
		return registerState;
	}
	public void setRegisterState(int registerState) {
		this.registerState = registerState;
	}
}
