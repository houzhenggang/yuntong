package com.yuntong.service;

import java.util.List;
/***
 * 
 * @author yqy
 *	货物信息管理
 */
public interface Y_IGoodsManagerService {
	//货款计算方式
public List findAllPaymentInfo();
	//结算方式
public List findAllFreight();
}
