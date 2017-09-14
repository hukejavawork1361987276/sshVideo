package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Subject;

public interface FrontShareCDao {

	List<Subject> findSub(int subjectId);

	List<Course> findSCV(int subjectId);

	

}
