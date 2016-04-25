package com.yuntong.service.impl;

import java.util.List;


import com.yuntong.hibernate.database.dao.TRegisterInfoDAO;
import com.yuntong.hibernate.database.po.TRegisterInfo;
import com.yuntong.hibernate.database.po.TRegisterState;

import com.yuntong.service.M_IRegisterManagerService;



public class M_IRegisterManagerServiceManager implements
		M_IRegisterManagerService {
	TRegisterInfoDAO infoDAO;
//	���ݻ�Ʊ��Ż������ŵõ���Ʊ��Ϣ
	public List findRegisterInfoByInputID(String ID,long value) {
		List list=infoDAO.findByID(ID,value);
		return list;
	}
	
	//�˻�Ǽ�google
	public List findTopTen(long id){
		List list=infoDAO.findByIdTopTen(id);
		return list;
	}
	
	public void updateRegisterType(int rid, int updateState) {
		// TODO Auto-generated method stub
		TRegisterInfo info = new TRegisterInfo();
		info.setRegisterId(rid);
		
		TRegisterState ts= new TRegisterState();
		ts.setRstateId(updateState);
		info.setTRegisterState(ts);
		
		infoDAO.attachDirty(info);
	}


	public TRegisterInfoDAO getInfoDAO() {
		return infoDAO;
	}


	public void setInfoDAO(TRegisterInfoDAO infoDAO) {
		this.infoDAO = infoDAO;
	}




}
