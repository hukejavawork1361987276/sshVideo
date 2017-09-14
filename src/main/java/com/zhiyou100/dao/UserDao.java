package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.User;
import com.zhiyou100.model.Video;

public interface UserDao {

	List<User> selectUser();

	List<Subject> findSubject(Integer subjectId);

	List<Course> findCourseVideo(Integer subjectId);

	List<User> loginFront(String email, String password);

	List<User> findUser(String email);

	void addUser(String email, String pwd);

	void addMailMsg(String email,String mail1);

	List<User> findEmailbox(String email);

	List<User> findCaptcha(String email, String captcha);

	void updatePwd(String email, String password);

	void editUser(User user);

}
