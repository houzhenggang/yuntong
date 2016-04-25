package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yuntong.business.vo.J_FactoryInfoVO;
import com.yuntong.hibernate.database.dao.TFactoryInfoDAO;
import com.yuntong.hibernate.database.dao.TRegisterInfoDAO;
import com.yuntong.hibernate.database.po.TFactoryInfo;
import com.yuntong.service.J_FactoryInfoViewService;

public class J_FactoryInfoViewServiceImpl implements J_FactoryInfoViewService {
private TFactoryInfoDAO factoryInfoDAO ;
private TRegisterInfoDAO registerInfoDAO;
	public TFactoryInfoDAO getFactoryInfoDAO() {
	return factoryInfoDAO;
}
public void setFactoryInfoDAO(TFactoryInfoDAO factoryInfoDAO) {
	this.factoryInfoDAO = factoryInfoDAO;
}
	//����ҵ������
	public List FactoryLine() {
		List lists=(List) factoryInfoDAO.findInfoOrderByMoney();
		List list=new ArrayList();
		
		for (int i = 0; i < 10; i++) {
			J_FactoryInfoVO factoryInfoVO=new J_FactoryInfoVO();
			TFactoryInfo factorypo=(TFactoryInfo)lists.get(i); 
		
			factoryInfoVO.setName(factorypo.getFactoryName());
			factoryInfoVO.setMoney(factorypo.getFactoryConsumption());
			list.add(factoryInfoVO);
			
		}
		
		return list;				
	}
	//��Ա�ȼ��ֲ�
	public List findConsumption(){
		List li=factoryInfoDAO.findConsumption();
	 return	li;		
	}
	public TRegisterInfoDAO getRegisterInfoDAO() {
		return registerInfoDAO;
	}
	public void setRegisterInfoDAO(TRegisterInfoDAO registerInfoDAO) {
		this.registerInfoDAO = registerInfoDAO;
	}
//	�����ѯ������·
	public List findXianlu() {
		List li=registerInfoDAO.findXianlu();
		return li;
	}
	//���㷽ʽ����
	public List findBili() {
		List sq=registerInfoDAO.findBili();
		List tf=registerInfoDAO.findBili2();
		String strSq=sq.get(0).toString();
		String strTf=tf.get(0).toString();
		List re=new ArrayList();
		if(strSq==null||strSq.equals("")){
			strSq="0";
		}
		if(strTf==null||strTf.equals("")){
			strTf="0";
		}
		re.add(strSq);
		re.add(strTf);
		return re;
	}
}
