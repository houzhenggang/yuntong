package com.yuntong.myexception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yuntong.hibernate.database.dao.TDisrepareInfoDAO;

/***
 * 
 * @author yqy
 *	��ѯ���Ϊ���쳣
 */
public class Y_MyNullResultException extends Exception {
	String message="��ѯ���Ϊ��";
	public Y_MyNullResultException(){
		Log log = LogFactory.getLog(Y_MyNullResultException.class);
		log.debug("��ѯ���Ϊ��");
	}
	public String toString(){
		return message;		
	}
}
