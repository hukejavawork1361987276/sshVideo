<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Hello World</title>
    <link href='<c:url value="/css/bootstrap.min.css"></c:url>' rel="stylesheet">
    <script src='<c:url value="/js/jquery-1.12.4.min.js"></c:url>'></script>
    <script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
   <style>
  
   body{
   	margin:0 auto;
   	width: 1200px;
   	
   }
   .submit{
   	float: left;
   	padding-left: 300px;
   	padding-top: 10px;
   }
   </style>
   <script type="text/javascript" ></script>
   
   
   
  </head>
  
  
  	<body>
  <div class="jumbotron">
  <div class="container">
    <h2><b>添加课程</b></h2>
  </div>
</div>

<form action='<c:url value="/back/admin/addCourseSub"></c:url>' method="post">
<b style="font-size:large;float: left;">所属学科:</b><input type="text" name="c.subject.subject_name" class="form-control" id="exampleInputEmail1" placeholder="请输入" style="width: 1000px;display: inline;float: right;"><br /><br />
<b style="font-size:large;float: left;">标题:</b><input type="text" name="c.course_name" class="form-control" id="exampleInputEmail1" placeholder="请输入"style="width: 1000px;display: inline;float: right;"><br /><br />
<b style="font-size:large; float: left;">简介:</b><br />

<textarea  name="c.course_descr" cols="140" rows="5" style="float: right;"></textarea><br />
<br /><br />
<div class="submit">
	
<button type="submit" class="btn btn-primary">保存</button>
<a href="javascript:history.go(-1)"><button type="button" class="btn btn-primary">返回</button></a>

</div>
</form>
	</body>
</html>
