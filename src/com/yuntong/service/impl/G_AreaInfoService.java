package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yuntong.business.vo.Y_AreaInfoVO;
import com.yuntong.hibernate.database.dao.TAreaInfoDAO;
import com.yuntong.hibernate.database.po.TAreaInfo;
import com.yuntong.service.G_IAreaInfoService;

public class G_AreaInfoService implements G_IAreaInfoService {
	private TAreaInfoDAO areaInfoDAO;
	public TAreaInfoDAO getAreaInfoDAO() {
		return areaInfoDAO;
	}
	public void setAreaInfoDAO(TAreaInfoDAO areaInfoDAO) {
		this.areaInfoDAO = areaInfoDAO;
	}
	public List findCityByProvince(String province) {
		List list=areaInfoDAO.findByAreaProvince(province);
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
