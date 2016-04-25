package com.yuntong.service;

import java.util.List;
import com.yuntong.hibernate.database.po.TAgioType;
import com.yuntong.hibernate.database.po.TAgioInfo;
import com.yuntong.hibernate.database.po.TRegisterInfo;
import com.yuntong.hibernate.database.po.TRoadway;
import com.yuntong.hibernate.database.po.TDisrepareInfo;

import com.yuntong.myexception.Y_MyNullResultException;

public interface X_IfinancialManageService {
	public List findByProperty(String propertyName, Object value)throws Y_MyNullResultException;
	public TRegisterInfo findById(String propertyName,Object value) throws Y_MyNullResultException;
	public List findByAllObject()throws Y_MyNullResultException;
	public List findDayNum()throws Y_MyNullResultException;
	
	public void update(TRegisterInfo info);
	
	public List findAllAgio()throws Y_MyNullResultException;;
	
	public void save(TAgioInfo transientInstance);
	
	public TRoadway findById(Integer id);
	
	public void save(TDisrepareInfo disrepareInfo);
	public TAgioType findTypeByProperty(String propertyName, Object value)throws Y_MyNullResultException;
	public List findByAllTAgio();
	
	public List findByAllTAgiotype();
	
}
