package com.yuntong.business.vo;

public class G_RegisterAndGoodsInfoVO {
	private long  registerGlideID;				//����ˮ��
	private String goodsName;  //��������
	private String goodsNumberUnit; //������λ
	private long goodsNumber;  //��������
	private float goodsHeft;//��������
	private float goodsBulk;//���﷽��
	private int registerState;//��Ʊ״̬(ʡ������(1)����ʱ������(2))
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
