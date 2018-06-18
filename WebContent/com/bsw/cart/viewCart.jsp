<%@ page language="java" import="java.util.*,com.bsw.shopcart.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewCart.jsp' starting page</title>
    
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
  </head>
  
  <body>
  <jsp:useBean id="shopCart" class = "com.bsw.shopcart.ShopCart"></jsp:useBean>
  <center>购物车</center>
    <a href="javascript:window.close()">关闭窗口</a>
    <form action="/BookShop/servlet/ChargeControl" name="form1" method="post">
  <table align="center" border="1" bordercolor="#873827" cellspacing="0" class="style1">
  	<tr align="center">
		<td width="100">书名</td><td width="100">数量</td>
		<td width="100">单价</td><td width="100">总价</td>
		<td width="100">修改</td><td width="100">删除</td>
  	</tr>
  	<%
  		ArrayList bookList = (ArrayList)request.getAttribute("cartList"); 
  		Iterator it = bookList.iterator();
  		while(it.hasNext()){
  			shopCart = (ShopCart)it.next();
  			double total = shopCart.getPrice()*shopCart.getNum();
  	%>
  		<tr align="center">
  		<td><%=shopCart.getBookName() %></td><td><%=shopCart.getNum() %></td><td><%=shopCart.getPrice() %></td><td><%=total%></td>
  		<td><a href="/BookShop/servlet/ModifyShopCartItemControl?id=<%=shopCart.getId() %>">修改</a></td>
  		<td><a href="/BookShop/servlet/DeleteShopCartItemControl?id=<%=shopCart.getId() %>&bookId=<%=shopCart.getBookID() %>&num=<%=shopCart.getNum() %>">删除</a></td>
  		</tr>
  	<%
  		}
  	%>
  </table>
  
  <p></p>
  <center>  
  	<input type="submit" name="charge" value="结帐">
  </center>
	</form>
  </body>
</html>
