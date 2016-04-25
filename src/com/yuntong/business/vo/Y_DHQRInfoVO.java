package com.yuntong.business.vo;

import java.util.Date;

/***
 * 
 * @author yqy
 *	封装到货确认时货票信息
 */
public class Y_DHQRInfoVO {
	//货票
	private int	registerID=0;						//货票编号
	private long	registerGlideID=0;				//日流水号
	private String	registerFactoryName="";				//厂家名称
	private String registerFactoryphone="";            //厂家电话
	private String registerClientName="";				//客户名称
	private String registerClientPhone="";				//客户电话
	private String	registerConveyanceID="";		//(自动生成)运输编号(客户编号+流水号+件数)
	private String	registerLine="";				//运输线路（根据客户编号前四位自动生成）
	private int	registerFreightID=0;				//运费结算方式编号
	private String registerFreightName="";			//结算方式名称
	private String	registerPayerName="";			//付款人姓名 
	private int	registerUserID=0;					//操作员编号
	private Date	registerDate;				//制单时间
	private String strDate ="";                    //格式化时间
	private int	registerState=0;					//状态编号
	private String	RegisterRemark="";				//备注
	//货物
	private int goodsID=0;						//货物编号(主)
	private String goodsName="";					//货物名称
	private int goodsPaymentModeid=0;				//货款计算方式(重量或方量)编号
	private String goodsPaymentModeName="";		//货款计算方式(重量或方量)名字
	private int buyStyleID=0;						//付费方式编号
	private String buyStyleName="";				//付费方式名称
	private float goodsHeft=0;					//货物重量(吨)
	private float goodsBulk=0;					//货物方量(立方米)
	private long goodsNumber=0;					//货物件数
	private String goodsNumberUnit="";				//件数单位
	private float goodsValue=0;					//货物价值
	private float goodsFreight=0;					//运费		
	private float goodsInsuranceValue=0;			//货物保价
	private double goodsAllValue=0;				//合计
	private String goodsRemarkInfo="";				//备注信息
	//车次
	private int catId;								//车辆编号
	private int driverId;							//司机编号
	private int roadwayID;							//车次编号
	private String driverName="";					//司机姓名
	private String carName;						//车牌号码
	private Date startDate;						//发货时间
	private String formatStartDate;				//格式化发货时间
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
	
	
	//司机
	
	//车辆
	
	
}
