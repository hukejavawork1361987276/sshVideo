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
	//���course��Ϣ
	private Course c= new Course();
	//����course��Ϣ���id
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
	 * �õ�courseList��ҳ
	 */
	public String courseList(){
	
		int currentPage=(page==null?1:Integer.parseInt(page));
		
		Page page1=bsc.loadPageS(currentPage);
			
		ServletActionContext.getRequest().setAttribute("page", page1);

		return "success";
}
	/*
	 * ����addcourseListҳ
	 */
	public String addCourseP(){

		return "success";
	}
	/*
	 * �ύaddcourse
	 */
	public String addCourseSub(){
		bsc.addCourse(c);
		return "success";
	}
	/*
	 * ����editCourseҳ,��ѯ������Ϣ
	 */
	public String editCourseP(){
		Course c=	bsc.findCourse(cid);
		ActionContext context = ServletActionContext.getContext();
		context.put("course", c);
		return "success";
	}
	/*
	 * ����editCourseҳ,�ύ
	 */
	public String editCourseSub(){
		bsc.editCourse(c);
		return "success";
	}
	/*
	 * ����deleCourse�ύ
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
