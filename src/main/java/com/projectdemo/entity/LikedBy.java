package com.projectdemo.entity;

import javax.persistence.CascadeType;
//import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class LikedBy {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int likeid;
	private int postid;
	private int id;
	public int getLikeid() {
		return likeid;
	}
	public void setLikeid(int likeid) {
		this.likeid = likeid;
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LikedBy(int likeid, int postid, int id) {
		super();
		this.likeid = likeid;
		this.postid = postid;
		this.id = id;
	}
	public LikedBy() {}
	
}
