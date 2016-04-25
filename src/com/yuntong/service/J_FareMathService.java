package com.yuntong.service;

import java.util.List;

import com.yuntong.business.vo.*;

public interface J_FareMathService {
   public J_FareMathVo FindregisterId(int id);
   public void faremath(int goodsid,int typeid);
   public void Richange(int rigid ,int typeid);
   public  CheckRigVO CheckRig(int id);
   public List ShowState();
   public void RigStateChange(int rigid ,int typeid);
// ∑—”√π¿À„google
   public List findTopTen(int id);
   

}
