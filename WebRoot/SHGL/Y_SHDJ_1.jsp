<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>损货登记</title>

	<%-------------------------------------------查询货票信息ajax------------------------------------%>
	<script type="text/javascript" src="/yuntong/js/prototype1.js"></script>
<script type="text/javascript" src="/yuntong/js/autocomplete1.js"></script>
    <link rel="stylesheet" type="text/css" href="/yuntong/css/autocomplete1.css" /> 
<script type="text/javascript">
var xmlHttp;
//创建联接
function createXmlHttpRequest(){
	//根据不同浏览器创建
	if(window.ActiveXObject){
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}else if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}
}
//拼提交语句
function createQueryString(){
    //防止缓存
	var queryString="timeStamp="+new Date().getTime();
	return queryString;
}
//主
function doRequest(){
	//得到查询文本
	var myinputid=document.getElementById("inputID").value;
	
	if(myinputid==null||myinputid==""){
		
		alert("查询条件不能为空!!");
		return;
	}
	if(isNaN(myinputid)==true)
		{
			
			alert("编号必须为数字");			
			return;
		}
	if(myinputid.length>28)
                {
                        alert("长度超出限制");
                       //document.getElementById("inputID").focus();
                        return;
		}
	//得到查询类型
	
	createXmlHttpRequest();
	var queryString="/yuntong/SHGL/y_CKXX.do?inputID="+myinputid+"&";
	queryString=queryString+createQueryString();
	//状态改变时
	xmlHttp.onreadystatechange=stateChange;
	xmlHttp.open("get",queryString,true);
	xmlHttp.send(null);
	
}
function stateChange(){
	if(xmlHttp.readyState==4){
	//alert(xmlHttp.status+"");
		if(xmlHttp.status==200){
			parseResults();
		}
	}
}
//更新
function parseResults(){


		this.addInfo();
}
function addInfo(){

	var xmldoc=xmlHttp.responseXML;//以xml格式得到用户的数据	
	var root=xmldoc.documentElement;//得到XML文件的根
	//错误信息

	var mynodes=root.getElementsByTagName("error");
	var info=mynodes[0].text;//得到提示信息		
	if(info!=1){	
	alert(info);
	return;
	}
addMyChildNodes("registerID","registerID");
addMyChildNodes("registerLine","roadwayID");
addMyChildNodes("registerConveyanceID","registerConveyanceID");
addMyChildNodes("registerClientName","registerClientName");	
addMyChildNodes("registerClientPhone","registerClientPhone");	
addMyChildNodes("registerFactoryName","registerFactoryName");	
addMyChildNodes("registerFactoryphone","registerFactoryphone");
addMyChildNodes("goodsName","goodsName");
addMyChildNodes("goodsNumber","goodsNumber");
addMyChildNodes("goodsHeft","goodsHeft");
addMyChildNodes("goodsBulk","goodsBulk");
addMyChildNodes("registerFreightName","registerFreightName");
addMyChildNodes("goodsPaymentModeName","goodsPaymentModeName");
addMyChildNodes("goodsFreight","goodsFreight");
addMyChildNodes("goodsInsuranceValue","goodsInsuranceValue");
addMyChildNodes("goodsAllValue","goodsAllValue");
addMyChildNodes("goodsRemarkInfo","goodsRemarkInfo");
addMyChildNodes("driverName","driverName");
addMyChildNodes("carName","carName");
addMyChildNodes("formatStartDate","formatStartDate");
//填加车次编号
var xmldoc=xmlHttp.responseXML;//以xml格式得到用户的数据	
	var root=xmldoc.documentElement;//得到XML文件的根
	var mynodes=root.getElementsByTagName("roadwayID");
	var info=mynodes[0].text;//得到提示信息
document.getElementById("roid").value=info;

}

//目标层，标签名
function addMyChildNodes(name,tagname){
	var xmldoc=xmlHttp.responseXML;//以xml格式得到用户的数据	
	var root=xmldoc.documentElement;//得到XML文件的根
	var mynodes=root.getElementsByTagName(tagname);
	var info=mynodes[0].text;//得到提示信息
	var span=document.getElementById(name);
	if(span.hasChildNodes()){
		span.removeChild(span.childNodes[0]);
	}		
	span.appendChild(document.createTextNode(info));
}
//清空接点内容
function myReset(){
	document.getElementById("roid").value="";
	document.getElementById("inputID").value="";
	document.getElementById("money").value="";
	document.getElementById("cause").value="";
	this.removeChileInfo("registerID");
	this.removeChileInfo("registerLine");
	this.removeChileInfo("registerConveyanceID");
	this.removeChileInfo("registerClientName");
	this.removeChileInfo("registerClientPhone");
	this.removeChileInfo("registerFactoryName");
	this.removeChileInfo("registerFactoryphone");
	this.removeChileInfo("goodsName");
	this.removeChileInfo("goodsNumber");
	this.removeChileInfo("goodsHeft");
	this.removeChileInfo("goodsBulk");
	this.removeChileInfo("registerFreightName");
	this.removeChileInfo("goodsPaymentModeName");
	this.removeChileInfo("goodsFreight");
	this.removeChileInfo("goodsInsuranceValue");
	this.removeChileInfo("goodsAllValue");	
	this.removeChileInfo("goodsRemarkInfo");
	this.removeChileInfo("driverName");
	this.removeChileInfo("carName");
	this.removeChileInfo("formatStartDate");		
}
//清空层内容
function removeChileInfo(name){
	var span=document.getElementById(name);
	if(span.hasChildNodes()){
		span.removeChild(span.childNodes[0]);
	}
}
<%-------------------------------------------查询货票信息ajax------------------------------------%>
<%-------------------------------------------填加损货信息ajax------------------------------------%>
function doInsertInfo(){
	var rid=document.getElementById("rid").value;
	var roid=document.getElementById("roid").value;
	var money=document.getElementById("money").value;
	var cause=document.getElementById("cause").value;
	
	if(rid==""){
		alert("货票编号不能为空!!");
		return;
	}
	if(money==""){
		alert("损失金额不能为空!!");
		return;
	}
	if(isNaN(money)==true)
		{
			
			alert("损失金额必须为数字");			
			return;
		}
	if(cause==""){
		alert("损失原因不能为空!!");
		return;
	}
	createXmlHttpRequest();
	//var queryString="/yuntong/SHGL/y_disrepareInfo.do?rid="+rid+"&roid="+roid+"&money="+money+"&cause="+cause+"&";
	//queryString=queryString+createQueryString();
	//状态改变时
	//xmlHttp.onreadystatechange=stateChangeInsert;
	//xmlHttp.open("get",queryString,true);
	//xmlHttp.send(null);
	
	var url="/yuntong/SHGL/y_disrepareInfo.do?timeStamp="+new Date().getTime();
	var queryString="rid="+rid+"&roid="+roid+"&money="+money+"&cause="+cause;
	xmlHttp.open("POST",url,true);
	xmlHttp.onreadystatechange=stateChangeInsert;
	xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;");
	xmlHttp.send(queryString);
}
function stateChangeInsert(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			parseResultsInsert();
		}
	}
}
//更新
function parseResultsInsert(){
	var text=xmlHttp.responseText;
	alert(text);
	document.getElementById("roid").value="";
	this.myReset();
}

<%-------------------------------------------填加损货信息ajax------------------------------------%>
</script>
  </head>
  <link rel="stylesheet" type="text/css" href="/yuntong/css/maple.css" />
   <body background="/yuntong/picture/bk3.jpg" topmargin="0" marginheight="0" leftmargin="0" rightmargin="0" marginwidth="0">
  	<%@include file="/Y_Top.jsp" %>
	 <table width="984" BORDER=0 CELLSPACING=0 CELLPADDING=0>    	
    	<tr>
    		<td width="12%" valign="top" >
    		<!-- 左菜单 -->
    		<%@include file="/Y_Left.jsp" %>
    		</td>
    		<td valign="top" align="left" width="88%">
    			<!-- 中间内容（开始） -->
    				<table border="0" cellpadding="0" cellspacing="0" class="tx" width="100%">
    					<tr>
    						<td>当前位置：>><a href="/yuntong/y_GoIndex.do">首页</a>>>收货管理>>损货登记</td>
    					</tr>
    				</table>
    				<table border="0" width="100%" class="tx">
    					<tr>
    						<td background="" align="left">    						
    						<img height="68" width="90" border="0" src="/yuntong/picture/shdj/jcxs33.gif">													    						
    						</td>
    					</tr>
    				</table>
    				<table  width="100%" border="0" cellpadding="0" cellspacing="0">
    					<tr>
    						<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr bgcolor="a0c0c0">
										<td colspan="2">
											<font color="#804060" size="3">请输入损货信息</font>
										</td>
									</tr>
									<tr>
										<td>&nbsp;<font color="#804060">已到货货票编号：</font></td>
										<td>
										<input id="inputID" type="text" name="rid" class="tx">&nbsp;&nbsp;<input type="hidden" name="roid" value="1">
										<script type="text/javascript">
   												
   												 new CAPXOUS.AutoComplete("inputID", function() {
       												 return "/yuntong/SHGL/y_googleSHDJ.do?typing=" + this.text.value;
   														 });

													</script>
    							    			
										<input type="button" onclick="doRequest();" name="check" value="查看详细" class="tx">
										</td>
									</tr>
									<tr>
										<td>&nbsp;<font color="#804060">损失金额：</font></td>
										<td><input id="money" type="text" class="tx"></td>
									</tr>
									<tr>
										<td>&nbsp;<font color="#804060">损失原因：</font></td>
										<td><textarea id="cause" class="tx" cols="40" rows="4"></textarea></td>
									</tr>
									<tr>
										<td align="center">
											<input type="button" onclick="doInsertInfo();" name="submit" value="确认" class="tx">
										</td>
										<td align="center">
											<input type="button" onclick="myReset();" name="reset" value="取消" class="tx">
										</td>
									</tr>
								</table>
    						</td>
    						<td>
    						<!-- 操作步骤 -->
    							<table width="100%" border="0" cellpadding="0" cellspacing="0">
    							<tr>
    								<td background="/yuntong/picture/loginpage.gif" align="center"><br><font color="red">操作步骤</font></td>
    							</tr>
    							<tr>
    								<td background="/yuntong/picture/bg1.jpg"><br>
    									<font color="#804060">
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.输入货票编号<br>
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.如果需要查看货票信息，在填写
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好货票编号后单击查看详细<br>
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.输入损货金额及原因<br>
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.单击确定<br></font>
    								</td>
    							</tr>
    							<tr>
    							<td>
    								<img src="/yuntong/picture/bottom.jpg">
    							</td>
    							</tr>
    							</table>
    							<!-- 操作步骤 -->
    						</td>
    					</tr>
    					<tr>
    						<td>
    						<!-- 详细信息 -->
    				<table width="100%" class="tx" border="1" cellpadding="0" cellspacing="0">
    					<tr bgcolor="a0c0c0">
										<td colspan="2">
											<font color="#804060" size="3">详细信息</font>
										</td>
									</tr>
    				</table>
    				<table width="100%" class="tx" border="1" cellpadding="0" cellspacing="0" align="center">
    									<tr>
    										<td width="90" bgcolor="c0c0c0">货票ID</td>
    										<td width="90"><font color="#c06040"><span id="registerID">&nbsp;</span></font></td> 
    										<td width="90" bgcolor="c0c0c0">运输车次</td>
    										<td width="90"><font color="#c06040"><span id="registerLine">&nbsp;</span></font></td>
    										<td width="100" bgcolor="c0c0c0">运输编号</td>
    										<td><font color="#c06040"><span id="registerConveyanceID">&nbsp;</span></font></td>    										   										
    									</tr>
    									<tr>
    										<td bgcolor="c0c0c0">收货单位</td>
    										<td colspan="2"><font color="#c06040"><span id="registerClientName">&nbsp;</span></font></td>
    										<td bgcolor="c0c0c0">电话</td>
    										<td colspan="2"><font color="#c06040"><span id="registerClientPhone">&nbsp;</span></font></td>    										
    									</tr>
    									<tr>
    										<td bgcolor="c0c0c0">发货厂商</td>
    										<td colspan="2"><font color="#c06040"><span id="registerFactoryName">&nbsp;</span></font></td>
    										<td bgcolor="c0c0c0">电话</td>
    										<td colspan="2"><font color="#c06040"><span id="registerFactoryphone">&nbsp;</span></font></td>    										
    									</tr>
    									<tr>
    										<td bgcolor="c0c0c0">货物名称</td>
    										<td bgcolor="c0c0c0">件数</td>
    										<td bgcolor="c0c0c0">重量</td>
    										<td bgcolor="c0c0c0">方量</td>
    										<td bgcolor="c0c0c0">付款方式</td>
    										<td bgcolor="c0c0c0">计价方式</td>
    									</tr>
    									<tr>
    										<td><font color="#c06040"><span id="goodsName">&nbsp;</span></font></td>
    										<td><font color="#c06040"><span id="goodsNumber">&nbsp;</span></font></td>
    										<td><font color="#c06040"><span id="goodsHeft">&nbsp;</span></font></td>
    										<td><font color="#c06040"><span id="goodsBulk">&nbsp;</span></font></td>
    										<td><font color="#c06040"><span id="registerFreightName">&nbsp;</span></font></td>
    										<td><font color="#c06040"><span id="goodsPaymentModeName">&nbsp;</span></font></td>
    									</tr>
    									<tr>
    										<td bgcolor="c0c0c0">运费</td>
    										<td><font color="#c06040"><span id="goodsFreight">&nbsp;</span></font></td>
    										<td bgcolor="c0c0c0">保费</td>
    										<td><font color="#c06040"><span id="goodsInsuranceValue">&nbsp;</span></font></td>
    										<td bgcolor="c0c0c0">合计</td>
    										<td><font color="#c06040"><span id="goodsAllValue">&nbsp;</span></font></td>
    									</tr>
    									<tr>
    										<td rowspan="" bgcolor="c0c0c0" height="60">备注</td>
    										<td rowspan="" colspan="5"><font color="#c06040"><span id="goodsRemarkInfo">&nbsp;</span></font></td>    										
    									</tr>
    									<tr>
    										<td bgcolor="c0c0c0">司机</td>
    										<td><font color="#c06040"><span id="driverName">&nbsp;</span></font></td>
    										<td bgcolor="c0c0c0">车牌号码</td>
    										<td><font color="#c06040"><span id="carName">&nbsp;</span></font></td>
    										<td bgcolor="c0c0c0">发货日期</td>
    										<td><font color="#c06040"><span id="formatStartDate">&nbsp;</span></font></td>
    									</tr>    							    							
    								</table>    								
    						<!-- 详细信息结束 -->		
    						</td>
    						<td width="100">
    							<!-- 提示信息 -->
    							<table width="100%" border="0" cellpadding="0" cellspacing="0">
    							<tr>
    								<td background="/yuntong/picture/loginpage.gif" align="center"><br><font color="red">提示信息</font></td>
    							</tr>
    							<tr>
    								<td background="/yuntong/picture/bg1.jpg"  align="center">
    									<table border="0" width="80%" height="140">
    										<tr>
    											<td id="Y_tishi">
    												损货登记是对从南方发往目的地的，已经到货的货物进行损失和减少信息的登记
    											</td>
    										</tr>
    									</table>
    								</td>
    							</tr>
    							<tr>
    							<td>
    								<img src="/yuntong/picture/bottom.jpg">
    							</td>
    							</tr>
    							</table>
    							<!-- 提示信息 -->
    						</td>
    					</tr>
    				</table>    			    			    			
    			<!-- 中间内容(结束) -->
    		</td>
    	</tr>
    </table>    
  </body>
</html:html>

