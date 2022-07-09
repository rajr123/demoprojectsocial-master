package com.projectdemo.entity;

import java.security.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Posts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postid;
	private String user;
	private String postdata;
	private Instant date;
	private String caption;
	
	
	public Posts(int postid, String user, String postdata, Instant date, String caption) {
		super();
		this.postid = postid;
		this.user = user;
		this.postdata = postdata;
		this.date = date;
		this.caption = caption;
	}


	public int getPostid() {
		return postid;
	}


	public void setPostid(int postid) {
		this.postid = postid;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPostdata() {
		return postdata;
	}


	public void setPostdata(String postdata) {
		this.postdata = postdata;
	}


	public Instant getDate() {
		return date;
	}


	public void setDate(Instant date) {
		this.date = date;
	}


	public String getCaption() {
		return caption;
	}


	public void setCaption(String caption) {
		this.caption = caption;
	}


	public Posts() {}
	
	
}
