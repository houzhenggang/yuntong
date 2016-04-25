package com.yuntong.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.yuntong.business.vo.CheckRigVO;
import com.yuntong.business.vo.J_FareMathVo;
import com.yuntong.hibernate.database.dao.TAreaFreightInfoDAO;
import com.yuntong.hibernate.database.dao.TGoodsInfoDAO;
import com.yuntong.hibernate.database.dao.TRegisterInfoDAO;
import com.yuntong.hibernate.database.dao.TRegisterStateDAO;

import com.yuntong.hibernate.database.po.TAreaFreightInfo;
import com.yuntong.hibernate.database.po.TGoodsInfo;
import com.yuntong.hibernate.database.po.TRegisterInfo;
import com.yuntong.hibernate.database.po.TRegisterState;

import com.yuntong.service.J_FareMathService;

public class J_FareMathServiceImpl implements J_FareMathService {
 private  TRegisterInfoDAO registerInfoDAO ; 
 private TGoodsInfoDAO goodsInfoDAO  ;
 private TRegisterStateDAO registerStateDAO ;
 private TAreaFreightInfoDAO areaFreightInfoDAO ;
	public J_FareMathVo FindregisterId(int id) {
		
		//po将数据传递给vo
		TRegisterInfo fare=	registerInfoDAO.findById(id);
	     J_FareMathVo farevo=new J_FareMathVo();
	     farevo.setRegisterClientID(fare.getTClientInfo().getClientId());
	     farevo.setRegisterConveyanceId(fare.getRegisterConveyanceId());
	     farevo.setRegisterDate(fare.getRegisterDate());
	     farevo.setRegisterFactoryID(fare.getTFactoryInfo().getFactoryId());
	     farevo.setRegisterGlideId(fare.getRegisterGlideId());
	     farevo.setRegisterGoodsID(fare.getTGoodsInfo().getGoodsId());
          farevo.setRegisterId(fare.getRegisterId());	
          farevo.setRegisterLine(fare.getRegisterLine());
          farevo.setRegisterPayerName(fare.getRegisterPayerName());
          farevo.setRegisterRemark(fare.getRegisterRemark());
          farevo.setRegisterUserID(fare.getTUserInfo().getUserId());
          farevo.setTFreightStyleID(fare.getTFreightStyle().getFreightId());
          farevo.setRstateName(fare.getTRegisterState().getRstateName());
	
    return farevo;
	}
	public void faremath(int typeid, int goodsid) {
		 
	     if(typeid==1){
	    	 TGoodsInfo goods= goodsInfoDAO.findById(goodsid);
	    	 TAreaFreightInfo freight=areaFreightInfoDAO.findById(typeid);
	    	float heft= freight.getAfrerghtHeft();
	    	float goodsheft=goods.getGoodsHeft();
	    	float insurence=goods.getGoodsInsuranceValue();
	        float freights=(heft*goodsheft)+insurence;
	        goods.setGoodsFreight(freights);
	       goodsInfoDAO.getHibernateTemplate().update(goods);
	    
	     }
	 
	     TGoodsInfo goods= goodsInfoDAO.findById(goodsid);
    	 TAreaFreightInfo freight=areaFreightInfoDAO.findById(typeid);
    	 float bulk= freight.getAfrerghtBulk();
    	 float goodsbulk=goods.getGoodsBulk();
    	 float insurence=goods.getGoodsInsuranceValue();
         float freights=(bulk*goodsbulk)+insurence;
         goods.setGoodsFreight(freights);
         goodsInfoDAO.getHibernateTemplate().update(goods);
	     }
	public CheckRigVO CheckRig(int id) {
		
		
		TRegisterInfo fare=	registerInfoDAO.findById(id);
		
		CheckRigVO farevo=new CheckRigVO();
		     farevo.setRegisterClientID(fare.getTClientInfo().getClientId());
		     farevo.setRegisterConveyanceId(fare.getRegisterConveyanceId());
		     farevo.setRegisterDate(fare.getRegisterDate());
		     farevo.setRegisterFactoryID(fare.getTFactoryInfo().getFactoryId());
		     farevo.setRegisterGlideId(fare.getRegisterGlideId());
		     farevo.setRegisterGoodsID(fare.getTGoodsInfo().getGoodsId());
	          farevo.setRegisterId(fare.getRegisterId());	
	          farevo.setRegisterLine(fare.getRegisterLine());
	          farevo.setRegisterPayerName(fare.getRegisterPayerName());
	          farevo.setRegisterRemark(fare.getRegisterRemark());
	          farevo.setRegisterUserID(fare.getTUserInfo().getUserId());
	          farevo.setTFreightStyleID(fare.getTFreightStyle().getFreightId());
	          farevo.setRstateID(fare.getTRegisterState().getRstateId());
	

           return farevo;
		 
	
		
	}
	public void Richange(int rigid ,int typeid){
		TRegisterInfo fare=	registerInfoDAO.findById(rigid);
		if(typeid==1){
			
			 int stateIds=fare.getTRegisterState().getRstateId();
			 TRegisterState sttate=new TRegisterState();
			 sttate.setRstateId(2);
			 fare.setTRegisterState(sttate);
		
			     registerInfoDAO.getHibernateTemplate().update(fare);
			return ;
		}
	  if(typeid==2){
		  
		  int stateIds=fare.getTRegisterState().getRstateId();
			 TRegisterState sttate=new TRegisterState();
			 sttate.setRstateId(4);
		
			     registerInfoDAO.getHibernateTemplate().update(fare);
		return ;
		  
	  }
	 
	  
	}
	public TRegisterInfoDAO getRegisterInfoDAO() {
		return registerInfoDAO;
	}
	public void setRegisterInfoDAO(TRegisterInfoDAO registerInfoDAO) {
		this.registerInfoDAO = registerInfoDAO;
	}
	
	public TAreaFreightInfoDAO getAreaFreightInfoDAO() {
		return areaFreightInfoDAO;
	}
	public void setAreaFreightInfoDAO(TAreaFreightInfoDAO areaFreightInfoDAO) {
		this.areaFreightInfoDAO = areaFreightInfoDAO;
	}
	public TGoodsInfoDAO getGoodsInfoDAO() {
		return goodsInfoDAO;
	}
	public void setGoodsInfoDAO(TGoodsInfoDAO goodsInfoDAO) {
		this.goodsInfoDAO = goodsInfoDAO;
	}
	public TRegisterStateDAO getRegisterStateDAO() {
		return registerStateDAO;
	}
	public void setRegisterStateDAO(TRegisterStateDAO registerStateDAO) {
		this.registerStateDAO = registerStateDAO;
	}
	public List ShowState() {
		
        List list=	registerStateDAO.getstateName();
		return list;
	}
	public void RigStateChange(int rigid, int typeid) {
		TRegisterInfo fare=	registerInfoDAO.findById(rigid);
		if(typeid==2){
			
			// int stateIds=fare.getTRegisterState().getRstateId();
			 TRegisterState sttate=new TRegisterState();
			 sttate.setRstateId(5);
			 fare.setTRegisterState(sttate);
		
			     registerInfoDAO.getHibernateTemplate().update(fare);
			return ;
		}
	  if(typeid==4){
		  
		 // int stateIds=fare.getTRegisterState().getRstateId();
			 TRegisterState sttate=new TRegisterState();
			 sttate.setRstateId(6);
		
			     registerInfoDAO.getHibernateTemplate().update(fare);
		return ;
		  
	  }
	 
		
	}
//	费用估算google
	public List findTopTen(int id) {
		List list=registerInfoDAO.findgsTopTen(id);
		System.out.println("-----------------------------------------------");
		System.out.println(id);
		return list;
	}
	
	



	
	
	

}
