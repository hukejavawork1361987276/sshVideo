package com.zhiyou100.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhiyou100.dao.UserDao;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.User;
import com.zhiyou100.model.Video;
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

public  SessionFactory getFactory(){
	SessionFactory SessionFactory=getHibernateTemplate().getSessionFactory();
	return SessionFactory;
}

	@Override
	public List<User> selectUser() {
		
		 List<User> li=	 (List<User>) getHibernateTemplate().find("from User");
		for (User user : li) {
			System.out.println(li);
		}
		return li;
	}

	@Override
	public List<Subject> findSubject(Integer subjectId) {
		System.out.println(subjectId);
		
		List<Subject> s=	(List<Subject>) getHibernateTemplate().find("from Subject where id=?",subjectId);
		for (Subject subject : s) {
			System.out.println(subject);
		}
		return s;
	}

	@Override
	public List<Course> findCourseVideo(Integer subjectId) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		SQLQuery sqlQuery = session.createSQLQuery("select *from (select *from("
				+ "select s.subject_name,s.id subject_id, c.course_name,c.id "
				+ "coursetable_id,c.course_descr  from subject s left join "
				+ "course c on  s.id=c.subject_id)ss left join video v on "
				+ "ss.coursetable_id=v.course_id)xx where xx.subject_id=?;");
		sqlQuery.setParameter(0, subjectId);
				sqlQuery.addEntity(Video.class);
				List<Video> list = sqlQuery.list(); 
				for (Video video : list) {
					System.out.println(video);
				}
				List<Course> list1 = null; 
		
		
		return list1;
	}
//login
	@Override
	public List<User> loginFront(String email, String password) {
		List<User> list = (List<User>) getHibernateTemplate().find("from User where email=? and password=?", email,password);
		return list;
	}
//regist判断邮箱存在
	@Override
	public List<User> findUser(String email) {
		List<User> list = (List<User>) getHibernateTemplate().find("from User where email=?",email);
		return list;
	}

	@Override
	public void addUser(String email, String pwd) {
		User u=new User();
		u.setEmail(email);
		u.setPassword(pwd);
		getHibernateTemplate().save(u);
		
	}
//存邮件信息到数据库
	@Override
	public void addMailMsg(String email,String mailMSG) {
	
	Session session=	getHibernateTemplate().getSessionFactory().getCurrentSession();
	User user=	(User) session.createQuery("from User where email=?").setParameter(0, email).uniqueResult();

	user.setCaptcha(mailMSG);
		 getHibernateTemplate().update(user);
		
	}

	@Override
	public List<User> findEmailbox(String email) {
		List<User> list = (List<User>) getHibernateTemplate().find("from User where email=?",email);
		 return list;
	}
//查找验证码
	@Override
	public List<User> findCaptcha(String email, String captcha) {
		List<User> list = (List<User>) getHibernateTemplate().find("from User where email=? and captcha=?",email,captcha);

		return list;
	}
//重置密码提交
	@Override
	public void updatePwd(String email, String password) {
		Session session=	getHibernateTemplate().getSessionFactory().getCurrentSession();
		User user=	(User) session.createQuery("from User where email=?").setParameter(0, email).uniqueResult();

		user.setPassword(password);
			 getHibernateTemplate().update(user);
		
	}
//提交更新资料
	@Override
	public void editUser(User user) {
		Session session=	getHibernateTemplate().getSessionFactory().getCurrentSession();
		User user1=	(User) session.createQuery("from User where email=?").setParameter(0, user.getEmail()).uniqueResult();
			user1.setBirthday(user.getBirthday());
			user1.setSex(user.getSex());
			user1.setNick_name(user.getNick_name());
			user1.setCity(user.getCity());
			user1.setProvince(user.getProvince());
			 getHibernateTemplate().update(user1);
		
	}

}
