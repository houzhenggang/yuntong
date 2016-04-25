package com.yuntong.business.vo;

import java.util.Date;

public class G_RoadwayVO{
	private String driverName;
	private String truckNum;
	private int driverId;
	private int truckId;
	private Date roadStartDate;
    private Date roadArrive;
    private int roadType;
    private String dateString;
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public Date getRoadArrive() {
		return roadArrive;
	}
	public void setRoadArrive(Date roadArrive) {
		this.roadArrive = roadArrive;
	}
	public Date getRoadStartDate() {
		return roadStartDate;
	}
	public void setRoadStartDate(Date roadStartDate) {
		this.roadStartDate = roadStartDate;
	}
	public int getRoadType() {
		return roadType;
	}
	public void setRoadType(int roadType) {
		this.roadType = roadType;
	}
	public int getTruckId() {
		return truckId;
	}
	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}
	public String getTruckNum() {
		return truckNum;
	}
	public void setTruckNum(String truckNum) {
		this.truckNum = truckNum;
	}
}