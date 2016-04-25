package com.yuntong.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yuntong.business.vo.Y_FactoryInfoVO;
import com.yuntong.hibernate.database.dao.TFactoryInfoDAO;
import com.yuntong.hibernate.database.po.TAreaInfo;
import com.yuntong.hibernate.database.po.TFactoryInfo;
import com.yuntong.hibernate.database.po.TGrade;
import com.yuntong.service.Y_IFactoryManagerService;

public class Y_FactoryManagerService implements Y_IFactoryManagerService {
	 private TFactoryInfoDAO infoDAO;
	 
	public TFactoryInfoDAO getInfoDAO() {
		return infoDAO;
	}

	public void setInfoDAO(TFactoryInfoDAO infoDAO) {
		this.infoDAO = infoDAO;
	}
	//根据编号得到厂商信息
	public Y_FactoryInfoVO findFactoryByID(int fid) {
		TFactoryInfo info=new TFactoryInfo();
		info=infoDAO.findById(fid);
		
		Y_FactoryInfoVO vo=new Y_FactoryInfoVO();
		vo.setFactoryID(info.getFactoryId());
		vo.setFactoryName(info.getFactoryName());
		vo.setFactoryLinkMan(info.getFactoryLinkman());
		vo.setFactoryGradeID(info.getTGrade().getGradeId());
		//vo.setFactoryGradeName(info.getTGrade().getGradeName());
		//vo.setFactoryGradeRote(info.getTGrade().getGradeRate());
		vo.setFactoryAddress(info.getFactoryAddress());
		vo.setFactoryAreaID(info.getTAreaInfo().getAreaInfoId());
		//vo.setFactoryAreaName(info.getTAreaInfo().getAreaCity());
		vo.setFactoryConsumption(info.getFactoryConsumption());
		vo.setFactoryEmail(info.getFactoryEmail());
		vo.setFactoryFax(info.getFactoryFax());
		vo.setFactoryPhone(info.getFactoryPhone());
		vo.setFactoryPostID(info.getFactoryPostId());
		vo.setFactoryRemark(info.getFactoryRemark());
		//时间格式化
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		String date=format.format(info.getFactoryDate());
		vo.setFactoryDate(date);
		
		return vo;
	}
	//插入一条记录
	public void addFactoryInfo(Y_FactoryInfoVO vo) {
		TFactoryInfo info=new TFactoryInfo();
		info.setFactoryAddress(vo.getFactoryAddress());		
		info.setFactoryEmail(vo.getFactoryEmail());
		info.setFactoryFax(vo.getFactoryFax());
		info.setFactoryLinkman(vo.getFactoryLinkMan());
		
		info.setFactoryName(vo.getFactoryName());
		info.setFactoryPhone(vo.getFactoryPhone());
		info.setFactoryRemark(vo.getFactoryRemark());
		info.setFactoryPostId(vo.getFactoryPostID());
		info.setFactoryDate(new Date());
		TGrade tg=new TGrade();
		tg.setGradeId(1);
		info.setTGrade(tg);
		float consumption=0;
		info.setFactoryConsumption(consumption);
		TAreaInfo taf=new TAreaInfo();
		taf.setAreaInfoId(vo.getFactoryAreaID());
		info.setTAreaInfo(taf);
		infoDAO.save(info);		
	}
//google
	public List findTopTen(int fid) {
		List list=infoDAO.findTopTen(fid);
//		List volist=new ArrayList();
//		for (int i = 0; i < 10; i++) {
//			volist.add(list.get(i));
//		}
		return list;
	}

}
