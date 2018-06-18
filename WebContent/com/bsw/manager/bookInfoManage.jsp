<%@ page language="java" import="java.util.*,com.bsw.book.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bookInfoManage.jsp' starting page</title>
    
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
   <%! // 定义servlet 地址 和参数
  	  String url = "/BookShop/servlet/BookInfoManageControl";  
  %>
    <center>
	    <font size="5" >图书信息管理</font>
	    <br>
	    <br>
		    <table border="0" width="600" class="style1">
		    	<tr>
		    		<td colspan="6" align="right"><a href="<%=url%>?action=1" >新增图书</td>
		    	</tr>
		    	<tr>
			    	<td align="center">编号</td>
			    	<td align="center">图书名称</td>
			    	<td align="center">单价</td>
			    	<td align="center">出版社</td> 
			    	<td align="center">详细信息</td>
			    	<td align="center">修改</td>
			    	<td align="center">删除</td>
			    	
		    	</tr>
		    	<%! Book book; %>
		    	<%
		    		ArrayList al = (ArrayList)request.getAttribute("books");
	    		
		    		if(al!=null){
		    		
						Iterator it1 = al.iterator();
					while(it1.hasNext()){
							book = (Book)it1.next();
		    	 %>
		    	<tr>
		    		<td><%=book.getId() %></td>
		    		<td><%=book.getName() %></td>
		    		<td><%=book.getPrice() %>元</td>
		    		<td><%=book.getBookman() %></td>
		    		<td align="center"><a href="/BookShop/servlet/BookDetailControl?bookID=<%=book.getId()%>&categoryID=<%=book.getCategoryId()%>" target="new">查看</a></td>
			    	<td align="center"><a href="<%=url%>?action=2&bookID=<%=book.getId()%>" >修改</a></td>
			    	<td align="center"><a href="<%=url%>?action=3&bookID=<%=book.getId()%>">删除</a></td>
		    	</tr>
		    	
		    	<%}
	    	}%>
		    </table>
	  </center>
  </body>
</html>
