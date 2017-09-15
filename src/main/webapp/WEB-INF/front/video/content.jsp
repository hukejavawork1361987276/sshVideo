<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouyc
  Date: 2017/6/30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<div class="intro">
	<div class="container">
		<div class="v-intro">
			<div class="left">
				<video id="videoPlayer" src="${video1.video_url}" class="video-js vjs-default-skin" controls width="627" height="280"
					   poster="${video1.video_image_url}" data-setup="{}">
				</video>
			</div>

			<div class="right">
				<p class="right-title">${video1.video_title}</p>
				<div class="avatar">
					<span style="background-image: url(${video1.speaker.speaker_head_url})"></span>
					<p><b>讲师：${video1.speaker.speaker_name}</b><br><i>${video1.speaker.speaker_descr}</i></p>
				</div>
				<p class="video-intro">
					<span>本节内容：</span> ${video1.video_descr}
				</p>
			</div>
		</div>



		<div class="kcjs">
			<p class="title">课程介绍</p>
			<p class="content">${video1.course_id.course_descr}</p>
		</div>

	</div>
</div>
<!--目录-->
<div class="catalog">
	<div class="container">
		<p class="title">目录</p>

		<c:forEach items="${course1.setVideo}" var="video" >
			<div class="chapter">
				<p class="biaoti"><a href="${pageContext.request.contextPath}/front/user/videoPage?videoId=${video.id}&subjectId=${subjectId}">${video.video_title}</a></p>
				<p class="lecturer">${video.video_descr}</p>
				<p class="lecturer">讲师：${video.speaker.speaker_name}</p>
				<div class="v-info">
					<span class="count"><img src="static/img/count.png" alt="">${video.video_play_times}</span>
					<span class="duration"><img src="static/img/player.png" alt="">${video.video_length}</span>
				</div>
			</div>
		</c:forEach>


	</div>
</div>