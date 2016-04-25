package com.yuntong.service.impl;

import com.yuntong.business.vo.J_ShaoVO;
import com.yuntong.hibernate.database.dao.TAgioInfoDAO;
import com.yuntong.hibernate.database.po.TAgioInfo;
import com.yuntong.service.J_ShaoShouKuanService;

public class J_ShaoShouKuanServiceImpl implements J_ShaoShouKuanService {
         private TAgioInfoDAO agioInfoDAO; 
public J_ShaoVO ShaoShouKuan(int id) {
		TAgioInfo agioInfo= agioInfoDAO.findById(id);
		J_ShaoVO shaoVO=new J_ShaoVO();
		shaoVO.setAgioId(agioInfo.getAgioId());
		shaoVO.setTAgioType(agioInfo.getTAgioType().getAtypeId());
         shaoVO.setTRegisterID(agioInfo.getTRegisterInfo().getRegisterId());
         shaoVO.setAgioMoney(agioInfo.getAgioMoney());
         shaoVO.setAgioInfo(agioInfo.getAgioInfo());
		return shaoVO;
	}
	public TAgioInfoDAO getAgioInfoDAO() {
		return agioInfoDAO;
	}
	public void setAgioInfoDAO(TAgioInfoDAO agioInfoDAO) {
		this.agioInfoDAO = agioInfoDAO;
	}
	public void SaveShaoShouKuan(TAgioInfo agioInfo) {
		agioInfoDAO.getHibernateTemplate().update(agioInfo);
		
	}
	
}
