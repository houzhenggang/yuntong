package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuntong.business.vo.Y_MarketInfoVO;
import com.yuntong.hibernate.database.dao.TMarketInfoDAO;
import com.yuntong.hibernate.database.po.TAreaInfo;
import com.yuntong.hibernate.database.po.TMarketInfo;

import com.yuntong.service.Y_IMarketManagerService;

public class Y_MarketManagerService implements Y_IMarketManagerService {
	private TMarketInfoDAO infoDAO;
	
	public TMarketInfoDAO getInfoDAO() {
		return infoDAO;
	}

	public void setInfoDAO(TMarketInfoDAO infoDAO) {
		this.infoDAO = infoDAO;
	}
	//根据地区编号查找市场信息
	public List findMarketInfoByAreaID(int areaID) {
		TAreaInfo areaInfo=new TAreaInfo();
		areaInfo.setAreaInfoId(areaID);
		TMarketInfo marketInfo=new TMarketInfo();
		marketInfo.setMarketId(1001);	
		List list=infoDAO.findByAreaID(areaID);
		List volist=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			int marketID=((TMarketInfo)(list.get(i))).getMarketId();
			String marketName=((TMarketInfo)(list.get(i))).getMarketName();
			int marketAreaID=((TMarketInfo)(list.get(i))).getTAreaInfo().getAreaInfoId();										
			String marketAddress=((TMarketInfo)(list.get(i))).getMarketAddress();						
			String markeyPostID=((TMarketInfo)(list.get(i))).getMarkeyPostId();
			Y_MarketInfoVO vo=new Y_MarketInfoVO();
			vo.setMarketAddress(marketAddress);
			vo.setMarketAreaID(marketAreaID);
			vo.setMarketID(marketID);
			vo.setMarketName(marketName);
			vo.setMarkeyPostID(markeyPostID);
			volist.add(vo);
		}
		return  volist;
	}
	//根据市场名称查找所属地区名称
	public String findAreaNameByMarketName(String marketName) {
		List list=infoDAO.findByMarketName(marketName);
		String Temp=((TMarketInfo)(list.get(0))).getTAreaInfo().getAreaCity();
		return Temp;
	}	
}
