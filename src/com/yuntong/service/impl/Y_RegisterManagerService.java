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
 *	��Ʊ���ҵ����
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
	//��Ʊ�Ǽ�
	public Y_RegisterInfoVO addRegisterInfo(Y_FactoryInfoVO finfo, Y_ClientInfoVO cinfo,
			Y_GoodsInfoVO ginfo,Y_UserInfoVO Uvo) {
		log.info("========Dao�Ƽ۷�ʽ"+ginfo.getGoodsPaymentModeid());
		/*
		 * 1�Ǽǳ�����Ϣ
		 */
		//���ұ��
		int factoryID=0;
		//���ҵ������
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
		//���ҵ������
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
		 * 2�Ǽǿͻ���Ϣ
		 */
		//�ͻ����
		long clientID;
		//�г����
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
		 *3�Ǽǻ�����Ϣ 
		 */				
		
		TGoodsInfo tgInfo=new TGoodsInfo();
		tgInfo.setGoodsBulk(ginfo.getGoodsBulk());				//����
		tgInfo.setGoodsHeft(ginfo.getGoodsHeft());				//����
		tgInfo.setGoodsName(ginfo.getGoodsName());				//����
		long goodsNum=ginfo.getGoodsNumber();
		tgInfo.setGoodsNumber(goodsNum);						//����
		tgInfo.setGoodsNumberUnit(ginfo.getGoodsNumberUnit());	//��λ
		tgInfo.setGoodsRemarkInfo(ginfo.getGoodsRemarkInfo());  //��ע
		tgInfo.setGoodsValue(ginfo.getGoodsValue());        	//��ֵ
		TPaymentOfGoodsStyle tstyle=new TPaymentOfGoodsStyle();	//�Ƽ۷�ʽ
		
		tstyle.setPaymentId(ginfo.getGoodsPaymentModeid());
		tgInfo.setTPaymentOfGoodsStyle(tstyle);
		log.info("================================"+tgInfo.getTPaymentOfGoodsStyle().getPaymentId());		
		ginfoDAO.save(tgInfo);
		//������
		int goodsID=tgInfo.getGoodsId();
		/*
		 *4�Ǽǻ�Ʊ 
		 */		
		//��װ��Ʊ��Ϣ
		TRegisterInfo rInfo=new TRegisterInfo();
		//���ұ��
		TFactoryInfo tempfinfo=new TFactoryInfo();
		tempfinfo.setFactoryId(factoryID);
		rInfo.setTFactoryInfo(tempfinfo);
		//�ͻ����
		TClientInfo tempcinfo=new TClientInfo();
		tempcinfo.setClientId(clientID);
		rInfo.setTClientInfo(tempcinfo);
		//������
		TGoodsInfo tempginfo=new TGoodsInfo();
		tempginfo.setGoodsId(goodsID);
		rInfo.setTGoodsInfo(tempginfo);
		//��Ʊ���
		long myday=this.createDayNum();		
		rInfo.setRegisterGlideId(myday);
		//������(�ͻ����+��ˮ��+����)
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
		//������·
		TAreaInfo areainfo= areaInfoDAO.findById(fyaid);
		String staName=areainfo.getAreaCity();
		TMarketInfo marketinfo= marketInfoDAO.findById(marid);
		String endName=marketinfo.getTAreaInfo().getAreaCity();
		String registerLine=staName+"-"+endName;
		rInfo.setRegisterLine(registerLine);
		//���㷽ʽ
		TFreightStyle freightStyle=new TFreightStyle();
		freightStyle.setFreightId(ginfo.getBuyStyleID());
		rInfo.setTFreightStyle(freightStyle);
		//������
		//����Ա
		TUserInfo uinfo=new TUserInfo();
		uinfo.setUserId(Uvo.getUserId());
		rInfo.setTUserInfo(uinfo);
		//֪��ʱ��
		rInfo.setRegisterDate(new Date());
		//״̬���
		TRegisterState state=new TRegisterState();
		state.setRstateId(1);
		rInfo.setTRegisterState(state);
		//��������
		rinfoDAO.save(rInfo);
		return this.registerPoToVo(rInfo, tgInfo);
	}
	//��Ʊ��Ϣ��װת��
	public Y_RegisterInfoVO registerPoToVo(TRegisterInfo rinfo,TGoodsInfo ginfo){
		Y_RegisterInfoVO rvo=new Y_RegisterInfoVO();
		//��Ʊ
		rvo.setRegisterID(rinfo.getRegisterId());
		rvo.setRegisterUserID(rinfo.getTUserInfo().getUserId());
		rvo.setRegisterState(rinfo.getTRegisterState().getRstateId());
		rvo.setRegisterRemark(rinfo.getRegisterRemark());
		rvo.setRegisterClientID(rinfo.getTClientInfo().getClientId());
		rvo.setRegisterConveyanceID(rinfo.getRegisterConveyanceId());
		rvo.setRegisterDate(rinfo.getRegisterDate());
		SimpleDateFormat format=new SimpleDateFormat("yyyy��MM��dd��");
		String Mydate=format.format(rinfo.getRegisterDate());
		rvo.setStrDate(Mydate);
		rvo.setRegisterFactoryID(rinfo.getTFactoryInfo().getFactoryId());
		rvo.setRegisterFreightID(rinfo.getTFreightStyle().getFreightId());
		rvo.setRegisterGlideID(rinfo.getRegisterGlideId());
		rvo.setRegisterLine(rinfo.getRegisterLine());
		return rvo;
	}
	//��Ʊ���
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
	//��ˮ��
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
	
//	����ҵ���Ż������ŵõ���Ʊ��Ϣ
	public Y_DHQRInfoVO findRegisterInfoByInputID(String inputID,int typeID) {
		//��Ʊ���ݿ���
		int rid=0;
		//�жϲ�ѯ����
		if(typeID==1){
		//����ҵ���ŵõ����ݿ���	
		rid=this.findRegisterID(Long.parseLong(inputID));
		}
		else{
			//���������ŵõ����ݿ���
			rid=this.findRegisterIDByRunID(Long.parseLong(inputID));
		}
		log.info("--------"+rid);
		//���ݻ�Ʊ���ݿ��ŵõ���Ʊ��Ϣ
		TDrawInfo dinfo=new TDrawInfo();		
		dinfo=this.findDrawInfoByRegisterID(rid);
		log.info("״̬��ţ�-------------------"+dinfo.getTRegisterInfo().getTRegisterState().getRstateId());

		//��װ������Ϣ
		Y_DHQRInfoVO vo=new Y_DHQRInfoVO();
		//===================================��Ʊ���=====================================
		//���ݿ���
		vo.setRegisterID(rid);
		//״̬���
		vo.setRegisterState(dinfo.getTRegisterInfo().getTRegisterState().getRstateId());
		//�û���
		log.info("�û�����"+dinfo.getTRegisterInfo().getTClientInfo().getClientCompany());
		vo.setRegisterClientName(dinfo.getTRegisterInfo().getTClientInfo().getClientCompany());
		//�û��绰
		vo.setRegisterClientPhone(dinfo.getTRegisterInfo().getTClientInfo().getClientPhone());
		//������
		vo.setRegisterFactoryName(dinfo.getTRegisterInfo().getTFactoryInfo().getFactoryName());
		//���̵绰
		vo.setRegisterFactoryphone(dinfo.getTRegisterInfo().getTFactoryInfo().getFactoryPhone());
		//��Ʊ���
		vo.setRegisterGlideID(dinfo.getTRegisterInfo().getRegisterGlideId());
		//������·
		vo.setRegisterLine(dinfo.getTRegisterInfo().getRegisterLine());
		log.info("������·"+dinfo.getTRegisterInfo().getRegisterLine());
		//������
		vo.setRegisterConveyanceID(dinfo.getTRegisterInfo().getRegisterConveyanceId());
		//�˷ѽ��㷽ʽ
		vo.setRegisterFreightName(dinfo.getTRegisterInfo().getTFreightStyle().getFreightName());
		//�Ƶ�ʱ��
		vo.setRegisterDate(dinfo.getTRegisterInfo().getRegisterDate());
		//��ʽ��֪��ʱ��
		SimpleDateFormat format=new SimpleDateFormat("yyyy��MM��dd--hh:mm:ss");
		String Mydate=format.format(dinfo.getTRegisterInfo().getRegisterDate());
		vo.setStrDate(Mydate);
		log.info("֪��ʱ��"+Mydate);
		//==================================�������========================================
		
		//��������
		vo.setGoodsName(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsName());
		log.info("�������ƣ�"+dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsName());
		//�������
		vo.setGoodsNumber(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsNumber());
		//����
		vo.setGoodsHeft(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsHeft());
		//����
		vo.setGoodsBulk(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsBulk());
		//�Ƽ۷�ʽ
		log.info("�Ƽ۷�ʽ:"+dinfo.getTRegisterInfo().getTGoodsInfo().getTPaymentOfGoodsStyle().getPaymentName());
		vo.setGoodsPaymentModeName(dinfo.getTRegisterInfo().getTGoodsInfo().getTPaymentOfGoodsStyle().getPaymentName());
		//�˷�
		vo.setGoodsFreight(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsFreight());
		float yunfei=dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsFreight();
		log.info("�˷ѣ�"+yunfei);
		//����
		vo.setGoodsInsuranceValue(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsInsuranceValue());
		float baofei=dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsInsuranceValue();
		log.info("���ѣ�"+baofei);
		//�ϼ�
		float heji=yunfei+baofei;
		log.info("�ϼƣ�"+heji);
		vo.setGoodsAllValue(heji);
//		==================================�������========================================
		//˾��
		vo.setDriverName(dinfo.getDrawRoadwayId().getTDriverInfo().getDriverName());
		//˾�����
		vo.setDriverId(dinfo.getDrawRoadwayId().getTDriverInfo().getDriverId());
		//�������
		vo.setCatId(dinfo.getDrawRoadwayId().getTTruckInfo().getTruckId());
		//����
		vo.setCarName(dinfo.getDrawRoadwayId().getTTruckInfo().getTruckNum());
		//����ʱ��
		vo.setStartDate(dinfo.getDrawRoadwayId().getRoadStartDate());
		//��ʽ������ʱ��		
		String formatdate=format.format(dinfo.getDrawRoadwayId().getRoadStartDate());
		vo.setFormatStartDate(formatdate);
		log.info("����ʱ�䣺"+formatdate);
		log.info("==========================�ɹ��õ����в�ѯ��Ϣ===========================");
		
		//===================================���Ļ�Ʊ״̬==================================
		//this.updateRegisterType(rid, updateStateid);
		return vo;
	}
	//�޸Ļ�Ʊ״̬(��ţ�Ŀ��״̬)
	public void updateRegisterType(int rid,int updateState){
		rinfoDAO.updateRegisterState(rid, updateState);
		log.info("�ɹ��޸Ļ�Ʊ״̬");
	}
//���ݻ�Ʊ��ŵõ���Ʊ��Ϣ
	public TDrawInfo findDrawInfoByRegisterID(int rid) {
		TDrawInfo info=drawInfoDAO.findDrawInfoByRegisterID(rid);
		return info;
	}
//	���ݻ�Ʊҵ���ŵõ����
	public int findRegisterID(long rid){
		log.info("========================================="+rid);
		TRegisterInfo info=rinfoDAO.findRegisterInfoByGlideID(rid);
		int id=info.getRegisterId();
		log.info("��ʵ��ţ�"+id);
		return id;
	}
// ���������ŵõ���Ʊ���	
	public int findRegisterIDByRunID(Long rid){
		TRegisterInfo info=rinfoDAO.findRegisterInfoByConveyanceID(rid+"");
		int id=info.getRegisterId();
		return id;
	}
	//����ҵ���ŵõ���Ʊ��Ϣ
	public Y_DHQRInfoVO findRegisterInfoByInputID(String inputID) {
//		��Ʊ���ݿ���
		int rid=0;
		//�жϲ�ѯ����
		
		//����ҵ���ŵõ����ݿ���	
		rid=this.findRegisterID(Long.parseLong(inputID));
		
		
		log.info("--------"+rid);
		//���ݻ�Ʊ���ݿ��ŵõ���Ʊ��Ϣ
		TDrawInfo dinfo=new TDrawInfo();		
		dinfo=this.findDrawInfoByRegisterID(rid);
		log.info("״̬��ţ�-------------------"+dinfo.getTRegisterInfo().getTRegisterState().getRstateId());

		//��װ������Ϣ
		Y_DHQRInfoVO vo=new Y_DHQRInfoVO();
		//===================================��Ʊ���=====================================
		//���ݿ���
		vo.setRegisterID(rid);
		//״̬���
		vo.setRegisterState(dinfo.getTRegisterInfo().getTRegisterState().getRstateId());
		//�û���
		log.info("�û�����"+dinfo.getTRegisterInfo().getTClientInfo().getClientCompany());
		vo.setRegisterClientName(dinfo.getTRegisterInfo().getTClientInfo().getClientCompany());
		//�û��绰
		vo.setRegisterClientPhone(dinfo.getTRegisterInfo().getTClientInfo().getClientPhone());
		//������
		vo.setRegisterFactoryName(dinfo.getTRegisterInfo().getTFactoryInfo().getFactoryName());
		//���̵绰
		vo.setRegisterFactoryphone(dinfo.getTRegisterInfo().getTFactoryInfo().getFactoryPhone());
		//��Ʊ���
		vo.setRegisterGlideID(dinfo.getTRegisterInfo().getRegisterGlideId());
		//������·
		vo.setRegisterLine(dinfo.getTRegisterInfo().getRegisterLine());
		log.info("������·"+dinfo.getTRegisterInfo().getRegisterLine());
		//������
		vo.setRegisterConveyanceID(dinfo.getTRegisterInfo().getRegisterConveyanceId());
		//�˷ѽ��㷽ʽ
		vo.setRegisterFreightName(dinfo.getTRegisterInfo().getTFreightStyle().getFreightName());
		//�Ƶ�ʱ��
		vo.setRegisterDate(dinfo.getTRegisterInfo().getRegisterDate());
		//��ʽ��֪��ʱ��
		SimpleDateFormat format=new SimpleDateFormat("yyyy��MM��dd--hh:mm:ss");
		String Mydate=format.format(dinfo.getTRegisterInfo().getRegisterDate());
		vo.setStrDate(Mydate);
		log.info("֪��ʱ��"+Mydate);
		//==================================�������========================================
		
		//��������
		vo.setGoodsName(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsName());
		log.info("�������ƣ�"+dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsName());
		//�������
		vo.setGoodsNumber(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsNumber());
		//����
		vo.setGoodsHeft(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsHeft());
		//����
		vo.setGoodsBulk(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsBulk());
		//�Ƽ۷�ʽ
		log.info("�Ƽ۷�ʽ:"+dinfo.getTRegisterInfo().getTGoodsInfo().getTPaymentOfGoodsStyle().getPaymentName());
		vo.setGoodsPaymentModeName(dinfo.getTRegisterInfo().getTGoodsInfo().getTPaymentOfGoodsStyle().getPaymentName());
		//�˷�
		vo.setGoodsFreight(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsFreight());
		float yunfei=dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsFreight();
		log.info("�˷ѣ�"+yunfei);
		//����
		vo.setGoodsInsuranceValue(dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsInsuranceValue());
		float baofei=dinfo.getTRegisterInfo().getTGoodsInfo().getGoodsInsuranceValue();
		log.info("���ѣ�"+baofei);
		//�ϼ�
		float heji=yunfei+baofei;
		log.info("�ϼƣ�"+heji);
		vo.setGoodsAllValue(heji);
		//==================================�������========================================
		//���α��
		vo.setRoadwayID(dinfo.getDrawRoadwayId().getRoadwayId());
		//˾��
		vo.setDriverName(dinfo.getDrawRoadwayId().getTDriverInfo().getDriverName());
		//����
		vo.setCarName(dinfo.getDrawRoadwayId().getTTruckInfo().getTruckNum());
		//����ʱ��
		vo.setStartDate(dinfo.getDrawRoadwayId().getRoadStartDate());
		//��ʽ������ʱ��		
		String formatdate=format.format(dinfo.getDrawRoadwayId().getRoadStartDate());
		vo.setFormatStartDate(formatdate);
		log.info("����ʱ�䣺"+formatdate);
		log.info("==========================�ɹ��õ����в�ѯ��Ϣ===========================");
		
		//===================================���Ļ�Ʊ״̬==================================
		//this.updateRegisterType(rid, updateStateid);
		return vo;
	}
	//��������Ϣ
	public boolean insertDisrepareInfo(int rid, int roid, float money, String cause) {
		disrepareInfoDAO.save(rid, roid, money, cause);
		return false;
	}
	//���ݻ�Ʊ��ŵõ����α��
	public int findRoidByRid(int rid) {
//		���ݻ�Ʊ���ݿ��ŵõ���Ʊ��Ϣ
		TDrawInfo dinfo=new TDrawInfo();		
		dinfo=this.findDrawInfoByRegisterID(rid);
		int roid=dinfo.getDrawRoadwayId().getRoadwayId();
		return roid;
	}
	//�޸�˾���ͳ�����״̬Ϊ����
	public void updateCarAndDriver(int cid, int did) {
		log.info("�޸�״̬��ʼ================================");
		truckInfoDAO.updataCarState(cid);
		driverInfoDAO.updateDriverState(did);
		log.info("�޸�״̬�ɹ�================================");
	}
	//����ȷ��google
	public List findTopTen(String id, String ty) {
		List list=rinfoDAO.findTopTen(id, ty);
		return list;
	}
	//����Ǽ�google
	public List findTopTen(String id) {
		List list=rinfoDAO.findTopTen(id);
		return list;
	}
}
