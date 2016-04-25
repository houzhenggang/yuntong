package com.yuntong.business.vo;

import java.util.Date;
import java.util.List;

public class CheckRigVO {
	private Integer registerId;
    private int TFreightStyleID;
    private int RstateID;
    private int RegisterFactoryID;
    private int RegisterUserID;
    private int RegisterGoodsID;
    private Long RegisterClientID;
    private Long registerGlideId;
    private String registerConveyanceId;
    private String registerLine;
    private String registerPayerName;
    private Date registerDate;
    private String registerRemark;
	public Long getRegisterClientID() {
		return RegisterClientID;
	}
	public void setRegisterClientID(Long registerClientID) {
		RegisterClientID = registerClientID;
	}
	public String getRegisterConveyanceId() {
		return registerConveyanceId;
	}
	public void setRegisterConveyanceId(String registerConveyanceId) {
		this.registerConveyanceId = registerConveyanceId;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public int getRegisterFactoryID() {
		return RegisterFactoryID;
	}
	public void setRegisterFactoryID(int registerFactoryID) {
		RegisterFactoryID = registerFactoryID;
	}
	public Long getRegisterGlideId() {
		return registerGlideId;
	}
	public void setRegisterGlideId(Long registerGlideId) {
		this.registerGlideId = registerGlideId;
	}
	public int getRegisterGoodsID() {
		return RegisterGoodsID;
	}
	public void setRegisterGoodsID(int registerGoodsID) {
		RegisterGoodsID = registerGoodsID;
	}
	public Integer getRegisterId() {
		return registerId;
	}
	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}
	public String getRegisterLine() {
		return registerLine;
	}
	public void setRegisterLine(String registerLine) {
		this.registerLine = registerLine;
	}
	public String getRegisterPayerName() {
		return registerPayerName;
	}
	public void setRegisterPayerName(String registerPayerName) {
		this.registerPayerName = registerPayerName;
	}
	public String getRegisterRemark() {
		return registerRemark;
	}
	public void setRegisterRemark(String registerRemark) {
		this.registerRemark = registerRemark;
	}
	public int getRegisterUserID() {
		return RegisterUserID;
	}
	public void setRegisterUserID(int registerUserID) {
		RegisterUserID = registerUserID;
	}
	
	public int getRstateID() {
		return RstateID;
	}
	public void setRstateID(int rstateID) {
		RstateID = rstateID;
	}
	public int getTFreightStyleID() {
		return TFreightStyleID;
	}
	public void setTFreightStyleID(int freightStyleID) {
		TFreightStyleID = freightStyleID;
	}
}
