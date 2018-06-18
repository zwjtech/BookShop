<%@ page language="java" import="com.bsw.user.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'managerWelcome1.jsp' starting page</title>
    
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
		a:visited{color:#800080;}
		a:hover,a:active,a:focus{color:#c00;}
  </style>
    <style type="text/css">
<!--
.style1 {font-size: 12px}
-->
</style>
  </head>
  
  <body class="style1">
  <%! // 定义servlet 地址 和参数
  	  String url1 = "/BookShop/servlet/ManagerControl?index=" + 1; //跳转至managerControl.java，同时传参index为1
  	  String url2 = "/BookShop/servlet/ManagerControl?index=" + 2;
  	  String url3 = "/BookShop/servlet/ManagerControl?index=" + 3; 
  	  String url4 = "/BookShop/servlet/ManagerControl?index=" + 4;  
  	  String url5 = "/BookShop/servlet/ManagerControl?index=" + 5;
  %>
    <center>
    <form name="welcome" method="post" class="style1" >
   	管理员操作
   	<p>
   	<%
   	User user =((User)session.getAttribute("user"));
   	if(user != null){
 		out.println(user.getName() + "管理员,您好！");
   	} else {
   	%>
   	<font color="red"><b>您已经推出，请重新登陆！</b></font>
   	<%
   		}
   	 %>
   	 <p>
   	 <a href=<%=url1 %> target="middle_right">后台管理首页</a>
   	 <p>
   	 <a href=<%=url2 %> target="middle_right">图书类别管理</a>
   	 <p>
   	 <a href=<%=url3 %> target="middle_right">图书信息管理</a>
   	 <p>
   	 <a href=<%=url4 %> target="middle_right">图书销售信息</a>
   	 <p>
   	 <a href=<%=url5 %> target="middle_right">退出管理系统</a>
  </form>
  </center>
  </body>
</html>
