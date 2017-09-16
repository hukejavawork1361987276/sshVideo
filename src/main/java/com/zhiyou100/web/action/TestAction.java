package com.zhiyou100.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhiyou100.service.TestService;

@Controller("TestAction")
@Scope(scopeName="prototype")
public class TestAction {
	@Autowired
	TestService at;
	public	String test1(){
		return "success";
	}
}
