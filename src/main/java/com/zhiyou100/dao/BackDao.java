package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.Admin;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Page;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.Video;

public interface BackDao {

	List<Admin> login(String name, String password1);

	List<Speaker> findSpeaker();

	List<Course> findCourse();

	Page loadPage(String titlelike, String speakid, String courseid, int currentPage);

	Page loadPageppp(int currentPage);

	Page loadPageVppp(String titlelike, String speakid, String courseid, int currentPage);

	void addVideo(Video v);

	Video findVideo(Integer vid);

	void editVideo(Video v);

	int deleVideo(Integer vid);

	void deleAVideo(List<Integer> deleVideo);

}
