package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Page;
import com.zhiyou100.model.TongJi;
import com.zhiyou100.model.Video;

public interface BackCCService {



	Page loadPageS(int currentPage);

	void addCourse(Course c);

	Course findCourse(int cid);

	void editCourse(Course c);

	void deleCourse(int c);

	List<TongJi> findbiao();

}
