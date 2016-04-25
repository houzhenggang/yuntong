package com.yuntong.service;

import java.util.List;

/***
 * 
 * @author yqy
 *	运时运费调整
 */
public interface Y_IAreaFreightInfoService {
//得到所有的信息
public List findAllInfo();
//得到所有地区信息
public List findAllAreaInfo();
//根据页面大小得到总页数(页面大小，其始地编号，目的地编号)
public int getPageNum(int pageSize, int strid, int endid);
//分页得到用户信息(页面大小，当前页数,其始地编号，目的地编号)
public List findSplitRegister(int pageSize, int curPage, int strid,int endid);
//根据编号删除信息
public void deleteInfoById(int id);
//添加记录并判断是否有重复记录
public boolean addAFinfo(int iid,int stid,int enid,int pjtime,float zhong,float fang);
}
