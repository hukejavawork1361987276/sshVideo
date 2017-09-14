<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
                 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <jsp:include page="/WEB-INF/back/menu.jsp">
   <jsp:param value="speaker" name="fromJsp"/>  </jsp:include>              
  <%@taglib prefix="fy" uri="http://zhiyou100.com/common/"%>  
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
   	   	
   .collapse navbar-collapse{
   		text-align:center;
   		margin: auto;
   		padding-left: 300px;
   	}
   	
.search{
	
	float: right;
}
   </style>
   
  </head>
  	<body>
  			<div class="jumbotron">
  <div class="container">
    <h2><b>主讲人列表-主讲人管理</b></h2>
  </div>
</div>




<div>
  		
 <a href='<c:url value="/vedio/addSpeakerYM.action"></c:url>'><button type="button" class="btn btn-primary">添加主讲人</button></a>

<div class="search">
<form action='<c:url value="/vedio/speakerList.action"></c:url>'>
<b>名字:</b><input type="text" value="${speaker_name}" name="speaker_name" class="form-control" id="exampleInputName2" placeholder="主讲人姓名" style="width: 200px; display: inline;">
<b>职位:</b><input type="text" value="${speaker_job}" name="speaker_job" class="form-control" id="exampleInputName2" placeholder="主讲人职位" style="width: 200px; display: inline;">
 <button type="submit" class="btn btn-primary">搜索</button>
 </form>
</div>
  </div>	
  	<br />
  	<br />
  	
  	
  	
  	<table class="table">
  		<thead>
  <tr>
  	
  	<th width="5px" >序号</th>
  	<th>名称</th>
  	<th>职位</th>
  	<th>简介</th>
 
  	
  	<th width="5px">编辑</th>
  	<th width="5px">删除</th> 	
  </tr>	
  </thead>
  <tbody>
  <c:forEach items="${page.rows}" var="speakers" varStatus="inco">
<tr>
	
	<td>${inco.count+10*(page.page-1)}</td>
	<td>${speakers.speaker_name}</td>
	<td>${speakers.speaker_job}</td>
	<td>${speakers.speaker_descr}</td>
	<td><a href='<c:url value="/vedio/editSpeaker.action"></c:url>?id=${speakers.id}'><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
	<td><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></td>
</tr>
</c:forEach>
</tbody>
		</table>
		


 <fy:page url="${pageContext.request.contextPath}/vedio/speakerList.action"></fy:page>	
	</body>
</html>

