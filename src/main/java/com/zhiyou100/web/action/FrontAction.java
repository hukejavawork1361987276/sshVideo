package com.zhiyou100.web.action;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.LoginInf;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.User;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.UserService;
import com.zhiyou100.video.utils.HMS;
import com.zhiyou100.video.utils.MailUtil;

/**  
* @ClassName:FrontAction.java  
* @Description: 
* @author:  hk 
* @date :下午4:57:10 
*/
@Controller("FrontAction")
@Scope(scopeName="prototype")
public class FrontAction {
	@Autowired
	UserService us; 
	private Integer subjectId;
	private String email;
	private String password;
	private String captcha;
	private String pwdAgain;
	private User usersub=new User();
	
	
	
	
	
	
	
	public User getUsersub() {
		return usersub;
	}
	public void setUsersub(User usersub) {
		this.usersub = usersub;
	}
	public String getPwdAgain() {
		return pwdAgain;
	}
	public void setPwdAgain(String pwdAgain) {
		this.pwdAgain = pwdAgain;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
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
	 * 登录页面
	 */
		public String index1(){
			return "success";
			
		}
		/**
		 * 登录
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
		
			inf.setMessage("用户名密码不匹配!");
			return "success";
			
		}
		//注册
		public String regist(){
			inf=new LoginInf();
			List<User> u =	us.findUser(email);
			if (u.size()==1) {
				inf.setMessage("此邮箱已被注册!");
			}else{
				String pwd = DigestUtils.md5Hex(password);
				us.addUser(email,pwd);
				inf.setSuccess(true);
			}
			return "success";
		}
		//退出
		public String exit(){
			 HttpSession session = ServletActionContext.getRequest().getSession();
			 session.invalidate();
			return "success";	
		}
		//忘记密码页面跳转
		public String forgetpwdPage(){
			
			return "success";	
		}
		//sendemail
		public String sendemail(){
			System.out.println("sdafgdh:"+email);
			 inf=new LoginInf();
			
			//产生验证码
			String str=UUID.randomUUID().toString();
			String mailMSG=	str.substring(0, 5);
			//查找邮箱
			List<User> li=	us.findEmailbox(email);
			System.out.println(li);
			if (li.size()==0) {
				inf.setMessage("不是注册邮箱!");
			}else{
				System.out.println("存验证码");
				//存验证码
				us.addMailMsg(email,mailMSG);
				//发邮件
				System.out.println("发邮件");
				try {
					MailUtil.send(email, "验证消息", mailMSG);
					inf.setSuccess(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
			return "success";	
		}
		//提交验证码
		public String forgetpwd(){
			List<User> user=	us.findCaptcha(email,captcha);
			if (user.size()==0) {
				return "false";
			}else{
				return "success";
			}
		}
		//重置密码
		public String resetpwd(){
			String pwd = DigestUtils.md5Hex(password);
			us.updatePwd(email,pwd);
					return"success";
				}
		public String message(){
			List<User> u =	us.findUser(email);
			for (User user : u) {
				HttpSession session = ServletActionContext.getRequest().getSession();
				 session.setAttribute("user", user);	
			}
			 
			return"success";
		}
		public String profile(){
			List<User> u =	us.findUser(email);
			for (User user : u) {
				HttpSession session = ServletActionContext.getRequest().getSession();
				 session.setAttribute("user", user);	
			}
			 
			return"success";
		}
		public String	 profileSub(){
			us.editUser(usersub);
			
			List<User> u =	us.findUser(usersub.getEmail());
			for (User user : u) {
				System.out.println("currentSession;"+user);
				HttpSession session = ServletActionContext.getRequest().getSession();
				 session.setAttribute("user", user);	
			}
			return"success";
		}
		/**
		 * web图片超链接
		 */
		public String index(){
			System.out.println("-----web图片超链接");
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
