<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>My JSP 'addBook.jsp' starting page</title>
<style type="text/css">
<!--
.style1 {font-size: 12px}
-->
</style>
  </head>
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
  		
  		function checkCate(){
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
  		    	document.addbook.action="/BookShop/servlet/AddNewBookControl";
  			    document.addbook.submit(); 
  		    }
  		}
  </script>
  <body onLoad=get()>
  <%
	  	HashMap cates = (HashMap)request.getAttribute("cates");
	    Set set = cates.keySet();
	    Integer id = new Integer(0);
	    String name = "";
   %>
  <center>
    <form name="addbook" action="/BookShop/servlet/AddNewBookControl" method="post">
    <table border="0" width="600" class="style1">
    <caption align = "center">新增图书</caption>
    <tr>
    <td>图书名称：<input name="name" type="text" onBlur=checkName()></td>
    <td><font color="#ff0000">请输入图书名称</font></td>
    </tr>
    <tr>
    <td>图书类别：<select name="categoryId">
    				<%
    				  Iterator it = set.iterator();
    				  while(it.hasNext()){
    				  	id = (Integer)it.next();
    				  	name = (String)cates.get(id);
    				 %>
			    	<option value="<%=id %>" selected><%=name %></option> 
			    	<%
			    	}
			    	 %>	
			    </select></td>
    <td><font color="#ff0000">请输入图书类别</font></td>
    </tr>
    <tr>
    <td>图书价格：<input type="text" name="price" onBlur=checkCate()></td>
    <td><font color="#ff0000">请输入图书价格</font></td>
    </tr>
    <tr>
    <td>图书作者：<input type="text" name="author" onBlur=checkAuthor()></td>
    <td><font color="#ff0000">请输入图书作者</font></td>
    </tr>
    <tr>
    <td>出版社:&nbsp;&nbsp;&nbsp;<input type="text" name="bookman" onBlur=checkBM()></td>
    <td><font color="#ff0000">请输入图书出版社</font></td>
    </tr>
    <tr>
    <td>入库数量:&nbsp;<input type="text" name="total" onBlur=checkNowTotal()></td>
    <td><font color="#ff0000">请输入入库数量</font></td>
    </tr>
    <tr>
    <td>现有库存:&nbsp;<input type="text" name="nowtotal"></td>
    <td><font color="#ff0000">请输入现有库存</font></td>
    </tr>
    <tr>
    <td>上架时间：<input type="text" name="addTime" value="<%=Calendar.getInstance().getTime().toLocaleString()%>" onBlur=getTime()></td>
    <td><font color="#ff0000">请输入上架时间</font></td>
    </tr>
    <tr>
    <td>图书简介:&nbsp;<textarea name="introduction" wrap="physical"  onBlur=checkInstroduction()></textarea></td>
    <td><font color="#ff0000">请输入图书简介</font></td>
    </tr>
    <tr>
    <td align="center" colspan="2"><input type="submit" name="Submit" value="提交" onClick=fun()>
    &nbsp; &nbsp; &nbsp;<input type="button" name="cancel" value="取消"></td>
    </tr>
    </table>
    </form>
    </center>
  </body>
</html>
