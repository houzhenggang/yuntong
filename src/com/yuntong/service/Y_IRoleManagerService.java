package com.yuntong.service;

import java.util.List;

/***
 * 
 * @author yqy
 *	Ȩ�޹���
 */
public interface Y_IRoleManagerService {
	//�õ�����Ȩ����Ϣ
	public List findAllRoleInfo();
	//�޸�Ȩ��
	public void updataRoleInfo(int SHGL,int PWGL,int PSGL,int CWGL,int SCGL,int TJCX,int JBZL,int roleId);
	//�õ�ӵ��Ȩ�ޱ���
	public List findUserRole();
}
