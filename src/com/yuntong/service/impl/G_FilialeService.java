package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.yuntong.business.vo.G_FilialeInfoVO;
import com.yuntong.hibernate.database.dao.TFilialeInfoDAO;
import com.yuntong.hibernate.database.po.TFilialeInfo;
import com.yuntong.service.G_IFilialeService;

public class G_FilialeService implements G_IFilialeService {
	private TFilialeInfoDAO filialeInfoDAO;

	public TFilialeInfoDAO getFilialeInfoDAO() {
		return filialeInfoDAO;
	}

	public void setFilialeInfoDAO(TFilialeInfoDAO filialeInfoDAO) {
		this.filialeInfoDAO = filialeInfoDAO;
	}


	public List getFilialeNameAndID() {
		List l=filialeInfoDAO.getFilialeInfoNameAndID();
		List list=new ArrayList();
		for (int i = 0; i < l.size(); i++) {
			G_FilialeInfoVO vo=new G_FilialeInfoVO();
			TFilialeInfo a=(TFilialeInfo) l.get(i);
			vo.setFilialeId(a.getFilialeId());
			vo.setFilialeName(a.getFilialeName());
			list.add(vo);
		}
		return list;
	}

	public TFilialeInfo findFilialeInfoByID(int ID) {
		return filialeInfoDAO.findById(ID);
	}


}
