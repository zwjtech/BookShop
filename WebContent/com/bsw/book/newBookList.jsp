<%@ page language="java" import="java.util.*,com.bsw.book.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newBookList.jsp' starting page</title>
    <style type="text/css">
<!--
.style1 {font-size: 12px}
-->
    </style>
  </head>
  <body>
  <span class="style1"></span>  
  <jsp:useBean id="book" class = "com.bsw.book.Book" scope = "page"></jsp:useBean>
  <jsp:useBean id="bookDAO" class = "com.bsw.book.BookDAO" scope = "page"></jsp:useBean>
   <%
    	ArrayList books = (ArrayList)request.getAttribute("newBooks");
    	
    	// 容器不空
    %>
    <center>
    <form name = "newBookForm" action = "" method = "post">	
    <table width = "555" class="style1">
    	<caption><B>图书列表</B></caption>
    	<tr align = "center">
    	<td>图书名称</td>
    	<td>作者</td>
    	<td>出版社</td>
    	<td>单价</td>
    	<td>状态</td>
   <% 
    	Iterator it = books.iterator();
    	while(it.hasNext()){
    		book = (Book)it.next();
     %>
 
     <tr>
     	<td align = "center"><a href = "/BookShop/servlet/BookDetailControl?bookID=<%=book.getId()%>&categoryID=<%=book.getCategoryId() %>" target = "new" ><%=book.getName()%></a></td>
     	<td align = "center"><%=book.getAuthor() %></td>
     	<td align = "center"><%=book.getBookman() %></td>
     	<td align = "center"><%=book.getPrice() %></td>
     	<td align = "center"><%=book.getTotal() %></td>
     </tr>
     <tr><td>&nbsp;</td></tr>
     <%
     	}
      %>
     </table>
     </form>
  </center>
  </body>
</html>
