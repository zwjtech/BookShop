<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'managerWelcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  
  </head>
   
  	<frameset rows="20%,*,20%" border = "0">
	  	<frame name="top" src="/BookShop/com/bsw/common/headManager.jsp" scrolling="no"> 
		<frameset cols="50,150,490,50" border = "0">
			<frame></frame>
			<frame name="middle_left" src="com/bsw/manager/managerWelcome1.jsp " scrolling="Auto">
			<frame name="middle_right" src="com/bsw/manager/managerWelcome2.jsp" scrolling="Auto">
			<frame></frame>
		</frameset>
	 	<frame name="bottom" src="/BookShop/com/bsw/common/foot.jsp" scrolling="no">
	 </frameset>
</html>
