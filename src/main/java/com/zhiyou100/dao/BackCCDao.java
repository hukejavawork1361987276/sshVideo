package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Page;
import com.zhiyou100.model.Video;

public interface BackCCDao {

	List<Course> getCourses();

	Page loadPageS(int currentPage);

	void addCourse(Course c);

	Course findCourse(int cid);

	void editCourse(Course c);

	void deleCourse(int c);

	List<Video> findbiao();

}
