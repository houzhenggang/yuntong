package com.yuntong.service;

import java.util.List;



public interface M_IRegisterManagerService {
//	���ݻ�Ʊ��Ż������ŵõ���Ʊ��Ϣ
	public List findRegisterInfoByInputID(String ID,long value);
//	�޸Ļ�Ʊ״̬
	public void updateRegisterType(int rid,int updateState);
//	�˻�Ǽ�google
	public List findTopTen(long id);
}
