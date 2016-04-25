<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>司机信息登记</title>

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
   		var driverCardID=document.getElementById("driverCardID").value;
		var driverRemarkInfo=document.getElementById("driverRemarkInfo").value;
		var driverDriverCardID=document.getElementById("driverDriverCardID").value;
		var driverPhoto=document.getElementById("driverPhoto").value;
		var driverCompanyID=document.getElementById("driverCompanyID").value;
		var driverName=document.getElementById("driverName").value;
		var driverPhoneNum=document.getElementById("driverPhoneNum").value;
		var driverAge=document.getElementById("driverAge").value;
		var driverSexObj=document.getElementById("driverSex");
		var driverSex=0;
		if(driverSexObj.checked){
			driverSex=0
		}else{
			driverSex=1;
		}
		if(driverCardID==""||driverDriverCardID==""||driverDriverCardID==""||driverPhoto==""||driverCompanyID==""||driverName==""||driverPhoneNum==""||driverAge==""){
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
		var string="driverCardID="+driverCardID+"&driverDriverCardID="+driverDriverCardID+"&driverPhoto="+
		driverPhoto+"&driverCompanyID="+driverCompanyID+"&driverName="+
		driverName+"&driverPhoneNum="+driverPhoneNum+"&driverAge="+driverAge+"&driverSex="+driverSex+"&driverRemarkInfo="+driverRemarkInfo+"&";
		createXmlHttpRequest();
		var queryString="/yuntong/PSGL/g_AddDriverInfo.do?";
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
				clear();
				alert("添加失败!");
			}
		}
	}
	
	function clear(){
		document.getElementById("driverCardID").value="";
		document.getElementById("driverRemarkInfo").value="";
		document.getElementById("driverDriverCardID").value="";
		document.getElementById("driverPhoto").value="";
		document.getElementById("driverCompanyID").value="";
		document.getElementById("driverName").value="";
		document.getElementById("driverPhoneNum").value="";
		document.getElementById("driverAge").value="";
		document.getElementById("driverSex").value="";
	}
	//上传图片开始
	function uploadpic(){
		var path=document.getElementById("driverPhoto").value;
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
		var queryString="/yuntong/PSGL/g_UpLoadPicture.do?path="+encodeURIComponent(path)+"&type=driver&";
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
	//查找司机信息开始
	function findDriverInfo(){
		document.getElementById("continueAdd").disabled=false;
		var driverName=document.getElementById("findDriverName").value;
		if(driverName==""){
			alert("司机姓名不能为空!");
			return;
		}
		createXmlHttpRequest();
		var queryString="/yuntong/PSGL/g_FindDriverInfo.do?driverName="+encodeURIComponent(driverName)+"&";
		queryString=queryString+createQueryString();
		//状态改变时
		xmlHttp.onreadystatechange=findDriverInfoState;
		xmlHttp.open("get",queryString,true);
		xmlHttp.send(null);
	}
	
	function findDriverInfo2(driverName){
		document.getElementById("continueAdd").disabled=false;
		createXmlHttpRequest();
		var queryString="/yuntong/PSGL/g_FindDriverInfo.do?driverName="+encodeURIComponent(driverName)+"&";
		queryString=queryString+createQueryString();
		//状态改变时
		xmlHttp.onreadystatechange=findDriverInfoState;
		xmlHttp.open("get",queryString,true);
		xmlHttp.send(null);
	}
	function findDriverInfoState(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				showDriverInfo();
			}else{
				alert("没有找到信息!");
				document.getElementById("findDriverName").value="";
			}
		}
	}
	function showDriverInfo(){
		var xmldoc=xmlHttp.responseXML;
		var root=xmldoc.documentElement;
		var driverName=root.getElementsByTagName("driverName")[0].text;
		var driverAge=root.getElementsByTagName("driverAge")[0].text;
		var driverSex=root.getElementsByTagName("driverSex")[0].text;
		var driverPhoto=root.getElementsByTagName("driverPhoto")[0].text;
		var driverDriverCardID=root.getElementsByTagName("driverDriverCardID")[0].text;
		var driverCardID=root.getElementsByTagName("driverCardID")[0].text;
		var driverPhoneNum=root.getElementsByTagName("driverPhoneNum")[0].text;
		var driverCompanyID=root.getElementsByTagName("driverCompanyID")[0].text;
		var driverRemarkInfo=root.getElementsByTagName("driverRemarkInfo")[0].text;
		
		//设值
		document.driverFrm.driverName.value=driverName;
		document.driverFrm.driverAge.value=driverAge;
		for(var i=0;i<document.driverFrm.driverSex.length;i++){
			var id=document.driverFrm.driverSex[i];
			if(id.value==driverSex){
				id.checked="checked";
			}
		}
		document.driverFrm.driverPhoto.value=driverPhoto;
		document.driverFrm.driverDriverCardID.value=driverDriverCardID;
		document.driverFrm.driverCardID.value=driverCardID;
		document.driverFrm.driverPhoneNum.value=driverPhoneNum;
		for(var i=0;i<document.driverFrm.driverCompanyID.options.length;i++){
			var id=document.driverFrm.driverCompanyID.options[i];
			if(id.value==driverCompanyID){
				id.selected=true;
			}
		}
		document.driverFrm.driverRemarkInfo.value=driverRemarkInfo;
		
		//设置不可用
		document.driverFrm.driverName.disabled=true;
		document.driverFrm.driverAge.disabled=true;
		document.driverFrm.driverSex[0].disabled=true;
		document.driverFrm.driverSex[1].disabled=true;
		document.driverFrm.driverPhoto.disabled=true;
		document.driverFrm.driverDriverCardID.disabled=true;
		document.driverFrm.driverCardID.disabled=true;
		document.driverFrm.driverPhoneNum.disabled=true;
		document.driverFrm.driverCompanyID.disabled=true;
		document.driverFrm.driverRemarkInfo.disabled=true;
		document.driverFrm.upload.disabled=true;
		document.driverFrm.submit.disabled=true;
		document.driverFrm.reset.disabled=true;
		document.getElementById("findDriverName").value="";
	}
	//查找司机信息开始
	
	//司机姓名列表开始
	function getDriverNameList(page){
		curPage=page;
		createXmlHttpRequest();
		var queryString="/yuntong/PSGL/g_FindAllDriverInfo.do?curPage="+curPage+"&";
		queryString=queryString+createQueryString();
		//状态改变时
		xmlHttp.onreadystatechange=getDriverNameListState;
		xmlHttp.open("get",queryString,true);
		xmlHttp.send(null);
	}
	function getDriverNameListState(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				showDriverNameList();
			}else{
				alert("没有找到信息!");
			}
		}
	}
	function showDriverNameList(){
		var xmldoc=xmlHttp.responseXML;
		var root=xmldoc.documentElement;
		totalPage=root.getElementsByTagName("totalPage")[0].text;
		var nodes=root.getElementsByTagName("driverNaneList");
		var nodeLength=nodes.length;
		var nextPage=parseInt(curPage)+1;
		var backPage=parseInt(curPage)-1;		
		var tr=tb.insertRow();
		var td=tr.insertCell();
		td.innerHTML="<tr><td class=tx align=\"center\">司机姓名列表:</td></tr>"
		if(tb.firstChild==tb.lastChild){
			for(var i=0;i<nodeLength;i++){
				tb.align="center";
				var tr=tb.insertRow();
				var td=tr.insertCell();
				td.background="/yuntong/picture/bg1.jpg";
				td.innerHTML="<a href=\"#\" onclick=\"findDriverInfo2(\'"+nodes[i].text+"\')\">"+nodes[i].text+"</a>";
			}
			var tr=tb.insertRow();
			var td=tr.insertCell();
			td.background="/yuntong/picture/bg1.jpg";
			td.innerHTML="<a href=\"#\" onclick=\"getDriverNameList(\'"+nextPage+"\')\">下一页</a>";
		}else{
			var size=tb.children.length;
			for(var j=0;j<size;j++){
				tb.deleteRow();
			}
			var tr=tb.insertRow();
			var td=tr.insertCell();
			td.align="center";
			td.background="/yuntong/picture/loginpage.gif";
			td.innerHTML="<tr><td background=\"/yuntong/picture/loginpage.gif\" align=\"center\"><br><font color=\"red\">司机姓名列表</font></td></tr>";
			for(var i=0;i<nodes.length;i++){
				var tr=tb.insertRow();
				var td=tr.insertCell();
				tb.align="center";
				td.background="/yuntong/picture/bg1.jpg";
				td.innerHTML="<a href=\"#\" onclick=\"findDriverInfo2(\'"+nodes[i].text+"\')\">"+nodes[i].text+"</a>";
			}
			if(totalPage!=1){
				if(curPage==totalPage){
					var tr=tb.insertRow();
					var td=tr.insertCell();
					td.background="/yuntong/picture/bg1.jpg";
					td.innerHTML="<a href=\"#\" onclick=\"getDriverNameList(\'"+backPage+"\')\">上一页</a>";
				}else if(curPage==1){
					var tr=tb.insertRow();
					var td=tr.insertCell();
					td.background="/yuntong/picture/bg1.jpg";
					td.innerHTML="<a href=\"#\" onclick=\"getDriverNameList(\'"+nextPage+"\')\">下一页</a>";
				}else{
					var tr=tb.insertRow();
					var td=tr.insertCell();
					td.background="/yuntong/picture/bg1.jpg";
					td.innerHTML="<a href=\"#\" onclick=\"getDriverNameList(\'"+backPage+"\')\">上一页</a><a href=\"#\" onclick=\"getDriverNameList(\'"+nextPage+"\')\">下一页</a>";
				}
			}
		}
		var tr=tb.insertRow();
		var td=tr.insertCell();
		td.innerHTML="<img src=\"/yuntong/picture/bottom.jpg\">";
	}
	
	function continueAdd(){
		clear();
		document.driverFrm.driverName.disabled=false;
		document.driverFrm.driverAge.disabled=false;
		document.driverFrm.driverSex[0].disabled=false;
		document.driverFrm.driverSex[1].disabled=false;
		document.driverFrm.driverPhoto.disabled=false;
		document.driverFrm.driverDriverCardID.disabled=false;
		document.driverFrm.driverCardID.disabled=false;
		document.driverFrm.driverPhoneNum.disabled=false;
		document.driverFrm.driverCompanyID.disabled=false;
		document.driverFrm.driverRemarkInfo.disabled=false;
		document.driverFrm.upload.disabled=false;
		document.driverFrm.submit.disabled=false;
		document.driverFrm.reset.disabled=false;
		document.getElementById("continueAdd").disabled=true;
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
    			  
    				<table border="0" cellpadding="0" cellspacing="0" class="tx" width="100%">
    					<tr>
    						<td>当前位置:>><a href="/yuntong/y_GoIndex.do">首页</a>>>司机信息登记</td>
    					</tr>
    					
    				</table>
    				<table border="0" cellpadding="0" cellspacing="0" class="tx" width="100%">
    					<tr>
    						<td background="" align="left">
								<img height="77" width="90" border="0" src="/yuntong/picture/psgl/jl3.bmp">
    						</td>
    					</tr>
    				</table>
    				<table>
    					<tr><td height="20"></td></tr>
    				</table>
    				<!-- 添加司机信息(开始) -->
    				<table border="0" cellpadding="0" cellspacing="0"  width="100%">
    				<tr><td rowspan="2">
    				  <table border="0" cellpadding="0" cellspacing="0" class="tx" width="100%">
    							    	<tr><td bgcolor="a0c0c0"><font color="#804060" size="3">司机信息登记</font></tr>
    							    	<tr>
    							    		<td bgcolor="a0c0c0">
    							    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;司机信息查询<br>
    							    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入司机姓名
    							    		<input class="tx" type="text" id="findDriverName" name="findDriverName" value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    							    			<input class="tx" type="button" onClick="findDriverInfo();" name="Find" value="查  询">
    							    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    							    			<input type="button" name="carList" onclick="getDriverNameList(1);" value="显示司机列表" class=tx>    							    			
    							    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    							    			<input type="button" id="continueAdd" name="continueAdd" onclick="continueAdd();" value="继续添加" class=tx disabled="disabled">
    							    		</td>
    							    	</tr>
				      </table>
				      <form action="#" method="post" name="driverFrm">
    				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tx">
    				 <tr>
        <td width="138"><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名:</div></td>
        <td width="350">
        	<div align="left">
              <input class=tx name="driverName" type="text" id="driverName" size="40">
            </div></td>
            
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;龄:</div></td>
        <td><div align="left">
              <input class=tx name="driverAge" type="text" id="driverAge" size="40">
        </div></td>
        
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性&nbsp;&nbsp;&nbsp;&nbsp;别:</div></td>
        <td><div align="left">
		 	<input type="radio" id="driverSex" name="driverSex" value="0" checked="checked">男
		 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         	 <input type="radio" id="driverSex" name="driverSex" value="1">女
          </div></td>
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上传照片:</div></td>
        <td><div align="left">
              <input class=tx name="driverPhoto" type="file" id="driverPhoto" size="15">
			  <input class="tx" name="upload" type="button" id="upload" value="上   传" onclick="uploadpic();">
        </div></td>
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;驾驶证号:</div></td>
        <td><div align="left">
              <input name="driverDriverCardID" type="text" class=tx id="driverDriverCardID" size="40">
          </div></td>
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号:</div></td>
        <td><div align="left">
              <input class=tx name="driverCardID" type="text" id="driverCardID" size="40">
        </div></td>
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话:</div></td>
        <td><div align="left">
          <input class=tx name="driverPhoneNum" type="text" id="driverPhoneNum" size="40">
        </div></td>
       
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;隶属分公司:</div></td>
        <td><div align="left">
              <select name="driverCompanyID" class="tx" id="driverCompanyID">
             <c:forEach items="${filialeList}" var="filialeList">
        	<option value="${filialeList.filialeId}">${filialeList.filialeName}</option>
        </c:forEach>
              </select>
          </div></td>
      </tr>
      <tr>
        <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备&nbsp;&nbsp;&nbsp;&nbsp;注:</div></td>
        <td><div align="left">
              <textarea name="driverRemarkInfo" cols="40" rows="5" class="tx" id="driverRemarkInfo"></textarea>
        </div></td>
      </tr>
      
      
      <tr>
        <td colspan="2"><div align="center">
          <input class="tx" name="submit" type="button" id="submit" value="提交" onClick="doRequest();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input class="tx" name="reset" type="reset" id="reset" value="重置" onclick="clear();">        
        </div></td>
      </tr>
    				</table></form>
    					<!-- 添加司信息（结束） -->    	    						    						    						
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
    						<td valign="top">
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
    												登记新加入的司机信息
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
