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
   
  </head>
  	<body>
  		<div class="jumbotron">
  <div class="container">
    <h2><b>编辑主讲人-主讲人管理</b></h2>
  </div>
</div>

<form action="${pageContext.request.contextPath}/back/admin/editSpeakerSub" method="post">
<input type="hidden" name="s.id" value="${speaker.id}">

<b style="font-size:large;float: left;">名字:</b><input value="${speaker.speaker_name}" name="s.speaker_name" type="text" class="form-control" id="exampleInputEmail1" placeholder="视频标题" style="width: 1000px;display: inline;float: right;"><br /><br />
<b style="font-size:large;float: left;">职业:</b><input value="${speaker.speaker_job}" name="s.speaker_job" type="text" class="form-control" id="exampleInputEmail1" placeholder="主讲人"style="width: 1000px;display: inline;float: right;"><br /><br />
<b style="font-size:large;float: left;">头像图片:</b><input value="${speaker.speaker_head_url}" type="text" name="s.speaker_head_url" class="form-control" id="exampleInputEmail1" placeholder="所属课程"style="width: 1000px;display: inline;float: right;"><br /><br />
<b style="font-size:large; float: left;">简介:</b><br />

<textarea name="s.speaker_descr" cols="140" rows="5" style="float: right;">${speaker.speaker_descr}</textarea><br />
<br /><br />
<div class="submit">
	
<button type="submit" class="btn btn-primary">保存</button>

 <a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
</div>
</form>
	</body>
</html>

