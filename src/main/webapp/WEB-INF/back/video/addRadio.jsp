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
   	   		text-align: center;
   	   		
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
    <h2><b>添加视频信息-视频管理</b></h2>
  </div>
</div>

<form action='<c:url value="/back/admin/addVideoSub"></c:url>'enctype="multipart/form-data" method="post">
<b style="font-size:large;float: left;">视频标题:</b><input type="text" name="video_title" class="form-control" id="exampleInputEmail1" placeholder="视频标题" style="width: 1000px;display: inline;float: right;"><br /><br />



<div class="form-group" > 

<div style="float: left;">
<b style="font-size:large;float: left;">主讲人:</b>
</div>
<div style="float: right;">
<select class="form-control" name="speaker_id" style="width: 1000px;height: 35px;">
	<option value="">请输入主讲人</option>
   <c:forEach items="${allSpeaker}" var="allSpeaker" varStatus="inco">
   <option value="${allSpeaker.id}" >${allSpeaker.speaker_name}</option>
   </c:forEach>
 </select></div>
</div>
<br /><br />




<div class="form-group" > 
<div style="float: left;">
<b style="font-size:large;float: left;">所属课程:</b></div>
<div style="float: right;">
<select class="form-control" name="course_id" style="width: 1000px;height: 35px;">
	<option value="">请输入课程</option>
   <c:forEach items="${allCourse}" var="allCourse" varStatus="inco">
   <option value="${allCourse.id}" >${allCourse.course_name}</option>
   </c:forEach>
 </select></div>
</div>
<br /><br />





<b style="font-size:large;float: left;">视频时长:</b><input name="video_length" type="text" class="form-control" id="exampleInputEmail1" placeholder="视频时长"style="width: 1000px;display: inline;float: right;"><br /><br />
<b style="font-size:large;float: left;">封面图片:</b><input name="video_image_url" type="text" class="form-control" id="exampleInputEmail1" placeholder="封面图片"style="width: 1000px;display: inline;float: right;"><br /><br />
<b style="font-size:large;float: left;">视频播放地址:</b><input name="video_url" type="text" class="form-control" id="exampleInputEmail1" placeholder="视频播放地址"style="width: 1000px;display: inline;float: right;"><br /><br />
<b style="font-size:large;float: left;">视频简介:</b>

<textarea name="video_descr" cols="140" rows="5" style="float: right;"></textarea><br />
<br />
<div class="submit">
<button type="submit" class="btn btn-primary">确定</button>

 <a class="btn btn-default" href="javascript:history.go(-1)">返回</a></div>

</form>
	</body>
</html>

