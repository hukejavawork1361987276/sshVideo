package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.BackDao;
import com.zhiyou100.model.Admin;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Page;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.BackService;
	@Service
public class BackServiceImpl implements BackService{
		@Autowired
		BackDao bd;
		
	@Override
	public List<Admin> login(String name, String password1) {
		
		return bd.login( name, password1);
	}

	@Override
	public List<Speaker> findSpeaker() {
		// TODO Auto-generated method stub
		return bd.findSpeaker();
	}

	@Override
	public List<Course> findCourse() {
		
		return bd.findCourse();
	}

	@Override
	public Page loadPage(String titlelike, String speakid, String courseid, int currentPage) {
		// TODO Auto-generated method stub
		return bd.loadPage(titlelike,speakid,courseid,currentPage);
	}

	@Override
	public Page loadPageppp(int currentPage, String speaker_name,String speaker_job) {
		
		return bd.loadPageppp(currentPage,speaker_name,speaker_job);
	}

	@Override
	public Page loadPageVppp(String titlelike, String speakid, String courseid, int currentPage) {
		
		return bd.loadPageVppp( titlelike, speakid, courseid,currentPage);
	}

	@Override
	public void addVideo(Video v) {
		
		bd.addVideo(v);
		
	}

	@Override
	public Video findVideo(Integer vid) {
		// TODO Auto-generated method stub
		return bd.findVideo(vid);
	}

	@Override
	public void editVideo(Video v) {
		bd.editVideo(v);
		
	}

	@Override
	public int deleVideo(Integer vid) {
		// TODO Auto-generated method stub
		return bd.deleVideo(vid);
	}

	@Override
	public void deleAVideo(List<Integer> deleVideo) {
		bd.deleAVideo(deleVideo);
		
	}

}
