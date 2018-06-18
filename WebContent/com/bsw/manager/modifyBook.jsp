<%@ page language="java" import="java.util.*,com.bsw.book.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifBook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  	function submitModify(bookID){
  		document.modifyBook.action = "/BookShop/servlet/ModifyBookControl?bookID="+bookID;
  	}
  </script>
  <script type="text/javascript">
  		function checkName(){
  			if(document.addbook.name.value.length==0){
  				alert("请输入图书名称！");
  				
  			}else if(!isNaN(document.addbook.name.value)){
  				alert("图书名称为字符型！");
  				
  			}else if(document.addbook.name.value.length>32){
				alert("图书名称必须小于等于32位！"); 
				document.addbook.name.select();
  				document.addbook.name.focus(); 			
  			}
  		}
  		
  		function checkPrice(){
  		    if(document.addbook.price.value.length==0){
  				alert("请输入图书价格！");
  				
  				
  			}else if(isNaN(document.addbook.price.value)){
  				alert("图书价格必须是浮点型数值！");
  			
  			}else if(document.addbook.price.value.length>4){
  				alert("图书价格必须小于5位数！");
  				document.addbook.price.select();
  				document.addbook.price.focus();
  			}
  		}
  		
  		function checkAuthor(){
  			if(document.addbook.author.value.length==0){
  			    alert("请输入图书作者！");
  			  
  			}else if(!isNaN(document.addbook.author.value)){
  				alert("图书作者名必须是字符型！");
  				
  			}else if(document.addbook.author.value.length>16){
  				alert("图书作者姓名长度不得长于16个字符！");
  			    document.addbook.author.select();
  			    document.addbook.author.focus();
  			}
  		}
  		
  		function checkBM(){
  			if(document.addbook.bookman.value.length==0){
  			    alert("请输入图书出版社！");
  			    
  			}else if(!isNaN(document.addbook.bookman.value)){
  				alert("图书出版社名必须是字符型！");
  				
  			}else if(document.addbook.bookman.value.length>32){
  				alert("图书出版社姓名长度不得长于32个字符！");
  			    document.addbook.bookman.select();
  			    document.addbook.bookman.focus();
  			}
  		}
  		
  		function checkTotal(){
  		    if(document.addbook.total.value.length==0){
  				alert("请输入图书入库数量！");
  				
  			}else if(isNaN(document.addbook.total.value)){
  				alert("图书入库数量必须是数值！");
  				
  				
  			}else if(document.addbook.total.value.length>7){
  				alert("图书入库数量必须小于7位数！");
  				document.addbook.total.select();
  				document.addbook.total.focus();
  			}
  		}
  		
  		function checkNowTotal(){
  		    if(document.addbook.nowtotal.value.length==0){
  				alert("请输入现有库存数量！");
  				
  				
  			}else if(isNaN(document.addbook.nowtotal.value)){
  				alert("现有库存数量必须是数值！");
  				
  				
  			}else if(document.addbook.nowtotal.value.length>7){
  				alert("现有库存数量必须小于7位数！");
  				document.addbook.nowtotal.select();
  				document.addbook.nowtotal.focus();
  			}
  		}
  		
  		function checkInstroduction(){
  			if(document.addbook.instroduction.value.length==0){
  			    alert("请输入图书简介！");
  			    
  			}else if(!isNaN(document.addbook.instroduction.value)){
  				alert("图书简介必须是字符型！");
  				
  			}else if(document.addbook.instroduction.value.length>255){
  				alert("图书简介长度不得长于255个字符！");
  			    document.addbook.instroduction.select();
  			    document.addbook.instroduction.focus();
  			}
  		}
  		
  		
  		function get(){
  		    document.addbook.name.select();
  		    document.addbook.name.focus();
  		}
  		
  		function fun(){
  		fm=document.addbook.name.value.length==0||document.addbook.price.value.length==0||
  	       document.addbook.author.value.length==0||document.addbook.bookman.value.length==0||
  	       document.addbook.total.value.length==0||document.addbook.nowtotal.value.length==0||
  	       document.addbook.instroduction.value.length==0;
  		    if(fm){
  		     	alert("您还有没有输入的数据!");
  		    }else{
  		    	document.modifyBook.action = "/BookShop/servlet/ModifyBookControl?bookID="+bookID;
  			   // document.addbook.submit(); 
  		    }
  		}
  </script>
    <style type="text/css">
<!--
.style1 {font-size: 12px}
-->
</style>
  <body>
  <%
 
  Book book = (Book)request.getAttribute("book"); 
      HashMap cates = (HashMap)request.getAttribute("cates");
      Integer id ;
      String name = "";
    %>
    <center>
    <form name="modifyBook" action="" method="post" class="style1">
    <table border="0" width="600"onLoad="get()" class="style1">
    <tr>
    <th colspan="2"><center><b><h3>修改图书</h3></b></center></th>
    </tr>
    <tr>
    <td align = "right">图书名称：</td>
    <td align = "left"><input name="name" type="text" value = "<%=book.getName()%>" onBlur=checkName()></td>
    <td><font color="#ff0000">请输入图书名称</font></td>
    </tr>
    <%
    	
     %>
    <tr>
    <td align = "right">图书类别：</td>
    <td align = "left"><select name="categoryId">
			    	<%
    					Set set = cates.keySet();
    					Iterator it = set.iterator();
    					while(it.hasNext()){
    						id = (Integer)it.next();
    						int id1 = id.intValue();
    						name = (String)cates.get(id);
    				%>
    					<option value = "<%=id%>" 
    						<%if(id1 == book.getCategoryId()){%>
    						   selected
    						<%
    						} 
    						%>
    					><%=name%></option>
    				<%
    					}
    				 %>
			    </select></td>
    <td><font color="#ff0000">请输入图书类别</font></td>
    </tr>
    <tr>
    <td align = "right">图书价格：</td>
    <td align = "left"><input type="text" name="price" value = "<%=book.getPrice()%>" onBlur=checkPrice()></td>
    <td><font color="#ff0000">请输入图书价格</font></td>
    </tr>
    
    <tr>
    <td align = "right">图书作者：</td>
    <td align = "left"><input type="text" name="author" value = "<%=book.getAuthor()%>" onBlur=checkAuthor()></td>
    <td><font color="#ff0000">请输入图书作者</font></td>
    </tr>
    
    <tr>
    <td align = "right">出版社：</td>
    <td align = "left"><input type="text" name="bookman" value = "<%=book.getBookman() %>" onBlur=checkBM()></td>
    <td><font color="#ff0000">请输入图书出版社</font></td>
    </tr>
    
    <tr>
    <td align = "right">入库数量：</td>
    <td align = "left"><input type="text" name="total" value = "<%=book.getTotal() %>" onBlur=checkTotal()></td>
    <td><font color="#ff0000">请输入入库数量</font></td>
    </tr>
    
    
    <tr>
    <td align = "right">现有库存：</td>
	<td align = "left"><input type="text" name="nowtotal" value = "<%=book.getCurrentNum() %>" onBlur=checkNowTotal() > </td>
    <td><font color="#ff0000">请输入现有库存</font></td>
    </tr>
    
    <tr>
    <td align = "right">上架时间：</td>
    <td align = "left"><input type="text" name="addTime" value="<%=book.getAddTime()%>"></td>
    <td><font color="#ff0000">请输入上架时间</font></td>
    </tr>
    
    
    <tr>
    <td align = "right">图书简介：</td>
	<td align = "left"><textarea name="introduction" wrap="physical" checkInstroduction()><%=book.getIntroduction()%></textarea></td>
    <td><font color="#ff0000">请输入图书简介</font></td>
    </tr>
    
    <tr>
    <td align="center" colspan="2"><input type="submit" name="Submit" value="提交" onClick = "submitModify(<%=book.getId()%>)">
    &nbsp; &nbsp; &nbsp;<input type="button" name="cancel" value="取消"></td>
    </tr>
    </table>
    </form>
    </center>
  </body>
</html>
