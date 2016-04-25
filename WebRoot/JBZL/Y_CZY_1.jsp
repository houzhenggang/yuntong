<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />    
    <title>操作员管理</title>	
    <script src="/yuntong/js/rowcolor.js"></script>
    <%-------------------------------------------删除ajax------------------------------------%>
<script type="text/javascript">
var xmlHttp;
var userid;
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
function doRequest(id,name){
	userid=id;
	if(confirm("您确认删除用户"+name+"吗？")==false){
		return;
	}
	createXmlHttpRequest();
	var queryString="/yuntong/JBZL/y_FindU1.do?userId="+userid+"&";
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
	var tab=document.getElementById("tab");		
		for(i=0;i<tab.childNodes.length;i++){
			if(tab.childNodes[i].id==userid){
				tab.removeChild(tab.childNodes[i]);
			}
		}
}
<%-------------------------------------------修改------------------------------------%>
//填如选定项信息
function findinfo(id,name,f,d,role,userTrueName,userPhone,userCardId,userPwd,userLoginNum,userLoginDate,userDate){
	var form=document.mf2;
	//用户编号
	form.userId.value=id;
	//用户名
	form.userName.value=name;
	//分公司编号
	for(i=0;i<form.filiale.options.length;i++){
		if(form.filiale.options[i].value==f){
			form.filiale.options[i].selected="selected";
		}
	}

	//部门
	for(i=0;i<form.department.options.length;i++){
		if(form.department.options[i].value==d){
			form.department.options[i].selected="selected";
		}
	}
	//权限
	for(i=0;i<form.userRole.options.length;i++){
		if(form.userRole.options[i].value==role){
			form.userRole.options[i].selected="selected";
		}
	}
	//真实姓名
	form.userTrueName.value=userTrueName;
	//联系电话
	form.userPhone.value=userPhone;
	//身份证号码
	form.userCardId.value=userCardId;	
	//密码
	form.userPwd1.value=userPwd;
	form.userPwd2.value=userPwd;
	//登陆次数
	form.userLoginNum.value=userLoginNum;
	//上次登陆时间
	form.userLoginDate.value=userLoginDate;
	//注册时间
	form.userDate.value=userDate;
	//按钮
	form.submit.value="修改";
	//提示信息切换
	document.getElementById("div1").style.display="none";
	
	addinfo.style.display='none';
	updataInfo.style.display='';
}
//返回填加
function returnadd(){
	//信息还原
	var form=document.mf2;
	//用户编号
	form.userId.value=null;
	//用户名
	form.userName.value="";
	//分公司编号
	form.filiale.options[0].selected="selected";
	//部门
	form.department.options[0].selected="selected";
	//权限
	form.userRole.options[0].selected="selected";		
	//真实姓名
	form.userTrueName.value="";
	//联系电话
	form.userPhone.value="";
	//身份证号码
	form.userCardId.value="";	
	//密码
	form.userPwd1.value="";
	form.userPwd2.value="";
	//登陆次数
	form.userLoginNum.value="";
	//上次登陆时间
	form.userLoginDate.value="";
	//按钮
	form.submit.value="填加";
	//提示信息切换
	document.getElementById("div1").style.display="";
	addinfo.style.display='';
	updataInfo.style.display='none';
}
function showcalendar(obj){
  		dv=window.showModalDialog("calendar.htm","44","center:1;help:no;status:no;dialogHeight:246px;dialogWidth:216px;scroll:no")
  		if (dv) {if (dv=="null") obj.value='';else obj.value=dv;}
}
function checkDateInfo(){
	var d1=document.getElementById("Date1").value;
	var d2=document.getElementById("Date2").value;
	if(d1==""||d1==null||d2==""||d2==null){
		alert("日期不能为空!!!");
		return false;
	}
	return true;
}
</script>
<%-------------------------------------------删除ajax------------------------------------%>
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
    				<table  class="tx" border="1" cellpadding="0" cellspacing="0" width="100%">
    					<tr>
    						<td>当前位置：>><a href="/yuntong/y_GoIndex.do">首页</a>>>基本资料>>操作员</td>
    					</tr>
    				</table>
    				
    							<table bgcolor="" border="0" cellpadding="0" cellspacing="0" width="100%" class="tx">
 									<tr>
 										<td  bgcolor="a0c0c0">
 										<form action="/yuntong/JBZL/y_UserSplit.do" onsubmit="return checkDateInfo();" method="post">&nbsp;										
 											所属公司：<select class="tx" name="filiale">
 												<option value="0" selected="selected">------------</option>
 												<c:forEach items="${sessionScope.Y_Filiale}" var="list">
 												<option value="${list.filialeID}">${list.filialeName}</option>
 												</c:forEach>
 												</select>
 											&nbsp;&nbsp;										
 											所属部门：<select class="tx" name="department">
 											<option  value="0" selected="selected" >------</option>
 												<option value="1">收货部</option>
 												<option  value="2" >市场部</option>
 												<option  value="3" >财务部</option>
 												<option  value="4" >票物部</option>
 												<option  value="5" >配送部</option>
 												<option  value="6" >经理办</option>
 												<option  value="7" >其他</option> 											 											
 												
 											</select>
 											日期范围（前）
 											<input  class=tx id="Date1" name="Date1" type="text" size="20" style="CURSOR: hand" onclick=showcalendar(this,this) readOnly>
 											<!--  
 											<object class="tx" name="Date1" classid="clsid:20DD1B9E-87C4-11D1-8BE3-0000F8754DA1" id="dtpicker" height="20" width="130">
											<param name="_ExtentX" value="2000">
											<param name="_ExtentY" value="400">
											<param name="_Version" value="393216">
											<param name="MousePointer" value="0">
											<param name="Enabled" value="1">
											<param name="OLEDropMode" value="0">
											<param name="CalendarBackColor" value="-2147483643">
											<param name="CalendarForeColor" value="-2147483630">
											<param name="CalendarTitleBackColor" value="-2147483633">
											<param name="CalendarTitleForeColor" value="-2147483630">
											<param name="CalendarTrailingForeColor" value="-2147483631">
											<param name="CheckBox" value="0">
											<param name="CustomFormat" value>
											<param name="DateIsNull" value="0">
											<param name="Format" value="662831105">
											<param name="UpDown" value="0">
											<param name="CurrentDate" value="--------------">
											<param name="MaxDate" value="2958465">
											<param name="MinDate" value="-109205">
								 			</object>
								 			-->
								 			&nbsp;
 											日期范围（后）
 											<input  class=tx name="Date2" type="text" id="Date2" size="20" style="CURSOR: hand" onclick=showcalendar(this,this) readOnly>
 											<!--  
 											<object class="tx" name="Date2" classid="clsid:20DD1B9E-87C4-11D1-8BE3-0000F8754DA1" id="dtpicker" height="20" width="130">
											<param name="_ExtentX" value="2000">
											<param name="_ExtentY" value="400">
											<param name="_Version" value="393216">
											<param name="MousePointer" value="0">
											<param name="Enabled" value="1">
											<param name="OLEDropMode" value="0">
											<param name="CalendarBackColor" value="-2147483643">
											<param name="CalendarForeColor" value="-2147483630">
											<param name="CalendarTitleBackColor" value="-2147483633">
											<param name="CalendarTitleForeColor" value="-2147483630">
											<param name="CalendarTrailingForeColor" value="-2147483631">
											<param name="CheckBox" value="0">
											<param name="CustomFormat" value>
											<param name="DateIsNull" value="0">
											<param name="Format" value="662831105">
											<param name="UpDown" value="0">
											<param name="CurrentDate" value="--------------">
											<param name="MaxDate" value="2958465">
											<param name="MinDate" value="-109205">
								 			</object>-->&nbsp;
								 			<input type="submit" class="tx" name="" value="查询">
								 			</form>
 										</td>
 									</tr>
 								</table> 		
    				
 								<table  border="1" cellspacing="0" cellpadding="0" width="100%" class="tx">
 									<tbody  id="tab">
 									<tr bgcolor="#CCCCCC">
 										
 										<td align="center"><b>用户名</b></td>
 										<td align="center"><b>真实姓名</b></td>
 										<td align="center"><b>所属公司</b></td>
 										<td align="center"><b>所属部门</b></td>
 										<td align="center"><b>联系电话</b></td>
 										<td align="center"><b>身份证号码</b></td>
 										<td align="center"><b>角色名称</b></td>
 										<td align="center"><b>登陆次数</b></td>
 										<td align="center"><b>注册时间</b></td>
 										<td align="center"><b>修改</b></td>
 										<td align="center"><b>删除</b></td>
 									</tr>
 									<c:forEach items="${Y_userinfopage1}" var="list">
 									<tr  id="${list.userId}" onmouseover="changecolor(this);" onmouseout="changeback(this);">
 										
 										<td><font color="#804060">${list.userName}</font></td>
 										<td>${list.userTrueName}</td>
 										<td><font color="#804060">${list.userFilialeName}</font></td>
 										<td>${list.userDepartmentName}</td>
 										<td><font color="#804060">${list.userPhone}</font></td>
 										<td>${list.userCardID}</td>
 										<td><font color="#804060">${list.userRoleName}</font></td>
 										<td>${list.userLoginNum}</td>
 										<td><font color="#804060">${list.strUserDate}</font></td>
 										<td><font color="#804060">
 										<a onclick="findinfo('${list.userId}','${list.userName}','${list.userFilialeId}','${list.userDepartmentId}','${list.userRoleId}','${list.userTrueName}','${list.userPhone}','${list.userCardID}','${list.userPwd}','${list.userLoginNum}','${list.userLoginDate}','${list.userDate}');"  style="cursor:hand">[修改]</a>
 										</td>
 										<td><font color="#804060"><a name="${list.userName}" id="${list.userId}" onclick="doRequest(this.id,this.name)"  style="cursor:hand">[删除]</a></font></td>
 									</tr>
 									</c:forEach>
 									</tbody>
 								</table>
 								<form action="/yuntong/JBZL/y_UserSplit.do" method="post">
 								<table border="0" cellpadding="0" cellspacing="0" width="100%" class="tx"> 							
    							<tr bgcolor="#CCCCCC">
    							<td align="center"><a class="tx" href="/yuntong/JBZL/y_GoYHQX.do">权限管理</a></td>    							
    						<td align="center"><a href="/yuntong/JBZL/y_UserSplit.do?pageNum=A">[首页]</a></td>
    						<td align="center"><a href="/yuntong/JBZL/y_UserSplit.do?pageNum=B">[上一页]</a></td>
    						<td align="center"><a href="/yuntong/JBZL/y_UserSplit.do?pageNum=C">[下一页]</a></td>
    						<td align="center"><a href="/yuntong/JBZL/y_UserSplit.do?pageNum=D">[末页]</a></td>
    						<td align="center">${Y_usercurPate}/${Y_userpageSize}</td>
    						<td  align="center" width="20%">    						
    						<input class="tx" type="text" name="page" size="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    						<input type="submit" class="tx" value="转到">
    						    						    						    				
    						</td>
    						<td><a href="/yuntong/JBZL/y_GoCZY.do" class="tx">显示全部</a></td>
    					</tr>
    					</table>  	
    					</form>
 								<table border="0" cellpadding="0" cellspacing="0" width="100%" height="140" class="tx">
    							<tr>
    								<td width="14%">
    									<img src="/yuntong/picture/jbzl/user.gif">
    								</td>
    								<td valign="top">
    								<span>
    									<form name="mf2" action="/yuntong/JBZL/y_addUserInfo.do" method="post">
    									
    										<span id="addinfo"><font color="#804060" size="2"><b>添加新用户：</b></font></span>
    										<span id="updataInfo" style="display:none"><font size="2" color="#804060"><b>修改用户信息：</b></font>
    										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    										
    										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    										<input type="button" class="tx" onclick="returnadd();" value="返回填加" ></span>
    										<br><input type="hidden" name="userId" value="">
    										<input type="hidden" name="userLoginNum" value="">
    										<input type="hidden" name="userLoginDate" value="">
    										<input type="hidden" name="userDate" value="">
    										用户名：<input class="tx" type="text" name="userName"><font color="red">*</font>&nbsp;&nbsp;
    										&nbsp;&nbsp;&nbsp;&nbsp;
    										所属公司：<select class="tx" name="filiale">
 												<c:forEach items="${sessionScope.Y_Filiale}" var="list">
 												<option  value="${list.filialeID}">${list.filialeName}</option>
 												</c:forEach>
 												</select>
 											&nbsp;&nbsp;										
 											所属部门：<select class="tx" name="department">
 											
 												<option value="1" selected="selected">收货部</option>
 												<option  value="2" >市场部</option>
 												<option  value="3" >财务部</option>
 												<option  value="4" >票物部</option>
 												<option  value="5" >配送部</option>
 												<option  value="6" >经理办</option>
 												<option  value="7" >其他</option> 											 											 												
 											</select>
 											用户权限：
 											<select class="tx" name="userRole">
 											    <c:forEach items="${Y_userRoleInfo}" var="list">
 												<option value="${list.roleID}" class="">${list.roleName}</option> 
 												</c:forEach>																			 											 												
 											</select>
 											<br>
 											真实姓名：<input class="tx" type="text" name="userTrueName"><font color="red">*</font>
 											&nbsp;&nbsp;&nbsp;&nbsp;联系电话：<input class="tx" type="text" name="userPhone">
 											&nbsp;&nbsp;&nbsp;&nbsp;身份证号码：<input class="tx" type="text" name="userCardId" size="30"><br>
 											<span id="div1">登陆密码：<input id="div1" class="tx" type="text" name="userPwd1"><font color="red">*</font>&nbsp;&nbsp;&nbsp;&nbsp;
 											密码确认：<input id="div2" class="tx" type="text" name="userPwd2"><font color="red">*</font><br><br></span>
 											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 											
 											&nbsp;&nbsp;&nbsp;&nbsp;
 											<c:if test="${sessionScope.Y_tishi!=null}">
    											<font color="#804060" size="4">${sessionScope.Y_tishi}</font>
    										</c:if>
    										<c:if test="${sessionScope.Y_tishi==null}">
    										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    										</c:if>
    										<c:remove var="Y_tishi" scope="session"/>
 											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 											&nbsp;&nbsp;&nbsp;&nbsp;<input class="tx" type="submit" name="submit" value="填加">
 											
 											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 											
 											&nbsp;&nbsp;&nbsp;&nbsp;<input class="tx"  type="reset" onclick="" name="reset" value="取消">
    									</form>
									</span>    												
    								</td>    						    						
    							</tr>
    							</table>    			    			    			    			
    			<!-- 中间内容(结束) -->
    		</td>
    	</tr>
    </table>    
  </body>
</html:html>

