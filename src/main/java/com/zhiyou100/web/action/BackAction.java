package com.zhiyou100.web.action;

import java.util.List;

import javax.servlet.http.HttpSession;

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
* @date :����10:40:49 
*/
@Controller("BackAction")
@Scope(scopeName="prototype")
public class BackAction implements ModelDriven<Video>{
	private Video v=new Video();
	private Integer vid;
	private	LoginInf inf;
	private List<Integer> deleVideo;
//speakerģ����ѯ	
	private String speaker_name;
	private String speaker_job;
//addSpeaker
	private Speaker s=new Speaker();
//����Speaker sid
	private int sid;
	
	

	


	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Speaker getS() {
		return s;
	}
	public void setS(Speaker s) {
		this.s = s;
	}
	public String getSpeaker_name() {
		return speaker_name;
	}
	public void setSpeaker_name(String speaker_name) {
		this.speaker_name = speaker_name;
	}
	public String getSpeaker_job() {
		return speaker_job;
	}
	public void setSpeaker_job(String speaker_job) {
		this.speaker_job = speaker_job;
	}
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
	//����video�б�
	public String videoList(){
		//�����������б�
		List<Speaker> allSpeaker= bs.findSpeaker();	
		ServletActionContext.getRequest().setAttribute("allSpeaker", allSpeaker);
		//���ҿγ��б�
		List<Course> allCourse= bs.findCourse();	
		ServletActionContext.getRequest().setAttribute("allCourse", allCourse);
		
		int currentPage=(page==null?1:Integer.parseInt(page));


		Page page1=bs.loadPageVppp(titlelike,speakid,courseid,currentPage);
	
		ServletActionContext.getRequest().setAttribute("page", page1);
	
		return "success";
		
	}
	/*
	 * speaker��ҳ,ģ����ѯ
	 */
	
	public String speakerList(){
	
		int currentPage=(page==null?1:Integer.parseInt(page));
		
		Page page1=bs.loadPageppp(currentPage,speaker_name, speaker_job);
			
		ServletActionContext.getRequest().setAttribute("page", page1);

		return "success";
}
	//�����Ƶҳ��
	public String addVideo(){
		//�����������б�
		List<Speaker> allSpeaker= bs.findSpeaker();	
		ServletActionContext.getRequest().setAttribute("allSpeaker", allSpeaker);
		//���ҿγ��б�
		List<Course> allCourse= bs.findCourse();	
		ServletActionContext.getRequest().setAttribute("allCourse", allCourse);
		return "success";
	}
	//���video�ύ
	public String addVideoSub(){
		bs.addVideo(v);
		return "success";
	}
	@Override
	public Video getModel() {
		// TODO Auto-generated method stub
		return v;
	}
	//�༭video
	public String editVideo() {
		//�����������б�
		List<Speaker> allSpeaker= bs.findSpeaker();	
		ServletActionContext.getRequest().setAttribute("allSpeaker", allSpeaker);
		//���ҿγ��б�
		List<Course> allCourse= bs.findCourse();	
		ServletActionContext.getRequest().setAttribute("allCourse", allCourse);
		//�鵽��Ӧ��video
		Video video= bs.findVideo(vid);
		ServletActionContext.getRequest().setAttribute("video", video);
		return "success";
	}
	public String editVideoSub() {
		bs.editVideo(v);
		return "success";
	}
	//ɾ��һ��video
	public String deleOneVideo(){
		inf=new LoginInf();
		if (vid!=null) {
			int a=bs.deleVideo(vid);
			inf.setSuccess(true);
			inf.setMessage("success");	
		}
		
		return "success";
	}
	//����ɾ��video
	public String deleVideo(){
		System.out.println(deleVideo);
		bs.deleAVideo(deleVideo);
		return "success";
	}
	/*
	 * addSpeakerҳ��
	 */
	public String addSpeakerYM(){
		
		return "success";
	}
	/*
	 * addSpeaker�ύ
	 */
	public String addSpeaker(){
		bs.addSpeaker(s);
		return "success";
	}
	/*
	 * editSpeakerҳ��
	 */
	public String editSpeakerP(){
		 ActionContext context = ServletActionContext.getContext();
		List<Speaker>	li= 	bs.findOneSpeaker(sid);
		for (Speaker speaker : li) {
			context.put("speaker", speaker);
		}
		return "success";
	}
	/*
	 * editSpeakerҳ���ύ
	 */
	public String editSpeakerSub(){

		bs.editSpeaker(s);
		return "success";
	}

	/*
	 * dele one Speaker
	 */
	public String 	deleOneS(){

		bs.deleOneSpeaker(sid);
		return "success";
	}
	/*
	 * courseListPage
	 */
	public String 	courseList(){

		
		return "success";
	}
}
