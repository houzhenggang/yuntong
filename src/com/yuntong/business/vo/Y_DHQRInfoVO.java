package com.yuntong.business.vo;

import java.util.Date;

/***
 * 
 * @author yqy
 *	��װ����ȷ��ʱ��Ʊ��Ϣ
 */
public class Y_DHQRInfoVO {
	//��Ʊ
	private int	registerID=0;						//��Ʊ���
	private long	registerGlideID=0;				//����ˮ��
	private String	registerFactoryName="";				//��������
	private String registerFactoryphone="";            //���ҵ绰
	private String registerClientName="";				//�ͻ�����
	private String registerClientPhone="";				//�ͻ��绰
	private String	registerConveyanceID="";		//(�Զ�����)������(�ͻ����+��ˮ��+����)
	private String	registerLine="";				//������·�����ݿͻ����ǰ��λ�Զ����ɣ�
	private int	registerFreightID=0;				//�˷ѽ��㷽ʽ���
	private String registerFreightName="";			//���㷽ʽ����
	private String	registerPayerName="";			//���������� 
	private int	registerUserID=0;					//����Ա���
	private Date	registerDate;				//�Ƶ�ʱ��
	private String strDate ="";                    //��ʽ��ʱ��
	private int	registerState=0;					//״̬���
	private String	RegisterRemark="";				//��ע
	//����
	private int goodsID=0;						//������(��)
	private String goodsName="";					//��������
	private int goodsPaymentModeid=0;				//������㷽ʽ(��������)���
	private String goodsPaymentModeName="";		//������㷽ʽ(��������)����
	private int buyStyleID=0;						//���ѷ�ʽ���
	private String buyStyleName="";				//���ѷ�ʽ����
	private float goodsHeft=0;					//��������(��)
	private float goodsBulk=0;					//���﷽��(������)
	private long goodsNumber=0;					//�������
	private String goodsNumberUnit="";				//������λ
	private float goodsValue=0;					//�����ֵ
	private float goodsFreight=0;					//�˷�		
	private float goodsInsuranceValue=0;			//���ﱣ��
	private double goodsAllValue=0;				//�ϼ�
	private String goodsRemarkInfo="";				//��ע��Ϣ
	//����
	private int catId;								//�������
	private int driverId;							//˾�����
	private int roadwayID;							//���α��
	private String driverName="";					//˾������
	private String carName;						//���ƺ���
	private Date startDate;						//����ʱ��
	private String formatStartDate;				//��ʽ������ʱ��
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
	
	public String getRegisterConveyanceID() {
		return registerConveyanceID;
	}
	public void setRegisterConveyanceID(String registerConveyanceID) {
		this.registerConveyanceID = registerConveyanceID;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	
	public long getRegisterGlideID() {
		return registerGlideID;
	}
	public void setRegisterGlideID(long registerGlideID) {
		this.registerGlideID = registerGlideID;
	}
	public int getRegisterID() {
		return registerID;
	}
	public void setRegisterID(int registerID) {
		this.registerID = registerID;
	}
	public String getRegisterLine() {
		return registerLine;
	}
	public void setRegisterLine(String registerLine) {
		this.registerLine = registerLine;
	}
	
	public String getRegisterRemark() {
		return RegisterRemark;
	}
	public void setRegisterRemark(String registerRemark) {
		RegisterRemark = registerRemark;
	}
	public int getRegisterState() {
		return registerState;
	}
	public void setRegisterState(int registerState) {
		this.registerState = registerState;
	}
	public int getRegisterUserID() {
		return registerUserID;
	}
	public void setRegisterUserID(int registerUserID) {
		this.registerUserID = registerUserID;
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getRegisterClientName() {
		return registerClientName;
	}
	public void setRegisterClientName(String registerClientName) {
		this.registerClientName = registerClientName;
	}
	public String getRegisterClientPhone() {
		return registerClientPhone;
	}
	public void setRegisterClientPhone(String registerClientPhone) {
		this.registerClientPhone = registerClientPhone;
	}
	public String getRegisterFactoryName() {
		return registerFactoryName;
	}
	public void setRegisterFactoryName(String registerFactoryName) {
		this.registerFactoryName = registerFactoryName;
	}
	public String getRegisterFactoryphone() {
		return registerFactoryphone;
	}
	public void setRegisterFactoryphone(String registerFactoryphone) {
		this.registerFactoryphone = registerFactoryphone;
	}
	
	public double getGoodsAllValue() {
		return goodsAllValue;
	}
	public void setGoodsAllValue(double goodsAllValue) {
		this.goodsAllValue = goodsAllValue;
	}
	public int getRegisterFreightID() {
		return registerFreightID;
	}
	public void setRegisterFreightID(int registerFreightID) {
		this.registerFreightID = registerFreightID;
	}
	public String getRegisterFreightName() {
		return registerFreightName;
	}
	public void setRegisterFreightName(String registerFreightName) {
		this.registerFreightName = registerFreightName;
	}
	public String getRegisterPayerName() {
		return registerPayerName;
	}
	public void setRegisterPayerName(String registerPayerName) {
		this.registerPayerName = registerPayerName;
	}
	public String getFormatStartDate() {
		return formatStartDate;
	}
	public void setFormatStartDate(String formatStartDate) {
		this.formatStartDate = formatStartDate;
	}
	public int getRoadwayID() {
		return roadwayID;
	}
	public void setRoadwayID(int roadwayID) {
		this.roadwayID = roadwayID;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	
	//˾��
	
	//����
	
	
}
