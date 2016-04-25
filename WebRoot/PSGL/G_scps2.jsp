<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>市场配送</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="../css/lnroad.css" rel="stylesheet" type="text/css">
    <link href="../css/maple.css" rel="stylesheet" type="text/css">
    <link href="../css/autocomplete.css" rel="stylesheet" type="text/css">
    <link href="../css/autocomplete_custom.css" rel="stylesheet" type="text/css">
	 <script type="text/javascript" src="../js/utils.js"></script>
	  <script type="text/javascript" src="../js/autoComplete.js"></script>
    
    <!-- 提交表单ajax开始 -->
    <script type="text/javascript" language="javascript"> 
    	var xmlHttp;
    	var ids="null";
    	var heft=0;
    	var bulk=0;
    	var index=0;
    	var autoComplete = null;//创建autoComplete对象
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
   		var hheft=document.getElementById("hheft").value;//重量
   		var hbulk=document.getElementById("hbulk").value;
   	 	var registerGlideID=document.getElementById("registerGlideID").value;
   	 	if(registerGlideID==""){
		  	 alert("货票编号不能为空!");
		  	 return;
	  	}
   		if(ids!=""){
	  	 	var id=ids.split("/");
	  	 	for(var i=1;i<id.length;i++){
	  	 		if(registerGlideID==id[i]){
			 	 		alert("货票编号"+id[i]+"已经添加！");
			 	 		document.getElementById("registerGlideID").value="";
			  	 		return;
			 	 	}
	  	 	}
	  	 }
	  	 if(heft>=hheft || bulk>=hbulk){
   			alert("重量或者方量超出车辆载重!");
   			document.getElementById("registerGlideID").value="";
   			return;
   		}
  	 	ids=ids+"/"+registerGlideID;
		var queryString="/yuntong/PSGL/g_FindRegisterInfo.do?registerGlideID="+registerGlideID+"&";
		queryString=queryString+createQueryString();
		//状态改变时
		createXmlHttpRequest();
		xmlHttp.onreadystatechange=stateChange;
		xmlHttp.open("get",queryString,true);
		xmlHttp.send(null);
	
	}
	function stateChange(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				parseResults();
				document.getElementById("registerGlideID").value="";
			}else{
				alert("没有找到信息!");
				document.getElementById("registerGlideID").value="";
			}
		}
	}
	function parseResults(){	
		var xmldoc=xmlHttp.responseXML;//以xml格式得到用户的数据	
		var root=xmldoc.documentElement;//得到XML文件的根
		var registerState=root.getElementsByTagName("registerState")[0].text;
		if(registerState!=2){
			alert("市场配送货票内没有找到编号为"+document.getElementById("registerGlideID").value+"的货票\n请重新查证后输入!");
			document.getElementById("registerGlideID").value="";
			return;
		}
		var registerGlideID=root.getElementsByTagName("registerGlideID")[0].text;
		var goodsName=root.getElementsByTagName("goodsName")[0].text;
		var goodsNumberUnit=root.getElementsByTagName("goodsNumberUnit")[0].text;
		var goodsNumber=root.getElementsByTagName("goodsNumber")[0].text;
		var goodsHeft=root.getElementsByTagName("goodsHeft")[0].text;
		heft=parseFloat(heft)+parseFloat(goodsHeft);
		var goodsBulk=root.getElementsByTagName("goodsBulk")[0].text;
		bulk=parseFloat(bulk)+parseFloat(goodsBulk);
		var tr=tb.insertRow();
		tr.align="center";
		var td1=tr.insertCell();
		var td2=tr.insertCell();
		var td3=tr.insertCell();
		var td4=tr.insertCell();
		var td5=tr.insertCell();
		var td6=tr.insertCell();
		var td7=tr.insertCell();
		td1.width="15%";
		td2.width="15%";
		td3.width="15%";
		td4.width="15%";
		td5.width="15%";
		td6.width="15%";
		td7.width="15%";
		td1.innerHTML=registerGlideID;
		td2.innerHTML=goodsName;
		td3.innerHTML=goodsNumberUnit;
		td4.innerHTML=goodsNumber;
		td5.innerHTML=goodsHeft;
		td6.innerHTML=goodsBulk;
		var id=registerGlideID+"/"+goodsHeft+"/"+goodsBulk;
		td7.innerHTML="<a id="+id+" href=\"#\" onclick=\"deleteTableRow(this);\">删除</a>";
		index=index=1;
		var hefts=document.createTextNode(heft);
		var bulks=document.createTextNode(bulk);
		var h=document.getElementById("heft");
		var b=document.getElementById("bulk");
		if(h.firstChild==h.lastChild){
			h.appendChild(hefts);
			b.appendChild(bulks);
		}else{
			h.removeChild(h.lastChild);
			b.removeChild(b.lastChild);
			h.appendChild(hefts);
			b.appendChild(bulks);
		}
		document.getElementById("hRGID").value=ids;
		document.getElementById("infos").style.display="";
	}
	
	function deleteTableRow(obj){
		var infos=obj.id.split("/");
		var ID=infos[0];
		var tr=obj.parentElement.parentElement;
		tb.removeChild(tr);
		ids=ids.replace(ID,"null");
		var goodsHeft=infos[1];
		var goodsBulk=infos[2];
		heft=parseFloat(heft)-parseFloat(goodsHeft);
		bulk=parseFloat(bulk)-parseFloat(goodsBulk);
		var hefts=document.createTextNode(heft);
		var bulks=document.createTextNode(bulk);
		var h=document.getElementById("heft");
		var b=document.getElementById("bulk");
		if(h.firstChild==h.lastChild){
			h.appendChild(hefts);
			b.appendChild(bulks);
		}else{
			h.removeChild(h.lastChild);
			b.removeChild(b.lastChild);
			h.appendChild(hefts);
			b.appendChild(bulks);
		}
		document.getElementById("hRGID").value=ids;
		if(heft==0 && bulk==0){
			document.getElementById("infos").style.display="none";
		}
	}
	
	//autoComplete start
	onload = function pageLoadHdle() {
        var completeConfiguration = {
          instanceName: "autoComplete",
          textbox: document.getElementById("registerGlideID"),
          height: 165
        };
	/* Create a new instance of autoComplete */
        /* 创建自动完成的实例 */
        autoComplete = new neverModules.modules.autocomplete(completeConfiguration);
        autoComplete.useContent = false;
        /* 以下为可选项，这里的示例都是默认值 { */  
        /* 当useContent为false时，此功能生效，确定是否忽略速度，
        如果不忽略速度，则效率提高30%左右，（没测试过，估计的）
        ，也就是没有高亮功能，适合纯DHTML的匹配 */
        autoComplete.ignoreSpeed = false;
        /* 开启方向键（小键盘） */
        autoComplete.useArrow = true;
        /* 当数据量较大时，自动截取前部分的数据，提高效率 */
        autoComplete.autoSlice = false;
        /* 无论输入字符串在dataSource的何处，始终匹配 */
        autoComplete.ignoreWhere = true;
        /* 一个空格代表一个或多个字符（串） */
        autoComplete.useSpaceMatch = false;
        /* 忽略大小写 */
        autoComplete.ignoreCase = true;
        /* 以上为可选项，这里的示例都是默认值 } */ 
        /* Create autoComplete */
        /* 创建自动完成 */
        autoComplete.create();
      }
      function AjaxHdle (evt) {
      	var registerGlideID=document.getElementById("registerGlideID").value;
      	if(isNaN(registerGlideID)){alert("请输入数字!");return;}
      	if(registerGlideID==""){return;}
        /* 如果输入的键是有效的，即非方向键等无效键，或是在缓存中有该值，则显示自动完成 */
        if (autoComplete.isValidKey(evt)==false || autoComplete.isRequireAjax()==false) {
      	 	 showAutocomplete(evt);
         	 return;
        }
        /* 显示loading图像 */
        autoComplete.showAnimateImage("../images/indicator.gif");
        /* 异步获取数据 */
        var queryString="/yuntong/PSGL/g_RegisterAutoComplete.do?id="+registerGlideID+"&type=2&";
		queryString=queryString+createQueryString();
      	createXmlHttpRequest();
        xmlHttp.onreadystatechange = function(){AjaxHdleState(evt)};
        xmlHttp.open("GET",queryString, true);
        xmlHttp.send(null);
      }
      function AjaxHdleState(evt){
      	if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				loadCompleteData(evt);
			}
		}
      }
      function loadCompleteData (evt) {
        var xmldoc=xmlHttp.responseXML;
		var root=xmldoc.documentElement;
	    var listSize=root.getElementsByTagName("listSize")[0].text;	
	    var dataSource = [];
	    if(listSize==0){
	    	dataSource="";
	    }else{
	    	for(var i=0;i<listSize;i++){
	   	  	 	 dataSource[i] =window.eval(root.getElementsByTagName("registerGlideID")[i].text);
	   		 }
	    }
	    autoComplete.setDataSource(dataSource);
	    showAutocomplete(evt);	
	    if(listSize!=0){
	    	autoComplete.expandAllItem();
	    } 
      }
      /* 显示autoComplete */
      function showAutocomplete(evt) {
        autoComplete.hdleEvent(evt);
        window.setTimeout(function () {
          autoComplete.closeAnimateImage();
          },1000);
      }
	//autoComplete end
    </script>
     <!-- 提交表单ajax结束 -->

    
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
    						<td>当前位置:>><a href="/yuntong/y_GoIndex.do">首页</a>>>市场配送</td>
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
			<!-- 内容  --><br>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
			<td valign="top">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tx">
						<tr>
							<td>
								车牌号码&nbsp;:&nbsp;&nbsp;&nbsp;${info.truckNum}
							</td>
							<td>
								司机姓名&nbsp;:&nbsp;&nbsp;&nbsp;${info.driverName}
							</td>
						</tr>
						<tr>
							<td colspan="2">
								输入货票编号&nbsp;:&nbsp;&nbsp;&nbsp;
<input type=text class=tx id=registerGlideID name=registerGlideID onkeyup="AjaxHdle(event)" ondblclick="autoComplete.expandAllItem();" size=30>
								&nbsp;&nbsp;&nbsp;<input class=tx type=button name=submit value=添加 onclick="doRequest();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								(<span style="color:red">只能装填配送地区相符的货票</span>)
							</td>
						</tr>
					</table>
						
					
					</td>
				</tr>
				<tr>
					<td style="display: none" id="infos">
						<table border="1" cellpadding="0" cellspacing="0"  width="100%" class=tx>
							<tr>
								<td width="15%"><div align="center">货票编号</div></td>
								<td width="15%"><div align="center">货物名称</div></td>
								<td width="15%"><div align="center">数量单位</div></td>
								<td width="15%"><div align="center">货物数量</div></td>
								<td width="15%"><div align="center">重&nbsp;&nbsp;量</div></td>
								<td width="15%"><div align="center">方&nbsp;&nbsp;量</div></td>
								<td width="15%"><div align="center">删&nbsp;&nbsp;除</div></td>
							</tr>
						</table>
						<table id="tab" width="100%" border="1" cellpadding="0" cellspacing="0" class="tx">
							<tbody id="tb">
							</tbody>	
						</table>
						<form method="post" action="/yuntong/PSGL/g_GoSNPS3.do">
						<table border="0" cellpadding="0" cellspacing="0" width="100%" class=tx>
						<tr><td width="17%" align="center">合计</td><td id="heft" align="center">重量:&nbsp;</td>
							<td id="bulk" align="center">方量:&nbsp;</td>
						</tr>
						<tr>
			              <input type="hidden" name="hroadType" id="hroadType" value="2">
			              <input type="hidden" name="hdriverId" id="driverId" value="${info.driverId}">
			              <input type="hidden" name="htruckNum" id="htruckNum" value="${info.truckNum}">
			              <input type="hidden" name="htruckId" id="htruckId" value="${info.truckId}">
			              <input type="hidden" name="hheft" id="hheft" value="${info.truckStyleTonnage}">
			              <input type="hidden" name="hbulk" id="hbulk" value="${info.truckStyleCubage}">
			              <input type="hidden" name="hRGID" id="hRGID">
						<td colspan="3" align="center">
						<a href="#" onclick="javascript:submit();" class="tx">下一步</a></td>
						</tr>
						</table></form>
					</td>
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
    												市场运输管理是对分公司与市场之间的，车辆货物人员安排进行管理的模块。可以自动判断车辆和司机是否空闲。车辆是否满载等信息 
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

