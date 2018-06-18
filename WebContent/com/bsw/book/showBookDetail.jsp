<%@ page language="java" import="java.util.*,com.bsw.book.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>查看图书详细信息</title>

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
		a:link{color:#009;}
		a:visited{color:#800080;}
		a:hover,a:active,a:focus{color:#c00;
		}

  .style1 {font-size: 12px}
        </style>
	</head>
	<body>
	<center>
	<jsp:include flush="true" page="/com/bsw/common/head.jsp"></jsp:include>
	</center>
	<% request.setCharacterEncoding("UTF-8");
	   response.setCharacterEncoding("UTF-8");
		Book book = (Book)request.getAttribute("book");
     %>
	<table align = center  width = "742" border = "1" class="style1">
		
		<tr>
			<td colspan = "4" align = "center"><b>图书详尽信息<b></td>
		</tr>
			<tr>
				<td>
					图书名称：
				</td>
				<td>
					<%=book.getName()%>
				</td>
				<td>
					类别
				</td>
				<td>
					<%=request.getAttribute("categoryName") %>
				</td>
			</tr>
			<tr>
				<td>
					单价
				</td>
				<td>
					<%=book.getPrice() %>元
				</td>
				<td>
					作者
				</td>
				<td>
					<%=book.getAuthor()%>
				</td>
			</tr>
			<tr>
				<td>
					出版社
				</td>
				<td>
					<%=book.getBookman() %>
				</td>
				<td>
					入库数
				</td>
				<td>
					<%=book.getTotal() %>
				</td>
			</tr>
			<tr>
				<td>
					现有库存
				</td>
				<td>
					<%=book.getCurrentNum() %>
				</td>
				<td>
					上架时间
				</td>
				<td>
					<%=book.getAddTime() %>
				</td>
			</tr>
			<tr>
				<td>
					图书简介
				</td>
				<td colspan="3">
					输入图书简介
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<center>
						<a href="javascript:window.close()">关闭窗口</a>
					</center>
				</td>
				<td colspan="2">
					<center>
						<a href="/BookShop/com/bsw/user/userLogin.jsp"> 购物请登录</a>
				</td>
			</tr>
		</table>
	</body>
</html>
