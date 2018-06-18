<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<style type="text/css">
<!--
.style1 {font-size: 12px}
-->
</style>

  <script type="text/javascript">
  
  	function userLogin() {
	  	if(document.user.userName.value.length==0||document.user.pwd.value.length==0){
	  		alert("请输入用户名和密码！");
	  	}else{
	  		document.user.action = "/BookShop/servlet/LoginControl";
	  		document.user.submit();
	  	}
  		
  	}
  	function registerUser(){
		document.user.action = "/BookShop/com/bsw/user/regist.jsp";
	  	document.user.submit();	
  	}
  </script>
  
</head>

<body>
<center>
<jsp:include flush="true" page="/com/bsw/common/head.jsp"></jsp:include>
</center>
<form name="user" method="post" action="">
<table align="center" width="660" height="400" >
	<tr>
		<td>
			<table width="321" cellpadding="0" cellspacing="0" bordercolor="#dbd8d1" border="1">
				<tr height="8">
					<td background="/BookShop/image/m1.jpg">&nbsp;<span class="style1">登录网上书店</span></td>
				</tr>
				<tr>
					<td height="150">
						<br>
						<span class="style1">已注册用户请从这里登录</span>
						<p>
						<div align="right">
						<span class="style1">用户名：</span>
						<input type="text" name="userName">&nbsp;&nbsp;<br><br>
						<span class="style1">密码</span>：<input type="password" name="pwd"> &nbsp;<p>
						<center>
							<input type="button" name="login" value="登录" onclick="userLogin()" style="background-color:#212312;background:background-image; background-image:url(/BookShop/image/button.png)">
						</center>
						<p>
						<hr size="1" width="250" align="center">
						</div>
						<p>
						<div class="style1">
						有任何疑问请<a href="http://localhost:8080/BookShop/">联系我们</a>						</div>

					</td>
				</tr>
				<tr><td height="60"></td></tr>
				<tr>
					<td background="/BookShop/image/end.jpg" height="13px"></td>
				</tr>
			</table>
		</td>
		<td>
			<table width="321" cellpadding="0" cellspacing="0" bordercolor="#dbd8d1" border="1">
				<tr>
					<td background="/BookShop/image/m1.jpg" height="8px">&nbsp;<span class="style1">新用户注册</span></td>
				</tr>
				<tr>
					<td height="150"><br>
						&nbsp;&nbsp;<span class="style1">&nbsp;新用户请注册新帐户 </span>
						<p>
						  &nbsp;&nbsp;&nbsp;<span class="style1">立刻享受
						  </span>
						<div>
							<ul>
								<li class="style1">多种商品的选择，假一罚二</li>
								<li class="style1">最优惠的价格，物超所值</li>
								<li class="style1">货到付款，零风险购物</li>
								<li class="style1">"最以客户为中心"，的服务和客户体验</li>
							</ul>
							<div align="right"><input name="register" type="button" value="新用户注册"  style="background-color:#212312;background:background-image; background-image:url(/BookShop/image/button.png)" onclick="registerUser()">&nbsp;&nbsp;</div>
						</div>
						<p></p>
					</td>
				</tr>
				<tr><td height="60"></td></tr>
				<tr>
					<td background="/BookShop/image/end.jpg"  height="13px"></td>
				</tr>
			</table>
		</td>
</table>
</form>
<center>
<jsp:include flush="true" page="/com/bsw/common/foot.jsp"></jsp:include>
</center>
</body>
</html>
