package com.yuntong.service;

import java.util.List;

import com.yuntong.business.vo.Y_ClientInfoVO;
import com.yuntong.hibernate.database.po.TClientInfo;
/***
 * 
 * @author yqy
 *	�ͻ���Ϣ����
 */
public interface Y_IClientManagerService {
//�����û���ŵõ��û���Ϣ
public Y_ClientInfoVO findById(Long id);
//������Ϣ
public void addClientInfo(Y_ClientInfoVO vo);
//google��ѯ
public List findTopTen(int cid);
}
