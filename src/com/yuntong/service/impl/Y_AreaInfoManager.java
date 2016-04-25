package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuntong.business.vo.Y_AreaInfoVO;
import com.yuntong.hibernate.database.dao.TAreaInfoDAO;
import com.yuntong.hibernate.database.dao.TMarketInfoDAO;
import com.yuntong.hibernate.database.po.TAreaInfo;
import com.yuntong.service.Y_IAreaManagerService;

public class Y_AreaInfoManager implements Y_IAreaManagerService {
	private TAreaInfoDAO infoDAO;
	
	public TAreaInfoDAO getInfoDAO() {
		return infoDAO;
	}

	public void setInfoDAO(TAreaInfoDAO infoDAO) {
		this.infoDAO = infoDAO;
	}

	public List findAllAreaInfo() {
		List list=infoDAO.findAllAreaInfo();
		List volist=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Y_AreaInfoVO vo=new Y_AreaInfoVO();
			vo.setAreaID(((TAreaInfo)(list.get(i))).getAreaInfoId());
			vo.setAreaProvince(((TAreaInfo)(list.get(i))).getAreaProvince());
			vo.setAreaCity(((TAreaInfo)(list.get(i))).getAreaCity());
			vo.setAreaFilialeType(((TAreaInfo)(list.get(i))).getAreaFilialeType());
			volist.add(vo);
		}
		return volist;
	}
	
}
