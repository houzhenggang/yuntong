/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yuntong.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yuntong.business.vo.G_TruckInfoVO;
import com.yuntong.service.G_ITruckInfoService;

/** 
 * MyEclipse Struts
 * Creation date: 04-10-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class G_FindTruckInfoAction extends Action {
	private G_ITruckInfoService truckInfoService;
	
	/*
	 * Generated Methods
	 */

	public G_ITruckInfoService getTruckInfoService() {
		return truckInfoService;
	}

	public void setTruckInfoService(G_ITruckInfoService truckInfoService) {
		this.truckInfoService = truckInfoService;
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
		String str=request.getParameter("truckNum");
		String truckNum=new String(str.getBytes("ISO-8859-1"),"UTF-8");
		G_TruckInfoVO vo=truckInfoService.getTruckInfoByTruckNum(truckNum);
		out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.print("<info>");
		//���ƺ���
		out.print("<truckNum value='"+vo.getTruckNum()+"'>");
		out.print(vo.getTruckNum());
		out.print("</truckNum>");
		//��������
		out.print("<truckEngineNum value='"+vo.getTruckEngineNum()+"'>");
		out.print(vo.getTruckEngineNum());
		out.print("</truckEngineNum>");
		//��ʻ֤��
		out.print("<truckRunNum value='"+vo.getTruckRunNum()+"'>");
		out.print(vo.getTruckRunNum());
		out.print("</truckRunNum>");
		//�� �� ��
		out.print("<truckInsuranceNum value='"+vo.getTruckInsuranceNum()+"'>");
		out.print(vo.getTruckInsuranceNum());
		out.print("</truckInsuranceNum>");
		//�� �� ��
		out.print("<truckStyleID value='"+vo.getTruckStyleID()+"'>");
		out.print(vo.getTruckStyleID());
		out.print("</truckStyleID>");
		//��   ɫ
		out.print("<truckColor value='"+vo.getTruckColor()+"'>");
		out.print(vo.getTruckColor());
		out.print("</truckColor>");
		//�ϴ���Ƭ
		out.print("<truckPhoto value='"+vo.getTruckPhoto()+"'>");
		out.print(vo.getTruckPhoto());
		out.print("</truckPhoto>");
		//��������
		out.print("<truckBuyDate value='"+vo.getTruckBuyDate()+"'>");
		out.print(vo.getTruckBuyDate());
		out.print("</truckBuyDate>");
		//ʹ������
		out.print("<truckFixed value='"+vo.getTruckFixed()+"'>");
		out.print(vo.getTruckFixed());
		out.print("</truckFixed>");
		//������˾���
		out.print("<truckCompanyID value='"+vo.getTruckCompanyID()+"'>");
		out.print(vo.getTruckCompanyID());
		out.print("</truckCompanyID>");
		out.print("</info>");
		out.close();
		return null;
	}
}