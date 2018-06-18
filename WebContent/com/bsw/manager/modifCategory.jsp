<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifCategory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   <script type="text/javascript">
   		function check(){
	   		
	     	fm=document.modifyCate.category;
	   	    if(fm.value.length==0){
	   		 	alert("请输入图书类别！");
	   		 	 fm.select();
	   		 	fm.focus();
  			   
	   		}
   		}
  
  </script>
    <style type="text/css">
<!--
.style1 {font-size: 12px}
-->
</style>
  <body>
  
   <% 
   
   request.setCharacterEncoding("UTF-8");
   response.setContentType("text/html;charset=UTF-8");
   response.setCharacterEncoding("UTF-8");
   	int id = Integer.parseInt(request.getParameter("id"));
   	String cateName = request.getParameter("cateName");
    cateName = URLDecoder.decode(cateName, "utf-8");
   %>
   
   <%
  	String url = "/BookShop/servlet/BookCateManagerControl?index=2" + "&id=" + id; // index 为一表示 增加图书类别
   %>
     <center>
     <form action=<%=url %> method="post" class="style1">
    	<font size="5">修改图书类别</font>
        <p>
       		 图书类别：<input type="text" name="category" value=<%=cateName %>>
        <p>
        	<input type="submit" name="modif" value="修改" onClick="check()" >
        	<input type="Reset" name="reset" value="重置">
		</form>
    </center>
  </body>
</html>
