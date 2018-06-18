<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addBookCategory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function addBookCate(){ 
		var name = document.addForm.category.value;
		var flag = 1;
		if(name.length == 0){ // 检测名称是否为空
			alert("请输入图书类别名称！");
			flag = 0;
		} else if(name.indexOf(" ",0) != -1){
			alert("类别不能包含空格！");
			flag = 0;
		}
		if(flag == 1){
			document.addForm.action = "/BookShop/servlet/BookCateManagerControl?index=1";
			document.addForm.submit();
		}
  	}
</script>
  </head>
  <style type="text/css">
<!--
.style1 {font-size: 12px}
-->
</style>
  <body class="style1">
  <%
  	response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
  
  	String url = "/BookShop/servlet/BookCateManagerControl"; // flag 为1表示 增加图书类别
  	
   %>
    <center>
    	<form action= "" name="addForm" method = "post" class="style1">
    	<font size="5">新增图书类别</font>
        <p>
       		 图书类别：<input type="text" name="category">
        <p>
        	<input type="button" name="sbmt" value="新增" onClick = "addBookCate()" >
        	<input type="reset" name="reset" value="重置"> 
        </form>
    </center>
  </body>
</html>
