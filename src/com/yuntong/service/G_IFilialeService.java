package com.yuntong.service;

import java.util.List;
import com.yuntong.hibernate.database.po.TFilialeInfo;

public interface G_IFilialeService {
	public List getFilialeNameAndID();
	public TFilialeInfo findFilialeInfoByID(int ID);
}
