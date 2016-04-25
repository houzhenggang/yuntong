<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>少收款</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="/yuntong/js/rowcolor.js"></script>
	<script type="text/javascript">
		function show(message){
			alert(message);
		}
		function check2(){
			var info=document.forms.form2.RegisterInfo.value;
			var name=document.forms.form2.ATypeName.value;
			var mon=document.forms.form2.AgioMoney.value;
			var info=document.forms.form2.AgioInfo.value;
			if(info=="" || info==null){
				alert("货票编号不能为空!!");
				return;
			}
			
			if(name=="" || name==null){
				alert("类型不能为空!!");
				return;
			}
			
			if(mon=="" || mon==null){
				alert("少收金额!!");
				return;
			}else if(isNaN(mon.substring(0,mon.indexOf("."))) && isNaN(mon.substring(mon.indexOf(".")))) {
				alert("真确输入钱数");
				return;
			}
			
			if((info!="" || info!=null)){
				if(isNaN(info)){
					document.forms.form1.RegisterInfo.value='';
					document.forms.form1.RegisterInfo.focus();
					alert("数字格式");
					
					return;
				}
			}
		}
		
		function checkMon(){
		var mon=document.forms.form2.AgioMoney.value;
			if(isNaN(mon.substring(0,mon.indexOf("."))) && isNaN(mon.substring(mon.indexOf(".")))) {
				alert("真确输入钱数");
				
			}
		}
		
		function check(){
			var info=document.forms.form1.RegisterInfo.value;
			var name=document.forms.form1.ATypeName.value;
			
			if((info=="" || info==null) && (name=="" || name==null)){
				alert("请输入要查询的信息");
				return false;
			}
		
			
			
				if(isNaN(info)){
					document.forms.form1.RegisterInfo.value='';
					document.forms.form1.RegisterInfo.focus();
					alert("数字格式");
					
					return;
				}
			
			
		}
		
		function checkNum(){
			var info=document.forms.form1.RegisterInfo.value;
			if(isNaN(info)){
				document.forms.form1.RegisterInfo.value='';
				alert("数字格式");
				
			}
		}
		function show(){
		document.all.c.color='black';
		document.all.c1.color='red';
		document.all.show.style.display='none';
		document.all.select.style.display='';
	}
	function show1(){
		document.all.c.color='red';
		document.all.c1.color='black';
		document.all.show.style.display='';
		document.all.select.style.display='none';
	}
		function addcheck(){
		
		}
	</script>
  </head>
  <link rel="stylesheet" type="text/css" href="/yuntong/css/maple.css" />
   <body background="/yuntong/picture/bk3.jpg" topmargin="0" marginheight="0" leftmargin="0" rightmargin="0" marginwidth="0">
  	<%@include file="/Y_Top.jsp" %>
	 <table width="984" BORDER=0 CELLSPACING=0 CELLPADDING=0 >    	
    	<tr>
    		<td width="12%" valign="top" >
    		<!-- 左菜单 -->
    		<%@include file="/Y_Left.jsp" %>
    		</td>
    		<td valign="top" align="left" width="88%">
    			<!-- 中间内容（开始） -->
    				<table border="0" cellpadding="0"  cellspacing="0" width="100%" class="tx">
    					<tr>
    						<td>当前位置：>><a href="/yuntong/y_GoIndex.do">首页</a>>>少收款</td>
    					</tr>
    				</table>
    				<table border="0" cellpadding="0" cellspacing="0" width="100%" class="tx">
    					<tr>
    						<td background="" align="left">
						<img height="66" width="82" border="0" src="/yuntong/picture/shdj/jcxs33.gif">
							
						</td>
    					</tr>
    				</table>
    				<table border="0" width="100%"  class="">
    					<tr>
    						<td rowspan="2">
    						<hr width="100%" size="1">
    							<table border="0" width="95%">
    								<logic:present scope="request" name="null">
    									<tr><td colspan="7" align="center"><h3 align="center"><font color="red">没有消息</font></h3></td></tr>
    									<tr><td colspan="7" align="right"><a href="/yuntong/Financial/x_Financial.do?test=few">显示所有</a></td></tr>
    								</logic:present>
    								<tr>
    									<td>
    								<form id="form1" action="/yuntong/Financial/x_few.do" method="post" onsubmit="return check();">		
    								<logic:notPresent scope="request" name="null">
    								<table onmousemove="show1();" width="90%" border="1" cellpadding="0" cellspacing="0" class="tx"  align="center">
    											<caption><h3>显示区</h3></caption>
    											<tr>
    												<td align="center">货单编号</td>
    												<td align="center">少收类型</td>
    												<td align="center">少收金额</td>
    												<td align="center">客户</td>
    											
    											</tr>
    										
    											<logic:iterate id="list" name="listfew" offset="<%=(String)request.getAttribute("offset") %>" length="<%=(String)request.getAttribute("PageSixze") %>">
    											<tr onmouseover="changecolor(this);" onmouseout="changeback(this);">
		    												<td align="center"><font color="#804060">${list.TRegisterInfo.registerGlideId}</font></td>
		    												<td align="center">${list.TAgioType.atypeName}</td>
		    												<td align="center"><font color="#804060">${list.agioMoney}</font></td>
		    												<td align="center">${list.TRegisterInfo.TClientInfo.clientName}</td>
		    												
    											</tr>    											
    											</logic:iterate>
    											<tfoot>
    									<tr>
    									<logic:present scope="request" name="uqiun">
    										<td colspan="7" align="right"><a href="/yuntong/Financial/x_Financial.do?test=few">显示所有</a></td>
    									</logic:present>
    									</tr>	
    									</tfoot>
    								</table>
    								<table align="center" width="90%" >
    								<tr>
    									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    								</tr>
    								
    									<td align="center" width="100%" colspan="7" class="tx">
    											<a href="/yuntong/Financial/x_Financial.do?test=few&currentPage=1">[首页]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
    											<a href="/yuntong/Financial/x_Financial.do?test=few&currentPage=<%=Integer.parseInt((String)request.getAttribute("currentPage"))+1 +""%>">[下一页]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
    											<a href="/yuntong/Financial/x_Financial.do?test=few&currentPage=<%=Integer.parseInt((String)request.getAttribute("currentPage"))-1+""%>">[上一页]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
    											<a href="/yuntong/Financial/x_Financial.do?test=few&currentPage=<%=Integer.parseInt((String)request.getAttribute("totalpage"))%>">[尾页]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
    									</td>
    								
    								
    									

    								</table>
    								</logic:notPresent>
    									
    									<hr width="100%" size="1">
    									
    										<table width="50%" align="center" bgcolor="a0c0c0" onmousemove="show();">
    											<caption><h3>查找</h3></caption>
    											<tr>
    												<td>货票编号</td>
    												<td><input class="tx" type="text" name="RegisterInfo" onfocusout="checkNum();"/></td>
    											</tr>
    											<tr>
    												<td>少收类型</td>
    												<td>
    													<select name="ATypeName" class="tx">
		    													<option value="">
			
																</option>
																<c:forEach items="${typeid}" var="id">
																	<option value="${id.atypeName}">
																		${id.atypeName}
																	</option>
																	
																</c:forEach>
																
														</select>
    												</td>
    											</tr>
    											<tr>
    												<td colspan="2" align="right">
    													<input class="tx" type="submit" value="查找" name="manage"/>
    												</td>
    											</tr>
    										</table>
    										</form>
    					</td>
    				</tr>
    			</table>
    									
    						
    						</td>
    						<td valign="top" width="100">
    						<!-- 操作步骤 -->
    							<table width="100%" border="0" cellpadding="0" cellspacing="0">
    							<tr>
    								<td background="/yuntong/picture/loginpage.gif" align="center"><br><font color="red">操作步骤</font></td>
    							</tr>
    							<tr>
    								<td background="/yuntong/picture/bg1.jpg">
    									<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red" id="c">1.显示所有损货单
    						<br><br>
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="" id="c1">2.损货单的详细查询
    						<br><br>
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
    						<td valign="top"><!-- 提示信息 -->
    							<table width="100%" border="0" cellpadding="0" cellspacing="0">
    							<tr>
    								<td background="/yuntong/picture/loginpage.gif" align="center"><br><font color="red">提示信息</font></td>
    							</tr>
    							<tr>
    								<td background="/yuntong/picture/bg1.jpg">
    									<span id="select" style="display: none;">
    									<br>
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;可根据货票编号或
    									<br>
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;少收类型来查询
    									<br><br><br></span>
    									<span id="show" style="">
    						<br><br><br>
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;显示所有'少收'货票
    						<br><br><br><br></span>
    								</td>
    							</tr>
    							<tr>
    							<td>
    								<img src="/yuntong/picture/bottom.jpg">
    							</td>
    							</tr>
    							</table>
    							<!-- 提示信息 --></td>
    					</tr>
    				</table>    			    			    		    			
    			<!-- 中间内容(结束) -->
    		</td>
    	</tr>
    </table>    
  </body>
</html:html>

