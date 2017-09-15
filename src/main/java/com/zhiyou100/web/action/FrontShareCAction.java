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

	
	
	//frontҳ�湲��γ�  
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
	//frontҳ�湲��γ�  2.---video��Ϣ,��Ӧcourse��video
	public String courseIndex2(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		//��ѯѡ��video��Ϣ
		List<Video>  liv= 	fs.findVideo(videoId);
		int cid=0;
		for (Video video : liv) {
		session.setAttribute("video1", video);
		cid=video.getCourse_id().getId();
		}
		System.out.println(cid);
		//��ѯ���ڿγ�videolist
		List<Course>  course=fs.findCVList(cid);
		for (Course course2 : course) {	
			session.setAttribute("course1", course2);
		}
		//add���Ŵ���
		fs.addCount(videoId);
		return "success";
		
	}
	//course:index.jsp-- ONCLOCK videoID --load:video:index.jsp
	public String videoPage(){
		return "success";
	}
}
