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
 *	�û�����ʵ����
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
 * ��½�ж�
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
 *�����û����õ��û���Ϣ 
 *ת��Ϊvo��ʽ
 */
	public Y_UserInfoVO findUserInfoByName(String userName) {
		TUserInfo info=new TUserInfo();
		info.setUserUseName(userName);
		//�����û����õ��û���Ϣ
		List list=userInfoDAO.findByExample(info);
		Y_UserInfoVO infoVO=new Y_UserInfoVO();
		 int userId=((TUserInfo)list.get(0)).getUserId();                     						//�û����
		 int userFilialeId=((TUserInfo)list.get(0)).getTFilialeInfo().getFilialeId();   			//��˾���
		 String userLoginName=((TUserInfo)list.get(0)).getUserUseName();							//�û���
		 String userTrueName=((TUserInfo)list.get(0)).getUserName();                   				//��ʵ����
		 String userPwd=((TUserInfo)list.get(0)).getUserPassword();									//����
		 int userDepartmentId=((TUserInfo)list.get(0)).getTDepartment().getDepartmentId();			//���ű��
		 String userDepartmentName=((TUserInfo)list.get(0)).getTDepartment().getDepartmantName();	//��������
		 int userRoleId=((TUserInfo)list.get(0)).getTRoleInfo().getRoleId();						//��ɫ���
		 int userLoginNum=((TUserInfo)list.get(0)).getUserLoginNum();								//��½����
		 Date userLoginDate=((TUserInfo)list.get(0)).getUserLoginDate();							//�ϴε�½ʱ��
		 Date userDate=((TUserInfo)list.get(0)).getUserDate();										//ע��ʱ��
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
		//���ݹ�˾��ŵõ���˾��Ϣ
		TFilialeInfo filialeInfo=filialeInfoDAO.findById(userFilialeId);
		String userFilialeName=filialeInfo.getFilialeName();
		infoVO.setUserFilialeName(userFilialeName);		
		//���ݽ�ɫ��ŵõ���Ϣ
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
	//��ҳ�õ��û���Ϣ(ҳ���С����ǰҳ��,��˾��ţ����ű�ţ�����ǰ�����ں�)
	public List findSplitRegister(int pageSize, int curPage, int filiale, int department, Date date1, Date date2) {
		List list=userInfoDAO.findSplitRegister(pageSize, curPage, filiale, department, date1, date2);
		//povoת��
		List voList=new ArrayList();
		SimpleDateFormat format=new SimpleDateFormat("yyyy��MM��dd��");
		for (int i = 0; i < list.size(); i++) {
			Y_UserInfoVO vo=new Y_UserInfoVO();			
			//��ʽ��ʱ��
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
	//����ҳ���С�õ���ҳ��(ҳ���С����˾��ţ����ű�ţ�����ǰ�����ں�)
	public int getPageNum(int pageSize, int filiale, int department, Date date1, Date date2) {
		int temp=userInfoDAO.getPageNum(pageSize, filiale, department, date1, date2);
		log.info("����ҳ���С�õ���ҳ��(�û���Ϣ)");
		return temp;
	}
	//�����û����ɾ���û���Ϣ	
	public void deleteUserByID(int userId) {
		userInfoDAO.deleteUserByID(userId);		
	}
	//�õ�����Ȩ����Ϣ
	public List findAllRoleInfo() {
		List list=roleInfoDAO.findAllRoleInfo();
		
		List voList=new ArrayList();
		//ת����ʽ
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
	//��ӻ��޸��û�
	public void addUserInfo(int userId, String userName, int filiale, int department, int userRole, String userTrueName, String userPhone, String userCardId, String userPwd2, int userLoginNum, Date userLoginDate,Date userDate ) {
		userInfoDAO.addUserInfo(userId, userName, filiale, department, userRole, userTrueName, userPhone, userCardId, userPwd2, userLoginNum, userLoginDate,userDate );	
	}
//	�޸��û���½�����ϴε�½ʱ��
	public void updataUserLoginTime(int userId) {		
		userInfoDAO.updataUserLoginTime(userId);
	}
//	�õ����¹�����Ϣ
	public AfficheInfoVO findTopDate() {
		TAffiche t=afficheDAO.findTopDate();
		//��ʽת��
		AfficheInfoVO vo=new AfficheInfoVO();
		vo.setAfficheID(t.getAfficheId());
		vo.setAfficheDateTime(t.getAfficheDateTime());
		vo.setAfficheInfo(t.getAfficheInfo());
		vo.setAfficheTitle(t.getAfficheTitle());
		vo.setAfficheUserID(t.getTUserInfo().getUserId());
		vo.setAfficheUserName(t.getTUserInfo().getUserName());
		//��ʽ��ʱ��
		SimpleDateFormat format=new SimpleDateFormat("yyyy��MM��dd��");
		String formatDate=format.format(t.getAfficheDateTime());
		vo.setArricheFormatDate(formatDate);
		return vo;
	}
	//�õ�������ʾ��Ϣ
	public List findAllCue() {
		List list=cueDAO.findAllCue();
		//��ʽת��
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
//	�޸ĵ�½����
	public void updateUserPwd(int userId, String userPwd) {
		userInfoDAO.updateUserPwd(userId, userPwd);		
	}
	
}
