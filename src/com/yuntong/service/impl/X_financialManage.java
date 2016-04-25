package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yuntong.hibernate.database.dao.TAgioInfoDAO;
import com.yuntong.hibernate.database.dao.TAgioTypeDAO;
import com.yuntong.hibernate.database.dao.TDisrepareInfoDAO;
import com.yuntong.hibernate.database.dao.TRegisterInfoDAO;
import com.yuntong.hibernate.database.dao.TRegisterStateDAO;
import com.yuntong.hibernate.database.dao.TRoadwayDAO;
import com.yuntong.hibernate.database.po.*;
import com.yuntong.myexception.Y_MyNullResultException;
import com.yuntong.service.*;

public class X_financialManage implements X_IfinancialManageService{
	private TRegisterInfoDAO infoDAO;
	private TDisrepareInfoDAO infoDAO2;
	private TRegisterStateDAO stateDAO;
	private TAgioInfoDAO agioInfoDAO;
	private TRoadwayDAO roadwayDAO;
	private TAgioTypeDAO agioTypeDAO;
	
	public TRegisterStateDAO getStateDAO() {
		return stateDAO;
	}
	public void setStateDAO(TRegisterStateDAO stateDAO) {
		this.stateDAO = stateDAO;
	}
	public TRegisterInfoDAO getInfoDAO() {
		return infoDAO;
	}
	public void setInfoDAO(TRegisterInfoDAO infoDAO) {
		this.infoDAO = infoDAO;
	}	
	public TDisrepareInfoDAO getInfoDAO2() {
		return infoDAO2;
	}
	public void setInfoDAO2(TDisrepareInfoDAO infoDAO2) {
		this.infoDAO2 = infoDAO2;
	}
	
	
	public List findByProperty(String propertyName, Object value) throws Y_MyNullResultException{
		// TODO Auto-generated method stub
		List list=infoDAO.findByProperty(propertyName, value);
		return list;
	}
	
	public List findByAllObject() throws Y_MyNullResultException{
		// TODO Auto-generated method stub
		List list=infoDAO2.findByDisrepare();
		return list;
	}
	
	public List findDayNum() throws Y_MyNullResultException {
		// TODO Auto-generated method stub
		List<TRegisterInfo> list=infoDAO.findDayNum();
		List list2=new ArrayList();
		for (int i = 0; i <list.size(); i++) {
			list2.add(list.get(i).getRegisterId());
		}
		return list2;
	}
	
	public TRegisterInfo findById(String propertyName, Object value)
	throws Y_MyNullResultException {
		List list=(List) findByProperty(propertyName, value);
		TRegisterInfo info=(TRegisterInfo)list.get(0);
		return infoDAO.findById(info.getRegisterId());
	}
	
	
	
	public List findAllAgio() throws Y_MyNullResultException {
		// TODO Auto-generated method stub
		
		return agioInfoDAO.findAllAgio();
	}
	public TAgioInfoDAO getAgioInfoDAO() {
		return agioInfoDAO;
	}
	public void setAgioInfoDAO(TAgioInfoDAO agioInfoDAO) {
		this.agioInfoDAO = agioInfoDAO;
	}
	public void update(TRegisterInfo info) {
		// TODO Auto-generated method stub
		infoDAO.attachDirty(info);
		
	}
	public void save(TAgioInfo transientInstance) {
		// TODO Auto-generated method stub
		agioInfoDAO.save(transientInstance);
	}
	public TRoadway findById(Integer id) {
		// TODO Auto-generated method stub
		TRoadway roadway=roadwayDAO.findById(id);
		return roadway;
	}
	
	public void save(TDisrepareInfo disrepareInfo) {
		// TODO Auto-generated method stub
		infoDAO2.attachDirty(disrepareInfo);
	}
	
	public TAgioType findTypeByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		TAgioType agioType=(TAgioType) agioTypeDAO.findByProperty(propertyName, value).get(0);
		return agioType;
	}
	
	public TAgioTypeDAO getAgioTypeDAO() {
		return agioTypeDAO;
	}
	public void setAgioTypeDAO(TAgioTypeDAO agioTypeDAO) {
		this.agioTypeDAO = agioTypeDAO;
	}
	
	public TRoadwayDAO getRoadwayDAO() {
		return roadwayDAO;
	}
	public void setRoadwayDAO(TRoadwayDAO roadwayDAO) {
		this.roadwayDAO = roadwayDAO;
	}
	public List findByAllTAgio() {
		// TODO Auto-generated method stub
		List list=agioInfoDAO.gettypeId();
		return list;
	}
	public List findByAllTAgiotype() {
		// TODO Auto-generated method stub
		
		List list=agioTypeDAO.findAllAgioType();

		return list;
	}
	
	

}
