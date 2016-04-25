<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>收货登记</title>

	<%-------------------------------------------ajax------------------------------------%>
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
<%-------------------------------------------地区市场关联(开始)------------------------------------%>
function doRequest(areavalue){
	
	createXmlHttpRequest();
	var queryString="/yuntong/SHGL/y_FindMarketByAreaID.do?areavalue="+areavalue+"&";
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
	var nodes=root.getElementsByTagName("market");
	document.cinfo.marketvalue.options.length=0;//清除以前的所有选项
	for(i=0;i<nodes.length;i++){//循环添加下拉列表
		//选项值
		document.cinfo.marketvalue.options.add(new Option(nodes[i].text));
		//value属性
		document.cinfo.marketvalue.options[i].value=nodes[i].attributes.getNamedItem("value").value;		
	}
}
<%-------------------------------------------地区市场关联(结束)------------------------------------%>
<%-------------------------------------------客户查询(开始)------------------------------------%>
function doRequestSelect(){
//验证
	if(document.select.clientID.value==null||document.select.clientID.value==""){
		alert("查询条件不能为空！");
		document.select.clientID.focus();
		return;
	}
	if(isNaN(document.select.clientID.value)==true)
		{
			alert("编号必须为数字");	
			document.select.clientID.focus();		
			return;
		}
	var selvalue=document.select.clientID.value;
	createXmlHttpRequest();
	var queryString="/yuntong/SHGL/y_FindClientByID.do?sid="+selvalue+"&";
	queryString=queryString+createQueryString();
	//状态改变时
	xmlHttp.onreadystatechange=stateChangeSelect;
	xmlHttp.open("get",queryString,true);
	xmlHttp.send(null);

}
function stateChangeSelect(){
	if(xmlHttp.readyState==4){
	//alert(xmlHttp.status+"");
		if(xmlHttp.status==200){
			parseResultsSelect();
		}
	}
}
//更新
function parseResultsSelect(){
	var xmldoc=xmlHttp.responseXML;//以xml格式得到用户的数据	
	var root=xmldoc.documentElement;//得到XML文件的根
	//错误信息

	var mynodes=root.getElementsByTagName("error");
	var info=mynodes[0].text;//得到提示信息	
	if(info!=1){
	document.select.clientID.focus();
	document.select.reset();
	alert(info);
	return;
	}
	//编号
	var mynodes1=root.getElementsByTagName("cid");
	var info1=mynodes1[0].text;//得到提示信息	
	document.cinfo.mycid.value=info1;
	document.cinfo.cid.value=info1;
	//地区
	var mynodes2=root.getElementsByTagName("areaname");
	var info2=mynodes2[0].text;//得到提示信息
	document.cinfo.areavalue.options[document.cinfo.areavalue.selectedIndex].text=info2;

	//市场
	var mynodes3=root.getElementsByTagName("cmarketname");
	var info3=mynodes3[0].text;//得到提示信息
	document.cinfo.marketvalue.options[document.cinfo.marketvalue.selectedIndex].text=info3;
	 //公司名称
	 var mynodes4=root.getElementsByTagName("ccompany");
	var info4=mynodes4[0].text;//得到提示信息	
	document.cinfo.cname.value=info4;
    // 联系人
    var mynodes5=root.getElementsByTagName("cname");
	var info5=mynodes5[0].text;//得到提示信息	
	document.cinfo.cman.value=info5; 
    // 客户电话
    var mynodes6=root.getElementsByTagName("sphone");
	var info6=mynodes6[0].text;//得到提示信息	
	document.cinfo.cphone.value=info6;
    // 电子邮件
    var mynodes7=root.getElementsByTagName("cemail");
	var info7=mynodes7[0].text;//得到提示信息	
	document.cinfo.cemail.value=info7;
    // 邮政编码
    var mynodes8=root.getElementsByTagName("cpostid");
	var info8=mynodes8[0].text;//得到提示信息	
	document.cinfo.cpostid.value=info8;
	// 地址
    var mynodes9=root.getElementsByTagName("caddress");
	var info9=mynodes9[0].text;//得到提示信息	
	document.cinfo.caddress.value=info9;
	//控键设置为不可用
	document.cinfo.areavalue.disabled="disabled";
	document.cinfo.marketvalue.disabled="disabled";
	document.cinfo.cname.disabled="disabled";
	document.cinfo.cman.disabled="disabled";
	document.cinfo.cphone.disabled="disabled";
	document.cinfo.cpostid.disabled="disabled";
	document.cinfo.cemail.disabled="disabled";
	document.cinfo.caddress.disabled="disabled";
	ts.style.display="";
	ts2.style.display="none";
}
//还原控键状态
function MyReset(){
	document.cinfo.areavalue.disabled="";
	document.cinfo.marketvalue.disabled="";
	document.cinfo.cname.disabled="";
	document.cinfo.cman.disabled="";
	document.cinfo.cphone.disabled="";
	document.cinfo.cpostid.disabled="";
	document.cinfo.cemail.disabled="";
	document.cinfo.caddress.disabled="";
	document.cinfo.reset();
	ts.style.display="none";
	ts2.style.display="";
}
<%-------------------------------------------客户查询(结束)------------------------------------%>
</script>
<%-------------------------------------------ajax------------------------------------%>
  </head>
  <link rel="stylesheet" type="text/css" href="/yuntong/css/maple.css" />
   <body background="/yuntong/picture/bk3.jpg" topmargin="0" marginheight="0" leftmargin="0" rightmargin="0" marginwidth="0" onload="doRequest(document.cinfo.areavalue.options[document.cinfo.areavalue.selectedIndex].value);MyReset();">
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
    						<td>当前位置：>><a href="/yuntong/y_GoIndex.do">首页</a>>>收货管理>>收货登记</td>
    					</tr>
    				</table>
    				<table border="0" width="100%" class="tx">
    					<tr>
    						<td background="" align="left">    						
    						<img height="68" width="90" border="0" src="/yuntong/picture/shdj/dhdj.gif">													    						
    						</td>
    					</tr>
    				</table><br>
    				<table border="0" width="100%" cellpadding="0" cellspacing="0">
    					<tr valign="top">
    						<td rowspan="2">
    							<!--================ 客户登记  ===================-->
    							<form action="" method="post" name="select">
    							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tx" align="center">
    								<tr>
    									<td bgcolor="a0c0c0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>客户信息登记：</b></td>
    								</tr>
    								<tr>
    									<td bgcolor=""><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>已登记客户：</b><br>
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户编号：<input class="tx"  type="text" name="clientID">
										<script type="text/javascript">
   
   												 new CAPXOUS.AutoComplete("clientID", function() {
       												 return "/yuntong/SHGL/y_findcinfo.do?typing=" + this.text.value;
   														 });

													</script>&nbsp;&nbsp;&nbsp;&nbsp;
    									<input class="tx"  type="button" onclick="doRequestSelect();" value="查找信息"><br>&nbsp;
    									</td>
    								</tr>
    							</table>
    							</form>
    							<form action="/yuntong/SHGL/y_SHDJClientAction.do" method="post" name="cinfo">
    							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tx" align="center">
    								<tr>
    									<td colspan="2" bgcolor="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><span id="ts2" style="">未登记客户：</span><span id="ts" style="display:none">查询结果：</span></b></td>    									
    								</tr>
    								<tr>
    									<td bgcolor="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户编号：
    									<input type="hidden" name="mycid" value="9">
    									<input type="text" class="tx" name="cid" disabled="disabled" value="系统生成" >
    									<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地区：&nbsp;&nbsp;&nbsp;&nbsp;
    										<select id="areavalue" name="areavalue" class="tx" onchange="doRequest(areavalue.options[areavalue.selectedIndex].value);">
    										<c:forEach items="${sessionScope.areainfo}" var="ainfo">
    										<option value="${ainfo.areaID}">${ainfo.areaCity}</option>
    										</c:forEach>
    										</select>
    									市场：
    									<select id="marketvalue" name="marketvalue" class="tx">
    									<c:forEach items="${sessionScope.marketinfo}" var="minfo">
    										<option>${minfo.marketName}</option>
    										</c:forEach>
    									</select><br>
    									
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公司名称：<input type="text" class="tx" name="cname">&nbsp;<font color="red">*</font><br>
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系人&nbsp;&nbsp;&nbsp;：<input class="tx"  type="text" name="cman">&nbsp;<font color="red">*</font><br>
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户电话：<input type="text"  class="tx" name="cphone">&nbsp;<font color="red">*</font><br>
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电子邮件：<input type="text" class="tx"  name="cemail">&nbsp;<font color="red">*</font><br>
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：<input type="text"  class="tx" name="cpostid"><br>
    									</td>
    									<td width="260" bgcolor="">
    										<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;场内地址：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea  class="tx" name="caddress" rows="7" cols="28"></textarea>
    									</td>
    									 									
    								</tr>
    								<tr>
    									<td colspan="2" align="center" bgcolor=""><br>
    										<a href="/yuntong/SHGL/y_SHDJbuck1.do" class="tx">上一步</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    										<input class="tx"  type="button" onclick="MyReset();" name="" value="重新填写">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    										<input class="tx"  type="submit" name="" value="下一步"><br>&nbsp;
    									</td>   
    								</tr>
    							</table>
							</form>    							    						    						    						    						
    						</td>
    						<td valign="top" width="20%">
    							<!-- 操作步骤 -->
    							<table width="100%" border="0" cellpadding="0" cellspacing="0">
    							<tr>
    								<td background="/yuntong/picture/loginpage.gif" align="center"><br><font color="red">操作步骤</font></td>
    							</tr>
    							<tr>
    								<td background="/yuntong/picture/bg1.jpg">
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.填写厂商信息
    						<br><br>
    						&nbsp;&nbsp;&nbsp;-->2.<font color="red">录入收货人信息</font>
    						<br><br>
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.登记货物情况
    						<br><br>
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.生成货票
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
    						<td >
								<!-- 提示信息 -->
    							<table width="100%" border="0" cellpadding="0" cellspacing="0">
    							<tr>
    								<td background="/yuntong/picture/loginpage.gif" align="center"><br><font color="red">提示信息</font></td>
    							</tr>
    							<tr>
    								<td background="/yuntong/picture/bg1.jpg" align="center">
    									<table border="0" width="80%" height="140">
    										<tr>
    											<td id="Y_tishi">
    												收货登记是对南方厂商准备运送的商品进行登记的页面，其中包含厂商登记，客户登记货物信息登记三个步骤。登记完毕生成未估价货票
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

