<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'registerSuccess.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<center><jsp:include flush="true" page="/com/bsw/common/head.jsp"></jsp:include></center>
    <center>恭喜您,注册成功!</center>
    <!-- 进入首页 -->
    <center><font color="#CC0033">您现在可以<a href="/BookShop/com/bsw/user/userLogin.jsp">登录</a><a href="/BookShop/index.jsp">|进入首页</a></font></center>
    <jsp:include flush="true" page="/com/bsw/common/foot.jsp"></jsp:include>
  </body>
</html>
