/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yuntong.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yuntong.business.vo.G_RegisterAndGoodsInfoVO;
import com.yuntong.service.G_IRegisterInfoService;

/** 
 * MyEclipse Struts
 * Creation date: 04-20-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class G_RegisterAutoCompleteAction extends Action {
	private G_IRegisterInfoService registerInfoService;
	/*
	 * Generated Methods
	 */

	public G_IRegisterInfoService getRegisterInfoService() {
		return registerInfoService;
	}

	public void setRegisterInfoService(G_IRegisterInfoService registerInfoService) {
		this.registerInfoService = registerInfoService;
	}

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws IOException 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/xml; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id=request.getParameter("id");
		int type=Integer.parseInt(request.getParameter("type"));
		List list=registerInfoService.getRegisterInfoListByID(id.trim(), type);
		out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.print("<info>");
		if(list.size()==0){
			out.print("<listSize value='"+0+"'>");
			out.print(0);
			out.print("</listSize>");
		}else{
			if(list.size()<=10){
				out.print("<listSize value='"+list.size()+"'>");
				out.print(list.size());
				out.print("</listSize>");
				for (int i = 0; i < list.size(); i++) {
					G_RegisterAndGoodsInfoVO vo=(G_RegisterAndGoodsInfoVO) list.get(i);
					out.print("<registerGlideID value='"+vo.getRegisterGlideID()+"'>");
					out.print(vo.getRegisterGlideID());
					out.print("</registerGlideID>");
				}
				
			}else{
				out.print("<listSize value='"+10+"'>");
				out.print(10);
				out.print("</listSize>");
				for (int i = 0; i < 10; i++) {
					G_RegisterAndGoodsInfoVO vo=(G_RegisterAndGoodsInfoVO) list.get(i);
					out.print("<registerGlideID value='"+vo.getRegisterGlideID()+"'>");
					out.print(vo.getRegisterGlideID());
					out.print("</registerGlideID>");
				}
			}
		}
		out.print("</info>");
		out.close();
		return null;
	}
}