package com.yuntong.service.impl;
/***
 * ��ʱ�˷�
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

	//�õ�������Ϣ����װ
	public List findAllInfo() {
		List po=freightInfoDAO.findAllInfo();
		List voList=new ArrayList();
		//ת����ʽ
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
	//�õ����е�����Ϣ
	public List findAllAreaInfo() {
		List list=areaInfoDAO.findAllAreaInfo();		
		return list;
	}
//	��ҳ�õ��û���Ϣ(ҳ���С����ǰҳ��,��ʼ�ر�ţ�Ŀ�ĵر��)
	public List findSplitRegister(int pageSize, int curPage, int strid, int endid) {
		List po=freightInfoDAO.findSplitRegister(pageSize, curPage, strid, endid);
		List voList=new ArrayList();
		//ת����ʽ
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
//	����ҳ���С�õ���ҳ��(ҳ���С����ʼ�ر�ţ�Ŀ�ĵر��)
	public int getPageNum(int pageSize, int strid, int endid) {
		int temp=freightInfoDAO.getPageNum(pageSize, strid, endid);
		return temp;
	}
//���ݱ��ɾ����Ϣ
	public void deleteInfoById(int id) {
		freightInfoDAO.deleteInfoByID(id);		
	}
//��ӻ��޸�
	public boolean addAFinfo(int iid, int stid, int enid, int pjtime, float zhong, float fang) {
		boolean tag=freightInfoDAO.addAFinfo(iid, stid, enid, pjtime, zhong, fang);
		return tag;
	}
}
