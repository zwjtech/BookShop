<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <frameset rows="20%,*,20%" border="0"> 
	<frame name="top" src="/BookShop/com/bsw/common/head.jsp" scrolling="no"> 
	
	<frame name="middle" src="/BookShop/com/bsw/user/userLogin.jsp" scrolling="Auto"> 
 	
	<frame name="bottom" src="/BookShop/com/bsw/common/foot.jsp" scrolling="no" marginhight=5> 
</frameset> 
</html>
