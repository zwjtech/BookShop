<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URL"%>
<%@ page language="java"
	import="java.util.*,com.bsw.book.*,com.bsw.user.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'bookList.jsp' starting page</title>
   <style type="text/css">
  		a{text-decoration:none;}
  		a:link{color:#900;}
  		a:visited{color:#800080;}
  		a:hover,a:active,a:focus{color:#c00}
       .style1 {font-size: 12px}
   </style>
	<script language="JavaScript" type="text/JavaScript">
	function checkNum(num) { //v2.0
	 if(num<=0){
	 alert("没有足够的库存！");
	 }
	}
	</script>
	</head>
	<body>
		<jsp:useBean id="user" class="com.bsw.user.User"></jsp:useBean>

		<%!String userName;%>

		<%-- 设置响应页面的编码和文档类型--%>
		<%
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			user = (User) session.getAttribute("user");

			userName = user.getName();
		%>
		<jsp:useBean id="book" class="com.bsw.book.Book" scope="page"></jsp:useBean>
		<table align="center" width="742" border="0">
			<tr>
				<td colspan="5">
					<img src="/BookShop/image/logo.JPG" width="741" height="64">
				</td>
			</tr>
			<tr>
				<td>
					<span class="style1"> 尊敬的<%=userName%>,欢迎您的到来！！ </span>
				</td>
				<td>
					<a href="/BookShop/servlet/LoginControl" class="style1">用户首页</a>
				</td>
				<td>
					<a href="/BookShop/com/bsw/user/userInfo.jsp" class="style1">个人信息</a>
				</td>
				<td>
					<a href="/BookShop/com/bsw/user/userExit.jsp" class="style1">退出登录</a>
				</td>
				<td>
					<a href="/BookShop/servlet/ShopCartControl" target="new"
						class="style1">查看购物车</a>
				</td>
			</tr>
		</table>
		<form name="addShoppingCart" action="" method="post">
			<center>
				<font size="5"><b><strong>图书列表</strong><B>
				</font>
			</center>
			<br>
			<br>
			<table border="0" width="740" align="center">
				<tr>
					<td>
						<div align="center" class="style1">
							图书名称
						</div>
					</td>
					<td>
						<div align="center" class="style1">
							作者
						</div>
					</td>
					<td>
						<div align="center" class="style1">
							出版社
						</div>
					</td>
					<td>
						<div align="center" class="style1">
							单价
						</div>
					</td>
					<td>
						<div align="center" class="style1">
							状态
						</div>
					</td>
					<td>
						<div align="center" class="style1">
							加入购物车
						</div>
					</td>
				</tr>
				<%
					ArrayList books = (ArrayList) request.getAttribute("books");
					Iterator it = books.iterator();
					while (it.hasNext()) {
						book = (Book) it.next();
						String bookname = URLEncoder.encode(book.getName(),"utf-8");
						String href = "/BookShop/com/bsw/cart/addShopCart.jsp?bookName="
						+ bookname
						+ "&price="
						+ book.getPrice()
						+ "&bookID=" + book.getId();
						if (book.getCurrentNum() <= 0) {
							href = "/BookShop/servlet/LoginControl";
						}
				%>
				<tr align="center" class="style1">
					<td>
						<%=book.getName()%>
					</td>
					<td>
						<%=book.getAuthor()%>
					</td>
					<td>
						<%=book.getBookman()%>
					</td>
					<td>
						<%=book.getPrice()%>
					</td>
					<td>
						<%=book.getCurrentNum()%>
					</td>
					<td>
						<a href=<%=href%> class="style1"
							onClick="checkNum(<%=book.getCurrentNum()%>)">加入购物车</a>
					</td>
				</tr>
				<%
				}
				%>
			</table>
		</form>
	</body>
</html>
