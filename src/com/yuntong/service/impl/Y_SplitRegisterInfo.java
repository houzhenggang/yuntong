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
 *	��Ʊ��ҳ
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
	//����ҳ���С�õ���ҳ��
	public int getPageNum(int pageSize){
		int clientID=0;
		int factroyID=0;
		int freightID=0;
		Date insertDate=null;
		return infoDAO.getPageNum(pageSize,clientID,factroyID,freightID,insertDate);
	}
	//�õ�ָ��ҳ����Ϣ
	public List findSplitRegisterInfo(int pageSize, int curPage) {
		int clientID=0;
		int factroyID=0;
		int freightID=0;
		Date insertDate=null;
		List list=infoDAO.findSplitRegister(pageSize, curPage,clientID,factroyID,freightID,insertDate);
		log.info("��¼����+++++++"+list.size());
		//תpoΪvo
		SimpleDateFormat format=new SimpleDateFormat("yyyy��MM��dd");		
		List voList=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Y_DHQRInfoVO vo=new Y_DHQRInfoVO();
			vo.setRegisterID(((TRegisterInfo)(list.get(i))).getRegisterId());		//���ݱ��
			vo.setRegisterGlideID(((TRegisterInfo)(list.get(i))).getRegisterGlideId()); //ҵ����
			vo.setRegisterConveyanceID(((TRegisterInfo)(list.get(i))).getRegisterConveyanceId()); //������
			vo.setRegisterLine(((TRegisterInfo)(list.get(i))).getRegisterLine());					//��·
			vo.setRegisterFactoryName(((TRegisterInfo)(list.get(i))).getTFactoryInfo().getFactoryName()); //��������
			vo.setRegisterFreightName(((TRegisterInfo)(list.get(i))).getTFreightStyle().getFreightName());//���㷽ʽ
			vo.setGoodsName(((TRegisterInfo)(list.get(i))).getTGoodsInfo().getGoodsName());			//��������
			vo.setGoodsPaymentModeName(((TRegisterInfo)(list.get(i))).getTGoodsInfo().getTPaymentOfGoodsStyle().getPaymentName());//���۷�ʽ
			Date date=((TRegisterInfo)(list.get(i))).getRegisterDate();
			String formatdate=format.format(date);
			vo.setStrDate(formatdate);     //�Ƶ�ʱ��
			voList.add(vo);
		}
		return voList;
	}
	//��ȷ��ѯ
	public List findRegisterByIDAndRunID(long inputID, int inputType) {
		List list=infoDAO.findRegisterByIDAndRunID(inputID, inputType);
//		תpoΪvo
		SimpleDateFormat format=new SimpleDateFormat("yyyy��MM��dd");		
		List voList=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Y_DHQRInfoVO vo=new Y_DHQRInfoVO();
			vo.setRegisterID(((TRegisterInfo)(list.get(i))).getRegisterId());		//���ݱ��
			vo.setRegisterGlideID(((TRegisterInfo)(list.get(i))).getRegisterGlideId()); //ҵ����
			vo.setRegisterConveyanceID(((TRegisterInfo)(list.get(i))).getRegisterConveyanceId()); //������
			vo.setRegisterLine(((TRegisterInfo)(list.get(i))).getRegisterLine());					//��·
			vo.setRegisterFactoryName(((TRegisterInfo)(list.get(i))).getTFactoryInfo().getFactoryName()); //��������
			vo.setRegisterFreightName(((TRegisterInfo)(list.get(i))).getTFreightStyle().getFreightName());//���㷽ʽ
			vo.setGoodsName(((TRegisterInfo)(list.get(i))).getTGoodsInfo().getGoodsName());			//��������
			vo.setGoodsPaymentModeName(((TRegisterInfo)(list.get(i))).getTGoodsInfo().getTPaymentOfGoodsStyle().getPaymentName());//���۷�ʽ
			Date date=((TRegisterInfo)(list.get(i))).getRegisterDate();
			String formatdate=format.format(date);
			vo.setStrDate(formatdate);     //�Ƶ�ʱ��
			voList.add(vo);
		}
		return voList;
	}
	//�õ����пͻ���Ϣ
	public List findAllClientInfo() {
		List list=clientInfoDAO.findAllClientInfo();
		List voList=new ArrayList();
		//��ʽת��
		for (int i = 0; i < list.size(); i++) {
			Y_ClientInfoVO vo=new Y_ClientInfoVO();
			vo.setClientID(((TClientInfo)(list.get(i))).getClientId());
			vo.setClientName(((TClientInfo)(list.get(i))).getClientName());
			voList.add(vo);
		}
		return voList;
	}
	//�õ����г�����Ϣ
	public List findAllFactoryInfo() {
		List list=factoryInfoDAO.findAllFactoryInfo();
		List voList=new ArrayList();
		//��ʽת��
		for (int i = 0; i < list.size(); i++) {
			Y_FactoryInfoVO vo=new Y_FactoryInfoVO();
			vo.setFactoryID(((TFactoryInfo)(list.get(i))).getFactoryId());
			vo.setFactoryName(((TFactoryInfo)(list.get(i))).getFactoryName());
			voList.add(vo);
		}
		return voList;
	}
	//��Χ��ѯʱ��ҳ����Ϣ
	public List findSplitRegisterInfo(int pageSize, int curPage, int clientID, int factroyID, int freightID, Date insertDate) {
		List list=infoDAO.findSplitRegister(pageSize, curPage,clientID,factroyID,freightID,insertDate);
		log.info("��Χ��ѯ��¼����+++++++"+list.size());
		//תpoΪvo
		SimpleDateFormat format=new SimpleDateFormat("yyyy��MM��dd");		
		List voList=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Y_DHQRInfoVO vo=new Y_DHQRInfoVO();
			vo.setRegisterID(((TRegisterInfo)(list.get(i))).getRegisterId());		//���ݱ��
			vo.setRegisterGlideID(((TRegisterInfo)(list.get(i))).getRegisterGlideId()); //ҵ����
			vo.setRegisterConveyanceID(((TRegisterInfo)(list.get(i))).getRegisterConveyanceId()); //������
			vo.setRegisterLine(((TRegisterInfo)(list.get(i))).getRegisterLine());					//��·
			vo.setRegisterFactoryName(((TRegisterInfo)(list.get(i))).getTFactoryInfo().getFactoryName()); //��������
			vo.setRegisterFreightName(((TRegisterInfo)(list.get(i))).getTFreightStyle().getFreightName());//���㷽ʽ
			vo.setGoodsName(((TRegisterInfo)(list.get(i))).getTGoodsInfo().getGoodsName());			//��������
			vo.setGoodsPaymentModeName(((TRegisterInfo)(list.get(i))).getTGoodsInfo().getTPaymentOfGoodsStyle().getPaymentName());//���۷�ʽ
			Date date=((TRegisterInfo)(list.get(i))).getRegisterDate();
			String formatdate=format.format(date);
			vo.setStrDate(formatdate);     //�Ƶ�ʱ��
			voList.add(vo);
		}
		return voList;
	}
	//��Χ��ѯʱ����ҳ��
	public int getPageNum(int pageSize, int clientID, int factroyID, int freightID, Date insertDate) {
		log.info("�ͻ����service:"+clientID);
		int pageNum=infoDAO.getPageNum(pageSize,clientID,factroyID,freightID,insertDate);
		
		return pageNum;
	}
	//���ݱ��ɾ����Ʊ
	public void deleteRegisterByID(int rid) {
		infoDAO.deleteRegisterByID(rid);		
	}	
}
