package com.yuntong.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuntong.business.vo.Y_ClientInfoVO;
import com.yuntong.hibernate.database.dao.TClientInfoDAO;
import com.yuntong.hibernate.database.po.TClientInfo;
import com.yuntong.hibernate.database.po.TMarketInfo;
import com.yuntong.service.Y_IClientManagerService;

public class Y_ClientManagerService implements Y_IClientManagerService {
	private TClientInfoDAO infoDAO;
	
	public TClientInfoDAO getInfoDAO() {
		return infoDAO;
	}

	public void setInfoDAO(TClientInfoDAO infoDAO) {
		this.infoDAO = infoDAO;
	}
	//根据客户编号得到客户信息
	public Y_ClientInfoVO findById(Long id) {
		TClientInfo info=infoDAO.findById(id);
		Y_ClientInfoVO infoVO=new Y_ClientInfoVO();
		infoVO.setClientID(Integer.parseInt(id.toString()));
		infoVO.setClientName(info.getClientName());
		infoVO.setClientMarketID(info.getTMarketInfo().getMarketId());
		infoVO.setClientMarketName(info.getTMarketInfo().getMarketName());
		infoVO.setClientAddress(info.getClientAddress());
		infoVO.setClientCompany(info.getClientCompany());
		infoVO.setClientEmail(info.getClientEmail());
		infoVO.setClientPhone(info.getClientPhone());
		infoVO.setClientPostID(info.getClientPostId());
		//格式化时间
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		String date=format.format(info.getClientDate());
		infoVO.setClientDate(date);
		return infoVO;
	}
	//插入信息
	public void addClientInfo(Y_ClientInfoVO vo) {
		TClientInfo info=new TClientInfo();
		info.setClientAddress(vo.getClientAddress());
		info.setClientCompany(vo.getClientCompany());
		info.setClientDate(new Date());
		info.setClientEmail(vo.getClientEmail());
		info.setClientName(vo.getClientName());
		info.setClientPhone(vo.getClientPhone());
		info.setClientPostId(vo.getClientPostID());
		TMarketInfo tm=new TMarketInfo();
		tm.setMarketId(vo.getClientMarketID());
		info.setTMarketInfo(tm);
		infoDAO.save(info);		
	}
	//google

	public List findTopTen(int cid) {
		List list=infoDAO.findTopTen(cid);
		return list;
	}
	

}
