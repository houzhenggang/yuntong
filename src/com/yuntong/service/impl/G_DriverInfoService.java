package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.yuntong.business.vo.G_DriverInfoVO;
import com.yuntong.charset.G_CharSet;
import com.yuntong.hibernate.database.dao.TDriverInfoDAO;
import com.yuntong.hibernate.database.po.TDriverInfo;
import com.yuntong.hibernate.database.po.TFilialeInfo;
import com.yuntong.service.G_IDriverInfoService;
import com.yuntong.service.G_IFilialeService;

public class G_DriverInfoService implements G_IDriverInfoService {
	private TDriverInfoDAO driverInfoDAO;
	private G_IFilialeService filialeService;
	public G_IFilialeService getFilialeService() {
		return filialeService;
	}
	public void setFilialeService(G_IFilialeService filialeService) {
		this.filialeService = filialeService;
	}
	public TDriverInfoDAO getDriverInfoDAO() {
		return driverInfoDAO;
	}
	public void setDriverInfoDAO(TDriverInfoDAO driverInfoDAO) {
		this.driverInfoDAO = driverInfoDAO;
	}
	/**
	 * 司机信息登记
	 */
	public void addDriverInfo(G_DriverInfoVO driverInfoVO) {
		TDriverInfo info=new TDriverInfo();
		info.setDriverAge(driverInfoVO.getDriverAge());
		info.setDriverCardId(G_CharSet.charSet(driverInfoVO.getDriverCardID(), "ISO-8859-1","GBK"));
		info.setDriverDriverCardId(G_CharSet.charSet(driverInfoVO.getDriverDriverCardID(), "ISO-8859-1","GBK"));
		info.setDriverName(G_CharSet.charSet(driverInfoVO.getDriverName(),"ISO-8859-1","GBK"));
		info.setDriverPhoneNum(G_CharSet.charSet(driverInfoVO.getDriverPhoneNum(), "ISO-8859-1","GBK" ));
		info.setDriverPhoto(G_CharSet.charSet(driverInfoVO.getDriverPhoto(), "ISO-8859-1","GBK"));
		info.setDriverRemarkInfo(G_CharSet.charSet(driverInfoVO.getDriverRemarkInfo(), "ISO-8859-1","GBK"));
		info.setDriverSex(driverInfoVO.getDriverSex());
		TFilialeInfo filialeInfo=filialeService.findFilialeInfoByID(driverInfoVO.getDriverCompanyID());
		info.setTFilialeInfo(filialeInfo);
		info.setIsLeisure(driverInfoVO.getIsLeisure());
		driverInfoDAO.save(info);	
	}
	/**
	 * 得到所有空闲司机的信息
	 */
	public List getDrinerIsLeisure(int isLeisure) {
		List list= driverInfoDAO.findByDriverIsLeisure(isLeisure);
		List l=new ArrayList();
		for(int i=0;i<list.size();i++){
			TDriverInfo info=(TDriverInfo) list.get(i);
			G_DriverInfoVO vo=new G_DriverInfoVO();
			vo.setDriverName(info.getDriverName());
			vo.setDriverId(info.getDriverId());
			l.add(vo);
		}
		return l;
	}
	/**
	 * 改变司机状态
	 */
	public void changeDriverIsLeisure(int driverId) {
		TDriverInfo info=driverInfoDAO.findById(driverId);
		info.setIsLeisure(1);
		driverInfoDAO.update(info);
	}
	public G_DriverInfoVO getDriverInfoByName(String name) {
		List list=driverInfoDAO.getDriverInfoByName(name);
		TDriverInfo info=(TDriverInfo) list.get(0);
		G_DriverInfoVO vo=new G_DriverInfoVO();
		vo.setDriverName(info.getDriverName());
		vo.setDriverAge(info.getDriverAge());
		vo.setDriverSex(info.getDriverSex());
		vo.setDriverPhoto(info.getDriverPhoto());
		vo.setDriverCardID(info.getDriverCardId());
		vo.setDriverDriverCardID(info.getDriverDriverCardId());
		vo.setDriverPhoneNum(info.getDriverPhoneNum());
		vo.setDriverCompanyID(info.getTFilialeInfo().getFilialeId());
		vo.setDriverRemarkInfo(info.getDriverRemarkInfo());
		return vo;
	}
	public int getTotalPage(int pageSize) {
		return (int)Math.ceil((double)driverInfoDAO.getTotalPage()/pageSize);
	}
	public List getAllDriverInfo(int pageSize, int curPage) {
		List list=driverInfoDAO.getAllDriverInfo(pageSize, curPage);
		List l=new ArrayList();
		l.clear();
		for (int i = 0; i < list.size(); i++) {
			TDriverInfo info=(TDriverInfo) list.get(i);
			G_DriverInfoVO vo=new G_DriverInfoVO();
			vo.setDriverName(info.getDriverName());
			l.add(vo);
		}
		return l;
	}
}
