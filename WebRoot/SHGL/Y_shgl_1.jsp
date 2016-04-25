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

	<%-------------------------------------------查询厂商ajax------------------------------------%>
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
function doRequest(){

	var getFactoryID=document.getElementById("ffi").value;
	//验证输入
	if(getFactoryID==null||getFactoryID==""){
		alert("查询参数不能为空！");
		document.form2.findFactoryID.focus();
		return;
	}
	if(isNaN(getFactoryID)==true)
		{
			alert("编号必须为数字");	
			document.form2.findFactoryID.focus();		
			return;
		}
	createXmlHttpRequest();
	var queryString="/yuntong/SHGL/y_SelectFactory.do?fid="+getFactoryID+"&";
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
	document.form2.findFactoryID.focus();
	document.form2.reset();
	alert(info);
	return;
	}
	//编号
	var mynodes1=root.getElementsByTagName("factoryID");
	var info1=mynodes1[0].text;//得到提示信息	
	document.form1.MyfactoryID.value=info1;
	document.form1.factoryID.value=info1;
	//公司名
	var mynodes2=root.getElementsByTagName("factoryName");
	var info2=mynodes2[0].text;//得到提示信息	
	document.form1.factoryName.value=info2;
	//联系人
	var mynodes3=root.getElementsByTagName("factoryLinkMan");
	var info3=mynodes3[0].text;//得到提示信息	
	document.form1.factoryLinkman.value=info3;
    //地区
	var mynodes4=root.getElementsByTagName("FAreaID");
	var info4=mynodes4[0].text;//得到提示信息
	for(var y=0;y<document.form1.factoryArea.options.length;y++){
		//循环判断id
		if(document.form1.factoryArea.options[y].value==info4){
			document.form1.factoryArea.options[y].selected="selected";	
		}
	}
	//联系电话
	var mynodes5=root.getElementsByTagName("FPhone");
	var info5=mynodes5[0].text;//得到提示信息	
	document.form1.factoryPhone.value=info5;
	//传真
	var mynodes6=root.getElementsByTagName("FFax");
	var info6=mynodes6[0].text;//得到提示信息	
	document.form1.factoryFax.value=info6;
	//邮政编码
	var mynodes7=root.getElementsByTagName("FPostID");
	var info7=mynodes7[0].text;//得到提示信息	
	document.form1.factoryPostID.value=info7;
	//电子邮件
	var mynodes8=root.getElementsByTagName("FEmail");
	var info8=mynodes8[0].text;//得到提示信息	
	document.form1.factoryEmail.value=info8;
	//详细地址
	var mynodes9=root.getElementsByTagName("FAddress");
	var info9=mynodes9[0].text;//得到提示信息	
	document.form1.factoryAddress.value=info9;
	//其他信息
	var mynodes10=root.getElementsByTagName("FInfo");
	var info10=mynodes10[0].text;//得到提示信息	
	document.form1.factoryInfo.value=info10;
	//控键设置为不可用
	document.form1.factoryName.disabled="disabled";
	document.form1.factoryLinkman.disabled="disabled";
	document.form1.factoryArea.disabled="disabled";
	document.form1.factoryPhone.disabled="disabled";
	document.form1.factoryFax.disabled="disabled";
	document.form1.factoryPostID.disabled="disabled";
	document.form1.factoryEmail.disabled="disabled";
	document.form1.factoryAddress.disabled="disabled";
	document.form1.factoryInfo.disabled="disabled";
	//
	ts.style.display="";
	ts2.style.display="none";
}
//还原控键状态
function MyReset(){
	document.form1.factoryName.disabled="";
	document.form1.factoryLinkman.disabled="";
	document.form1.factoryArea.disabled="";
	document.form1.factoryPhone.disabled="";
	document.form1.factoryFax.disabled="";
	document.form1.factoryPostID.disabled="";
	document.form1.factoryAddress.disabled="";
	document.form1.factoryEmail.disabled="";
	document.form1.factoryInfo.disabled="";
	
	ts.style.display="none";
	ts2.style.display="";
	
	document.form1.reset();
	//document.form2.reset();
	
}
</script>
<%-------------------------------------------查询厂商ajax------------------------------------%>
	
  </head>
   <script type="text/javascript" src="/yuntong/js/prototype1.js"></script>
<script type="text/javascript" src="/yuntong/js/autocomplete1.js"></script>
    <link rel="stylesheet" type="text/css" href="/yuntong/css/autocomplete1.css" /> 
  <link rel="stylesheet" type="text/css" href="/yuntong/css/maple.css" />
   <body background="/yuntong/picture/bk3.jpg" topmargin="0" marginheight="0" leftmargin="0" rightmargin="0" marginwidth="0" onload="MyReset();">
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
    						<td>当前位置：>><a href="/yuntong/y_GoIndex.do">首页</a>>>收货管理>>收货登记</td>
    					</tr>
    				</table>
    				<table border="0" cellpadding="0" cellspacing="0" width="100%" class="tx">
    					<tr>
    						<td background="" align="left">    						
    						<img height="68" width="90" border="0" src="/yuntong/picture/shdj/dhdj.gif">													    						
    						</td>
    					</tr>
    				</table>
    				<table border="0" width="100%">
    					<tr>
    						<td rowspan="2" valign="top">
    							<!-- 管理部分(开始) -->
    								<form action="#" method="get" name="form2">
    							    <table id="shdj1001" onmousemove="myInfoXmlHttpDoRequest(this.id);" border="0" class="tx" cellpadding="0" cellspacing="0" width="100%">
    							    	<tr>
    							    		<td  bgcolor="a0c0c0"><b>发货厂商登记：</b></td>
    							    	</tr>
    							    	<tr>
    							    		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>已登记厂商：</b><br>
    							    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;厂商编号：<input class="tx" type="text" id="ffi"   name="findFactoryID" value="">
    							    			<script type="text/javascript">
   												
   												 new CAPXOUS.AutoComplete("findFactoryID", function() {
       												 return "/yuntong/SHGL/y_selectFinfo.do?typing=" + this.text.value;
   														 });

													</script>
    							    			
    							    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    							    			<input  class="tx" type="button" onclick="doRequest();" name="Find" value="查找信息"><br>&nbsp;
    							    		</td>
    							    	</tr>
    							    </table>
    							    </form>    							    
    							    <form action="/yuntong/SHGL/y_SHGLFactroy.do" method="post" name="form1" onsubmit="">
    							    <table id="shdj1002" onmousemove="myInfoXmlHttpDoRequest(this.id);" width="100%" border="0" class="tx"  cellpadding="0" cellspacing="0">
    							    	<tr>
    							    		<td colspan="2" bgcolor="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><span id="ts2" style="">未登记厂商：</span><span id="ts" style="display:none">查询结果：</span></b></td>    							    		
    							    	</tr>
    							    	<tr>
    							    		<td >
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;厂商编号：<input type="hidden" name="factoryID" value="9999"><input class="tx" type="text" name="MyfactoryID" disabled="disabled" value="系统生成"><br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公司名称：<input  class="tx" type="text" name="factoryName">&nbsp;<font color="red">*</font><br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系人：&nbsp;&nbsp;&nbsp;<input class="tx" type="text" name="factoryLinkman">&nbsp;<font color="red">*</font><br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所属地区：
 
												<select class="tx" name="factoryArea">
												<c:forEach items="${sessionScope.cityinfo}" var="list">												
													<option value="${list.areaID}">${list.areaCity}</option>													
												</c:forEach>
												</select><br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话：<input class="tx" type="text" name="factoryPhone" size="15">&nbsp;<font color="red">*</font><br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系传真：<input class="tx" type="text" name="factoryFax" size="15"><br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：<input class="tx" type="text" name="factoryPostID" size="15">&nbsp;<font color="red">*</font><br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电子邮件：<input class="tx" type="text" name="factoryEmail" size="25"><br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;详细地址：<input class="tx" type="text" name="factoryAddress" size="35">&nbsp;<font color="red">*</font><br>
											</td>
    							    		<td bgcolor="">
    							    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其他信息：<br>
    							    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea class="tx"  name="factoryInfo" rows="7" cols="28"></textarea>
    							    		</td>
    							    	</tr>
    							    	<tr bgcolor="">
    							    		<td colspan="2" align="center"><br><input name="" class="tx" type="button" onclick="MyReset();" value="重新填写" >
    							    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    							    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    							    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    							    		<input class="tx" name="submit" type="submit" value="下一步" ><br>&nbsp;
    							    		</td>    							    	
    							    	</tr>
    							    </table>
    							    </form>
    							<!-- 管理部分(结束) -->
    						</td>
    						<td valign="top" width="20%">
    							<!-- 操作步骤 -->
    							<table width="100%" border="0" cellpadding="0" cellspacing="0">
    							<tr>
    								<td background="/yuntong/picture/loginpage.gif" align="center"><br><font color="red">操作步骤</font></td>
    							</tr>
    							<tr>
    								<td background="/yuntong/picture/bg1.jpg">
    									&nbsp;&nbsp;&nbsp;--><font color="red">1.填写厂商信息</font>
    						<br><br>
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.录入收货人信息
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
    						</td><br>
    					</tr>
    					<tr>
    						<td>
    							<!-- 提示信息 -->
    							<table width="100%" border="0" cellpadding="0" cellspacing="0">
    							<tr>
    								<td background="/yuntong/picture/loginpage.gif" align="center"><br><font color="red">提示信息</font></td>
    							</tr>
    							<tr>
    								<td align="center" background="/yuntong/picture/bg1.jpg">
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

