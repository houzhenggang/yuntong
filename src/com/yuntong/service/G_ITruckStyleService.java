package com.yuntong.service;

import java.util.List;

import com.yuntong.hibernate.database.po.TTruckStyle;

public interface G_ITruckStyleService {
	/**
	 * 得到所有的车型
	 * @return
	 */
	public List getAllTruckStyle();
	public TTruckStyle findTruckStyleByID(int id);
}
