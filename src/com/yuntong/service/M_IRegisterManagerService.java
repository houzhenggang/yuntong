package com.yuntong.service;

import java.util.List;



public interface M_IRegisterManagerService {
//	根据货票编号或运输编号得到货票信息
	public List findRegisterInfoByInputID(String ID,long value);
//	修改货票状态
	public void updateRegisterType(int rid,int updateState);
//	退火登记google
	public List findTopTen(long id);
}
