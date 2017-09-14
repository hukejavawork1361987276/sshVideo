package com.zhiyou100.web.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Subject;
import com.zhiyou100.service.FrontShareCService;
import com.zhiyou100.service.UserService;

@Controller("ShareAction")
@Scope(scopeName="prototype")
public class FrontShareCAction {
	@Autowired
	FrontShareCService fs; 
	
	private int subjectId;
	
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	
	
	//frontÒ³Ãæ¹²Ïí¿Î³Ì  
	public String courseIndex(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Subject> lis= 	fs.findSub(subjectId);
		for (Subject subject : lis) {
			session.setAttribute("subject", subject);
		}
		List<Course> lic=	fs.findSCV(subjectId);		
		session.setAttribute("courses", lic);
		return "success";
	}
	public String lllll(){
		return "success";
	}
}
