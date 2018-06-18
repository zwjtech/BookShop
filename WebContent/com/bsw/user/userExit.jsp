<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userExit.jsp' starting page</title>
    
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
  <center>
    <jsp:include flush="true" page="/com/bsw/common/head.jsp"></jsp:include>
    </center>
    <%
    	session.removeValue("user");
     %>
   <div align = "center" class="style1">
   <P></P>
   尊敬的用户，您已成功退出本系统，欢迎您的使用 
   <p></p>
    <jsp:include flush="true" page="/com/bsw/common/foot.jsp"></jsp:include>
    </div>
  </body>
</html>
