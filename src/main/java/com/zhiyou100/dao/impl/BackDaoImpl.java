package com.zhiyou100.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.weaver.SignatureUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhiyou100.dao.BackDao;
import com.zhiyou100.model.Admin;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Page;

import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.Video;


@Repository
public class BackDaoImpl extends HibernateDaoSupport implements BackDao{

	@Override
	public List<Admin> login(String name, String password1) {
		List<Admin> li=	(List<Admin>) getHibernateTemplate().find("from Admin where name=? and password=?",name,password1);
		return li;
	}

	@Override
	public List<Speaker> findSpeaker() {
		List<Speaker> li=	(List<Speaker>) getHibernateTemplate().find("from Speaker");
		return li;
	}

	@Override
	public List<Course> findCourse() {
		List<Course> li=	(List<Course>) getHibernateTemplate().find("from Course");
		return li;
	}

	@Override
	public Page loadPage(String titlelike, String speakid, String courseid, int currentPage) {
		Page<Video> page=new Page<>();
		page.setPage(currentPage);
		
	
		
		StringBuffer sql= new StringBuffer();
		//String  sqlbase="select count(1)from video v left join speaker s on v.speaker_id = s.id left join course c on v.course_id = c.id";
		String  sqlbase="select count(1)from Video v left join v.speaker left join  v.course_id ";

		sql.append(sqlbase);
		 if (speakid !=null && speakid!="") {
			 sql.append("and  v.speaker_id="+speakid+"");
		}
		 if (courseid !=null && courseid !="") {
			 sql.append("and  v.course_id ="+courseid+"");
		}
		 if (titlelike !=null && titlelike !="") {
			 sql.append("and v.video_title like '%'"+titlelike+"'%'");
		}
		 
		 Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
	
	Number n=(Number) session.createQuery(sql.toString()).uniqueResult();
	  
		 page.setTotal(n.intValue());
		page.setSize(10);

		int	currentPage1 =(currentPage-1)*10;
		
		
		
		StringBuffer sql2= new StringBuffer();
		String  sqlbase2="from Video v left join v.speaker left join v.course_id ";
		//String  sqlbase2="from Video";

		sql2.append(sqlbase2);
		 if (speakid !=null && speakid!="") {
			 sql2.append("and  v.speaker_id="+speakid+"");
		}
		 if (courseid !=null && courseid !="") {
			 sql2.append("and  v.course_id ="+courseid+"");
		}
		 if (titlelike !=null && titlelike !="") {
			 sql2.append("and v.video_title like '%'"+titlelike+"'%'");
		}
		
		 System.out.println("dsgfhm---"+sql2);
		List<Video> li	=session.createQuery(sql2.toString()).list();
		
		System.out.println(li);
		System.out.println("wai");
		for (Video video : li) {
			System.out.println("xfbhfj");
			System.out.println(video);
		}
		page.setRows(li);

		return page;
		
	}
//Speaker列表
	@Override
	public Page loadPageppp(int currentPage, String speaker_name,String speaker_job) {

		//page对象
		Page<Speaker> page=new Page<>();
		//放入当前页
		page.setPage(currentPage);
		//查询共多少条
		StringBuffer sql2= new StringBuffer();
		String hql="select count(1) from Speaker where 1=1";
		sql2.append(hql);
		 if (speaker_name !=null && !("").equals(speaker_name)) {
		
			 sql2.append("and  speaker_name like '%"+speaker_name+"%'");
		}
		 if (speaker_job !=null && !("").equals(speaker_job)) {
	
			 sql2.append("and speaker_job like '%"+speaker_job+"%'");
		}
		 
		 Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Number n=(Number) session.createQuery(sql2.toString()).uniqueResult();
		 page.setTotal(n.intValue());
		 //规定分页一次十条
			page.setSize(10);
			//从当前页的条数查询十条
			StringBuffer sql3= new StringBuffer();
			String hql1="from Speaker where 1=1";
			sql3.append(hql1);
			 if (speaker_name !=null && !("").equals(speaker_name)) {
				
				 sql3.append("and   speaker_name like '%"+speaker_name+"%'");
			}
			 if (speaker_job !=null && !("").equals(speaker_job)) {
				
				 sql3.append("and  speaker_job like '%"+speaker_job+"%'");
			}
			int	currentPage1 =(currentPage-1)*10;
		List<Speaker> li=	 session.createQuery(sql3.toString()).setFirstResult(currentPage1).setMaxResults(10).list();
		//将查到的十条放入page对象
		page.setRows(li);
		
		return page;
	}
//videoList
	@Override
	public Page loadPageVppp(String titlelike, String speakid, String courseid, int currentPage) {
		//page对象
		Page<Video> page=new Page<>();
		//放入当前页
		page.setPage(currentPage);
		//查询共多少条
		StringBuffer sql2= new StringBuffer();
		String hql="select count(1) from Video  where 1=1";
		sql2.append(hql);
		 if (speakid !=null && !("").equals(speakid)) {
			 System.out.println("speakid:"+speakid);
			 sql2.append("and  speaker_id="+speakid+"");
		}
		 if (courseid !=null && !("").equals(courseid)) {
			 System.out.println("courseid:"+courseid);
			 sql2.append("and  course_id ="+courseid+"");
		}
		 if (titlelike !=null && !("").equals(titlelike)) {
			 System.out.println("titlelike:"+titlelike);
			 sql2.append("and video_title like '%"+titlelike+"%'");
		}
		
		 Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Number n=(Number) session.createQuery(sql2.toString()).uniqueResult();
		 page.setTotal(n.intValue());
		 //规定分页一次十条
			page.setSize(10);
			//从当前页的条数查询十条
			int	currentPage1 =(currentPage-1)*10;
		
			
			StringBuffer sql3= new StringBuffer();
			String hql3="from Video  where 1=1";
			sql3.append(hql3);
			 if (speakid !=null && !("").equals(speakid)) {
				 System.out.println("speakid:"+speakid);
				 sql3.append("and  speaker_id="+speakid+"");
			}
			 if (courseid !=null && !("").equals(courseid)) {
				 System.out.println("courseid:"+courseid);
				 sql3.append("and  course_id ="+courseid+"");
			}
			 if (titlelike !=null && !("").equals(titlelike)) {
				 System.out.println("titlelike:"+titlelike);
				 sql3.append("and video_title like '%"+titlelike+"%'");
			}
			
			
			
			List<Video> li=	 session.createQuery(sql3.toString()).setFirstResult(currentPage1).setMaxResults(10).list();
		//将查到的十条放入page对象
		page.setRows(li);
		
		return page;
	}

	@Override
	public void addVideo(Video v) {
		
		getHibernateTemplate().save(v);
		
		
	}

	@Override
	public Video findVideo(Integer vid) {
		 Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		 Query query = session.createQuery("from Video where id=?");
		query.setParameter(0, vid);
		Video video=(Video) query.uniqueResult();
		return video;
	}

	@Override
	public void editVideo(Video v) {
		 getHibernateTemplate().update(v);
		
	}

	@Override
	public int deleVideo(Integer vid) {	
		Video video=(Video)this.getHibernateTemplate().get(Video.class,vid);
		System.out.println(video);
        getHibernateTemplate().delete(video);
		return 0;
	}

	@Override
	public void deleAVideo(List<Integer> deleVideo) {
	    List list = new ArrayList();
	    
		for (Integer integer : deleVideo) {
		Video v=(Video) getHibernateTemplate().get(Video.class,integer);
		
		list.add(v);	
		}
		
		getHibernateTemplate().deleteAll(list);
	}
/*
 *addSpeaker
 */
	@Override
	public void addSpeaker(Speaker s) {
		getHibernateTemplate().save(s);
		
	}
/*
 * findOneSpeaker(edit)
 */
	@Override
	public List<Speaker> findOneSpeaker(int sid) {
		List<Speaker> find = (List<Speaker>) getHibernateTemplate().find("from Speaker where id=?", sid);
		return find;
	}

	@Override
	public void editSpeaker(Speaker s) {
		Speaker speaker = getHibernateTemplate().get(Speaker.class, s.getId());
		speaker.setSpeaker_descr(s.getSpeaker_descr());
		speaker.setSpeaker_head_url(s.getSpeaker_head_url());
		speaker.setSpeaker_job(s.getSpeaker_job());
		speaker.setSpeaker_name(s.getSpeaker_name());

		speaker.setUpdate_time(new Date(System.currentTimeMillis()));
		
		getHibernateTemplate().update(speaker);
		

	}
/*
 * 删除one speaker
 */
	@Override
	public void deleOneSpeaker(int sid) {
		Speaker speaker = getHibernateTemplate().get(Speaker.class, sid);
		getHibernateTemplate().delete(speaker);
	}
}
