package com.zhiyou100.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Page;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.BackCCService;







@Controller("BackCCAction")
@Scope(scopeName="prototype")
public class BackCCAction {

	@Autowired
	BackCCService bsc;
	
	private String page;
	//添加course信息
	private Course c= new Course();
	//更改course信息获得id
	private int cid;
	
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Course getC() {
		return c;
	}

	public void setC(Course c) {
		this.c = c;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	
	
	/*
	 * 得到courseList分页
	 */
	public String courseList(){
	
		int currentPage=(page==null?1:Integer.parseInt(page));
		
		Page page1=bsc.loadPageS(currentPage);
			
		ServletActionContext.getRequest().setAttribute("page", page1);

		return "success";
}
	/*
	 * 进入addcourseList页
	 */
	public String addCourseP(){

		return "success";
	}
	/*
	 * 提交addcourse
	 */
	public String addCourseSub(){
		bsc.addCourse(c);
		return "success";
	}
	/*
	 * 进入editCourse页,查询本条信息
	 */
	public String editCourseP(){
		Course c=	bsc.findCourse(cid);
		ActionContext context = ServletActionContext.getContext();
		context.put("course", c);
		return "success";
	}
	/*
	 * 进入editCourse页,提交
	 */
	public String editCourseSub(){
		bsc.editCourse(c);
		return "success";
	}
	/*
	 * 进入deleCourse提交
	 */
	public String deleOneC(){
		
		bsc.deleCourse(cid);
		return "success";
	}
	/*
	 * 
	 */
	public String Tongji(){
		List<Video> v=	bsc.findbiao();
		for (Video video : v) {
			System.out.println(video);
		}
		StringBuffer name=new StringBuffer();
		StringBuffer data=new StringBuffer();
		for (int i = 0; i < v.size(); i++) {

			//name.append(v.get(i).getCourseName());
			name.append(v.get(i).getCourseName());
			data.append(v.get(i).getAvgvideo_play_times());
			if(i != v.size() -1 ){
				name.append(",");
				data.append(",");
			}
			
		}
		ActionContext context = ServletActionContext.getContext();
		context.put("name", name);
		context.put("data", data);

		return "success";
	}
}
