package com.yuntong.service;

import java.util.Date;
import java.util.List;

import com.yuntong.business.vo.AfficheInfoVO;
import com.yuntong.business.vo.Y_UserInfoVO;
import com.yuntong.hibernate.database.po.TAffiche;

/***
 * 
 * @author yqy
 *	�û���Ϣ����
 */
public interface Y_IUserManagerService {
/*
 * �û���½�ж�
 */
public boolean checkLogin(String userName,String userPwd);
/*
 * �����û����õ��û���Ϣ
 */
public Y_UserInfoVO findUserInfoByName(String userName);
//����ҳ���С�õ���ҳ��(ҳ���С����˾��ţ����ű�ţ�����ǰ�����ں�)
public int getPageNum(int pageSize,int filiale,int department,Date date1,Date date2);
//��ҳ�õ��û���Ϣ(ҳ���С����ǰҳ��,��˾��ţ����ű�ţ�����ǰ�����ں�)
public List findSplitRegister(int pageSize,int curPage,int filiale,int department,Date date1,Date date2);
//�����û����ɾ���û���Ϣ
public void deleteUserByID(int userId);
//�õ�����Ȩ����Ϣ
public List findAllRoleInfo();
//��ӻ��޸��û�
public void addUserInfo(int userId,String userName,int filiale,int department,int userRole,String userTrueName,String userPhone,String userCardId,String userPwd2,int userLoginNum,Date userLoginDate,Date userDate );
//�޸��û���½�����ϴε�½ʱ��
public void updataUserLoginTime(int userId);
//�õ����¹�����Ϣ
public AfficheInfoVO findTopDate();
//�õ�������ʾ��Ϣ
public List findAllCue();
//�޸ĵ�½����
public void updateUserPwd(int userId,String userPwd);
}
