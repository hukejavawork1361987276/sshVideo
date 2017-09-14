<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Hello World</title>
    <link href='<c:url value="/css/bootstrap.min.css"></c:url>' rel="stylesheet">
    <script src='<c:url value="/js/jquery-1.12.4.min.js"></c:url>'></script>
    <script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
    
    <script src='<c:url value="js/jquery.validate.min.js"></c:url>'></script>
    <script src='<c:url value="/js/messages_zh.min.js"></c:url>'></script>
   
   <style>
   	body{ text-align:center} 
   
   
   	
   	.form-control{
   		height: 40px;
   		border-color: green;
   	}
   	.geshi{
   		
   		padding-top: 300px;
   	}
   </style>
  

   <script type="text/javascript">
   $(function () {

   	$("#form1").validate({
   		rules:{
   			name:{
   				required:true
   			},
   			password:{
   				required:true
   			}
   			
   		},
   		messages:{
   		name:{	required:"用户名不能为空"		
   				},
   			
   		password:{	required:"密码不能为空"
   				
   				}
   		}/* ,
   		errorPlacement: function(error, element) { //错误信息位置设置方法
   			error.appendTo( element.parent().next() ); //这里的element是录入数据的对象
   			} */
   	});
   	
   });

   
   </script>
  </head>
  <body>
   
 <div class="geshi">
     <form id="form1" class="form-inline" action='<c:url value="/back/admin/login"></c:url>'>	
  	<div class="form-group" >  
  		<img alt=""src='<c:url value="/img/logo.png"></c:url>'/><br />
  		<input type="text" class="form-control" id="exampleInputEmail3" placeholder="用户名" size="36"  name="name">
  		<br /><br />
    <input type="password" class="form-control" id="exampleInputPassword3" placeholder="登录密码" size="36" name="password">
  	<br /><br />
 	<div >
	<button  type="submit" class="btn-block btn btn-success" >登录</button>
	</div>
  	</div>
</form>
</div>
    
      
      
  
      
    
  </body>
</html>
