package com.yuntong.business.vo;

public class G_TruckInfoAndStyleVO {
	private int driverId;//˾��ID
	private String driverName;//˾������
	private int truckId;//����ID
	private String truckPhoto;//������Ƭ·��
	private String truckNum;//����
	private String truckStyleName ;//�ͺ�
	private Long truckStyleTonnage;//����(����)
    private Long truckStyleCubage;//�����ݻ�(����)
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
