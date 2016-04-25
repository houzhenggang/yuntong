package com.yuntong.service;



import java.util.List;

import com.yuntong.business.vo.Y_FactoryInfoVO;
/***
 * 
 * @author yqy
 *	厂商信息管理
 */
public interface Y_IFactoryManagerService {
//根据厂商编号得到信息
public Y_FactoryInfoVO findFactoryByID(int fid);
//插入一条厂商记录
public void addFactoryInfo(Y_FactoryInfoVO vo);
//得到前十
public List findTopTen(int fid);
}
