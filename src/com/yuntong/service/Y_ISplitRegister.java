package com.yuntong.service;

import java.util.Date;
import java.util.List;

/***
 * 
 * @author yqy
 *	��Ʊ��ҳ
 */
public interface Y_ISplitRegister {
	//��ҳ��
	public int getPageNum(int pageSize);
	//��ǰҳ��Ϣ
	public List findSplitRegisterInfo(int pageSize,int curPage);
	//δ����Ʊ��ȷ��ѯ
	public List findRegisterByIDAndRunID(long inputID,int inputType);
	//�õ����г�����Ϣ
	public List findAllClientInfo();
	//�õ����пͻ���Ϣ
	public List findAllFactoryInfo();
	//��Χ��ѯ��ҳ��
	public int getPageNum(int pageSize,int clientID,int factroyID,int freightID,Date insertDate);
	//��Χ��ѯ��ǰҳ��Ϣ
	public List findSplitRegisterInfo(int pageSize,int curPage,int clientID,int factroyID,int freightID,Date insertDate);
	//���ݱ��ɾ����Ʊ
	public void deleteRegisterByID(int rid);
}
