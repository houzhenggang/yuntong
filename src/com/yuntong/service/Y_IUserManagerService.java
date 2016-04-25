package com.yuntong.service;

import java.util.Date;
import java.util.List;

import com.yuntong.business.vo.AfficheInfoVO;
import com.yuntong.business.vo.Y_UserInfoVO;
import com.yuntong.hibernate.database.po.TAffiche;

/***
 * 
 * @author yqy
 *	用户信息管理
 */
public interface Y_IUserManagerService {
/*
 * 用户登陆判断
 */
public boolean checkLogin(String userName,String userPwd);
/*
 * 根据用户名得到用户信息
 */
public Y_UserInfoVO findUserInfoByName(String userName);
//根据页面大小得到总页数(页面大小，公司编号，部门编号，日期前，日期后)
public int getPageNum(int pageSize,int filiale,int department,Date date1,Date date2);
//分页得到用户信息(页面大小，当前页数,公司编号，部门编号，日期前，日期后)
public List findSplitRegister(int pageSize,int curPage,int filiale,int department,Date date1,Date date2);
//根据用户编号删除用户信息
public void deleteUserByID(int userId);
//得到所有权限信息
public List findAllRoleInfo();
//填加或修改用户
public void addUserInfo(int userId,String userName,int filiale,int department,int userRole,String userTrueName,String userPhone,String userCardId,String userPwd2,int userLoginNum,Date userLoginDate,Date userDate );
//修改用户登陆次数上次登陆时间
public void updataUserLoginTime(int userId);
//得到最新公告信息
public AfficheInfoVO findTopDate();
//得到所有提示信息
public List findAllCue();
//修改登陆密码
public void updateUserPwd(int userId,String userPwd);
}
