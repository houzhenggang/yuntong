package com.yuntong.service;



import java.util.List;

import com.yuntong.business.vo.Y_FactoryInfoVO;
/***
 * 
 * @author yqy
 *	������Ϣ����
 */
public interface Y_IFactoryManagerService {
//���ݳ��̱�ŵõ���Ϣ
public Y_FactoryInfoVO findFactoryByID(int fid);
//����һ�����̼�¼
public void addFactoryInfo(Y_FactoryInfoVO vo);
//�õ�ǰʮ
public List findTopTen(int fid);
}
