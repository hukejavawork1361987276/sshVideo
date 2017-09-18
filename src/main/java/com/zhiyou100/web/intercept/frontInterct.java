package com.zhiyou100.web.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zhiyou100.model.Admin;
import com.zhiyou100.model.User;

public class frontInterct extends MethodFilterInterceptor{


	@Override
	protected String doIntercept(ActionInvocation actionInvocat) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user= (User) session.getAttribute("user");
		System.out.println(user+":user");
		if (user!=null) {
			String invoke = actionInvocat.invoke();
			return "invoke";
		}else{
			
		return "false";
	}
	}}

