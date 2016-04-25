package com.yuntong.service;

import com.yuntong.business.vo.J_ShaoVO;
import com.yuntong.hibernate.database.po.TAgioInfo;

public interface J_ShaoShouKuanService {
   public J_ShaoVO ShaoShouKuan(int id);
   public void SaveShaoShouKuan(TAgioInfo shaoVO);
}
