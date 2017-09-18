package com.zhiyou100.web.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zhiyou100.model.Admin;

public class LoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation actionInvocat) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Admin user= (Admin) session.getAttribute("userAdmin");
		System.out.println(user+":user");
		if (user!=null) {
			String invoke = actionInvocat.invoke();
			return "invoke";
		}else{
			
		return "false";
	}}
	}


