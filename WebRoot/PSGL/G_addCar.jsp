<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>车辆信息登记</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	

    <link href="../css/lnroad.css" rel="stylesheet" type="text/css">
    <link href="../css/maple.css" rel="stylesheet" type="text/css">
    <!-- 提交表单ajax开始 -->
    <script type="text/javascript" language="javascript"> 
    	var xmlHttp;	
    	var curPage=0;
    	var upLoadFlag=false;//判断是否上传成功过照片
    	var isUploadSucced=false;//判断是否上传成功
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
		var truckNum=document.getElementById("truckNum").value;
		var truckEngineNum=document.getElementById("truckEngineNum").value;
		var truckRunNum=document.getElementById("truckRunNum").value;
		var truckInsuranceNum=document.getElementById("truckInsuranceNum").value;
		var truckStyleID=document.getElementById("truckStyleID").value;
		var truckColor=document.getElementById("truckColor").value;
		var truckPhoto=document.getElementById("truckPhoto").value;
		var truckBuyDate=document.getElementById("truckBuyDate").value;
		var truckFixed=document.getElementById("truckFixed").value;
		var truckCompanyID=document.getElementById("truckCompanyID").value;
		if(truckNum==""||truckEngineNum==""||truckRunNum==""||truckInsuranceNum==""||truckColor==""||truckPhoto==""||truckBuyDate==""||truckFixed==""){
			alert("带*号的信息必须填写完整");
			return;
		}
		if(upLoadFlag==false){
			alert("没有上传图片!");
			return;
		}
		if(isUploadSucced==false){
			alert("图片没有上传成功!请重新上传");
			return;
		}
		var string="truckNum="+truckNum+"&truckEngineNum="+truckEngineNum+"&truckRunNum="+
		truckRunNum+"&truckInsuranceNum="+truckInsuranceNum+"&truckStyleID="+
		truckStyleID+"&truckColor="+truckColor+"&truckPhoto="+truckPhoto+"&truckBuyDate="+
		truckBuyDate+"&truckFixed="+truckFixed+"&truckCompanyID="+truckCompanyID+"&";
		createXmlHttpRequest();
		var queryString="/yuntong/PSGL/g_AddTruckInfo.do?";
		queryString=queryString+string+createQueryString();
		//状态改变时
		xmlHttp.onreadystatechange=stateChange;
		xmlHttp.open("get",queryString,true);
		xmlHttp.send(null);
	}
	function stateChange(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				clear();
				alert("添加成功！");
			}else{
				alert("注册失败!");
				clear();
			}
		}
	}
	
	function clear(){
		document.getElementById("truckNum").value="";
		document.getElementById("truckEngineNum").value="";
		document.getElementById("truckRunNum").value="";
		document.getElementById("truckInsuranceNum").value="";
		document.getElementById("truckStyleID").value="";
		document.getElementById("truckColor").value="";
		document.getElementById("truckPhoto").value="";
		document.getElementById("truckBuyDate").value="";
		document.getElementById("truckFixed").value="";
		document.getElementById("truckCompanyID").value="";
	}
	//上传图片开始
	function uploadpic(){
		var path=document.getElementById("truckPhoto").value;
		var paths=path.split("\\");
		var fileNames=paths[paths.length-1].split(".");
		var fileName=fileNames[fileNames.length-1];
		var end=new Array("jpg","gif","png","bmp","JPG","GIF","PNG","BMP");
		var count=0;
		for(var i=0;i<end.length;i++){
			if(fileName!=end[i]){
				count++;
			}
		}
		if(count==end.length){
			alert("图片格式不对!\n只能上传("+end.toString()+")格式图片!");
			return;
		}
		upLoadFlag=true;
		createXmlHttpRequest();
		var queryString="/yuntong/PSGL/g_UpLoadPicture.do?path="+encodeURIComponent(path)+"&type=car&";
		queryString=queryString+createQueryString();
		//状态改变时
		xmlHttp.onreadystatechange=uploadpicstate;
		xmlHttp.open("get",queryString,true);
		xmlHttp.send(null);
	}
	function uploadpicstate(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				isUploadSucced=true;
				alert("上传成功！");
			}else{
				isUploadSucced=false;
				alert("上传失败!");
			}
		}
	}
	//上传图片结束
	//查找车辆信息开始
	function findTruckInfo(){
		document.getElementById("continueAdd").disabled=false;
		var truckNum=document.getElementById("findTruckNum").value;
		if(truckNum==""){
			alert("车牌号码不能为空!");
			return;
		}
		createXmlHttpRequest();
		var queryString="/yuntong/PSGL/g_FindTruckInfo.do?truckNum="+encodeURIComponent(truckNum)+"&";
		queryString=queryString+createQueryString();
		//状态改变时
		xmlHttp.onreadystatechange=findTruckInfoState;
		xmlHttp.open("get",queryString,true);
		xmlHttp.send(null);
	}
	function findTruckInfo2(truckNum){
		document.getElementById("continueAdd").disabled=false;
		createXmlHttpRequest();
		var queryString="/yuntong/PSGL/g_FindTruckInfo.do?truckNum="+encodeURIComponent(truckNum)+"&";
		queryString=queryString+createQueryString();
		//状态改变时
		xmlHttp.onreadystatechange=findTruckInfoState;
		xmlHttp.open("get",queryString,true);
		xmlHttp.send(null);
	}
	function findTruckInfoState(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				showTruckInfo();
			}else{
				alert("没有找到信息!");
				document.getElementById("findTruckNum").value="";
			}
		}
	}
	function showTruckInfo(){
		var xmldoc=xmlHttp.responseXML;
		var root=xmldoc.documentElement;
		var truckNum=root.getElementsByTagName("truckNum")[0].text;
		var truckEngineNum=root.getElementsByTagName("truckEngineNum")[0].text;
		var truckRunNum=root.getElementsByTagName("truckRunNum")[0].text;
		var truckInsuranceNum=root.getElementsByTagName("truckInsuranceNum")[0].text;
		var truckStyleID=root.getElementsByTagName("truckStyleID")[0].text;
		var truckColor=root.getElementsByTagName("truckColor")[0].text;
		var truckPhoto=root.getElementsByTagName("truckPhoto")[0].text;
		var truckBuyDate=root.getElementsByTagName("truckBuyDate")[0].text;
		var truckFixed=root.getElementsByTagName("truckFixed")[0].text;
		var truckCompanyID=root.getElementsByTagName("truckCompanyID")[0].text;
		
		//设值
		document.truckFrm.truckNum.value=truckNum;
		document.truckFrm.truckEngineNum.value=truckEngineNum;
		document.truckFrm.truckRunNum.value=truckRunNum;
		for(var i=0;i<document.truckFrm.truckStyleID.options.length;i++){
			var id=document.truckFrm.truckStyleID.options[i];
			if(id.value==truckStyleID){
				id.selected=true;
			}
		}
		document.truckFrm.truckColor.value=truckColor;
		document.truckFrm.truckPhoto.value=truckPhoto;
		document.truckFrm.truckBuyDate.value=truckBuyDate;
		document.truckFrm.truckFixed.value=truckFixed;
		for(var i=0;i<document.truckFrm.truckCompanyID.options.length;i++){
			var id=document.truckFrm.truckCompanyID.options[i];
			if(id.value==truckStyleID){
				id.selected=true;
			}
		}
		document.truckFrm.truckInsuranceNum.value=truckInsuranceNum;
		
		//设置不可用
		document.truckFrm.truckNum.disabled=true;
		document.truckFrm.truckEngineNum.disabled=true;
		document.truckFrm.truckRunNum.disabled=true;
		document.truckFrm.truckStyleID.disabled=true
		document.truckFrm.truckColor.disabled=true;
		document.truckFrm.truckPhoto.disabled=true;
		document.truckFrm.truckBuyDate.disabled=true;
		document.truckFrm.truckFixed.disabled=true;
		document.truckFrm.truckCompanyID.disabled=true;
		document.truckFrm.truckInsuranceNum.disabled=true;
		document.truckFrm.upload.disabled=true;
		document.truckFrm.submit.disabled=true;
		document.truckFrm.reset.disabled=true;
		document.getElementById("findTruckNum").value="";
	}
	//查找车辆信息开始
	//车牌号码列表开始
	function getTruckNumList(page){
		curPage=page;
		createXmlHttpRequest();
		var queryString="/yuntong/PSGL/g_FindAllTruck.do?curPage="+curPage+"&";
		queryString=queryString+createQueryString();
		//状态改变时
		xmlHttp.onreadystatechange=getTruckNumListState;
		xmlHttp.open("get",queryString,true);
		xmlHttp.send(null);
	}
	function getTruckNumListState(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				showTruckNumList();
			}else{
				alert("没有找到信息!");
			}
		}
	}
	function showTruckNumList(){
		var xmldoc=xmlHttp.responseXML;
		var root=xmldoc.documentElement;
		totalPage=root.getElementsByTagName("totalPage")[0].text;
		var nodes=root.getElementsByTagName("truckNumList");
		var nextPage=parseInt(curPage)+1;
		var backPage=parseInt(curPage)-1;		
		var tr=tb.insertRow();
		var td=tr.insertCell();
		td.align="center";
		td.background="/yuntong/picture/loginpage.gif";
		td.innerHTML="<font color=\"red\">车牌号码列表</font>";
		if(tb.firstChild==tb.lastChild){
			for(var i=0;i<nodes.length;i++){
				tb.align="center";
				var tr=tb.insertRow();
				var td=tr.insertCell();
				td.background="/yuntong/picture/bg1.jpg";
				td.innerHTML="<a href=\"#\" onclick=\"findTruckInfo2(\'"+nodes[i].text+"\')\">"+nodes[i].text+"</a>";
			}
			var tr=tb.insertRow();
			var td=tr.insertCell();
			td.background="/yuntong/picture/bg1.jpg";
			td.innerHTML="<a href=\"#\" onclick=\"getTruckNumList(\'"+nextPage+"\')\">下一页</a>";
		}else{
			var size=tb.children.length;
			for(var j=0;j<size;j++){
				tb.deleteRow();
			}
			var tr=tb.insertRow();
			var td=tr.insertCell();
			td.align="center";
			td.background="/yuntong/picture/loginpage.gif";
			td.innerHTML="<tr><td background=\"/yuntong/picture/loginpage.gif\" align=\"center\"><br><font color=\"red\">车牌号码列表</font></td></tr>";
			for(var i=0;i<nodes.length;i++){
				var tr=tb.insertRow();
				var td=tr.insertCell();
				td.background="/yuntong/picture/bg1.jpg";
				tb.align="center";
				td.innerHTML="<a href=\"#\" onclick=\"findTruckInfo2(\'"+nodes[i].text+"\')\">"+nodes[i].text+"</a>";
			}
			if(totalPage!=1){
				if(curPage==totalPage){
					var tr=tb.insertRow();
					var td=tr.insertCell();
					td.background="/yuntong/picture/bg1.jpg";
					td.innerHTML="<a href=\"#\" onclick=\"getTruckNumList(\'"+backPage+"\')\">上一页</a>";
				}else if(curPage==1){
					var tr=tb.insertRow();
					var td=tr.insertCell();
					td.background="/yuntong/picture/bg1.jpg";
					td.innerHTML="<a href=\"#\" onclick=\"getTruckNumList(\'"+nextPage+"\')\">下一页</a>";
				}else{
					var tr=tb.insertRow();
					var td=tr.insertCell();
					td.background="/yuntong/picture/bg1.jpg";
					td.innerHTML="<a href=\"#\" onclick=\"getTruckNumList(\'"+backPage+"\')\">上一页</a><a href=\"#\" onclick=\"getTruckNumList(\'"+nextPage+"\')\">下一页</a>";
				}
			}
		}
		var tr=tb.insertRow();
		var td=tr.insertCell();
		td.innerHTML="<img src=\"/yuntong/picture/bottom.jpg\">";
	}
	
	function continueAdd(){
		clear();
		document.truckFrm.truckNum.disabled=false;
		document.truckFrm.truckEngineNum.disabled=false;
		document.truckFrm.truckRunNum.disabled=false;
		document.truckFrm.truckStyleID.disabled=false
		document.truckFrm.truckColor.disabled=false;
		document.truckFrm.truckPhoto.disabled=false;
		document.truckFrm.truckBuyDate.disabled=false;
		document.truckFrm.truckFixed.disabled=false;
		document.truckFrm.truckCompanyID.disabled=false;
		document.truckFrm.truckInsuranceNum.disabled=false;
		document.truckFrm.upload.disabled=false;
		document.truckFrm.submit.disabled=false;
		document.truckFrm.reset.disabled=false;
		document.getElementById("continueAdd").disabled=true;
	}
	//车牌号码列表开始
	
	function showcalendar(obj){
  		dv=window.showModalDialog("calendar.htm","44","center:1;help:no;status:no;dialogHeight:246px;dialogWidth:216px;scroll:no")
  		if (dv) {if (dv=="null") obj.value='';else obj.value=dv;}
	}
    </script>
     <!-- 提交表单ajax结束 -->

  </head>
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
    			  
    				<table border="0" width="100%" class="tx" cellpadding="0" cellspacing="0">
    					<tr>
    						<td>当前位置：>><a href="/yuntong/y_GoIndex.do">首页</a>>>车辆信息登记</td>
    					</tr>
    					
    				</table>
    				<table border="0" class="tx" cellpadding="0" cellspacing="0" width="100%">
    					<tr>
    						<td background="" align="left">
    						<img height="77" width="90" border="0" src="/yuntong/picture/psgl/car.gif">
    						</td>
    					</tr>
    				</table>
    				<table>
    					<tr><td height="20"></td></tr>
    				</table>
    				<!-- 添加车辆信息(开始) -->
    				<table border="0" width="100%" cellpadding="0" cellspacing="0">
    				<tr><td rowspan="2">
    				  <table border="0" class="tx" cellpadding="0" cellspacing="0" width="100%">
    							    	<tr>
    							    		<td  bgcolor="a0c0c0"><font color="#804060" size="3">车辆信息登记：</font></td>
    							    	</tr>
    							    	<tr>
    							    		<td bgcolor="a0c0c0">
    							    		
    							    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已登记车辆查询：<br>
    							    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;车牌号码：<input class="tx" type="text" id="findTruckNum" name="findTruckNum">
    							    			
    							    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    							    			<input class="tx" type="button" onclick="findTruckInfo();" name="Find" value="查找信息">
    							    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    							    			<input type="button" name="carList" onclick="getTruckNumList(1);" value="显示车牌列表" class=tx>    							    			
    							    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    							    			<input type="button" id="continueAdd" name="continueAdd" onclick="continueAdd();" value="继续添加" class=tx disabled="disabled">  
    							    		</td>
    							    	</tr>
    							    </table>
    		<form action="#" method="post" name="truckFrm">
    				<table width="100%" border="0" cellpadding="0" cellspacing="0" class=tx>
    				 <tr>
        <td width="138" align="left"><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;车牌号码:</div></td>
        <td width="350" align="left">
		
            <div align="left">
              <input class=tx name="truckNum" type="text" id="truckNum" size="40">&nbsp;&nbsp;<font color="red">*</font>
            </div></td>
            
      </tr>
      <tr>
        <td><div  align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发动机号:</div></td>
        <td><div  align="left">
              <input class=tx name="truckEngineNum" type="text" id="truckEngineNum" size="40">&nbsp;&nbsp;<font color="red">*</font>
        </div></td>
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;行驶证号:</div></td>
        <td><div align="left">
              <input class=tx name="truckRunNum" type="text" id="truckRunNum" size="40">&nbsp;&nbsp;<font color="red">*</font>
        </div></td>
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;保 险 号:</div></td>
        <td><div align="left">
              <input class=tx name="truckInsuranceNum" type="text" id="truckInsuranceNum" size="40">&nbsp;&nbsp;<font color="red">*</font>
        </div></td>
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;车 型 号:</div></td>
        <td><div align="left">
        <select class=tx name="truckStyleID" id="truckStyleID">
        <c:forEach items="${truckStyleList}" var="styleList">
        	<option value="${styleList.truckStyleID}">${styleList.truckStyleName}</option>
        </c:forEach>
        </select>
        </div></td>
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;颜&nbsp;&nbsp;&nbsp;色:</div></td>
        <td><div align="left">
              <input class=tx name="truckColor" type="text" id="truckColor" size="40">&nbsp;&nbsp;<font color="red">*</font>
        </div></td>
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上传照片:</div></td>
        <td><div align="left">
              <input class=tx name="truckPhoto" type="file" id="truckPhoto" size="15">
			  <input class="txt1" name="upload" type="button" id="upload" value="上   传" onclick="uploadpic();">&nbsp;&nbsp;<font color="red">*</font>
        </div></td>
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;购买日期:</div></td>
        <td><div align="left">
              <input  class=tx name="truckBuyDate" type="text" id="truckBuyDate" size="40" style="CURSOR: hand" onclick=showcalendar(this,this) readOnly>&nbsp;&nbsp;<font color="red">*</font>
        </div></td>
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;使用年限:</div></td>
        <td><div align="left">
              <input class=tx name="truckFixed" type="text" id="truckFixed" size="40">&nbsp;&nbsp;<font color="red">*</font>
        </div></td>
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;隶属分公司:</div></td>
        <td><div align="left">
            <select class=tx name="truckCompanyID" id="truckCompanyID">
        <c:forEach items="${filialeList}" var="filialeList">
        	<option value="${filialeList.filialeId}">${filialeList.filialeName}</option>
        </c:forEach>
        </select>
        </div></td>
      </tr>
      <tr>
        <td colspan="2"><div align="center">
          <input class="tx" name="submit" type="button" id="submit" value="提  交" onclick="doRequest();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input class="tx" name="reset" type="button" id="reset" value="重  置" onclick="clear();">        
        </div></td>
      </tr>
    				</table>
    				</form>
    				
    				<!-- 添加车辆信息（结束） -->  
    				</td> 
    					<td valign="top" width="20%" id=carList> 					
  							<!-- 操作步骤 -->
    							<table width="100%" border="0" cellpadding="0" cellspacing="0">
    							<tbody id=tb>
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
    							</tbody>
    							</table>
    							<!-- 操作步骤 -->
  							</td>  							
    					</tr>
    					<tr>
    						<td valign="top" height="80%">
    						<!-- 提示信息 -->
    							<table width="100%" border="0" cellpadding="0" cellspacing="0">
    							<tr>
    								<td background="/yuntong/picture/loginpage.gif" align="center"><br><font color="red">提示信息</font></td>
    							</tr>
    							<tr>
    								<td background="/yuntong/picture/bg1.jpg">
    								<table border="0" width="80%" height="140" align="center">
    										<tr>
    											<td>
    												登记新购买的车辆信息
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

