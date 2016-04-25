package com.yuntong.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.yuntong.business.vo.G_TruckInfoAndStyleVO;
import com.yuntong.business.vo.G_TruckInfoVO;
import com.yuntong.charset.G_CharSet;
import com.yuntong.hibernate.database.dao.TTruckInfoDAO;
import com.yuntong.hibernate.database.po.TFilialeInfo;
import com.yuntong.hibernate.database.po.TTruckInfo;
import com.yuntong.hibernate.database.po.TTruckStyle;
import com.yuntong.service.G_IFilialeService;
import com.yuntong.service.G_ITruckInfoService;
import com.yuntong.service.G_ITruckStyleService;

public class G_TruckInfoService implements G_ITruckInfoService {
	private TTruckInfoDAO truckInfoDAO;
	private G_IFilialeService filialeService;
	private G_ITruckStyleService truckStyleService;
	

	public G_IFilialeService getFilialeService() {
		return filialeService;
	}

	public void setFilialeService(G_IFilialeService filialeService) {
		this.filialeService = filialeService;
	}

	public G_ITruckStyleService getTruckStyleService() {
		return truckStyleService;
	}

	public void setTruckStyleService(G_ITruckStyleService truckStyleService) {
		this.truckStyleService = truckStyleService;
	}

	public TTruckInfoDAO getTruckInfoDAO() {
		return truckInfoDAO;
	}

	public void setTruckInfoDAO(TTruckInfoDAO truckInfoDAO) {
		this.truckInfoDAO = truckInfoDAO;
	}
	public void addTruckInfo(G_TruckInfoVO truckInfo) {
		TTruckInfo info=new TTruckInfo();
		int companyId=truckInfo.getTruckCompanyID();
		int truckStyleID=truckInfo.getTruckStyleID();
		
		TFilialeInfo fila=filialeService.findFilialeInfoByID(companyId);
		info.setTFilialeInfo(fila);
		
		TTruckStyle style=truckStyleService.findTruckStyleByID(truckStyleID);
		info.setTTruckStyle(style);
		
		info.setTruckBuyDate(G_CharSet.charSet(truckInfo.getTruckBuyDate(), "ISO-8859-1","GBK"));
		info.setTruckColor(G_CharSet.charSet(truckInfo.getTruckColor(), "ISO-8859-1","GBK"));
		info.setTruckEngineNum(G_CharSet.charSet(truckInfo.getTruckEngineNum(), "ISO-8859-1","GBK"));
		info.setTruckFixed(truckInfo.getTruckFixed());
		info.setTruckInsuranceNum(G_CharSet.charSet(truckInfo.getTruckInsuranceNum(), "ISO-8859-1","GBK"));
		info.setTruckNum(G_CharSet.charSet(truckInfo.getTruckNum(), "ISO-8859-1","GBK"));
		info.setTruckPhoto(G_CharSet.charSet(truckInfo.getTruckPhoto(), "ISO-8859-1","GBK"));
		info.setTruckRunNum(G_CharSet.charSet(truckInfo.getTruckRunNum(), "ISO-8859-1","GBK"));
		info.setIsLeisure(truckInfo.getIsLeisure());
		truckInfoDAO.save(info);		
	}

	public List getTruckIsLeisure(int isLeisure) {
		List list= truckInfoDAO.findByTruckIsLeisure(isLeisure);
		List l=new ArrayList();
		for (int i = 0; i <list.size(); i++) {
			TTruckInfo info=(TTruckInfo) list.get(i);
			G_TruckInfoVO vo=new G_TruckInfoVO();
			vo.setTruckId(info.getTruckId());
			vo.setTruckNum(info.getTruckNum());
			vo.setTruckStyleID(info.getTTruckStyle().getTruckStyleId());
			l.add(vo);
		}
		return l;
	}

	public G_TruckInfoAndStyleVO getTruckParticularInfo(String truckNum) {
		List list=truckInfoDAO.findTruckInfoAndTruckStyleByTruckNum(truckNum);
		TTruckInfo info=(TTruckInfo) list.get(0);
		G_TruckInfoAndStyleVO vo=new G_TruckInfoAndStyleVO();
		vo.setTruckId(info.getTruckId());
		vo.setTruckNum(info.getTruckNum());
		vo.setTruckPhoto(info.getTruckPhoto());
		vo.setTruckStyleCubage(info.getTTruckStyle().getTruckStyleCubage());
		vo.setTruckStyleName(info.getTTruckStyle().getTruckStyleName());
		vo.setTruckStyleTonnage(info.getTTruckStyle().getTruckStyleTonnage());
		return vo;
	}

	public void changeTruckIsLeisure(int truckId) {
		TTruckInfo info=truckInfoDAO.findById(truckId);
		info.setIsLeisure(1);
		truckInfoDAO.update(info);		
	}

	public G_TruckInfoVO getTruckInfoByTruckNum(String truckNum) {
		List list=truckInfoDAO.findTruckInfoAndTruckStyleByTruckNum(truckNum);
		TTruckInfo info=(TTruckInfo) list.get(0);
		G_TruckInfoVO vo=new G_TruckInfoVO();
		vo.setTruckNum(info.getTruckNum());
		vo.setTruckEngineNum(info.getTruckEngineNum());
		vo.setTruckRunNum(info.getTruckRunNum());
		vo.setTruckInsuranceNum(info.getTruckInsuranceNum());
		vo.setTruckStyleID(info.getTTruckStyle().getTruckStyleId());
		vo.setTruckColor(info.getTruckColor());
		vo.setTruckPhoto(info.getTruckPhoto());
		vo.setTruckBuyDate(info.getTruckBuyDate());
		vo.setTruckFixed(info.getTruckFixed());
		vo.setTruckCompanyID(info.getTFilialeInfo().getFilialeId());
		return vo;
	}

	public List getTruckNumList(int pageSize,int curPage) {
		List list=truckInfoDAO.getTruckNum(pageSize,curPage);
		List l=new ArrayList();
		l.clear();
		for (int i = 0; i < list.size(); i++) {
			TTruckInfo info=(TTruckInfo) list.get(i);
			G_TruckInfoVO vo=new G_TruckInfoVO();
			vo.setTruckNum(info.getTruckNum());
			l.add(vo);
		}
		return l;
	}

	public int getTotalPage(int pageSize) {
		System.out.println((int) Math.ceil((double)(truckInfoDAO.getTotalPage())/pageSize));
		return (int) Math.ceil((double)(truckInfoDAO.getTotalPage())/pageSize);
		
	}
	//google
	public List findTopTen(String id) {
		List list =truckInfoDAO.findTopTen(id);
		return list;
	}
}
