<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>J_ShaoShouKuan.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
var xmlHttp;
//创建XmlHttpRequest对象;
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
	var getfacoryid=document.getElementById("agioID").value;
	//验证输入
	if(getfacoryid==null||getfacoryid==""){
		alert("查询参数不能为空！");
		document.form2.agioID.focus();
		return;
	}
	if(isNaN(getfacoryid)==true)
		{
			alert("编号必须为数字");	
			document.form2.agioID.focus();		
			return;
		}
	createXmlHttpRequest();
	var queryString="/yuntong/PWGL/j_ShaoShouKuanAjax.do?id="+getfacoryid+"&";
     queryString=queryString+createQueryString();
	//状态改变时
	xmlHttp.onreadystatechange=stateChange;
	xmlHttp.open("get",queryString,true);
	xmlHttp.send(null);

}
function stateChange(){
	if(xmlHttp.readyState==4){
	
		if(xmlHttp.status==200){
			parseResults();
		}
	}
}

function parseResults(){	
	var xmldoc=xmlHttp.responseXML;//以xml格式得到用户的数据	
	var root=xmldoc.documentElement;//得到XML文件的根
	if(root==null){
	alert(" 未找到,对不起!");
	return;
	}
	var mynodes1=root.getElementsByTagName("agioid");
	var info1=mynodes1[0].text;//得到提示信息	
	document.form1.agioID.value=info1;
	var mynodes2=root.getElementsByTagName("agiotype");
	var info2=mynodes2[0].text;//得到提示信息	
	
	document.form1.agioTypeID.value=info2;
	
	var mynodes3=root.getElementsByTagName("agioRid");
	var info3=mynodes3[0].text;//得到提示信息	
	document.form1.agioGoodsID.value=info3;
    
	var mynodes4=root.getElementsByTagName("agiomoney");
	var info4=mynodes4[0].text;//得到提示信息
	document.form1.agioMoney.value=info4;
	
	var mynodes5=root.getElementsByTagName("agioinfo");
	var info5=mynodes5[0].text;//得到提示信息	
	document.form1.agioInfo.value=info5;
	}
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
    						<td>当前位置：>><a href="/yuntong/y_GoIndex.do">首页</a>>>票务冲减</td>
    					</tr>
    				</table>
    				<table border="0" cellpadding="0" cellspacing="0" class="tx" width="100%">
					<tr>
						<td background="">
						<img height="70" width="90" border="0" src="/yuntong/picture/shdj/cg1.bmp">							
						</td>
					</tr>
					</table>
    				<!-- 管理部分(开始) -->
    								<table width="100%" border="0" cellpadding="0" cellspacing="0">
    									<tr>
    										<td>
    											<form action="#" method="get" name="form2">
    							    <table border="0" cellpadding="0" cellspacing="0" class="tx" width="100%">
    							    	<tr>
    							    		<td align="center">登记少收款及赔款</td>
    							    	</tr>
    							    	<tr>
    							    		<td align="center"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    							    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请您输入货票编号：<input class="tx" type="text" id="agioID" name="AgioID">
    							    			
    							    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    							    			<input class="tx" type="button" onclick="doRequest();" name="Find" value="查找信息">
    							    		</td>
    							    	</tr>
    							    </table>
    							    </form>
    							    <form action="/yuntong/PWGL/j_ShaoShouKuan.do" method="post" name="form1">
    							    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tx">
    							    	
    							    	<tr>
    							    		<td>
    							    		    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;记录编号：<input class="tx" type="text" name="agioID"><br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类型：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="tx" type="text" name="agioTypeID"><br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;货票编号:&nbsp;&nbsp;<input class="tx" type="text" name="agioGoodsID"><font color="red">*</font><br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;少收金额:&nbsp;&nbsp;<input class="tx" type="text" name="agioMoney">&nbsp;<font color="red"></font><br>
										     
											</td>
    							    		<td>
    							    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;少收备注：<br>
    							    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea class="tx" name="agioInfo" rows="4" cols="33"></textarea>
    							    		</td>
    							    		
    							    	</tr>
    							    	<tr>
    						           <td colspan="2" align="center">	 <br>   		
    							    		<input class="tx" align="right" name="submit" type="submit" value="保存信息" ><br>&nbsp;
    							    		</td>    							    	
    							    	</tr>
    							    </table>
    							    
    							    </form>
    										</td>
    										<td width="100">
    										<!-- 操作步骤 -->
    							<table width="100%" border="0" cellpadding="0" cellspacing="0">
    							<tr>
    								<td background="/yuntong/picture/loginpage.gif" align="center"><br><font color="red">操作步骤</font></td>
    							</tr>
    							<tr>
    								<td background="/yuntong/picture/bg1.jpg"><font color="#804060">
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.车辆和司机选择
    						<br><br>
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.货物装填
    						<br><br>
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.生成车次<br>
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
    								<br>
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
    												少收款和赔款是送货后因壳沪户还价,或货物损坏少收的款项
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
    				<!-- 管理部分(结束) -->
    							    			    		    			
    			<!-- 中间内容(结束) -->
    		</td>
    	</tr>
    </table>    
  </body>
</html:html>

