package com.yuntong.business.vo;

import java.util.Date;
/***
 * 
 * @author yqy
 * 封装用户登陆信息
 *
 */
public class Y_UserInfoVO {
	private int userId;                            //用户编号
	private int userFilialeId;					   //公司编号
	private String userFilialeName;				   //公司名称
	private String userName;						//用户名
	private String userTrueName;                    //真实姓名
	private String userPwd;							//密码
	private int userDepartmentId;					//部门编号
	private String userDepartmentName;				//部门名称
	private String userPhone;						//联系电话
	private String userCardID;						//身份正
	private int userRoleId;							//角色编号
	private String userRoleName;                    //角色名称
	private int userLoginNum;						//登陆次数
	private Date userLoginDate;						//上次登陆时间
	private Date userDate;							//注册时间
	private String strUserDate;                     //格式化注册时间
	
	private int roleSHGL;							//收货管理
	private int rolePWGL;							//票物管理
	private int rolePSGL;							//配送管理
	private int roleCWGL;							//财务管理
	private int roleSCGL;							//市场管理
	private int  roleTJCX;							//统计查询
	private int roleJBZL;							//基本资料
	public int getRoleCWGL() {
		return roleCWGL;
	}
	public void setRoleCWGL(int roleCWGL) {
		this.roleCWGL = roleCWGL;
	}
	public int getRoleJBZL() {
		return roleJBZL;
	}
	public void setRoleJBZL(int roleJBZL) {
		this.roleJBZL = roleJBZL;
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
	public String getStrUserDate() {
		return strUserDate;
	}
	public void setStrUserDate(String strUserDate) {
		this.strUserDate = strUserDate;
	}
	public Date getUserDate() {
		return userDate;
	}
	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}
	public int getUserDepartmentId() {
		return userDepartmentId;
	}
	public void setUserDepartmentId(int userDepartmentId) {
		this.userDepartmentId = userDepartmentId;
	}
	public String getUserDepartmentName() {
		return userDepartmentName;
	}
	public void setUserDepartmentName(String userDepartmentName) {
		this.userDepartmentName = userDepartmentName;
	}
	public int getUserFilialeId() {
		return userFilialeId;
	}
	public void setUserFilialeId(int userFilialeId) {
		this.userFilialeId = userFilialeId;
	}
	public String getUserFilialeName() {
		return userFilialeName;
	}
	public void setUserFilialeName(String userFilialeName) {
		this.userFilialeName = userFilialeName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getUserLoginDate() {
		return userLoginDate;
	}
	public void setUserLoginDate(Date userLoginDate) {
		this.userLoginDate = userLoginDate;
	}
	public int getUserLoginNum() {
		return userLoginNum;
	}
	public void setUserLoginNum(int userLoginNum) {
		this.userLoginNum = userLoginNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserTrueName() {
		return userTrueName;
	}
	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserCardID() {
		return userCardID;
	}
	public void setUserCardID(String userCardID) {
		this.userCardID = userCardID;
	}
}
