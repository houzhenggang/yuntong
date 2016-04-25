package com.yuntong.service;

import java.util.List;

import com.yuntong.business.vo.Y_ClientInfoVO;
import com.yuntong.hibernate.database.po.TClientInfo;
/***
 * 
 * @author yqy
 *	客户信息管理
 */
public interface Y_IClientManagerService {
//根据用户编号得到用户信息
public Y_ClientInfoVO findById(Long id);
//插入信息
public void addClientInfo(Y_ClientInfoVO vo);
//google查询
public List findTopTen(int cid);
}
