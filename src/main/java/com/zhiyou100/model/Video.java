package com.zhiyou100.model;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

public class Video {
	
	private int id;
	private	Speaker speaker;
	private	Course course_id ;
	private	int video_play_times;
	private	String video_title;
	private	String video_image_url;
	private	String video_url ;
	private	String video_descr;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private	Timestamp  insert_time;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private	Timestamp update_time ;
	//private	Date update_time ;
	private int video_length;
	private String video_lengthStr;
	
	
	
	
	
	
	public String getVideo_lengthStr() {
		return video_lengthStr;
	}
	public void setVideo_lengthStr(String video_lengthStr) {
		this.video_lengthStr = video_lengthStr;
	}
	
	
	
	
	
	


	public int getVideo_length() {
		return video_length;
	}
	public void setVideo_length(int video_length) {
		this.video_length = video_length;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public Course getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Course course_id) {
		this.course_id = course_id;
	}
	public int getVideo_play_times() {
		return video_play_times;
	}
	public void setVideo_play_times(int video_play_times) {
		this.video_play_times = video_play_times;
	}
	public String getVideo_title() {
		return video_title;
	}
	public void setVideo_title(String video_title) {
		this.video_title = video_title;
	}
	public String getVideo_image_url() {
		return video_image_url;
	}
	public void setVideo_image_url(String video_image_url) {
		this.video_image_url = video_image_url;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	public String getVideo_descr() {
		return video_descr;
	}
	public void setVideo_descr(String video_descr) {
		this.video_descr = video_descr;
	}
	
	public Timestamp getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(Timestamp insert_time) {
		this.insert_time = insert_time;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	@Override
	public String toString() {
		return "Video [id=" + id + ", video_play_times=" + video_play_times + ", video_title=" + video_title
				+ ", video_image_url=" + video_image_url + ", video_url=" + video_url + ", video_descr=" + video_descr
				+ ", insert_time=" + insert_time + ", update_time=" + update_time + ", video_length=" + video_length
				+ ", video_lengthStr=" + video_lengthStr + "]";
	}
	
	
	
	
	
	}
	
	
	
	
	
	

