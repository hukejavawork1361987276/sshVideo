package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.Video;

public interface FrontShareCDao {

	List<Subject> findSub(int subjectId);

	List<Course> findSCV(int subjectId);

	List<Video> findVideo(int videoId);

	List<Course> findCVList(int cid);

	

}
