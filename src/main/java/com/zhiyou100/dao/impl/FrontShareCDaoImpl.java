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
//��ѯ����Ŀγ�
	@Override
	public List<Course> findSCV(int subjectId) {
		List<Course> li=	(List<Course>) getHibernateTemplate().find("from Course where subject_id=?", subjectId);
		return li;

	}
	//��ѯ����Ŀγ�������subject
	@Override
	public List<Subject> findSub(int subjectId) {
		List<Subject> li=	(List<Subject>) getHibernateTemplate().find("from Subject where id=?", subjectId);
		for (Subject subject : li) {
			System.out.println(subject);
		}
		return li;
	}
//��ѯѡ��video
	@Override
	public List<Video> findVideo(int videoId) {
		System.out.println("//��ѯѡ��video");
		List<Video> li=	(List<Video>) getHibernateTemplate().find("from Video where id=?", videoId);
for (Video video : li) {
	System.out.println(video);
}
		return li;
	}
//��ѯѡ��video��Ӧcourse��videos
	@Override
	public List<Course> findCVList(int cid) {
		System.out.println("//��ѯѡ��video��Ӧcourse��videos");
		List<Course> li=	(List<Course>) getHibernateTemplate().find("from Course where id=?", cid);
for (Course course : li) {
	System.out.println(course);
}
		
		return li;
	}

}
