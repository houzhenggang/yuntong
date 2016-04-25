package com.yuntong.service;

import java.util.List;

import com.yuntong.hibernate.database.po.TAgioInfo;

public interface M_TAgionInfoManagerService {
	public List getAllInfo();
	public void deleteInfo(int id);
	public List selectInfo(String type,String value);
	public List gettypeId();
	public List getRegisterId();
	public void updateInfo(TAgioInfo info);
	public void addInfo(TAgioInfo info);
	public List findtop10(int fid);
}
