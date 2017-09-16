package com.zhiyou100.dao.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhiyou100.dao.BackCCDao;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Page;
import com.zhiyou100.model.TongJi;
import com.zhiyou100.model.Video;
@Repository
public class BackCCDaoImpl extends HibernateDaoSupport implements BackCCDao  {

	@Override
	public List<Course> getCourses() {
		List<Course> find = (List<Course>) getHibernateTemplate().find("from Course");
		for (Course course : find) {
			System.out.println(course);
		}
		return find;
	}
/*
 * course分页
 */
	@Override
	public Page loadPageS(int currentPage) {
		Page<Course> page=new Page<>();
		page.setPage(currentPage);
		String  sqlbase="select count(1) from Course";
		 Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Number n=(Number) session.createQuery(sqlbase).uniqueResult();
		 page.setTotal(n.intValue());
			page.setSize(10);
			int	currentPage1 =(currentPage-1)*10;
			String  sqlbase2="from Course";
			List<Course> list = session.createQuery(sqlbase2).setFirstResult(currentPage1).setMaxResults(10).list();
			page.setRows(list);
		return page;
	}
	/*
	 * 添加course提交
	 */
	@Override
	public void addCourse(Course c) {
		System.out.println(c);
		getHibernateTemplate().save(c);
		
	}
	/*
	 * find one course
	 */
	@Override
	public Course findCourse(int cid) {
		Course course = getHibernateTemplate().get(Course.class, cid);
		return course;
	}
	/*
	 * edit one course
	 */
	@Override
	public void editCourse(Course c) {
		Course course = getHibernateTemplate().get(Course.class, c.getId());
		course.setCourse_descr(c.getCourse_descr());
		course.setCourse_name(c.getCourse_name());
		course.setSubject(c.getSubject());
		course.setUpdate_time( new Date( System.currentTimeMillis()));
		
		getHibernateTemplate().update(course);
		
	}
	@Override
	public void deleCourse(int c) {
		Course course = getHibernateTemplate().get(Course.class, c);
		System.out.println(course);
		getHibernateTemplate().delete(course);
		
	}
	@Override
	public List<TongJi> findbiao() {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query SQLQuery = session.createSQLQuery("select c.course_name courseName ,"
				+ "avg(v.video_play_times) Avgvideo_play_times from "
				+ "video v right join course c on v.course_id=c.id "
				+ "group by"
				+ " c.course_name ").setResultTransformer(Transformers.aliasToBean(TongJi.class));
				List<TongJi> list = SQLQuery.list();

		return list;
	}

}
