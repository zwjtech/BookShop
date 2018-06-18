<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="com.bsw.book.Book"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showNewBook.jsp' starting page</title>
  </head>
      <style type="text/css">
<!--
.style1 {font-size: 12px}
-->
</style>
  <script type="text/javascript">
  	function showBook(book){
  		document.showCategory.action = "/BookShop/servlet/BookDetailControl?bookID="+bookID;
  		document.showCategory.submit();
  	}
  	
  </script>
  <body>
  <jsp:useBean id="bookDAO" class = "com.bsw.book.BookDAO" scope = "page"></jsp:useBean>
  <jsp:useBean id="book" class = "com.bsw.book.Book" scope = "page"></jsp:useBean>
  <center>
  <form name = "showNewBook" action="" method = "post">
  	<table align = "center" width = "185" class="style1">
   		<tr bgcolor = "#dbd8d1">
   			<td  align = "center"> <font size = "2">新书上架</font></td>
   		</tr>
   	<%
   		ArrayList books = (ArrayList)request.getAttribute("newBooksName");
   		if(books.isEmpty()){
   	 %>
   		<font size = 3 align = "center">暂时没有新书，谢谢合作</font>
   	<%
   		} else {
   			Iterator it = books.iterator();
   			while(it.hasNext()){
   				book = (Book)it.next();
   	 %>
  	<tr>
  		
  		<td align = "left"><a href = "/BookShop/servlet/BookDetailControl?bookID=<%=book.getId()%>&categoryID=<%=book.getCategoryId() %>" target = "new" ><%=book.getName()%></a></td>
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
