<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'managerLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style type="text/css">
  		a{text-decoration:none;}
  		a:link{color:#009;}
  		a:hover,a:active,a:focus{color:#c00;}
  </style>
    <style type="text/css">
<!--
.style1 {font-size: 12px}
-->
</style>
  </head>
  
  <script type="text/javascript">
  
  	function loginSubmit() {
  	
  		document.login.action = "/BookShop/servlet/LoginControl?role="+1;
  		document.login.submit();
  	}
  </script>
  <%
  	String url = "/BookShop/servlet/LoginControl?role=" + 1; // 管理员登陆
   %> 
  <body>
   <center>
	 <table class="style1">
	 		<tr>
				<td>
					<%@include file="/com/bsw/common/head.jsp"%>
				</td>
			</tr>
	 		<tr>
		 		<td align="center">
				 <form name="login" action=<%=url %> method="post">
					 <table border="2" bgcolor="#dbd8d1" width="400">
						 <tr>
						   <td><center>管理员登录</center></td>
						 </tr>
						 <tr>
						   <td><center>用户名：<input type="text" name="userName" value = "admin"></center></td>
						 </tr>
						 <tr>
						   <td><center>密  码：&nbsp;<input type="password" name="pwd" value = "admin"></center></td>
						 </tr>
						 <tr>
						   <td><center><input type="submit" name="login2" value="登录">&nbsp;&nbsp;
						   			   <input type="reset" value="取消"> &nbsp;&nbsp;<a href="/BookShop/servlet/WelcomeControl">返回首页</a></center></td>
						 </tr>
						 <tr>
						   <td><center>友情提示：管理员用户名和密码均为admin</center></td>
						 </tr>
					 </table>
				 </form>
				</td>
		</tr>
		<tr>
			<td>
				<%@include file="/com/bsw/common/foot.jsp"%>
			</td>
		</tr>
	</table>
  </center>
  </body>
</html>
