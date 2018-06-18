<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'exitManagerSystem.jsp' starting page</title>
    
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
  		a:link{color:#900;}
  		a:visited{color:#800080;}
  		a:hover,a:active,a:focus{color:#c00}
  </style>
  </head>
  <style type="text/css">
<!--
.style1 {font-size: 12px}
-->
</style>
  <body class="style1">
    <center>尊敬的管理员，您已经成功退出本系统，欢迎您的使用！
    <p>
    <a href="/BookShop/servlet/WelcomeControl" target = "_top">返回主页</a>/<a href="com/bsw/manager/managerLogin.jsp" target = "_top">重新登录</a>
    </center>
  </body>
</html>
