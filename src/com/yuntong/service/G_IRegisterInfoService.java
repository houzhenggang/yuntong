package com.yuntong.service;

import java.util.List;

import com.yuntong.business.vo.G_RegisterAndGoodsInfoVO;

public interface G_IRegisterInfoService {
	public G_RegisterAndGoodsInfoVO findRegisterInfoByRegisterGlideID(long registerGlideId);
	public int[] getTotalRegisterByYear(String year);
	public List getRegisterInfoListByID(String id,int type);
	public void changeRegisterState(long registerGlideId);
}
