<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>My JSP 'index.jsp' starting page</title>
  </head>
  <body>
   <table align = center  width = "742">
   <tr>
   		<td colspan = "2">
   			<jsp:include flush="true" page="/com/bsw/common/head.jsp"></jsp:include>
 		</td>
   </tr>
   
   <tr>
   		<td width = "25%" >
   			<jsp:include flush="true" page="/com/bsw/book/showCategory.jsp"></jsp:include>
   		</td>
   
   		<td rowspan = "2"  width = "75%" align = "top">
   			<jsp:include flush="true" page="/com/bsw/book/newBookList.jsp"></jsp:include>
   		</td>
   	</tr>
   	<tr>
   		<td width = "25%" align = "left">
   			<jsp:include flush="true" page="/com/bsw/book/showNewBook.jsp"></jsp:include>
   		</td>
   	</tr>
   	
   	<tr>
   		<td colspan = "2">
   			<jsp:include flush="true" page="/com/bsw/common/foot.jsp"></jsp:include>
   		</td>
   	</tr>
   </table>
  </body>
</html>
