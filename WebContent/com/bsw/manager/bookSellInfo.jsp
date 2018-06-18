<%@ page language="java" import="java.util.*,com.bsw.traderecord.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bookSellInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style type="text/css">
<!--
.style1 {font-size: 12px}
-->
</style>
  <body>
     <center>
     <font size="5">图书销售信息</font>
     <table border=0 width=600 class="style1">
	     <tr>
	     	<td align="center">编号</td>
	     	<td align="center">用户ID</td>
	     	<td align="center">图书ID</td>
	     	<td align="center">数量</td>
	     	<td align="center">总价</td>
	     </tr>
	    <%
	      HashMap hashMap=(HashMap)request.getAttribute("hashMap");
	      Set set=hashMap.keySet();
	      Iterator iter=set.iterator();
	      while(iter.hasNext()){
	      TradeRecord record=(TradeRecord)iter.next();
	      Double price1= (Double)hashMap.get(record);
	      double price = price1.doubleValue();
	    %>
	     <tr>
	     	<td align="center"><%=record.getId() %></td>
	     	<td align="center"><%=record.getUserId() %></td>
	     	<td align="center"><%=record.getBookId() %></td>
	     	<td align="center"><%=record.getTradeNum() %></td>
	     	<td align="center"><%=price %></td>
	     <%} %>
	     </tr>
     </table>
     </center>
  </body>
</html>
