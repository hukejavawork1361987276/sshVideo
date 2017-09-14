package com.zhiyou100.model;

import java.util.HashSet;
import java.util.Set;

public class Subject {
	private int id;
	private String subject_name;
	
	 private Set<Course> setCourse=new HashSet<>();
	 
	public Set<Course> getSetCourse() {
		return setCourse;
	}
	public void setSetCourse(Set<Course> setCourse) {
		this.setCourse = setCourse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", subject_name=" + subject_name + ", setCourse=" + setCourse + "]";
	}
	
	
	
	
}
