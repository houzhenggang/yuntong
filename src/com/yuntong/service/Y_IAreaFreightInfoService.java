package com.yuntong.service;

import java.util.List;

/***
 * 
 * @author yqy
 *	��ʱ�˷ѵ���
 */
public interface Y_IAreaFreightInfoService {
//�õ����е���Ϣ
public List findAllInfo();
//�õ����е�����Ϣ
public List findAllAreaInfo();
//����ҳ���С�õ���ҳ��(ҳ���С����ʼ�ر�ţ�Ŀ�ĵر��)
public int getPageNum(int pageSize, int strid, int endid);
//��ҳ�õ��û���Ϣ(ҳ���С����ǰҳ��,��ʼ�ر�ţ�Ŀ�ĵر��)
public List findSplitRegister(int pageSize, int curPage, int strid,int endid);
//���ݱ��ɾ����Ϣ
public void deleteInfoById(int id);
//��Ӽ�¼���ж��Ƿ����ظ���¼
public boolean addAFinfo(int iid,int stid,int enid,int pjtime,float zhong,float fang);
}
