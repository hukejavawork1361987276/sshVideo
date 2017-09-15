package com.zhiyou100.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhiyou100.dao.FrontShareCDao;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.Video;
@Repository
public class FrontShareCDaoImpl extends HibernateDaoSupport implements FrontShareCDao{
//查询点击的课程
	@Override
	public List<Course> findSCV(int subjectId) {
		List<Course> li=	(List<Course>) getHibernateTemplate().find("from Course where subject_id=?", subjectId);
		return li;

	}
	//查询点击的课程所属的subject
	@Override
	public List<Subject> findSub(int subjectId) {
		List<Subject> li=	(List<Subject>) getHibernateTemplate().find("from Subject where id=?", subjectId);
		for (Subject subject : li) {
			System.out.println(subject);
		}
		return li;
	}
//查询选中video
	@Override
	public List<Video> findVideo(int videoId) {
		System.out.println("//查询选中video");
		List<Video> li=	(List<Video>) getHibernateTemplate().find("from Video where id=?", videoId);
for (Video video : li) {
	System.out.println(video);
}
		return li;
	}
//查询选中video对应course的videos
	@Override
	public List<Course> findCVList(int cid) {
		System.out.println("//查询选中video对应course的videos");
		List<Course> li=	(List<Course>) getHibernateTemplate().find("from Course where id=?", cid);
	
		return li;
	}
/*
 * 添加播放次数
 */
	@Override
	public void addCount(int videoId) {
		Video video = getHibernateTemplate().get(Video.class, videoId);
		video.setVideo_play_times(video.getVideo_play_times()+1);
		 getHibernateTemplate().save(video);
	}

}
