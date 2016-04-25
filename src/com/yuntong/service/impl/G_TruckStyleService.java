package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.yuntong.business.vo.G_TruckStyleVO;
import com.yuntong.hibernate.database.dao.TTruckStyleDAO;
import com.yuntong.hibernate.database.po.TTruckStyle;
import com.yuntong.service.G_ITruckStyleService;

public class G_TruckStyleService implements G_ITruckStyleService {
	private TTruckStyleDAO truckStyleDAO;
	public TTruckStyleDAO getTruckStyleDAO() {
		return truckStyleDAO;
	}
	public void setTruckStyleDAO(TTruckStyleDAO truckStyleDAO) {
		this.truckStyleDAO = truckStyleDAO;
	}
	public List getAllTruckStyle() {
		List list=truckStyleDAO.getAllTruckStyle();
		List l=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			G_TruckStyleVO vo=new G_TruckStyleVO();
			TTruckStyle s=(TTruckStyle) list.get(i);
			vo.setTruckStyleID(s.getTruckStyleId());
			vo.setTruckStyleName(s.getTruckStyleName());
			l.add(vo);
		}
		return l;
	}
	public TTruckStyle findTruckStyleByID(int id) {
		return truckStyleDAO.findById(id);
	}

}
