package com.yuntong.service.impl;

import com.yuntong.business.vo.G_RoadwayVO;
import com.yuntong.hibernate.database.dao.TCarTypeDAO;
import com.yuntong.hibernate.database.dao.TDriverInfoDAO;
import com.yuntong.hibernate.database.dao.TRoadwayDAO;
import com.yuntong.hibernate.database.dao.TTruckInfoDAO;
import com.yuntong.hibernate.database.po.TCarType;
import com.yuntong.hibernate.database.po.TDriverInfo;
import com.yuntong.hibernate.database.po.TRoadway;
import com.yuntong.hibernate.database.po.TTruckInfo;
import com.yuntong.service.G_IDriverInfoService;
import com.yuntong.service.G_IRoadwayService;
import com.yuntong.service.G_ITruckInfoService;

public class G_RoadwayService implements G_IRoadwayService {
	private TRoadwayDAO roadwayDAO;
	private TCarTypeDAO carTypeDAO;
	private TDriverInfoDAO driverInfoDAO;
	private TTruckInfoDAO truckInfoDAO;
	private G_IDriverInfoService driverInfoService;
	private G_ITruckInfoService truckInfoService;
	
	public TRoadwayDAO getRoadwayDAO() {
		return roadwayDAO;
	}
	public void setRoadwayDAO(TRoadwayDAO roadwayDAO) {
		this.roadwayDAO = roadwayDAO;
	}
	
	public G_IDriverInfoService getDriverInfoService() {
		return driverInfoService;
	}
	public void setDriverInfoService(G_IDriverInfoService driverInfoService) {
		this.driverInfoService = driverInfoService;
	}
	public G_ITruckInfoService getTruckInfoService() {
		return truckInfoService;
	}
	public void setTruckInfoService(G_ITruckInfoService truckInfoService) {
		this.truckInfoService = truckInfoService;
	}
	public TCarTypeDAO getCarTypeDAO() {
		return carTypeDAO;
	}
	public void setCarTypeDAO(TCarTypeDAO carTypeDAO) {
		this.carTypeDAO = carTypeDAO;
	}
	public TTruckInfoDAO getTruckInfoDAO() {
		return truckInfoDAO;
	}
	public void setTruckInfoDAO(TTruckInfoDAO truckInfoDAO) {
		this.truckInfoDAO = truckInfoDAO;
	}
	public void addRoadway(G_RoadwayVO roadwayVO) {
		truckInfoService.changeTruckIsLeisure(roadwayVO.getTruckId());
		driverInfoService.changeDriverIsLeisure(roadwayVO.getDriverId());
		TRoadway roadway=new TRoadway();
		roadway.setRoadStartDate(roadwayVO.getRoadStartDate());
		TCarType type=carTypeDAO.findById(roadwayVO.getRoadType());
		TDriverInfo driverInfo=driverInfoDAO.findById(roadwayVO.getDriverId());
		TTruckInfo truckInfo=truckInfoDAO.findById(roadwayVO.getTruckId());
		roadway.setTCarType(type);
		roadway.setTDriverInfo(driverInfo);
		roadway.setTTruckInfo(truckInfo);
		roadwayDAO.save(roadway);
	}
	public TDriverInfoDAO getDriverInfoDAO() {
		return driverInfoDAO;
	}
	public void setDriverInfoDAO(TDriverInfoDAO driverInfoDAO) {
		this.driverInfoDAO = driverInfoDAO;
	}
}
