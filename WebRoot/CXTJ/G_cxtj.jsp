<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>统计查询</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="../css/lnroad.css" rel="stylesheet" type="text/css">
    <link href="../css/maple.css" rel="stylesheet" type="text/css">
    
    <!-- 提交表单ajax开始 -->
    <script type="text/javascript" src="../js/jsgraphics.js"></script>
    <script type="text/javascript" language="javascript"> 
    	var xmlHttp;	
    	var month=new Array();
    	var jg=new jsGraphics();
    	var jg1=new jsGraphics();
    	var scanYear=0;
    	
	//创建联接
	function createXmlHttpRequest(){
	//根据不同浏览器创建
		if(window.ActiveXObject){
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}else if(window.XMLHttpRequest){
			xmlHttp=new XMLHttpRequest();
		}
	}
	function createQueryString(){
	    //防止缓存
		var queryString="timeStamp="+new Date().getTime();
		return queryString;
	}

   	function doRequest(){
  	 	var year=document.getElementById("year").value;
  	 	scanYear=year;
  	 	if(year==""){
  	 		alert("请输入要查询的年!");
  	 		return;
  	 	}
  	 	if(isNaN(year)){
  	 		alert("输入错误!只能输入数字!");
  	 		document.getElementById("year").value="";
  	 		return ;
  	 	}
		var queryString="/yuntong/CXTJ/g_CXTJ.do?year="+scanYear+"&";
		queryString=queryString+createQueryString();
		//状态改变时
		createXmlHttpRequest();
		xmlHttp.onreadystatechange=stateChange;
		xmlHttp.open("post",queryString,true);
		xmlHttp.send(null);
	}
	function stateChange(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				parseResults();
			}else{
				alert("没有相关信息!");
			}
		}
	}
	function setStyle(){
		document.getElementById("polyline").checked=false;
		document.getElementById("myCanvas").style.display="";
		document.getElementById("myCanvas1").style.display="none";
	}
	function setStyle1(){
		document.getElementById("rect").checked=false;
		document.getElementById("myCanvas1").style.display="";
		document.getElementById("myCanvas").style.display="none";
	}
	function initCanvas(){
		if(document.getElementById("rect").checked==true){
			document.getElementById("myCanvas1").style.display="none";
			document.getElementById("myCanvas").style.display="";
		}else{
			document.getElementById("myCanvas1").style.display="";
			document.getElementById("myCanvas").style.display="none";
		}
	}
	function parseResults(){	
		if(scanYear==0){return;}
		var xmldoc=xmlHttp.responseXML;//以xml格式得到用户的数据	
		var root=xmldoc.documentElement;//得到XML文件的根
		var cntLength=root.getElementsByTagName("cntLength")[0].text;
		for(var i=0;i<cntLength;i++){
			var monthCnt=root.getElementsByTagName("monthCnt"+i)[0].text;
			month[i]=monthCnt;
		}
		initCanvas();
		jg=new jsGraphics("myCanvas");
		myDrawFunction();
		jg1=new jsGraphics("myCanvas1");
		MydrawPolyline();
		document.getElementById("submit").disabled=true;
		document.getElementById("clear").disabled=false;
	}
	function again(){
		document.getElementById("submit").disabled=false;
		document.getElementById("clear").disabled=true;
		document.getElementById("year").value="";
		document.getElementById("myCanvas1").style.display="none";
		document.getElementById("myCanvas").style.display="none";
		clearCanvas();
	}
	
	function clearCanvas(){
		jg1.clear();
		jg.clear();
	}
</script>


     <!-- 提交表单ajax结束 -->

    
  </head>
<body>
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
    						<td>当前位置:>><a href="/yuntong/y_GoIndex.do">首页</a>>>查询统计>>货票查询</td>
    					</tr>
    					
    				</table>
    				<table border="0" cellpadding="0" cellspacing="0" class="tx"  width="100%">
    					<tr>
    						<td background="" align="left">
								<img height="60" width="70" border="0"
								src="/yuntong/picture/shdj/jl4.bmp">
    						</td>
    					</tr>
    				</table>
    				<table>
    					<tr><td height="10"></td></tr>
    				</table>
			<!-- 内容  -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
			<td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tx" align="top">
				<tr>
					<td bgcolor="a0c0c0">
						<table width="100%" border="0">
							<tr>
								<td><strong>请输入要查询的年(例如:2007)</strong></td>
								<td><input type="text" name="year" id="year" class="tx" onchange="clearCanvas();">&nbsp;&nbsp;&nbsp;
								<input type="button" id="submit" value="查  询" onclick="doRequest();" class="txt1"> 
								<input id="clear" type="button" value="重新查询" onclick="again();" class="txt1" disabled="disabled">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								 <input type="radio" name="rect" id="rect" value="1" checked="checked" onclick="setStyle()"/>柱状图
								 <input type="radio" name="polyline" id="polyline" value="2" onclick="setStyle1()" />曲线图
								</td>
							</tr>
							<tr>
						</table>
				      				     
				    </td>
				</tr>
				<tr>
				  <td>
				  <table width="100%" border="0"  height="380">
	<div id="myCanvas" style="WIDTH: 100%; POSITION: absolute; TOP: 208px; HEIGHT:30px;display:"></div>
	<div id="myCanvas1" style="WIDTH: 100%; POSITION: absolute; TOP: 208px; HEIGHT:30px;display:"></div> 	             
	<script language="javascript">
	function MydrawPolyline(){
		jg1.setFont("arial","18px",Font.BOLD);
		jg1.drawString(scanYear+"曲线数据图",280,80);
		jg1.setFont("arial","12px",Font.PLAIN);
		jg1.setColor("black");
		jg1.setStroke(3);//设置线厚度
		jg1.drawLine(50,360,630,360);//画x轴
		jg1.drawLine(50,100,50,360);//画Y轴
		//jg1.drawString("月份",640,370);
		jg1.drawString("数量(票/格)",20,80);
		var Xpoints = new Array(12); 
		var Ypoints = new Array(12); 
		for(var i=0;i<12;i++){	
			Xpoints[i]=70+(i*47);
			Ypoints[i]=360-month[i]/2;
			jg1.drawString(month[i]+"",Xpoints[i],Ypoints[i]-25);
		}
		for(var i=0;i<12;i++){  //画X轴出12个月
			jg1.setColor("black");
			jg1.drawString((i+1)+"月",70+(i*47),370);
		}
		for(var i=0;i<10;i++){ //画Y轴刻度
			jg1.setColor("black");
			jg1.drawString("50"*(i),20,350-(i*26));
			jg1.drawLine(49,360-(i*26),51,360-(i*26));
		}
		jg1.setColor("red");
		jg1.setFont("arial","12px",Font.PLAIN);
		jg1.drawPolyline(Xpoints,Ypoints);
		jg1.paint();
	}
	
	function myDrawFunction(){
		jg.setFont("arial","18px",Font.BOLD);
		jg.drawString(scanYear+"柱状数据图",280,80);
		jg.setFont("arial","12px",Font.PLAIN);
		jg.setColor("black");
		jg.setStroke(3);//设置线厚度
		jg.drawLine(50,360,630,360);//画x轴
		jg.drawLine(50,100,50,360);//画Y轴
		//jg.drawString("月份",640,370);
		jg.drawString("数量(票/格)",20,80);
		for(var i=0;i<12;i++){  //画出12个月
			jg.setColor("black");
			jg.drawString((i+1)+"月",70+(i*47),370);
		}
		for(var i=0;i<10;i++){
			jg.setColor("black");
			jg.drawString("50"*(i),20,350-(i*26));
			jg.drawLine(49,360-(i*26),51,360-(i*26));
		}
		for(var i=0;i<12;i++){	
			if(month[i]!=0){
				jg.setColor("red");
				jg.fillRect(60+(i*47),360-month[i]/2,30,month[i]/2);
			}
		}
		jg.paint();
	}
	</script>
	      </table>
	             
	             </td>
			  </tr>
				</table>
			</td>
			<td valign="top">
			<table width="100"  border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><!-- 操作步骤 -->
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
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.检查无误后选择确定<br>
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
					<td>
						<!-- 提示信息 -->
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td background="/yuntong/picture/loginpage.gif" align="center">
										<br>
										<font color="red">提示信息</font>
									</td>
								</tr>
								<tr>
									<td align="center" background="/yuntong/picture/bg1.jpg">
    									<table border="0" width="80%" height="140">
    										<tr>
    											<td id="Y_tishi">
    												当前页面统计了查询年度的各月结算货票的数量
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
		</td>
	</tr>
</table>
</body>
</html:html>

