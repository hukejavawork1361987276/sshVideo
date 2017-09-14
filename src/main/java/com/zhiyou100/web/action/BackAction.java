package com.zhiyou100.web.action;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.model.Admin;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.LoginInf;
import com.zhiyou100.model.Page;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.User;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.BackService;
import com.zhiyou100.service.UserService;


/**  
* @ClassName:BackAction.java  
* @Description: 
* @author:  hk 
* @date :上午10:40:49 
*/
@Controller("BackAction")
@Scope(scopeName="prototype")
public class BackAction implements ModelDriven<Video>{
	private Video v=new Video();
	private Integer vid;
	private	LoginInf inf;
	private List<Integer> deleVideo;

	


	public List<Integer> getDeleVideo() {
	return deleVideo;
}
public void setDeleVideo(List<Integer> deleVideo) {
	this.deleVideo = deleVideo;
}
	public LoginInf getInf() {
	return inf;
}
public void setInf(LoginInf inf) {
	this.inf = inf;
}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}

	private String name;
	private String password;

	private String titlelike;
	private String page;
	private String speakid;
	private String courseid;
	
	
	
	public String getTitlelike() {
		return titlelike;
	}
	public void setTitlelike(String titlelike) {
		this.titlelike = titlelike;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getSpeakid() {
		return speakid;
	}
	public void setSpeakid(String speakid) {
		this.speakid = speakid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Autowired
	BackService bs;
	public String loginYM(){
		return "success";
		
	}
	public String login(){
		 String password1= DigestUtils.md5Hex(password); 
		List<Admin> li=bs.login(name,password1);

		if (li.size()==1) {
			return "success";
		} else {
			return "false";
		}
	}
	//查找video列表
	public String videoList(){
		//查找主讲人列表
		List<Speaker> allSpeaker= bs.findSpeaker();	
		ServletActionContext.getRequest().setAttribute("allSpeaker", allSpeaker);
		//查找课程列表
		List<Course> allCourse= bs.findCourse();	
		ServletActionContext.getRequest().setAttribute("allCourse", allCourse);
		
		int currentPage=(page==null?1:Integer.parseInt(page));


		Page page1=bs.loadPageVppp(titlelike,speakid,courseid,currentPage);
	
		ServletActionContext.getRequest().setAttribute("page", page1);
	
		return "success";
		
	}
	//speaker分页
	public String speakerList(){
	
		int currentPage=(page==null?1:Integer.parseInt(page));
		
		Page page1=bs.loadPageppp(currentPage);
			
		ServletActionContext.getRequest().setAttribute("page", page1);

		return "success";
}
	//添加视频页面
	public String addVideo(){
		//查找主讲人列表
		List<Speaker> allSpeaker= bs.findSpeaker();	
		ServletActionContext.getRequest().setAttribute("allSpeaker", allSpeaker);
		//查找课程列表
		List<Course> allCourse= bs.findCourse();	
		ServletActionContext.getRequest().setAttribute("allCourse", allCourse);
		return "success";
	}
	//添加video提交
	public String addVideoSub(){
		bs.addVideo(v);
		return "success";
	}
	@Override
	public Video getModel() {
		// TODO Auto-generated method stub
		return v;
	}
	//编辑video
	public String editVideo() {
		//查找主讲人列表
		List<Speaker> allSpeaker= bs.findSpeaker();	
		ServletActionContext.getRequest().setAttribute("allSpeaker", allSpeaker);
		//查找课程列表
		List<Course> allCourse= bs.findCourse();	
		ServletActionContext.getRequest().setAttribute("allCourse", allCourse);
		//查到对应的video
		Video video= bs.findVideo(vid);
		ServletActionContext.getRequest().setAttribute("video", video);
		return "success";
	}
	public String editVideoSub() {
		bs.editVideo(v);
		return "success";
	}
	//删除一条video
	public String deleOneVideo(){
		inf=new LoginInf();
		if (vid!=null) {
			int a=bs.deleVideo(vid);
			inf.setSuccess(true);
			inf.setMessage("success");	
		}
		
		return "success";
	}
	//批量删除video
	public String deleVideo(){
		System.out.println(deleVideo);
		bs.deleAVideo(deleVideo);
		return "success";
	}
	
}
