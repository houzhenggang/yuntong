package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.yuntong.business.vo.Y_FreightStyleVO;
import com.yuntong.business.vo.Y_PaymentStyleVO;
import com.yuntong.hibernate.database.dao.TFreightStyleDAO;
import com.yuntong.hibernate.database.dao.TPaymentOfGoodsStyleDAO;
import com.yuntong.hibernate.database.po.TFreightStyle;
import com.yuntong.hibernate.database.po.TPaymentOfGoodsStyle;
import com.yuntong.service.Y_IGoodsManagerService;
/***
 * 
 * @author yqy
 *	货物信息管理
 */
public class Y_GoodsManagerService implements Y_IGoodsManagerService {
	private TFreightStyleDAO styleDAO;
	private TPaymentOfGoodsStyleDAO goodsStyleDAO;
	
	
	//	得到所有结算方式
	public List findAllFreight() {
		List list=styleDAO.findAllFreightInfo();
		List rlist=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Y_FreightStyleVO vo=new Y_FreightStyleVO();
			vo.setFreightID(((TFreightStyle)(list.get(i))).getFreightId());
			vo.setFreightName(((TFreightStyle)(list.get(i))).getFreightName());
			vo.setFreightRemark(((TFreightStyle)(list.get(i))).getFreightRemark());
			rlist.add(vo);
		}
		return rlist;
	}
	//得到所有货款计算方式
	public List findAllPaymentInfo() {
		List list=goodsStyleDAO.findAllPaymentInfo();
		List rlist=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Y_PaymentStyleVO vo=new Y_PaymentStyleVO();
			vo.setPaymentID(((TPaymentOfGoodsStyle)(list.get(i))).getPaymentId());
			vo.setPaymentName(((TPaymentOfGoodsStyle)(list.get(i))).getPaymentName());
			vo.setPaymentRemark(((TPaymentOfGoodsStyle)(list.get(i))).getPaymentRemark());
			rlist.add(vo);
		}
		return rlist;
	}

	public TPaymentOfGoodsStyleDAO getGoodsStyleDAO() {
		return goodsStyleDAO;
	}
	public void setGoodsStyleDAO(TPaymentOfGoodsStyleDAO goodsStyleDAO) {
		this.goodsStyleDAO = goodsStyleDAO;
	}
	public TFreightStyleDAO getStyleDAO() {
		return styleDAO;
	}
	public void setStyleDAO(TFreightStyleDAO styleDAO) {
		this.styleDAO = styleDAO;
	}
}
