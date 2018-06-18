<%@ page language="java" import="java.util.*,com.bsw.bookcategory.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showCategory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	    <style type="text/css">
<!--
.style1 {font-size: 12px}
-->
</style>
  <script type="text/javascript">
  </script>
  </head>
  <jsp:useBean id = "category" class = "com.bsw.bookcategory.BookCategory" scope = "page" />
  <body>
  <center>
   <form name = "showCategory" action = "" method = "post">
   
   <table align = "center" width = "185" class="style1">
   		<tr bgcolor = "#dbd8d1">
   			<td  align = "center"> <font size = "2">所有图书类别</font></td>
   		</tr>
  	<%
  		ArrayList categories = (ArrayList)request.getAttribute("categories");
  		if(categories != null){
  		Iterator it = categories.iterator();
  		while(it.hasNext()){
  			category = (BookCategory)it.next();
  	 %>
  	
  
   		<tr>
   			<td align = "left"><a href = "/BookShop/servlet/CategoryDetailControl?categoryID=<%=category.getId()%>"><%=category.getName()%></a></td>
   		</tr>
  <%
  	}
  }
  %>
   </table>
   
   </form>
   
   </center>
  </body>
</html>
