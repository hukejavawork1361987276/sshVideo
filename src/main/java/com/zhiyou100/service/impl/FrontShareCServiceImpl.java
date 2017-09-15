package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.BackDao;
import com.zhiyou100.dao.FrontShareCDao;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.FrontShareCService;
@Service
public  class FrontShareCServiceImpl implements FrontShareCService{
	@Autowired
	FrontShareCDao bd;

	

	@Override
	public List<Subject> findSub(int subjectId) {
		// TODO Auto-generated method stub
		return bd.findSub(subjectId);
	}



	@Override
	public List<Course> findSCV(int subjectId) {
		// TODO Auto-generated method stub
		return bd.findSCV(subjectId);
	}



	@Override
	public List<Video> findVideo(int videoId) {
		
		return bd.findVideo(videoId);
	}



	@Override
	public List<Course> findCVList(int cid) {
		// TODO Auto-generated method stub
		return bd.findCVList(cid);
	}
}
