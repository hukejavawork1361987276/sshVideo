package com.zhiyou100.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhiyou100.service.FrontShareCService;
import com.zhiyou100.service.UserService;

@Controller("FrontAction")
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
	public String index(){
		//fs.findSCV(subjectId);
		return "";
	}
}
