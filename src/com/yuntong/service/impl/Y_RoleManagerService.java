package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yuntong.business.vo.Y_RoleInfo;
import com.yuntong.hibernate.database.dao.TRoleInfoDAO;
import com.yuntong.hibernate.database.dao.TUserInfoDAO;
import com.yuntong.hibernate.database.po.TRoleInfo;
import com.yuntong.service.Y_IRoleManagerService;
/***
 * 
 * @author yqy
 *	Ȩ�޹���
 */
public class Y_RoleManagerService implements Y_IRoleManagerService {
	private TUserInfoDAO userInfoDAO;
	private TRoleInfoDAO roleInfoDAO;
	public TRoleInfoDAO getRoleInfoDAO() {
		return roleInfoDAO;
	}
	public void setRoleInfoDAO(TRoleInfoDAO roleInfoDAO) {
		this.roleInfoDAO = roleInfoDAO;
	}
	//�õ������û�Ȩ��
	public List findAllRoleInfo() {
		List list=roleInfoDAO.findAllRoleInfo();
		List voList=new ArrayList();
		//��ʽת��
		for (int i = 0; i < list.size(); i++) {
			Y_RoleInfo vo=new Y_RoleInfo();
			vo.setRoleID(((TRoleInfo)(list.get(i))).getRoleId());
			vo.setRoleName(((TRoleInfo)(list.get(i))).getRoleName());
			vo.setRoleCWGL(((TRoleInfo)(list.get(i))).getRoleCWGL());
			vo.setRoleJBZL(((TRoleInfo)(list.get(i))).getRoleJBZL());
			vo.setRolePSGL(((TRoleInfo)(list.get(i))).getRolePSGL());
			vo.setRolePWGL(((TRoleInfo)(list.get(i))).getRolePWGL());
			vo.setRoleSCGL(((TRoleInfo)(list.get(i))).getRoleSCGL());
			vo.setRoleSHGL(((TRoleInfo)(list.get(i))).getRoleSHGL());
			vo.setRoleTJCX(((TRoleInfo)(list.get(i))).getRoleTJCX());
			voList.add(vo);
		}
		return voList;
	}
	//�޸�Ȩ��
	public void updataRoleInfo(int SHGL, int PWGL, int PSGL, int CWGL, int SCGL, int TJCX, int JBZL, int roleId) {
		roleInfoDAO.updataRoleInfo(SHGL, PWGL, PSGL, CWGL, SCGL, TJCX, JBZL, roleId);		
	}
	//�õ�ӵ��Ȩ�ޱ���
	public List findUserRole() {
		List list=userInfoDAO.findUserRole();
		return list;
	}
	public TUserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}
	public void setUserInfoDAO(TUserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}
	

}
