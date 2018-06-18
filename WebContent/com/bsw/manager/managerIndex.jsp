<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<html>
  <head>
   
    <title>My JSP 'managerIndex.jsp' starting page</title>
    
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
<body class="style1">
<center>
	<table>
		<tr>
			<td>
				<%@include file="/com/bsw/common/head.jsp"%>
			</td>
		</tr>
		<tr>
			<td>
				<%@include file="/com/bsw/user/exitUserSystem.jsp"%>
			</td>
		</tr>
		<tr>
			<td>
				<center><%@include file="/com/bsw/common/foot.jsp"%></center>
			</td>
		</tr>
	</table>
</center>
</body>
</html>
