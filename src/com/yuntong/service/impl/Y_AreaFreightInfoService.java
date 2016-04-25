package com.yuntong.service.impl;
/***
 * 运时运费
 */
import java.util.ArrayList;
import java.util.List;

import com.yuntong.business.vo.Y_AFInfoVO;
import com.yuntong.hibernate.database.dao.TAreaFreightInfoDAO;
import com.yuntong.hibernate.database.dao.TAreaInfoDAO;
import com.yuntong.hibernate.database.po.TAreaFreightInfo;
import com.yuntong.service.Y_IAreaFreightInfoService;

public class Y_AreaFreightInfoService implements Y_IAreaFreightInfoService {
	private TAreaFreightInfoDAO freightInfoDAO;
	private TAreaInfoDAO areaInfoDAO;
	public TAreaInfoDAO getAreaInfoDAO() {
		return areaInfoDAO;
	}

	public void setAreaInfoDAO(TAreaInfoDAO areaInfoDAO) {
		this.areaInfoDAO = areaInfoDAO;
	}

	public TAreaFreightInfoDAO getFreightInfoDAO() {
		return freightInfoDAO;
	}

	public void setFreightInfoDAO(TAreaFreightInfoDAO freightInfoDAO) {
		this.freightInfoDAO = freightInfoDAO;
	}

	//得到所有信息并封装
	public List findAllInfo() {
		List po=freightInfoDAO.findAllInfo();
		List voList=new ArrayList();
		//转化格式
		for (int i = 0; i < po.size(); i++) {
			Y_AFInfoVO vo=new Y_AFInfoVO();
			vo.setAfBeginName(((TAreaFreightInfo)(po.get(i))).getTAreaInfoByAfrerghtBegin().getAreaCity());
			vo.setAfrerghtBegin(((TAreaFreightInfo)(po.get(i))).getTAreaInfoByAfrerghtBegin().getAreaInfoId());
			vo.setAfrerghtBulk(((TAreaFreightInfo)(po.get(i))).getAfrerghtBulk());
			vo.setAfrerghtEnd(((TAreaFreightInfo)(po.get(i))).getTAreaInfoByAfrerghtEnd().getAreaInfoId());
			vo.setAfrerghtEndName(((TAreaFreightInfo)(po.get(i))).getTAreaInfoByAfrerghtEnd().getAreaCity());
			vo.setAfrerghtHeft(((TAreaFreightInfo)(po.get(i))).getAfrerghtHeft());
			vo.setAfrerghtID(((TAreaFreightInfo)(po.get(i))).getAfrerghtId());
			vo.setAfrerghtTime(((TAreaFreightInfo)(po.get(i))).getAfrerghtTime());
			voList.add(vo);
		}
		return voList;
	}
	//得到所有地区信息
	public List findAllAreaInfo() {
		List list=areaInfoDAO.findAllAreaInfo();		
		return list;
	}
//	分页得到用户信息(页面大小，当前页数,其始地编号，目的地编号)
	public List findSplitRegister(int pageSize, int curPage, int strid, int endid) {
		List po=freightInfoDAO.findSplitRegister(pageSize, curPage, strid, endid);
		List voList=new ArrayList();
		//转化格式
		for (int i = 0; i < po.size(); i++) {
			Y_AFInfoVO vo=new Y_AFInfoVO();
			vo.setAfBeginName(((TAreaFreightInfo)(po.get(i))).getTAreaInfoByAfrerghtBegin().getAreaCity());
			vo.setAfrerghtBegin(((TAreaFreightInfo)(po.get(i))).getTAreaInfoByAfrerghtBegin().getAreaInfoId());
			vo.setAfrerghtBulk(((TAreaFreightInfo)(po.get(i))).getAfrerghtBulk());
			vo.setAfrerghtEnd(((TAreaFreightInfo)(po.get(i))).getTAreaInfoByAfrerghtEnd().getAreaInfoId());
			vo.setAfrerghtEndName(((TAreaFreightInfo)(po.get(i))).getTAreaInfoByAfrerghtEnd().getAreaCity());
			vo.setAfrerghtHeft(((TAreaFreightInfo)(po.get(i))).getAfrerghtHeft());
			vo.setAfrerghtID(((TAreaFreightInfo)(po.get(i))).getAfrerghtId());
			vo.setAfrerghtTime(((TAreaFreightInfo)(po.get(i))).getAfrerghtTime());
			voList.add(vo);
		}
		return voList;
	}
//	根据页面大小得到总页数(页面大小，其始地编号，目的地编号)
	public int getPageNum(int pageSize, int strid, int endid) {
		int temp=freightInfoDAO.getPageNum(pageSize, strid, endid);
		return temp;
	}
//根据编号删除信息
	public void deleteInfoById(int id) {
		freightInfoDAO.deleteInfoByID(id);		
	}
//添加或修改
	public boolean addAFinfo(int iid, int stid, int enid, int pjtime, float zhong, float fang) {
		boolean tag=freightInfoDAO.addAFinfo(iid, stid, enid, pjtime, zhong, fang);
		return tag;
	}
}
