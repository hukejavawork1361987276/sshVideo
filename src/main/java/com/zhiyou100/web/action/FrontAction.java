package com.zhiyou100.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.LoginInf;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.User;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.UserService;
import com.zhiyou100.video.utils.HMS;

/**  
* @ClassName:FrontAction.java  
* @Description: 
* @author:  hk 
* @date :ÏÂÎç4:57:10 
*/
@Controller("FrontAction")
@Scope(scopeName="prototype")
public class FrontAction {
	@Autowired
	UserService us; 
	private Integer subjectId;
	private String email;
	private String password;
	
	
	
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
	 * µÇÂ¼Ò³Ãæ
	 */
		public String index1(){
			return "success";
			
		}
		/**
		 * µÇÂ¼
		 */
		public String login(){
			inf=new LoginInf();
			if (!("").equals(email)&&!("").equals(password)) {
				String pwd = DigestUtils.md5Hex(password);
				List<User> u=	us.loginFront(email,pwd);
				if (u.size()!=0) {
					inf.setSuccess(true);
				}
				for (User user : u) {
					 HttpSession session = ServletActionContext.getRequest().getSession();
					 session.setAttribute("user", user);	
				}
					
			}
		
			inf.setMessage("ÓÃ»§ÃûÃÜÂë²»Æ¥Åä!");
			return "success";
			
		}
		//×¢²á
		public String regist(){
			inf=new LoginInf();
			List<User> u =	us.findUser(email);
			if (u.size()==1) {
				inf.setMessage("´ËÓÊÏäÒÑ±»×¢²á!");
			}else{
				String pwd = DigestUtils.md5Hex(password);
				us.addUser(email,pwd);
				inf.setSuccess(true);
			}
			return "success";
		}
		public String exit(){
			System.out.println("dsgtysession1");
			 HttpSession session = ServletActionContext.getRequest().getSession();
			 System.out.println("dsgtysession2");
			 session.invalidate();
			return "success";	
		}
		
		/**
		 * webÍ¼Æ¬³¬Á´½Ó
		 */
		public String index(){
			System.out.println("-----webÍ¼Æ¬³¬Á´½Ó");
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
