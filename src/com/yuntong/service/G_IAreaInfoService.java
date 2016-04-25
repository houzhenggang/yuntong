package com.yuntong.service;

import java.util.List;

public interface G_IAreaInfoService {
	/**
	 * 根据省查找城市
	 * @param province
	 * @return
	 */
	public List findCityByProvince(String province);
}
