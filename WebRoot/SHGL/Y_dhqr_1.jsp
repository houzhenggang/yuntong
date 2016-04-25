<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>到货确认</title>

	<%-------------------------------------------查询货票信息ajax------------------------------------%>
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
	var myinputid=document.form1.inputID.value;
	if(myinputid==null||myinputid==""){
		document.form1.inputID.focus();
		alert("查询条件不能为空!!");
		return;
	}
	if(isNaN(myinputid)==true)
		{
			document.form1.inputID.focus();
			alert("编号必须为数字");			
			return;
		}
	if(myinputid.length>28)
                {
                        alert("长度超出限制");
                        document.form1.inputID.focus();
                        return;
		}
	//得到查询类型
	var myinputtype=1;
	if(document.form1.seltype[0].checked==true){
	myinputtype=document.form1.seltype[0].value;
	}else{
	myinputtype=document.form1.seltype[1].value;
	}
	createXmlHttpRequest();
	var queryString="/yuntong/SHGL/y_FindRegisterByID.do?inputID="+myinputid+"&inputType="+myinputtype+"&";
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
var xmldoc=xmlHttp.responseXML;//以xml格式得到用户的数据	
	var root=xmldoc.documentElement;//得到XML文件的根
	//错误信息

	var mynodes=root.getElementsByTagName("error");
	var info=mynodes[0].text;//得到提示信息	
	if(info!=1){
	document.form1.inputID.focus();
	alert(info);
	return;
	}
addMyChildNodes("strdate","strdate");
addMyChildNodes("registerID","registerID");
addMyChildNodes("registerLine","registerLine");
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
	document.getElementById("MyinputID").value="";
	this.removeChileInfo("strdate");
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
<%-------------------------------------------确认信息------------------------------------%>
function doRequestUpdate(){
	if(confirm("您确认到货吗？")==false){
		return;
	}
	createXmlHttpRequest();
	var queryString="/yuntong/SHGL/y_UpdateRegisterType.do?";
	queryString=queryString+createQueryString();
	//状态改变时
	xmlHttp.onreadystatechange=stateUpdateChange;
	xmlHttp.open("get",queryString,true);
	xmlHttp.send(null);

}
function stateUpdateChange(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){		
			parseUpdateResults();
		}
	}
}
//更新
function parseUpdateResults(){
	alert(xmlHttp.responseText);
	this.myReset();
}
//google查询
    							function google(ty){
    							
   									new CAPXOUS.AutoComplete("inputID", function() 
   									{   								  								
       								return "/yuntong/SHGL/y_googleDHQR.do?typing=" + this.text.value;
   									}   								
   									);
   								
								}
								
</script>
<%-------------------------------------------ajax------------------------------------%>

  </head>
  <script type="text/javascript" src="/yuntong/js/prototype1.js"></script>
<script type="text/javascript" src="/yuntong/js/autocomplete1.js"></script>
    <link rel="stylesheet" type="text/css" href="/yuntong/css/autocomplete1.css" /> 
  <link rel="stylesheet" type="text/css" href="/yuntong/css/maple.css" />
   <body onload="google();" background="/yuntong/picture/bk3.jpg" topmargin="0" marginheight="0" leftmargin="0" rightmargin="0" marginwidth="0">
  	<%@include file="/Y_Top.jsp" %>
	 <table width="984" BORDER=0 CELLSPACING=0 CELLPADDING=0>    	
    	<tr>
    		<td width="12%" valign="top" >
    		<!-- 左菜单 -->
    		<%@include file="/Y_Left.jsp" %>
    		</td>
    		<td valign="top" align="left" width="88%">
    			<!-- 中间内容（开始） -->
    				<table border="0" class="tx" width="100%">
    					<tr>
    						<td>当前位置：>><a href="/yuntong/y_GoIndex.do">首页</a>>>收货管理>>到货确认</td>
    					</tr>
    				</table>
    				<table border="0" width="100%" class="tx">
    					<tr>
    						<td background="" align="left">    						
    						<img height="68" width="90" border="0" src="/yuntong/picture/shdj/jl1.bmp">													    						
    						</td>
    					</tr>
    				</table>
    				<!-- 到货确认（开始） -->
    				<br>
    				<table border="0" cellpadding="0" cellspacing="0" width="100%">
    					<tr valign="top">
    						<td rowspan="2">
    						<form name="form1" action="" method="get">
    							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tx">
    					<tr>
    						<td  bgcolor="a0c0c0"><span id="rid"><b>请输入货票编号</b></span><span id="cid" style="display:none"><b>请输入运输编号</b></span>    							
    							<input class="tx" id="MyinputID" type="text" name="inputID">
    							    							    							    							    							
    						</td>
    						<td  bgcolor="a0c0c0">
    							<b>查询条件</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;货票编号：
    							<input onclick="javascript:cid.style.display='none';rid.style.display='';google();" checked="checked" type="radio" name="seltype" value="1"  />
    							运输编号：<input type="radio" name="seltype" value="2" onclick="javascript:rid.style.display='none';cid.style.display='';google();" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    							<input class="tx" type="button" onclick="doRequest();" name="" value="查询">
    							
    						</td>
    					</tr>
    				</table>
    				</form>
    				制单时间：<span id="strdate">&nbsp;</span>
    				<table width="100%" cellpadding="0" cellspacing="0" class="tx" border="1" align="center">
    									<tr>
    										<td width="90" bgcolor="c0c0c0">货票ID</td>
    										<td width="90"><font color="#c06040"><span id="registerID">&nbsp;</span></font></td> 
    										<td width="90" bgcolor="c0c0c0">运输线路</td>
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
    								<table width="100%" border="0">
    									<tr>
    										<td align="center"><br>
    											<input onclick="doRequestUpdate();" class="tx" type="button" value="到货确认">    											
    										</td>
    										<td align="center"><br>
    											<input onclick="myReset();" class="tx" type="button" value="清空信息">    											
    										</td>
    									</tr>    								
    								</table>
    				<!-- 到货确认（结束） -->    	    						    						    						
    						</td>
    						<td valign="top" width="20%">
    						<!-- 操作步骤 -->
    							<table width="100%" border="0" cellpadding="0" cellspacing="0">
    							<tr>
    								<td background="/yuntong/picture/loginpage.gif" align="center"><br><font color="red">操作步骤</font></td>
    							</tr>
    							<tr>
    								<td background="/yuntong/picture/bg1.jpg"><font color="#804060">
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.选择查询条件
    						<br><br>
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.输入查询信息查询
    						<br><br>
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.检查无误后选择确定
    						</font>
    						<br>
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
    						<td valign="top">
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
    												到货确认是对从南方分站送往北方分站的货物进行登记的页面，工作原理：查找到需要登记的货票，修改货票的状态为已到货
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
    				</table> <br>   			    			    
    			<hr align="center" width="100%" size="1"/>	    			    			
    			<!-- 中间内容(结束) -->
    		</td>
    	</tr>
    </table>    
  </body>
</html:html>

