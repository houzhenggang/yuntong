package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 * 封装地区信息
 */
public class Y_AreaInfoVO {
	private int areaID;                         //编号
	private String areaProvince;				//省份
	private String areaCity;					//城市
	private int areaFilialeType;				//南北标市
	public String getAreaCity() {
		return areaCity;
	}
	public void setAreaCity(String areaCity) {
		this.areaCity = areaCity;
	}
	public int getAreaFilialeType() {
		return areaFilialeType;
	}
	public void setAreaFilialeType(int areaFilialeType) {
		this.areaFilialeType = areaFilialeType;
	}
	public int getAreaID() {
		return areaID;
	}
	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}
	public String getAreaProvince() {
		return areaProvince;
	}
	public void setAreaProvince(String areaProvince) {
		this.areaProvince = areaProvince;
	}
	
}
