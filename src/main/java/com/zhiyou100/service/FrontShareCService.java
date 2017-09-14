package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Subject;

public interface FrontShareCService {

	List<Course> findSCV(int subjectId);

	List<Subject> findSub(int subjectId);

}
