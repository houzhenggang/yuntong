package com.yuntong.service;

import java.util.List;

import com.yuntong.business.vo.Y_ClientInfoVO;
import com.yuntong.business.vo.Y_DHQRInfoVO;
import com.yuntong.business.vo.Y_FactoryInfoVO;
import com.yuntong.business.vo.Y_GoodsInfoVO;
import com.yuntong.business.vo.Y_RegisterInfoVO;
import com.yuntong.business.vo.Y_UserInfoVO;
import com.yuntong.hibernate.database.dao.TFactoryInfoDAO;
import com.yuntong.hibernate.database.po.TDrawInfo;
import com.yuntong.hibernate.database.po.TRegisterInfo;


/***
 * 
 * @author yqy
 *	��Ʊ����
 */
public interface Y_IRegisterManagerService {
	//���ɻ�Ʊ
public Y_RegisterInfoVO addRegisterInfo(Y_FactoryInfoVO finfo,Y_ClientInfoVO cinfo,Y_GoodsInfoVO ginfo,Y_UserInfoVO Uvo);
//����ҵ���Ż������ŵõ���Ʊ��Ϣ
public Y_DHQRInfoVO findRegisterInfoByInputID(String inputID,int typeID);
//���ݻ�Ʊ��ŵõ���Ʊ��Ϣ
public TDrawInfo findDrawInfoByRegisterID(int rid);
//���ݻ�Ʊҵ���ŵõ����
public int findRegisterID(long rid);
//���������ŵõ���Ʊ���
public int findRegisterIDByRunID(Long rid);
//�޸Ļ�Ʊ״̬
public void updateRegisterType(int rid,int updateState);
//����ҵ���ŵõ���Ʊ��Ϣ
public Y_DHQRInfoVO findRegisterInfoByInputID(String inputID);
//��������Ϣ
public boolean insertDisrepareInfo(int rid,int roid,float money,String cause);
//���ݻ�Ʊ��ŵõ����α��
public int findRoidByRid(int rid);
//�޸�˾���ͳ�����״̬Ϊ����
public void updateCarAndDriver(int cid,int did);
//����ȷ��googleЧ��
public List findTopTen(String id,String ty);
//����Ǽ�googleЧ��
public List findTopTen(String id);
}
