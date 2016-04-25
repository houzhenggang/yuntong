package com.yuntong.requestProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.RequestProcessor;

/***
 * 
 * @author Administrator
 *	��Ϣ����
 */
public class MyRequestProcessor extends RequestProcessor {
	private static final Log log = LogFactory.getLog(MyRequestProcessor.class);
	@Override
	protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			log.debug("===================��Ϣ����=========================");
		} catch (Exception e) {			
			e.printStackTrace();
			log.error("====================��Ϣ����ʧ��===============", e);
			return false;
		}
		return true;
	}
}
