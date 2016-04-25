package com.yuntong.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yuntong.business.vo.Y_ClientInfoVO;
import com.yuntong.business.vo.Y_DHQRInfoVO;
import com.yuntong.business.vo.Y_FactoryInfoVO;
import com.yuntong.hibernate.database.dao.TClientInfoDAO;
import com.yuntong.hibernate.database.dao.TFactoryInfoDAO;
import com.yuntong.hibernate.database.dao.TRegisterInfoDAO;
import com.yuntong.hibernate.database.po.TClientInfo;
import com.yuntong.hibernate.database.po.TFactoryInfo;
import com.yuntong.hibernate.database.po.TRegisterInfo;
import com.yuntong.service.Y_ISplitRegister;
/***
 * 
 * @author yqy
 *	货票分页
 */
public class Y_SplitRegisterInfo implements Y_ISplitRegister {
	private Log log = LogFactory.getLog(Y_SplitRegisterInfo.class);
	private TRegisterInfoDAO infoDAO;
	private TClientInfoDAO clientInfoDAO;
	private TFactoryInfoDAO factoryInfoDAO;
	public TClientInfoDAO getClientInfoDAO() {
		return clientInfoDAO;
	}
	public void setClientInfoDAO(TClientInfoDAO clientInfoDAO) {
		this.clientInfoDAO = clientInfoDAO;
	}
	public TFactoryInfoDAO getFactoryInfoDAO() {
		return factoryInfoDAO;
	}
	public void setFactoryInfoDAO(TFactoryInfoDAO factoryInfoDAO) {
		this.factoryInfoDAO = factoryInfoDAO;
	}
	public TRegisterInfoDAO getInfoDAO() {
		return infoDAO;
	}
	public void setInfoDAO(TRegisterInfoDAO infoDAO) {
		this.infoDAO = infoDAO;
	}
	//根据页面大小得到总页数
	public int getPageNum(int pageSize){
		int clientID=0;
		int factroyID=0;
		int freightID=0;
		Date insertDate=null;
		return infoDAO.getPageNum(pageSize,clientID,factroyID,freightID,insertDate);
	}
	//得到指定页面信息
	public List findSplitRegisterInfo(int pageSize, int curPage) {
		int clientID=0;
		int factroyID=0;
		int freightID=0;
		Date insertDate=null;
		List list=infoDAO.findSplitRegister(pageSize, curPage,clientID,factroyID,freightID,insertDate);
		log.info("记录条数+++++++"+list.size());
		//转po为vo
		SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd");		
		List voList=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Y_DHQRInfoVO vo=new Y_DHQRInfoVO();
			vo.setRegisterID(((TRegisterInfo)(list.get(i))).getRegisterId());		//数据编号
			vo.setRegisterGlideID(((TRegisterInfo)(list.get(i))).getRegisterGlideId()); //业务编号
			vo.setRegisterConveyanceID(((TRegisterInfo)(list.get(i))).getRegisterConveyanceId()); //运输编号
			vo.setRegisterLine(((TRegisterInfo)(list.get(i))).getRegisterLine());					//线路
			vo.setRegisterFactoryName(((TRegisterInfo)(list.get(i))).getTFactoryInfo().getFactoryName()); //厂商名称
			vo.setRegisterFreightName(((TRegisterInfo)(list.get(i))).getTFreightStyle().getFreightName());//结算方式
			vo.setGoodsName(((TRegisterInfo)(list.get(i))).getTGoodsInfo().getGoodsName());			//货物名称
			vo.setGoodsPaymentModeName(((TRegisterInfo)(list.get(i))).getTGoodsInfo().getTPaymentOfGoodsStyle().getPaymentName());//几价方式
			Date date=((TRegisterInfo)(list.get(i))).getRegisterDate();
			String formatdate=format.format(date);
			vo.setStrDate(formatdate);     //制单时间
			voList.add(vo);
		}
		return voList;
	}
	//精确查询
	public List findRegisterByIDAndRunID(long inputID, int inputType) {
		List list=infoDAO.findRegisterByIDAndRunID(inputID, inputType);
//		转po为vo
		SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd");		
		List voList=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Y_DHQRInfoVO vo=new Y_DHQRInfoVO();
			vo.setRegisterID(((TRegisterInfo)(list.get(i))).getRegisterId());		//数据编号
			vo.setRegisterGlideID(((TRegisterInfo)(list.get(i))).getRegisterGlideId()); //业务编号
			vo.setRegisterConveyanceID(((TRegisterInfo)(list.get(i))).getRegisterConveyanceId()); //运输编号
			vo.setRegisterLine(((TRegisterInfo)(list.get(i))).getRegisterLine());					//线路
			vo.setRegisterFactoryName(((TRegisterInfo)(list.get(i))).getTFactoryInfo().getFactoryName()); //厂商名称
			vo.setRegisterFreightName(((TRegisterInfo)(list.get(i))).getTFreightStyle().getFreightName());//结算方式
			vo.setGoodsName(((TRegisterInfo)(list.get(i))).getTGoodsInfo().getGoodsName());			//货物名称
			vo.setGoodsPaymentModeName(((TRegisterInfo)(list.get(i))).getTGoodsInfo().getTPaymentOfGoodsStyle().getPaymentName());//几价方式
			Date date=((TRegisterInfo)(list.get(i))).getRegisterDate();
			String formatdate=format.format(date);
			vo.setStrDate(formatdate);     //制单时间
			voList.add(vo);
		}
		return voList;
	}
	//得到所有客户信息
	public List findAllClientInfo() {
		List list=clientInfoDAO.findAllClientInfo();
		List voList=new ArrayList();
		//格式转换
		for (int i = 0; i < list.size(); i++) {
			Y_ClientInfoVO vo=new Y_ClientInfoVO();
			vo.setClientID(((TClientInfo)(list.get(i))).getClientId());
			vo.setClientName(((TClientInfo)(list.get(i))).getClientName());
			voList.add(vo);
		}
		return voList;
	}
	//得到所有厂商信息
	public List findAllFactoryInfo() {
		List list=factoryInfoDAO.findAllFactoryInfo();
		List voList=new ArrayList();
		//格式转换
		for (int i = 0; i < list.size(); i++) {
			Y_FactoryInfoVO vo=new Y_FactoryInfoVO();
			vo.setFactoryID(((TFactoryInfo)(list.get(i))).getFactoryId());
			vo.setFactoryName(((TFactoryInfo)(list.get(i))).getFactoryName());
			voList.add(vo);
		}
		return voList;
	}
	//范围查询时的页面信息
	public List findSplitRegisterInfo(int pageSize, int curPage, int clientID, int factroyID, int freightID, Date insertDate) {
		List list=infoDAO.findSplitRegister(pageSize, curPage,clientID,factroyID,freightID,insertDate);
		log.info("范围查询记录条数+++++++"+list.size());
		//转po为vo
		SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd");		
		List voList=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Y_DHQRInfoVO vo=new Y_DHQRInfoVO();
			vo.setRegisterID(((TRegisterInfo)(list.get(i))).getRegisterId());		//数据编号
			vo.setRegisterGlideID(((TRegisterInfo)(list.get(i))).getRegisterGlideId()); //业务编号
			vo.setRegisterConveyanceID(((TRegisterInfo)(list.get(i))).getRegisterConveyanceId()); //运输编号
			vo.setRegisterLine(((TRegisterInfo)(list.get(i))).getRegisterLine());					//线路
			vo.setRegisterFactoryName(((TRegisterInfo)(list.get(i))).getTFactoryInfo().getFactoryName()); //厂商名称
			vo.setRegisterFreightName(((TRegisterInfo)(list.get(i))).getTFreightStyle().getFreightName());//结算方式
			vo.setGoodsName(((TRegisterInfo)(list.get(i))).getTGoodsInfo().getGoodsName());			//货物名称
			vo.setGoodsPaymentModeName(((TRegisterInfo)(list.get(i))).getTGoodsInfo().getTPaymentOfGoodsStyle().getPaymentName());//几价方式
			Date date=((TRegisterInfo)(list.get(i))).getRegisterDate();
			String formatdate=format.format(date);
			vo.setStrDate(formatdate);     //制单时间
			voList.add(vo);
		}
		return voList;
	}
	//范围查询时的总页数
	public int getPageNum(int pageSize, int clientID, int factroyID, int freightID, Date insertDate) {
		log.info("客户编号service:"+clientID);
		int pageNum=infoDAO.getPageNum(pageSize,clientID,factroyID,freightID,insertDate);
		
		return pageNum;
	}
	//根据编号删除货票
	public void deleteRegisterByID(int rid) {
		infoDAO.deleteRegisterByID(rid);		
	}	
}
