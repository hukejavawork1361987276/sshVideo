package com.zhiyou100.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
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
* @date :����4:57:10 
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
	//��������
	private User usersub=new User();
	//�ļ��ϴ�
	private File image_file;
	private String image_fileFileName;
	private String image_fileContentType;
	//��������
	private String oldPassword;
	private String newPassword;
	private String newPasswordAgain;
	
	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNewPasswordAgain() {
		return newPasswordAgain;
	}
	public void setNewPasswordAgain(String newPasswordAgain) {
		this.newPasswordAgain = newPasswordAgain;
	}
	public File getImage_file() {
		return image_file;
	}
	public void setImage_file(File image_file) {
		this.image_file = image_file;
	}
	public String getImage_fileFileName() {
		return image_fileFileName;
	}
	public void setImage_fileFileName(String image_fileFileName) {
		this.image_fileFileName = image_fileFileName;
	}
	public String getImage_fileContentType() {
		return image_fileContentType;
	}
	public void setImage_fileContentType(String image_fileContentType) {
		this.image_fileContentType = image_fileContentType;
	}
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
	 * ��¼ҳ��
	 */
		public String index1(){
			return "success";
			
		}
		/**
		 * ��¼
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
		
			inf.setMessage("�û������벻ƥ��!");
			return "success";
			
		}
		//ע��
		public String regist(){
			inf=new LoginInf();
			List<User> u =	us.findUser(email);
			if (u.size()==1) {
				inf.setMessage("�������ѱ�ע��!");
			}else{
				String pwd = DigestUtils.md5Hex(password);
				us.addUser(email,pwd);
				inf.setSuccess(true);
			}
			return "success";
		}
		//�˳�
		public String exit(){
			 HttpSession session = ServletActionContext.getRequest().getSession();
			 session.invalidate();
			return "success";	
		}
		//��������ҳ����ת
		public String forgetpwdPage(){
			
			return "success";	
		}
		//sendemail
		public String sendemail(){
			System.out.println("sdafgdh:"+email);
			 inf=new LoginInf();
			
			//������֤��
			String str=UUID.randomUUID().toString();
			String mailMSG=	str.substring(0, 5);
			//��������
			List<User> li=	us.findEmailbox(email);
			System.out.println(li);
			if (li.size()==0) {
				inf.setMessage("����ע������!");
			}else{
				System.out.println("����֤��");
				//����֤��
				us.addMailMsg(email,mailMSG);
				//���ʼ�
				System.out.println("���ʼ�");
				try {
					MailUtil.send(email, "��֤��Ϣ", mailMSG);
					inf.setSuccess(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
			return "success";	
		}
		//�ύ��֤��
		public String forgetpwd(){
			List<User> user=	us.findCaptcha(email,captcha);
			if (user.size()==0) {
				return "false";
			}else{
				return "success";
			}
		}
		//��������
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
		//������Ϣ�ύ
		public String	 profileSub(){
			us.editUser(usersub);
			//����session
			List<User> u =	us.findUser(usersub.getEmail());
			for (User user : u) {
				System.out.println("currentSession;"+user);
				HttpSession session = ServletActionContext.getRequest().getSession();
				 session.setAttribute("user", user);	
			}
			return"success";
		}
		//����ͷ��
		public String avatar(){
			
			return"success";
		}
		//����ͷ��
		public String avatarSbu(){
			System.out.println("image_file"+image_file);
			System.out.println("image_fileFileName"+image_fileFileName);
			System.out.println("image_file"+image_file);
			String str = UUID.randomUUID().toString().replaceAll("-", "");
		    String ext = FilenameUtils.getExtension(image_fileFileName);
		    String fileName = str+"."+ext;
		    String databasepic= fileName+"."+FilenameUtils.getExtension(image_fileFileName);
		    us.updatepic(email,databasepic);
		    System.out.println("fileName:"+fileName);
		try {
			FileUtils.copyFile(new File(image_file.getAbsolutePath()), new File("D:\\develo\\Java\\vimage\\"+databasepic));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//session
		List<User> u =	us.findUser(email);
		for (User user : u) {
			System.out.println("session:"+user);
			HttpSession session = ServletActionContext.getRequest().getSession();
			 session.setAttribute("user", user);	
		}
		
			return"success";
		}
		//���밲ȫpage
		public String passwordPage(){
			return"success";
		}
		//���������ύ
		public String passwordSub(){
			String pwd = DigestUtils.md5Hex(oldPassword);
			List<User> li=	us.findOldPassword(email,pwd);
			if (li.size()==1) {
			us.updatePwd(email, newPassword);
			}

			return"success";
		}
		/**
		 * webͼƬ������
		 *//*
		public String index(){
			System.out.println("-----webͼƬ������");
			ActionContext.getContext().put("subjectId", subjectId);
			List<Subject> subjectlist		=	us.findSubject(subjectId);
			for (Subject subject2 : subjectlist) {
				ActionContext.getContext().put("subject", subject2);
			}
			
			List<Course>  course=	us.findCourseVideo(subjectId);
			for (Course course2 : course) {
			//	List<Video> videoList = course2.getVideoList();
				for (Video video : videoList) {
					int vlength = video.getVideo_length();
					String  vlengthStr=	HMS.trans(vlength);
						video.setVideo_lengthStr(vlengthStr);
					
					
					
				}
			}

			ActionContext.getContext().put("courses", course);			
			return "success";
			
			
		}*/
}
