<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'blockManage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 <style type="text/css">
<!--
.style1 {font-size: 12px}
-->
</style>
  <body class="style1">
    <br>
  		<br>
  		<br>
  		<br>
  		<br>
    	管理员，欢迎您，请选择左侧菜单进行相应的操作!
    	<ul class="style1">
    	<li>可以对图书类别进行管理：
    	<li>可以对图书信息进行管理：
    	<li>可以查看图示销售信息
    	<li>可以退出管理系统
    	</ul>
  </body>
</html>
