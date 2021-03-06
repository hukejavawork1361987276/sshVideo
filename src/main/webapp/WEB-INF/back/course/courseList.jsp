<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@taglib prefix="fy" uri="http://zhiyou100.com/common/"%> 
      <%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

      <jsp:include page="/WEB-INF/back/menu.jsp">
   <jsp:param value="course" name="fromJsp"/></jsp:include>
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
    <link rel="stylesheet" href="css/jquery-confirm.min.css" />
      <script type="text/javascript" src="js/jquery-confirm.min.js" ></script>
   <style>
  
   body{
   	margin:0 auto;
   	width: 1200px;
   	
   }
   </style>
   <script type="text/javascript">
   function  deleOne(id){
		$.confirm({
		    title: '警告',
		    content: '确认删除一个?',
		    type: 'green',
		    buttons: {   
		        ok: {
		            text: "确认",
		            btnClass: 'btn-primary',
		            action: function () {
		            	location.href='back/admin/deleOneC?cid='+id;
		        	}
		        },
		        cancel: function(){
		        	 text: "取消" 
		        	 
		        }
		    }
		});}
   </script>
   
   
  </head>
  	<body>
  		<div class="jumbotron">
  <div class="container">
    <h2><b>课程列表-课程管理</b></h2>
  </div>
</div>

  	<div>
  		
  			<a href="${pageContext.request.contextPath}/back/admin/addCourseP"><button type="button" class="btn btn-primary">添加课程</button></a>
  		
  	</div>
  	
  	<div>
  	<table class="table">
  		<thead>
  <tr>
  	<th width="5px" >序号</th>
  	<th>标题</th>
  	<th>学科</th>
  	<th>简介</th>
  	<th width="5px">编辑</th>
  	<th width="5px">删除</th> 	
  </tr>	
  </thead>
  <tbody>

  <c:forEach items="${page.rows}" var="courseList" varStatus="inco">
<tr>
	<td>${inco.count+10*(page.page-1)}</td>
	<td>${courseList.course_name}</td>
	<td>${courseList.subject.subject_name}</td>
	<td>${courseList.course_descr}</td>
	<td><a href="${pageContext.request.contextPath}/back/admin/editCourseP?cid=${courseList.id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
	<td><a><span class="glyphicon glyphicon-trash" aria-hidden="true" onclick="deleOne(${courseList.id})"></span></a></td>
</tr>
</c:forEach>
</tbody>
		</table>
		<fy:page url="${pageContext.request.contextPath}/back/admin/courseList"></fy:page>
  
  	
  		
  		

  	</div>
  	
	</body>
</html>
