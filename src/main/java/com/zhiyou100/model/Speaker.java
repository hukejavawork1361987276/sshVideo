package com.zhiyou100.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Speaker {

	
	 private	 int id;
	 private	 String speaker_name;
	 private	 String speaker_job;
	 private	 String speaker_head_url;
	 private	 String speaker_descr ;
	 private	 Date	insert_time;
	 private	 Date   update_time;
	 private Set<Video> setVideo=new HashSet<>();
	 
	public Set<Video> getSetVideo() {
		return setVideo;
	}
	public void setSetVideo(Set<Video> setVideo) {
		this.setVideo = setVideo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpeaker_name() {
		return speaker_name;
	}
	public void setSpeaker_name(String speaker_name) {
		this.speaker_name = speaker_name;
	}
	public String getSpeaker_job() {
		return speaker_job;
	}
	public void setSpeaker_job(String speaker_job) {
		this.speaker_job = speaker_job;
	}
	public String getSpeaker_head_url() {
		return speaker_head_url;
	}
	public void setSpeaker_head_url(String speaker_head_url) {
		this.speaker_head_url = speaker_head_url;
	}
	public String getSpeaker_descr() {
		return speaker_descr;
	}
	public void setSpeaker_descr(String speaker_descr) {
		this.speaker_descr = speaker_descr;
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
	@Override
	public String toString() {
		return "Speaker [id=" + id + ", speaker_name=" + speaker_name + ", speaker_job=" + speaker_job
				+ ", speaker_head_url=" + speaker_head_url + ", speaker_descr=" + speaker_descr + ", insert_time="
				+ insert_time + ", update_time=" + update_time + ", setVideo=" + setVideo + "]";
	}
	
	
	
	 
	 
}
