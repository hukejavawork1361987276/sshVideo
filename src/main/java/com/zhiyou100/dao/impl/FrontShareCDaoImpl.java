package com.zhiyou100.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhiyou100.dao.FrontShareCDao;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Subject;
@Repository
public class FrontShareCDaoImpl extends HibernateDaoSupport implements FrontShareCDao{

	@Override
	public List<Course> findSCV(int subjectId) {
		List<Course> li=	(List<Course>) getHibernateTemplate().find("from Course where subject_id=?", subjectId);
		return li;

	}

	@Override
	public List<Subject> findSub(int subjectId) {
		List<Subject> li=	(List<Subject>) getHibernateTemplate().find("from Subject where id=?", subjectId);
		return li;
	}

}
