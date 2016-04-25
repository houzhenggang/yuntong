package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yuntong.business.vo.G_RegisterAndGoodsInfoVO;
import com.yuntong.hibernate.database.dao.TRegisterInfoDAO;
import com.yuntong.hibernate.database.dao.TRegisterStateDAO;
import com.yuntong.hibernate.database.po.TRegisterInfo;
import com.yuntong.hibernate.database.po.TRegisterState;
import com.yuntong.service.G_IRegisterInfoService;

public class G_RegisterInfoService implements G_IRegisterInfoService {
	private TRegisterInfoDAO registerInfoDAO;
	private TRegisterStateDAO registerStateDAO;
	public TRegisterStateDAO getRegisterStateDAO() {
		return registerStateDAO;
	}
	public void setRegisterStateDAO(TRegisterStateDAO registerStateDAO) {
		this.registerStateDAO = registerStateDAO;
	}
	public TRegisterInfoDAO getRegisterInfoDAO() {
		return registerInfoDAO;
	}
	public void setRegisterInfoDAO(TRegisterInfoDAO registerInfoDAO) {
		this.registerInfoDAO = registerInfoDAO;
	}
	/**
	 * 查找货票信息
	 * @return
	 */
	public G_RegisterAndGoodsInfoVO findRegisterInfoByRegisterGlideID(long registerGlideId){
		List list=registerInfoDAO.findRegisterInfoByRigeterGlideId(registerGlideId);
		TRegisterInfo info= (TRegisterInfo) list.get(0);
		G_RegisterAndGoodsInfoVO vo=new G_RegisterAndGoodsInfoVO();
		vo.setRegisterGlideID(info.getRegisterGlideId());
		String stat=info.getTRegisterState().getRstateName();
		if(stat.equals("收讫已付款") || stat.equals("提付未付款")){
			vo.setRegisterState(1);
		}
		if(stat.equals("到货已登记收讫") || stat.equals("到货已登记提付")){
			vo.setRegisterState(2);
		}
		vo.setGoodsBulk(info.getTGoodsInfo().getGoodsBulk());
		vo.setGoodsHeft(info.getTGoodsInfo().getGoodsHeft());
		vo.setGoodsName(info.getTGoodsInfo().getGoodsName());
		vo.setGoodsNumber(info.getTGoodsInfo().getGoodsNumber());
		vo.setGoodsNumberUnit(info.getTGoodsInfo().getGoodsNumberUnit());
		return vo;
	}
	public int[] getTotalRegisterByYear(String year) {
		int[] counts=new int[12];
		List list=registerInfoDAO.getRegisterInfoByYear(year);
		for(int j=0;j<12;j++){
			for (int i = 0; i < list.size(); i++) {
				TRegisterInfo info=(TRegisterInfo) list.get(i);
				String[] dates=info.getRegisterDate().toString().split("-");
				String month=dates[1];
				if (month.equals("0"+(j+1)) || month.equals(j+1+"")) {
					counts[j]+=1;
				}
			}
		}
		return counts;
	}
	public void changeRegisterState(long registerGlideId) {
		TRegisterInfo info=(TRegisterInfo) registerInfoDAO.findByRegisterGlideId(registerGlideId).get(0);
		TRegisterState state=registerStateDAO.findById(7);
		info.setTRegisterState(state);
		registerInfoDAO.changeRegisterState(info);
	}
	public List getRegisterInfoListByID(String id, int type) {
		List list=registerInfoDAO.getRegisterInfoListByID(id, type);
		List l=new ArrayList();
		l.clear();
		for (int i = 0; i < list.size(); i++) {
			G_RegisterAndGoodsInfoVO vo=new G_RegisterAndGoodsInfoVO();
			TRegisterInfo info=(TRegisterInfo) list.get(i);
			vo.setRegisterGlideID(info.getRegisterGlideId());
			l.add(vo);
		}
		return l;
	}
}
