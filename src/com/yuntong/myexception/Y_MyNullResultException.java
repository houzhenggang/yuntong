package com.yuntong.myexception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yuntong.hibernate.database.dao.TDisrepareInfoDAO;

/***
 * 
 * @author yqy
 *	查询结果为空异常
 */
public class Y_MyNullResultException extends Exception {
	String message="查询结果为空";
	public Y_MyNullResultException(){
		Log log = LogFactory.getLog(Y_MyNullResultException.class);
		log.debug("查询结果为空");
	}
	public String toString(){
		return message;		
	}
}
