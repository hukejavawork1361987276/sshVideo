<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/WEB-INF/back/menu.jsp">
   <jsp:param value="statistics" name="fromJsp"/></jsp:include>
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
   	
   body{
   	margin:0 auto;
   	width: 1200px;
   	
   }
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
    
   
    
    <!--  -->
<!--  -->
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:400px"></div>
    <!-- ECharts单文件引入 -->
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript">
    $(function () {
    	
    var name="${name}".split(",");
    var data="${data}".split(",");
    	 // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main')); 
                
                var option = {
                    tooltip: {
                        show: true
                    },
                    legend: {
                        data:['课程的平均播放次数']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            data : name
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            "name":"课程的平均播放次数",
                            "type":"bar",
                            
                            "data":
                            	data
                        }
                    ]
                };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
    	
		
	});
       
    </script>


  </body>
</html>