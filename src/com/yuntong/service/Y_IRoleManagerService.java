package com.yuntong.service;

import java.util.List;

/***
 * 
 * @author yqy
 *	权限管理
 */
public interface Y_IRoleManagerService {
	//得到所有权限信息
	public List findAllRoleInfo();
	//修改权限
	public void updataRoleInfo(int SHGL,int PWGL,int PSGL,int CWGL,int SCGL,int TJCX,int JBZL,int roleId);
	//得到拥护权限比例
	public List findUserRole();
}
