package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.BackCCDao;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Page;
import com.zhiyou100.model.TongJi;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.BackCCService;

@Service
public class BackCCServiceImpl implements BackCCService{
@Autowired 
BackCCDao bc;
	
	@Override
	public Page loadPageS(int currentPage) {
		
		return bc.loadPageS(currentPage);
	}

	@Override
	public void addCourse(Course c) {
		bc.addCourse(c);
		
	}

	@Override
	public Course findCourse(int cid) {
		// TODO Auto-generated method stub
		return bc.findCourse(cid);
	}

	@Override
	public void editCourse(Course c) {
		// TODO Auto-generated method stub
		bc.editCourse(c);
	}

	@Override
	public void deleCourse(int c) {
		bc.deleCourse(c);
		
	}

	@Override
	public List<TongJi> findbiao() {
		// TODO Auto-generated method stub
		return bc.findbiao();
	}

}
