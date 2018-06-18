<%@ page language="java" import="java.util.*,com.bsw.user.*,java.net.URLDecoder" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>My JSP 'addShoppingBag.jsp' starting page</title>
  <style type="text/css">
  		a{text-decoration:none;}
  		a:link{color:#900;}
  		a:visited{color:#800080;}
  		a:hover,a:active,a:focus{color:#c00}
  .style1 {font-size: 12px}
  </style>
  </head>
  <script type="text/javascript">
  	function ChangeSum(price){
  		var num = document.addShoppingBag.total.value;
  		if(num.length == 0){
  			document.addShoppingBag.totalprice.value = "";
  		} else if(isNaN(num)){
 			alert("数量必需是整数！");
 			document.addShoppingBag.totalprice.value = "";
 			document.addShoppingBag.total.select();
  			document.addShoppingBag.total.focus();
  			
 		} else if(num <= 0){
 			alert("数量必须大于零！");
 			document.addShoppingBag.totalprice.value = "";
 			document.addShoppingBag.total.select();
  			document.addShoppingBag.total.focus();
  		
 		} else {
 			document.addShoppingBag.totalprice.value = num * price;
 		}
 	
  	}
   function SubmitItem(bookID){
   		num = -document.addShoppingBag.total.value;
 		document.addShoppingBag.action="/BookShop/servlet/AddToShopCartControl?bookID="+bookID +"&num="+num;
 		document.addShoppingBag.submit();
   }
  </script>
  <body>
  <%
  response.setContentType("text/html;charset=UTF-8");
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
  User user = (User)session.getAttribute("user"); 
  %>
  <%
     	String bookName = request.getParameter("bookName");
     	String price = request.getParameter("price");
     	//bookName = new String(bookName.getBytes("ISO-8859-1"),"UTF-8");
     	bookName = URLDecoder.decode(bookName, "utf-8");
   %>
   <table align = "center"  width = "742" border="0" class="style1">
   		<tr>
   			<td colspan = "5"> <img src="/BookShop/image/logo.JPG" width="741" height="64"></td>
   		</tr>
   		<tr>
   		<td><span class="style1">
        尊敬的<%=user.getName()%>,欢迎您的到来！！ </span></td>
	    <td>
	  		   <a href="/BookShop/servlet/LoginControl">用户首页</a></td>
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
     <form name="addShoppingBag" action="" method="post">
     <center><b><font size="5">图书加入购物车</font></b></center>
     <br>
     <table border="0" width="854" height="90" class="style1" align="center">
     	 <tr>
     	 	<th align="center">图书名称</th>
     	 	<th align="center">单价</th>
     	 	<th align="center">数量</th>
     	 	<th align="center">总价</th>
     	 </tr>
     	 <tr>
     	 	<td><center> <%=bookName %> </center></td>
     	 	<td><center> <%=price%> </center></td>
     	 	<td><center><input type="text" name="total" size="4" value = "1" onBlur = "ChangeSum(<%=price%>)">本</center></td>
     	 	<td><center><input type="text" name="totalprice" size="4" value = <%=price%> >元</center></td>
     	 </tr>
     	 <tr>
     	 	<td colspan="4" align="right"><input name="Check" type="button" class="style1" onClick = "SubmitItem(<%=request.getParameter("bookID")%>)" value="确定"></td>
     	 </tr>
     </table>
  </body>
</html>
