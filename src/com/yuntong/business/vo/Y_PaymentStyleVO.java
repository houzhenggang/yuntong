package com.yuntong.business.vo;
/***
 * 
 * @author yqy
 *货款计算方式
 */
public class Y_PaymentStyleVO {
private int	paymentID; //编号
private String	paymentName;//名称
private String 	paymentRemark;//详细说明
public int getPaymentID() {
	return paymentID;
}
public void setPaymentID(int paymentID) {
	this.paymentID = paymentID;
}
public String getPaymentName() {
	return paymentName;
}
public void setPaymentName(String paymentName) {
	this.paymentName = paymentName;
}
public String getPaymentRemark() {
	return paymentRemark;
}
public void setPaymentRemark(String paymentRemark) {
	this.paymentRemark = paymentRemark;
}
}
