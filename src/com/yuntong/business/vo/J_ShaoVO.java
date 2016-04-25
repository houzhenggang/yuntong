package com.yuntong.business.vo;



public class J_ShaoVO {
	private int agioId;
    private int TAgioType;
    private int TRegisterID;
    private Float agioMoney;
    private String agioInfo;
	public int getAgioId() {
		return agioId;
	}
	public void setAgioId(int agioId) {
		this.agioId = agioId;
	}
	public String getAgioInfo() {
		return agioInfo;
	}
	public void setAgioInfo(String agioInfo) {
		this.agioInfo = agioInfo;
	}
	public Float getAgioMoney() {
		return agioMoney;
	}
	public void setAgioMoney(Float agioMoney) {
		this.agioMoney = agioMoney;
	}
	public int getTAgioType() {
		return TAgioType;
	}
	public void setTAgioType(int agioType) {
		TAgioType = agioType;
	}
	public int getTRegisterID() {
		return TRegisterID;
	}
	public void setTRegisterID(int registerID) {
		TRegisterID = registerID;
	}
}
