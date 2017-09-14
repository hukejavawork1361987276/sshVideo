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
    <title>menu</title>
    <link href='<c:url value="/css/bootstrap.min.css"></c:url>' rel="stylesheet">
    <script src='<c:url value="/js/jquery-1.12.4.min.js"></c:url>'></script>
    <script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
   
   <style>
   	
   	.context{
   		
   		margin: 0 auto;
   		width: 1200px;
 			height: 1000px;
   	}

   </style>
   
   <script type="text/javascript">
   
	   
 function  zhong(is){
	
			$(is).toggleClass("active");
			
			
   };
		 
	
    
 
   </script>
  </head>
  <body>
    
   
    
    <div class="linka">
    <nav class=" navbar navbar-inverse">
  <div class="container">
   
   
   <ul class="nav navbar-nav">
            <li  ><a href="" > <b style="font-size: larger;">视频管理系统</b></a></li>
            <li ${param.fromJsp=="video"?"class='active'":""}><a  href='<c:url value="/back/admin/videoList"></c:url>' target="pageBox">视频管理</a></li>
            <li ${param.fromJsp=="speaker"?"class='active'":""}><a  href='<c:url value="/back/admin/speakerList"></c:url>' target="pageBox">主讲人管理</a></li>
            <li ${param.fromJsp=="course"?"class='active'":""}><a  href='<c:url value="/vedio/courseList.action"></c:url>' target="pageBox">课程管理</a></li>
            <li ${param.fromJsp=="statistics"?"class='active'":""}><a  href='<c:url value="/vedio/tongji.action"></c:url>'>统计分析</a></li>
     </ul>
     
     <div style="float: right;">
       <ul class="nav navbar-nav">
            <li id="right"><a href="#">admin<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></li>
          </ul>
          </div>
 	 </div>
	</nav>
	</div>
                                                                                                      


<!-- <div class="embed-responsive embed-responsive-16by9">
  			<iframe class="embed-responsive-item" src="http://www.baidu.com" name="pageBox"></iframe>
		</div> -->

  </body>
</html>