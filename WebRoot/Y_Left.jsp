<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 菜单弹出控制 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script language="javascript">
function shouhuo()
{	
	var shouhuo = document.getElementById("shouhuo");	
	var piaowu = document.getElementById("piaowu");
	var peisong = document.getElementById("peisong");
	var caiwu = document.getElementById("caiwu");
	var shichang = document.getElementById("shichang");
	var tongji = document.getElementById("tongji");
	var ziliao = document.getElementById("ziliao");	
	if(shouhuo.style.display!="" )
	{
		shouhuo.style.display="";		
		piaowu.style.display="none";
		peisong.style.display="none";
		caiwu.style.display="none";
		shichang.style.display="none";
		tongji.style.display="none";
		ziliao.style.display="none";
	}else{
		shouhuo.style.display="none";
	}
}
function piaowu()
{	
	var shouhuo = document.getElementById("shouhuo");	
	var piaowu = document.getElementById("piaowu");
	var peisong = document.getElementById("peisong");
	var caiwu = document.getElementById("caiwu");
	var shichang = document.getElementById("shichang");
	var tongji = document.getElementById("tongji");
	var ziliao = document.getElementById("ziliao");	
	if(piaowu.style.display!="" )
	{
		piaowu.style.display="";		
		shouhuo.style.display="none";
		peisong.style.display="none";
		caiwu.style.display="none";
		shichang.style.display="none";
		tongji.style.display="none";
		ziliao.style.display="none";
	}else{
		piaowu.style.display="none";
	}
}
function peisong()
{	
	var shouhuo = document.getElementById("shouhuo");	
	var piaowu = document.getElementById("piaowu");
	var peisong = document.getElementById("peisong");
	var caiwu = document.getElementById("caiwu");
	var shichang = document.getElementById("shichang");
	var tongji = document.getElementById("tongji");
	var ziliao = document.getElementById("ziliao");	
	if(peisong.style.display!="" )
	{
		peisong.style.display="";		
		shouhuo.style.display="none";
		piaowu.style.display="none";
		caiwu.style.display="none";
		shichang.style.display="none";
		tongji.style.display="none";
		ziliao.style.display="none";
	}else{
		peisong.style.display="none";
	}
}
function caiwu()
{	
	var shouhuo = document.getElementById("shouhuo");	
	var piaowu = document.getElementById("piaowu");
	var peisong = document.getElementById("peisong");
	var caiwu = document.getElementById("caiwu");
	var shichang = document.getElementById("shichang");
	var tongji = document.getElementById("tongji");
	var ziliao = document.getElementById("ziliao");	
	if(caiwu.style.display!="" )
	{
		caiwu.style.display="";		
		shouhuo.style.display="none";
		piaowu.style.display="none";
		peisong.style.display="none";
		shichang.style.display="none";
		tongji.style.display="none";
		ziliao.style.display="none";
	}else{
		caiwu.style.display="none";
	}
}
function shichang()
{	
	var shouhuo = document.getElementById("shouhuo");	
	var piaowu = document.getElementById("piaowu");
	var peisong = document.getElementById("peisong");
	var caiwu = document.getElementById("caiwu");
	var shichang = document.getElementById("shichang");
	var tongji = document.getElementById("tongji");
	var ziliao = document.getElementById("ziliao");	
	if(shichang.style.display!="" )
	{
		shichang.style.display="";		
		shouhuo.style.display="none";
		piaowu.style.display="none";
		caiwu.style.display="none";
		peisong.style.display="none";
		tongji.style.display="none";
		ziliao.style.display="none";
	}else{
		shichang.style.display="none";
	}
}
function tongji()
{	
	var shouhuo = document.getElementById("shouhuo");	
	var piaowu = document.getElementById("piaowu");
	var peisong = document.getElementById("peisong");
	var caiwu = document.getElementById("caiwu");
	var shichang = document.getElementById("shichang");
	var tongji = document.getElementById("tongji");
	var ziliao = document.getElementById("ziliao");	
	if(tongji.style.display!="" )
	{
		tongji.style.display="";		
		shouhuo.style.display="none";
		piaowu.style.display="none";
		caiwu.style.display="none";
		peisong.style.display="none";
		shichang.style.display="none";
		ziliao.style.display="none";
	}else{
		tongji.style.display="none";
	}
}
function ziliao()
{	
	var shouhuo = document.getElementById("shouhuo");	
	var piaowu = document.getElementById("piaowu");
	var peisong = document.getElementById("peisong");
	var caiwu = document.getElementById("caiwu");
	var shichang = document.getElementById("shichang");
	var tongji = document.getElementById("tongji");
	var ziliao = document.getElementById("ziliao");	
	if(ziliao.style.display!="" )
	{
		ziliao.style.display="";		
		shouhuo.style.display="none";
		piaowu.style.display="none";
		caiwu.style.display="none";
		peisong.style.display="none";
		shichang.style.display="none";
		tongji.style.display="none";
	}else{
		ziliao.style.display="none";
	}
}

</script>

    <table BORDER=0 CELLSPACING=0 CELLPADDING=0 COLS=1  WIDTH="104" >
<tr>
	<td align="center"><br><font color="#804060">--系统菜单--</font></td>
</tr>    
<tr>
<td onclick="shouhuo();" onmousemove="myInfoXmlHttpDoRequest(this.id);this.background='/yuntong/picture/sparebtnon.jpg'" id="left1001" background="/yuntong/picture/img01.jpg" height="28" align="center" style="cursor:hand" onmouseout="this.background='/yuntong/picture/img01.jpg'"><font color="#804020">收货管理</font></td>
</tr>
<tr>
<td align="center"><div  id="shouhuo" style="display:none ">
	<c:if test="${userLoginInfo.roleSHGL==1}">
	<a id="left1002" onmousemove="myInfoXmlHttpDoRequest(this.id);" href="/yuntong/SHGL/y_GoSHGL.do">[收货登记]</a><br>
	<a  id="left1003" onmousemove="myInfoXmlHttpDoRequest(this.id);" href="/yuntong/SHGL/y_GoDHQR.do">[到货确认]</a><br>
	<a href="/yuntong/SHGL/y_GoSHDJ.do" id="left1008" onmousemove="myInfoXmlHttpDoRequest(this.id);">[损货登记]</a><br>
	<a id="left1004" onmousemove="myInfoXmlHttpDoRequest(this.id);" href="/yuntong/SHGL/y_GoWGHP.do">[未估价货票]</a>
	</c:if>
	<c:if test="${userLoginInfo.roleSHGL==0}">	
	<a onclick="quanxian();" style="cursor:hand" id="left1002" onmousemove="myInfoXmlHttpDoRequest(this.id);">[收货登记]</a><br>
	<a onclick="quanxian();" style="cursor:hand" id="left1003" onmousemove="myInfoXmlHttpDoRequest(this.id);">[到货确认]</a><br>
	<a onclick="quanxian();" style="cursor:hand" id="left1008" onmousemove="myInfoXmlHttpDoRequest(this.id);">[损货登记]</a><br>
	<a onclick="quanxian();" style="cursor:hand" id="left1004" onmousemove="myInfoXmlHttpDoRequest(this.id);">[未估价货票]</a>
	</c:if>
</div></td>
</tr>
<tr>
<td onclick="piaowu();" background="/yuntong/picture/img01.jpg" height="28" align="center" style="cursor:hand" id="left2000"  onmousemove="myInfoXmlHttpDoRequest(this.id);this.background='/yuntong/picture/sparebtnon.jpg'" onmouseout="this.background='/yuntong/picture/img01.jpg'"><font color="#804020">票务管理</font></td>
</tr>
<tr>
<td align="center"><div id="piaowu" style="display:none">
<c:if test="${userLoginInfo.rolePWGL==1}">
		<a href="/yuntong/PWGL/J_FareMath.jsp" id="left2001" onmousemove="myInfoXmlHttpDoRequest(this.id);">[费用估算]</a><br>
     <a href="/yuntong/PWGL/j_GetStateAction.do" id="left2003" onmousemove="myInfoXmlHttpDoRequest(this.id);" >[货票充减]</a><br>
     <a href="/yuntong/PWGL/J_ShaoShouKuan.jsp">[少收款和赔款]</a><br>
    </c:if>
    <c:if test="${userLoginInfo.rolePWGL==0}">
		<a onclick="quanxian();" style="cursor:hand" id="left2001" onmousemove="myInfoXmlHttpDoRequest(this.id);">[费用估算]</a><br>
     <a  onclick="quanxian();" style="cursor:hand" id="left2003" onmousemove="myInfoXmlHttpDoRequest(this.id);">[货票充减]</a><br>
     <a  onclick="quanxian();" style="cursor:hand" id="left2004" onmousemove="myInfoXmlHttpDoRequest(this.id);">[少收款和赔款]</a><br>
    </c:if>
	
</div></td>
</tr>
<tr>
<td onclick="peisong();" id="left2000"  onmousemove="myInfoXmlHttpDoRequest(this.id);this.background='/yuntong/picture/sparebtnon.jpg'" background="/yuntong/picture/img01.jpg" height="28" align="center" style="cursor:hand"  onmouseout="this.background='/yuntong/picture/img01.jpg'"><font color="#804020">配送管理</font></td>
</tr>
<tr>
<td align="center"><div id="peisong" style="display:none ">
<c:if test="${userLoginInfo.rolePSGL==1}">
	<a href="/yuntong/PSGL/g_GoPSGL.do" id="left3001" onmousemove="myInfoXmlHttpDoRequest(this.id);">[车辆登记]</a><br>
	<a href="/yuntong/PSGL/g_GoDriverInfo.do" id="left3002" onmousemove="myInfoXmlHttpDoRequest(this.id);">[司机登记]</a><br>
	<a href="/yuntong/PSGL/g_GoSJYS.do" id="left3003"  onmousemove="myInfoXmlHttpDoRequest(this.id);">[省际运输]</a><br>
	<a href="/yuntong/PSGL/g_GoSNPS.do" id="left3004" onmousemove="myInfoXmlHttpDoRequest(this.id);" >[市场配送]</a>
	</c:if>
	<c:if test="${userLoginInfo.rolePSGL==0}">
	<a onclick="quanxian();" style="cursor:hand" id="left3001" onmousemove="myInfoXmlHttpDoRequest(this.id);">[车辆登记]</a><br>
	<a onclick="quanxian();" style="cursor:hand" id="left3002" onmousemove="myInfoXmlHttpDoRequest(this.id);">[司机登记]</a><br>
	<a onclick="quanxian();" style="cursor:hand" id="left3003"  onmousemove="myInfoXmlHttpDoRequest(this.id);">[省际运输]</a><br>
	<a onclick="quanxian();" style="cursor:hand" id="left3004" onmousemove="myInfoXmlHttpDoRequest(this.id);" >[市场配送]</a>
	</c:if>
</div></td>
</tr>
<tr>
<td onclick="caiwu();" background="/yuntong/picture/img01.jpg" height="28" id="left4000" onmousemove="myInfoXmlHttpDoRequest(this.id);this.background='/yuntong/picture/sparebtnon.jpg'"align="center" style="cursor:hand" onmouseout="this.background='/yuntong/picture/img01.jpg'"><font color="#804020">财务管理</font></td>
</tr>
<tr>
<td align="center"><div id="caiwu" style="display:none ">
<c:if test="${userLoginInfo.roleCWGL==1}">
	<a href="/yuntong/Financial/x_Financial.do?test=per" id="left4001"  onmousemove="myInfoXmlHttpDoRequest(this.id);">[预收货款]</a><br>	
	<a href="/yuntong/Financial/x_Financial.do?test=pick" id="left4002"  onmousemove="myInfoXmlHttpDoRequest(this.id);" >[提负收费]</a><br>
	<a href="/yuntong/Financial/x_Financial.do?test=lose">[损货赔付]</a><br>
	<a href="/yuntong/Financial/x_Financial.do?test=few">[少收款登记]</a><br>
	<a href="/yuntong/Financial/x_Financial.do?test=ribose">[核    算]</a>
	</c:if>
	<c:if test="${userLoginInfo.roleCWGL==0}">
	<a onclick="quanxian();" style="cursor:hand" id="left4001"  onmousemove="myInfoXmlHttpDoRequest(this.id);">[预收货款]</a><br>	
	<a onclick="quanxian();" style="cursor:hand" id="left4002"  onmousemove="myInfoXmlHttpDoRequest(this.id);" >[提负收费]</a><br>
	<a onclick="quanxian();" style="cursor:hand">[损货赔付]</a><br>
	<a onclick="quanxian();" style="cursor:hand">[少收款登记]</a><br>
	<a onclick="quanxian();" style="cursor:hand">[核    算]</a>
	</c:if>
</div></td>
</tr>
<tr>
<td onclick="shichang();" background="/yuntong/picture/img01.jpg" height="28" align="center" style="cursor:hand" id="left5000" onmouseout="this.background='/yuntong/picture/img01.jpg'" onmousemove="myInfoXmlHttpDoRequest(this.id);this.background='/yuntong/picture/sparebtnon.jpg'"><font color="#804020">市场管理</font></td>
</tr>
<tr>
<td align="center"><div id="shichang" style="display:none ">
<c:if test="${userLoginInfo.roleSCGL==1}">
<a href="/yuntong/SCGL/m_scgl_1.do" id="left5001" onmousemove="myInfoXmlHttpDoRequest(this.id);">[少收款登记]</a><br>
<a href="/yuntong/SCGL/M_scgll_2.jsp" id="left5002" onmousemove="myInfoXmlHttpDoRequest(this.id);">[退货登记]</a>
</c:if>
<c:if test="${userLoginInfo.roleSCGL==0}">
<a onclick="quanxian();" style="cursor:hand" id="left5001" onmousemove="myInfoXmlHttpDoRequest(this.id);">[少收款登记]</a><br>
<a onclick="quanxian();" style="cursor:hand" id="left5002" onmousemove="myInfoXmlHttpDoRequest(this.id);">[退货登记]</a>
</c:if>
</div></td>
</tr>
<tr>
<td onclick="tongji();" id="left6000" background="/yuntong/picture/img01.jpg" height="28" align="center" style="cursor:hand" onmouseout="this.background='/yuntong/picture/img01.jpg'" onmousemove="myInfoXmlHttpDoRequest(this.id);this.background='/yuntong/picture/sparebtnon.jpg'"><font color="#804020">查询统计</font><br></td>


</tr>
<tr>
<td align="center"><div id="tongji" style="display:none ">
<c:if test="${userLoginInfo.roleTJCX==1}">
<a href="/yuntong/CXTJ/G_cxtj.jsp" id="left6002"  onmousemove="myInfoXmlHttpDoRequest(this.id);">[货票查询]</a><br>
<a href="/yuntong/PWGL/j_RigHotLineAction.do" id="left6001"  onmousemove="myInfoXmlHttpDoRequest(this.id);">[各项统计]</a>
</c:if>
<c:if test="${userLoginInfo.roleTJCX==0}">
<a onclick="quanxian();" style="cursor:hand" id="left6002"  onmousemove="myInfoXmlHttpDoRequest(this.id);">[货票查询]</a><br>
<a onclick="quanxian();" style="cursor:hand" id="left6001"  onmousemove="myInfoXmlHttpDoRequest(this.id);">[各项统计]</a>
</c:if>
</div></td>
</tr>
<tr>
<td onclick="ziliao();" background="/yuntong/picture/img01.jpg" height="28" align="center" style="cursor:hand" onmouseout="this.background='/yuntong/picture/img01.jpg'" onmousemove="myInfoXmlHttpDoRequest(this.id);this.background='/yuntong/picture/sparebtnon.jpg'" id="left7000"><font color="#804020">基本资料</font></td>
</tr>
<tr>
<td align="center"><div id="ziliao" style="display:none ">
<c:if test="${userLoginInfo.roleJBZL==1}">
<a href="/yuntong/JBZL/y_GoCZY.do" id="left7001" onmousemove="myInfoXmlHttpDoRequest(this.id);">[操作员]</a><br>
<a href="/yuntong/JBZL/y_GoYHQX.do" id="left7002" onmousemove="myInfoXmlHttpDoRequest(this.id);">[用户权限]</a><br>
<a href="/yuntong/JBZL/y_GoYsyf.do" id="left7004" onmousemove="myInfoXmlHttpDoRequest(this.id);">[运费运时调整]</a><br>
</c:if>
<c:if test="${userLoginInfo.roleJBZL==0}">
<a style="cursor:hand"  onclick="quanxian();" id="left7001" onmousemove="myInfoXmlHttpDoRequest(this.id);">[操作员]</a><br>
<a style="cursor:hand" onclick="quanxian();" id="left7002" onmousemove="myInfoXmlHttpDoRequest(this.id);">[用户权限]</a><br>
<a style="cursor:hand" onclick="quanxian();" onmousemove="myInfoXmlHttpDoRequest(this.id);">[运费运时调整]</a><br>
</c:if>
<a href="/yuntong/JBZL/y_GoXGMM.do" id="left7003" onmousemove="myInfoXmlHttpDoRequest(this.id);">[修改密码]</a><br>



</div></td>
</tr>
<tr>
<td background="/yuntong/picture/img01.jpg" height="28" align="center" style="cursor:hand" onmouseout="this.background='/yuntong/picture/img01.jpg'" onmousemove="myInfoXmlHttpDoRequest(this.id);this.background='/yuntong/picture/sparebtnon.jpg'" id="left8000"><font color="#804020">系统帮助</font></td>
</tr>
<tr>
<td background="/yuntong/picture/img01.jpg" height="28" align="center" style="cursor:hand" onmouseout="this.background='/yuntong/picture/img01.jpg'" onmousemove="myInfoXmlHttpDoRequest(this.id);this.background='/yuntong/picture/sparebtnon.jpg'" id="left9000"><a href="/yuntong/y_Logout.do"><font color="#804020">安全注销</font></a></td>
</tr>

</table>


