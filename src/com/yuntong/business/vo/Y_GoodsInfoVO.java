package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 *	������Ϣ��װ
 */
public class Y_GoodsInfoVO {
	private int goodsID;						//������(��)
	private String goodsName;					//��������
	private int goodsPaymentModeid;				//������㷽ʽ(��������)���
	private String goodsPaymentModeName;		//������㷽ʽ(��������)����
	private int buyStyleID;						//���ѷ�ʽ���
	private String buyStyleName;				//���ѷ�ʽ����
	private float goodsHeft;					//��������(��)
	private float goodsBulk;					//���﷽��(������)
	private long goodsNumber;					//�������
	private String goodsNumberUnit;				//������λ
	private float goodsValue;					//�����ֵ
	private float goodsFreight;					//�˷�		
	private float goodsInsuranceValue;			//���ﱣ��
	private String goodsRemarkInfo;				//��ע��Ϣ
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
