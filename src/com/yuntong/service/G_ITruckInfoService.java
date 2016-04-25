package com.yuntong.service;

import java.util.List;

import com.yuntong.business.vo.G_TruckInfoAndStyleVO;
import com.yuntong.business.vo.G_TruckInfoVO;

public interface G_ITruckInfoService {
	public void addTruckInfo(G_TruckInfoVO truckInfo);
	public List getTruckIsLeisure(int isLeisure);
	public G_TruckInfoAndStyleVO getTruckParticularInfo(String truckNum);
	public void changeTruckIsLeisure(int truckId);
	public G_TruckInfoVO getTruckInfoByTruckNum(String truckNum);
	public List getTruckNumList(int pageSize,int curPage);
	public int getTotalPage(int pageSize);
	//google
	public List findTopTen(String id);
}
