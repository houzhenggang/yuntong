package com.yuntong.service;

import java.util.List;

import com.yuntong.hibernate.database.po.TTruckStyle;

public interface G_ITruckStyleService {
	/**
	 * �õ����еĳ���
	 * @return
	 */
	public List getAllTruckStyle();
	public TTruckStyle findTruckStyleByID(int id);
}
