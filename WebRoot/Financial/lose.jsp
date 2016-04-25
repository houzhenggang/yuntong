<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>损货赔付</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	var message;
		function show(message){
			alert(message,"原因",1);
		}
		
		
		function check(){
			var id=document.forms.form1.regId.value;
			if(id=='' || id==null){
				alert("请输入要查的编号");
				return false;
			}else{
				document.all.form1.action="/yuntong/Financial/x_lose.do?test=select";
			}
		}
		
		function checkNum(){
			var id=document.forms.form1.regId.value;
			if(isNaN(id)){
				alert("货票为数字，请正确填写！！");
				document.forms.form1.regId.value='';
			}
		}
		
	function show0(){
		document.all.c.color='';
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
    				<table border="0" cellpadding="0" cellspacing="0" width="100%" class="tx">
    					<tr>
    						<td>当前位置：>><a href="/yuntong/y_GoIndex.do">首页</a>>>损货赔付</td>
    					</tr>
    				</table>
    				<table border="0" cellpadding="0" cellspacing="0" width="100%" class="tx">
    					<tr>
    						<td background="" align="left">
						<img height="66" width="82" border="0" src="/yuntong/picture/shdj/jcxs33.gif">
							
						</td>
    					</tr>
    				</table>
    				<table border="0" cellpadding="0" cellspacing="0" width="100%" class="">
    					<tr>
    						<td rowspan="2">
    							
									
								<table border="0" width="95%">
								<logic:present scope="request" name="null">
    								<tr><td colspan="7" align="center"><h3 align="center"><font color="red">没有消息</font></h3></td></tr>
    								<tr><td colspan="7" align="right"><a href="/yuntong/Financial/x_Financial.do?test=lose">显示所有</a></td></tr>
    							</logic:present>
    								<tr>
    									<td>
    										<table onmousemove="show1();" width="90%" border="1" cellpadding="0" cellspacing="0" class="tx" align="center">
    										<logic:notPresent scope="request" name="null">
    											<caption><h3>显示区</h3></caption>
    											<tr>
    												<td class="tx" align="center">损失货单编号</td>
    												<td class="tx" align="center">货物名称</td>
    												<td class="tx" align="center">损货车次</td>
    												<!--<td class="tx" align="center">赔偿金额</td>
    												<td class="tx" align="center">应赔金额</td>
    												<td class="tx" align="center">付款人</td>-->
    												<td class="tx" align="center">损失金额</td>
    												<td class="tx" align="center">损失原因</td>
    											</tr>
    										
    											<logic:iterate id="list" name="listlose" offset="<%=(String)request.getAttribute("offset") %>" length="<%=(String)request.getAttribute("PageSixze") %>">
    											<tr>
    												<td align="center">${list.TRegisterInfo.registerGlideId}</td>
    												<td align="center">${list.TRegisterInfo.TGoodsInfo.goodsName}</td>
    												<td align="center">${list.TRoadway.roadwayId}</td>
    												<!-- <td align="center">${list.disrepareIndemnity}</td>-->
    												<td align="center">${list.disrepareMoney}</td>
    												<!-- <td align="center">${list.disrepareIndemnityMan}</td>-->
    												<td align="center">${list.disrepareCause}</td>
    											</tr>    											
    											</logic:iterate>
    											<tfoot>
    											<tr>
    										<logic:present scope="request" name="uqiun">
    											<td colspan="9" align="right"><a href="/yuntong/Financial/x_Financial.do?test=lose">显示所有</a></td>
    										</logic:present>
    										<logic:notPresent scope="request" name="Selectfenye">
    										
    													<td width="100%" align="center" colspan="7">
    														<a href="/yuntong/Financial/x_Financial.do?test=lose&currentPage=1">[首页]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
    														<a href="/yuntong/Financial/x_Financial.do?test=lose&currentPage=<%=Integer.parseInt((String)request.getAttribute("currentPage"))+1 +""%>">[下一页]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
    														<a href="/yuntong/Financial/x_Financial.do?test=lose&currentPage=<%=Integer.parseInt((String)request.getAttribute("currentPage"))-1+""%>">[上一页]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
    														<a href="/yuntong/Financial/x_Financial.do?test=lose&currentPage=<%=Integer.parseInt((String)request.getAttribute("totalpage"))%>">[尾页]</a>
    													</td>
    										
    										</logic:notPresent>
    									</tr>	
    								</tfoot>  
    								</logic:notPresent>  								
    								</table>
    										
    							
    							<br>
    							<hr width="100%" size="1" align="center"/>
    							<form action="#" method="post" id="form1" onsubmit="return check();">
    								<table onmousemove="show0();" border="0" class="tx" cellpadding="0" cellspacing="0" width="60%" align="center">
    									<caption><h3>查找</h3></caption>
    									<tr>
    										<td align="center"><br>货票编号：</td> 
    										<td><br><input class="tx" type="text" name="regId" onfocusout="checkNum();"/></td>	
    									</tr>
    									<tr>
    										<td colspan="2" align="right"> 
    											<input class="tx" type="submit" name="test" value="查找"/>&nbsp;&nbsp;&nbsp;
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
    								<td background="/yuntong/picture/loginpage.gif" align="center"><br><font color="red">功能</font></td>
    							</tr>
    							<tr>
    								<td background="/yuntong/picture/bg1.jpg">
    									<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red" id="c">1.显示所有损货单
    						<br><br>
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font id="c1">2.损货单的详细查询
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
    									<br><br>
    									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;货票编号来查询
    									<br>
    									
    									<br><br></span>
    									<span id="show" style="">
    						<br><br>
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;显示所有'损货'信息
    						<br><br><br></span>
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

