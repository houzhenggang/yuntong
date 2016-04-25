package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yuntong.business.vo.Y_FilialeInfoVO;
import com.yuntong.hibernate.database.dao.TFilialeInfoDAO;
import com.yuntong.hibernate.database.po.TFilialeInfo;
import com.yuntong.service.Y_IFilialeManagerService;
/***
 * 
 * @author yqy
 *	�ֹ�˾��Ϣ����
 */
public class Y_FilialeManagerService implements Y_IFilialeManagerService {
	private TFilialeInfoDAO infoDAO;
	
	public TFilialeInfoDAO getInfoDAO() {
		return infoDAO;
	}

	public void setInfoDAO(TFilialeInfoDAO infoDAO) {
		this.infoDAO = infoDAO;
	}

	//�õ����зֹ�˾��Ϣ
	public List findAllFilialeInfo() {
		List list=infoDAO.findAllFilialeInfo();
		//povoת��
		List voList=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Y_FilialeInfoVO vo=new Y_FilialeInfoVO();
			vo.setFilialeID(((TFilialeInfo)(list.get(i))).getFilialeId());
			vo.setFilialeName(((TFilialeInfo)(list.get(i))).getFilialeName());
			voList.add(vo);
		}
		return voList;
	}

}
