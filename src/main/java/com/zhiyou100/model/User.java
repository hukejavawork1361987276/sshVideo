package com.zhiyou100.model;

import java.sql.Date;
import java.sql.Timestamp;

public class User {

	private int id;
	private String nick_name;
	private int sex;
	private Date birthday;
	private String email;
	private String province;
	private String city;
	private String head_url;
	private String password;
	private Timestamp insert_time;
	private Timestamp update_time;
	private String captcha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHead_url() {
		return head_url;
	}
	public void setHead_url(String head_url) {
		this.head_url = head_url;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nick_name=" + nick_name + ", sex=" + sex + ", birthday=" + birthday + ", email="
				+ email + ", province=" + province + ", city=" + city + ", head_url=" + head_url + ", password="
				+ password + ", insert_time=" + insert_time + ", update_time=" + update_time + ", captcha=" + captcha
				+ "]";
	}
	
	
	
}
