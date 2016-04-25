package com.yuntong.service.impl;

import java.util.List;

import com.yuntong.hibernate.database.dao.TAgioInfoDAO;
import com.yuntong.hibernate.database.po.TAgioInfo;
import com.yuntong.service.M_TAgionInfoManagerService;
import com.yuntong.*;

public class M_TAgionInfoManager implements M_TAgionInfoManagerService {
	TAgioInfoDAO dao;
	//见面穿过来的数据转成VO，然后穿到业务，把VO转成PO
	public List getAllInfo() {
		
		List list=dao.getAllInfo();
		return list;
	}
	public TAgioInfoDAO getDao() {
		return dao;
	}
	public void setDao(TAgioInfoDAO dao) {
		this.dao = dao;
	}
	public void deleteInfo(int id) {
		TAgioInfo info= new TAgioInfo();
		info.setAgioId(id);
		dao.delete(info);
		
	}
	public List selectInfo(String type, String value) {
		List list=dao.selectInfo(type, value);
		return list;
	}
	public List getRegisterId() {
		List list=dao.getRegisterId();
		return list;
	}
	public List gettypeId() {
		List list=dao.gettypeId();
		return list;
	}
	public void addInfo(TAgioInfo info) {
		dao.attachDirty(info);
	}
	public void updateInfo(TAgioInfo info) {
		dao.attachDirty(info);	
	}
	public List findtop10(int fid) {
		List list=dao.findTopTen(fid);
		return list;
	}

}
