package com.projectdemo.entity;

public class FeedPosts {
	private User userdetails;
	private Posts posts;
	public User getUserdetails() {
		return userdetails;
	}
	public void setUserdetails(User userdetails) {
		this.userdetails = userdetails;
	}
	public Posts getPosts() {
		return posts;
	}
	public void setPosts(Posts posts) {
		this.posts = posts;
	}
	public FeedPosts(User userdetails, Posts posts) {
		super();
		this.userdetails = userdetails;
		this.posts = posts;
	}
	public FeedPosts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
