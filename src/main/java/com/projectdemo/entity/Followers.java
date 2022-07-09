package com.projectdemo.entity;

import java.util.UUID;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Followers{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int following;
	private String usern;
	private String fusername;
	public int getFollowing() {
		return following;
	}
	public void setFollowing(int following) {
		this.following = following;
	}
	public String getUsern() {
		return usern;
	}
	public void setUsern(String usern) {
		this.usern = usern;
	}
	public String getFusername() {
		return fusername;
	}
	public void setFusername(String fusername) {
		this.fusername = fusername;
	}
	public Followers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Followers(int following, String usern, String fusername) {
		super();
		this.following = following;
		this.usern = usern;
		this.fusername = fusername;
	}
	
	
}
