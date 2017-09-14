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

}
