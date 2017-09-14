package com.zhiyou100.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.LoginInf;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.UserService;
import com.zhiyou100.video.utils.HMS;

/**  
* @ClassName:FrontAction.java  
* @Description: 
* @author:  hk 
* @date :����4:57:10 
*/
@Controller("FrontAction")
@Scope(scopeName="prototype")
public class FrontAction {
	@Autowired
	UserService us; 
	private Integer subjectId;
	
	
	
	
	
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	private	LoginInf inf;

	public LoginInf getInf() {
	return inf;
	}
	public void setInf(LoginInf inf) {
	this.inf = inf;
	}
	/**
	 * ��¼ҳ��
	 */
		public String index1(){
			return "success";
			
		}
		/**
		 * ��¼
		 */
		public String login(){
			System.out.println("-----��¼����");
			 inf=new LoginInf();
			//inf.setSuccess("��¼�ɹ�!");
			inf.setMessage("�û������벻ƥ��!");
			return "success";
			
		}
		/**
		 * webͼƬ������
		 */
		public String index(){
			System.out.println("-----webͼƬ������");
			ActionContext.getContext().put("subjectId", subjectId);
			List<Subject> subjectlist		=	us.findSubject(subjectId);
			for (Subject subject2 : subjectlist) {
				ActionContext.getContext().put("subject", subject2);
			}
			
			List<Course>  course=	us.findCourseVideo(subjectId);
		/*	for (Course course2 : course) {
			//	List<Video> videoList = course2.getVideoList();
				for (Video video : videoList) {
					int vlength = video.getVideo_length();
					String  vlengthStr=	HMS.trans(vlength);
						video.setVideo_lengthStr(vlengthStr);
					
					
					
				}
			}*/

			ActionContext.getContext().put("courses", course);			
			return "success";
			
			
		}
}
