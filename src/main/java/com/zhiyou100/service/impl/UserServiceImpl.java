package com.zhiyou100.service.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.UserDao;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.User;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.UserService;
@Service
public class UserServiceImpl implements UserService{
@Autowired
UserDao ud;

@Override
public List<User> selectUser() {
	// TODO Auto-generated method stub
	return ud.selectUser();
}

@Override
public List<Subject> findSubject(Integer subjectId) {
	// TODO Auto-generated method stub
	return ud.findSubject(subjectId);
}

@Override
public List<Course> findCourseVideo(Integer subjectId) {
	
	return ud.findCourseVideo(subjectId);
}

@Override
public List<User> loginFront(String email, String password) {
	// TODO Auto-generated method stub
	return ud.loginFront(email,password);
}

@Override
public List<User> findUser(String email) {
	// TODO Auto-generated method stub
	return ud.findUser(email);
}

@Override
public void addUser(String email, String pwd) {
	// TODO Auto-generated method stub
	ud.addUser(email, pwd);
}

@Override
public void addMailMsg(String email,String mail1) {
	// TODO Auto-generated method stub
	ud.addMailMsg(email,mail1);
}

@Override
public List<User> findEmailbox(String email) {
	// TODO Auto-generated method stub
	return ud.findEmailbox(email);
}

@Override
public List<User> findCaptcha(String email, String captcha) {
	// TODO Auto-generated method stub
	return ud.findCaptcha(email,captcha);
}

@Override
public void updatePwd(String email, String password) {
	// TODO Auto-generated method stub
	ud.updatePwd(email, password);
}

@Override
public void editUser(User user) {
	ud.editUser( user);
	
}

@Override
public void updatepic(String email, String databasepic) {
	ud.updatepic( email,  databasepic);
	
}

@Override
public List<User> findOldPassword(String email, String oldPassword) {
	String pwd = DigestUtils.md5Hex(oldPassword);
	return ud.findOldPassword(email,pwd);
}

}
