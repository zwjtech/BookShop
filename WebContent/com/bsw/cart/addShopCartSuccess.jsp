<%@ page language="java" import="java.util.*,com.bsw.user.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加成功</title>
    
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
.style2 {font-size: 12}
-->
    </style>
  </head>
  
  <body>
     <%
  response.setContentType("text/html;charset=UTF-8");
  User user = (User)session.getAttribute("user"); 
  %>
   <table align = "center"  width = "742" border="0" class="style1">
   		<tr>
   			<td colspan = "5"> <img src="/BookShop/image/logo.JPG" width="741" height="64"></td>
   		</tr>
   		<tr>
   		<td><span class="style1">
        尊敬的<%=user.getName()%>,欢迎您的到来！！ </span></td>
	    <td>
	  		   <a href="/BookShop/servlet/LoginControl">继续购物</a></td>
	    <td>
	   	  <a href="/BookShop/com/bsw/user/userInfo.jsp">个人信息</a></td>
	   	 <td>
	    	 <a href="/BookShop/com/bsw/user/userExit.jsp">退出登录</a>
	    </td>
	    <td>
	    	<a href="/BookShop/servlet/ShopCartControl" target="new">查看购物车</a>
	    </td>
	    </tr>
  </table>  
	<center><p></p>
	<span class="style1">恭喜您，添加成功</span>！
	<p></p>
	<jsp:include flush="true" page="/com/bsw/common/foot.jsp"></jsp:include>
	</center>
  </body>
</html>
