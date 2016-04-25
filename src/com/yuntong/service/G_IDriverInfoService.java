package com.yuntong.service;

import java.util.List;

import com.yuntong.business.vo.G_DriverInfoVO;

public interface G_IDriverInfoService {
	public void addDriverInfo(G_DriverInfoVO driverInfoVO);
	public List getDrinerIsLeisure(int isLeisure);
	public void changeDriverIsLeisure(int driverId);
	public G_DriverInfoVO getDriverInfoByName(String name);
	public int getTotalPage(int pageSize);
	public List getAllDriverInfo(int pageSize, int curPage);
}
