package com.yuntong.service;

import java.util.List;

import com.yuntong.business.vo.Y_ClientInfoVO;
import com.yuntong.business.vo.Y_DHQRInfoVO;
import com.yuntong.business.vo.Y_FactoryInfoVO;
import com.yuntong.business.vo.Y_GoodsInfoVO;
import com.yuntong.business.vo.Y_RegisterInfoVO;
import com.yuntong.business.vo.Y_UserInfoVO;
import com.yuntong.hibernate.database.dao.TFactoryInfoDAO;
import com.yuntong.hibernate.database.po.TDrawInfo;
import com.yuntong.hibernate.database.po.TRegisterInfo;


/***
 * 
 * @author yqy
 *	货票管理
 */
public interface Y_IRegisterManagerService {
	//生成货票
public Y_RegisterInfoVO addRegisterInfo(Y_FactoryInfoVO finfo,Y_ClientInfoVO cinfo,Y_GoodsInfoVO ginfo,Y_UserInfoVO Uvo);
//根据业务编号或运输编号得到货票信息
public Y_DHQRInfoVO findRegisterInfoByInputID(String inputID,int typeID);
//根据货票编号得到领票信息
public TDrawInfo findDrawInfoByRegisterID(int rid);
//根据货票业务编号得到编号
public int findRegisterID(long rid);
//根据运输编号得到货票编号
public int findRegisterIDByRunID(Long rid);
//修改货票状态
public void updateRegisterType(int rid,int updateState);
//根据业务编号得到货票信息
public Y_DHQRInfoVO findRegisterInfoByInputID(String inputID);
//填加损货信息
public boolean insertDisrepareInfo(int rid,int roid,float money,String cause);
//根据货票编号得到车次编号
public int findRoidByRid(int rid);
//修改司机和车辆的状态为空闲
public void updateCarAndDriver(int cid,int did);
//到货确认google效果
public List findTopTen(String id,String ty);
//孙货登记google效果
public List findTopTen(String id);
}
