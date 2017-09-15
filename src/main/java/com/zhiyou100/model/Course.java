package com.zhiyou100.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Course {

	 private	 int id;
	 //∂‡∂‘“ªsubject
	 private	 Subject subject;
	 private 	String course_name ;
	 private	 String course_descr;
	 private	 Date insert_time;
	 private	 Date  update_time;
	 private Set<Video> setVideo=new HashSet<>();
	 
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_descr() {
		return course_descr;
	}
	public void setCourse_descr(String course_descr) {
		this.course_descr = course_descr;
	}
	public Date getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(Date insert_time) {
		this.insert_time = insert_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Set<Video> getSetVideo() {
		return setVideo;
	}
	public void setSetVideo(Set<Video> setVideo) {
		this.setVideo = setVideo;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", subject=" + subject + ", course_name=" + course_name + ", course_descr="
				+ course_descr + ", insert_time=" + insert_time + ", update_time=" + update_time + "]";
	}
	
	
	
	
	 
	
	
	
	 
	 
}
