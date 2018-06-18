<%@ page language="java" import="java.util.*,com.bsw.user.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <style type="text/css">
<!--
.style2 {font-size: 24px}
.style3 {font-size: 12px}
.style4 {color: #FF0000; font-size: 12px; }
-->
    </style>
  </head>
  
  <script type="text/javascript">
  
  	function checkPwd(){
  	
  		if(document.form1.password.value.length>16){
  			alert("密码最多16位！");
  			form1.password.focus();
  			form1.password.select();
  		} 
  	}
  	
  	function checkRealname(){	
  	
  		if(document.form1.realname.value.length>16){
  			alert("真实名最多16位！");
  			form1.realname.focus();
  			form1.realname.select();
  		}
  	}
  	
  	function checkAge(){
  	
  		if(isNaN(document.form1.age.value)){
  			alert("年龄必须为数值!");
  			form1.age.focus();
  			form1.age.select();
  		} else if(document.form1.age.value>100){
  			alert("年龄不可大于100!");
  			form1.age.focus();
  			form1.age.select();
  		} else if(document.form1.age.value<0){
  			alert("年龄不能小于0!");
  			form1.age.focus();
  			form1.age.select();
  		}
  	}
  	
  	function checkEmail(){
  	
		var Email = document.form1.email.value;
		var re = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
		if (!re.exec(Email)){
			alert("请输入正确的EMail地址!");
		    form1.email.focus();
  			form1.email.select();
		}
	}
  	
  	function checkCommMethod(){
  	
  		if(document.form1.commMethod.value.length>16){
  			alert("联系方式（电话号）最多16位!");
  			form1.commMethod.focus();
  			form1.commMethod.select();
  		}
  	}
  	
  	function checkAddress(){
  	
  		if(document.form1.address.value.length>16){
  			alert("联系地址最多16位!");
  			form1.address.focus();
  			form1.address.select();
  		}
  	}
  	
  	function get(){
  	
  		var f = document.form1;
  		f.Wname.focus();
  		f.Wname.select();
  	}
  	function fun(){
  	
  		var f = document.form1;
  		if(f.Wname.value.length==0||f.password.value.length==0||f.realname.value.length==0||
  			f.age.value.length==0||f.email.value.length==0||f.commMethod.value.length==0||f.address.value.length==0){
  			alert("您还没填完各项信息!");
  		} else {
  			document.form1.action="/BookShop/servlet/RegisterControl";
  			document.form1.submit();
  		}
  	}
  </script>
  <body onLoad="get()"> 
  <%
  	User user = (User)request.getAttribute("userTemp");
   %>
  <center>
 <jsp:include flush="true" page="/com/bsw/common/head.jsp"></jsp:include>
  <form name="form1" action="/BookShop/servlet/RegisterControl" method="post">
   <table width="741" border="0">
<tbody>	<tr>
	  		<td height="32" colspan = "4"><center class="style2">用户注册</center></td>
	   	</tr>
		<tr bgcolor="#dbd8d1">
			<td colspan = "4" height="10"></td>
		</tr>
		<tr>
			<td width="117" height="25"><span class="style3">用户名：</span></td>
			<td width="168"><input type="text" name="Wname"></input></td>
			<td width="193">&nbsp;</td>
			<td width="184" bgcolor="#00FF00"><span class="style4">您的用户名已被占用</span></td>
		</tr>
		<tr>
			<td><span class="style3">密  码:</span></td>
			<td><input type="password" name="password" onBlur="checkPwd()"></input></td>
			<td>&nbsp;</td>
			<td><span class="style4">请填写密码</span></td>
		</tr>
		<tr>
			<td><span class="style3">真实姓名:</span></td>
			<td><input type="text" name="realname"  value = "<%=user.getRealName()%>" onBlur="checkRealname()" /></td>
			<td>&nbsp;</td>
			<td><span class="style4">请填写你的真实姓名</span></td>
		</tr>
		<tr>
			<td><span class="style3">性  别</span></td>
			<td><span class="style3">
		    <input type="radio" name="gender" value = "1" <%
		    	if(user.getGender().equals("1")){
		     %> 
		     checked
		     <%
		     	} 
		      %>
		     />
			男
			<input type="radio" name="gender" value = "2"
				<%
		    	if(user.getGender().equals("2")){
		     %> 
		     checked
		     <%
		     	} 
		      %>
			/>
			女
			</span></td>
			<td>&nbsp;</td>
			<td><span class="style4">请选择您的性别</span></td>
		</tr>
		<tr>
			<td><span class="style3">年龄:</span></td>
			<td><input type="text" name="age" value = "<%=user.getAge()%>" onBlur="checkAge()" /></td>
			<td>&nbsp;</td>
			<td><span class="style4">请填写您的年龄</span></td>
	</tr>
		<tr>
			<td><span class="style3">User Email </span></td>
			<td><input type="text" name="email" value = "<%=user.getEmail() %>"onBlur="checkEmail()" /></td>
			<td>&nbsp;</td>
			<td><span class="style4">请输入您常用的电子邮件</span></td>
		</tr>
<tr>
<td><span class="style3">联系方式</span></td>
<td><input type="text" name="commMethod" value = "<%=user.getPhone()%>" onBlur="checkCommMethod()"/></td>
<td>&nbsp;</td>
<td><span class="style4">请输入您的联系方式以便于我们及时联系您</span></td>
</tr>
<tr>
<td><span class="style3">联系地址</span></td>
<td><input type="text" name="address" value = "<%=user.getAddress() %>" onBlur="checkAddress()"/></td>
<td>&nbsp;</td>
<td><span class="style4">请填写您的地址以便于我们发货给您</span></td>
</tr>
<tr>
<td><span class="style3">注册时间: </span></td>
<td><input type="text" name="registTime" value="<%=Calendar.getInstance().getTime().toLocaleString()%>"></td>
<td>&nbsp;</td>
<td>&nbsp;</td></tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td align="center"><input type="button" name="Submit" value="提交" onclick="fun()">
  <input type="button" name="Submit" value="取消"></td>
<td>&nbsp;</td></tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td></tr>
</tbody></table> 
</form>
<jsp:include flush="true" page="/com/bsw/common/foot.jsp"></jsp:include>
</center>
  </body>
</html>
