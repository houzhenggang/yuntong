<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 用户登陆 -->


<HTML><HEAD><TITLE>用户登陆</TITLE>

<META http-equiv=Content-Type content="text/html; charset=gb2312">
<link rel="stylesheet" type="text/css" href="/yuntong/css/maple.css" />
<META content="MSHTML 6.00.2800.1106" name=GENERATOR>
<%-------------------------------------------处理验证码ajax------------------------------------%>
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
	
	createXmlHttpRequest();
	var queryString="/yuntong/y_CheckNum.do?";
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
	var divid=document.getElementById("checkname");
	//如果有子接点
	if(divid.hasChildNodes()){
		divid.removeChild(divid.childNodes[0]);
	}
	//创建新接点
	var responseText=document.createTextNode(xmlHttp.responseText);
	divid.appendChild(responseText);
        //divid.innerHTML=xmlHttp.responseText;
}
</script>
<%-------------------------------------------ajax------------------------------------%>
</HEAD>
<BODY onload="doRequest();" bgColor=#ffffff leftMargin=0 background=/yuntong/picture/bj1.gif 
topMargin=0>
<DIV id=Layer1 
style="Z-INDEX: 1; LEFT: 0px; WIDTH: 100%; POSITION: absolute; TOP: 0px; HEIGHT: 100%">
<FORM name=loginForm action="/yuntong/y_Login.do" method=post align="left">
<DIV align=center>
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width=623 align=center border=0>
        <TBODY>
        <TR>
          <TD align="center" colSpan=3 width="623" height="260" background="/yuntong/picture/welcome_01.gif">
          <!-- 验证码返回提示 -->
          <br><br><br><br><br>
          <font color="#ff60a0" size="5">${ckerror}</font>
          </TD></TR>
        <TR>
          <TD rowSpan=4><IMG height=92 src="/yuntong/picture/welcome_02.gif" 
            width=46></TD>
          <TD vAlign=left background="" height=13>
            <DIV align=left><FONT color=#006633 size=2>用户名：</FONT><FONT 
            color=#006633 size=2> <INPUT value="" class=tx maxLength=15 size=15 
            name=userName> </FONT><FONT color=#006633 size=2>　</FONT></DIV></TD>
          <TD rowSpan=4><IMG height=92 src="/yuntong/picture/welcome_04.gif" 
            width=402></TD></TR>
        <TR>
          <TD vAlign=left background="" height=9>
            <DIV align=left><FONT color=#006633 size=2>密&nbsp;&nbsp;&nbsp;码： <INPUT value="" class=tx 
            type=password maxLength=15 size=15 name=userPwd> 　 
           </FONT>		</DIV>		</TD>
		</TR>

		

        <TR>
          <TD vAlign=left background="" height=21>
		  

			<FONT color=#006633 size=2>验证码： <INPUT class=tx 
            type=test maxLength=15 size=4 name=checkNum> 
			 　           </FONT><a href="#" onclick="doRequest();" style="text-decoration:none"><FONT color="#ff4080" size=2><span id="checkname"></span></FONT></a>
		


		  
            <DIV align=center><FONT color=#006633 size=2>　　
              <input class=txt1 style="BACKGROUND-COLOR:#ffffff"  type=submit value=确定 name=ChkCngPwd2>　 
                
<INPUT class=txt1 style="BACKGROUND-COLOR: #ffffff"  type=reset value=取消 name=ChkCngPwd> 
            </FONT></DIV>			</TD>
			</TR>
        <TR>
          <TD align="center" height=2 width="175" background="/yuntong/picture/welcome_05.gif"></TD></TR></TBODY></TABLE>
			
		  </TD></TR></TBODY></TABLE><FONT 
color=red></FONT></DIV></FORM>
<c:remove var="ckerror" scope="session"/>
</BODY></HTML>

