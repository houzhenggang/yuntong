package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 * ��װ������Ϣ
 */
public class Y_AreaInfoVO {
	private int areaID;                         //���
	private String areaProvince;				//ʡ��
	private String areaCity;					//����
	private int areaFilialeType;				//�ϱ�����
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
