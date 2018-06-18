<%@ page language="java" import="java.util.*,com.bsw.shopcart.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyShopCart.jsp' starting page</title>
    
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
    <script type="text/javascript">
  	function ChangeSum(price){
  	
	  	var num = document.modifyForm.num.value;
  		if(num.length == 0){
  			document.modifyForm.sum.value = "";
  		} else if(isNaN(num)){
 			alert("数量必需是整数！");
 			document.modifyForm.sum.value = "";
 			document.modifyForm.num.select();
  			document.modifyForm.num.focus();
  			
 		} else if(num <= 0){
 			alert("数量必须大于零！");
 			document.modifyForm.sum.value = "";
 			document.modifyForm.num.select();
  			document.modifyForm.num.focus();
  		
 		} else {
 			document.modifyForm.sum.value = num * price;
 		}
 	
  	}
  	function getFocus(){
  		document.modifyForm.num.select();	
  		document.modifyForm.num.fucus();
  	}
  	function modifyItem(id,beforeNum,bookId){
  		var num1 = document.modifyForm.num.value;
  		document.modifyForm.action="/BookShop/servlet/ChangeShopCartItemControl?id="+id +"&num="+num1+"&beforeNum="+beforeNum+"&bookId="+bookId;
  	}
  </script>
  <body onLoad = "getFocus()" bgcolor="white">
    <%
   		ShopCart shopcart = (ShopCart)request.getAttribute("shopcart");
     %>
     <form name = "modifyForm" method = "post">
     <center><h2>修改购物车</h2></center>
     	<table align="center" border="1" bordercolor="#637362" cellspacing="1" class="style1">
     		<tr align="center">
				<td width="200">书名</td><td width="50">数量</td><td width="50">单价</td>
				<td width="50">总价</td>
	  		</tr>
			<tr align="center">
				<td width="200"><%=shopcart.getBookName() %></td>
				
				<td width="50">
					<input type = "text" name = "num" value = "<%=shopcart.getNum() %>" onBlur = "ChangeSum(<%=shopcart.getPrice() %>)" size="5">
				</td>
				<td width="50"><%=shopcart.getPrice() %> </td>
				
				<td width="50">
					<input type = "text" name = "sum" value = "<%=shopcart.getNum()*shopcart.getPrice() %>" disabled size="5">
				</td>
	  		</tr>
     	</table>
     	<center><input type="submit" name = "Submit" value="确定" onClick="modifyItem(<%=shopcart.getId() %>,<%=shopcart.getNum() %>,<%=shopcart.getBookID() %>)"></center>
     </form>
  </body>
</html>
