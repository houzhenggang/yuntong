package com.yuntong.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yuntong.business.vo.AfficheInfoVO;
import com.yuntong.business.vo.Y_CueInfoVO;
import com.yuntong.business.vo.Y_RoleInfo;
import com.yuntong.business.vo.Y_UserInfoVO;
import com.yuntong.hibernate.database.dao.TAfficheDAO;
import com.yuntong.hibernate.database.dao.TCueDAO;
import com.yuntong.hibernate.database.dao.TFactoryInfoDAO;
import com.yuntong.hibernate.database.dao.TFilialeInfoDAO;
import com.yuntong.hibernate.database.dao.TRoleInfoDAO;
import com.yuntong.hibernate.database.dao.TUserInfoDAO;
import com.yuntong.hibernate.database.po.TAffiche;
import com.yuntong.hibernate.database.po.TCue;
import com.yuntong.hibernate.database.po.TFactoryInfo;
import com.yuntong.hibernate.database.po.TFilialeInfo;
import com.yuntong.hibernate.database.po.TRoleInfo;
import com.yuntong.hibernate.database.po.TUserInfo;
import com.yuntong.service.Y_IUserManagerService;
/***
 * 
 * @author yqy
 *	用户管理实现类
 */
public class Y_UserManagerService implements Y_IUserManagerService {
	private static Log log = LogFactory.getLog(TCueDAO.class);
	private TUserInfoDAO userInfoDAO;
	private TFilialeInfoDAO filialeInfoDAO;
	private TRoleInfoDAO roleInfoDAO;
	private TFactoryInfoDAO factoryInfoDAO;
	private TAfficheDAO afficheDAO;
	private TCueDAO cueDAO;
	public TCueDAO getCueDAO() {
		return cueDAO;
	}
	public void setCueDAO(TCueDAO cueDAO) {
		this.cueDAO = cueDAO;
	}
	public TAfficheDAO getAfficheDAO() {
		return afficheDAO;
	}
	public void setAfficheDAO(TAfficheDAO afficheDAO) {
		this.afficheDAO = afficheDAO;
	}
	public TFactoryInfoDAO getFactoryInfoDAO() {
		return factoryInfoDAO;
	}
	public void setFactoryInfoDAO(TFactoryInfoDAO factoryInfoDAO) {
		this.factoryInfoDAO = factoryInfoDAO;
	}
	public TFilialeInfoDAO getFilialeInfoDAO() {
		return filialeInfoDAO;
	}
	public void setFilialeInfoDAO(TFilialeInfoDAO filialeInfoDAO) {
		this.filialeInfoDAO = filialeInfoDAO;
	}
	public TRoleInfoDAO getRoleInfoDAO() {
		return roleInfoDAO;
	}
	public void setRoleInfoDAO(TRoleInfoDAO roleInfoDAO) {
		this.roleInfoDAO = roleInfoDAO;
	}
	public TUserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}
	public void setUserInfoDAO(TUserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}
/*
 * 登陆判断
 */
	public boolean checkLogin(String userName, String userPwd) {
		TUserInfo userInfo=new TUserInfo();
		userInfo.setUserUseName(userName);
		userInfo.setUserPassword(userPwd);
		if(userInfoDAO.findByExample(userInfo).isEmpty()){
			return false;
		}
			return true;
	}
/*
 *根据用户名得到用户信息 
 *转换为vo格式
 */
	public Y_UserInfoVO findUserInfoByName(String userName) {
		TUserInfo info=new TUserInfo();
		info.setUserUseName(userName);
		//根据用户名得到用户信息
		List list=userInfoDAO.findByExample(info);
		Y_UserInfoVO infoVO=new Y_UserInfoVO();
		 int userId=((TUserInfo)list.get(0)).getUserId();                     						//用户编号
		 int userFilialeId=((TUserInfo)list.get(0)).getTFilialeInfo().getFilialeId();   			//公司编号
		 String userLoginName=((TUserInfo)list.get(0)).getUserUseName();							//用户名
		 String userTrueName=((TUserInfo)list.get(0)).getUserName();                   				//真实姓名
		 String userPwd=((TUserInfo)list.get(0)).getUserPassword();									//密码
		 int userDepartmentId=((TUserInfo)list.get(0)).getTDepartment().getDepartmentId();			//部门编号
		 String userDepartmentName=((TUserInfo)list.get(0)).getTDepartment().getDepartmantName();	//部门名称
		 int userRoleId=((TUserInfo)list.get(0)).getTRoleInfo().getRoleId();						//角色编号
		 int userLoginNum=((TUserInfo)list.get(0)).getUserLoginNum();								//登陆次数
		 Date userLoginDate=((TUserInfo)list.get(0)).getUserLoginDate();							//上次登陆时间
		 Date userDate=((TUserInfo)list.get(0)).getUserDate();										//注册时间
		infoVO.setUserId(userId);
		infoVO.setUserFilialeId(userFilialeId);
		infoVO.setUserTrueName(userTrueName);
		infoVO.setUserName(userLoginName);
		infoVO.setUserPwd(userPwd);
		infoVO.setUserDepartmentId(userDepartmentId);
		infoVO.setUserDepartmentName(userDepartmentName);
		infoVO.setUserRoleId(userRoleId);
		infoVO.setUserLoginNum(userLoginNum);
		infoVO.setUserLoginDate(userLoginDate);
		infoVO.setUserDate(userDate);
		//根据公司编号得到公司信息
		TFilialeInfo filialeInfo=filialeInfoDAO.findById(userFilialeId);
		String userFilialeName=filialeInfo.getFilialeName();
		infoVO.setUserFilialeName(userFilialeName);		
		//根据角色编号得到信息
		TRoleInfo roleInfo=roleInfoDAO.findById(userRoleId);
		String userRoleName=roleInfo.getRoleName();
		infoVO.setRoleCWGL(roleInfo.getRoleCWGL());
		infoVO.setRoleJBZL(roleInfo.getRoleJBZL());
		infoVO.setRolePSGL(roleInfo.getRolePSGL());
		infoVO.setRolePWGL(roleInfo.getRolePWGL());
		infoVO.setRoleSCGL(roleInfo.getRoleSCGL());
		infoVO.setRoleSHGL(roleInfo.getRoleSHGL());
		infoVO.setRoleTJCX(roleInfo.getRoleTJCX());
		infoVO.setUserRoleName(userRoleName);
		return infoVO;
	}
	//分页得到用户信息(页面大小，当前页数,公司编号，部门编号，日期前，日期后)
	public List findSplitRegister(int pageSize, int curPage, int filiale, int department, Date date1, Date date2) {
		List list=userInfoDAO.findSplitRegister(pageSize, curPage, filiale, department, date1, date2);
		//povo转换
		List voList=new ArrayList();
		SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");
		for (int i = 0; i < list.size(); i++) {
			Y_UserInfoVO vo=new Y_UserInfoVO();			
			//格式化时间
			Date date=((TUserInfo)(list.get(i))).getUserDate();
			String Mydate=format.format(date);
			
			vo.setStrUserDate(Mydate);
			vo.setUserDate(date);
			vo.setUserDepartmentId(((TUserInfo)(list.get(i))).getTDepartment().getDepartmentId());
			vo.setUserDepartmentName(((TUserInfo)(list.get(i))).getTDepartment().getDepartmantName());
			vo.setUserFilialeId(((TUserInfo)(list.get(i))).getTFilialeInfo().getFilialeId());
			vo.setUserFilialeName(((TUserInfo)(list.get(i))).getTFilialeInfo().getFilialeName());
			vo.setUserId(((TUserInfo)(list.get(i))).getUserId());
			vo.setUserLoginDate(((TUserInfo)(list.get(i))).getUserLoginDate());
			vo.setUserName(((TUserInfo)(list.get(i))).getUserUseName());
			vo.setUserPwd(((TUserInfo)(list.get(i))).getUserPassword());
			vo.setUserRoleId(((TUserInfo)(list.get(i))).getTRoleInfo().getRoleId());
			vo.setUserRoleName(((TUserInfo)(list.get(i))).getTRoleInfo().getRoleName());
			vo.setUserTrueName(((TUserInfo)(list.get(i))).getUserName());
			vo.setUserCardID(((TUserInfo)(list.get(i))).getUserCardId());
			vo.setUserLoginNum(((TUserInfo)(list.get(i))).getUserLoginNum());
			vo.setUserPhone(((TUserInfo)(list.get(i))).getUserPhone());
			voList.add(vo);
		}
		return voList;
	}
	//根据页面大小得到总页数(页面大小，公司编号，部门编号，日期前，日期后)
	public int getPageNum(int pageSize, int filiale, int department, Date date1, Date date2) {
		int temp=userInfoDAO.getPageNum(pageSize, filiale, department, date1, date2);
		log.info("根据页面大小得到总页数(用户信息)");
		return temp;
	}
	//根据用户编号删除用户信息	
	public void deleteUserByID(int userId) {
		userInfoDAO.deleteUserByID(userId);		
	}
	//得到所有权限信息
	public List findAllRoleInfo() {
		List list=roleInfoDAO.findAllRoleInfo();
		
		List voList=new ArrayList();
		//转换格式
		for (int i = 0; i < list.size(); i++) {
			Y_RoleInfo vo=new Y_RoleInfo();
			log.info("----------------------------------------------------------");
			vo.setRoleID(((TRoleInfo)(list.get(i))).getRoleId());
			vo.setRoleCWGL(((TRoleInfo)(list.get(i))).getRoleCWGL());
			vo.setRoleJBZL(((TRoleInfo)(list.get(i))).getRoleJBZL());
			vo.setRoleName(((TRoleInfo)(list.get(i))).getRoleName());
			vo.setRolePSGL(((TRoleInfo)(list.get(i))).getRolePSGL());
			vo.setRoleSCGL(((TRoleInfo)(list.get(i))).getRoleSCGL());
			vo.setRoleSHGL(((TRoleInfo)(list.get(i))).getRoleSHGL());
			vo.setRoleTJCX(((TRoleInfo)(list.get(i))).getRoleTJCX());
			vo.setRolePWGL(((TRoleInfo)(list.get(i))).getRolePWGL());
			voList.add(vo);						
		}
		return voList;
	}
	//填加或修改用户
	public void addUserInfo(int userId, String userName, int filiale, int department, int userRole, String userTrueName, String userPhone, String userCardId, String userPwd2, int userLoginNum, Date userLoginDate,Date userDate ) {
		userInfoDAO.addUserInfo(userId, userName, filiale, department, userRole, userTrueName, userPhone, userCardId, userPwd2, userLoginNum, userLoginDate,userDate );	
	}
//	修改用户登陆次数上次登陆时间
	public void updataUserLoginTime(int userId) {		
		userInfoDAO.updataUserLoginTime(userId);
	}
//	得到最新公告信息
	public AfficheInfoVO findTopDate() {
		TAffiche t=afficheDAO.findTopDate();
		//格式转换
		AfficheInfoVO vo=new AfficheInfoVO();
		vo.setAfficheID(t.getAfficheId());
		vo.setAfficheDateTime(t.getAfficheDateTime());
		vo.setAfficheInfo(t.getAfficheInfo());
		vo.setAfficheTitle(t.getAfficheTitle());
		vo.setAfficheUserID(t.getTUserInfo().getUserId());
		vo.setAfficheUserName(t.getTUserInfo().getUserName());
		//格式化时间
		SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");
		String formatDate=format.format(t.getAfficheDateTime());
		vo.setArricheFormatDate(formatDate);
		return vo;
	}
	//得到所有提示信息
	public List findAllCue() {
		List list=cueDAO.findAllCue();
		//格式转换
		List voList=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Y_CueInfoVO vo=new  Y_CueInfoVO();
			vo.setCueID(((TCue)(list.get(i))).getCueId());
			vo.setCueInfo(((TCue)(list.get(i))).getCueInfo());
			vo.setCueName(((TCue)(list.get(i))).getCueName());
			vo.setCuePlace(((TCue)(list.get(i))).getCuePlace());
			voList.add(vo);
		}
		return voList;
	}
//	修改登陆密码
	public void updateUserPwd(int userId, String userPwd) {
		userInfoDAO.updateUserPwd(userId, userPwd);		
	}
	
}
