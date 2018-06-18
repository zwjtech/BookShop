<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.util.*,com.bsw.bookcategory.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bookCateManage.jsp' starting page</title>
    
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
  <body>
    <center><font size="5">图书类别管理</font></center>
    <br>
    <br>
	    <table border="0" width="600" class="style1" align="center">
	    	<tr>
	    		<td colspan="4" align="center"><a href="com/bsw/manager/addBookCategory.jsp">新增图书类别</td>
	    	</tr>
	    	<tr>
	    	<td align="center">类别编号</td>
	    	<td align="center">图书类别</td>
	    	<td align="center">修改</td>
	    	<td align="center">删除</td>
	    	</tr>
	    	<%! BookCategory bc; %>
	    	<%	request.setCharacterEncoding("UTF-8");
  				 response.setContentType("text/html;charset=UTF-8");
   				response.setCharacterEncoding("UTF-8");
	    		
	    		ArrayList al = (ArrayList)request.getAttribute("bookCategory");
	    		
	    		if(al!=null){
				Iterator it1 = al.iterator();
				while(it1.hasNext()){
						bc = (BookCategory)it1.next();
						String cname = URLEncoder.encode(bc.getName(),"utf-8");
			%>
				<tr>
	    			<td align="center"><%=bc.getId() %></td>
	    			<td align="center"><%=bc.getName() %></td>
	    			<td align="center"><a href="com/bsw/manager/modifCategory.jsp?id=<%=bc.getId() %>&cateName=<%=cname%>">修改</a></td>
	    			<td align="center"><a href="/BookShop/servlet/BookCateManagerControl?id=<%=bc.getId() %>&index=3">删除</a></td>
	    		</tr>
	    	 <%}
	    	 
	    	}%>
	    </table>
  </body>
</html>
