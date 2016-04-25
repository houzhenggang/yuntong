package com.yuntong.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.sqlmap.engine.transaction.TransactionException;
import com.yuntong.business.vo.Y_ClientInfoVO;
import com.yuntong.business.vo.Y_DHQRInfoVO;
import com.yuntong.business.vo.Y_FactoryInfoVO;
import com.yuntong.business.vo.Y_GoodsInfoVO;
import com.yuntong.business.vo.Y_RegisterInfoVO;
import com.yuntong.business.vo.Y_UserInfoVO;
import com.yuntong.hibernate.database.dao.TAreaInfoDAO;
import com.yuntong.hibernate.database.dao.TClientInfoDAO;
import com.yuntong.hibernate.database.dao.TDisrepareInfoDAO;
import com.yuntong.hibernate.database.dao.TDrawInfoDAO;
import com.yuntong.hibernate.database.dao.TDriverInfoDAO;
import com.yuntong.hibernate.database.dao.TFactoryInfoDAO;
import com.yuntong.hibernate.database.dao.TGoodsInfoDAO;
import com.yuntong.hibernate.database.dao.TMarketInfoDAO;
import com.yuntong.hibernate.database.dao.TRegisterInfoDAO;
import com.yuntong.hibernate.database.dao.TTruckInfoDAO;
import com.yuntong.hibernate.database.po.TAreaInfo;
import com.yuntong.hibernate.database.po.TClientInfo;
import com.yuntong.hibernate.database.po.TDrawInfo;
import com.yuntong.hibernate.database.po.TFactoryInfo;
import com.yuntong.hibernate.database.po.TFreightStyle;
import com.yuntong.hibernate.database.po.TGoodsInfo;
import com.yuntong.hibernate.database.po.TGrade;
import com.yuntong.hibernate.database.po.TMarketInfo;
import com.yuntong.hibernate.database.po.TPaymentOfGoodsStyle;
import com.yuntong.hibernate.database.po.TRegisterInfo;
import com.yuntong.hibernate.database.po.TRegisterState;
import com.yuntong.hibernate.database.po.TUserInfo;
import com.yuntong.service.Y_IRegisterManagerService;
/***
 * 
 * @author yqy
 *	货票相关业务处理
 */
public class Y_RegisterManagerService implements Y_IRegisterManagerService {
	private Log log = LogFactory.getLog(Y_RegisterManagerService.class);
	private TFactoryInfoDAO finfoDAO;
	private TClientInfoDAO  cinfoDAO;
	private TGoodsInfoDAO ginfoDAO;
	private TRegisterInfoDAO rinfoDAO;
	private TAreaInfoDAO areaInfoDAO;
	private TMarketInfoDAO marketInfoDAO;
	private TDrawInfoDAO drawInfoDAO;
	private TDisrepareInfoDAO disrepareInfoDAO;
	private TTruckInfoDAO truckInfoDAO;
	private TDriverInfoDAO driverInfoDAO;
	public TDriverInfoDAO getDriverInfoDAO() {
		return driverInfoDAO;
	}
	public void setDriverInfoDAO(TDriverInfoDAO driverInfoDAO) {
		this.driverInfoDAO = driverInfoDAO;
	}
	public TTruckInfoDAO getTruckInfoDAO() {
		return truckInfoDAO;
	}
	public void setTruckInfoDAO(TTruckInfoDAO truckInfoDAO) {
		this.truckInfoDAO = truckInfoDAO;
	}
	public TDisrepareInfoDAO getDisrepareInfoDAO() {
		return disrepareInfoDAO;
	}
	public void setDisrepareInfoDAO(TDisrepareInfoDAO disrepareInfoDAO) {
		this.disrepareInfoDAO = disrepareInfoDAO;
	}
	public TGoodsInfoDAO getGinfoDAO() {
		return ginfoDAO;
	}
	public void setGinfoDAO(TGoodsInfoDAO ginfoDAO) {
		this.ginfoDAO = ginfoDAO;
	}
	public TClientInfoDAO getCinfoDAO() {
		return cinfoDAO;
	}
	public void setCinfoDAO(TClientInfoDAO cinfoDAO) {
		this.cinfoDAO = cinfoDAO;
	}
	public TFactoryInfoDAO getFinfoDAO() {
		return finfoDAO;
	}
	public void setFinfoDAO(TFactoryInfoDAO finfoDAO) {
		this.finfoDAO = finfoDAO;
	}
	public TAreaInfoDAO getAreaInfoDAO() {
		return areaInfoDAO;
	}
	public void setAreaInfoDAO(TAreaInfoDAO areaInfoDAO) {
		this.areaInfoDAO = areaInfoDAO;
	}
	public TMarketInfoDAO getMarketInfoDAO() {
		return marketInfoDAO;
	}
	public void setMarketInfoDAO(TMarketInfoDAO marketInfoDAO) {
		this.marketInfoDAO = marketInfoDAO;
	}
	public TDrawInfoDAO getDrawInfoDAO() {
		return drawInfoDAO;
	}
	public void setDrawInfoDAO(TDrawInfoDAO drawInfoDAO) {
		this.drawInfoDAO = drawInfoDAO;
	}
	public TRegisterInfoDAO getRinfoDAO() {
		return rinfoDAO;
	}
	public void setRinfoDAO(TRegisterInfoDAO rinfoDAO) {
		this.rinfoDAO = rinfoDAO;
	}
	//货票登记
	public Y_RegisterInfoVO addRegisterInfo(Y_FactoryInfoVO finfo, Y_ClientInfoVO cinfo,
			Y_GoodsInfoVO ginfo,Y_UserInfoVO Uvo) {
		log.info("========Dao计价方式"+ginfo.getGoodsPaymentModeid());
		/*
		 * 1登记厂家信息
		 */
		//厂家编号
		int factoryID=0;
		//厂家地区编号
		int fyaid=0;
		
		TFactoryInfo tfinfo=new TFactoryInfo();
		if(finfo.getFactoryID()==9999){
		tfinfo.setFactoryAddress(finfo.getFactoryAddress());		
		tfinfo.setFactoryEmail(finfo.getFactoryEmail());
		tfinfo.setFactoryFax(finfo.getFactoryFax());
		tfinfo.setFactoryLinkman(finfo.getFactoryLinkMan());		
		tfinfo.setFactoryName(finfo.getFactoryName());
		tfinfo.setFactoryPhone(finfo.getFactoryPhone());
		tfinfo.setFactoryRemark(finfo.getFactoryRemark());
		tfinfo.setFactoryPostId(finfo.getFactoryPostID());
		tfinfo.setFactoryDate(new Date());
		TGrade tg=new TGrade();
		tg.setGradeId(1);
		tfinfo.setTGrade(tg);
		float consumption=0;
		tfinfo.setFactoryConsumption(consumption);
		TAreaInfo taf=new TAreaInfo();
		//厂家地区编号
		fyaid=finfo.getFactoryAreaID();
		taf.setAreaInfoId(fyaid);
		tfinfo.setTAreaInfo(taf);
		finfoDAO.save(tfinfo);
		factoryID=Integer.parseInt(finfoDAO.findMaxID().get(0).toString());
		}else{
			fyaid=finfo.getFactoryAreaID();
			factoryID=finfo.getFactoryID();
		}
		
		/*
		 * 2登记客户信息
		 */
		//客户编号
		long clientID;
		//市场编号
		int marid=0;
		TClientInfo tcinfo=new TClientInfo();
		
		if(cinfo.getClientID()==9){
		tcinfo.setClientAddress(cinfo.getClientAddress());
		tcinfo.setClientCompany(cinfo.getClientCompany());
		tcinfo.setClientDate(new Date());
		tcinfo.setClientEmail(cinfo.getClientEmail());
		tcinfo.setClientName(cinfo.getClientName());
		tcinfo.setClientPhone(cinfo.getClientPhone());
		tcinfo.setClientPostId(cinfo.getClientPostID());
		TMarketInfo tm=new TMarketInfo();
		marid=cinfo.getClientMarketID();
		tm.setMarketId(marid);
		tcinfo.setTMarketInfo(tm);
		cinfoDAO.save(tcinfo);
		
		clientID=Long.parseLong(cinfoDAO.findMaxID().get(0).toString());
		}else{
			marid=cinfo.getClientMarketID();
			clientID=cinfo.getClientID();
		}
		/*
		 *3登记货物信息 
		 */				
		
		TGoodsInfo tgInfo=new TGoodsInfo();
		tgInfo.setGoodsBulk(ginfo.getGoodsBulk());				//方量
		tgInfo.setGoodsHeft(ginfo.getGoodsHeft());				//重量
		tgInfo.setGoodsName(ginfo.getGoodsName());				//名称
		long goodsNum=ginfo.getGoodsNumber();
		tgInfo.setGoodsNumber(goodsNum);						//数量
		tgInfo.setGoodsNumberUnit(ginfo.getGoodsNumberUnit());	//单位
		tgInfo.setGoodsRemarkInfo(ginfo.getGoodsRemarkInfo());  //备注
		tgInfo.setGoodsValue(ginfo.getGoodsValue());        	//价值
		TPaymentOfGoodsStyle tstyle=new TPaymentOfGoodsStyle();	//计价方式
		
		tstyle.setPaymentId(ginfo.getGoodsPaymentModeid());
		tgInfo.setTPaymentOfGoodsStyle(tstyle);
		log.info("================================"+tgInfo.getTPaymentOfGoodsStyle().getPaymentId());		
		ginfoDAO.save(tgInfo);
		//货物编号
		int goodsID=tgInfo.getGoodsId();
		/*
		 *4登记货票 
		 */		
		//封装货票信息
		TRegisterInfo rInfo=new TRegisterInfo();
		//厂家编号
		TFactoryInfo tempfinfo=new TFactoryInfo();
		tempfinfo.setFactoryId(factoryID);
		rInfo.setTFactoryInfo(tempfinfo);
		//客户编号
		TClientInfo tempcinfo=new TClientInfo();
		tempcinfo.setClientId(clientID);
		rInfo.setTClientInfo(tempcinfo);
		//货物编号
		TGoodsInfo tempginfo=new TGoodsInfo();
		tempginfo.setGoodsId(goodsID);
		rInfo.setTGoodsInfo(tempginfo);
		//货票编号
		long myday=this.createDayNum();		
		rInfo.setRegisterGlideId(myday);
		//运输编号(客户编号+流水号+件数)
		int dayNum=this.createDayNumLuShui();
		String temp1="";													
		if(dayNum<100000000){temp1="";}
		if(dayNum<10000000){temp1="0";}
		if(dayNum<1000000){temp1="00";}
		if(dayNum<100000){temp1="000";}
		if(dayNum<10000){temp1="0000";}
		if(dayNum<1000){temp1="00000";}
		if(dayNum<100){temp1="000000";}
		if(dayNum<10){temp1="0000000";}
		String temp2="";
		if(goodsNum<10000){temp2="";}
		if(goodsNum<1000){temp2="0";}
		if(goodsNum<100){temp2="00";}
		if(goodsNum<10){temp2="000";}
		String conveyanceID=clientID+temp1+dayNum+temp2+goodsNum;
		rInfo.setRegisterConveyanceId(conveyanceID);
		//运输线路
		TAreaInfo areainfo= areaInfoDAO.findById(fyaid);
		String staName=areainfo.getAreaCity();
		TMarketInfo marketinfo= marketInfoDAO.findById(marid);
		String endName=marketinfo.getTAreaInfo().getAreaCity();
		String registerLine=staName+"-"+endName;
		rInfo.setRegisterLine(registerLine);
		//结算方式
		TFreightStyle freightStyle=new TFreightStyle();
		freightStyle.setFreightId(ginfo.getBuyStyleID());
		rInfo.setTFreightStyle(freightStyle);
		//付款人
		//操作员
		TUserInfo uinfo=new TUserInfo();
		uinfo.setUserId(Uvo.getUserId());
		rInfo.setTUserInfo(uinfo);
		//知单时间
		rInfo.setRegisterDate(new Date());
		//状态编号
		TRegisterState state=new TRegisterState();
		state.setRstateId(1);
		rInfo.setTRegisterState(state);
		//保存数据
		rinfoDAO.save(rInfo);
		return this.registerPoToVo(rInfo, tgInfo);
	}
	//货票信息封装转换
	public Y_RegisterInfoVO registerPoToVo(TRegisterInfo rinfo,TGoodsInfo ginfo){
		Y_RegisterInfoVO rvo=new Y_RegisterInfoVO();
		//货票
		rvo.setRegisterID(rinfo.getRegisterId());
		rvo.setRegisterUserID(rinfo.getTUserInfo().getUserId());
		rvo.setRegisterState(rinfo.getTRegisterState().getRstateId());
		rvo.setRegisterRemark(rinfo.getRegisterRemark());
		rvo.setRegisterClientID(rinfo.getTClientInfo().getClientId());
		rvo.setRegisterConveyanceID(rinfo.getRegisterConveyanceId());
		rvo.setRegisterDate(rinfo.getRegisterDate());
		SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");
		String Mydate=format.format(rinfo.getRegisterDate());
		rvo.setStrDate(Mydate);
		rvo.setRegisterFactoryID(rinfo.getTFactoryInfo().getFactoryId());
		rvo.setRegisterFreightID(rinfo.getTFreightStyle().getFreightId());
		rvo.setRegisterGlideID(rinfo.getRegisterGlideId());
		rvo.setRegisterLine(rinfo.getRegisterLine());
		return rvo;
	}
	//货票编号
	public long createDayNum(){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		String Mydate=format.format(new Date());
		String date="";
		List list=rinfoDAO.findDayNum();
		int j=1;
		for (int i = 0; i < list.size(); i++) {
			date=format.format(((TRegisterInfo)(list.get(i))).getRegisterDate());
			if(date.equals(Mydate)){
				j++;
			}
		}
		String temp1="";													
		if(j<10000){temp1="";}
		if(j<1000){temp1="0";}
		if(j<100){temp1="00";}
		if(j<10){temp1="000";}
		long dayNum=Long.parseLong(Mydate+temp1+j);
		return dayNum;				
	}
	//流水号
	public int createDayNumLuShui(){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		String Mydate=format.format(new Date());
		String date="";
		List list=rinfoDAO.findDayNum();
		int j=1;
		for (int i = 0; i < list.size(); i++) {
			date=format.format(((TRegisterInfo)(list.get(i))).getRegisterDate());
			if(date.equals(Mydate)){
				j++;
			}
		}
		return j;
	}
	
//	根据业务编号或运输编号得到货票信息
	public Y_DHQRInfoVO findRegisterInfoByInputID(String inputID,int typeID) {
		//货票数据库编号
		int rid=0;
		//判断查询类型
		if(typeID==1){
		//根据业务编号得到数据库编号	
		rid=this.findRegisterID(Long.parseLong(inputID));
		}
		else{
			//根据运输编号得到数据库编号
			rid=this.findRegisterIDByRunID(Long.parseLong(inputID));
		}
		log.info("--------"+rid);
		//根据货票数据库编号得到领票信息
		TDrawInfo dinfo=new TDrawInfo();		
		dinfo=this.findDrawInfoByRegisterID(rid);
		log.info("状态编号：-------------------"+dinfo.getTRegisterInfo().getTRegisterState().getRstateId());

		//封装界面信息
		Y_DHQRInfoVO vo=new Y_DHQRInfoVO();
		//===================================货票相关=====================================
		//数据库编号
		vo.setRegisterID(rid);
		//状态编号
		vo.setRegisterState(dinfo.getTRegisterInfo().getTRegisterState().getRstateId());
		//用户名
		log.info("用户名："+dinfo.getTRegisterInfo().getTClientInfo().getClientCompany());
		vo.setRegisterClientName(dinfo.getTRegisterInfo().getTClientInfo().getClientCompany());
		//用户电话
		vo.setRegisterClientPhone(dinfo.getTRegisterInfo().getTClientInfo().getClientPhone());
		//厂商名
		vo.setRegisterFactoryName(dinfo.getTRegisterInfo().getTFactoryInfo().getFactoryName());
		//厂商电话
		vo.setRegisterFactoryphone(dinfo.getTRegisterInfo().getTFactoryInfo().getFactoryPhone());
		//货票编号
		vo.setRegisterGlideID(dinfo.getTRegisterInfo().getRegisterGlideId());
		//运输线路
		vo.setRegisterLine(dinfo.getTRegisterInfo().getRegisterLine());
		log.info("运输线路"+dinfo.getTRegisterInfo().getRegisterLine());
		//运输编号
		vo.setRegisterConveyanceID(dinfo.getTRegisterInfo().getRegisterConveyanceId());
		//运费结算方式
		vo.setRegisterFreightName(dinfo.getTRegisterInfo().getTFreightStyle().getFreightName());
		//制单时间
		vo.setRegisterDate(dinfo.getTRegisterInfo().getRegisterDate());
		//格式化知单时间
		SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd--hh:mm:ss");
		String Mydate=format.format(dinfo.getTRegisterInfo().getRegisterDate());
		vo.setStrDate(Mydate);
		log.info("知单时间"+Mydate);
		//==================================货物相关========================================
		
		//货物名称
		vo.setGoodsName(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsName());
		log.info("货物名称："+dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsName());
		//货物件数
		vo.setGoodsNumber(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsNumber());
		//重量
		vo.setGoodsHeft(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsHeft());
		//方量
		vo.setGoodsBulk(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsBulk());
		//计价方式
		log.info("计价方式:"+dinfo.getTRegisterInfo().getTGoodsInfo().getTPaymentOfGoodsStyle().getPaymentName());
		vo.setGoodsPaymentModeName(dinfo.getTRegisterInfo().getTGoodsInfo().getTPaymentOfGoodsStyle().getPaymentName());
		//运费
		vo.setGoodsFreight(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsFreight());
		float yunfei=dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsFreight();
		log.info("运费："+yunfei);
		//保费
		vo.setGoodsInsuranceValue(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsInsuranceValue());
		float baofei=dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsInsuranceValue();
		log.info("保费："+baofei);
		//合计
		float heji=yunfei+baofei;
		log.info("合计："+heji);
		vo.setGoodsAllValue(heji);
//		==================================车次相关========================================
		//司机
		vo.setDriverName(dinfo.getDrawRoadwayId().getTDriverInfo().getDriverName());
		//司机编号
		vo.setDriverId(dinfo.getDrawRoadwayId().getTDriverInfo().getDriverId());
		//车辆编号
		vo.setCatId(dinfo.getDrawRoadwayId().getTTruckInfo().getTruckId());
		//车牌
		vo.setCarName(dinfo.getDrawRoadwayId().getTTruckInfo().getTruckNum());
		//发货时间
		vo.setStartDate(dinfo.getDrawRoadwayId().getRoadStartDate());
		//格式化发货时间		
		String formatdate=format.format(dinfo.getDrawRoadwayId().getRoadStartDate());
		vo.setFormatStartDate(formatdate);
		log.info("发货时间："+formatdate);
		log.info("==========================成功得到所有查询信息===========================");
		
		//===================================更改货票状态==================================
		//this.updateRegisterType(rid, updateStateid);
		return vo;
	}
	//修改货票状态(编号，目标状态)
	public void updateRegisterType(int rid,int updateState){
		rinfoDAO.updateRegisterState(rid, updateState);
		log.info("成功修改货票状态");
	}
//根据货票编号得到领票信息
	public TDrawInfo findDrawInfoByRegisterID(int rid) {
		TDrawInfo info=drawInfoDAO.findDrawInfoByRegisterID(rid);
		return info;
	}
//	根据货票业务编号得到编号
	public int findRegisterID(long rid){
		log.info("========================================="+rid);
		TRegisterInfo info=rinfoDAO.findRegisterInfoByGlideID(rid);
		int id=info.getRegisterId();
		log.info("真实编号："+id);
		return id;
	}
// 根据运输编号得到货票编号	
	public int findRegisterIDByRunID(Long rid){
		TRegisterInfo info=rinfoDAO.findRegisterInfoByConveyanceID(rid+"");
		int id=info.getRegisterId();
		return id;
	}
	//根据业务编号得到货票信息
	public Y_DHQRInfoVO findRegisterInfoByInputID(String inputID) {
//		货票数据库编号
		int rid=0;
		//判断查询类型
		
		//根据业务编号得到数据库编号	
		rid=this.findRegisterID(Long.parseLong(inputID));
		
		
		log.info("--------"+rid);
		//根据货票数据库编号得到领票信息
		TDrawInfo dinfo=new TDrawInfo();		
		dinfo=this.findDrawInfoByRegisterID(rid);
		log.info("状态编号：-------------------"+dinfo.getTRegisterInfo().getTRegisterState().getRstateId());

		//封装界面信息
		Y_DHQRInfoVO vo=new Y_DHQRInfoVO();
		//===================================货票相关=====================================
		//数据库编号
		vo.setRegisterID(rid);
		//状态编号
		vo.setRegisterState(dinfo.getTRegisterInfo().getTRegisterState().getRstateId());
		//用户名
		log.info("用户名："+dinfo.getTRegisterInfo().getTClientInfo().getClientCompany());
		vo.setRegisterClientName(dinfo.getTRegisterInfo().getTClientInfo().getClientCompany());
		//用户电话
		vo.setRegisterClientPhone(dinfo.getTRegisterInfo().getTClientInfo().getClientPhone());
		//厂商名
		vo.setRegisterFactoryName(dinfo.getTRegisterInfo().getTFactoryInfo().getFactoryName());
		//厂商电话
		vo.setRegisterFactoryphone(dinfo.getTRegisterInfo().getTFactoryInfo().getFactoryPhone());
		//货票编号
		vo.setRegisterGlideID(dinfo.getTRegisterInfo().getRegisterGlideId());
		//运输线路
		vo.setRegisterLine(dinfo.getTRegisterInfo().getRegisterLine());
		log.info("运输线路"+dinfo.getTRegisterInfo().getRegisterLine());
		//运输编号
		vo.setRegisterConveyanceID(dinfo.getTRegisterInfo().getRegisterConveyanceId());
		//运费结算方式
		vo.setRegisterFreightName(dinfo.getTRegisterInfo().getTFreightStyle().getFreightName());
		//制单时间
		vo.setRegisterDate(dinfo.getTRegisterInfo().getRegisterDate());
		//格式化知单时间
		SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd--hh:mm:ss");
		String Mydate=format.format(dinfo.getTRegisterInfo().getRegisterDate());
		vo.setStrDate(Mydate);
		log.info("知单时间"+Mydate);
		//==================================货物相关========================================
		
		//货物名称
		vo.setGoodsName(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsName());
		log.info("货物名称："+dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsName());
		//货物件数
		vo.setGoodsNumber(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsNumber());
		//重量
		vo.setGoodsHeft(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsHeft());
		//方量
		vo.setGoodsBulk(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsBulk());
		//计价方式
		log.info("计价方式:"+dinfo.getTRegisterInfo().getTGoodsInfo().getTPaymentOfGoodsStyle().getPaymentName());
		vo.setGoodsPaymentModeName(dinfo.getTRegisterInfo().getTGoodsInfo().getTPaymentOfGoodsStyle().getPaymentName());
		//运费
		vo.setGoodsFreight(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsFreight());
		float yunfei=dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsFreight();
		log.info("运费："+yunfei);
		//保费
		vo.setGoodsInsuranceValue(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsInsuranceValue());
		float baofei=dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsInsuranceValue();
		log.info("保费："+baofei);
		//合计
		float heji=yunfei+baofei;
		log.info("合计："+heji);
		vo.setGoodsAllValue(heji);
		//==================================车次相关========================================
		//车次编号
		vo.setRoadwayID(dinfo.getDrawRoadwayId().getRoadwayId());
		//司机
		vo.setDriverName(dinfo.getDrawRoadwayId().getTDriverInfo().getDriverName());
		//车牌
		vo.setCarName(dinfo.getDrawRoadwayId().getTTruckInfo().getTruckNum());
		//发货时间
		vo.setStartDate(dinfo.getDrawRoadwayId().getRoadStartDate());
		//格式化发货时间		
		String formatdate=format.format(dinfo.getDrawRoadwayId().getRoadStartDate());
		vo.setFormatStartDate(formatdate);
		log.info("发货时间："+formatdate);
		log.info("==========================成功得到所有查询信息===========================");
		
		//===================================更改货票状态==================================
		//this.updateRegisterType(rid, updateStateid);
		return vo;
	}
	//填加损货信息
	public boolean insertDisrepareInfo(int rid, int roid, float money, String cause) {
		disrepareInfoDAO.save(rid, roid, money, cause);
		return false;
	}
	//根据货票编号得到车次编号
	public int findRoidByRid(int rid) {
//		根据货票数据库编号得到领票信息
		TDrawInfo dinfo=new TDrawInfo();		
		dinfo=this.findDrawInfoByRegisterID(rid);
		int roid=dinfo.getDrawRoadwayId().getRoadwayId();
		return roid;
	}
	//修改司机和车辆的状态为空闲
	public void updateCarAndDriver(int cid, int did) {
		log.info("修改状态开始================================");
		truckInfoDAO.updataCarState(cid);
		driverInfoDAO.updateDriverState(did);
		log.info("修改状态成功================================");
	}
	//到货确认google
	public List findTopTen(String id, String ty) {
		List list=rinfoDAO.findTopTen(id, ty);
		return list;
	}
	//孙货登记google
	public List findTopTen(String id) {
		List list=rinfoDAO.findTopTen(id);
		return list;
	}
}
