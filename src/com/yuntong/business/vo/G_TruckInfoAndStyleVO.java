package com.yuntong.business.vo;

public class G_TruckInfoAndStyleVO {
	private int driverId;//司机ID
	private String driverName;//司机姓名
	private int truckId;//车辆ID
	private String truckPhoto;//车辆照片路径
	private String truckNum;//车牌
	private String truckStyleName ;//型号
	private Long truckStyleTonnage;//载重(重量)
    private Long truckStyleCubage;//货舱容积(方量)
	public String getTruckNum() {
		return truckNum;
	}
	public void setTruckNum(String truckNum) {
		this.truckNum = truckNum;
	}
	public String getTruckPhoto() {
		return truckPhoto;
	}
	public void setTruckPhoto(String truckPhoto) {
		this.truckPhoto = truckPhoto;
	}
	public Long getTruckStyleCubage() {
		return truckStyleCubage;
	}
	public void setTruckStyleCubage(Long truckStyleCubage) {
		this.truckStyleCubage = truckStyleCubage;
	}
	public String getTruckStyleName() {
		return truckStyleName;
	}
	public void setTruckStyleName(String truckStyleName) {
		this.truckStyleName = truckStyleName;
	}
	public Long getTruckStyleTonnage() {
		return truckStyleTonnage;
	}
	public void setTruckStyleTonnage(Long truckStyleTonnage) {
		this.truckStyleTonnage = truckStyleTonnage;
	}
	public int getTruckId() {
		return truckId;
	}
	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
}
