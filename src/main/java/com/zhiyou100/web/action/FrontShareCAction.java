package com.zhiyou100.web.action;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.FrontShareCService;
import com.zhiyou100.service.UserService;

@Controller("ShareAction")
@Scope(scopeName="prototype")
public class FrontShareCAction {
	@Autowired
	FrontShareCService fs; 
	
	private int subjectId;
	private int videoId;
	
	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	
	
	//front页面共享课程  
	public String courseIndex(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Subject> lis= 	fs.findSub(subjectId);
		for (Subject subject : lis) {
			session.setAttribute("subject", subject);
		}
		List<Course> lic=	fs.findSCV(subjectId);	
		for (Course course : lic) {
			System.out.println(course);
		}
		
		session.setAttribute("courses", lic);
		return "success";
	}
	//front页面共享课程  2.---video信息,对应course的video
	public String courseIndex2(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		//查询选中video信息
		List<Video>  liv= 	fs.findVideo(videoId);
		int cid=0;
		for (Video video : liv) {
		session.setAttribute("video1", video);
		cid=video.getCourse_id().getId();
		}
		//查询所在课程videolist
		List<Course>  course=fs.findCVList(cid);
		session.setAttribute("course", course);
		return "success";
	}
}
