<%@ page language="java" import="java.util.*,com.bsw.user.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <% User user = (User)session.getAttribute("user"); %>
  <center>
  <table align = "center"  width = "742" border="0">
   		<tr>
   			<td colspan = "5"> <img src="/BookShop/image/logo.JPG" width="741" height="64"></td>
   		</tr>
   		<tr>
   		<td><span class="style1">
        尊敬的<%=user.getName()%>,欢迎您的到来！！ </span></td>
	    <td>
	  		   <a href="/BookShop/servlet/LoginControl" class="style1">用户首页</a></td>
	    <td>
	   	  <a href="com/bsw/user/userInfo.jsp" class="style1">个人信息</a></td>
	   	 <td>
	    	 <a href="com/bsw/user/userExit.jsp" class="style1">退出登录</a>
	    </td>
	    <td>
	    	<a href="/BookShop/servlet/ShopCartControl" target="new" class="style1">查看购物车</a>
	    </td>
	    </tr>
	</table>   
  <h2>用户详细信息</h2>
  <table border=0 width="743" cellpadding="10" class="style1">
  <center>
	  <tr>
	  	<td align="right">用户名：</td>
	  	<td align="left"><%=user.getName() %></td>
	  	<td align="right">真实姓名：</td>
	  	<td align="left"><%=user.getRealName() %></td>
	  </tr>
	   <tr>
	  	<td align="right">性别：</td>
	  	<td align="left"><%=user.getGender()%></td>
	  	<td align="right">年龄：</td>
	  	<td align="left"><%=user.getAge() %></td>
	  </tr>
	   <tr>
	  	<td align="right"> Email：</td>
	  	<td align="left"><%=user.getEmail() %></td>
	  	<td align="right"> 联系方式：</td>
	  	<td align="left"><%=user.getPhone() %></td>
	  </tr>
	   <tr>
	  	<td align="right"> 联系地址：</td>
	  	<td align="left"> <%=user.getAddress() %></td>
	  	<td align="right">注册时间：</td>
	  	<td align="left"><%=user.getRegisterTime() %></td>
	  </tr>
	  </table>
	  
  </center>
  </body>
  <jsp:include flush="true" page="/com/bsw/common/foot.jsp"></jsp:include>
</html>
