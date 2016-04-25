<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>省际运输</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="../css/lnroad.css" rel="stylesheet" type="text/css">
    <link href="../css/maple.css" rel="stylesheet" type="text/css">
  </head>
<body>
 <body background="/yuntong/picture/bk3.jpg" topmargin="0" marginheight="0" leftmargin="0" rightmargin="0" marginwidth="0">
  	<%@include file="/Y_Top.jsp" %>
  	<input type="hidden" id="id" name="id">
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
    						<td>当前位置:>><a href="/yuntong/y_GoIndex.do">首页</a>>>省际运输</td>
    					</tr>    					
    				</table>
    				<table border="0" cellpadding="0" cellspacing="0" class="tx" width="100%">
    					<tr>
    						<td background="" align="left">
    						<img height="66" width="84" border="0" src="/yuntong/picture/psgl/cx1.gif">
    						</td>
    					</tr>
    				</table>
    				<table>
    					<tr><td height="20"></td></tr>
    				</table>
			<!-- 内容  -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
			<td valign="top"><br><br>
			<hr width="100%" size="1"></hr>
			<br>
					<br>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="" colspan="2">
					<table width="100%" border="1" cellpadding="0" cellspacing="0" class="tx">
						<tr>
							<td colspan="2" align="center">
								已经成功生成车次,详细信息如下:
							</td>
							
						</tr>
						<tr>
						<td>
							车牌号码&nbsp;:&nbsp;&nbsp;&nbsp;${info.truckNum}
								
						</td>
						<td>
							司机姓名&nbsp;:&nbsp;&nbsp;&nbsp;${info.driverName}
						</td>
						</tr>
						<tr>
							<td >
								发车时间&nbsp;:&nbsp;&nbsp;&nbsp;${info.dateString}
							</td>
							<td >
								车次类型&nbsp;:&nbsp;&nbsp;&nbsp;省际运输
							</td>
						</tr>
						
					</table>
					
					</td>
				</tr>		
			</table>
			<br>
					<br>
			<hr width="100%" size="1"></hr>
			<table width="100%" >
			<tr>
							<td align="center"><a class="tx" href="/yuntong/y_GoIndex.do">返回首页</a></td>
							<td align="center"><a class="tx" href="/yuntong/PSGL/g_GoSJYS.do">继续填加</a></td>
						</tr>
						</table>
			</td>
			<td width="100">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><!-- 操作步骤 -->
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
    							<!-- 操作步骤 --></td>
				</tr>
				<tr>
					<td><!-- 提示信息 -->
    							<table width="100%" border="0" cellpadding="0" cellspacing="0">
    							<tr>
    								<td background="/yuntong/picture/loginpage.gif" align="center"><br><font color="red">提示信息</font></td>
    							</tr>
    							<tr>
    							<td align="center" background="/yuntong/picture/bg1.jpg">
    								<table border="0" width="80%" height="140">
    										<tr>
    											<td id="Y_tishi">
    												省际运输管理是对各个分公司之间的运输车次，车辆货物人员安排进行管理的模块。可以自动判断车辆和司机是否空闲。车辆是否满载等信息 
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
    							<!-- 提示信息 --></td>
				</tr>
				</table>
		</td>
	</tr>
</table>
</body>
</html:html>

