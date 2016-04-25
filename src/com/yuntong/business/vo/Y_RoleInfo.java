package com.yuntong.business.vo;
/***
 * 封装权限
 * @author yqy
 *
 */
public class Y_RoleInfo {
private int	roleID;						//角色编号
private String    roleName;				//角色名称
private int roleSHGL;					//收货管理
private int rolePWGL;					//票物管理
private int rolePSGL;					//配送管理
private int roleCWGL;					//财务管理
private int roleSCGL;					//市场管理
private int  roleTJCX;					//统计查询
private int roleJBZL;					//基本资料
public int getRoleCWGL() {
	return roleCWGL;
}
public void setRoleCWGL(int roleCWGL) {
	this.roleCWGL = roleCWGL;
}
public int getRoleID() {
	return roleID;
}
public void setRoleID(int roleID) {
	this.roleID = roleID;
}
public int getRoleJBZL() {
	return roleJBZL;
}
public void setRoleJBZL(int roleJBZL) {
	this.roleJBZL = roleJBZL;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public int getRolePSGL() {
	return rolePSGL;
}
public void setRolePSGL(int rolePSGL) {
	this.rolePSGL = rolePSGL;
}
public int getRolePWGL() {
	return rolePWGL;
}
public void setRolePWGL(int rolePWGL) {
	this.rolePWGL = rolePWGL;
}
public int getRoleSCGL() {
	return roleSCGL;
}
public void setRoleSCGL(int roleSCGL) {
	this.roleSCGL = roleSCGL;
}
public int getRoleSHGL() {
	return roleSHGL;
}
public void setRoleSHGL(int roleSHGL) {
	this.roleSHGL = roleSHGL;
}
public int getRoleTJCX() {
	return roleTJCX;
}
public void setRoleTJCX(int roleTJCX) {
	this.roleTJCX = roleTJCX;
}
}
