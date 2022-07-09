package com.projectdemo.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
//import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import org.springframework.data.annotation.Id;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Comments {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int commentid;
	private int postid;
	private String comment;
	private int uuid;
	
	public Comments(int commentid, int postid, String comment, int uuid) {
		super();
		this.commentid = commentid;
		this.postid = postid;
		this.comment = comment;
		this.uuid = uuid;
	}
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	
	
}
