package com.yuntong.business.vo;

import java.util.Date;
/***
 * 
 * @author yqy
 * ��װ�û���½��Ϣ
 *
 */
public class Y_UserInfoVO {
	private int userId;                            //�û����
	private int userFilialeId;					   //��˾���
	private String userFilialeName;				   //��˾����
	private String userName;						//�û���
	private String userTrueName;                    //��ʵ����
	private String userPwd;							//����
	private int userDepartmentId;					//���ű��
	private String userDepartmentName;				//��������
	private String userPhone;						//��ϵ�绰
	private String userCardID;						//�����
	private int userRoleId;							//��ɫ���
	private String userRoleName;                    //��ɫ����
	private int userLoginNum;						//��½����
	private Date userLoginDate;						//�ϴε�½ʱ��
	private Date userDate;							//ע��ʱ��
	private String strUserDate;                     //��ʽ��ע��ʱ��
	
	private int roleSHGL;							//�ջ�����
	private int rolePWGL;							//Ʊ�����
	private int rolePSGL;							//���͹���
	private int roleCWGL;							//�������
	private int roleSCGL;							//�г�����
	private int  roleTJCX;							//ͳ�Ʋ�ѯ
	private int roleJBZL;							//��������
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
