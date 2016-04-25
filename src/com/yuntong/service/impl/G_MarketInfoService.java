package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yuntong.business.vo.G_MarketInfoVO;
import com.yuntong.hibernate.database.dao.TMarketInfoDAO;
import com.yuntong.hibernate.database.po.TMarketInfo;
import com.yuntong.service.G_IMarketInfoService;

public class G_MarketInfoService implements G_IMarketInfoService {
	private TMarketInfoDAO marketInfoDAO;
	
	public TMarketInfoDAO getMarketInfoDAO() {
		return marketInfoDAO;
	}

	public void setMarketInfoDAO(TMarketInfoDAO marketInfoDAO) {
		this.marketInfoDAO = marketInfoDAO;
	}

	public List findMarketInfo() {
		List list=marketInfoDAO.findMarketInfo();
		List l=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			TMarketInfo info=(TMarketInfo) list.get(i);
			G_MarketInfoVO vo=new G_MarketInfoVO();
			vo.setMarketName(info.getMarketName());
			l.add(vo);
		}
		return l;
	}
}
